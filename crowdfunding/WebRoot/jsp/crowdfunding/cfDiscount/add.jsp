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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfDiscount/cfDiscount.js"></script>
	<script type="text/javascript">
		function cfDiscount_add_submit(dialog){
			$("#crowdfunding_cfDiscount_add_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfDiscount_add_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
							"#crowdfunding_cfDiscount_add_form",
							basePath+"admin/crowdfunding/cfDiscount!doAdd.action",
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
 	<form id="crowdfunding_cfDiscount_add_form" name="crowdfunding_cfDiscount_add_form" class="l-form" method="post">
	 <input type="hidden" name="cfDiscount.id" value="${cfDiscount.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>userId：</label>
			  	    <input type="text" name="cfDiscount.userId" value="${cfDiscount.userId}" class="input-text " />
					<!-- <font color="red">userId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>discountKind：</label>
			  	    <input type="text" name="cfDiscount.discountKind" value="${cfDiscount.discountKind}" class="input-text " />
					<!-- <font color="red">discountKind提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>parValue：</label>
			  	    <input type="text" name="cfDiscount.parValue" value="${cfDiscount.parValue}" class="input-text " />
					<!-- <font color="red">parValue提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>state：</label>
			  	    <input type="text" name="cfDiscount.state" value="${cfDiscount.state}" class="input-text digits " />
					<!-- <font color="red">state提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>integralTime：</label>
			  	    <input type="text" name="cfDiscount.integralTime" value="${cfDiscount.integralTime}" class="input-text " />
					<!-- <font color="red">integralTime提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>overdueTime：</label>
			  	    <input type="text" name="cfDiscount.overdueTime" value="${cfDiscount.overdueTime}" class="input-text " />
					<!-- <font color="red">overdueTime提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>useRole：</label>
			  	    <input type="text" name="cfDiscount.useRole" value="${cfDiscount.useRole}" class="input-text " />
					<!-- <font color="red">useRole提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>remark：</label>
			  	    <input type="text" name="cfDiscount.remark" value="${cfDiscount.remark}" class="input-text " />
					<!-- <font color="red">remark提示</font> -->
				</li>
	    	</ul>
	    </div>
		<!--
		<div style="margin-top:10px;margin-bottom:15px;">
			<a class="l-button" onclick="cfDiscount_add_submit()">提交</a>
			<a class="l-button" onclick="$("#crowdfunding_cfDiscount_add_form").reset()">重置</a>
		</div>
		-->
    </form>
</body>
</html>