package com.iboray.lms.domain.vo;

import java.io.Serializable;

public class UsecompVO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8664911432057139826L;

	private Integer id;

	private String usecompno;

	private String usecompcode;

	private String usecompname;

	private String sortname1;

	private String sortname2;

	private String fkParentusecompno;

	private String invalid;

	private String createtime;

	private String updatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsecompno() {
		return usecompno;
	}

	public void setUsecompno(String usecompno) {
		this.usecompno = usecompno == null ? null : usecompno.trim();
	}

	public String getUsecompcode() {
		return usecompcode;
	}

	public void setUsecompcode(String usecompcode) {
		this.usecompcode = usecompcode == null ? null : usecompcode.trim();
	}

	public String getUsecompname() {
		return usecompname;
	}

	public void setUsecompname(String usecompname) {
		this.usecompname = usecompname == null ? null : usecompname.trim();
	}

	public String getSortname1() {
		return sortname1;
	}

	public void setSortname1(String sortname1) {
		this.sortname1 = sortname1 == null ? null : sortname1.trim();
	}

	public String getSortname2() {
		return sortname2;
	}

	public void setSortname2(String sortname2) {
		this.sortname2 = sortname2 == null ? null : sortname2.trim();
	}

	public String getFkParentusecompno() {
		return fkParentusecompno;
	}

	public void setFkParentusecompno(String fkParentusecompno) {
		this.fkParentusecompno = fkParentusecompno == null ? null
				: fkParentusecompno.trim();
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

}
