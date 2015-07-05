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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfLoginlog/cfLoginlog.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfLoginlog_form" name="crowdfunding_cfLoginlog_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>userId：</label>
				   <input id="cfLoginlogCondition.userId" name="cfLoginlogCondition.userId" value="${cfLoginlogCondition.userId}" />
				   <label>content：</label>
				   <input id="cfLoginlogCondition.content" name="cfLoginlogCondition.content" value="${cfLoginlogCondition.content}" />
				   <label>createTime：</label>
				   <input id="cfLoginlogCondition.createTime" name="cfLoginlogCondition.createTime" value="${cfLoginlogCondition.createTime}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfLoginlog_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfLoginlog_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfLoginlog_grid" class="grid">
    </div>
</body>
</html>