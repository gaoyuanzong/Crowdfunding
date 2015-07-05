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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfDiscount/cfDiscount.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfDiscount_form" name="crowdfunding_cfDiscount_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>userId：</label>
				   <input id="cfDiscountCondition.userId" name="cfDiscountCondition.userId" value="${cfDiscountCondition.userId}" />
				   <label>discountKind：</label>
				   <input id="cfDiscountCondition.discountKind" name="cfDiscountCondition.discountKind" value="${cfDiscountCondition.discountKind}" />
				   <label>parValue：</label>
				   <input id="cfDiscountCondition.parValue" name="cfDiscountCondition.parValue" value="${cfDiscountCondition.parValue}" />
				   <label>state：</label>
				   <input id="cfDiscountCondition.state" name="cfDiscountCondition.state" value="${cfDiscountCondition.state}" />
				   <label>integralTime：</label>
				   <input id="cfDiscountCondition.integralTime" name="cfDiscountCondition.integralTime" value="${cfDiscountCondition.integralTime}" />
				   <label>overdueTime：</label>
				   <input id="cfDiscountCondition.overdueTime" name="cfDiscountCondition.overdueTime" value="${cfDiscountCondition.overdueTime}" />
				   <label>useRole：</label>
				   <input id="cfDiscountCondition.useRole" name="cfDiscountCondition.useRole" value="${cfDiscountCondition.useRole}" />
				   <label>remark：</label>
				   <input id="cfDiscountCondition.remark" name="cfDiscountCondition.remark" value="${cfDiscountCondition.remark}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfDiscount_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfDiscount_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfDiscount_grid" class="grid">
    </div>
</body>
</html>