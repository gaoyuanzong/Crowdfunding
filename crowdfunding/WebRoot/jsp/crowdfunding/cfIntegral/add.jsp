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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfIntegral/cfIntegral.js"></script>
	<script type="text/javascript">
		function cfIntegral_add_submit(dialog){
			$("#crowdfunding_cfIntegral_add_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfIntegral_add_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
							"#crowdfunding_cfIntegral_add_form",
							basePath+"admin/crowdfunding/cfIntegral!doAdd.action",
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
 	<form id="crowdfunding_cfIntegral_add_form" name="crowdfunding_cfIntegral_add_form" class="l-form" method="post">
	 <input type="hidden" name="cfIntegral.id" value="${cfIntegral.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>userId：</label>
			  	    <input type="text" name="cfIntegral.userId" value="${cfIntegral.userId}" class="input-text " />
					<!-- <font color="red">userId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>integralType：</label>
			  	    <input type="text" name="cfIntegral.integralType" value="${cfIntegral.integralType}" class="input-text " />
					<!-- <font color="red">integralType提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>integralDetail：</label>
			  	    <input type="text" name="cfIntegral.integralDetail" value="${cfIntegral.integralDetail}" class="input-text " />
					<!-- <font color="red">integralDetail提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>integralValue：</label>
			  	    <input type="text" name="cfIntegral.integralValue" value="${cfIntegral.integralValue}" class="input-text " />
					<!-- <font color="red">integralValue提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>createTime：</label>
			  	    <input type="text" name="cfIntegral.createTime" value="${cfIntegral.createTime}" class="input-text " />
					<!-- <font color="red">createTime提示</font> -->
				</li>
	    	</ul>
	    </div>
		<!--
		<div style="margin-top:10px;margin-bottom:15px;">
			<a class="l-button" onclick="cfIntegral_add_submit()">提交</a>
			<a class="l-button" onclick="$("#crowdfunding_cfIntegral_add_form").reset()">重置</a>
		</div>
		-->
    </form>
</body>
</html>