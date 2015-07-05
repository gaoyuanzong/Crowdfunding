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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfInvitation/cfInvitation.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfInvitation_form" name="crowdfunding_cfInvitation_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>userId：</label>
				   <input id="cfInvitationCondition.userId" name="cfInvitationCondition.userId" value="${cfInvitationCondition.userId}" />
				   <label>beInvitedUserid：</label>
				   <input id="cfInvitationCondition.beInvitedUserid" name="cfInvitationCondition.beInvitedUserid" value="${cfInvitationCondition.beInvitedUserid}" />
				   <label>award：</label>
				   <input id="cfInvitationCondition.award" name="cfInvitationCondition.award" value="${cfInvitationCondition.award}" />
				   <label>isEffect：</label>
				   <input id="cfInvitationCondition.isEffect" name="cfInvitationCondition.isEffect" value="${cfInvitationCondition.isEffect}" />
				   <label>createTime：</label>
				   <input id="cfInvitationCondition.createTime" name="cfInvitationCondition.createTime" value="${cfInvitationCondition.createTime}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfInvitation_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfInvitation_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfInvitation_grid" class="grid">
    </div>
</body>
</html>