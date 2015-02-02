package com.iboray.lms.userinterface.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.iboray.lms.application.service.DeptService;
import com.iboray.lms.application.service.RoleService;
import com.iboray.lms.application.service.UserService;
import com.iboray.lms.domain.vo.DeptVO;
import com.iboray.lms.domain.vo.RoleVO;
import com.iboray.lms.domain.vo.UserRoleVO;
import com.iboray.lms.domain.vo.UserVO;

public class UserAction extends BaseAction<UserVO> {

	private UserService userService;
	
	private RoleService roleService;
	
	private DeptService deptService;
	
	private UserVO user;
	
	private DeptVO dept;
	
	private static final long serialVersionUID = 3272916596151277129L;

	//添加用户
	public String saveUser() {
		UserRoleVO urv = new UserRoleVO();
		String[] tempNos = nos.split(",");
		if(nos!=null && tempNos.length > 0 ){
			Set<RoleVO> roleSet = new HashSet<RoleVO>();
			for(int i=0;i<tempNos.length;i++){
				RoleVO re = roleService.findByNo(tempNos[i]);
				if(re!=null){
					roleSet.add(re);
				}
			}
			urv.setRoleVOs(roleSet);
		}
		urv.setUserVO(user);
		userService.createUser(urv);
		return SUCCESS;
	}
//	
//	public String findUser(){
//		List<User> users = userService.findAll();
//		setAttribute("users", users);
//		setAttribute("ul", users.size());
//		return FINDBYPAGE;
//	}
//	
	public String deleteUsers(){
		userService.deleteByNos(nos.split(","));
		return findUsersPager();
	}
//	
	public String findUsersPager(){
		int pageSize = 5;
		pager = userService.findAll(getPageNo(), pageSize);
		setAttribute("pager", pager);
		return FINDBYPAGE;
	}
	public String index(){
		List<DeptVO> depts = deptService.findAll();
		List<RoleVO> roles = roleService.findAll();
		setAttribute("roles", roles);
		setAttribute("depts", depts);
		return "index";
	}
	public String login(){
		return "islogin";
	}
	public String logout(){
			UserVO u = (UserVO)getSession().getAttribute("user");
		if(u!=null)
			getSession().removeAttribute("user");
		
		return ERROR;
		
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	public DeptService getDeptService() {
		return deptService;
	}
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	public DeptVO getDept() {
		return dept;
	}
	public void setDept(DeptVO dept) {
		this.dept = dept;
	}

	
}
