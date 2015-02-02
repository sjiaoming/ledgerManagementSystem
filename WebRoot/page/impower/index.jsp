<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.iboray.lms.domain.vo.MResourceVO" %>
<%@page import="com.iboray.lms.domain.vo.RoleVO" %>
<%
	List<MResourceVO> rl = (List<MResourceVO>)request.getAttribute("rl");
	//Role role = (Role)request.getAttribute("role");
	List<String> list = (List)request.getAttribute("res_no");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript" language="javascript">
	function sq(){
		this.form1.action = "role/role_impower.action";
		this.form1.submit();
	}
	function getImpower(){
		<%
			if(list !=null && list.size()>0){
				for(int i = 0;i<list.size();i++){
				%>
				document.getElementById('<%=list.get(i)%>').checked = true;
				<%
			}
			}
		%>
	
	}
</script>
</head>

<body onload="getImpower();">
	<table>
	<tr><td><input type="button" value="授权" onclick="sq();"></td></tr>
	<form action="" method="post" name="form1">
	<input type="hidden" name="no" value="${mainBodyId }">
		<c:forEach var="res" items="${rl }">
			<c:if test="${res.mresourceVOParent == null  }">
				<tr>
					<td><input id="${res.mresourceno }" type="checkbox" name="nos" value="${res.mresourceno }">${res.mresourcename}</td>
				</tr>
				<c:forEach var="res1" items="${rl }">
					<c:if test="${res1.mresourceVOParent.mresourceno == res.mresourceno  }">
						<tr>
							<td>---</td>
							<td><input  id="${res1.mresourceno }" type="checkbox" name="nos" value="${res1.mresourceno }">${res1.mresourcename}</td>
						</tr>
						<c:forEach var="res2" items="${rl }">
							<c:if test="${res2.mresourceVOParent.mresourceno == res1.mresourceno  }">
								<tr>
									<td>---</td>
									<td>---</td>
									<td><input  id="${res2.mresourceno }" type="checkbox" name="nos" value="${res2.mresourceno }">${res2.mresourcename}</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</c:if>
		</c:forEach>
	</form>
	</table>
</body>
</html>
