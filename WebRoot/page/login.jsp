<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="org.springframework.security.web.WebAttributes" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>LMS</title>
	<meta	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"	name="viewport">
	<link href="<%=path %>/webres/stylesheets/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/webres/stylesheets/font-awesome.css" media="all" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/webres/stylesheets/se7en-font.css" media="all" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/webres/stylesheets/style.css" media="all" rel="stylesheet"	type="text/css" />

	<script src="<%=path %>/webres/javascripts/jquery-1.10.2.min.js"	type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery-ui.js"	type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/bootstrap.min.js" type="text/javascript"></script>

  </head>
  
<body class="login1">
	<!-- Login Screen -->
	<div class="login-wrapper">
		<div class="login-container">
			<a href="index.html"><img width="100" height="30"
				src="<%=path %>/webres/images/logo-login%402x.png" /></a>
			<form action="<%=path %>/j_spring_security_check" method="post">
				<div class="form-group">
					<input class="form-control" placeholder="Username"	type="text" name="j_username">
				</div>
				<div class="form-group">
					<input class="form-control" placeholder="Password" type="password" name="j_password">
					<input	type="submit" value="&#xf054;" >
				</div>
				<div class="form-options clearfix">
					<a class="pull-right" href="#">Forgot password?</a>
					<div class="text-left">
						<label class="checkbox"><input type="checkbox"><span>Remember
								me</span></label>
					</div>
				</div>
				<font color=red><b>${SPRING_SECURITY_LAST_EXCEPTION.message }</b></font>
			</form>
		</div>
	</div>
	<!-- End Login Screen -->
	
	<script src="<%=path %>/webres/javascripts/raphael.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.mousewheel.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.vmap.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.vmap.sampledata.js"	type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.vmap.world.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.bootstrap.wizard.js"	type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/fullcalendar.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/gcal.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.dataTables.min.js"	type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/datatable-editable.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.easy-pie-chart.js"	type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/excanvas.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.isotope.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/masonry.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/modernizr.custom.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.fancybox.pack.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/select2.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/styleswitcher.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/wysiwyg.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.inputmask.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.validate.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/bootstrap-fileupload.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/bootstrap-datepicker.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/bootstrap-timepicker.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/bootstrap-colorpicker.js"	type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/bootstrap-switch.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/daterange-picker.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/date.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/morris.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/skycons.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/jquery.sparkline.min.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/fitvids.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/main.js" type="text/javascript"></script>
	<script src="<%=path %>/webres/javascripts/respond.js" type="text/javascript"></script>

</body>
</html>
