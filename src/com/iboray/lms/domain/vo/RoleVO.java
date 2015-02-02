package com.iboray.lms.domain.vo;

import java.io.Serializable;

public class RoleVO  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8542374637202513067L;
	private String roleno;
    private String rolename;
    private String rolevalue;
    private String invalid;
    private String createtime;
    private String updatetime;
    public String getRoleno() {
        return roleno;
    }
    public void setRoleno(String roleno) {
        this.roleno = roleno == null ? null : roleno.trim();
    }
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
    public String getRolevalue() {
        return rolevalue;
    }
    public void setRolevalue(String rolevalue) {
        this.rolevalue = rolevalue == null ? null : rolevalue.trim();
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
    
}