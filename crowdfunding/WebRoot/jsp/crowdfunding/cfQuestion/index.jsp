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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfQuestion/cfQuestion.js"></script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfQuestion_form" name="crowdfunding_cfQuestion_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>userId：</label>
				   <input id="cfQuestionCondition.userId" name="cfQuestionCondition.userId" value="${cfQuestionCondition.userId}" />
				   <label>questionId：</label>
				   <input id="cfQuestionCondition.questionId" name="cfQuestionCondition.questionId" value="${cfQuestionCondition.questionId}" />
				   <label>answer：</label>
				   <input id="cfQuestionCondition.answer" name="cfQuestionCondition.answer" value="${cfQuestionCondition.answer}" />
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfQuestion_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfQuestion_form').reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfQuestion_grid" class="grid">
    </div>
</body>
</html>