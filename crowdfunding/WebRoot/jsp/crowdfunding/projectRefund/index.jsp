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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectRefund/projectRefund.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_projectRefund_form" name="crowdfunding_projectRefund_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>退款人：</label>
				   <input id="projectRefundCondition.userId" name="projectRefundCondition.userId" value="${projectRefundCondition.userId}" />
				   <label>项目ID：</label>
				   <input id="projectRefundCondition.projectId" name="projectRefundCondition.projectId" value="${projectRefundCondition.projectId}" />
				   <label>认购单ID：</label>
				   <input id="projectRefundCondition.subscribeId" name="projectRefundCondition.subscribeId" value="${projectRefundCondition.subscribeId}" />
				   <label>支付订单号：</label>
				   <input id="projectRefundCondition.orderId" name="projectRefundCondition.orderId" value="${projectRefundCondition.orderId}" />
				   <label>退款金额：</label>
				   <input id="projectRefundCondition.refundAmount" name="projectRefundCondition.refundAmount" value="${projectRefundCondition.refundAmount}" />
				   <label>退款状态：</label>
				   <input id="projectRefundCondition.refundStatus" name="projectRefundCondition.refundStatus" value="${projectRefundCondition.refundStatus}" />
				   <label>审核状态：</label>
				   <input id="projectRefundCondition.checkStatus" name="projectRefundCondition.checkStatus" value="${projectRefundCondition.checkStatus}" />
				   <label>退款订单号：</label>
				   <input id="projectRefundCondition.refundOrderId" name="projectRefundCondition.refundOrderId" value="${projectRefundCondition.refundOrderId}" />
				   <label>退款时间：</label>
				   <input id="projectRefundCondition.refundTime" name="projectRefundCondition.refundTime" value="${projectRefundCondition.refundTime}" />
				   <label>创建时间：</label>
				   <input id="projectRefundCondition.createTime" name="projectRefundCondition.createTime" value="${projectRefundCondition.createTime}" />
				   <label>更新时间：</label>
				   <input id="projectRefundCondition.updateTime" name="projectRefundCondition.updateTime" value="${projectRefundCondition.updateTime}" />
				   <label>交易单号：</label>
				   <input id="projectRefundCondition.transactionId" name="projectRefundCondition.transactionId" value="${projectRefundCondition.transactionId}" />
				   <label>退款类型：0整单退1部分退：</label>
				   <input id="projectRefundCondition.refundType" name="projectRefundCondition.refundType" value="${projectRefundCondition.refundType}" />
				   <label>退款描述：</label>
				   <input id="projectRefundCondition.refundDesc" name="projectRefundCondition.refundDesc" value="${projectRefundCondition.refundDesc}" />
				   <label>佣金状态：是否已经收取佣金 10 未收；20，已收（只有跳票项目的退款单这个字段才有对应值）：</label>
				   <input id="projectRefundCondition.commissionStatus" name="projectRefundCondition.commissionStatus" value="${projectRefundCondition.commissionStatus}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="projectRefund_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_projectRefund_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_projectRefund_grid" class="grid">
    </div>
</body>
</html>