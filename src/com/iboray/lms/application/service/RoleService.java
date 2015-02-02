package com.iboray.lms.application.service;

import java.util.List;
import java.util.Set;

import com.iboray.lms.domain.vo.MResourceRoleVO;
import com.iboray.lms.domain.vo.MResourceVO;
import com.iboray.lms.domain.vo.RoleVO;

public interface RoleService {
	public List<RoleVO> findAll();
	
	public int createRole(RoleVO rv);
	
	public RoleVO findByNo(String no);
	
	public Set<MResourceVO> findMResourceByRoleNo(String RoleNo);
	
	public int createRoleMResource(MResourceRoleVO mr);
}
