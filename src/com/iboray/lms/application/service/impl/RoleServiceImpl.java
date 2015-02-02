package com.iboray.lms.application.service.impl;

import java.util.List;
import java.util.Set;

import com.iboray.lms.application.service.RoleService;
import com.iboray.lms.domain.activity.RoleActivity;
import com.iboray.lms.domain.vo.MResourceRoleVO;
import com.iboray.lms.domain.vo.MResourceVO;
import com.iboray.lms.domain.vo.RoleVO;

public class RoleServiceImpl implements RoleService {
	
	private RoleActivity roleActivity;
	public List<RoleVO> findAll() {
		return roleActivity.findAll();
	}
	public int createRole(RoleVO rv){
		return roleActivity.createRole(rv);
	}
	public RoleVO findByNo(String no){
		return roleActivity.findByNo(no);
	}
	public Set<MResourceVO> findMResourceByRoleNo(String RoleNo){
		return roleActivity.findMResourceByRoleNo(RoleNo);
	}
	public RoleActivity getRoleActivity() {
		return roleActivity;
	}
	public void setRoleActivity(RoleActivity roleActivity) {
		this.roleActivity = roleActivity;
	}
	public int createRoleMResource(MResourceRoleVO mr) {
		roleActivity.deleteRoleByRoleNo(mr.getRoleVO().getRoleno());
		return roleActivity.createRoleMResource(mr);
	}
	
	
}
