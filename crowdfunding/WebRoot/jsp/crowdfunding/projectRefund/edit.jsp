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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectRefund/projectRefund.js"></script>
	<script type="text/javascript">
		function projectRefund_edit_submit(dialog){
			$("#crowdfunding_projectRefund_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_projectRefund_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_projectRefund_edit_form",
						basePath+"admin/crowdfunding/projectRefund!doEdit.action",
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
 	<form id="crowdfunding_projectRefund_edit_form" name="crowdfunding_projectRefund_edit_form" class="l-form" method="post">
	 <input type="hidden" name="projectRefund.id" value="${projectRefund.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>退款人：</label>
			  	    <input type="text" name="projectRefund.userId" value="${projectRefund.userId}" class="input-text " />
					<!-- <font color="red">退款人提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目ID：</label>
			  	    <input type="text" name="projectRefund.projectId" value="${projectRefund.projectId}" class="input-text digits " />
					<!-- <font color="red">项目ID提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>认购单ID：</label>
			  	    <input type="text" name="projectRefund.subscribeId" value="${projectRefund.subscribeId}" class="input-text digits " />
					<!-- <font color="red">认购单ID提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>支付订单号：</label>
			  	    <input type="text" name="projectRefund.orderId" value="${projectRefund.orderId}" class="input-text " />
					<!-- <font color="red">支付订单号提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>退款金额：</label>
			  	    <input type="text" name="projectRefund.refundAmount" value="${projectRefund.refundAmount}" class="input-text digits " />
					<!-- <font color="red">退款金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>退款状态：</label>
			  	    <input type="text" name="projectRefund.refundStatus" value="${projectRefund.refundStatus}" class="input-text digits " />
					<!-- <font color="red">退款状态提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>审核状态：</label>
			  	    <input type="text" name="projectRefund.checkStatus" value="${projectRefund.checkStatus}" class="input-text digits " />
					<!-- <font color="red">审核状态提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>退款订单号：</label>
			  	    <input type="text" name="projectRefund.refundOrderId" value="${projectRefund.refundOrderId}" class="input-text " />
					<!-- <font color="red">退款订单号提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>退款时间：</label>
			  	    <input type="text" name="projectRefund.refundTime" value="${projectRefund.refundTime}" class="input-text " />
					<!-- <font color="red">退款时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>创建时间：</label>
			  	    <input type="text" name="projectRefund.createTime" value="${projectRefund.createTime}" class="input-text " />
					<!-- <font color="red">创建时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>更新时间：</label>
			  	    <input type="text" name="projectRefund.updateTime" value="${projectRefund.updateTime}" class="input-text " />
					<!-- <font color="red">更新时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>交易单号：</label>
			  	    <input type="text" name="projectRefund.transactionId" value="${projectRefund.transactionId}" class="input-text " />
					<!-- <font color="red">交易单号提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>退款类型：0整单退1部分退：</label>
			  	    <input type="text" name="projectRefund.refundType" value="${projectRefund.refundType}" class="input-text digits " />
					<!-- <font color="red">退款类型：0整单退1部分退提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>退款描述：</label>
			  	    <input type="text" name="projectRefund.refundDesc" value="${projectRefund.refundDesc}" class="input-text " />
					<!-- <font color="red">退款描述提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>佣金状态：是否已经收取佣金 10 未收；20，已收（只有跳票项目的退款单这个字段才有对应值）：</label>
			  	    <input type="text" name="projectRefund.commissionStatus" value="${projectRefund.commissionStatus}" class="input-text digits " />
					<!-- <font color="red">佣金状态：是否已经收取佣金 10 未收；20，已收（只有跳票项目的退款单这个字段才有对应值）提示</font> -->
				</li>
	    	</ul>
	    </div>
    </form>
</body>
</html>