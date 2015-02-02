package com.iboray.lms.application.service.impl;

import java.util.List;

import com.iboray.lms.application.service.MResourceService;
import com.iboray.lms.domain.activity.MResourceActivity;
import com.iboray.lms.domain.vo.MResourceVO;

public class MResourceServiceImpl implements MResourceService {

	private MResourceActivity mResourceActivity;
	@Override
	public List<MResourceVO> findAll() {
		return mResourceActivity.findAll();
	}
	public List<MResourceVO> findByFk_No(String fkno){
		return mResourceActivity.findByFk_No(fkno);
	}
	public int createMResource(MResourceVO mResourceVO){
		return mResourceActivity.createMResource(mResourceVO);
	}
	public List<MResourceVO> findAllParentMResource(){
		return mResourceActivity.findAllParentMResource();
	}
	@Override
	public MResourceVO findByNo(String no) {
		return mResourceActivity.findByNo(no);
	}
	
	public MResourceActivity getmResourceActivity() {
		return mResourceActivity;
	}
	public void setmResourceActivity(MResourceActivity mResourceActivity) {
		this.mResourceActivity = mResourceActivity;
	}

	
}
