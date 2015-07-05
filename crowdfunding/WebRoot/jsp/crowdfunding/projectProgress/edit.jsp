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
	<link href="${basePath}jsp/crowdfunding/common/crowdfunding.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/common/common.js"></script>
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectProgress/projectProgress.js"></script>
	<script type="text/javascript">
		function projectProgress_edit_submit(dialog){
			$("#crowdfunding_projectProgress_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_projectProgress_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_projectProgress_edit_form",
						basePath+"admin/crowdfunding/projectProgress!doEdit.action",
						function(json){
							if(json.success){
								home_fresh();
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
		});
	</script>
</head>
<body>
 	<form id="crowdfunding_projectProgress_edit_form" name="crowdfunding_projectProgress_edit_form" class="l-form" method="post">
	 <input type="hidden" name="projectProgress.id" value="${projectProgress.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目发起人：</label>
			  	    <input type="text" name="projectProgress.userId" value="${projectProgress.userId}" class="input-text " />
					<!-- <font color="red">项目发起人提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目ID：</label>
			  	    <input type="text" name="projectProgress.projectId" value="${projectProgress.projectId}" class="input-text digits " />
					<!-- <font color="red">项目ID提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目名称：</label>
			  	    <input type="text" name="projectProgress.projectName" value="${projectProgress.projectName}" class="input-text " />
					<!-- <font color="red">项目名称提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>进度内容：</label>
			  	    <input type="text" name="projectProgress.progressContent" value="${projectProgress.progressContent}" class="input-text " />
					<!-- <font color="red">进度内容提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>图片：</label>
			  	    <input type="text" name="projectProgress.progressImage" value="${projectProgress.progressImage}" class="input-text " />
					<!-- <font color="red">图片提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>创建时间：</label>
			  	    <input type="text" name="projectProgress.createTime" value="${projectProgress.createTime}" class="input-text " />
					<!-- <font color="red">创建时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>缩略图：</label>
			  	    <input type="text" name="projectProgress.progressThumImage" value="${projectProgress.progressThumImage}" class="input-text " />
					<!-- <font color="red">缩略图提示</font> -->
				</li>
	    	</ul>
	    </div>
    </form>
</body>
</html>