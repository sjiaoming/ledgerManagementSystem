package com.iboray.lms.application.service;

import com.iboray.lms.domain.vo.CGcontractVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public interface CGcontractService {
	
	public CGcontractVO findVOBYNo(String no);
	public int deleteByNos(String[] nos);
	public String create(CGcontractVO urv,String[] planNos,PlanVO planvo);
	public int save(CGcontractVO urv);
	public Pager<CGcontractVO> findAll(int offset,int limit);
	public Pager<CGcontractVO> findByVO(CGcontractVO vo,JqGridSearchTo to,int offset,int limit,UserVO user);
}
