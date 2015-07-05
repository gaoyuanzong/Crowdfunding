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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/projectSubscribe/projectSubscribe.js"></script>
	<script type="text/javascript">
		function projectSubscribe_add_submit(dialog){
			$("#crowdfunding_projectSubscribe_add_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_projectSubscribe_add_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
							"#crowdfunding_projectSubscribe_add_form",
							basePath+"admin/crowdfunding/projectSubscribe!doAdd.action",
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
 	<form id="crowdfunding_projectSubscribe_add_form" name="crowdfunding_projectSubscribe_add_form" class="l-form" method="post">
	 <input type="hidden" name="projectSubscribe.id" value="${projectSubscribe.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>用户：</label>
			  	    <input type="text" name="projectSubscribe.userId" value="${projectSubscribe.userId}" class="input-text " />
					<!-- <font color="red">用户提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目ID：</label>
			  	    <input type="text" name="projectSubscribe.projectId" value="${projectSubscribe.projectId}" class="input-text digits " />
					<!-- <font color="red">项目ID提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>回报ID：</label>
			  	    <input type="text" name="projectSubscribe.redoundId" value="${projectSubscribe.redoundId}" class="input-text digits " />
					<!-- <font color="red">回报ID提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>收获地址ID：</label>
			  	    <input type="text" name="projectSubscribe.addressId" value="${projectSubscribe.addressId}" class="input-text digits " />
					<!-- <font color="red">收获地址ID提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>认购状态：</label>
			  	    <input type="text" name="projectSubscribe.subscribeStatus" value="${projectSubscribe.subscribeStatus}" class="input-text digits " />
					<!-- <font color="red">认购状态提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>运费：</label>
			  	    <input type="text" name="projectSubscribe.freight" value="${projectSubscribe.freight}" class="input-text digits " />
					<!-- <font color="red">运费提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>支持金额：</label>
			  	    <input type="text" name="projectSubscribe.supportAmount" value="${projectSubscribe.supportAmount}" class="input-text digits " />
					<!-- <font color="red">支持金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>支付金额：</label>
			  	    <input type="text" name="projectSubscribe.payAmount" value="${projectSubscribe.payAmount}" class="input-text digits " />
					<!-- <font color="red">支付金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>支付时间：</label>
			  	    <input type="text" name="projectSubscribe.payedTime" value="${projectSubscribe.payedTime}" class="input-text " />
					<!-- <font color="red">支付时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>是否需要回报：</label>
			  	    <input type="text" name="projectSubscribe.isRedound" value="${projectSubscribe.isRedound}" class="input-text digits " />
					<!-- <font color="red">是否需要回报提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>订单号：</label>
			  	    <input type="text" name="projectSubscribe.orderId" value="${projectSubscribe.orderId}" class="input-text " />
					<!-- <font color="red">订单号提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>创建时间：</label>
			  	    <input type="text" name="projectSubscribe.createTime" value="${projectSubscribe.createTime}" class="input-text " />
					<!-- <font color="red">创建时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>更新时间：</label>
			  	    <input type="text" name="projectSubscribe.ipdateTime" value="${projectSubscribe.ipdateTime}" class="input-text " />
					<!-- <font color="red">更新时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>快递公司：</label>
			  	    <input type="text" name="projectSubscribe.expressCompany" value="${projectSubscribe.expressCompany}" class="input-text " />
					<!-- <font color="red">快递公司提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>运单号：</label>
			  	    <input type="text" name="projectSubscribe.expressNum" value="${projectSubscribe.expressNum}" class="input-text " />
					<!-- <font color="red">运单号提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>备注：</label>
			  	    <input type="text" name="projectSubscribe.remarks" value="${projectSubscribe.remarks}" class="input-text " />
					<!-- <font color="red">备注提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>交易单：</label>
			  	    <input type="text" name="projectSubscribe.transactionId" value="${projectSubscribe.transactionId}" class="input-text " />
					<!-- <font color="red">交易单提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>支付状态：</label>
			  	    <input type="text" name="projectSubscribe.payStatus" value="${projectSubscribe.payStatus}" class="input-text digits " />
					<!-- <font color="red">支付状态提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>email：</label>
			  	    <input type="text" name="projectSubscribe.email" value="${projectSubscribe.email}" class="input-text email " />
					<!-- <font color="red">email提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目标签：</label>
			  	    <input type="text" name="projectSubscribe.projectTag" value="${projectSubscribe.projectTag}" class="input-text " />
					<!-- <font color="red">项目标签提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>客服备注：</label>
			  	    <input type="text" name="projectSubscribe.csRemarks" value="${projectSubscribe.csRemarks}" class="input-text " />
					<!-- <font color="red">客服备注提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>0-无需发票；1-需要发票：</label>
			  	    <input type="text" name="projectSubscribe.invoiceFlag" value="${projectSubscribe.invoiceFlag}" class="input-text digits " />
					<!-- <font color="red">0-无需发票；1-需要发票提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>发票标题：</label>
			  	    <input type="text" name="projectSubscribe.invoiceTitle" value="${projectSubscribe.invoiceTitle}" class="input-text " />
					<!-- <font color="red">发票标题提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>逻辑删除标志0正常1删除：</label>
			  	    <input type="text" name="projectSubscribe.status" value="${projectSubscribe.status}" class="input-text digits " />
					<!-- <font color="red">逻辑删除标志0正常1删除提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>0-未取消，1-单笔退款：</label>
			  	    <input type="text" name="projectSubscribe.cancelTag" value="${projectSubscribe.cancelTag}" class="input-text digits " />
					<!-- <font color="red">0-未取消，1-单笔退款提示</font> -->
				</li>
	    	</ul>
	    </div>
		<!--
		<div style="margin-top:10px;margin-bottom:15px;">
			<a class="l-button" onclick="projectSubscribe_add_submit()">提交</a>
			<a class="l-button" onclick="$("#crowdfunding_projectSubscribe_add_form").reset()">重置</a>
		</div>
		-->
    </form>
</body>
</html>