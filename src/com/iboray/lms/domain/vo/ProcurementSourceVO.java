package com.iboray.lms.domain.vo;

import java.io.Serializable;

public class ProcurementSourceVO  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6854460897558010580L;

	private Integer id;

    private String procurementno;

    private String procurementname;

    private String procurementwaycode;

    private String bnumber;

    private String fnumber;

    private String procurementcreatedate;

    private String procurementauditdate;

    private String searchannounceddate;

    private String searchauditdate;

    private String executionwaycode;

    private String fkUserno;

    private String fkDeptno;

    private String invalid;

    private String createtime;
    
    private String updatetime;
    
    private Integer idOp;

    private String procurementnoOp;

    private String procurementnameOp;

    private String procurementwaycodeOp;

    private String bnumberOp;

    private String fnumberOp;

    private String procurementcreatedateOp;

    private String procurementauditdateOp;

    private String searchannounceddateOp;

    private String searchauditdateOp;

    private String executionwaycodeOp;

    private String fkUsernoOp;

    private String fkDeptnoOp;

    private String invalidOp;

    private String createtimeOp;

    private String updatetimeOp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcurementno() {
        return procurementno;
    }

    public void setProcurementno(String procurementno) {
        this.procurementno = procurementno == null ? null : procurementno.trim();
    }

    public String getProcurementname() {
        return procurementname;
    }

    public void setProcurementname(String procurementname) {
        this.procurementname = procurementname == null ? null : procurementname.trim();
    }

    public String getProcurementwaycode() {
        return procurementwaycode;
    }

    public void setProcurementwaycode(String procurementwaycode) {
        this.procurementwaycode = procurementwaycode == null ? null : procurementwaycode.trim();
    }

    public String getBnumber() {
        return bnumber;
    }
    public void setBnumber(String bnumber) {
        this.bnumber = bnumber == null ? null : bnumber.trim();
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getProcurementcreatedate() {
        return procurementcreatedate;
    }

    public void setProcurementcreatedate(String procurementcreatedate) {
        this.procurementcreatedate = procurementcreatedate == null ? null : procurementcreatedate.trim();
    }

    public String getProcurementauditdate() {
        return procurementauditdate;
    }

    public void setProcurementauditdate(String procurementauditdate) {
        this.procurementauditdate = procurementauditdate == null ? null : procurementauditdate.trim();
    }

    public String getSearchannounceddate() {
        return searchannounceddate;
    }

    public void setSearchannounceddate(String searchannounceddate) {
        this.searchannounceddate = searchannounceddate == null ? null : searchannounceddate.trim();
    }

    public String getSearchauditdate() {
        return searchauditdate;
    }

    public void setSearchauditdate(String searchauditdate) {
        this.searchauditdate = searchauditdate == null ? null : searchauditdate.trim();
    }

    public String getExecutionwaycode() {
        return executionwaycode;
    }

    public void setExecutionwaycode(String executionwaycode) {
        this.executionwaycode = executionwaycode == null ? null : executionwaycode.trim();
    }

    public String getFkUserno() {
        return fkUserno;
    }

    public void setFkUserno(String fkUserno) {
        this.fkUserno = fkUserno == null ? null : fkUserno.trim();
    }

    public String getFkDeptno() {
        return fkDeptno;
    }

    public void setFkDeptno(String fkDeptno) {
        this.fkDeptno = fkDeptno == null ? null : fkDeptno.trim();
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid == null ? null : invalid.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

	public Integer getIdOp() {
		return idOp;
	}

	public void setIdOp(Integer idOp) {
		this.idOp = idOp;
	}

	public String getProcurementnoOp() {
		return procurementnoOp;
	}

	public void setProcurementnoOp(String procurementnoOp) {
		this.procurementnoOp = procurementnoOp;
	}

	public String getProcurementnameOp() {
		return procurementnameOp;
	}

	public void setProcurementnameOp(String procurementnameOp) {
		this.procurementnameOp = procurementnameOp;
	}

	public String getProcurementwaycodeOp() {
		return procurementwaycodeOp;
	}

	public void setProcurementwaycodeOp(String procurementwaycodeOp) {
		this.procurementwaycodeOp = procurementwaycodeOp;
	}

	public String getBnumberOp() {
		return bnumberOp;
	}

	public void setBnumberOp(String bnumberOp) {
		this.bnumberOp = bnumberOp;
	}

	public String getFnumberOp() {
		return fnumberOp;
	}

	public void setFnumberOp(String fnumberOp) {
		this.fnumberOp = fnumberOp;
	}

	public String getProcurementcreatedateOp() {
		return procurementcreatedateOp;
	}

	public void setProcurementcreatedateOp(String procurementcreatedateOp) {
		this.procurementcreatedateOp = procurementcreatedateOp;
	}

	public String getProcurementauditdateOp() {
		return procurementauditdateOp;
	}

	public void setProcurementauditdateOp(String procurementauditdateOp) {
		this.procurementauditdateOp = procurementauditdateOp;
	}

	public String getSearchannounceddateOp() {
		return searchannounceddateOp;
	}

	public void setSearchannounceddateOp(String searchannounceddateOp) {
		this.searchannounceddateOp = searchannounceddateOp;
	}

	public String getSearchauditdateOp() {
		return searchauditdateOp;
	}

	public void setSearchauditdateOp(String searchauditdateOp) {
		this.searchauditdateOp = searchauditdateOp;
	}

	public String getExecutionwaycodeOp() {
		return executionwaycodeOp;
	}

	public void setExecutionwaycodeOp(String executionwaycodeOp) {
		this.executionwaycodeOp = executionwaycodeOp;
	}

	public String getFkUsernoOp() {
		return fkUsernoOp;
	}

	public void setFkUsernoOp(String fkUsernoOp) {
		this.fkUsernoOp = fkUsernoOp;
	}

	public String getFkDeptnoOp() {
		return fkDeptnoOp;
	}

	public void setFkDeptnoOp(String fkDeptnoOp) {
		this.fkDeptnoOp = fkDeptnoOp;
	}

	public String getInvalidOp() {
		return invalidOp;
	}

	public void setInvalidOp(String invalidOp) {
		this.invalidOp = invalidOp;
	}

	public String getCreatetimeOp() {
		return createtimeOp;
	}

	public void setCreatetimeOp(String createtimeOp) {
		this.createtimeOp = createtimeOp;
	}

	public String getUpdatetimeOp() {
		return updatetimeOp;
	}

	public void setUpdatetimeOp(String updatetimeOp) {
		this.updatetimeOp = updatetimeOp;
	}
    
}
