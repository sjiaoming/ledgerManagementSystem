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
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div id="dialog-warring" class="hide">
							<p>请选择计划!</p>

						</div>
						<!-- #dialog-message -->
						<div id="dialog-message" class="hide">
							<p>确认领取计划?</p>

							<div class="hr hr-12 hr-double"></div>

							<p>
								共计 [ <b><span id="planNum">--</span></b> ]条计划
							</p>
						</div>
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
					
					url: '<%=path%>/plan/plan_findProcurementPlanByPager.action',
					datatype: "json",
					//datatype: "local",
					//data: grid_data,
					cellEdit:false,
					mtype: 'POST',
					height: parentMainHeight-220,
					colNames:[' ','包号','方案号','购物车编号','购物车行号','计划编号', '计划行号', '接收日期','物料编码', '物料描述','计划数量','计量单位','单价','金额','交货日期','交货地址','planno','planstatus','invalid'],
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
					caption: "计划领取",
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
					caption:"领取",
					//buttonicon :none,
					onClickButton :myonlingqufunc,
					//position :"first",
					title :"领取计划",
					cursor :"",
					id :"lingqu"
				});
				
				
				//自定义分隔符
				//$("#grid_id").navSeparatorAdd('#pager',{sepclass:"",sepcontent :""});
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field 
					
					form.find('input[name=receiptdate]').datepicker({format:'yyyymmdd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
					form.find('input[name=arrivaldate]').datepicker({format:'yyyymmdd' , autoclose:true})
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
				
				$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {_title : function(title) {
				var $title = this.options.title || '&nbsp;';
				if (("title_html" in this.options) && this.options.title_html == true)
					title.html($title);
				else
					title.text($title);
				}
			}));
		});
		</script>
	<script type="text/javascript">
			function myonlingqufunc() {
			if (check()) {
				var pn = getNos();
				$("#planNum").text(pn.length);
				var dialog = $("#dialog-message")
						.removeClass('hide')
						.dialog(
								{
									modal : true,
									title : "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i> 提示</h4></div>",
									title_html : true,
									buttons : [ {
										text : "Cancel",
										"class" : "btn btn-xs",
										click : function() {
											$(this).dialog("close");
										}
									}, {
										text : "OK",
										"class" : "btn btn-primary btn-xs",
										click : function() {
											planReceive();
											$(this).dialog("close");
										}
									} ]
								});
			}
		}
			var planReceive = function(){
				//var obj = jQuery.parseJSON('{"name":"John"}');  
				//alert( obj.name === "John" );
				var params = jQuery.toJSON(getNos());
				var url = "<%=path%>/plan/plan_planReceive.action";
				$.ajax({
					url:url,
					data:{nos:params},
					type:"POST",
					dataType:"json",
					cache:false,
					error:function(textStatus,errorThrown){
						alert("系统ajax交互错误: " + textStatus);
					},
					success:function(data,textStatus){
						alert("系统ajax success"+data.ajaxResult+"----"+textStatus);
						var url='<%=path%>/plan/plan_findProcurementPlanByPager.action';
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
