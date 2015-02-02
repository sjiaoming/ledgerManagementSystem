package com.iboray.lms.userinterface.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.iboray.lms.application.service.XScontractService;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.domain.vo.XscontractVO;
import com.iboray.lms.infrastructure.utils.JqGridToVO;
import com.iboray.lms.infrastructure.utils.JsonPojoMapper;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class XScontractAction extends BaseAction<XscontractVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5900877451051157072L;

	private XScontractService xscontractService;
	
	private XscontractVO xscontract;
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
			xscontract.setFkUserno(uv.getUserno());
			xscontract.setFkDeptno(uv.getFkDeptno());
			xscontract.setXscontractnum(xscontractService.create(xscontract,planNo,plan));
		}
		PrintWriter pw = null;
		try {
			pw = response().getWriter();
			pw.write(xscontract.getXscontractnum());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return null;
	}
	public String delete(){
		xscontractService.deleteByNos(nos.trim().split(","));
		return findByPager();
	}
	public String findByPager(){
		JqGridSearchTo to=getJqGridSearchTo();
		
		XscontractVO pv=null;
		if(to!=null)
			pv = (XscontractVO)JqGridToVO.getVOfromJqGrid(to, XscontractVO.class);
		if(pager == null){
			pager = new Pager<XscontractVO>();
		}
		pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		UserVO user = (UserVO)ServletActionContext.getRequest().getSession().getAttribute("user");
		pager = xscontractService.findByVO(pv, to,getPageNo(), pager.getPageSize(),user);
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
	public void setXscontractService(XScontractService xscontractService) {
		this.xscontractService = xscontractService;
	}
	public XscontractVO getXscontract() {
		return xscontract;
	}
	public void setXscontract(XscontractVO xscontract) {
		this.xscontract = xscontract;
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
