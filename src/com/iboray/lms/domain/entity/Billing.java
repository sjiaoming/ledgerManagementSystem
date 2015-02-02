package com.iboray.lms.domain.entity;

public class Billing {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.billingNo
     *
     * @mbggenerated
     */
    private String billingno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.billingMoney
     *
     * @mbggenerated
     */
    private Double billingmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.billingDate
     *
     * @mbggenerated
     */
    private String billingdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.billingNumber
     *
     * @mbggenerated
     */
    private Double billingnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.FK_xsContractNo
     *
     * @mbggenerated
     */
    private String fkXscontractno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.FK_arrivalNo
     *
     * @mbggenerated
     */
    private String fkArrivalno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.FK_userNo
     *
     * @mbggenerated
     */
    private String fkUserno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.invalid
     *
     * @mbggenerated
     */
    private String invalid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.createTime
     *
     * @mbggenerated
     */
    private String createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_billing.updateTime
     *
     * @mbggenerated
     */
    private String updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.id
     *
     * @return the value of lm_d_billing.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.id
     *
     * @param id the value for lm_d_billing.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.billingNo
     *
     * @return the value of lm_d_billing.billingNo
     *
     * @mbggenerated
     */
    public String getBillingno() {
        return billingno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.billingNo
     *
     * @param billingno the value for lm_d_billing.billingNo
     *
     * @mbggenerated
     */
    public void setBillingno(String billingno) {
        this.billingno = billingno == null ? null : billingno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.billingMoney
     *
     * @return the value of lm_d_billing.billingMoney
     *
     * @mbggenerated
     */
    public Double getBillingmoney() {
        return billingmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.billingMoney
     *
     * @param billingmoney the value for lm_d_billing.billingMoney
     *
     * @mbggenerated
     */
    public void setBillingmoney(Double billingmoney) {
        this.billingmoney = billingmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.billingDate
     *
     * @return the value of lm_d_billing.billingDate
     *
     * @mbggenerated
     */
    public String getBillingdate() {
        return billingdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.billingDate
     *
     * @param billingdate the value for lm_d_billing.billingDate
     *
     * @mbggenerated
     */
    public void setBillingdate(String billingdate) {
        this.billingdate = billingdate == null ? null : billingdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.billingNumber
     *
     * @return the value of lm_d_billing.billingNumber
     *
     * @mbggenerated
     */
    public Double getBillingnumber() {
        return billingnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.billingNumber
     *
     * @param billingnumber the value for lm_d_billing.billingNumber
     *
     * @mbggenerated
     */
    public void setBillingnumber(Double billingnumber) {
        this.billingnumber = billingnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.FK_xsContractNo
     *
     * @return the value of lm_d_billing.FK_xsContractNo
     *
     * @mbggenerated
     */
    public String getFkXscontractno() {
        return fkXscontractno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.FK_xsContractNo
     *
     * @param fkXscontractno the value for lm_d_billing.FK_xsContractNo
     *
     * @mbggenerated
     */
    public void setFkXscontractno(String fkXscontractno) {
        this.fkXscontractno = fkXscontractno == null ? null : fkXscontractno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.FK_arrivalNo
     *
     * @return the value of lm_d_billing.FK_arrivalNo
     *
     * @mbggenerated
     */
    public String getFkArrivalno() {
        return fkArrivalno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.FK_arrivalNo
     *
     * @param fkArrivalno the value for lm_d_billing.FK_arrivalNo
     *
     * @mbggenerated
     */
    public void setFkArrivalno(String fkArrivalno) {
        this.fkArrivalno = fkArrivalno == null ? null : fkArrivalno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.FK_userNo
     *
     * @return the value of lm_d_billing.FK_userNo
     *
     * @mbggenerated
     */
    public String getFkUserno() {
        return fkUserno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.FK_userNo
     *
     * @param fkUserno the value for lm_d_billing.FK_userNo
     *
     * @mbggenerated
     */
    public void setFkUserno(String fkUserno) {
        this.fkUserno = fkUserno == null ? null : fkUserno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.invalid
     *
     * @return the value of lm_d_billing.invalid
     *
     * @mbggenerated
     */
    public String getInvalid() {
        return invalid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.invalid
     *
     * @param invalid the value for lm_d_billing.invalid
     *
     * @mbggenerated
     */
    public void setInvalid(String invalid) {
        this.invalid = invalid == null ? null : invalid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.createTime
     *
     * @return the value of lm_d_billing.createTime
     *
     * @mbggenerated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.createTime
     *
     * @param createtime the value for lm_d_billing.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_billing.updateTime
     *
     * @return the value of lm_d_billing.updateTime
     *
     * @mbggenerated
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_billing.updateTime
     *
     * @param updatetime the value for lm_d_billing.updateTime
     *
     * @mbggenerated
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}