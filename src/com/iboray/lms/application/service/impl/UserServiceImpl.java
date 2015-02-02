package com.iboray.lms.application.service.impl;

import com.iboray.lms.application.service.UserService;
import com.iboray.lms.domain.activity.UserActivity;
import com.iboray.lms.domain.vo.UserRoleVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.Pager;

public class UserServiceImpl implements UserService {
	
	private UserActivity userActivity;
	
	@Override
	public UserVO findUserByNameAndPwd(String name, String password) {
		return userActivity.findUserByNameAndPwd(name, password);
	}

	public UserVO findUserByName(String name){
		return userActivity.findUserByName(name);
	}
	@Override
	public UserRoleVO findRolesByUserNo(String userNo) {
		return userActivity.findRolesByUserNo(userNo);
	}
	public int createUser(UserRoleVO uv){
		return userActivity.createUser(uv);
	}
	public Pager<UserVO> findAll(int offset,int limit){
		return userActivity.findAll(offset, limit);
	}
	public int deleteByNos(String[] nos){
		return userActivity.deleteByNos(nos);
	}
	public UserActivity getUserActivity() {
		return userActivity;
	}

	public void setUserActivity(UserActivity userActivity) {
		this.userActivity = userActivity;
	}
	

	
}
