package com.iboray.lms.domain.vo;

import java.io.Serializable;

public class CGcontractVO  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2384679576768624011L;
	private Integer id;
    private String cgcontractno;
    private String cgcontractname;
    private String cgcontractnum;
    private String fkSuppliersno;
    private String signingdate;
    private String arrivaldate;
    private Double totalmoney;
    private String fkProcurementno;
    private Double qualitymoney;
    private String qualitydate;
    private Double payed;
    private String fkUserno;
    private String fkDeptno;
    private String fkUsecompno;
    private String invalid;
    private String createtime;
    private String updatetime;
    private Double creditMoney;
    private Integer idOp;
    private String cgcontractnoOp;
    private String cgcontractnameOp;
    private String cgcontractnumOp;
    private String fkSuppliersnoOp;
    private String signingdateOp;
    private String arrivaldateOp;
    private Double totalmoneyOp;
    private String fkProcurementnoOp;
    private Double qualitymoneyOp;
    private String qualitydateOp;
    private Double payedOp;
    private String fkUsernoOp;
    private String fkDeptnoOp;
    private String fkUsecompnoOp;
    private String invalidOp;
    private String createtimeOp;
    private String updatetimeOp;
    private Double shuldPay;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCgcontractno() {
        return cgcontractno;
    }

    public void setCgcontractno(String cgcontractno) {
        this.cgcontractno = cgcontractno == null ? null : cgcontractno.trim();
    }

    public String getCgcontractname() {
        return cgcontractname;
    }

    public void setCgcontractname(String cgcontractname) {
        this.cgcontractname = cgcontractname == null ? null : cgcontractname.trim();
    }

    public String getCgcontractnum() {
        return cgcontractnum;
    }

    public void setCgcontractnum(String cgcontractnum) {
        this.cgcontractnum = cgcontractnum == null ? null : cgcontractnum.trim();
    }

    public String getFkSuppliersno() {
        return fkSuppliersno;
    }

    public void setFkSuppliersno(String fkSuppliersno) {
        this.fkSuppliersno = fkSuppliersno == null ? null : fkSuppliersno.trim();
    }

    public String getSigningdate() {
        return signingdate;
    }

    public void setSigningdate(String signingdate) {
        this.signingdate = signingdate == null ? null : signingdate.trim();
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate == null ? null : arrivaldate.trim();
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getFkProcurementno() {
        return fkProcurementno;
    }

    public void setFkProcurementno(String fkProcurementno) {
        this.fkProcurementno = fkProcurementno == null ? null : fkProcurementno.trim();
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

    public Double getPayed() {
        return payed;
    }

    public void setPayed(Double payed) {
        this.payed = payed;
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

	public String getCgcontractnoOp() {
		return cgcontractnoOp;
	}

	public void setCgcontractnoOp(String cgcontractnoOp) {
		this.cgcontractnoOp = cgcontractnoOp;
	}

	public String getCgcontractnameOp() {
		return cgcontractnameOp;
	}

	public void setCgcontractnameOp(String cgcontractnameOp) {
		this.cgcontractnameOp = cgcontractnameOp;
	}

	public String getCgcontractnumOp() {
		return cgcontractnumOp;
	}

	public void setCgcontractnumOp(String cgcontractnumOp) {
		this.cgcontractnumOp = cgcontractnumOp;
	}

	public String getFkSuppliersnoOp() {
		return fkSuppliersnoOp;
	}

	public void setFkSuppliersnoOp(String fkSuppliersnoOp) {
		this.fkSuppliersnoOp = fkSuppliersnoOp;
	}

	public String getSigningdateOp() {
		return signingdateOp;
	}

	public void setSigningdateOp(String signingdateOp) {
		this.signingdateOp = signingdateOp;
	}

	public String getArrivaldateOp() {
		return arrivaldateOp;
	}

	public void setArrivaldateOp(String arrivaldateOp) {
		this.arrivaldateOp = arrivaldateOp;
	}

	public Double getTotalmoneyOp() {
		return totalmoneyOp;
	}

	public void setTotalmoneyOp(Double totalmoneyOp) {
		this.totalmoneyOp = totalmoneyOp;
	}

	public String getFkProcurementnoOp() {
		return fkProcurementnoOp;
	}

	public void setFkProcurementnoOp(String fkProcurementnoOp) {
		this.fkProcurementnoOp = fkProcurementnoOp;
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

	public Double getPayedOp() {
		return payedOp;
	}

	public void setPayedOp(Double payedOp) {
		this.payedOp = payedOp;
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

	public Double getCreditMoney() {
		return creditMoney;
	}

	public void setCreditMoney(Double creditMoney) {
		this.creditMoney = creditMoney;
	}

	public Double getShuldPay() {
		return shuldPay;
	}

	public void setShuldPay(Double shuldPay) {
		this.shuldPay = shuldPay;
	}
	
    
}