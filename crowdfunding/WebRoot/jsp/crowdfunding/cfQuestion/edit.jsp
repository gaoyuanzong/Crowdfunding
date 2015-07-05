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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfQuestion/cfQuestion.js"></script>
	<script type="text/javascript">
		function cfQuestion_edit_submit(dialog){
			$("#crowdfunding_cfQuestion_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfQuestion_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_cfQuestion_edit_form",
						basePath+"admin/crowdfunding/cfQuestion!doEdit.action",
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
 	<form id="crowdfunding_cfQuestion_edit_form" name="crowdfunding_cfQuestion_edit_form" class="l-form" method="post">
	 <input type="hidden" name="cfQuestion.id" value="${cfQuestion.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>userId：</label>
			  	    <input type="text" name="cfQuestion.userId" value="${cfQuestion.userId}" class="input-text " />
					<!-- <font color="red">userId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>questionId：</label>
			  	    <input type="text" name="cfQuestion.questionId" value="${cfQuestion.questionId}" class="input-text " />
					<!-- <font color="red">questionId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>answer：</label>
			  	    <input type="text" name="cfQuestion.answer" value="${cfQuestion.answer}" class="input-text " />
					<!-- <font color="red">answer提示</font> -->
				</li>
	    	</ul>
	    </div>
    </form>
</body>
</html>