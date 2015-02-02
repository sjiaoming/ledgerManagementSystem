<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
     <form action="user/user_saveUser.action" method="post">
                用户名:<input type="text" name="user.username"><br>
                密 码:<input type="text" name="user.password"><br>
                姓名:<input type="text" name="user.personname"><br>
                部门: <c:forEach var="ds" items="${depts }">
                	【<input type="radio" name="user.fkDeptno" value="${ds.deptno }">${ds.deptname }】
                </c:forEach>
                <br>
                角色:
                <c:forEach var="rs" items="${roles }">
                	【<input type="checkbox" name="nos" value="${rs.roleno }">${rs.rolename }】
                </c:forEach>
        <input type="submit" value="保存">                
     </form>
  </body>
</html>
