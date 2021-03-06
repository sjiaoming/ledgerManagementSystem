package com.iboray.lms.domain.entity;

public class ProcurementSource {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.procurementNo
     *
     * @mbggenerated
     */
    private String procurementno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.procurementName
     *
     * @mbggenerated
     */
    private String procurementname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.procurementWayCode
     *
     * @mbggenerated
     */
    private String procurementwaycode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.bNumber
     *
     * @mbggenerated
     */
    private String bnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.fNumber
     *
     * @mbggenerated
     */
    private String fnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.procurementCreateDate
     *
     * @mbggenerated
     */
    private String procurementcreatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.procurementAuditDate
     *
     * @mbggenerated
     */
    private String procurementauditdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.searchAnnouncedDate
     *
     * @mbggenerated
     */
    private String searchannounceddate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.searchAuditDate
     *
     * @mbggenerated
     */
    private String searchauditdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.ExecutionWayCode
     *
     * @mbggenerated
     */
    private String executionwaycode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.FK_userNo
     *
     * @mbggenerated
     */
    private String fkUserno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.FK_deptNo
     *
     * @mbggenerated
     */
    private String fkDeptno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.invalid
     *
     * @mbggenerated
     */
    private String invalid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.createTime
     *
     * @mbggenerated
     */
    private String createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lm_d_procurementsource.updateTime
     *
     * @mbggenerated
     */
    private String updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.id
     *
     * @return the value of lm_d_procurementsource.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.id
     *
     * @param id the value for lm_d_procurementsource.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.procurementNo
     *
     * @return the value of lm_d_procurementsource.procurementNo
     *
     * @mbggenerated
     */
    public String getProcurementno() {
        return procurementno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.procurementNo
     *
     * @param procurementno the value for lm_d_procurementsource.procurementNo
     *
     * @mbggenerated
     */
    public void setProcurementno(String procurementno) {
        this.procurementno = procurementno == null ? null : procurementno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.procurementName
     *
     * @return the value of lm_d_procurementsource.procurementName
     *
     * @mbggenerated
     */
    public String getProcurementname() {
        return procurementname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.procurementName
     *
     * @param procurementname the value for lm_d_procurementsource.procurementName
     *
     * @mbggenerated
     */
    public void setProcurementname(String procurementname) {
        this.procurementname = procurementname == null ? null : procurementname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.procurementWayCode
     *
     * @return the value of lm_d_procurementsource.procurementWayCode
     *
     * @mbggenerated
     */
    public String getProcurementwaycode() {
        return procurementwaycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.procurementWayCode
     *
     * @param procurementwaycode the value for lm_d_procurementsource.procurementWayCode
     *
     * @mbggenerated
     */
    public void setProcurementwaycode(String procurementwaycode) {
        this.procurementwaycode = procurementwaycode == null ? null : procurementwaycode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.bNumber
     *
     * @return the value of lm_d_procurementsource.bNumber
     *
     * @mbggenerated
     */
    public String getBnumber() {
        return bnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.bNumber
     *
     * @param bnumber the value for lm_d_procurementsource.bNumber
     *
     * @mbggenerated
     */
    public void setBnumber(String bnumber) {
        this.bnumber = bnumber == null ? null : bnumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.fNumber
     *
     * @return the value of lm_d_procurementsource.fNumber
     *
     * @mbggenerated
     */
    public String getFnumber() {
        return fnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.fNumber
     *
     * @param fnumber the value for lm_d_procurementsource.fNumber
     *
     * @mbggenerated
     */
    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.procurementCreateDate
     *
     * @return the value of lm_d_procurementsource.procurementCreateDate
     *
     * @mbggenerated
     */
    public String getProcurementcreatedate() {
        return procurementcreatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.procurementCreateDate
     *
     * @param procurementcreatedate the value for lm_d_procurementsource.procurementCreateDate
     *
     * @mbggenerated
     */
    public void setProcurementcreatedate(String procurementcreatedate) {
        this.procurementcreatedate = procurementcreatedate == null ? null : procurementcreatedate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.procurementAuditDate
     *
     * @return the value of lm_d_procurementsource.procurementAuditDate
     *
     * @mbggenerated
     */
    public String getProcurementauditdate() {
        return procurementauditdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.procurementAuditDate
     *
     * @param procurementauditdate the value for lm_d_procurementsource.procurementAuditDate
     *
     * @mbggenerated
     */
    public void setProcurementauditdate(String procurementauditdate) {
        this.procurementauditdate = procurementauditdate == null ? null : procurementauditdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.searchAnnouncedDate
     *
     * @return the value of lm_d_procurementsource.searchAnnouncedDate
     *
     * @mbggenerated
     */
    public String getSearchannounceddate() {
        return searchannounceddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.searchAnnouncedDate
     *
     * @param searchannounceddate the value for lm_d_procurementsource.searchAnnouncedDate
     *
     * @mbggenerated
     */
    public void setSearchannounceddate(String searchannounceddate) {
        this.searchannounceddate = searchannounceddate == null ? null : searchannounceddate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.searchAuditDate
     *
     * @return the value of lm_d_procurementsource.searchAuditDate
     *
     * @mbggenerated
     */
    public String getSearchauditdate() {
        return searchauditdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.searchAuditDate
     *
     * @param searchauditdate the value for lm_d_procurementsource.searchAuditDate
     *
     * @mbggenerated
     */
    public void setSearchauditdate(String searchauditdate) {
        this.searchauditdate = searchauditdate == null ? null : searchauditdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.ExecutionWayCode
     *
     * @return the value of lm_d_procurementsource.ExecutionWayCode
     *
     * @mbggenerated
     */
    public String getExecutionwaycode() {
        return executionwaycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.ExecutionWayCode
     *
     * @param executionwaycode the value for lm_d_procurementsource.ExecutionWayCode
     *
     * @mbggenerated
     */
    public void setExecutionwaycode(String executionwaycode) {
        this.executionwaycode = executionwaycode == null ? null : executionwaycode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.FK_userNo
     *
     * @return the value of lm_d_procurementsource.FK_userNo
     *
     * @mbggenerated
     */
    public String getFkUserno() {
        return fkUserno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.FK_userNo
     *
     * @param fkUserno the value for lm_d_procurementsource.FK_userNo
     *
     * @mbggenerated
     */
    public void setFkUserno(String fkUserno) {
        this.fkUserno = fkUserno == null ? null : fkUserno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.FK_deptNo
     *
     * @return the value of lm_d_procurementsource.FK_deptNo
     *
     * @mbggenerated
     */
    public String getFkDeptno() {
        return fkDeptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.FK_deptNo
     *
     * @param fkDeptno the value for lm_d_procurementsource.FK_deptNo
     *
     * @mbggenerated
     */
    public void setFkDeptno(String fkDeptno) {
        this.fkDeptno = fkDeptno == null ? null : fkDeptno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.invalid
     *
     * @return the value of lm_d_procurementsource.invalid
     *
     * @mbggenerated
     */
    public String getInvalid() {
        return invalid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.invalid
     *
     * @param invalid the value for lm_d_procurementsource.invalid
     *
     * @mbggenerated
     */
    public void setInvalid(String invalid) {
        this.invalid = invalid == null ? null : invalid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.createTime
     *
     * @return the value of lm_d_procurementsource.createTime
     *
     * @mbggenerated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.createTime
     *
     * @param createtime the value for lm_d_procurementsource.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lm_d_procurementsource.updateTime
     *
     * @return the value of lm_d_procurementsource.updateTime
     *
     * @mbggenerated
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lm_d_procurementsource.updateTime
     *
     * @param updatetime the value for lm_d_procurementsource.updateTime
     *
     * @mbggenerated
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}