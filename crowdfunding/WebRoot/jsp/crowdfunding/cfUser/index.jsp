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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfUser/cfUser.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfUser_form" name="crowdfunding_cfUser_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>userName：</label>
				   <input id="cfUserCondition.userName" name="cfUserCondition.userName" value="${cfUserCondition.userName}" />
				   <label>petName：</label>
				   <input id="cfUserCondition.petName" name="cfUserCondition.petName" value="${cfUserCondition.petName}" />
				   <label>realName：</label>
				   <input id="cfUserCondition.realName" name="cfUserCondition.realName" value="${cfUserCondition.realName}" />
				   <label>phone：</label>
				   <input id="cfUserCondition.phone" name="cfUserCondition.phone" value="${cfUserCondition.phone}" />
				   <label>isPhone：</label>
				   <input id="cfUserCondition.isPhone" name="cfUserCondition.isPhone" value="${cfUserCondition.isPhone}" />
				   <label>mail：</label>
				   <input id="cfUserCondition.mail" name="cfUserCondition.mail" value="${cfUserCondition.mail}" />
				   <label>isMail：</label>
				   <input id="cfUserCondition.isMail" name="cfUserCondition.isMail" value="${cfUserCondition.isMail}" />
				   <label>idNumber：</label>
				   <input id="cfUserCondition.idNumber" name="cfUserCondition.idNumber" value="${cfUserCondition.idNumber}" />
				   <label>backPath：</label>
				   <input id="cfUserCondition.backPath" name="cfUserCondition.backPath" value="${cfUserCondition.backPath}" />
				   <label>frontPath：</label>
				   <input id="cfUserCondition.frontPath" name="cfUserCondition.frontPath" value="${cfUserCondition.frontPath}" />
				   <label>isIdentity：</label>
				   <input id="cfUserCondition.isIdentity" name="cfUserCondition.isIdentity" value="${cfUserCondition.isIdentity}" />
				   <label>province：</label>
				   <input id="cfUserCondition.province" name="cfUserCondition.province" value="${cfUserCondition.province}" />
				   <label>citys：</label>
				   <input id="cfUserCondition.citys" name="cfUserCondition.citys" value="${cfUserCondition.citys}" />
				   <label>address：</label>
				   <input id="cfUserCondition.address" name="cfUserCondition.address" value="${cfUserCondition.address}" />
				   <label>personalStatement：</label>
				   <input id="cfUserCondition.personalStatement" name="cfUserCondition.personalStatement" value="${cfUserCondition.personalStatement}" />
				   <label>invitationCode：</label>
				   <input id="cfUserCondition.invitationCode" name="cfUserCondition.invitationCode" value="${cfUserCondition.invitationCode}" />
				   <label>personalCode：</label>
				   <input id="cfUserCondition.personalCode" name="cfUserCondition.personalCode" value="${cfUserCondition.personalCode}" />
				   <label>filePath：</label>
				   <input id="cfUserCondition.filePath" name="cfUserCondition.filePath" value="${cfUserCondition.filePath}" />
				   <label>isLock：</label>
				   <input id="cfUserCondition.isLock" name="cfUserCondition.isLock" value="${cfUserCondition.isLock}" />
				   <label>isActivate：</label>
				   <input id="cfUserCondition.isActivate" name="cfUserCondition.isActivate" value="${cfUserCondition.isActivate}" />
				   <label>registerTime：</label>
				   <input id="cfUserCondition.registerTime" name="cfUserCondition.registerTime" value="${cfUserCondition.registerTime}" />
				   <label>lastLoginTime：</label>
				   <input id="cfUserCondition.lastLoginTime" name="cfUserCondition.lastLoginTime" value="${cfUserCondition.lastLoginTime}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfUser_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfUser_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfUser_grid" class="grid">
    </div>
</body>
</html>