package com.iboray.lms.userinterface.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iboray.lms.infrastructure.utils.JsonPojoMapper;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Action基类
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4669197267749902284L;
	public static final String FINDBYPAGE = "findByPage";
	public static final String INDEX = "index";
	/**
	 * pager对象
	 */
	protected Pager<T> pager;
	/**
	 * 多个ID
	 */
	protected Integer[] ids;
	/**
	 * 单个ID
	 */
	protected Integer id;
	/**
	 * 多个No
	 */
	protected String nos;
	/**
	 * 单个No
	 */
	protected String no;
	
	protected String searchField;
	protected String searchString;
	protected String searchOper;
	protected String filters;
	protected String sidx;
	protected String sord;
	protected boolean _search;
	protected String nd;
	
	protected String add;
	protected String addoper;
	protected String editoper;
	protected String deloper;
	
	public JqGridSearchTo getJqGridSearchTo(){
		JqGridSearchTo to=null;
		if(filters!=null && !StringUtils.isEmpty(filters)){
			try {
				to = (JqGridSearchTo) JsonPojoMapper.fromJson(filters, JqGridSearchTo.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			to = new JqGridSearchTo();
		}
//		to.setPage(Integer.parseInt(page));
//		to.setRows(Integer.parseInt(rows));
		to.setSidx(sidx);
		to.setSord(sord);
		to.setSearchField(searchField);
		to.setSearchOper(searchOper);
		to.setSearchString(searchString);
		to.set_search(_search);
		return to;
	}
	/**
	 * 获取页面传值
	 * @param str
	 * @return
	 */
	public String getParameter(String str){
		return ServletActionContext.getRequest().getParameter(str);
	}
	/**
	 * 给页面传值
	 * @param name
	 * @param o
	 */
	public void setAttribute(String name,Object o){
		ServletActionContext.getRequest().setAttribute(name, o);
	}
	/**
	 * 获取attribute值
	 * @param name
	 * @return
	 */
	public Object getAttribute(String name){
		return ServletActionContext.getRequest().getAttribute(name);
	}
	/**
	 * 获取request
	 * @return
	 */
	public HttpServletRequest request(){
		return ServletActionContext.getRequest();
	}
	/**
	 * 获取response
	 * @return
	 */
	public HttpServletResponse response(){
		return ServletActionContext.getResponse();
	}
	/**
	 * 获取session
	 * @return
	 */
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	public int getPageNo(){
		if(pager==null||pager.getOffset()==0)
			return 0;
		return (pager.getOffset()-1)*pager.getPageSize();
	}
	public Pager<T> getPager() {
		return pager;
	}
	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNos() {
		return nos;
	}
	public void setNos(String nos) {
		this.nos = nos;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField.equals("")?null:searchField;
	}
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString.equals("")?null:searchString;
	}
	public String getSearchOper() {
		return searchOper;
	}
	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper.equals("")?null:searchOper;
	}
	public String getFilters() {
		return filters;
	}
	public void setFilters(String filters) {
		this.filters = filters;
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
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public boolean is_search() {
		return _search;
	}
	public void set_search(boolean _search) {
		this._search = _search;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getAddoper() {
		return addoper;
	}
	public void setAddoper(String addoper) {
		this.addoper = addoper;
	}
	public String getEditoper() {
		return editoper;
	}
	public void setEditoper(String editoper) {
		this.editoper = editoper;
	}
	public String getDeloper() {
		return deloper;
	}
	public void setDeloper(String deloper) {
		this.deloper = deloper;
	}
	
}
