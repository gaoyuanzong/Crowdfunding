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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectSubscribe/projectSubscribe.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_projectSubscribe_form" name="crowdfunding_projectSubscribe_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>用户：</label>
				   <input id="projectSubscribeCondition.userId" name="projectSubscribeCondition.userId" value="${projectSubscribeCondition.userId}" />
				   <label>项目ID：</label>
				   <input id="projectSubscribeCondition.projectId" name="projectSubscribeCondition.projectId" value="${projectSubscribeCondition.projectId}" />
				   <label>回报ID：</label>
				   <input id="projectSubscribeCondition.redoundId" name="projectSubscribeCondition.redoundId" value="${projectSubscribeCondition.redoundId}" />
				   <label>收获地址ID：</label>
				   <input id="projectSubscribeCondition.addressId" name="projectSubscribeCondition.addressId" value="${projectSubscribeCondition.addressId}" />
				   <label>认购状态：</label>
				   <input id="projectSubscribeCondition.subscribeStatus" name="projectSubscribeCondition.subscribeStatus" value="${projectSubscribeCondition.subscribeStatus}" />
				   <label>运费：</label>
				   <input id="projectSubscribeCondition.freight" name="projectSubscribeCondition.freight" value="${projectSubscribeCondition.freight}" />
				   <label>支持金额：</label>
				   <input id="projectSubscribeCondition.supportAmount" name="projectSubscribeCondition.supportAmount" value="${projectSubscribeCondition.supportAmount}" />
				   <label>支付金额：</label>
				   <input id="projectSubscribeCondition.payAmount" name="projectSubscribeCondition.payAmount" value="${projectSubscribeCondition.payAmount}" />
				   <label>支付时间：</label>
				   <input id="projectSubscribeCondition.payedTime" name="projectSubscribeCondition.payedTime" value="${projectSubscribeCondition.payedTime}" />
				   <label>是否需要回报：</label>
				   <input id="projectSubscribeCondition.isRedound" name="projectSubscribeCondition.isRedound" value="${projectSubscribeCondition.isRedound}" />
				   <label>订单号：</label>
				   <input id="projectSubscribeCondition.orderId" name="projectSubscribeCondition.orderId" value="${projectSubscribeCondition.orderId}" />
				   <label>创建时间：</label>
				   <input id="projectSubscribeCondition.createTime" name="projectSubscribeCondition.createTime" value="${projectSubscribeCondition.createTime}" />
				   <label>更新时间：</label>
				   <input id="projectSubscribeCondition.ipdateTime" name="projectSubscribeCondition.ipdateTime" value="${projectSubscribeCondition.ipdateTime}" />
				   <label>快递公司：</label>
				   <input id="projectSubscribeCondition.expressCompany" name="projectSubscribeCondition.expressCompany" value="${projectSubscribeCondition.expressCompany}" />
				   <label>运单号：</label>
				   <input id="projectSubscribeCondition.expressNum" name="projectSubscribeCondition.expressNum" value="${projectSubscribeCondition.expressNum}" />
				   <label>备注：</label>
				   <input id="projectSubscribeCondition.remarks" name="projectSubscribeCondition.remarks" value="${projectSubscribeCondition.remarks}" />
				   <label>交易单：</label>
				   <input id="projectSubscribeCondition.transactionId" name="projectSubscribeCondition.transactionId" value="${projectSubscribeCondition.transactionId}" />
				   <label>支付状态：</label>
				   <input id="projectSubscribeCondition.payStatus" name="projectSubscribeCondition.payStatus" value="${projectSubscribeCondition.payStatus}" />
				   <label>email：</label>
				   <input id="projectSubscribeCondition.email" name="projectSubscribeCondition.email" value="${projectSubscribeCondition.email}" />
				   <label>项目标签：</label>
				   <input id="projectSubscribeCondition.projectTag" name="projectSubscribeCondition.projectTag" value="${projectSubscribeCondition.projectTag}" />
				   <label>客服备注：</label>
				   <input id="projectSubscribeCondition.csRemarks" name="projectSubscribeCondition.csRemarks" value="${projectSubscribeCondition.csRemarks}" />
				   <label>0-无需发票；1-需要发票：</label>
				   <input id="projectSubscribeCondition.invoiceFlag" name="projectSubscribeCondition.invoiceFlag" value="${projectSubscribeCondition.invoiceFlag}" />
				   <label>发票标题：</label>
				   <input id="projectSubscribeCondition.invoiceTitle" name="projectSubscribeCondition.invoiceTitle" value="${projectSubscribeCondition.invoiceTitle}" />
				   <label>逻辑删除标志0正常1删除：</label>
				   <input id="projectSubscribeCondition.status" name="projectSubscribeCondition.status" value="${projectSubscribeCondition.status}" />
				   <label>0-未取消，1-单笔退款：</label>
				   <input id="projectSubscribeCondition.cancelTag" name="projectSubscribeCondition.cancelTag" value="${projectSubscribeCondition.cancelTag}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="projectSubscribe_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_projectSubscribe_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_projectSubscribe_grid" class="grid">
    </div>
</body>
</html>