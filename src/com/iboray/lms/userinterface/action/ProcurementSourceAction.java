package com.iboray.lms.userinterface.action;

import org.apache.struts2.ServletActionContext;

import com.iboray.lms.application.service.ProcurementSourceService;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.ProcurementSourceVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.utils.JsonPojoMapper;

public class ProcurementSourceAction extends BaseAction<ProcurementSourceVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6641820669110470023L;

	private ProcurementSourceService procurementSourceService;
	
	private PlanVO plan;
	
	private ProcurementSourceVO procurementSource;
	private String ajaxResult;
	public String save() {
		if(nos!=null && nos.length()>0){
			nos = nos.trim();
			String[] planNo;
			if(nos.indexOf("\"")>0){
				nos = nos.replaceAll("\"", "");
				planNo= nos.substring(1,nos.length()-1).split(",");
			}else
				planNo = nos.split(",");
			UserVO uv = (UserVO)getSession().getAttribute("user");
			procurementSource.setFkUserno(uv.getUserno());
			procurementSource.setFkDeptno(uv.getFkDeptno());
			procurementSourceService.create(procurementSource,planNo,plan,uv);
		}
		ajaxResult = JsonPojoMapper.toJson(SUCCESS, false);
//		ServletActionContext.getRequest().setAttribute("ajaxResult",ajaxResult);
		ServletActionContext.getRequest().setAttribute("ajaxResult","{\"ajaxResult\":\"success\"}");
		return null;
	}
	public String delete(){
		procurementSourceService.deleteByNos(nos.trim().split(","));
		return findByPager();
	}
	public String findByPager(){
		int pageSize = 5;
		pager = procurementSourceService.findAll(getPageNo(), pageSize);
		setAttribute("pager", pager);
		return FINDBYPAGE;
	}
	public ProcurementSourceVO getProcurementSource() {
		return procurementSource;
	}
	public void setProcurementSource(ProcurementSourceVO procurementSource) {
		this.procurementSource = procurementSource;
	}
	public String getAjaxResult() {
		return ajaxResult;
	}
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
	public void setProcurementSourceService(
			ProcurementSourceService procurementSourceService) {
		this.procurementSourceService = procurementSourceService;
	}
	public PlanVO getPlan() {
		return plan;
	}
	public void setPlan(PlanVO plan) {
		this.plan = plan;
	}

	
}
