package com.iboray.lms.application.service;

import com.iboray.lms.domain.vo.UserRoleVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.userinterface.common.Pager;

public interface UserService {

	public UserVO findUserByNameAndPwd(String name,String password);
	
	public UserRoleVO findRolesByUserNo(String userNo);
	
	public UserVO findUserByName(String name);
	
	public int createUser(UserRoleVO uv);
	
	public Pager<UserVO> findAll(int offset,int limit);
	
	public int deleteByNos(String[] nos);
}
