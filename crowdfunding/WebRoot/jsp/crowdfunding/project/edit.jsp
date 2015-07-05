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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/project/project.js"></script>
	<script type="text/javascript">
		function project_edit_submit(dialog){
			$("#crowdfunding_project_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_project_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_project_edit_form",
						basePath+"admin/crowdfunding/project!doEdit.action",
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
 	<form id="crowdfunding_project_edit_form" name="crowdfunding_project_edit_form" class="l-form" method="post">
	 <input type="hidden" name="project.id" value="${project.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目标签：</label>
			  	    <input type="text" name="project.projectTag" value="${project.projectTag}" class="input-text " />
					<!-- <font color="red">项目标签提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目名称：</label>
			  	    <input type="text" name="project.projectName" value="${project.projectName}" class="input-text " />
					<!-- <font color="red">项目名称提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>广告词：</label>
			  	    <input type="text" name="project.projectAdWord" value="${project.projectAdWord}" class="input-text " />
					<!-- <font color="red">广告词提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目类型：</label>
			  	    <input type="text" name="project.projectType" value="${project.projectType}" class="input-text digits " />
					<!-- <font color="red">项目类型提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目状态：</label>
			  	    <input type="text" name="project.projectStatus" value="${project.projectStatus}" class="input-text digits " />
					<!-- <font color="red">项目状态提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>募集金额：</label>
			  	    <input type="text" name="project.amount" value="${project.amount}" class="input-text digits " />
					<!-- <font color="red">募集金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>已募集金额：</label>
			  	    <input type="text" name="project.collectedAmount" value="${project.collectedAmount}" class="input-text digits " />
					<!-- <font color="red">已募集金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>虚拟募集金额：</label>
			  	    <input type="text" name="project.virtualCollectedAmount" value="${project.virtualCollectedAmount}" class="input-text digits " />
					<!-- <font color="red">虚拟募集金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>是否开启虚拟募集金额：</label>
			  	    <input type="text" name="project.isVirtualCollectedAmount" value="${project.isVirtualCollectedAmount}" class="input-text digits " />
					<!-- <font color="red">是否开启虚拟募集金额提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>募集上限：</label>
			  	    <input type="text" name="project.topLimit" value="${project.topLimit}" class="input-text digits " />
					<!-- <font color="red">募集上限提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>募集天数：</label>
			  	    <input type="text" name="project.ccollectDays" value="${project.ccollectDays}" class="input-text digits " />
					<!-- <font color="red">募集天数提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目发起人：</label>
			  	    <input type="text" name="project.projectSponsor" value="${project.projectSponsor}" class="input-text " />
					<!-- <font color="red">项目发起人提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目图片：</label>
			  	    <input type="text" name="project.projectImage" value="${project.projectImage}" class="input-text " />
					<!-- <font color="red">项目图片提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>主页图片：</label>
			  	    <input type="text" name="project.projectThumImage" value="${project.projectThumImage}" class="input-text " />
					<!-- <font color="red">主页图片提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>视频地址：</label>
			  	    <input type="text" name="project.videoAddr" value="${project.videoAddr}" class="input-text " />
					<!-- <font color="red">视频地址提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>支持人数：</label>
			  	    <input type="text" name="project.supports" value="${project.supports}" class="input-text digits " />
					<!-- <font color="red">支持人数提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目简介：</label>
			  	    <input type="text" name="project.projectSummary" value="${project.projectSummary}" class="input-text " />
					<!-- <font color="red">项目简介提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目详情：</label>
			  	    <input type="text" name="project.projectDetails" value="${project.projectDetails}" class="input-text " />
					<!-- <font color="red">项目详情提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目地点：</label>
			  	    <input type="text" name="project.projectAddr" value="${project.projectAddr}" class="input-text " />
					<!-- <font color="red">项目地点提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>项目附件：</label>
			  	    <input type="text" name="project.projectAttachment" value="${project.projectAttachment}" class="input-text " />
					<!-- <font color="red">项目附件提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>上架时间：</label>
			  	    <input type="text" name="project.salesTime" value="${project.salesTime}" class="input-text " />
					<!-- <font color="red">上架时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>创建时间：</label>
			  	    <input type="text" name="project.createTime" value="${project.createTime}" class="input-text " />
					<!-- <font color="red">创建时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>更新时间：</label>
			  	    <input type="text" name="project.updateTime" value="${project.updateTime}" class="input-text " />
					<!-- <font color="red">更新时间提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>发起人支付宝账户：</label>
			  	    <input type="text" name="project.userAlipayAccount" value="${project.userAlipayAccount}" class="input-text " />
					<!-- <font color="red">发起人支付宝账户提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>支付宝账户名：</label>
			  	    <input type="text" name="project.userAlipayName" value="${project.userAlipayName}" class="input-text " />
					<!-- <font color="red">支付宝账户名提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>佣金费率：</label>
			  	    <input type="text" name="project.rate" value="${project.rate}" class="input-text digits " />
					<!-- <font color="red">佣金费率提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>发起人类型：</label>
			  	    <input type="text" name="project.userType" value="${project.userType}" class="input-text digits " />
					<!-- <font color="red">发起人类型提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>排序号：</label>
			  	    <input type="text" name="project.ind" value="${project.ind}" class="input-text digits " />
					<!-- <font color="red">排序号提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>0-未结束，1-众筹成功结束，2-众筹失败结束：</label>
			  	    <input type="text" name="project.closureType" value="${project.closureType}" class="input-text digits " />
					<!-- <font color="red">0-未结束，1-众筹成功结束，2-众筹失败结束提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>是否在前端显示0是1否：</label>
			  	    <input type="text" name="project.display" value="${project.display}" class="input-text digits " />
					<!-- <font color="red">是否在前端显示0是1否提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>0-未发货；1-已发货：</label>
			  	    <input type="text" name="project.shipType" value="${project.shipType}" class="input-text digits " />
					<!-- <font color="red">0-未发货；1-已发货提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>发货日期：</label>
			  	    <input type="text" name="project.shipTime" value="${project.shipTime}" class="input-text " />
					<!-- <font color="red">发货日期提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>审核进度： 0-未设标签; 1-已面签； 2-已初评； 3-已复评； 4-已签合同：</label>
			  	    <input type="text" name="project.reviewProgress" value="${project.reviewProgress}" class="input-text digits " />
					<!-- <font color="red">审核进度： 0-未设标签; 1-已面签； 2-已初评； 3-已复评； 4-已签合同提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>放款状态：10-未放款；20-已开始放款 ; 30-已放款完成：</label>
			  	    <input type="text" name="project.lendingStatus" value="${project.lendingStatus}" class="input-text digits " />
					<!-- <font color="red">放款状态：10-未放款；20-已开始放款 ; 30-已放款完成提示</font> -->
				</li>
	    	</ul>
	    </div>
    </form>
</body>
</html>