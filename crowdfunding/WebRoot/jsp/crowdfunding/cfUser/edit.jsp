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
	<script type="text/javascript" src="${basePath}jsp/crowdfunding/cfUser/cfUser.js"></script>
	<script type="text/javascript">
		function cfUser_edit_submit(dialog){
			$("#crowdfunding_cfUser_edit_form").submit();
		}
		
		$(document).ready(function(){
			 $("#crowdfunding_cfUser_edit_form").validate({
			 	submitHandler : function(frm){
					commonFrmSubmit(
						"#crowdfunding_cfUser_edit_form",
						basePath+"admin/crowdfunding/cfUser!doEdit.action",
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
 	<form id="crowdfunding_cfUser_edit_form" name="crowdfunding_cfUser_edit_form" class="l-form" method="post">
	 <input type="hidden" name="cfUser.id" value="${cfUser.id}"/>
	    <div class="content">
		
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>userName：</label>
			  	    <input type="text" name="cfUser.userName" value="${cfUser.userName}" class="input-text " />
					<!-- <font color="red">userName提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>petName：</label>
			  	    <input type="text" name="cfUser.petName" value="${cfUser.petName}" class="input-text " />
					<!-- <font color="red">petName提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>realName：</label>
			  	    <input type="text" name="cfUser.realName" value="${cfUser.realName}" class="input-text " />
					<!-- <font color="red">realName提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>phone：</label>
			  	    <input type="text" name="cfUser.phone" value="${cfUser.phone}" class="input-text phone " />
					<!-- <font color="red">phone提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>isPhone：</label>
			  	    <input type="text" name="cfUser.isPhone" value="${cfUser.isPhone}" class="input-text phone digits " />
					<!-- <font color="red">isPhone提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>mail：</label>
			  	    <input type="text" name="cfUser.mail" value="${cfUser.mail}" class="input-text email " />
					<!-- <font color="red">mail提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>isMail：</label>
			  	    <input type="text" name="cfUser.isMail" value="${cfUser.isMail}" class="input-text email digits " />
					<!-- <font color="red">isMail提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>idNumber：</label>
			  	    <input type="text" name="cfUser.idNumber" value="${cfUser.idNumber}" class="input-text " />
					<!-- <font color="red">idNumber提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>backPath：</label>
			  	    <input type="text" name="cfUser.backPath" value="${cfUser.backPath}" class="input-text " />
					<!-- <font color="red">backPath提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>frontPath：</label>
			  	    <input type="text" name="cfUser.frontPath" value="${cfUser.frontPath}" class="input-text " />
					<!-- <font color="red">frontPath提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>isIdentity：</label>
			  	    <input type="text" name="cfUser.isIdentity" value="${cfUser.isIdentity}" class="input-text digits " />
					<!-- <font color="red">isIdentity提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>province：</label>
			  	    <input type="text" name="cfUser.province" value="${cfUser.province}" class="input-text " />
					<!-- <font color="red">province提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>citys：</label>
			  	    <input type="text" name="cfUser.citys" value="${cfUser.citys}" class="input-text " />
					<!-- <font color="red">citys提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>address：</label>
			  	    <input type="text" name="cfUser.address" value="${cfUser.address}" class="input-text " />
					<!-- <font color="red">address提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>personalStatement：</label>
			  	    <input type="text" name="cfUser.personalStatement" value="${cfUser.personalStatement}" class="input-text " />
					<!-- <font color="red">personalStatement提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>invitationCode：</label>
			  	    <input type="text" name="cfUser.invitationCode" value="${cfUser.invitationCode}" class="input-text " />
					<!-- <font color="red">invitationCode提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>personalCode：</label>
			  	    <input type="text" name="cfUser.personalCode" value="${cfUser.personalCode}" class="input-text " />
					<!-- <font color="red">personalCode提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>filePath：</label>
			  	    <input type="text" name="cfUser.filePath" value="${cfUser.filePath}" class="input-text " />
					<!-- <font color="red">filePath提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>isLock：</label>
			  	    <input type="text" name="cfUser.isLock" value="${cfUser.isLock}" class="input-text digits " />
					<!-- <font color="red">isLock提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>isActivate：</label>
			  	    <input type="text" name="cfUser.isActivate" value="${cfUser.isActivate}" class="input-text digits " />
					<!-- <font color="red">isActivate提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>registerTime：</label>
			  	    <input type="text" name="cfUser.registerTime" value="${cfUser.registerTime}" class="input-text " />
					<!-- <font color="red">registerTime提示</font> -->
				</li>
	    	</ul>
	    	<ul>
	    		<li>
	    			<label><font color="red">*</font>lastLoginTime：</label>
			  	    <input type="text" name="cfUser.lastLoginTime" value="${cfUser.lastLoginTime}" class="input-text " />
					<!-- <font color="red">lastLoginTime提示</font> -->
				</li>
	    	</ul>
	    </div>
    </form>
</body>
</html>