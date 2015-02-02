package com.iboray.lms.application.service;

import java.util.List;

import com.iboray.lms.domain.vo.PlanProcurementSourceVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.PlanchangedetailsVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public interface PlanService {

	public PlanVO findPlanVOBYPlanNo(String planNo);
	
	public int deleteByNos(String[] nos,UserVO user);
	
	public int createPlan(PlanVO urv,UserVO user);
	
	public int savePlan(PlanVO urv,boolean cg,UserVO user);
	
	public int savePlans(PlanVO urv,String[] planNos,boolean cg,UserVO user);
	
	public int savePlans(PlanVO urv,String[] planNos,PlanVO params,UserVO user);
	
	public Pager<PlanVO> findAll(int offset,int limit);
	
	public List<PlanVO> findByVO(PlanVO planVO,UserVO user);
	
	public Pager<PlanVO> findByVO(PlanVO planVO,JqGridSearchTo to,int offset,int limit,UserVO user);
	
	public Pager<PlanProcurementSourceVO> findByVO(PlanProcurementSourceVO planProcurementSourceVO,JqGridSearchTo to,int offset,int limit,UserVO user);
	
	public List<PlanchangedetailsVO> findAllPlanchangedetails(String planNo);
	
}
