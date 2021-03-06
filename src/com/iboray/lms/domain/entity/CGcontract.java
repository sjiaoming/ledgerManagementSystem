package com.iboray.lms.domain.entity;

public class CGcontract {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.cgContractNo
     *
     * @mbggenerated
     */
    private String cgcontractno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.cgContractName
     *
     * @mbggenerated
     */
    private String cgcontractname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.cgContractNum
     *
     * @mbggenerated
     */
    private String cgcontractnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.FK_suppliersNo
     *
     * @mbggenerated
     */
    private String fkSuppliersno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.signingDate
     *
     * @mbggenerated
     */
    private String signingdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.arrivalDate
     *
     * @mbggenerated
     */
    private String arrivaldate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.totalMoney
     *
     * @mbggenerated
     */
    private Double totalmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.FK_procurementNo
     *
     * @mbggenerated
     */
    private String fkProcurementno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.qualityMoney
     *
     * @mbggenerated
     */
    private Double qualitymoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.qualityDate
     *
     * @mbggenerated
     */
    private String qualitydate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.payed
     *
     * @mbggenerated
     */
    private Double payed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.FK_userNo
     *
     * @mbggenerated
     */
    private String fkUserno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.FK_deptNo
     *
     * @mbggenerated
     */
    private String fkDeptno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.FK_usecompNo
     *
     * @mbggenerated
     */
    private String fkUsecompno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.invalid
     *
     * @mbggenerated
     */
    private String invalid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.createTime
     *
     * @mbggenerated
     */
    private String createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_cgcontract.updateTime
     *
     * @mbggenerated
     */
    private String updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.id
     *
     * @return the value of lm_d_cgcontract.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.id
     *
     * @param id the value for lm_d_cgcontract.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.cgContractNo
     *
     * @return the value of lm_d_cgcontract.cgContractNo
     *
     * @mbggenerated
     */
    public String getCgcontractno() {
        return cgcontractno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.cgContractNo
     *
     * @param cgcontractno the value for lm_d_cgcontract.cgContractNo
     *
     * @mbggenerated
     */
    public void setCgcontractno(String cgcontractno) {
        this.cgcontractno = cgcontractno == null ? null : cgcontractno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.cgContractName
     *
     * @return the value of lm_d_cgcontract.cgContractName
     *
     * @mbggenerated
     */
    public String getCgcontractname() {
        return cgcontractname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.cgContractName
     *
     * @param cgcontractname the value for lm_d_cgcontract.cgContractName
     *
     * @mbggenerated
     */
    public void setCgcontractname(String cgcontractname) {
        this.cgcontractname = cgcontractname == null ? null : cgcontractname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.cgContractNum
     *
     * @return the value of lm_d_cgcontract.cgContractNum
     *
     * @mbggenerated
     */
    public String getCgcontractnum() {
        return cgcontractnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.cgContractNum
     *
     * @param cgcontractnum the value for lm_d_cgcontract.cgContractNum
     *
     * @mbggenerated
     */
    public void setCgcontractnum(String cgcontractnum) {
        this.cgcontractnum = cgcontractnum == null ? null : cgcontractnum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.FK_suppliersNo
     *
     * @return the value of lm_d_cgcontract.FK_suppliersNo
     *
     * @mbggenerated
     */
    public String getFkSuppliersno() {
        return fkSuppliersno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.FK_suppliersNo
     *
     * @param fkSuppliersno the value for lm_d_cgcontract.FK_suppliersNo
     *
     * @mbggenerated
     */
    public void setFkSuppliersno(String fkSuppliersno) {
        this.fkSuppliersno = fkSuppliersno == null ? null : fkSuppliersno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.signingDate
     *
     * @return the value of lm_d_cgcontract.signingDate
     *
     * @mbggenerated
     */
    public String getSigningdate() {
        return signingdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.signingDate
     *
     * @param signingdate the value for lm_d_cgcontract.signingDate
     *
     * @mbggenerated
     */
    public void setSigningdate(String signingdate) {
        this.signingdate = signingdate == null ? null : signingdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.arrivalDate
     *
     * @return the value of lm_d_cgcontract.arrivalDate
     *
     * @mbggenerated
     */
    public String getArrivaldate() {
        return arrivaldate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.arrivalDate
     *
     * @param arrivaldate the value for lm_d_cgcontract.arrivalDate
     *
     * @mbggenerated
     */
    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate == null ? null : arrivaldate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.totalMoney
     *
     * @return the value of lm_d_cgcontract.totalMoney
     *
     * @mbggenerated
     */
    public Double getTotalmoney() {
        return totalmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.totalMoney
     *
     * @param totalmoney the value for lm_d_cgcontract.totalMoney
     *
     * @mbggenerated
     */
    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.FK_procurementNo
     *
     * @return the value of lm_d_cgcontract.FK_procurementNo
     *
     * @mbggenerated
     */
    public String getFkProcurementno() {
        return fkProcurementno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.FK_procurementNo
     *
     * @param fkProcurementno the value for lm_d_cgcontract.FK_procurementNo
     *
     * @mbggenerated
     */
    public void setFkProcurementno(String fkProcurementno) {
        this.fkProcurementno = fkProcurementno == null ? null : fkProcurementno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.qualityMoney
     *
     * @return the value of lm_d_cgcontract.qualityMoney
     *
     * @mbggenerated
     */
    public Double getQualitymoney() {
        return qualitymoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.qualityMoney
     *
     * @param qualitymoney the value for lm_d_cgcontract.qualityMoney
     *
     * @mbggenerated
     */
    public void setQualitymoney(Double qualitymoney) {
        this.qualitymoney = qualitymoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.qualityDate
     *
     * @return the value of lm_d_cgcontract.qualityDate
     *
     * @mbggenerated
     */
    public String getQualitydate() {
        return qualitydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.qualityDate
     *
     * @param qualitydate the value for lm_d_cgcontract.qualityDate
     *
     * @mbggenerated
     */
    public void setQualitydate(String qualitydate) {
        this.qualitydate = qualitydate == null ? null : qualitydate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.payed
     *
     * @return the value of lm_d_cgcontract.payed
     *
     * @mbggenerated
     */
    public Double getPayed() {
        return payed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.payed
     *
     * @param payed the value for lm_d_cgcontract.payed
     *
     * @mbggenerated
     */
    public void setPayed(Double payed) {
        this.payed = payed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.FK_userNo
     *
     * @return the value of lm_d_cgcontract.FK_userNo
     *
     * @mbggenerated
     */
    public String getFkUserno() {
        return fkUserno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.FK_userNo
     *
     * @param fkUserno the value for lm_d_cgcontract.FK_userNo
     *
     * @mbggenerated
     */
    public void setFkUserno(String fkUserno) {
        this.fkUserno = fkUserno == null ? null : fkUserno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.FK_deptNo
     *
     * @return the value of lm_d_cgcontract.FK_deptNo
     *
     * @mbggenerated
     */
    public String getFkDeptno() {
        return fkDeptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.FK_deptNo
     *
     * @param fkDeptno the value for lm_d_cgcontract.FK_deptNo
     *
     * @mbggenerated
     */
    public void setFkDeptno(String fkDeptno) {
        this.fkDeptno = fkDeptno == null ? null : fkDeptno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.FK_usecompNo
     *
     * @return the value of lm_d_cgcontract.FK_usecompNo
     *
     * @mbggenerated
     */
    public String getFkUsecompno() {
        return fkUsecompno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.FK_usecompNo
     *
     * @param fkUsecompno the value for lm_d_cgcontract.FK_usecompNo
     *
     * @mbggenerated
     */
    public void setFkUsecompno(String fkUsecompno) {
        this.fkUsecompno = fkUsecompno == null ? null : fkUsecompno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.invalid
     *
     * @return the value of lm_d_cgcontract.invalid
     *
     * @mbggenerated
     */
    public String getInvalid() {
        return invalid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.invalid
     *
     * @param invalid the value for lm_d_cgcontract.invalid
     *
     * @mbggenerated
     */
    public void setInvalid(String invalid) {
        this.invalid = invalid == null ? null : invalid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.createTime
     *
     * @return the value of lm_d_cgcontract.createTime
     *
     * @mbggenerated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.createTime
     *
     * @param createtime the value for lm_d_cgcontract.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_cgcontract.updateTime
     *
     * @return the value of lm_d_cgcontract.updateTime
     *
     * @mbggenerated
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_cgcontract.updateTime
     *
     * @param updatetime the value for lm_d_cgcontract.updateTime
     *
     * @mbggenerated
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}