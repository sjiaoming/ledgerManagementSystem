<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="pg" uri="/WEB-INF/lib/pager-taglib.jar" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	function del(){
  		
  		var ids = document.getElementsByName("nos");
  		alert(ids.length);
  		this.form.action = "user/user_deleteUsers.action";
  		this.form.submit();
  	}
  </script>
  
  <body>
 
    <table border="1">
    当前用户:${user.username }<p>
    <a href="<%=path %>/user/user_index.action" >ADD</a>
     <form action="user/user_deleteUsers.action" method="post">
    	 <input type="submit" value="del" />
      <tr>
      	<td width="100"></td>
        <td width="100">ID</td>
        <td width="100">用户名</td>
        <td width="100">密码</td>
        <td width="100">角色</td>
        <td width="100">姓名</td>
        <td width="100">部门No</td>
        <td width="100">状态</td>
        <td width="100">操作</td>
      </tr>
		
      <c:forEach items="${pager.pageList }" var="ss">
       <tr>
       <td width="100"><input type="checkbox" name="nos" value="${ss.userno }"></td>
        <td width="100">${ss.userno }</td>
        <td width="100">${ss.username }</td>
         <td width="100">${ss.password }</td>
         <td width="100">
			<c:forEach var="rls" items="${ss.roleVOs }">
			【${rls.rolename }】
			</c:forEach>
		</td>
		<td width="100">${ss.personname }</td>
		<td width="100">${ss.fkDeptno }</td>
		<td width="100">${ss.invalid }</td>
         <td width="100">--</td>
      </tr>
      </c:forEach>
      </form>
      <tr>
      	<td width="400" colspan="4">
      		<pg:pager items="${pager.totalNum }" maxIndexPages="5" maxPageItems="5" url="user/user_findUsersPager.action"
      		export="currentPageNo = pageNumber">
      			<pg:first>
      				<a href="${pageUrl }">首页</a>
      			</pg:first>
      			<pg:prev>
      				<a href="${pageUrl }">上一页</a>
      			</pg:prev>
      			<pg:pages>
      				<c:choose>
      					<c:when test="${currentPageNo eq pageNumber }">
      						<b>${pageNumber }</b>
      					</c:when>
      					<c:otherwise>
      					<a href="${pageUrl }">${pageNumber }</a>
      					</c:otherwise>
      				</c:choose>
      				
      			</pg:pages>
      			<pg:next>
      				<a href="${pageUrl }">下一页</a>
      			</pg:next>
      			<pg:last>
      				<a href="${pageUrl }">尾页</a>
      			</pg:last>
      		</pg:pager>
      	</td>
      </tr>
    </table>
  </body>
</html>
