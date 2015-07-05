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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfReaddress/cfReaddress.js"></script>
	<script type="text/javascript">
		function cfReaddress_edit_submit(dialog){
			$("#crowdfunding_cfReaddress_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfReaddress_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_cfReaddress_edit_form",
						basePath+"admin/crowdfunding/cfReaddress!doEdit.action",
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
 	<form id="crowdfunding_cfReaddress_edit_form" name="crowdfunding_cfReaddress_edit_form" class="l-form" method="post">
	 <input type="hidden" name="cfReaddress.id" value="${cfReaddress.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>userId：</label>
			  	    <input type="text" name="cfReaddress.userId" value="${cfReaddress.userId}" class="input-text " />
					<!-- <font color="red">userId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>receivesName：</label>
			  	    <input type="text" name="cfReaddress.receivesName" value="${cfReaddress.receivesName}" class="input-text " />
					<!-- <font color="red">receivesName提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>receivesCity：</label>
			  	    <input type="text" name="cfReaddress.receivesCity" value="${cfReaddress.receivesCity}" class="input-text " />
					<!-- <font color="red">receivesCity提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>receivesDetail：</label>
			  	    <input type="text" name="cfReaddress.receivesDetail" value="${cfReaddress.receivesDetail}" class="input-text " />
					<!-- <font color="red">receivesDetail提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>receivesCode：</label>
			  	    <input type="text" name="cfReaddress.receivesCode" value="${cfReaddress.receivesCode}" class="input-text " />
					<!-- <font color="red">receivesCode提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>mobile：</label>
			  	    <input type="text" name="cfReaddress.mobile" value="${cfReaddress.mobile}" class="input-text mobile " />
					<!-- <font color="red">mobile提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>isDefault：</label>
			  	    <input type="text" name="cfReaddress.isDefault" value="${cfReaddress.isDefault}" class="input-text digits " />
					<!-- <font color="red">isDefault提示</font> -->
				</li>
	    	</ul>
	    </div>
    </form>
</body>
</html>