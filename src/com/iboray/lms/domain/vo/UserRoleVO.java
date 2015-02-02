package com.iboray.lms.domain.vo;

import java.io.Serializable;
import java.util.Set;

public class UserRoleVO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1163486920012615672L;

	private UserVO userVO;
	
	private Set<RoleVO> roleVOs;
	
	private Set<MResourceVO> mresourceVOs;


	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public Set<RoleVO> getRoleVOs() {
		return roleVOs;
	}

	public void setRoleVOs(Set<RoleVO> roleVOs) {
		this.roleVOs = roleVOs;
	}

	public Set<MResourceVO> getMresourceVOs() {
		return mresourceVOs;
	}

	public void setMresourceVOs(Set<MResourceVO> mresourceVOs) {
		this.mresourceVOs = mresourceVOs;
	}


	
	
}
