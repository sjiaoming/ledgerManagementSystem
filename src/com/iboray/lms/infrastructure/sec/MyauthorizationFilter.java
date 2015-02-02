package com.iboray.lms.infrastructure.sec;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyauthorizationFilter extends AbstractSecurityInterceptor implements Filter{

	private FilterInvocationSecurityMetadataSource fisms;
	
	public FilterInvocationSecurityMetadataSource getFisms() {
		return fisms;
	}

	public void setFisms(FilterInvocationSecurityMetadataSource fisms) {
		this.fisms = fisms;
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//		System.out.println(">>>>>>>>>>>>>333333>>>>>>>>>>MyauthorizationFilter ");
		
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		//1 load resource 2 check permission
		InterceptorStatusToken ist = super.beforeInvocation(fi);
		
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(ist, null);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.fisms;
	}

	
}
