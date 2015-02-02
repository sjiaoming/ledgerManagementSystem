package com.iboray.lms.application.service.impl;

import com.iboray.lms.application.service.CGcontractService;
import com.iboray.lms.domain.activity.CGcontractActivity;
import com.iboray.lms.domain.vo.CGcontractVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class CGcontractServiceImpl implements CGcontractService {

	private CGcontractActivity cgcontractActivity;
	
	
	public void setCgcontractActivity(CGcontractActivity cgcontractActivity) {
		this.cgcontractActivity = cgcontractActivity;
	}

	@Override
	public CGcontractVO findVOBYNo(String no) {
		// TODO Auto-generated method stub
		return cgcontractActivity.findVOBYNo(no);
	}

	@Override
	public int deleteByNos(String[] nos) {
		// TODO Auto-generated method stub
		return cgcontractActivity.deleteByNos(nos);
	}

	@Override
	public String create(CGcontractVO urv,String[] planNos,PlanVO planvo) {
		// TODO Auto-generated method stub
		return cgcontractActivity.create(urv,planNos,planvo);
	}

	@Override
	public int save(CGcontractVO urv) {
		// TODO Auto-generated method stub
		return cgcontractActivity.save(urv);
	}

	@Override
	public Pager<CGcontractVO> findAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return cgcontractActivity.findAll(offset, limit);
	}

	@Override
	public Pager<CGcontractVO> findByVO(CGcontractVO vo,JqGridSearchTo to,int offset,int limit,UserVO user) {
		// TODO Auto-generated method stub
		return cgcontractActivity.findByVO(vo,to, offset, limit,user);
	}

}
