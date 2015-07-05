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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfInformation/cfInformation.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfInformation_form" name="crowdfunding_cfInformation_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>sendUserId：</label>
				   <input id="cfInformationCondition.sendUserId" name="cfInformationCondition.sendUserId" value="${cfInformationCondition.sendUserId}" />
				   <label>receiveUserId：</label>
				   <input id="cfInformationCondition.receiveUserId" name="cfInformationCondition.receiveUserId" value="${cfInformationCondition.receiveUserId}" />
				   <label>content：</label>
				   <input id="cfInformationCondition.content" name="cfInformationCondition.content" value="${cfInformationCondition.content}" />
				   <label>createTime：</label>
				   <input id="cfInformationCondition.createTime" name="cfInformationCondition.createTime" value="${cfInformationCondition.createTime}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfInformation_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfInformation_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfInformation_grid" class="grid">
    </div>
</body>
</html>