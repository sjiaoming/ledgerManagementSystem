package com.iboray.lms.domain.entity;

public class Suppliers {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_c_suppliers.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_c_suppliers.suppliersNo
     *
     * @mbggenerated
     */
    private String suppliersno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_c_suppliers.suppliersCode
     *
     * @mbggenerated
     */
    private String supplierscode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_c_suppliers.suppliersName
     *
     * @mbggenerated
     */
    private String suppliersname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_c_suppliers.invalid
     *
     * @mbggenerated
     */
    private String invalid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_c_suppliers.createTime
     *
     * @mbggenerated
     */
    private String createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_c_suppliers.updateTime
     *
     * @mbggenerated
     */
    private String updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_c_suppliers.id
     *
     * @return the value of lm_c_suppliers.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_c_suppliers.id
     *
     * @param id the value for lm_c_suppliers.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_c_suppliers.suppliersNo
     *
     * @return the value of lm_c_suppliers.suppliersNo
     *
     * @mbggenerated
     */
    public String getSuppliersno() {
        return suppliersno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_c_suppliers.suppliersNo
     *
     * @param suppliersno the value for lm_c_suppliers.suppliersNo
     *
     * @mbggenerated
     */
    public void setSuppliersno(String suppliersno) {
        this.suppliersno = suppliersno == null ? null : suppliersno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_c_suppliers.suppliersCode
     *
     * @return the value of lm_c_suppliers.suppliersCode
     *
     * @mbggenerated
     */
    public String getSupplierscode() {
        return supplierscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_c_suppliers.suppliersCode
     *
     * @param supplierscode the value for lm_c_suppliers.suppliersCode
     *
     * @mbggenerated
     */
    public void setSupplierscode(String supplierscode) {
        this.supplierscode = supplierscode == null ? null : supplierscode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_c_suppliers.suppliersName
     *
     * @return the value of lm_c_suppliers.suppliersName
     *
     * @mbggenerated
     */
    public String getSuppliersname() {
        return suppliersname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_c_suppliers.suppliersName
     *
     * @param suppliersname the value for lm_c_suppliers.suppliersName
     *
     * @mbggenerated
     */
    public void setSuppliersname(String suppliersname) {
        this.suppliersname = suppliersname == null ? null : suppliersname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_c_suppliers.invalid
     *
     * @return the value of lm_c_suppliers.invalid
     *
     * @mbggenerated
     */
    public String getInvalid() {
        return invalid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_c_suppliers.invalid
     *
     * @param invalid the value for lm_c_suppliers.invalid
     *
     * @mbggenerated
     */
    public void setInvalid(String invalid) {
        this.invalid = invalid == null ? null : invalid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_c_suppliers.createTime
     *
     * @return the value of lm_c_suppliers.createTime
     *
     * @mbggenerated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_c_suppliers.createTime
     *
     * @param createtime the value for lm_c_suppliers.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_c_suppliers.updateTime
     *
     * @return the value of lm_c_suppliers.updateTime
     *
     * @mbggenerated
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_c_suppliers.updateTime
     *
     * @param updatetime the value for lm_c_suppliers.updateTime
     *
     * @mbggenerated
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}