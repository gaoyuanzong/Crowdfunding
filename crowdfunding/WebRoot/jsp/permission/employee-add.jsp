<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/inc/meta.inc" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/jsp/inc/head.inc" %>
    <script type="text/javascript">
         function f_submit(dialog){
        	if($("form.validate").valid()){
	        	var param=$("form.validate").serialize();
	        	$.getJSON("${basePath}permission/employee!add.action", param,function(json){
	        		if(json.success){
	        			home_fresh();
					}else{
						alert(json.message,"error");
					}
				});
			} 
          }
    </script>
</head>

<body>
 <form class="l-form validate">
 <div style="display:none;"><!-- 附加  样式的问题 -->
 	<input type="text" />
 	<input type="password"/>
 </div>
    <div class="content">
    	<ul>
    		<li>
				<label>用户组：</label>
    			<select name="employee.roleId" class="required input-select">
    				<option></option>
    				<c:forEach items="${roleList }" var="item">
    					<option value="${item.id }">${item.name }</option>
    				</c:forEach>
    			</select>
    		</li>
    	</ul>
    	<ul>
    		<li>
    			<label>用户名称：</label>
    			<input type="text"  name="employee.name" id="name" class="required input-text"/>
    		</li>
    	</ul>
    	<ul>
    		<li>
    			<label>登录密码：</label>
    			<input type="password" name="employee.password" id="password" class="required input-text" minlength="6" maxlength="12">
    		</li>
    	</ul>
    	<ul>
    		<li>
    			<label>请再输一次密码：</label>
    			<input type="password" name="employee.repassword" id="repassword" class="required input-text {equalTo:'#password'}" minlength="6" maxlength="12">
    		</li>
    	</ul>
    </div>
    </form>
</body>
</html>