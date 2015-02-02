package com.lms.test;
   
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  
   



import com.lms.test.Criterion.CompareType;
import com.opensymphony.xwork2.ActionSupport;  
   
@SuppressWarnings("serial")  
public abstract class JqGridBaseAction<T> extends ActionSupport {  
    private List<T> gridModel = Collections.emptyList();  
    private Integer rows = 0;  
    private Integer page = 0;  
    private Integer total = 0;  
    private Integer record = 0;  
    private String sord;  
    private String sidx;  
       
    // (1)添加和查询有关的成员变量search、searchField、searchString、searchOper  
    private boolean search;  
    private String searchField;  
    private String searchString;  
    private String searchOper;  
    private String filters; 
    public abstract int getResultSize();  
    public abstract List<T> listResults(int from, int length);  
       
    // (2)添加用于根据条件进行查询的方法   
    public abstract int getResultSize(List<Criterion> criteria);  
    public abstract List<T> listResults(List<Criterion> criteria, int from, int length);  
   
    public String refreshGridModel() {  
        try {  
            List<Criterion> criteria = Collections.emptyList();  
               
            // (3)如果search值为true，则表明是查询请求   
            if(search == true) {  
            	criteria = new ArrayList<Criterion>();  
            	// (2)将Filter转化为Criterion列表，并加入总的Criterion列表    
                if(filters != null && filters.length()>0) {    
                    criteria.addAll(this.generateSearchCriteriaFromFilters(filters));    
                } 
                
                // (4)通过searchField、searchString、searchOper生成通用的查询条件  
                Criterion criterion = this.generateSearchCriterion(searchField, searchString, searchOper);  
                if(criterion != null) {  
                    criteria.add(criterion);  
                }  
            }  
               
            int from = rows * (page - 1);  
            int length = rows;  
               
            List<T> results = Collections.emptyList();  
               
            if(!criteria.isEmpty()) {   // (5)如果criteria列表不为空，则根据条件进行查询  
                record = this.getResultSize(criteria);  
                results = this.listResults(criteria, from, length);  
                  
            } else {  
                record = this.getResultSize();  
                results = this.listResults(from, length);  
                  
            }  
               
            this.setGridModel(results);  
            total = (int) Math.ceil((double) record / (double) rows);  
            return SUCCESS;  
        } catch (Exception e) {  
            e.printStackTrace();  
            this.addActionError(e.getMessage());  
            return ERROR;  
        }  
    }  
      
    // (6)通过searchField、searchString、searchOper三个参数生成Criterion的方法  
    public Criterion generateSearchCriterion(String searchField,  
            String searchString, String searchOper) {  
        Criterion criterion = null;  
          
        // (7)如果searchField、searchString、searchOper均不为null，且searchString不为空字符串时，则创建Criterion  
        if (searchField != null && searchString != null  
                & searchString.length() > 0 && searchOper != null) {  
            if ("eq".equals(searchOper)) {  
                criterion = Criterion.getEqualCriterion(searchField,  
                        searchString, null);  
            } else if ("ne".equals(searchOper)) {  
                criterion = Criterion.getCompareCriterion(CompareType.NE,  
                        searchField, searchString, null);  
            } else if ("lt".equals(searchOper)) {  
                criterion = Criterion.getCompareCriterion(CompareType.LT,  
                        searchField, searchString, null);  
            } else if ("le".equals(searchOper)) {  
                criterion = Criterion.getCompareCriterion(CompareType.LTE,  
                        searchField, searchString, null);  
            } else if ("gt".equals(searchOper)) {  
                criterion = Criterion.getCompareCriterion(CompareType.GT,  
                        searchField, searchString, null);  
            } else if ("ge".equals(searchOper)) {  
                criterion = Criterion.getCompareCriterion(CompareType.GTE,  
                        searchField, searchString, null);  
            } else if ("bw".equals(searchOper)) {  
                criterion = Criterion.getLikeCriterion(searchField,  
                        searchString + "%", null);  
            } else if ("bn".equals(searchOper)) {  
                criterion = Criterion.getNotLikeCriterion(searchField,  
                        searchString + "%", null);  
            } else if ("ew".equals(searchOper)) {  
                criterion = Criterion.getLikeCriterion(searchField, "%"  
                        + searchString, null);  
            } else if ("en".equals(searchOper)) {  
                criterion = Criterion.getNotLikeCriterion(searchField, "%"  
                        + searchString, null);  
            } else if ("cn".equals(searchOper)) {  
                criterion = Criterion.getLikeCriterion(searchField, "%"  
                        + searchString + "%", null);  
            } else if ("nc".equals(searchOper)) {  
                criterion = Criterion.getNotLikeCriterion(searchField, "%"  
                        + searchString + "%", null);  
            }  
        }  
        return criterion;  
    }
    public List<Criterion> generateSearchCriteriaFromFilters(String filters) {  
        List<Criterion> criteria = new ArrayList<Criterion>();  
          
//        JSONObject jsonObject = JSONObject.fromObject(filters);  
//          
//        JSONArray rules = jsonObject.getJSONArray("rules");  
//          
//        for(Object obj : rules) {  
//            JSONObject rule = (JSONObject) obj;  
//              
//            String field = rule.getString("field");  
//            String op = rule.getString("op");  
//            String data = rule.getString("data");  
//              
//            Criterion criterion = this.generateSearchCriterion(field, data, op);  
//              
//            if(criterion != null) {  
//                criteria.add(criterion);  
//            }  
//        }  
          
        return criteria;  
    }
	public List<T> getGridModel() {
		return gridModel;
	}
	public void setGridModel(List<T> gridModel) {
		this.gridModel = gridModel;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRecord() {
		return record;
	}
	public void setRecord(Integer record) {
		this.record = record;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
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
