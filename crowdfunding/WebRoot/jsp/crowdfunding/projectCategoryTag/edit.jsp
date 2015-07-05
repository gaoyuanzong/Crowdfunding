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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectCategoryTag/projectCategoryTag.js"></script>
	<script type="text/javascript">
		function projectCategoryTag_edit_submit(dialog){
			$("#crowdfunding_projectCategoryTag_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_projectCategoryTag_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_projectCategoryTag_edit_form",
						basePath+"admin/crowdfunding/projectCategoryTag!doEdit.action",
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
 	<form id="crowdfunding_projectCategoryTag_edit_form" name="crowdfunding_projectCategoryTag_edit_form" class="l-form" method="post">
	 <input type="hidden" name="projectCategoryTag.id" value="${projectCategoryTag.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>名称：</label>
			  	    <input type="text" name="projectCategoryTag.name" value="${projectCategoryTag.name}" class="required : true" />
			  	    <input type="hidden" name="projectCategoryTag.type" value=0 class="input-text digits " />
					<!-- <font color="red">名称提示</font> -->
				</li>
	    	</ul>
	    	<%--<ul>
	    		<li>
	    			<label><font color="red">*</font>0-分类 1-标签：</label>
			  	    <input type="text" name="projectCategoryTag.type" value="${projectCategoryTag.type}" class="input-text digits " />
					<!-- <font color="red">0-分类 1-标签提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>创建时间：</label>
			  	    <input type="text" name="projectCategoryTag.createdTime" value="${projectCategoryTag.createdTime}" class="input-text " />
					<!-- <font color="red">创建时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>修改时间：</label>
			  	    <input type="text" name="projectCategoryTag.modifiedTime" value="${projectCategoryTag.modifiedTime}" class="input-text " />
					<!-- <font color="red">修改时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>排序：</label>
			  	    <input type="text" name="projectCategoryTag.sortId" value="${projectCategoryTag.sortId}" class="input-text digits " />
					<!-- <font color="red">排序提示</font> -->
				</li>
	    	</ul>
	    --%></div>
    </form>
</body>
</html>