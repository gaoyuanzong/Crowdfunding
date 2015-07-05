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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfMoneyRecord/cfMoneyRecord.js"></script>
	<script type="text/javascript">
		function cfMoneyRecord_add_submit(dialog){
			$("#crowdfunding_cfMoneyRecord_add_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfMoneyRecord_add_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
							"#crowdfunding_cfMoneyRecord_add_form",
							basePath+"admin/crowdfunding/cfMoneyRecord!doAdd.action",
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
 	<form id="crowdfunding_cfMoneyRecord_add_form" name="crowdfunding_cfMoneyRecord_add_form" class="l-form" method="post">
	 <input type="hidden" name="cfMoneyRecord.id" value="${cfMoneyRecord.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>userId：</label>
			  	    <input type="text" name="cfMoneyRecord.userId" value="${cfMoneyRecord.userId}" class="input-text " />
					<!-- <font color="red">userId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>recordKind：</label>
			  	    <input type="text" name="cfMoneyRecord.recordKind" value="${cfMoneyRecord.recordKind}" class="input-text " />
					<!-- <font color="red">recordKind提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>recordState：</label>
			  	    <input type="text" name="cfMoneyRecord.recordState" value="${cfMoneyRecord.recordState}" class="input-text digits " />
					<!-- <font color="red">recordState提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>description：</label>
			  	    <input type="text" name="cfMoneyRecord.description" value="${cfMoneyRecord.description}" class="input-text " />
					<!-- <font color="red">description提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>createTime：</label>
			  	    <input type="text" name="cfMoneyRecord.createTime" value="${cfMoneyRecord.createTime}" class="input-text " />
					<!-- <font color="red">createTime提示</font> -->
				</li>
	    	</ul>
	    </div>
		<!--
		<div style="margin-top:10px;margin-bottom:15px;">
			<a class="l-button" onclick="cfMoneyRecord_add_submit()">提交</a>
			<a class="l-button" onclick="$("#crowdfunding_cfMoneyRecord_add_form").reset()">重置</a>
		</div>
		-->
    </form>
</body>
</html>