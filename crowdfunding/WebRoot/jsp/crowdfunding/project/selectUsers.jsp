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
	<script type="text/javascript">
		$(document).ready(function(){
			$("input[type='checkbox']").live("click",function(){
			$("input[type='checkbox']").each(function(i,obj){
				 $(obj).attr("checked",false);
			});
			 $(this).attr("checked","checked");
			 window.parent.getCfUser($(this).val(),$(this).attr("title"));
		});
	});
	var cfUser_grid = null;
var cfUser_toolbar = {
	items : [ ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfUser_grid",
		condition : "cfUserCondition",
		url : basePath+"admin/crowdfunding/cfUser!selectUsersData.action",
		formid : "crowdfunding_cfUser_form",
		toolbar : cfUser_toolbar,
		rownumbers:true,
		columns : [
				{
					display : "",
					name : "userName",
					render:function(items){
						return "<input type='checkbox'class='checkboxUser'title='"+items.userName+"' value='"+items.id+"'>";
					}
				},
				{
					display : "用户账户",
					name : "userName"
				},
				{
					display : "昵称",
					name : "petName"
				},
				{
					display : "真实姓名",
					name : "realName"
				},
				{
					display : "手机号码",
					name : "phone"
				},
				{
					display : "电子邮箱",
					name : "mail"
				},
				{
					display : "省市",
					name : "province"
				}
		]
	};
	cfUser_grid = showGrid(g);
});
	
	function cfUser_search() {
		cfUser_grid.loadData();
	}
	</script>
</head>
<body>
	<!-- search start -->
	<div class="content">
		<form id="crowdfunding_cfUser_form" name="crowdfunding_cfUser_form">
		   <ul>
		   <!-- search param 参数过长请拆分UL -->
			   <li>
				   <label>用户账户：</label>
				   <input id="cfUserCondition.userName" name="cfUserCondition.userName" value="${cfUserCondition.userName}" class="input-text "/>
				   <label>真实姓名：</label>
				   <input id="cfUserCondition.realName" name="cfUserCondition.realName" value="${cfUserCondition.realName}" class="input-text "/>
				   </li>
			<!-- search btn -->
		   	<li><a class="l-button" onclick="cfUser_search()">查询</a></li>
		   	<li><a class="l-button" onclick="$('#crowdfunding_cfUser_form')[0].reset()">重置</a></li>
		   </ul>
		</form>
	</div>
	
	<!-- table start -->
    <div id="crowdfunding_cfUser_grid" class="grid">
    </div>
</body>
</html>