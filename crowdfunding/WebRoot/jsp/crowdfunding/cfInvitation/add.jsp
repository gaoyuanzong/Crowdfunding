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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfInvitation/cfInvitation.js"></script>
	<script type="text/javascript">
		function cfInvitation_add_submit(dialog){
			$("#crowdfunding_cfInvitation_add_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfInvitation_add_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
							"#crowdfunding_cfInvitation_add_form",
							basePath+"admin/crowdfunding/cfInvitation!doAdd.action",
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
 	<form id="crowdfunding_cfInvitation_add_form" name="crowdfunding_cfInvitation_add_form" class="l-form" method="post">
	 <input type="hidden" name="cfInvitation.id" value="${cfInvitation.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>userId：</label>
			  	    <input type="text" name="cfInvitation.userId" value="${cfInvitation.userId}" class="input-text " />
					<!-- <font color="red">userId提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>beInvitedUserid：</label>
			  	    <input type="text" name="cfInvitation.beInvitedUserid" value="${cfInvitation.beInvitedUserid}" class="input-text " />
					<!-- <font color="red">beInvitedUserid提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>award：</label>
			  	    <input type="text" name="cfInvitation.award" value="${cfInvitation.award}" class="input-text " />
					<!-- <font color="red">award提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>isEffect：</label>
			  	    <input type="text" name="cfInvitation.isEffect" value="${cfInvitation.isEffect}" class="input-text digits " />
					<!-- <font color="red">isEffect提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>createTime：</label>
			  	    <input type="text" name="cfInvitation.createTime" value="${cfInvitation.createTime}" class="input-text " />
					<!-- <font color="red">createTime提示</font> -->
				</li>
	    	</ul>
	    </div>
		<!--
		<div style="margin-top:10px;margin-bottom:15px;">
			<a class="l-button" onclick="cfInvitation_add_submit()">提交</a>
			<a class="l-button" onclick="$("#crowdfunding_cfInvitation_add_form").reset()">重置</a>
		</div>
		-->
    </form>
</body>
</html>