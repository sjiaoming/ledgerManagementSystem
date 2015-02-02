package com.iboray.lms.application.service;

import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.domain.vo.XscontractVO;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public interface XScontractService {
	
	public XscontractVO findVOBYNo(String no);
	public int deleteByNos(String[] nos);
	public String create(XscontractVO urv,String[] planNos,PlanVO planvo);
	public int save(XscontractVO urv);
	public Pager<XscontractVO> findAll(int offset,int limit);
	public Pager<XscontractVO> findByVO(XscontractVO vo,JqGridSearchTo to,int offset,int limit,UserVO user);
}
