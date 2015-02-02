package com.iboray.lms.application.service.impl;

import com.iboray.lms.application.service.XScontractService;
import com.iboray.lms.domain.activity.XScontractActivity;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.domain.vo.XscontractVO;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class XScontractServiceImpl implements XScontractService {
	
	private XScontractActivity xscontractActivity;
	
	

	public void setXscontractActivity(XScontractActivity xscontractActivity) {
		this.xscontractActivity = xscontractActivity;
	}

	@Override
	public XscontractVO findVOBYNo(String no) {
		// TODO Auto-generated method stub
		return xscontractActivity.findVOBYNo(no);
	}

	@Override
	public int deleteByNos(String[] nos) {
		// TODO Auto-generated method stub
		return xscontractActivity.deleteByNos(nos);
	}

	@Override
	public String create(XscontractVO urv,String[] planNos,PlanVO planvo) {
		// TODO Auto-generated method stub
		return xscontractActivity.create(urv,planNos,planvo);
	}

	@Override
	public int save(XscontractVO urv) {
		// TODO Auto-generated method stub
		return xscontractActivity.save(urv);
	}

	@Override
	public Pager<XscontractVO> findAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return xscontractActivity.findAll(offset, limit);
	}

	@Override
	public Pager<XscontractVO> findByVO(XscontractVO vo,JqGridSearchTo to,int offset,int limit,UserVO user) {
		// TODO Auto-generated method stub
		return xscontractActivity.findByVO(vo, to,offset, limit,user);
	}

}
