package com.iboray.lms.application.service.impl;

import java.util.List;

import com.iboray.lms.application.service.PlanService;
import com.iboray.lms.domain.activity.PlanActivity;
import com.iboray.lms.domain.vo.PlanProcurementSourceVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.PlanchangedetailsVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class PlanServiceImpl implements PlanService {

	private PlanActivity planActivity;
	
	
	public void setPlanActivity(PlanActivity planActivity) {
		this.planActivity = planActivity;
	}

	@Override
	public PlanVO findPlanVOBYPlanNo(String planNo) {
		// TODO Auto-generated method stub
		return planActivity.findPlanVOBYPlanNo(planNo);
	}

	@Override
	public int deleteByNos(String[] nos,UserVO user) {
		// TODO Auto-generated method stub
		return planActivity.deleteByNos(nos,user);
	}

	@Override
	public int createPlan(PlanVO urv,UserVO user) {
		// TODO Auto-generated method stub
		return planActivity.createPlan(urv,user);
	}

	@Override
	public int savePlan(PlanVO urv,boolean cg,UserVO user) {
		// TODO Auto-generated method stub
		return planActivity.savePlan(urv,cg,user);
	}
	public int savePlans(PlanVO urv,String[] planNos,boolean cg,UserVO user){
		return planActivity.savePlans(urv, planNos,cg,user);
	}
	
	public int savePlans(PlanVO urv,String[] planNos,PlanVO params,UserVO user){
		return planActivity.savePlans(urv, planNos,params,user);
	}
	@Override
	public Pager<PlanVO> findAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return planActivity.findAll(offset, limit);
	}

	@Override
	public Pager<PlanVO> findByVO(PlanVO planVO,JqGridSearchTo to, int offset, int limit,UserVO user) {
		// TODO Auto-generated method stub
		return planActivity.findByVO(planVO,to, offset, limit,user);
	}

	@Override
	public List<PlanVO> findByVO(PlanVO planVO,UserVO user) {
		// TODO Auto-generated method stub
		return planActivity.findByVO(planVO,user);
	}
	
	public List<PlanchangedetailsVO> findAllPlanchangedetails(String planNo){
		return planActivity.findAllPlanchangedetails(planNo);
	}

	@Override
	public Pager<PlanProcurementSourceVO> findByVO(
			PlanProcurementSourceVO planProcurementSourceVO, JqGridSearchTo to,
			int offset, int limit, UserVO user) {
		// TODO Auto-generated method stub
		return planActivity.findByVO(planProcurementSourceVO, to, offset, limit, user);
	}
	

}
