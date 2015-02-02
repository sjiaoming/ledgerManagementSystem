<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<li class="active"><a href="<%=path%>/page/test.jsp"
	target="mainframe"> <i class="icon-dashboard"></i> <span
		class="menu-text">工作台 </span>
</a></li>
<li><a class="dropdown-toggle" href="javascript:void(0)"
	target="mainframe"> <i class="icon-desktop"></i> <span
		class="menu-text">系统管理</span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">
		<li><a href="<%=path%>/user/user_findUsersPager.action"
			target="mainframe"> <i class="icon-double-angle-right"></i>用户管理
		</a></li>
		<li><a href="<%=path%>/res/res_showList.action"
			target="mainframe"> <i class="icon-double-angle-right"></i> 资源管理
		</a></li>
		<li><a href="<%=path%>/role/role_showList.action"
			target="mainframe"> <i class="icon-double-angle-right"></i> 角色管理
		</a></li>

	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-list"></i> <span
		class="menu-text"> 业务管理 </span> <b class="arrow icon-angle-down"></b>
</a>
	<ul class="submenu">
		<li><a href="<%=path%>/page/plan/import_input.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i> 计划导入
		</a></li>
		<li><a href="<%=path%>/page/plan/index.jsp" target="mainframe">
				<i class="icon-double-angle-right"></i> 计划管理
		</a></li>
		<li><a href="<%=path%>/page/procurementSource/index.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i> 计划领取
		</a></li>
		<li><a href="<%=path%>/page/procurementSource/procurement.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i> 采购寻源
		</a></li>
	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-edit"></i> <span
		class="menu-text"> 合同台帐管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">

		<li><a href="<%=path%>/page/cgcontract/index.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i>
				生成采购合同
		</a></li>
		<li><a href="<%=path%>/page/cgcontract/cglist.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i>
				采购合同管理
		</a></li>
		<li><a href="<%=path%>/page/xscontract/index.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i>
				生成销售合同
		</a></li>
		<li><a href="<%=path%>/page/xscontract/xslist.jsp"
			target="mainframe"> <i class="icon-double-angle-right"></i>
				销售合同管理
		</a></li>
	</ul></li>
<li><a href="javascript:void(0)" target="mainframe"
	class="dropdown-toggle"> <i class="icon-list-alt"></i> <span
		class="menu-text"> 报表管理 </span> <b class="arrow icon-angle-down"></b>
</a>

	<ul class="submenu">
		<li><a href="view/userinfo/userinfo_add.jsp" target="mainframe">
				<i class="icon-double-angle-right"></i> 计划执行明细表
		</a></li>
		<li><a href="userInfListServlet" target="mainframe"> <i
				class="icon-double-angle-right"></i> 提报单位明细表
		</a></li>

	</ul></li>

