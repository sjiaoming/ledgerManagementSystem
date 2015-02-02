package com.iboray.lms.userinterface.action;

import org.apache.commons.lang.StringUtils;

import com.iboray.lms.application.service.MResourceService;
import com.iboray.lms.domain.vo.MResourceVO;

public class MResourceAction extends BaseAction<MResourceVO>{
	private static final long serialVersionUID = -2459982733543947188L;
	private MResourceService mResourceService;
	private MResourceVO resource;
	public String showList(){
		setAttribute("resources", mResourceService.findAllParentMResource());
		return "showList";
	}
	public String showListById(){
		setAttribute("resources", mResourceService.findByFk_No(no));
		return "showList";
	}
	public String showAddInput(){
		setAttribute("parentResources", mResourceService.findAllParentMResource());
		return "addInput";
	}
	public String saveRes(){
		if(no != null || !StringUtils.isEmpty(no))
			resource.setFkMresourceno(no);
		mResourceService.createMResource(resource);
//		MySecurityMetadataSource m = new MySecurityMetadataSource()
		return showList();
	}
//	public String deleteRes(){
//		resourceService.deleteByLogic(ids);
//		return showList();
//	}
	public MResourceService getmResourceService() {
		return mResourceService;
	}
	public void setmResourceService(MResourceService mResourceService) {
		this.mResourceService = mResourceService;
	}
	public MResourceVO getResource() {
		return resource;
	}
	public void setResource(MResourceVO resource) {
		this.resource = resource;
	}
	
}
