package com.iboray.lms.application.service.impl;

import com.iboray.lms.application.service.ProcurementSourceService;
import com.iboray.lms.domain.activity.ProcurementSourceActivity;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.ProcurementSourceVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.Pager;

public class ProcurementSourceServiceImpl implements ProcurementSourceService {

	private ProcurementSourceActivity procurementSourceActivity;

	
	

	public void setProcurementSourceActivity(
			ProcurementSourceActivity procurementSourceActivity) {
		this.procurementSourceActivity = procurementSourceActivity;
	}

	@Override
	public ProcurementSourceVO findProcurementSourceVOBYNo(String no) {
		// TODO Auto-generated method stub
		return procurementSourceActivity.findProcurementSourceVOBYNo(no);
	}

	@Override
	public int deleteByNos(String[] nos) {
		// TODO Auto-generated method stub
		return procurementSourceActivity.deleteByNos(nos);
	}

	public int create(ProcurementSourceVO urv,String[] planNos,PlanVO planvo,UserVO uv) {
		return procurementSourceActivity.create(urv,planNos,planvo, uv);
	}

	@Override
	public int save(ProcurementSourceVO urv) {
		// TODO Auto-generated method stub
		return procurementSourceActivity.save(urv);
	}

	@Override
	public Pager<ProcurementSourceVO> findAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return procurementSourceActivity.findAll(offset, limit);
	}

	@Override
	public Pager<ProcurementSourceVO> findByVO(ProcurementSourceVO vo,
			int offset, int limit) {
		// TODO Auto-generated method stub
		return procurementSourceActivity.findByVO(vo, offset, limit);
	}


}
