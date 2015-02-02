<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function del(){
			this.form1.action = "role/role_deleteRole.action";
			this.form1.submit();
		}
	</script>
  </head>
  
  <body>
  <table><tr>
  <td><input type="button" value="删除" onclick="del();"></td>
  <td><input type="button" value="修改"></td>
  <td><a href="role/role_showAddInput.action">角色新增</a></td>
  </tr></table>
    <table border="1" >
    <form name="" action="" method="post" id="form1">
    	<tr>
    	<td>选择	</td><td>id</td><td>角色名称</td><td>角色标识</td><td>角色操作</td>
    	</tr>
    	<c:forEach var="roles" items="${roles }">
    	<tr>
    	<td><input type="checkbox" name="ids" value="${roles.roleno }"></td>
    	<td>${roles.roleno }</td>
    	<td>${roles.rolename }</td>
    	<td>${roles.rolevalue }</td>
    	<td><a href="role/role_showImpower.action?no=${roles.roleno }">授权</a></td>
    	</tr>
    	 </c:forEach>
    </form>
    </table>
    
  </body>
</html>
