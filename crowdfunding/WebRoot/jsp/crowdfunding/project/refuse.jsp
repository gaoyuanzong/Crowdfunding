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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/project/auditProject.js"></script>
	<script type="text/javascript">
		function project_refuse_submit(dialog){
			$("#crowdfunding_project_refuse_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_project_refuse_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_project_refuse_form",
						basePath+"admin/crowdfunding/project!doRefuse.action",
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
 	<form id="crowdfunding_project_refuse_form" name="crowdfunding_project_refuse_form" class="l-form" method="post">
	 <input type="hidden" name="project.id" value="${project.id}"/>
	 <input type="hidden" name="type" value="${type }">
	    <div class="content">
			<ul>
	    		<li>
	    			<label><font color="red">*</font>项目名称：</label>
			  	    <input type="text" name="project.projectName" value="${project.projectName}" class="input-text" readonly="true"/>
					<!-- <font color="red">项目名称提示</font> -->
				</li>
	    	</ul>
	    	
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>说明：</label>
	    			<textarea rows="10" cols="60" name="project.auditReson" class="required"></textarea>
				</li>
	    	</ul>
	    	
	    	
	    </div>
    </form>
</body>
</html>