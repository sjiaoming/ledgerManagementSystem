package com.iboray.lms.application.service.impl;

import com.iboray.lms.application.service.UsecompService;
import com.iboray.lms.domain.activity.UsecompActivity;
import com.iboray.lms.domain.vo.UsecompVO;
import com.iboray.lms.userinterface.common.Pager;

public class UsecompServiceImpl implements UsecompService {

	private UsecompActivity usecompActivity;
	
	public void setUsecompActivity(UsecompActivity usecompActivity) {
		this.usecompActivity = usecompActivity;
	}

	@Override
	public UsecompVO findUsecompVOBYNo(String no) {
		// TODO Auto-generated method stub
		return usecompActivity.findUsecompVOBYNo(no);
	}

	@Override
	public int deleteByNos(String[] nos) {
		// TODO Auto-generated method stub
		return usecompActivity.deleteByNos(nos);
	}

	@Override
	public int create(UsecompVO urv) {
		// TODO Auto-generated method stub
		return usecompActivity.create(urv);
	}

	@Override
	public int save(UsecompVO urv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pager<UsecompVO> findAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return usecompActivity.findAll(offset, limit);
	}

	@Override
	public Pager<UsecompVO> findByVO(UsecompVO vo, int offset, int limit) {
		// TODO Auto-generated method stub
		return usecompActivity.findByVO(vo, offset, limit);
	}

}
