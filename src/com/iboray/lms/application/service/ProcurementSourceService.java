package com.iboray.lms.application.service;

import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.ProcurementSourceVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.Pager;

public interface ProcurementSourceService {
	
	public ProcurementSourceVO findProcurementSourceVOBYNo(String no);
	public int deleteByNos(String[] nos);
	public int save(ProcurementSourceVO urv);
	public Pager<ProcurementSourceVO> findAll(int offset,int limit);
	public Pager<ProcurementSourceVO> findByVO(ProcurementSourceVO vo,int offset,int limit);
	public int create(ProcurementSourceVO urv, String[] planNos,PlanVO planvo,UserVO uv);
}
