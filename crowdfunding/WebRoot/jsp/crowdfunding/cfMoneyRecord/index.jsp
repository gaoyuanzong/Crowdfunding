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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfMoneyRecord/cfMoneyRecord.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfMoneyRecord_form" name="crowdfunding_cfMoneyRecord_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>userId：</label>
				   <input id="cfMoneyRecordCondition.userId" name="cfMoneyRecordCondition.userId" value="${cfMoneyRecordCondition.userId}" />
				   <label>recordKind：</label>
				   <input id="cfMoneyRecordCondition.recordKind" name="cfMoneyRecordCondition.recordKind" value="${cfMoneyRecordCondition.recordKind}" />
				   <label>recordState：</label>
				   <input id="cfMoneyRecordCondition.recordState" name="cfMoneyRecordCondition.recordState" value="${cfMoneyRecordCondition.recordState}" />
				   <label>description：</label>
				   <input id="cfMoneyRecordCondition.description" name="cfMoneyRecordCondition.description" value="${cfMoneyRecordCondition.description}" />
				   <label>createTime：</label>
				   <input id="cfMoneyRecordCondition.createTime" name="cfMoneyRecordCondition.createTime" value="${cfMoneyRecordCondition.createTime}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfMoneyRecord_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfMoneyRecord_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfMoneyRecord_grid" class="grid">
    </div>
</body>
</html>