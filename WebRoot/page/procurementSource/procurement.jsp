<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();     
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html>
<html lang="en">
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
<link rel="stylesheet" href="<%=path %>/webres/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=path %>/webres/assets/css/jquery.gritter.css" />

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
	<form id="searchForm" action=""></form>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed');}catch(e){}
			</script>

		<div class="main-container-inner">

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed');}catch(e){}
					</script>


				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed');}catch(e){}
					</script>
			</div>
			<div class="page-content">
				<div class="row" id="wi">
					<div>
						<p>
							<button id="gritter-without-image">Without Image</button>
						</p>
					</div>
					<!-- /span -->
					<!-- Button trigger modal -->
					<a href="#modal-form" role="button" class="blue"
						data-toggle="modal" id="modala"> Form Inside a Modal Box </a>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div id="dialog-warring" class="hide">
							<p>请选择计划!</p>

						</div>
						<div id="dialog-confirm" class="hide">
							<div class="alert alert-info bigger-110">These items will
								be permanently deleted and cannot be recovered.</div>

							<div class="space-6"></div>

							<p class="bigger-110 bolder center grey">
								<i class="icon-hand-right blue bigger-120"></i> Are you sure?
							</p>
						</div>
						<!-- #dialog-confirm -->
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
						<script type="text/javascript">
						var $path_base = "/";//this will be used in gritter alerts containing images
					</script>
						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				
				<!-- /.row -->
				<div class="row">
					<div id="modal-form" class="modal fade bs-example-modal-lg"
						tabindex="-1" data-backdrop="static">
						<div class="modal-dialog" style="width:800px;">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="blue bigger">
										采购寻源 <small>共选择 [ <span id="caigouplanNum">--</span> ]
											条计划
										</small>
									</h4>
								</div>

								<div class="modal-body overflow-visible">
									<div class="row">
										<form class="form-horizontal" role="form">
											<div class="col-sm-6">
												<div class="control-group">
												<label class="control-label bolder blue">采购</label>
												<div class="form-group">
													<label for="bnumber" class="col-sm-4 control-label">包号</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="bnumber"
															placeholder="包号"/>
													</div>
												</div>
												<div class="form-group">
													<label for="fnumber" class="col-sm-4 control-label">方案号</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="fnumber"
															placeholder="方案号" />
													</div>
												</div>
												<div class="form-group">

													<label for="procurementname" class="col-sm-4 control-label">方案名称</label>
													<div class="col-sm-8">
														<input type="text" class="form-control"
															id="procurementname" placeholder="方案名称" />

													</div>
												</div>
												<div class="form-group">
													<label for="procurementcreatedate"
														class="col-sm-4 control-label">创建日期</label>
													<div class="col-sm-8">
													<span style="position: relative; z-index: 9999;">
														<div class="input-group">
															<input class="form-control date-picker" id="procurementcreatedate" type="text" data-date-format="yyyy-mm-dd" />
															<span class="input-group-addon"> 
															<i class="icon-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label for="procurementauditdate"
														class="col-sm-4 control-label">通过日期</label>
													<div class="col-sm-8">
													<span style="position: relative; z-index: 9999;">
														<div class="input-group">
															<input class="form-control date-picker"
																id="procurementauditdate" type="text"
																data-date-format="yyyy-mm-dd" /> <span
																class="input-group-addon"> <i
																class="icon-calendar bigger-110"></i>
															</span>
														</div>
														</span>
													</div>
												</div>
											</div>
											</div>
											<div class="col-sm-6">
												<div class="control-group">
												<label class="control-label bolder blue">寻源</label>
												<div class="form-group">
													<label for="searchannounceddate" class="col-sm-4 control-label">寻源单价</label>
													<div class="col-sm-8">
															<input type="text" class="form-control" id="searchprice"
															placeholder="寻源单价"/>
													
													</div>
												</div>
												<div class="form-group">
													<label for="searchauditdate"
														class="col-sm-4 control-label">寻源金额</label>
													<div class="col-sm-8">
															<input type="text" class="form-control" id="searchmoney"
															placeholder="寻源金额"/>
													</div>
												</div>
												<div class="form-group">
													<label for="searchannounceddate"
														class="col-sm-4 control-label">开标日期</label>
													<div class="col-sm-8">
													<span style="position: relative; z-index: 9999;">
														<div class="input-group">
															<input class="form-control date-picker"
																id="searchannounceddate" type="text"
																data-date-format="yyyy-mm-dd" /> <span
																class="input-group-addon"> <i
																class="icon-calendar bigger-110"></i>
															</span>
														</div>
														</span>
													</div>
												</div>
												<div class="form-group">
													<label for="searchauditdate"
														class="col-sm-4 control-label">结果审过日期</label>
													<div class="col-sm-8">
													<span style="position: relative; z-index: 9999;">
														<div class="input-group">
															<input class="form-control date-picker"
																id="searchauditdate" type="text"
																data-date-format="yyyy-mm-dd"/> <span
																class="input-group-addon"> <i
																class="icon-calendar bigger-110"></i>
															</span>
														</div>
														</span>
													</div>
												</div>
												</div>
											</div>
											<div class="col-sm-12">
												<div class="form-group">
														<label for="procurementwaycode" class="col-sm-2 control-label">采购方式</label>
														<div class="col-sm-10">
														<div class="row">
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="procurementwaycode" type="radio" class="ace" value="10"/>
																<span class="lbl">公开招标</span>
															</label>
														</div>
														</div>
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="procurementwaycode" type="radio" class="ace" value="50"/>
																<span class="lbl">邀请招标</span>
															</label>
														</div>
														</div>
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="procurementwaycode" type="radio" class="ace" value="20"/>
																<span class="lbl">单一来源</span>
															</label>
														</div>
														</div>
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="procurementwaycode" type="radio" class="ace" value="40"/>
																<span class="lbl">竞争性谈判</span>
															</label>
														</div>
														</div>
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="procurementwaycode" type="radio" class="ace" value="30"/>
																<span class="lbl">询比价</span>
															</label>
														</div>
														</div>
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="procurementwaycode" type="radio" class="ace" value="60"/>
																<span class="lbl">框架合同</span>
															</label>
														</div>
														</div>
														</div>
													</div>
												</div>
												</div>
												
												<div class="col-sm-12">
												<div class="form-group">
														<label for="executionwaycode" class="col-sm-2 control-label">合同执行方式</label>
														<div class="col-sm-10">
														<div class="row">
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="executionwaycode" type="radio" class="ace" value="10"/>
																<span class="lbl">统谈统签统付</span>
															</label>
														</div>
														</div>
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="executionwaycode" type="radio" class="ace" value="20"/>
																<span class="lbl">统谈统签分付</span>
															</label>
														</div>
														</div>
														<div class="col-sm-3">
														<div class="radio">
															<label>
																<input name="executionwaycode" type="radio" class="ace" value="30"/>
																<span class="lbl">统谈分签</span>
															</label>
														</div>
														</div>
														
														</div>
													</div>
												</div>
												</div>
										</form>
									</div>
								</div>

								<div class="modal-footer">
									<button class="btn btn-sm" data-dismiss="modal" id="cancelButton">
										<i class="icon-remove"></i> Cancel
									</button>

									<button class="btn btn-sm btn-primary" id="saveButton">
										<i class="icon-ok"></i> Save
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-container-inner -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->
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
	<script src="<%=path%>/webres/assets/js/bootstrap.min.js"></script>
	<script src="<%=path%>/webres/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="<%=path%>/webres/assets/js/jquery-ui-1.10.3.full.min.js"></script>
	<script src="<%=path%>/webres/assets/js/chosen.jquery.min.js"></script>
	<script src="<%=path%>/webres/assets/js/fuelux/fuelux.spinner.min.js"></script>
	<script src="<%=path%>/webres/assets/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="<%=path%>/webres/assets/js/jquery.autosize.min.js"></script>
	<script src="<%=path%>/webres/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
	<script src="<%=path%>/webres/assets/js/jquery.maskedinput.min.js"></script>
	<script src="<%=path%>/webres/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
	<script src="<%=path%>/webres/assets/js/jqGrid/i18n/grid.locale-en.js"></script>

	<!-- ace scripts -->

	<script src="<%=path%>/webres/assets/js/ace-elements.min.js"></script>
	<script src="<%=path%>/webres/assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script src="<%=path%>/webres/js/jquery.json-2.3.min.js"></script>

	<script src="<%=path%>/webres/assets/js/bootbox.min.js"></script>
	<script src="<%=path%>/webres/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=path%>/webres/assets/js/spin.min.js"></script>
	<script src="<%=path%>/webres/assets/js/jquery.gritter.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {

		
				$("#wi").hide();
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
				var parentMainHeight = window.parent.document.documentElement.clientHeight;
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
					
					url: '<%=path%>/plan/plan_procurementInit.action',
					datatype: "json",
					//datatype: "local",
					//data: grid_data,
					cellEdit:false,
					mtype: 'POST',
					height: parentMainHeight-220,
					colNames:[' ','包号','方案号','购物车编号','购物车行号','方案名称','创建日期','通过日期','采购方式','寻源单价','寻源金额','开标日期','审核日期','执行方式','计划编号', '计划行号', '接收日期','物料编码', '物料描述','计划数量','计量单位','单价','金额','交货日期','交货地址','planno','planstatus','invalid'],
					colModel:[
						{name:'planno',index:'', width:70, fixed:true, resize:false,
							formatter:'actions',
							formatoptions:{
								keys:true,
								delOptions:{
									
								},
								//editformbutton:true,
								editOptions:{
									recreateForm: true,
									beforeShowForm:beforeEditCallback,
									url:'<%=path%>/plan/plan_save.action',
									mtype:'POST'
								},
								extraparam: {
									"plan.planno":getNo,
									"plan.planstatus":getPlanstatus,
									"plan.invalid":getInvalid,
									"plan.bnumber":getBnumber,
									"plan.fnumber":getFnumber
								}
							}
						},
						{name:'bnumber',index:'bnumber', width:160,editable: true},
						{name:'fnumber',index:'fnumber', width:160,editable: true},
						{name:'cartcode',index:'cartcode', width:160},
						{name:'cartlinenum',sorttype:"int",index:'cartlinenum',width:50,searchrules:{"required":true, "number":true, "maxValue":4}},
						{name:'procurementname',index:'procurementname', width:160,editable: true},
						{name:'procurementcreatedate',index:'procurementcreatedate', width:160,editable: true, sorttype:"date",unformat: pickDate},
						{name:'procurementauditdate',index:'procurementauditdate', width:160,editable: true, sorttype:"date",unformat: pickDate},
						{name:'procurementwaycode',index:'procurementwaycode', width:160,editable: true},
						{name:'searchprice',index:'searchprice', width:160,editable: true},
						{name:'searchmoney',index:'searchmoney', width:160,editable: true},
						{name:'searchannounceddate',index:'searchannounceddate', width:160,editable: true, sorttype:"date",unformat: pickDate},
						{name:'searchauditdate',index:'searchauditdate', width:160,editable: true, sorttype:"date",unformat: pickDate},
						{name:'executionwaycode',index:'executionwaycode', width:160,editable: true},
						{name:'oldplannum',index:'oldplannum', width:150,editoptions:{size:"20",maxlength:"30"}},
						{name:'oldplanlinenum',index:'oldplanlinenum',sorttype:"int", width:50,editoptions:{size:"20",maxlength:"30"}},
						{name:'receiptdate',index:'receiptdate', width:80, sorttype:"date",unformat: pickDate},
						{name:'itemscode',index:'itemscode', width:160},
						{name:'itemsname',index:'itemsname', sortable:false,width:160},
						{name:'plannum',index:'plannum', sorttype:"int",width:50,editoptions:{size:"20",maxlength:"30"}},
						{name:'unit',index:'unit', width:50, sortable:false,editoptions:{size:"20",maxlength:"30"}},
						{name:'planprice',index:'planprice', sorttype:"int",width:50,editoptions:{size:"20",maxlength:"30"}},
						{name:'planmoney',index:'planmoney',sorttype:"int", width:60,editoptions:{size:"20",maxlength:"30"}},
						{name:'arrivaldate',index:'arrivaldate', width:80,sorttype:"date",unformat: pickDate},
						{name:'arrivaladdr',index:'arrivaladdr', width:160, sortable:false,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
						{name:'planno',hidden:true},
						{name:'planstatus',hidden:true},
						{name:'invalid',hidden:true}
						
					], 
					//footerrow: true,
					jsonReader: {
						root: "pageList",
						total: "totalpages",
						page: "offset",
						records: "totalNum",
						repeatitems: false
					},
					prmNames:{
						page:"pager.offset",// 表示请求页码的参数名称
						rows:"pager.pageSize",// 表示请求行数的参数名称
						sort: "sidx", // 表示用于排序的列名的参数名称
						order: "sord", // 表示采用的排序方式的参数名称
						search:"_search", // 表示是否是搜索请求的参数名称
						nd:"nd", // 表示已经发送请求的次数的参数名称
						id:"id", // 表示当在编辑数据模块中发送数据时，使用的id的名称
						oper:"oper", // operation参数名称
						editoper:"editoper", // 当在edit模式中提交数据时，操作的名称
						addoper:"addoper", // 当在add模式中提交数据时，操作的名称
						deloper:"deloper", // 当在delete模式中提交数据时，操作的名称
						subgridid:"id", // 当点击以载入数据到子表时，传递的数据名称
						npage: null,
						cartcode:"no",
						totalrows:"totalrows" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal
					},
					cellLayout:0,//IE9下水平滚动条的问题
					viewrecords : true,
					rowNum:50,
					rowList:[10,20,30],
					pager : pager_selector,
					altRows: true,
					//toppager: true,
					colTotals: true,
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
					rownumbers:true,
					loadComplete : function() {//完成服务器请求后，回调函数
						var table = this;
						setTimeout(function(){
							styleCheckbox(table);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
					scroll:1,//滚动加载
					editurl: "<%=path%>/plan/plan_save.action",
					caption: "采购寻源",
					shrinkToFit:false,
					autowidth: true
					
				});
				//enable search/filter toolbar
				//jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true});
				
				//switch element when editing inline
				function aceSwitch( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=checkbox]')
								.wrap('<label class="inline" />')
							.addClass('ace ace-switch ace-switch-5')
							.after('<span class="lbl"></span>');
					}, 0);
				}
				//enable datepicker
				function pickDate( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=text]')
								.datepicker({format:'yyyymmdd' , autoclose:true}); 
					}, 0);
				}
			
			
				//navButtons
				jQuery(grid_selector).jqGrid('navGrid',pager_selector,
					{ 	//navbar options
						edit: true,
						editicon : 'icon-pencil blue',
						add: false,
						//addicon : 'icon-plus-sign purple',
						del: false,
						//delicon : 'icon-trash red',
						search: true,
						searchicon : 'icon-search orange',
						refresh: true,
						refreshicon : 'icon-refresh green',
						//view: true,
						//viewicon : 'icon-zoom-in grey',
					},
					{
						//edit record form
						closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
							style_edit_form(form);
						},
						url:'<%=path%>/plan/plan_save.action',
						mtype:'POST',
						editData:{
							//"plan.planno":getNo,
							"plan.planstatus":getPlanstatus,
							"plan.invalid":getInvalid,
							"nos":getNos
						}
					},
					{},
					{},
					{
						//search form
						recreateForm: true,
						afterShowSearch: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />');
							style_search_form(form);
						},
						afterRedraw: function(){
							style_search_filters($(this));
						},
						multipleSearch: true,
						closeAfterSearch :true,
						closeAfterReset : true,
						closeOnEscape : true,
						caption: "查找",
					    Find: "查询",
					    Reset: "清除条件",
					    odata: [{ oper:'eq', text:'='},{ oper:'ne', text:'!='},{ oper:'lt', text:'<'},{ oper:'le', text:'<='},{ oper:'gt', text:'>'},{ oper:'ge', text:'>='},{ oper:'', text:''},{ oper:'', text:''},{ oper:'', text:''},{ oper:'', text:''},{ oper:'', text:''},{ oper:'', text:''},{ oper:'cn', text:'like'},{ oper:'', text:''}],
					    groupOps: [ { op: "AND", text: "满足所有" }, { op: "OR", text: "满足任一" } ]
						//multipleGroup:true,
						//showQuery: true
					}
				).navSeparatorAdd(pager_selector,{
				sepclass:"ui-separator",
				sepcontent :""
				
				}).jqGrid('navButtonAdd',pager_selector,{
					caption:"采购",
					//buttonicon :none,
					onClickButton :myoncaigoufuncs,
					//position :"first",
					title :"采购寻源",
					cursor :"",
					id :"caigou"
				});
				
				
				//自定义分隔符
				//$("#grid_id").navSeparatorAdd('#pager',{sepclass:"",sepcontent :""});
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field 
					
					form.find('input[name=procurementcreatedate]').datepicker({format:'yyyymmdd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
					form.find('input[name=procurementauditdate]').datepicker({format:'yyyymmdd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
					form.find('input[name=searchannounceddate]').datepicker({format:'yyyymmdd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
					form.find('input[name=searchauditdate]').datepicker({format:'yyyymmdd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
					//update buttons classes
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>');
					
					buttons = form.next().find('.navButton a');
					buttons.find('.ui-icon').remove();
					buttons.eq(0).append('<i class="icon-chevron-left"></i>');
					buttons.eq(1).append('<i class="icon-chevron-right"></i>');
					
					form.find('input[name=bnumber]').attr("name","plan.bnumber");
					form.find('input[name=fnumber]').attr("name","plan.fnumber");
				}
			
				function style_delete_form(form) {
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>');
				}
				
				function style_search_filters(form) {
					form.find('.delete-rule').val('X');
					form.find('.add-rule').addClass('btn btn-xs btn-primary');
					form.find('.add-group').addClass('btn btn-xs btn-success');
					form.find('.delete-group').addClass('btn btn-xs btn-danger');
				}
				function style_search_form(form) {
					var dialog = form.closest('.ui-jqdialog');
					var buttons = dialog.find('.EditTable');
					buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
					buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
					buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
				}
				
				function beforeDeleteCallback(e) {
					//alert("beforeDeleteCallback");
					var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
					style_delete_form(form);
					
					form.data('styled', true);
				}
				//var errorCallback = function(){
				//	alert(1);
				//};
				function beforeEditCallback(e) {
					//alert("beforeEditCallback");
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
					style_edit_form(form);
				}
			
				//it causes some flicker when reloading or navigating grid
				//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
				//or go back to default browser checkbox styles for the grid
				function styleCheckbox(table) {
				/**
					$(table).find('input:checkbox').addClass('ace')
					.wrap('<label />')
					.after('<span class="lbl align-top" />');
			
			
					$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
					.find('input.cbox[type=checkbox]').addClass('ace')
					.wrap('<label />').after('<span class="lbl align-top" />');
				*/
				}
				//unlike navButtons icons, action icons in rows seem to be hard-coded
				//you can change them like this in here if you want
				function updateActionIcons(table) {
					/**
					var replacement = 
					{
						'ui-icon-pencil' : 'icon-pencil blue',
						'ui-icon-trash' : 'icon-trash red',
						'ui-icon-disk' : 'icon-ok green',
						'ui-icon-cancel' : 'icon-remove red'
					};
					$(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
					*/
				}
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
						'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
						'ui-icon-seek-next' : 'icon-angle-right bigger-140',
						'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					});
				}
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
				
				$('#gritter-regular').on(ace.click_event, function(){
					$.gritter.add({
						title: 'This is a regular notice!',
						text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="blue">magnis dis parturient</a> montes, nascetur ridiculus mus.',
						image: $path_assets+'/avatars/avatar1.png',
						sticky: false,
						time: '',
						class_name: (!$('#gritter-light').get(0).checked ? 'gritter-light' : '')
					});
			
					return false;
				});
			
				$('#gritter-without-image').on(ace.click_event, function(){
					$.gritter.add({
						// (string | mandatory) the heading of the notification
						title: 'Congratulation!',
						// (string | mandatory) the text inside the notification
						text: '操作成功',
						class_name: 'gritter-success' + ('')
					});
					return false;
				});
				$('#saveButton').click(function(){
					
					//alert(1);
					doProcurement();
				});
				//chosen plugin inside a modal will have a zero width because the select element is originally hidden
				//and its width cannot be determined.
				//so we set the width after modal is show
				$('#modal-form').on('shown.bs.modal', function () {
					//$(this).find('.chosen-container').each(function(){
					//	$(this).find('a:first-child').css('width' , '20px');
					//	$(this).find('.chosen-drop').css('width' , '20px');
					//	$(this).find('.chosen-search input').css('width' , '10px');
					//});
					//alert("2015-15-11".replace(/-/gm,""));
					//$("input[name=jizai]:eq(0)").attr("checked",'checked');
					$(this).find('input[id="bnumber"]').val(getmodalBnumber());
					$(this).find('input[id="fnumber"]').val(getmodalFnumber());
					$(this).find('input[id="procurementname"]').val(getmodalprocurementname());
					$(this).find('input[id="procurementcreatedate"]').val(getmodalprocurementcreatedate());
					$(this).find('input[id="procurementauditdate"]').val(getmodalprocurementauditdate());
					var pwc = getmodalprocurementwaycode();
					$(this).find('input[name="procurementwaycode"][value='+pwc+']').attr("checked",'checked');
					$(this).find('input[id="searchprice"]').val(getmodalsearchprice());
					$(this).find('input[id="searchmoney"]').val(getmodalsearchmoney());
					$(this).find('input[id="searchannounceddate"]').val(getmodalsearchannounceddate());
					$(this).find('input[id="searchauditdate"]').val(getmodalsearchauditdate());
					var ewc = getmodalexecutionwaycode();
					$(this).find('input[name="executionwaycode"][value='+ewc+']').attr("checked",'checked');
				});
				/**
				//or you can activate the chosen plugin after modal is shown
				//this way select element becomes visible with dimensions and chosen works as expected
				$('#modal-form').on('shown', function () {
					$(this).find('.modal-chosen').chosen();
				})
				*/
				$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
		});
		</script>
	<script type="text/javascript">
			$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {_title : function(title) {
				var $title = this.options.title || '&nbsp;';
				if (("title_html" in this.options) && this.options.title_html == true)
					title.html($title);
				else
					title.text($title);
			}
			}));

			function myoncaigoufuncs() {
				if (check()) {
					var pn = getNos();
					$("#caigouplanNum").text(pn.length);
					$("#modala").click();
					
				}
			}
			$("#myButton").click(function(){
				     	 var $btn = $(this).button('loading');
				         $btn.delay(1000).queue(function() {
				          $(this).button('reset');
				         });        
			});
			var doProcurement = function(){
				//var obj = jQuery.parseJSON('{"name":"John"}');  
				//alert($("input:radio[name=procurementwaycode]:checked").val());
				var params = jQuery.toJSON(getNos());
				var url = "<%=path%>/procurement/proc_save.action";
				$.ajax({
					url:url,
					data:{
						"nos":params,
						"procurementSource.bnumber":$("#bnumber").val(),
						"procurementSource.fnumber":$("#fnumber").val(),
						"procurementSource.procurementname":$("#procurementname").val(),
						"procurementSource.procurementwaycode":$("input:radio[name=procurementwaycode]:checked").val(),
						"procurementSource.procurementcreatedate":$("#procurementcreatedate").val().replace(/-/gm,""),
						"procurementSource.procurementauditdate":$("#procurementauditdate").val().replace(/-/gm,""),
						"procurementSource.searchannounceddate":$("#searchannounceddate").val().replace(/-/gm,""),
						"procurementSource.searchauditdate":$("#searchauditdate").val().replace(/-/gm,""),
						"procurementSource.executionwaycode":$("input:radio[name=executionwaycode]:checked").val(),
						"plan.searchprice":$("#searchprice").val(),
						"plan.searchmoney":$("#searchmoney").val()
					},
					type:"POST",
					datatype:"json",
					cache:false,
					error:function(textStatus,errorThrown){
						alert("系统交互错误: " + textStatus+"<br>errorThrown:"+errorThrown);
					},
					success:function(data,textStatus){
						//alert("系统ajax success");
						$("#cancelButton").click();
						var url='<%=path%>/plan/plan_procurementInit.action';
							jQuery("#grid-table").setGridParam({
								url : url
							}).trigger("reloadGrid");
							$("#gritter-without-image").click();
						}
					});

		};

		// 获取jqGrid中选中行的planno
		var getNo = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.planno;
		};
		var getPlanstatus = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.planstatus;
		};
		var getInvalid = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.invalid;
		};
		var getFnumber = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			return $("#" + selectedId + "_fnumber").val();
		};
		var getBnumber = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			return $("#" + selectedId + "_bnumber").val();
		};
		var getmodalFnumber = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.fnumber;
			//return $("#" + selectedId + "_fnumber").val();
		};
		var getmodalBnumber = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.bnumber;
			//return $("#" + selectedId + "_bnumber").val();
		};
		var getmodalprocurementname = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.procurementname;
			//return $("#" + selectedId + "_fnumber").val();
		};
		var getmodalprocurementcreatedate = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.procurementcreatedate;
			//return $("#" + selectedId + "_bnumber").val();
		};
		var getmodalprocurementauditdate = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.procurementauditdate;
			//return $("#" + selectedId + "_fnumber").val();
		};
		var getmodalprocurementwaycode = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.procurementwaycode;
			//return $("#" + selectedId + "_bnumber").val();
		};
		var getmodalsearchprice = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.searchprice;
			//return $("#" + selectedId + "_fnumber").val();
		};
		var getmodalsearchmoney = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.searchmoney;
			//return $("#" + selectedId + "_bnumber").val();
		};
		var getmodalsearchannounceddate = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.searchannounceddate;
			//return $("#" + selectedId + "_bnumber").val();
		};
		var getmodalsearchauditdate = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.searchauditdate;
			//return $("#" + selectedId + "_fnumber").val();
		};
		var getmodalexecutionwaycode = function() {
			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			return rowData.executionwaycode;
			//return $("#" + selectedId + "_bnumber").val();
		};
		var getNos = function() {
			var rowIds = jQuery("#grid-table").jqGrid("getGridParam","selarrrow");
			var nos = [];
			if (rowIds.length > 0) {
				for (var i = 0; i < rowIds.length; i++) {
					var rowData = $("#grid-table").jqGrid("getRowData",rowIds[i]);
					nos[i] = rowData.planno;
				}
			}
			//alert(nos);
			return nos;
		};

		var getSelPlan = function() {

			var selectedId = $("#grid-table").jqGrid("getGridParam", "selrow");
			var rowData = $("#grid-table").jqGrid("getRowData", selectedId);
			alert("rowData: " + rowData.cartcode);
			return rowData;
			// alert("rowData: " + rowData);

		};
		function myontuihuifunc() {
			$("#dialog-confirm")
					.removeClass('hide')
					.dialog(
							{
								resizable : false,
								modal : true,
								title : "<div class='widget-header'><h4 class='smaller'><i class='icon-warning-sign red'></i> Empty the recycle bin?</h4></div>",
								title_html : true,
								buttons : [
										{
											html : "<i class='icon-trash bigger-110'></i>&nbsp;退回",
											"class" : "btn btn-danger btn-xs",
											click : function() {
												$(this).dialog("close");
											}
										},
										{
											html : "<i class='icon-remove bigger-110'></i>&nbsp;取消",
											"class" : "btn btn-xs",
											click : function() {
												$(this).dialog("close");
											}
										} ]
							});
		}
		var check = function() {
			var pn = getNos();
			//alert(pn.length);
			if (pn == "" || pn.length < 1) {

				var dialog = $("#dialog-warring")
						.removeClass('hide')
						.dialog(
								{
									modal : true,
									title : "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i> 提示</h4></div>",
									title_html : true,
									buttons : [ {
										text : "OK",
										"class" : "btn btn-primary btn-xs",
										click : function() {
											$(this).dialog("close");
										}
									} ]
								});
				return false;
			} else {
				return true;
			}

		};
	</script>
</body>
</html>
