<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

   <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui-master/dist/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
 
<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>
  
           
<table class="layui-table" >
  <thead>
    <tr>
      <th lay-data="{field:'id', width:80, sort: true}">账号</th>
      <th lay-data="{field:'username', width:80}">用户名</th>
      <th lay-data="{field:'sex', width:80, sort: true}">密码</th>
      <th lay-data="{field:'city', width:80}">年龄</th>
      <th lay-data="{field:'wealth', width:135, sort: true}">修改</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach var="user" items="${userlist }">
	   		   	<tr>
	   		   	    <th lay-data="{field:'id', width:80, sort: true}">${user.id }</th>
		   		     <td lay-data="{field:'name', width:80, sort: true}">${user.name }</td>
		   		     <td lay-data="{field:'pwd', width:80, sort: true}">${user.pwd }</td>
		   		   	 <td lay-data="{field:'city', width:80}">${user.age }</td>
				     <td lay-data="{field:'wealth', width:135, sort: true}"><a href="update_user.jsp?id=${user.id }" >修改</a></td>
	   		   	</tr>
	</c:forEach>
	 </tbody>
</table>
               
          
<script src="layui-master/dist/layui.js" charset="utf-8"></script>



</body>
</html>
