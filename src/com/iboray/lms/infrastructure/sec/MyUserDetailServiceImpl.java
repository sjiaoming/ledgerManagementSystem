package com.iboray.lms.infrastructure.sec;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.iboray.lms.application.service.UserService;
import com.iboray.lms.domain.vo.MResourceVO;
import com.iboray.lms.domain.vo.UserRoleVO;
import com.iboray.lms.domain.vo.UserVO;

public class MyUserDetailServiceImpl implements UserDetailsService{
	
	UserService us;
	
	public void setUs(UserService us) {
		this.us = us;
	}

	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
//		System.out.println(">>>>>>>>>>>>>22222222>>>>>>>>>>>>request username : "+arg0);
		UserVO u = us.findUserByName(arg0);
		User ud = new User(u.getUsername(), u.getPassword(), true, true, true, true, obtionGrantedAuthorities(u));
		return ud;
	}
	
	private Set<GrantedAuthority> obtionGrantedAuthorities(UserVO u){
		UserRoleVO userRoleVO = us.findRolesByUserNo(u.getUserno());
		
		Set<GrantedAuthority> ga = new HashSet<GrantedAuthority>();
		for(MResourceVO mResource : userRoleVO.getMresourceVOs()){
//			System.out.println(">>>>>>2222>>>>>>impower : "+"ROLE_"+mResource.getMresourcename());
			ga.add(new SimpleGrantedAuthority("ROLE_"+mResource.getMresourceno()));
		}
		
		return ga;
	}
	

	
}
