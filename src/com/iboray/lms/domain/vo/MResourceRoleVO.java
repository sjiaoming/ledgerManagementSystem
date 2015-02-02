package com.iboray.lms.domain.vo;

import java.io.Serializable;
import java.util.Set;

public class MResourceRoleVO  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7220174453765356484L;

	private RoleVO roleVO;
	
	private Set<MResourceVO> mresourceVOs;

	public Set<MResourceVO> getMresourceVOs() {
		return mresourceVOs;
	}

	public void setMresourceVOs(Set<MResourceVO> mresourceVOs) {
		this.mresourceVOs = mresourceVOs;
	}

	public RoleVO getRoleVO() {
		return roleVO;
	}

	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}




	
	
}
