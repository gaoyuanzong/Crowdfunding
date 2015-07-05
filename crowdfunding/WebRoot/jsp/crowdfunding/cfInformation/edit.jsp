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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfInformation/cfInformation.js"></script>
	<script type="text/javascript">
		function cfInformation_edit_submit(dialog){
			$("#crowdfunding_cfInformation_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfInformation_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_cfInformation_edit_form",
						basePath+"admin/crowdfunding/cfInformation!doEdit.action",
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
 	<form id="crowdfunding_cfInformation_edit_form" name="crowdfunding_cfInformation_edit_form" class="l-form" method="post">
	 <input type="hidden" name="cfInformation.id" value="${cfInformation.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>sendUserId：</label>
			  	    <input type="text" name="cfInformation.sendUserId" value="${cfInformation.sendUserId}" class="input-text " />
					<!-- <font color="red">sendUserId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>receiveUserId：</label>
			  	    <input type="text" name="cfInformation.receiveUserId" value="${cfInformation.receiveUserId}" class="input-text " />
					<!-- <font color="red">receiveUserId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>content：</label>
			  	    <input type="text" name="cfInformation.content" value="${cfInformation.content}" class="input-text " />
					<!-- <font color="red">content提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>createTime：</label>
			  	    <input type="text" name="cfInformation.createTime" value="${cfInformation.createTime}" class="input-text " />
					<!-- <font color="red">createTime提示</font> -->
				</li>
	    	</ul>
	    </div>
    </form>
</body>
</html>