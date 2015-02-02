package com.iboray.lms.infrastructure.sec;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {

	
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
//		System.out.println(">>>>>>>>>>>>>5555555>>>>>>>>>>MyAccessDecisionManager>> : ");
		if(configAttributes == null){
			return;
		}
		Iterator<ConfigAttribute> it = configAttributes.iterator();
		while(it.hasNext()){
			ConfigAttribute ca = it.next();
			String needPermission = ca.getAttribute();
			for(GrantedAuthority ga : authentication.getAuthorities()){
				if(needPermission.equals(ga.getAuthority())){
					return;
				}
			}
		}
		throw new AccessDeniedException("have not power!");
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	
}
