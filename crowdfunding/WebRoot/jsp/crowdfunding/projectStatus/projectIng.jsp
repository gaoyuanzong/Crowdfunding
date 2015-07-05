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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectStatus/projectStatus.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_projectIng_form" name="crowdfunding_projectIng_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>项目标签：</label>
				   <input id="projectCondition.projectTag" name="projectCondition.projectTag" value="${projectCondition.projectTag}" />
				   <label>项目名称：</label>
				   <input id="projectCondition.projectName" name="projectCondition.projectName" value="${projectCondition.projectName}" />
				   <label>项目类型：</label>
				   <input id="projectCondition.projectType" name="projectCondition.projectType" value="${projectCondition.projectType}" />
				   <label>项目状态：</label>
				   <input id="projectCondition.projectStatus" name="projectCondition.projectStatus" value="${projectCondition.projectStatus}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="project_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_projectIng_form')[0].reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_projectIng_grid" class="grid">
    </div>
</body>
</html>