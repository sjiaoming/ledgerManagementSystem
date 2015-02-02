<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'noImpower.jsp' starting page</title>
	<link href="<%=path %>/webres/stylesheets/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/webres/stylesheets/font-awesome.css" media="all" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/webres/stylesheets/se7en-font.css" media="all" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/webres/stylesheets/style.css" media="all" rel="stylesheet"	type="text/css" />
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport">
</head>
  </head>
  
  <body>
  
  <body class="fourofour">
	<!-- Login Screen -->
	<div class="fourofour-container">
		<h1>ERROR</h1>
		<h2>It looks like you're timeout!!!.</h2>
		<a class="btn btn-lg btn-default-outline" href="<%=request.getContextPath()%>/page/login.jsp" target="_top"><i
			class="icon-home"></i>Go to the homepage</a>
	</div>
	<!-- End Login Screen -->
</body>


<script src="<%=path %>/webres/javascripts/jquery-1.10.2.min.js"	type="text/javascript"></script>
<script src="<%=path %>/webres/javascripts/jquery-ui.js"	type="text/javascript"></script>
<script src="<%=path %>/webres/javascripts/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=path %>/webres/javascripts/main.js" type="text/javascript"></script> 
<script src="<%=path %>/webres/javascripts/modernizr.custom.js" type="text/javascript"></script>
<script src="<%=path %>/webres/javascripts/application.js" type="text/javascript"></script>
  </body>
</html>
