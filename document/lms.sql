-- ----------------------------
-- LEDGER_MANAGEMENT_2.0 Table创建文件
-- 适用数据库 mysql5.5
-- 创建日期：2014-11-27
-- 最后编辑日期：2014-05-14
-- 创建人： 史佼明
-- 最后编辑人：史佼明
-- Table数量：
-- 默认字符集 UTF8 -- UTF-8 UNICODE
-- 排序规则 UTF8-GENERAL_CI
-- lm_c 基础信息表
-- lm_a 系统管理表
-- lm_d 业务数据表
-- ----------------------------
use LMS;
-- ----------------------------
-- 1 供应商
-- ----------------------------
DROP TABLE IF EXISTS lm_c_suppliers;
CREATE TABLE lm_c_suppliers(
	id 				int(11) 	NOT NULL 	PRIMARY KEY		AUTO_INCREMENT	COMMENT	'主键',
	suppliersNo		VARCHAR(32)	NOT NULL		UNIQUE			COMMENT	'供应商No',
	suppliersCode	VARCHAR(8)					UNIQUE			COMMENT	'供应商Code',
	suppliersName	VARCHAR(50)	NOT NULL 		UNIQUE 			COMMENT	'供应商名称',
	invalid 		VARCHAR(2)	NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime		VARCHAR(14)	NOT NULL 		 				COMMENT	'创建日期',
	updateTime		VARCHAR(14)	NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='供应商';
-- ----------------------------
-- 2 提报单位
-- ----------------------------
DROP TABLE IF EXISTS lm_c_usecomp;
CREATE TABLE lm_c_usecomp(
	id 					int(11) 	NOT NULL 	PRIMARY KEY		AUTO_INCREMENT	COMMENT	'主键',
	usecompNo			VARCHAR(32)	NOT NULL		UNIQUE		COMMENT	'提报单位No',
	usecompCode			VARCHAR(8)					UNIQUE		COMMENT	'提报单位编码',
	usecompName			VARCHAR(50)	NOT NULL		UNIQUE		COMMENT	'提报单位主名称',
	sortName1			VARCHAR(50)								COMMENT	'提报单位短名称1',
	sortName2			VARCHAR(50)								COMMENT	'提报单位短名称2',
	FK_parentUsecompNo	VARCHAR(32)								COMMENT	'父级提报单位No',
	invalid 			VARCHAR(2)	NOT NULL	DEFAULT '10'	COMMENT	'10启用 20停用',
	createTime			VARCHAR(14)	NOT NULL 		 			COMMENT	'创建日期',
	updateTime			VARCHAR(14)	NOT NULL 		 			COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='提报单位';
CREATE INDEX sortName1 ON lm_c_usecomp(sortName1(10));
CREATE INDEX sortName2 ON lm_c_usecomp(sortName2(10));
-- ----------------------------
-- 3 部门
-- ----------------------------
DROP TABLE IF EXISTS lm_c_dept;
CREATE TABLE lm_c_dept(
	id 				int(11) 		NOT NULL PRIMARY KEY	AUTO_INCREMENT		COMMENT	'主键',
	deptNo			VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'部门No',
	deptCode		VARCHAR(8)		NOT NULL		UNIQUE			COMMENT	'部门编码',
	deptName		VARCHAR(20)		NOT NULL		UNIQUE			COMMENT	'部门名称',
	invalid 		VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime		VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime		VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='部门';
-- ----------------------------
-- 4 用户
-- ----------------------------
DROP TABLE IF EXISTS lm_a_user;
CREATE TABLE lm_a_user(
	id 				int(11) 		NOT NULL 	PRIMARY KEY		AUTO_INCREMENT	COMMENT	'主键',
	userNo			VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'用户编号',
	userName		VARCHAR(10)		NOT NULL		UNIQUE			COMMENT	'用户名称',
	password		VARCHAR(10)		NOT NULL						COMMENT	'用户密码',
	userType		VARCHAR(10)		NOT NULL		DEFAULT '10'	COMMENT	'10用户 20超管',
	personName		VARCHAR(10)		NOT NULL						COMMENT	'人员姓名',
	FK_deptNo		VARCHAR(32)		NOT NULL						COMMENT	'部门编号',
	dataRole 		VARCHAR(2)		NOT NULL		DEFAULT '10'	COMMENT	'10自己 20本部 30全体',
	invalid 		VARCHAR(2)		NOT NULL		DEFAULT '10'	COMMENT	'10启用 20停用',
	createTime		VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime		VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='用户';
CREATE INDEX userName_password ON lm_a_user(userName,password);
CREATE INDEX personName ON lm_a_user(personName);
CREATE INDEX FK_deptNo ON lm_a_user(FK_deptNo);

-- ----------------------------
-- 5 计划
-- ----------------------------
DROP TABLE IF EXISTS lm_d_plan;
CREATE TABLE lm_d_plan(
	id 					int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	planNo				VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'计划编码',
	itemsCode			VARCHAR(20)										COMMENT	'物料编码',
	itemsName			VARCHAR(50)		NOT NULL						COMMENT	'物料名称',
	cartCode			VARCHAR(20)										COMMENT	'购物车编号',
	cartlineNum			int(4)											COMMENT	'购物车行号',
	oldPlanNum			VARCHAR(20)										COMMENT	'原始计划编号',
	oldPlanlineNum		int(4)											COMMENT	'原始计划行号',
	FK_usecompNo		VARCHAR(32)		NOT NULL						COMMENT	'提报单位编码',
	ReceiptDate			VARCHAR(8)		NOT NULL						COMMENT	'计划接收日期',
	unit				VARCHAR(8)		NOT NULL						COMMENT	'计量单位',
	planNum				DOUBLE(15,2)	NOT NULL						COMMENT	'计划数量',
	planPrice			DOUBLE(13,2)	NOT NULL						COMMENT	'计划单价',
	planMoney			DOUBLE(13,2)	NOT NULL						COMMENT	'计划金额',
	arrivalDate			VARCHAR(8)		NOT NULL						COMMENT	'到货日期',
	arrivalAddr			VARCHAR(100)									COMMENT	'到货地址',
	planStatus			VARCHAR(2)		NOT NULL						COMMENT	'10未领取 20已领取 30采购寻源 40采购合同 50销售合同 60挂账 70已付 80开票 90已收 ',
	bNumber				VARCHAR(20)										COMMENT	'包号',
	fNumber				VARCHAR(20)										COMMENT	'方案号',
	FK_dTypeNo			VARCHAR(32)										COMMENT	'用作操作人姓名',
	FK_zTypeNo			VARCHAR(32)										COMMENT	'中类',
	FK_xTypeNo			VARCHAR(32)										COMMENT	'小类',
	searchPrice			DOUBLE(13,2)									COMMENT	'寻源单价',
	searchMoney			DOUBLE(13,2)									COMMENT	'寻源金额',
	FK_procurementNo	VARCHAR(32)										COMMENT	'采购寻源No',
	salesMoney			DOUBLE(13,2)									COMMENT	'销售金额',
	FK_cgContractNo		VARCHAR(32)										COMMENT	'采购合同No',
	FK_xsContractNo		VARCHAR(32)										COMMENT	'销售合同No',
	FK_dlContractNo		VARCHAR(32)										COMMENT	'代理合同No',
	FK_userNo			VARCHAR(32)										COMMENT	'用户No',
	FK_deptNo			VARCHAR(32)										COMMENT	'部门No',
	invalid 			VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime			VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime			VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='计划';
CREATE INDEX itemsCode ON lm_d_plan(itemsCode);
CREATE INDEX itemsName ON lm_d_plan(itemsName);
CREATE INDEX cartCode ON lm_d_plan(cartCode);
CREATE INDEX cartCode_cartlineNum ON lm_d_plan(cartCode,cartlineNum);
CREATE INDEX oldPlanNum ON lm_d_plan(oldPlanNum);
CREATE INDEX oldPlanNum_oldPlanlineNum ON lm_d_plan(oldPlanNum,oldPlanlineNum);
CREATE INDEX FK_usecompNo ON lm_d_plan(FK_usecompNo);
CREATE INDEX ReceiptDate ON lm_d_plan(ReceiptDate);
CREATE INDEX unit ON lm_d_plan(unit);
CREATE INDEX planStatus ON lm_d_plan(planStatus);
CREATE INDEX FK_procurementNo ON lm_d_plan(FK_procurementNo);
CREATE INDEX FK_cgContractNo ON lm_d_plan(FK_cgContractNo);
CREATE INDEX FK_xsContractNo ON lm_d_plan(FK_xsContractNo);
CREATE INDEX FK_dlContractNo ON lm_d_plan(FK_dlContractNo);
CREATE INDEX FK_userNo ON lm_d_plan(FK_userNo);
CREATE INDEX FK_deptNo ON lm_d_plan(FK_deptNo);
CREATE INDEX FK_bNumber ON lm_d_plan(bNumber);
CREATE INDEX FK_fNumber ON lm_d_plan(fNumber);
-- ----------------------------
-- 6 采购寻源
-- ----------------------------
DROP TABLE IF EXISTS lm_d_procurementSource;
CREATE TABLE lm_d_procurementSource(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	procurementNo 			VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'采购寻源No',
	procurementName			VARCHAR(50)		NOT NULL						COMMENT	'采购方案名称',
	procurementWayCode		VARCHAR(2)										COMMENT	'采购方式10公开招标 20单一来源 30询比价 40竞争性谈判 50邀请招标 60框架合同',
	bNumber					VARCHAR(20)										COMMENT	'包号',
	fNumber					VARCHAR(20)										COMMENT	'方案号',
	procurementCreateDate	VARCHAR(8)										COMMENT	'采购方案创建日期',
	procurementAuditDate	VARCHAR(8)										COMMENT	'采购方案审批通过日期',
	searchAnnouncedDate		VARCHAR(8)										COMMENT	'开标日期',
	searchAuditDate			VARCHAR(8)										COMMENT	'寻源结果审批通过日期',
	ExecutionWayCode		VARCHAR(2)										COMMENT	'采购寻源方式10统谈统签统付 20统谈统签分付 30 统谈分签',
	FK_userNo				VARCHAR(32)										COMMENT	'用户No',
	FK_deptNo				VARCHAR(32)										COMMENT	'部门No',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='采购方案';
CREATE INDEX procurementName ON lm_d_procurementSource(procurementName);
CREATE INDEX procurementWayCode ON lm_d_procurementSource(procurementWayCode);
CREATE INDEX bNumber ON lm_d_procurementSource(bNumber);
CREATE INDEX fNumber ON lm_d_procurementSource(fNumber);
CREATE INDEX procurementCreateDate ON lm_d_procurementSource(procurementCreateDate);
CREATE INDEX procurementAuditDate ON lm_d_procurementSource(procurementAuditDate);
CREATE INDEX searchAnnouncedDate ON lm_d_procurementSource(searchAnnouncedDate);
CREATE INDEX searchAuditDate ON lm_d_procurementSource(searchAuditDate);
CREATE INDEX ExecutionWayCode ON lm_d_procurementSource(ExecutionWayCode);
CREATE INDEX FK_userNo ON lm_d_procurementSource(FK_userNo);
CREATE INDEX FK_deptNo ON lm_d_procurementSource(FK_deptNo);
-- ----------------------------
-- 7 采购合同
-- ----------------------------
DROP TABLE IF EXISTS lm_d_cgContract;
CREATE TABLE lm_d_cgContract(
	id 					int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	cgContractNo		VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'合同编号',
	cgContractName		VARCHAR(50)		NOT NULL						COMMENT	'合同名称',
	cgContractNum		VARCHAR(14)		NOT NULL		UNIQUE			COMMENT	'合同号',
	FK_suppliersNo		VARCHAR(32)		NOT NULL						COMMENT	'供应商编号',
	signingDate			VARCHAR(8)		NOT NULL						COMMENT	'签订日期',
	arrivalDate			VARCHAR(8)										COMMENT	'到货日期',
	totalMoney			DOUBLE(13,2)	NOT NULL						COMMENT	'合同总额',
	FK_procurementNo	VARCHAR(32)										COMMENT	'采购寻源编号',
	qualityMoney		DOUBLE(13,2)									COMMENT	'质保金额',
	qualityDate			VARCHAR(8)										COMMENT	'质保日期',
	payed				DOUBLE(13,2)									COMMENT	'已付金额',
	FK_userNo			VARCHAR(32)										COMMENT	'用户No',
	FK_deptNo			VARCHAR(32)										COMMENT	'部门No',
	FK_usecompNo		VARCHAR(32)		NOT NULL						COMMENT	'提报单位编码',
	invalid 			VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime			VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime			VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='采购合同';
CREATE INDEX cgContractName ON lm_d_cgContract(cgContractName);
CREATE INDEX FK_deptNo ON lm_d_cgContract(FK_deptNo);
CREATE INDEX FK_suppliersNo ON lm_d_cgContract(FK_suppliersNo);
CREATE INDEX signingDate ON lm_d_cgContract(signingDate);
CREATE INDEX arrivalDate ON lm_d_cgContract(arrivalDate);
CREATE INDEX FK_procurementNo ON lm_d_cgContract(FK_procurementNo);
CREATE INDEX qualityDate ON lm_d_cgContract(qualityDate);
CREATE INDEX FK_usecompNo ON lm_d_cgContract(FK_usecompNo);
-- ----------------------------
-- 8 销售合同
-- ----------------------------
DROP TABLE IF EXISTS lm_d_xsContract;
CREATE TABLE lm_d_xsContract(
	id 					int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	xsContractNo		VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'合同编号',
	xsContractName		VARCHAR(50)		NOT NULL						COMMENT	'合同名称',
	xsContractNum		VARCHAR(14)		NOT NULL		UNIQUE			COMMENT	'合同号',
	signingDate			VARCHAR(8)		NOT NULL						COMMENT	'签订日期',
	totalMoney			DOUBLE(13,2)	NOT NULL						COMMENT	'合同总额',
	qualityMoney		DOUBLE(13,2)									COMMENT	'质保金额',
	qualityDate			VARCHAR(8)										COMMENT	'质保日期',
	signComp			VARCHAR(50)		NOT NULL						COMMENT	'签订单位',
	salesRate			DOUBLE(5,2)										COMMENT	'销售费率',
	FK_userNo			VARCHAR(32)										COMMENT	'用户No',
	FK_cgContractNo		VARCHAR(32)										COMMENT	'采购No',
	FK_deptNo			VARCHAR(32)										COMMENT	'部门No',
	FK_usecompNo		VARCHAR(32)		NOT NULL						COMMENT	'提报单位编码',
	invalid 			VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime			VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime			VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='销售合同';
CREATE INDEX FK_usecompNo ON lm_d_xsContract(FK_usecompNo);
CREATE INDEX xsContractName ON lm_d_xsContract(xsContractName);
CREATE INDEX signingDate ON lm_d_xsContract(signingDate);
CREATE INDEX qualityDate ON lm_d_xsContract(qualityDate);
CREATE INDEX signComp ON lm_d_xsContract(signComp);
CREATE INDEX FK_userNo ON lm_d_xsContract(FK_userNo);
CREATE INDEX FK_cgContractNo ON lm_d_xsContract(FK_cgContractNo);
CREATE INDEX FK_deptNo ON lm_d_xsContract(FK_deptNo);
-- ----------------------------
-- 9 到货管理
-- ----------------------------
DROP TABLE IF EXISTS lm_d_arrival;
CREATE TABLE lm_d_arrival(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	arrivalNo				VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'到货编号',
	arrivalNumber			DOUBLE(15,2)	NOT NULL						COMMENT	'到货数量',
	arrivalDate				VARCHAR(8)		NOT NULL						COMMENT	'到货日期',
	FK_planNo				VARCHAR(32)		NOT NULL						COMMENT	'计划No',
	FK_cgContractNo			VARCHAR(32)		NOT NULL						COMMENT	'采购合同No',
	FK_userNo				VARCHAR(32)										COMMENT	'用户No',
	invalid 				VARCHAR(2)		NOT NULL		DEFAULT '10'	COMMENT	'10启用 20停用',
	createTime				VARCHAR(20)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(20)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='到货管理';
CREATE INDEX arrivalDate ON lm_d_arrival(arrivalDate);
CREATE INDEX FK_planNo ON lm_d_arrival(FK_planNo);
CREATE INDEX FK_cgContractNo ON lm_d_arrival(FK_cgContractNo);
CREATE INDEX FK_userNo ON lm_d_arrival(FK_userNo);
-- ----------------------------
-- 10 挂账管理
-- ----------------------------
DROP TABLE IF EXISTS lm_d_cgContractCredit;
CREATE TABLE lm_d_cgContractCredit(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	creditNo				VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'挂账编号',
	creditMoney				DOUBLE(13,2)	NOT NULL						COMMENT	'挂账金额',
	creditDate				VARCHAR(8)		NOT NULL						COMMENT	'挂账日期',
	FK_cgContractNo			VARCHAR(32)		NOT NULL						COMMENT	'采购合同No',
	FK_userNo				VARCHAR(32)										COMMENT	'用户No',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='挂账管理';
CREATE INDEX FK_cgContractNo ON lm_d_cgContractCredit(FK_cgContractNo);
CREATE INDEX creditDate ON lm_d_cgContractCredit(creditDate);
-- ----------------------------
-- 11 付款管理
-- ----------------------------
DROP TABLE IF EXISTS lm_d_payed;
CREATE TABLE lm_d_payed(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	payedNo					VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'付款编号',
	payedMoney				DOUBLE(13,2)	NOT NULL						COMMENT	'付款金额',
	payedWay				VARCHAR(2)		NOT NULL						COMMENT	'付款方式10电汇 20承兑',
	payedDate				VARCHAR(8)		NOT NULL						COMMENT	'付款日期',
	FK_cgContractNo			VARCHAR(32)		NOT NULL						COMMENT	'采购合同No',
	FK_userNo				VARCHAR(32)										COMMENT	'用户No',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='付款管理';
CREATE INDEX payedDate ON lm_d_payed(payedDate);
CREATE INDEX FK_cgContractNo ON lm_d_payed(FK_cgContractNo);
-- ----------------------------
-- 12 开票管理
-- ----------------------------
DROP TABLE IF EXISTS lm_d_billing;
CREATE TABLE lm_d_billing(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	billingNo				VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'开票编号',
	billingMoney			DOUBLE(13,2)	NOT NULL						COMMENT	'开票金额',
	billingDate				VARCHAR(8)		NOT NULL						COMMENT	'开票日期',
	billingNumber			DOUBLE(15,2)	NOT NULL						COMMENT	'开票数量',
	FK_xsContractNo			VARCHAR(32)		NOT NULL						COMMENT	'销售No',
	FK_arrivalNo			VARCHAR(32)										COMMENT	'到货No',
	FK_userNo				VARCHAR(32)										COMMENT	'用户No',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='开票管理';
CREATE INDEX billingDate ON lm_d_billing(billingDate);
CREATE INDEX FK_xsContractNo ON lm_d_billing(FK_xsContractNo);
CREATE INDEX FK_arrivalNo ON lm_d_billing(FK_arrivalNo);
-- ----------------------------
-- 13 收款管理
-- ----------------------------
DROP TABLE IF EXISTS lm_d_received;
CREATE TABLE lm_d_received(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	receivedNo				VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'收款编号',
	receivedMoney			DOUBLE(13,2)	NOT NULL						COMMENT	'收款金额',
	receivedWay				VARCHAR(2)		NOT NULL						COMMENT	'收款方式10电汇 20承兑',
	receivedDate			VARCHAR(8)		NOT NULL						COMMENT	'收款日期',
	FK_xsContractNo			VARCHAR(32)		NOT NULL						COMMENT	'销售No',
	FK_userNo				VARCHAR(32)										COMMENT	'用户No',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='收款管理';
CREATE INDEX receivedDate ON lm_d_received(receivedDate);
CREATE INDEX FK_xsContractNo ON lm_d_received(FK_xsContractNo);
-- ----------------------------
-- 14 用户&角色
-- ----------------------------
DROP TABLE IF EXISTS lm_a_userRole;
CREATE TABLE lm_a_userRole(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	FK_userNo				VARCHAR(32)		NOT NULL						COMMENT	'用户编号',
	FK_roleNo				VARCHAR(32)		NOT NULL						COMMENT	'角色编号',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='用户角色';
CREATE INDEX FK_userNo ON lm_a_userRole(FK_userNo);
-- ----------------------------
-- 15 资源&角色
-- ----------------------------
DROP TABLE IF EXISTS lm_a_mresourceRole;
CREATE TABLE lm_a_mresourceRole(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	FK_mresourceNo			VARCHAR(32)		NOT NULL						COMMENT	'资源编号',
	FK_roleNo				VARCHAR(32)		NOT NULL						COMMENT	'角色编号',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='资源角色';
CREATE INDEX FK_mresourceNo ON lm_a_mresourceRole(FK_mresourceNo);
-- ----------------------------
-- 16 资源管理
-- ----------------------------
DROP TABLE IF EXISTS lm_a_mresource;
CREATE TABLE lm_a_mresource(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	mresourceNo				VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'资源编号',
	mresourceName			VARCHAR(20)		NOT NULL						COMMENT	'资源名称',
	mresourceValue			VARCHAR(20)		NOT NULL						COMMENT	'资源标识',
	mresourceUrl			VARCHAR(100)									COMMENT	'资源地址',
	FK_mresourceNo			VARCHAR(32)										COMMENT	'父级资源',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='资源管理';
CREATE INDEX mresourceName ON lm_a_mresource(mresourceName);
CREATE INDEX FK_mresourceNo ON lm_a_mresource(FK_mresourceNo);
-- ----------------------------
-- 17 角色管理
-- ----------------------------
DROP TABLE IF EXISTS lm_a_role;
CREATE TABLE lm_a_role(
	id 						int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	roleNo					VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'角色编号',
	roleName				VARCHAR(20)		NOT NULL						COMMENT	'角色名称',
	roleValue				VARCHAR(20)		NOT NULL						COMMENT	'角色标识',
	invalid 				VARCHAR(2)		NOT NULL	DEFAULT '10'		COMMENT	'10启用 20停用',
	createTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'创建日期',
	updateTime				VARCHAR(14)		NOT NULL 		 				COMMENT	'更新日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='角色管理';
CREATE INDEX roleName ON lm_a_role(roleName);
-- ----------------------------
-- 18 计划变更明细
-- ----------------------------
DROP TABLE IF EXISTS lm_d_planChangeDetails;
CREATE TABLE lm_d_planChangeDetails(
	id 					int(11) 		NOT NULL 	PRIMARY KEY	AUTO_INCREMENT	COMMENT	'主键',
	planChangeNo		VARCHAR(32)		NOT NULL		UNIQUE			COMMENT	'计划编码',
	itemsCode			VARCHAR(20)										COMMENT	'物料编码',
	itemsName			VARCHAR(50)										COMMENT	'物料名称',
	cartCode			VARCHAR(20)										COMMENT	'购物车编号',
	cartlineNum			int(4)											COMMENT	'购物车行号',
	oldPlanNum			VARCHAR(20)										COMMENT	'原始计划编号',
	oldPlanlineNum		int(4)											COMMENT	'原始计划行号',
	FK_usecompNo		VARCHAR(32)										COMMENT	'提报单位编码',
	ReceiptDate			VARCHAR(8)										COMMENT	'计划接收日期',
	unit				VARCHAR(8)										COMMENT	'计量单位',
	planNum				DOUBLE(15,2)									COMMENT	'计划数量',
	planPrice			DOUBLE(13,2)									COMMENT	'计划单价',
	planMoney			DOUBLE(13,2)									COMMENT	'计划金额',
	arrivalDate			VARCHAR(8)										COMMENT	'到货日期',
	arrivalAddr			VARCHAR(100)									COMMENT	'到货地址',
	planStatus			VARCHAR(2)										COMMENT	'10未领取 20已领取 30采购寻源 40采购合同 50销售合同 60挂账 70已付 80开票 90已收 ',
	planInvalid 		VARCHAR(2)										COMMENT	'10启用 20停用',
	bNumber				VARCHAR(20)										COMMENT	'包号',
	fNumber				VARCHAR(20)										COMMENT	'方案号',
	FK_dTypeNo			VARCHAR(32)										COMMENT	'用作操作类型10增加 20修改 30删除',
	FK_zTypeNo			VARCHAR(32)										COMMENT	'中类',
	FK_xTypeNo			VARCHAR(32)										COMMENT	'小类',
	FK_userNo			VARCHAR(32)										COMMENT	'用作操作人姓名',
	FK_deptNo			VARCHAR(32)										COMMENT	'部门No',
	FK_planNo			VARCHAR(32)										COMMENT	'计划No',
	createTime			VARCHAR(14)		 				 				COMMENT	'创建日期'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='计划变更明细';
CREATE INDEX FK_planNo ON lm_d_planChangeDetails(FK_planNo);
