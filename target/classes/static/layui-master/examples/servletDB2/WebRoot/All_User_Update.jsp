<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'All_User_Update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="margin-left:40%;width: 200px;background-color: lime;" >
    <form action="user/All_User_UpdaeServlet" method="get">
    	账号：<input type="text" readonly="readonly" name="uid" id = "uid" value="${param.id }">
   		用户名：<input type="text" name="name" id="name"/><hr>
    	密码：<input type="password" name="psw" id="psw"/><hr>
		年龄：<input type="text" name="age" id="age"/><hr>
    	<input type="submit" value="提交">
    </form>
    </div>
  </body>
</html>
