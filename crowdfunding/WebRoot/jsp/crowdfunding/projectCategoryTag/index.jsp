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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectCategoryTag/projectCategoryTag.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_projectCategoryTag_form" name="crowdfunding_projectCategoryTag_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>名称：</label>
				   <input id="projectCategoryTagCondition.name" name="projectCategoryTagCondition.name" value="${projectCategoryTagCondition.name}" />
				   <input type="hidden" id="projectCategoryTagCondition.type" name="projectCategoryTagCondition.type" value=0 />
				   <input type="hidden"  id="projectCategoryTagCondition.createdTime" name="projectCategoryTagCondition.createdTime" value="${projectCategoryTagCondition.createdTime}" />
				   <input type="hidden"  id="projectCategoryTagCondition.modifiedTime" name="projectCategoryTagCondition.modifiedTime" value="${projectCategoryTagCondition.modifiedTime}" />
				   <input type="hidden" id="projectCategoryTagCondition.sortId" name="projectCategoryTagCondition.sortId" value="${projectCategoryTagCondition.sortId}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="projectCategoryTag_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_projectCategoryTag_form')[0].reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_projectCategoryTag_grid" class="grid">
    </div>
</body>
</html>