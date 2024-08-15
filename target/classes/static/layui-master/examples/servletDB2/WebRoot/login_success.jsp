<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_success.jsp' starting page</title>
    
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
   <P style="color: red; font-size: 12px; margin-left: 45%;">登陆成功</P>
   <div style="margin-left:35%; width: 600px;height: 200px; margin-top: 100px;">
   		<a href="user_replenish.jsp">完善个人资料？</a>
   		<a href="user/Select_user_Servlet?id=${idlist }">查看个人资料</a>
   		<a href="user/Select_All_UserServlet">查看全部人员资料</a>
   </div>
  </body>
</html>
