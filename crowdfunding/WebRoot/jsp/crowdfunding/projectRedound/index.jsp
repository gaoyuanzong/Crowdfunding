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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectRedound/projectRedound.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_projectRedound_form" name="crowdfunding_projectRedound_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>项目ID：</label>
				   <input id="projectRedoundCondition.projectId" name="projectRedoundCondition.projectId" value="${projectRedoundCondition.projectId}" />
				   <label>回报金额：</label>
				   <input id="projectRedoundCondition.amount" name="projectRedoundCondition.amount" value="${projectRedoundCondition.amount}" />
				   <label>回报类型：</label>
				   <input id="projectRedoundCondition.redoundType" name="projectRedoundCondition.redoundType" value="${projectRedoundCondition.redoundType}" />
				   <label>回报内容：</label>
				   <input id="projectRedoundCondition.redoundContent" name="projectRedoundCondition.redoundContent" value="${projectRedoundCondition.redoundContent}" />
				   <label>图片：</label>
				   <input id="projectRedoundCondition.redoundImage" name="projectRedoundCondition.redoundImage" value="${projectRedoundCondition.redoundImage}" />
				   <label>上限：</label>
				   <input id="projectRedoundCondition.limits" name="projectRedoundCondition.limits" value="${projectRedoundCondition.limits}" />
				   <label>运费：</label>
				   <input id="projectRedoundCondition.freight" name="projectRedoundCondition.freight" value="${projectRedoundCondition.freight}" />
				   <label>回报天次：</label>
				   <input id="projectRedoundCondition.redoundDays" name="projectRedoundCondition.redoundDays" value="${projectRedoundCondition.redoundDays}" />
				   <label>0-不可开发票，1-可开发票：</label>
				   <input id="projectRedoundCondition.invoiceStatus" name="projectRedoundCondition.invoiceStatus" value="${projectRedoundCondition.invoiceStatus}" />
				   <label>创建时间：</label>
				   <input id="projectRedoundCondition.createTime" name="projectRedoundCondition.createTime" value="${projectRedoundCondition.createTime}" />
				   <label>更新时间：</label>
				   <input id="projectRedoundCondition.updateTime" name="projectRedoundCondition.updateTime" value="${projectRedoundCondition.updateTime}" />
				   <label>排序：</label>
				   <input id="projectRedoundCondition.ind" name="projectRedoundCondition.ind" value="${projectRedoundCondition.ind}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="projectRedound_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_projectRedound_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_projectRedound_grid" class="grid">
    </div>
</body>
</html>