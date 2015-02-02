package com.iboray.lms.domain.vo;

import java.io.Serializable;
import java.util.Set;


public class UserVO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3648111968111357405L;

	private String userno;

    private String username;

    private String password;

    private String usertype;

    private String personname;

    private String fkDeptno;
    
    private String datarole;

    private String invalid;

    private String createtime;

    private String updatetime;
    
    private Set<RoleVO> roleVOs;
    
	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getFkDeptno() {
		return fkDeptno;
	}

	public void setFkDeptno(String fkDeptno) {
		this.fkDeptno = fkDeptno;
	}

	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
	public Set<RoleVO> getRoleVOs() {
		return roleVOs;
	}

	public void setRoleVOs(Set<RoleVO> roleVOs) {
		this.roleVOs = roleVOs;
	}
	
	public String getDatarole() {
		return datarole;
	}

	public void setDatarole(String datarole) {
		this.datarole = datarole;
	}

	@Override
	public String toString() {
		return "UserVO [userno=" + userno + ", username=" + username
				+ ", password=" + password + ", usertype=" + usertype
				+ ", personname=" + personname + ", fkDeptno=" + fkDeptno
				+ ", datarole=" + datarole + ", invalid=" + invalid
				+ ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", roleVOs=" + roleVOs + "]";
	}

	

	
}
