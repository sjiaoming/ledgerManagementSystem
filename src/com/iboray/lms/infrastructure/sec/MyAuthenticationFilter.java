package com.iboray.lms.infrastructure.sec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.iboray.lms.application.service.UserService;
import com.iboray.lms.domain.vo.UserVO;


public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private UserService us;
	
	public void setUs(UserService us) {
		this.us = us;
	}

	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
//		System.out.println(">>>>>>>>>>>>>>111111>>>>>>>>>>>username: "+obtainUsername(request));
		String msg="";
		UserVO uv = null;
		try{
			uv = us.findUserByNameAndPwd(obtainUsername(request), obtainPassword(request));
		}catch (RuntimeException re){
			msg = re.getMessage();
//			System.out.println(">>>>>>>>>>>>>>msg>>>>>>>>>>>msg: "+msg);
		}
		
		if(!StringUtils.isEmpty(msg)){
//			msg = "username or password is error";
			BadCredentialsException exp = new BadCredentialsException(msg);
			throw exp;
		}
		request.getSession().setAttribute("user", uv);
		UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(obtainUsername(request), obtainPassword(request));
		setDetails(request, upat);
		return this.getAuthenticationManager().authenticate(upat);
	}
	
	
	
}
