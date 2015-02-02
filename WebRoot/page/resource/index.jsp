<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<script type="text/javascript">
	function del(){
			this.form1.action = "res/res_deleteRes.action";
			this.form1.submit();
		}
	</script>
  </head>
  
  <body>
  <table border="1" >
  <tr><td><input type="button" value="删除" onclick="del();"></td>
  <td><input type="button" value="修改"></td>
  <td><a href="<%=path %>/res/res_showAddInput.action" >ADD</a></td></tr>
  </table>
    <table border="1" >
    <form name="" action="" method="post" id="form1">
    	<tr>
    	<td>选择	</td><td>id</td><td>资源名称</td><td>资源标识</td><td>资源URL</td><td>层级</td>
    	</tr>
    	<c:forEach var="resources" items="${resources }">
    	<tr>
    	<td><input type="checkbox" name="nos" value="${resources.mresourceno }"></td>
    	<td>${resources.mresourceno }</td>
    	<td>${resources.mresourcename }</td>
    	<td>${resources.mresourcevalue }</td>
    	<td>${resources.mresourceurl }</td>
    	<c:choose>
	    	<c:when test="${fn:length(resources.mresourceVOSet)>0 }">
	    		<td><a href="res/res_showListById.action?no=${resources.mresourceno }">查看下级资源</a></td>
	    	</c:when>
	    	<c:otherwise>
	    		<td>没有下级资源</td>
	    	</c:otherwise>
    	</c:choose>
    	</tr>
    	 </c:forEach>
    </form>
    </table>
    
  </body>
</html>
