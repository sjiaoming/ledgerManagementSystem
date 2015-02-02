package com.iboray.lms.domain.vo;

import java.io.Serializable;

public class XscontractVO  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1328091793255581480L;
	private Integer id;
    private String xscontractno;
    private String xscontractname;
    private String xscontractnum;
    private String signingdate;
    private Double totalmoney;
    private Double qualitymoney;
    private String qualitydate;
    private String signcomp;
    private Double salesrate;
    private String fkUserno;
    private String fkCgcontractno;
    private String fkDeptno;
    private String fkUsecompno;
    private String invalid;
    private String createtime;
    private String updatetime;
    private Double billingMoney;
    private Double receivedMoney;
    private Double shuldReceived;
    private Integer idOp;
    private String xscontractnoOp;
    private String xscontractnameOp;
    private String xscontractnumOp;
    private String signingdateOp;
    private Double totalmoneyOp;
    private Double qualitymoneyOp;
    private String qualitydateOp;
    private String signcompOp;
    private Double salesrateOp;
    private String fkUsernoOp;
    private String fkCgcontractnoOp;
    private String fkDeptnoOp;
    private String fkUsecompnoOp;
    private String invalidOp;
    private String createtimeOp;
    private String updatetimeOp;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXscontractno() {
        return xscontractno;
    }

    public void setXscontractno(String xscontractno) {
        this.xscontractno = xscontractno == null ? null : xscontractno.trim();
    }

    public String getXscontractname() {
        return xscontractname;
    }

    public void setXscontractname(String xscontractname) {
        this.xscontractname = xscontractname == null ? null : xscontractname.trim();
    }

    public String getXscontractnum() {
        return xscontractnum;
    }

    public void setXscontractnum(String xscontractnum) {
        this.xscontractnum = xscontractnum == null ? null : xscontractnum.trim();
    }

    public String getSigningdate() {
        return signingdate;
    }

    public void setSigningdate(String signingdate) {
        this.signingdate = signingdate == null ? null : signingdate.trim();
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Double getQualitymoney() {
        return qualitymoney;
    }

    public void setQualitymoney(Double qualitymoney) {
        this.qualitymoney = qualitymoney;
    }

    public String getQualitydate() {
        return qualitydate;
    }

    public void setQualitydate(String qualitydate) {
        this.qualitydate = qualitydate == null ? null : qualitydate.trim();
    }

    public String getSigncomp() {
        return signcomp;
    }

    public void setSigncomp(String signcomp) {
        this.signcomp = signcomp == null ? null : signcomp.trim();
    }

    public Double getSalesrate() {
        return salesrate;
    }

    public void setSalesrate(Double salesrate) {
        this.salesrate = salesrate;
    }

    public String getFkUserno() {
        return fkUserno;
    }

    public void setFkUserno(String fkUserno) {
        this.fkUserno = fkUserno == null ? null : fkUserno.trim();
    }

    public String getFkCgcontractno() {
        return fkCgcontractno;
    }

    public void setFkCgcontractno(String fkCgcontractno) {
        this.fkCgcontractno = fkCgcontractno == null ? null : fkCgcontractno.trim();
    }
    public String getFkDeptno() {
        return fkDeptno;
    }
    public void setFkDeptno(String fkDeptno) {
        this.fkDeptno = fkDeptno == null ? null : fkDeptno.trim();
    }

    public String getFkUsecompno() {
        return fkUsecompno;
    }

    public void setFkUsecompno(String fkUsecompno) {
        this.fkUsecompno = fkUsecompno == null ? null : fkUsecompno.trim();
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

	public String getXscontractnoOp() {
		return xscontractnoOp;
	}

	public void setXscontractnoOp(String xscontractnoOp) {
		this.xscontractnoOp = xscontractnoOp;
	}

	public String getXscontractnameOp() {
		return xscontractnameOp;
	}

	public void setXscontractnameOp(String xscontractnameOp) {
		this.xscontractnameOp = xscontractnameOp;
	}

	public String getXscontractnumOp() {
		return xscontractnumOp;
	}

	public void setXscontractnumOp(String xscontractnumOp) {
		this.xscontractnumOp = xscontractnumOp;
	}

	public String getSigningdateOp() {
		return signingdateOp;
	}

	public void setSigningdateOp(String signingdateOp) {
		this.signingdateOp = signingdateOp;
	}

	public Double getTotalmoneyOp() {
		return totalmoneyOp;
	}

	public void setTotalmoneyOp(Double totalmoneyOp) {
		this.totalmoneyOp = totalmoneyOp;
	}

	public Double getQualitymoneyOp() {
		return qualitymoneyOp;
	}

	public void setQualitymoneyOp(Double qualitymoneyOp) {
		this.qualitymoneyOp = qualitymoneyOp;
	}

	public String getQualitydateOp() {
		return qualitydateOp;
	}

	public void setQualitydateOp(String qualitydateOp) {
		this.qualitydateOp = qualitydateOp;
	}

	public String getSigncompOp() {
		return signcompOp;
	}

	public void setSigncompOp(String signcompOp) {
		this.signcompOp = signcompOp;
	}

	public Double getSalesrateOp() {
		return salesrateOp;
	}

	public void setSalesrateOp(Double salesrateOp) {
		this.salesrateOp = salesrateOp;
	}

	public String getFkUsernoOp() {
		return fkUsernoOp;
	}

	public void setFkUsernoOp(String fkUsernoOp) {
		this.fkUsernoOp = fkUsernoOp;
	}

	public String getFkCgcontractnoOp() {
		return fkCgcontractnoOp;
	}

	public void setFkCgcontractnoOp(String fkCgcontractnoOp) {
		this.fkCgcontractnoOp = fkCgcontractnoOp;
	}

	public String getFkDeptnoOp() {
		return fkDeptnoOp;
	}

	public void setFkDeptnoOp(String fkDeptnoOp) {
		this.fkDeptnoOp = fkDeptnoOp;
	}

	public String getFkUsecompnoOp() {
		return fkUsecompnoOp;
	}

	public void setFkUsecompnoOp(String fkUsecompnoOp) {
		this.fkUsecompnoOp = fkUsecompnoOp;
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

	public Double getBillingMoney() {
		return billingMoney;
	}

	public void setBillingMoney(Double billingMoney) {
		this.billingMoney = billingMoney;
	}

	public Double getReceivedMoney() {
		return receivedMoney;
	}

	public void setReceivedMoney(Double receivedMoney) {
		this.receivedMoney = receivedMoney;
	}

	public Double getShuldReceived() {
		return shuldReceived;
	}

	public void setShuldReceived(Double shuldReceived) {
		this.shuldReceived = shuldReceived;
	}
    
}