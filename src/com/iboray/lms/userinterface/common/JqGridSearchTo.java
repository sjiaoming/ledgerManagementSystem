package com.iboray.lms.userinterface.common;

import java.io.Serializable;
import java.util.List;

public class JqGridSearchTo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8737277386517688743L;
	private String groupOp;		//多字段查询时分组类型，主要是AND或者OR
	private List<JqGridSearchDetailTo> rules; //多字段查询时候，查询条件的集合
	
	private int page;	//当前第几页
	private int rows;	//每页显示多少条数据
	private String sidx; 	//排序字段	
	private String sord;	//排序类型 ASC或者DESC
	private boolean _search;	//是否是查询 true 或者 false
	private String nd;		//暂时不清楚啥用的
	
	private String searchField;		//单字段查询的时候，查询字段名称
	private String searchString;	//单字段查询的时候，查询字段的值
	private String searchOper;		//单字段查询的时候，查询的操作
	
	public JqGridSearchTo(){
		
	}

	public String getGroupOp() {
		return groupOp;
	}

	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}



	public List<JqGridSearchDetailTo> getRules() {
		return rules;
	}

	public void setRules(List<JqGridSearchDetailTo> rules) {
		this.rules = rules;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public boolean is_search() {
		return _search;
	}

	public void set_search(boolean _search) {
		this._search = _search;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

}
