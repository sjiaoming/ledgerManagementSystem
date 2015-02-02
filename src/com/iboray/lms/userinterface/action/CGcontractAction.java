package com.iboray.lms.userinterface.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.iboray.lms.application.service.CGcontractService;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.vo.CGcontractVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.utils.JqGridToVO;
import com.iboray.lms.infrastructure.utils.JsonPojoMapper;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class CGcontractAction extends BaseAction<CGcontractVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7831183602722529185L;

	private CGcontractService cgcontractService;
	
	private CGcontractVO cgcontract;
	
	private PlanVO plan;
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
			UserVO uv = (UserVO)ServletActionContext.getRequest().getSession().getAttribute("user");
			cgcontract.setFkUserno(uv.getUserno());
			cgcontract.setFkDeptno(uv.getFkDeptno());
			cgcontract.setCgcontractnum(cgcontractService.create(cgcontract,planNo,plan));
		}
//		ajaxResult = JsonPojoMapper.toJson(SUCCESS, false);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(cgcontract.getCgcontractnum());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
//		ServletActionContext.getRequest().setAttribute("ajaxResult","{\"ajaxResult\":\""+cgcontract.getCgcontractnum()+"\"}");
		return null;
	}
	public String delete(){
		cgcontractService.deleteByNos(nos.trim().split(","));
		return findByPager();
	}
	public String findByPager(){
		JqGridSearchTo to=getJqGridSearchTo();
		
		CGcontractVO pv=null;
		if(to!=null)
			pv = (CGcontractVO)JqGridToVO.getVOfromJqGrid(to, CGcontractVO.class);
		if(pager == null){
			pager = new Pager<CGcontractVO>();
		}
		pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		UserVO user = (UserVO)ServletActionContext.getRequest().getSession().getAttribute("user");
		pager = cgcontractService.findByVO(pv, to,getPageNo(), pager.getPageSize(),user);
		if(pager.getTotalNum()<1)
			setAttribute("msg", "没有数据!");
		String cgcontractJsonStr = JsonPojoMapper.toJson(pager, true);
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(cgcontractJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return null;
		
	}
	public void setCgcontractService(CGcontractService cgcontractService) {
		this.cgcontractService = cgcontractService;
	}
	public CGcontractVO getCgcontract() {
		return cgcontract;
	}
	public void setCgcontract(CGcontractVO cgcontract) {
		this.cgcontract = cgcontract;
	}
	public PlanVO getPlan() {
		return plan;
	}
	public void setPlan(PlanVO plan) {
		this.plan = plan;
	}
	public String getAjaxResult() {
		return ajaxResult;
	}
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
	
	
}
