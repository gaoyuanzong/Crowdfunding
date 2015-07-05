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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectProgress/projectProgress.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_projectProgress_form" name="crowdfunding_projectProgress_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>项目发起人：</label>
				   <input id="projectProgressCondition.userId" name="projectProgressCondition.userId" value="${projectProgressCondition.userId}" />
				   <label>项目ID：</label>
				   <input id="projectProgressCondition.projectId" name="projectProgressCondition.projectId" value="${projectProgressCondition.projectId}" />
				   <label>项目名称：</label>
				   <input id="projectProgressCondition.projectName" name="projectProgressCondition.projectName" value="${projectProgressCondition.projectName}" />
				   <label>进度内容：</label>
				   <input id="projectProgressCondition.progressContent" name="projectProgressCondition.progressContent" value="${projectProgressCondition.progressContent}" />
				   <label>图片：</label>
				   <input id="projectProgressCondition.progressImage" name="projectProgressCondition.progressImage" value="${projectProgressCondition.progressImage}" />
				   <label>创建时间：</label>
				   <input id="projectProgressCondition.createTime" name="projectProgressCondition.createTime" value="${projectProgressCondition.createTime}" />
				   <label>缩略图：</label>
				   <input id="projectProgressCondition.progressThumImage" name="projectProgressCondition.progressThumImage" value="${projectProgressCondition.progressThumImage}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="projectProgress_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_projectProgress_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_projectProgress_grid" class="grid">
    </div>
</body>
</html>