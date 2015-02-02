package com.iboray.lms.userinterface.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.iboray.lms.application.service.MResourceService;
import com.iboray.lms.application.service.RoleService;
import com.iboray.lms.domain.vo.MResourceRoleVO;
import com.iboray.lms.domain.vo.MResourceVO;
import com.iboray.lms.domain.vo.RoleVO;


public class RoleAction extends BaseAction<RoleVO>{
	private static final long serialVersionUID = -1497791518786618295L;
	
	private RoleService roleService;
	
	private MResourceService mResourceService;
	
	private MResourceVO mResourceVO;
	
	private RoleVO rv;
	

	
	public String showList(){
		List<RoleVO> l = roleService.findAll();
		setAttribute("roles", l);
		return "showList";
	}
	public String showImpower(){
		List<MResourceVO> res = mResourceService.findAll();
		Set<MResourceVO> set = null;
		List<String> res_no = new ArrayList<String>();
		if(no != null && !StringUtils.isEmpty(no)){
			RoleVO role = roleService.findByNo(no);
			if(role!=null){
				set = roleService.findMResourceByRoleNo(role.getRoleno());
			}
			
		}
		if(set!=null &&!set.isEmpty()){
			for(Iterator<MResourceVO> it = set.iterator();it.hasNext();){
				res_no.add(it.next().getMresourceno());
			}
		}
		
		setAttribute("res_no",res_no);
		setAttribute("mainBodyId", no);
		setAttribute("rl", res);
		//setAttribute("role",role);
		
		return "showImpower";
	}
//	
	public String impower(){

		MResourceRoleVO mresourceRoleVO = new MResourceRoleVO();
		RoleVO rolevo = roleService.findByNo(no);
		String[] tempNos = nos.split(",");
		if(nos!=null && tempNos.length > 0 ){
			Set<MResourceVO> resourceSet = new HashSet<MResourceVO>();
			for(int i=0;i<tempNos.length;i++){
				MResourceVO re = mResourceService.findByNo(tempNos[i]);
				if(re!=null){
					resourceSet.add(re);
				}
			}
			mresourceRoleVO.setMresourceVOs(resourceSet);
		}
		mresourceRoleVO.setRoleVO(rolevo);
		roleService.createRoleMResource(mresourceRoleVO);
		
		return showList();
	}
	public String showAddInput(){
		return "addInput";
	}
	public String saveRole(){
		roleService.createRole(rv);
		return showList();
	}
//	public String deleteRole(){
//		roleService.deleteByLogic(ids);
//		return showList();
//	}
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public RoleVO getRv() {
		return rv;
	}

	public void setRv(RoleVO rv) {
		this.rv = rv;
	}
	public MResourceService getmResourceService() {
		return mResourceService;
	}
	public void setmResourceService(MResourceService mResourceService) {
		this.mResourceService = mResourceService;
	}
	public MResourceVO getmResourceVO() {
		return mResourceVO;
	}
	public void setmResourceVO(MResourceVO mResourceVO) {
		this.mResourceVO = mResourceVO;
	}
	
	
	
}
