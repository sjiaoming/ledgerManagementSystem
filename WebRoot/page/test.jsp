<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'test.jsp' starting page</title>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/webres/assets/css/datepicker.css" />
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=path %>/webres/javascripts/jquery-2.0.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="<%=path%>/webres/assets/js/date-time/bootstrap-datepicker.min.js"></script>

<script type="text/javascript">
	jQuery(function($) {
		$('.span2').datepicker();
		
		//$("#dp3").datepicker();
		
		//$("#dp3").datepicker().on('changeDate', function(ev){
		//	   $(this).datepicker("destroy");
		//});
	});
	
</script>

</head>

<body>
<div class="container">
		
	
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary btn-lg"
			data-toggle="modal" data-target="#myModal">Launch demo modal
		</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<div class="modal-body">
					<span style="position: relative; z-index: 9999;">
					  <input class="span2" size="16" type="text" value="12-02-2012">
					  </span>
</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
