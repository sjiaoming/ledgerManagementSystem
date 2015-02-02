<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		function add(){
			this.form2.action = "res/res_saveRes.action";
			this.form2.submit();
		}
	</script>
  </head>
  
  <body>
  <table><tr><td><input type="button" value="新增"  onclick="add()"></td>

  <table>
  <form name="" action="" method="post" id="form2">  
  	<tr><td>资源名称<input type="text" name="resource.mresourcename"></td></tr>
  	<tr><td>资源标识<input type="text" name="resource.mresourcevalue"></td></tr>
  	<tr><td>资源URL<input type="text" name="resource.mresourceurl"></td></tr>
  	<tr>
  	<td>上级资源
  	<select name="no" style="width:135px;" title="请选择资源">
	      <option value=""> --请选择-- </option>
	      <c:forEach var="flag" items="${parentResources}">
	      	<option value="${flag.mresourceno}"> ${flag.mresourcename} </option>
      	  </c:forEach>
    </select>
	</td>
	</tr>
  </form>
  </table>
    
  </body>
</html>
