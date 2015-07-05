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
		function project_pass_submit(dialog){
			$("#crowdfunding_project_pass_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_project_pass_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_project_pass_form",
						basePath+"admin/crowdfunding/project!doPass.action",
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
 	<form id="crowdfunding_project_pass_form" name="crowdfunding_project_pass_form" class="l-form" method="post">
	 <input type="hidden" name="project.id" value="${project.id}"/>
	    <div class="content">
			<ul>
	    		<li>
	    			<label><font color="red">*</font><h4>确认项目通过审核</h4>
					请输入项目所收取的收费比例，目前</br>
					系统默认收取0%：</label></br>
			  	    收费比例<input type="text" name="project.rate" value="0" class="required"/>%
				</li>
	    	</ul>
	    	
	    </div>
    </form>
</body>
</html>