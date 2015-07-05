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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfReaddress/cfReaddress.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfReaddress_form" name="crowdfunding_cfReaddress_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>userId：</label>
				   <input id="cfReaddressCondition.userId" name="cfReaddressCondition.userId" value="${cfReaddressCondition.userId}" />
				   <label>receivesName：</label>
				   <input id="cfReaddressCondition.receivesName" name="cfReaddressCondition.receivesName" value="${cfReaddressCondition.receivesName}" />
				   <label>receivesCity：</label>
				   <input id="cfReaddressCondition.receivesCity" name="cfReaddressCondition.receivesCity" value="${cfReaddressCondition.receivesCity}" />
				   <label>receivesDetail：</label>
				   <input id="cfReaddressCondition.receivesDetail" name="cfReaddressCondition.receivesDetail" value="${cfReaddressCondition.receivesDetail}" />
				   <label>receivesCode：</label>
				   <input id="cfReaddressCondition.receivesCode" name="cfReaddressCondition.receivesCode" value="${cfReaddressCondition.receivesCode}" />
				   <label>mobile：</label>
				   <input id="cfReaddressCondition.mobile" name="cfReaddressCondition.mobile" value="${cfReaddressCondition.mobile}" />
				   <label>isDefault：</label>
				   <input id="cfReaddressCondition.isDefault" name="cfReaddressCondition.isDefault" value="${cfReaddressCondition.isDefault}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfReaddress_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfReaddress_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfReaddress_grid" class="grid">
    </div>
</body>
</html>