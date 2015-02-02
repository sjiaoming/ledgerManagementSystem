<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<head>
		<meta charset="utf-8" />
		<title>--</title>
		<!-- basic styles -->
		<link href="<%=path %>/webres/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=path %>/webres/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<link rel="stylesheet" href="<%=path %>/webres/assets/css/jquery-ui-1.10.3.full.min.css" />
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/datepicker.css" />
		
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/chosen.css" />
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/daterangepicker.css" />
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/colorpicker.css" />
		<!-- ace styles -->

		<link rel="stylesheet" href="<%=path %>/webres/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=path %>/webres/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=path %>/webres/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="<%=path %>/webres/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="<%=path %>/webres/assets/js/html5shiv.js"></script>
		<script src="<%=path %>/webres/assets/js/respond.min.js"></script>
		<![endif]-->
	
</head>
<body>
<form  id="form1" name="form1"  action="?" method="post"  enctype="multipart/form-data" target= "hframe">
<input type="hidden" id="uppath" value="<%=path%>" />
<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<div id="successmsg" class="alert alert-success" role="alert">
								  <strong id="successInfo">Well done!</strong>您可以直接进入<a href="index.jsp" class="alert-link">计划管理</a>
								</div>
								<div id="errormsg" class="alert alert-danger" role="alert">
								  <strong id="errorInfo">Oh snap!</strong>导入失败，请稍后重试
								</div>
								<!-- PAGE CONTENT BEGINS -->
								<button id="pupload" type="button" class="btn btn-primary btn-lg btn-block" onclick='formSubmit()'>导入</button>
								<div class="progress">
								  <div id="progressbar" class="progress-bar progress-bar-striped active" role="progressbar" 
								  aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
								    <span id="progress">0%</span> Complete
								  </div>
								</div>
									<div class="row">
										<div class="col-sm-12">
											<div class="widget-box">
												<div class="widget-header">
													<h4>选择导入文件</h4>
													<span class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="icon-chevron-up"></i>
														</a>
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<!-- <input type="file" id="id-input-file-2" />-->
														<input multiple="" type="file" id="id-input-file-3" name="file"/>
													</div>
												</div>
											</div>
										</div>
								</div>
							</div><!-- /.col -->
						</div><!-- /.row -->
						<div class="row">
							<div class="col-xs-12">
							<div id="errorPanel">
								<div class="panel panel-danger">
									<div class="panel-heading">导入错误信息</div>
									<div class="panel-body">
									    <p>errorLineNo:错误行号,col*:错误列</p>
									 </div>
									<div id="errorTable"></div> 
								</div>
							</div> 
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
							<span id="ts"></span>
							<p>
							<span id="tsj"></span>
							</div>
						</div>
					</div><!-- /.page-content -->
			
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
	<iframe name ="hframe" id="hframe" style=" display: none" ></iframe >
</form>

