package com.iboray.lms.application.service.impl;

import java.util.List;

import com.iboray.lms.application.service.DeptService;
import com.iboray.lms.domain.activity.DeptActivity;
import com.iboray.lms.domain.vo.DeptVO;

public class DeptServiceImpl implements DeptService{

	private DeptActivity deptActivity;
	public List<DeptVO> findAll(){
		return deptActivity.findAll();
	}
	public DeptActivity getDeptActivity() {
		return deptActivity;
	}
	public void setDeptActivity(DeptActivity deptActivity) {
		this.deptActivity = deptActivity;
	}
	
}
