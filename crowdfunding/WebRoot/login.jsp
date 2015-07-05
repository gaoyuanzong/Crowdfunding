<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/jsp/inc/meta.inc" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="title" content="后台管理系统"/>
    <meta name="application-name" content="后台管理系统" />
	<link rel="Shortcut Icon" href="${basePath}image/logo.ico"  type=”image/x-icon”/>
	
    <script src="${basePath }ligerui/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
   	<link rel="stylesheet" type="text/css" href="${basePath }grind/css/style.css"  />
    <script type="text/javascript">
        function f_submit(){
        	if($("#name").val()==""||$("#name").val()=="用户名"){
        		$("#msg").html("用户名不能为空");
        		return false;
        	}
        	if($("#password").val()==""||$("#password").val()=="密码密码密码"){
        		$("#msg").html("密码不能为空");
        		return false;
        	}
        	$("#form1").submit();
        }
        $(function(){
        	$(document).keydown(function(event){
        		  if(event.keyCode==13){
        			  f_submit();
        		  }
        	}); 
        });
    </script>
</head>
<body class="bulbg">
<form id="form1" action="${basePath }login!login.action" method="post">
    <div class="centerbox">
    	<div class="loginbox">
       		 <div class="logo"><img src="${basePath }grind/images/logo.png" width="356" height="39" /></div>
        	 <div class="inputbox">
        	 	<p class="tisfont" id="msg">
               		<c:if test="${not empty actionErrors }">
                		<c:forEach items="${actionErrors }" var="error">
                			${error }&nbsp;&nbsp;
                		</c:forEach>
               		</c:if>
                 </p>
             </div>
        	 <div class="inputbox"><input id="name" name="employee.name" type="text" class="linkinput" value="用户名" onFocus="this.className='hoverinput';if(this.value=='用户名') this.value='';" onBlur="if (this.value=='') this.value='用户名';this.className='linkinput';"/></div>
        	 <div class="inputbox"></div>
        	 <div class="inputbox"><input id="password" name="employee.password" type="password" class="linkinput" value="密码密码密码" onFocus="this.className='hoverinput';if(this.value=='密码密码密码') this.value='';" onblur="if (this.value=='') this.value='密码密码密码';this.className='linkinput';"/></div>
        	 <div class="inputbox"></div>
        	 <div class="inputbox"><input name="" title="提交" onclick="f_submit();" type="button" class="loginlink" onMouseOver="this.className='loginhover'" onMouseOut="this.className='loginlink'"/></div>
    	</div>
    	<div class="bottom"><p class="fontbul">&copy;后台管理系统 </p></div>
    </div>
</form>
</body>
</html>

