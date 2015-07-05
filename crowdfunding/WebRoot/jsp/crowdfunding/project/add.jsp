<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/inc/meta.inc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<%@ include file="/jsp/inc/head.inc" %>
	<script type="text/javascript">
		basePath = "${basePath}";
	</script>
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/common/common.js"></script>
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/project/project.js"></script>
	<script type="text/javascript" charset="utf-8" src="${basePath}ckeditor/ckeditor.js"></script>
	<!-- 文件的上传处理 -->
	<script type="text/javascript" src="${basePath }swfupload/jquery.swfupload.js"></script>
	<script type="text/javascript" src="${basePath }swfupload/swfupload.js"></script>
	<!-- 地区处理 -->
	<script src="${basePath }js/area/Area.js" type="text/javascript"></script>
    <script src="${basePath }js/area/AreaData_min.js" type="text/javascript"></script>
	<script type="text/javascript">
		function project_add_submit(dialog){
			 for (instance in CKEDITOR.instances){
                CKEDITOR.instances[instance].updateElement();
            }
			$("#crowdfunding_project_add_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_project_add_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
							"#crowdfunding_project_add_form",
							basePath+"admin/crowdfunding/project!doAdd.action",
							function(json){
								if(json.success){
									window.location.href=basePath+"admin/crowdfunding/project!index.action";
								}else{
									alert(json.message,"error");
								}
							}
					);
			 	},
				errorPlacement: function(error, element) {
					error.appendTo(element.parents("li:first"));
				}
			 });
			 
			 $("input[type='text']").width("300px");
			 init();
		});
		function initCkEditor(){
	        CKEDITOR.disableAutoInline = true;
	        CKEDITOR.replace("projectDetails",{
	            width : 615,
	            height : 400
	        });
    	}

	    function init(){
	        initCkEditor();
	        commonUpload("uploadProjectImage",uploadImgPathCall,{
		                file_size_limit: 1024 * 50,//允许上传文件大小
		                file_types: "*.jpg;*.png;*.jpeg;*.gif",//允许上传文件类型
		                uploadFolder: "upload/project",//自定义上传目录 默认 upload
		            });
	         commonUpload("uploadProjectThumImage",uploadThumImagePathCall,{
		                file_size_limit: 1024 * 50,//允许上传文件大小
		                file_types: "*.jpg;*.png;*.jpeg;*.gif",//允许上传文件类型
		                uploadFolder: "upload/project",//自定义上传目录 默认 upload
		            });
					function uploadImgPathCall(event, fileObj, result) {
			                $("#projectImage").val(result.data.file);
			                $("#projectImage_view").attr("src",basePath+result.data.file);
			        }
					function uploadThumImagePathCall(event, fileObj, result) {
			                $("#projectThumImage").val(result.data.file);
			                $("#projectThumImage_view").attr("src",basePath+result.data.file);
			        }
			initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '0', '0', '0');
	    }
	    function selectUser(){
					showDialog({
						title : "选择发起人",
						width : 700, 
						height : 470, 
						name : "crowdfunding_cfUser_grid",
						url:basePath+"admin/crowdfunding/project!toSelectUser.action",
						onok : function(item,dialog){
							dialog.close();
						}
					});
				}
	    function getCfUser(userId,userName){
	    	$("#projectSponsorId").val(userId);
	    	$("#projectSponsorName").val(userName);
	    }
	</script>
	<style type="text/css">
	 .searchUser {
   		 background: url("/image/search.gif") no-repeat scroll 0 -2px transparent;
		}
	</style>
</head>
<body>
 	<form id="crowdfunding_project_add_form" name="crowdfunding_project_add_form" class="l-form" method="post">
	 <input type="hidden" name="project.id" value="${project.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目标签：</label>
	    			<c:forEach items="${tagList}" var="tags">
	    				<c:if test="${tags.type == 0}">
	    					<input type="checkbox" name="projectTags" value="${tags.name}" class="input-checkbox required" />${tags.name}
	    				</c:if>
	    			</c:forEach>
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目名称：</label>
			  	    <input type="text" name="project.projectName" value="${project.projectName}" class="input-text required" />
					<!-- <font color="red">项目名称提示</font> -->
				</li>
				
				<li>
	    			<label><font color="red">*</font>项目类型：</label>
			  	  	 <select name="project.projectType" value="${tags.id}" class="input-select required" >
    					<c:forEach items="${tagList}" var="tags">
	    					<c:if test="${tags.type == 1}">
	    						<option value="${tags.id}">${tags.name}</option>
	    					</c:if>
    					</c:forEach>
   					</select>
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>募集金额：</label>
			  	    <input type="text" name="project.amount" value="${project.amount}" class="input-text digits required" />
					<!-- <font color="red">募集金额提示</font> -->
				</li>
				<li>
	    			<label><font color="red">*</font>募集上限(填0是无上限)：</label>
			  	    <input type="text" name="project.topLimit" value="${project.topLimit}" class="input-text digits required" />% 
					<!-- <font color="red">募集上限提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>募集天数：</label>
			  	    <input type="text"  name="project.ccollectDays" value="${project.ccollectDays}" class="input-text digits required" />
					<!-- <font color="red">募集天数提示</font> -->
				</li>
				<li>
	    			<label><font color="red">*</font>项目发起人：</label>
			  	    <input type="text" id="projectSponsorName" value="${project.projectSponsor}" readonly="readonly" class="input-text" />
			  	    <input type="hidden" id="projectSponsorId" name="project.projectSponsor" value="${project.projectSponsor}" class="input-text required" />
					<a class="searchUser" href="javascript:selectUser();">选择</a>
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目地点：</label>
					<select id="seachprov" name="seachprov" onchange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');" class="input-select required">
				    </select>&nbsp;&nbsp;
				    <select id="seachcity" name="homecity" class="input-select required" onchange="setSelectedValue('seachprov','seachcity','projectAddr')">
				    </select>&nbsp;&nbsp;
			        <select id="seachdistrict" name="seachdistrict" class="input-select" style="display: none">
			        </select>
			        <input type="hidden" id="projectAddr" name="project.projectAddr" value="${project.projectAddr}" class="input-text required required" />
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目图片：</label>
			  	    <input type="hidden" id="projectImage" name="project.projectImage" value="${project.projectImage}" class="input-text required" />
					<input type="button" value="浏览" id="uploadProjectImage">
					<div>
						<img id="projectImage_view" style="width: 293px;height: 219px">
					</div>
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>主页图片：</label>
			  	    <input type="hidden" id="projectThumImage" name="project.projectThumImage" value="${project.projectThumImage}" class="input-text required" />
					 <input type="button" value="浏览" id="uploadProjectThumImage">
					 <div>
						<img id="projectThumImage_view" style="width: 655px;height: 425px">
					</div>
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目简介：</label>
			  	    <textarea name="project.projectSummary" value="${project.projectSummary}" class="input-text required" cols="47"/></textarea>
					<!-- <font color="red">项目简介提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    		
	    			<label><font color="red">*</font>项目详情：</label>
			  	    <input type="text" id="projectDetails" name="project.projectDetails" value="${project.projectDetails}" class="input-text" />
					<!-- <font color="red">项目详情提示</font> -->
				</li>
	    	</ul>
	    </div>
		<div style="margin-top:10px;margin-bottom:15px;">
		<a class="l-button" href="${basePath}admin/crowdfunding/project!index.action">上一步</a>
			<a class="l-button" onclick="project_add_submit()">下一步</a>
		</div>
    </form>
</body>
</html>