package com.iboray.lms.userinterface.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.iboray.lms.application.service.PlanService;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.entity.enums.PlanStateEnum;
import com.iboray.lms.domain.entity.enums.UserDataRoleEnum;
import com.iboray.lms.domain.vo.PlanProcurementSourceVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.PlanchangedetailsVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.utils.JqGridToVO;
import com.iboray.lms.infrastructure.utils.JsonPojoMapper;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class PlanAction extends BaseAction<PlanVO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7212215452632405740L;

	private PlanService planService;
	
	private PlanVO plan;
	
	private String cartcode;
	
	private String planJson;
	
	private String planno;
	
	private String ajaxResult;
	
	private boolean cg;
	public String save() {
		if(plan == null ){
			return INDEX;
		}
		UserVO user = (UserVO)getSession().getAttribute("user");
		if(nos!=null && nos.length()>0){
			nos = nos.trim();
			String[] planNo;
			if(nos.indexOf("\"")>0){
				nos = nos.replaceAll("\"", "");
				planNo= nos.substring(1,nos.length()-1).split(",");
			}else
				planNo = nos.split(",");
			planService.savePlans(plan, planNo,cg,user);
		}else if(!StringUtils.isEmpty(plan.getPlanno()))
			planService.savePlan(plan,cg,user);
		ajaxResult = SUCCESS;
		ServletActionContext.getRequest().setAttribute("ajaxResult", JsonPojoMapper.toJson(ajaxResult, false));
		return SUCCESS;
	}
	public String delete(){
		UserVO user = (UserVO)getSession().getAttribute("user");
		planService.deleteByNos(nos.trim().split(","),user);
		setAttribute("ajaxResult", "success");
		return findByPager();
	}
	public String getTotal(){
		setAttribute("plannumSum", 321123);
		return null;
	}
	
	public String findByPager(){
		JqGridSearchTo to=getJqGridSearchTo();
		
		PlanVO pv=null;
		if(to!=null)
			pv = (PlanVO)JqGridToVO.getVOfromJqGrid(to, PlanVO.class);
		if(pager == null){
			pager = new Pager<PlanVO>();
		}
		pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		UserVO user = (UserVO)getSession().getAttribute("user");
		pager = planService.findByVO(pv, to,getPageNo(), pager.getPageSize(),user);
		if(pager.getTotalNum()<1)
			setAttribute("msg", "没有数据!");
		setAttribute("pager", pager);
		setAttribute("plan", plan);
		String planJsonStr = JsonPojoMapper.toJson(pager, true);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(planJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return SUCCESS;
	}
	public String findProcurementPlanByPager(){
		JqGridSearchTo to=getJqGridSearchTo();
		PlanVO pv=null;
		if(to!=null)
			pv = (PlanVO)JqGridToVO.getVOfromJqGrid(to, PlanVO.class);
		if(pager == null){
			pager = new Pager<PlanVO>();
		}
		pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		pv.setPlanstatus(String.valueOf(PlanStateEnum.UNCLAIMED.getCode()));
		UserVO user = (UserVO)getSession().getAttribute("user");
		//pv.setFkDeptno(user.getFkDeptno());
		if(user==null)
			return LOGIN;
		String DataRoleCode = user.getDatarole();
		user.setDatarole(UserDataRoleEnum.DEPT.getCode());
		pager = planService.findByVO(pv, to,getPageNo(), pager.getPageSize(),user);
		user.setDatarole(DataRoleCode);
		if(pager.getTotalNum()<1)
			setAttribute("msg", "没有数据!");
		setAttribute("pager", pager);
		setAttribute("plan", plan);
		String planJsonStr = JsonPojoMapper.toJson(pager, true);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(planJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return SUCCESS;
	}
	public String planReceive(){
		if(plan == null ){
			plan = new PlanVO();
		}
		nos = nos.trim().replaceAll("\"", "");
		String[] planNo = nos.substring(1,nos.length()-1).split(",");
		plan.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		plan.setPlanstatus(String.valueOf(PlanStateEnum.UNCLAIMED.getCode()));
		PlanVO planvo = new PlanVO();
		planvo.setPlanstatus(String.valueOf(PlanStateEnum.CLAIMED.getCode()));
		UserVO u = (UserVO)getSession().getAttribute("user");
		if(u!=null){
			planvo.setFkUserno(u.getUserno());
		}else{
			
			throw new RuntimeException("User is null,please try login");
		}
		if(nos!=null && planNo.length>0)
			planService.savePlans(planvo, planNo,plan,u);
		ajaxResult = JsonPojoMapper.toJson(SUCCESS, false);
		ServletActionContext.getRequest().setAttribute("ajaxResult",ajaxResult);
		return findProcurementPlanByPager();
	}
	public String procurementInit(){
		JqGridSearchTo to=getJqGridSearchTo();
		if(pager == null){
			pager = new Pager<PlanVO>();
		}
		PlanProcurementSourceVO pv=null;
		if(to!=null)
			pv = (PlanProcurementSourceVO)JqGridToVO.getVOfromJqGrid(to, PlanProcurementSourceVO.class);
		Pager<PlanProcurementSourceVO> mpager = new Pager<PlanProcurementSourceVO>();
		pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		//pv.setPlanstatus(String.valueOf(PlanStateEnum.CLAIMED.getCode()));
		List<String> planstatusList = new ArrayList<String>();
		planstatusList.add(String.valueOf(PlanStateEnum.CLAIMED.getCode()));
		planstatusList.add(String.valueOf(PlanStateEnum.PROCUREMENTSC.getCode()));
		pv.setPlanstatusList(planstatusList);
		UserVO user = (UserVO)getSession().getAttribute("user");
		pv.setFkUserno(user.getUserno());
		mpager = planService.findByVO(pv, to,getPageNo(), pager.getPageSize(),user);
//		if(mpager.getTotalNum()<1)
//			setAttribute("msg", "没有数据!");
//		setAttribute("pager", mpager);
//		setAttribute("plan", plan);
		String planJsonStr = JsonPojoMapper.toJson(mpager, true);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(planJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return null;
	}
	public String doProcurement(){
		if(plan == null ){
			plan = new PlanVO();
		}
		nos = nos.trim().replaceAll("\"", "");
		String[] planNo = nos.substring(1,nos.length()-1).split(",");
		plan.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		plan.setPlanstatus(String.valueOf(PlanStateEnum.UNCLAIMED.getCode()));
		PlanVO planvo = new PlanVO();
		planvo.setPlanstatus(String.valueOf(PlanStateEnum.CLAIMED.getCode()));
		UserVO u = (UserVO)getSession().getAttribute("user");
		if(u!=null){
			planvo.setFkUserno(u.getUserno());
		}else{
			
			throw new RuntimeException("User is null,please try login");
		}
		if(nos!=null && planNo.length>0)
			planService.savePlans(planvo, planNo,plan,u);
		ajaxResult = SUCCESS;
		ServletActionContext.getRequest().setAttribute("ajaxResult", JsonPojoMapper.toJson(ajaxResult, false));
		return findProcurementPlanByPager();
	}
	public String cgContractPlan(){
		JqGridSearchTo to=null;
			
		PlanVO pv=new PlanVO();
		if(pager == null){
			pager = new Pager<PlanVO>();
		}
		pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		pv.setPlanstatus(String.valueOf(PlanStateEnum.PROCUREMENTSC.getCode()));
		UserVO user = (UserVO)getSession().getAttribute("user");
		pv.setFkUserno(user.getUserno());
		pager = planService.findByVO(pv, to,getPageNo(), pager.getPageSize(),user);
		if(pager.getTotalNum()<1)
			setAttribute("msg", "没有数据!");
		setAttribute("pager", pager);
		setAttribute("plan", plan);
		String planJsonStr = JsonPojoMapper.toJson(pager, true);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(planJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return SUCCESS;
	}
	public String xsContractPlan(){
		JqGridSearchTo to=null;
		PlanVO pv=new PlanVO();
		if(pager == null){
			pager = new Pager<PlanVO>();
		}
		pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		pv.setPlanstatus(String.valueOf(PlanStateEnum.CGCONTRACT.getCode()));
		UserVO user = (UserVO)getSession().getAttribute("user");
		pv.setFkUserno(user.getUserno());
		pager = planService.findByVO(pv, to,getPageNo(), pager.getPageSize(),user);
		if(pager.getTotalNum()<1)
			setAttribute("msg", "没有数据!");
		setAttribute("pager", pager);
		setAttribute("plan", plan);
		String planJsonStr = JsonPojoMapper.toJson(pager, true);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(planJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return SUCCESS;
	}
	public String findPlanChangeDetails(){
		List<PlanchangedetailsVO> pcdList = planService.findAllPlanchangedetails(no);
		if(pcdList==null || pcdList.size()<1)
			return null;
		String planJsonStr = JsonPojoMapper.toJson(pcdList, true);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(planJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return null;
	}
	public String addPlan(){
		
		return SUCCESS;
	}
	public String findByNO(){
		PlanVO p = planService.findPlanVOBYPlanNo(plan.getPlanno());
		setAttribute("plan", p);
		return "DETAIL";
	}
	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	public PlanVO getPlan() {
		return plan;
	}
	public void setPlan(PlanVO plan) {
		this.plan = plan;
	}
	public PlanService getPlanService() {
		return planService;
	}
	public String getPlanJson() {
		return planJson;
	}
	public void setPlanJson(String planJson) {
		this.planJson = planJson;
	}
	public String getCartcode() {
		return cartcode;
	}
	public void setCartcode(String cartcode) {
		this.cartcode = cartcode;
	}
	public String getPlanno() {
		return planno;
	}
	public void setPlanno(String planno) {
		this.planno = planno;
	}
	public boolean isCg() {
		return cg;
	}
	public void setCg(boolean cg) {
		this.cg = cg;
	}

	
	
}