<!-- basic scripts -->

		<!--[if !IE]> -->

			<script src="<%=path %>/webres/javascripts/jquery-2.0.3.min.js"></script>
		<!-- <![endif]-->

		<!--[if IE]>
			<script src="<%=path %>/webres/javascripts/jquery-1.10.2.min.js"></script>
		<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>/webres/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='<%=path %>/webres/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=path %>/webres/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="<%=path %>/webres/assets/js/bootstrap.min.js"></script>
		<script src="<%=path %>/webres/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->
			<script src="<%=path %>/webres/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=path %>/webres/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=path %>/webres/assets/js/jquery.knob.min.js"></script>
		<script src="<%=path %>/webres/assets/js/jquery.autosize.min.js"></script>
		<script src="<%=path %>/webres/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
		<script src="<%=path %>/webres/assets/js/jquery.maskedinput.min.js"></script>
		<script src="<%=path %>/webres/assets/js/bootstrap-tag.min.js"></script>
		<!-- ace scripts -->
		<script src="<%=path %>/webres/assets/js/ace-elements.min.js"></script>
		<script src="<%=path %>/webres/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		
		<script language="javascript" type="text/javascript">
	var callback = function(){
        $.ajax({
            type:"post",
            url:"fileUploadStatus/fileUploadStatus_getUploadStatus.action",
            success:function(msg){
            	
            	if(msg!=null && msg.split("#").length!=2 ){
            		var json = $.parseJSON(msg);
            		if(json!=null){
            				timeout = true;
            				clearUploadStatus();
            		}
            		var htmls=['<table class="table table-condensed">']; 
	            		htmls.push('<thead><tr>');
	            		for(var k in json[0]) 
	            			htmls.push('<th>'+k+'</th>');  
	            		htmls.push('</thead></tr>');
	            		for(var i=0,L=json.length;i<L;i++){
	            			htmls.push('<tbody><tr>');
	            			for(var k in json[i]){
	            				var tempd = json[i][k];
	            				var tempa = tempd==null;
	            				if(tempa)
	            				htmls.push('<td>'+""+'</td>');
	            				else
	            				htmls.push('<td>'+tempd+'</td>');
	            			}
	            			htmls.push('</tbody></tr>'); 
	            		}
	            		htmls.push('</table>'); 
            		$('#errorTable').html(htmls.join(''));
            		$('#successmsg').hide();
            		$('#errorPanel').show();
            	}else{
	            	var percentage = msg.split("#")[1];
	            	$('#progress').text(msg);
	            	$('#progressbar').attr('style',"width:"+percentage);
	            	if(parseFloat(percentage)==parseFloat("100%") ){
	            		timeout = true;
	            		clearUploadStatus();
	            		$('#successmsg').show();
	            	}
            	}
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
            	clearUploadStatus();
            	timeout = true;
            	$('#errorInfo').text("readyState:" + XMLHttpRequest.readyState+"|状态码:" + XMLHttpRequest.status+"|textStatus:" + textStatus+"|errorThrown:" + errorThrown);
            	$('#errormsg').show();
            }
        });  
    }
    var clearUploadStatus = function(){
        $.ajax({
            type:"post",
            url:"fileUploadStatus/fileUploadStatus_clearUploadStatus.action",
            success:function(msg){
            	
            },
            error:function(data){
            	$('#errormsg').show();
            }
        });  
    }
    var timeout = false;
    var planStatus = function(){
    	if(timeout)
    		return;
    	callback();
    	setTimeout(planStatus,100);
    }
    var formSubmit = function(){
    	var temp = document.form1.file.value.split(".")[document.form1.file.value.split(".").length-1];
		var ex;
		var actionName ;
		if('undefined'!=temp&&temp!=""&&temp!=null){
			ex = temp;
			if(ex == 'xls'){
				actionName = "PlanImportServlet?ex=xls";
			}else if(ex == 'xlsx'){
				actionName = "PlanImportServlet?ex=xlsx";
			}else{
				alert("不是有效的excel文件");
			return;
			}
			
		}else{
				alert("不是有效的excel文件");
			return;
		}
		clearUploadStatus();
		$('#pupload').attr("disabled","disabled");
		actionName = $("#uppath").val()+"/"+actionName;
		planStatus();
       	window.form1.action = actionName;
		window.form1.submit();
    }
</script>
<script type="text/javascript">
			jQuery(function($) {
				$('#id-input-file-3').ace_file_input({
					style:'well',
					btn_choose:'Drop files here or click to choose',
					btn_change:null,
					no_icon:'icon-cloud-upload',
					droppable:true,
					thumbnail:'small'//large | fit
					//,icon_remove:null//set null, to hide remove/reset button
					/* ,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					} */
					,before_remove : function() {
						//var file = $("#id-input-file-3");
						//file.after(file.clone().val("")); 
						//file.remove();
						$("#id-input-file-3").val("");
						//alert($("#id-input-file-3").val());
						timeout = false;
						return true;
					}
					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}
			
				}).on('change', function(){
				$('#pupload').attr("disabled",false);
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});
			$('#successmsg').hide();
			$('#errormsg').hide();
			$('#errorPanel').hide();
			});
		</script>
</body>
