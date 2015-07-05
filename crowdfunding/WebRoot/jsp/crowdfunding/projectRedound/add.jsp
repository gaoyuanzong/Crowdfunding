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
	<link href="${basePath}jsp/crowdfunding/common/crowdfunding.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/common/common.js"></script>
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectRedound/projectRedound.js"></script>
	<script type="text/javascript">
		function projectRedound_add_submit(dialog){
			$("#crowdfunding_projectRedound_add_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_projectRedound_add_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
							"#crowdfunding_projectRedound_add_form",
							basePath+"admin/crowdfunding/projectRedound!doAdd.action",
							function(json){
								if(json.success){
									home_fresh();
								}else{
									alert(json.message,"error");
								}
							}
					);
			 	},
				errorPlacement: function(error, element) {
					error.appendTo(element.parents("li:first"));
				}
			 });
		});
	</script>
</head>
<body>
 	<form id="crowdfunding_projectRedound_add_form" name="crowdfunding_projectRedound_add_form" class="l-form" method="post">
	 <input type="hidden" name="projectRedound.id" value="${projectRedound.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目ID：</label>
			  	    <input type="text" name="projectRedound.projectId" value="${projectRedound.projectId}" class="input-text required digits " />
					<!-- <font color="red">项目ID提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>回报金额：</label>
			  	    <input type="text" name="projectRedound.amount" value="${projectRedound.amount}" class="input-text required digits " />
					<!-- <font color="red">回报金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>回报类型：</label>
			  	    <input type="text" name="projectRedound.redoundType" value="${projectRedound.redoundType}" class="input-text required digits " />
					<!-- <font color="red">回报类型提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>回报内容：</label>
			  	    <input type="text" name="projectRedound.redoundContent" value="${projectRedound.redoundContent}" class="input-text required " />
					<!-- <font color="red">回报内容提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>图片：</label>
			  	    <input type="text" name="projectRedound.redoundImage" value="${projectRedound.redoundImage}" class="input-text " />
					<!-- <font color="red">图片提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>上限：</label>
			  	    <input type="text" name="projectRedound.limits" value="${projectRedound.limits}" class="input-text required digits " />
					<!-- <font color="red">上限提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>运费：</label>
			  	    <input type="text" name="projectRedound.freight" value="${projectRedound.freight}" class="input-text required digits " />
					<!-- <font color="red">运费提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>回报天次：</label>
			  	    <input type="text" name="projectRedound.redoundDays" value="${projectRedound.redoundDays}" class="input-text required digits " />
					<!-- <font color="red">回报天次提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>0-不可开发票，1-可开发票：</label>
			  	    <input type="text" name="projectRedound.invoiceStatus" value="${projectRedound.invoiceStatus}" class="input-text required digits " />
					<!-- <font color="red">0-不可开发票，1-可开发票提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>创建时间：</label>
			  	    <input type="text" name="projectRedound.createTime" value="${projectRedound.createTime}" class="input-text required " />
					<!-- <font color="red">创建时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>更新时间：</label>
			  	    <input type="text" name="projectRedound.updateTime" value="${projectRedound.updateTime}" class="input-text required " />
					<!-- <font color="red">更新时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>排序：</label>
			  	    <input type="text" name="projectRedound.ind" value="${projectRedound.ind}" class="input-text digits " />
					<!-- <font color="red">排序提示</font> -->
				</li>
	    	</ul>
	    </div>
		<!--
		<div style="margin-top:10px;margin-bottom:15px;">
			<a class="l-button" onclick="projectRedound_add_submit()">提交</a>
			<a class="l-button" onclick="$("#crowdfunding_projectRedound_add_form").reset()">重置</a>
		</div>
		-->
    </form>
</body>
</html>