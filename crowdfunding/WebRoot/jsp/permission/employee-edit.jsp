<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/inc/meta.inc" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/jsp/inc/head.inc" %>
    <script type="text/javascript">
         function f_submit(dialog){
        	if($("form.validate").valid()){
	        	var param=$("form.validate").serialize();
	        	$.getJSON("${basePath}permission/employee!edit.action", param,function(json){
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
 <input type="hidden" name="employee.id" value="${employee.id }"/>
    <div class="content">
    	<ul>
    		<li>
				<label>用户组：</label>
    			<select name="employee.roleId" class="required input-select">
    				<option></option>
    				<c:forEach items="${roleList }" var="item">
    					<option value="${item.id }" <c:if test="${employee.roleId eq item.id }">selected</c:if>>${item.name }</option>
    				</c:forEach>
    			</select>
    		</li>
    	</ul>
    	<ul>
    		<li>
    			<label>用户名称：</label>
    			<input type="text"  name="employee.name" id="name" value="${employee.name }" class="required input-text"/>
    		</li>
    	</ul>
    </div>
    </form>
</body>
</html>