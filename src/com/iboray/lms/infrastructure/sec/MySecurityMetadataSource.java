package com.iboray.lms.infrastructure.sec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.iboray.lms.application.service.MResourceService;
import com.iboray.lms.domain.vo.MResourceVO;

public class MySecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	public MySecurityMetadataSource(MResourceService res){
		this.res = res;
		loadResource();
	}
	private MResourceService res;
	
	public void setRes(MResourceService res) {
		this.res = res;
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String reqUrl = ((FilterInvocation)object).getRequestUrl().trim();
//		System.out.println(">>>>>>>>>>>>>444444>>>MySecurityMetadataSource>>>>return need power, requestUrl: "+reqUrl);
		if(resMap == null){
			loadResource();
		}
		if(reqUrl.indexOf('?')!=-1){
			reqUrl = reqUrl.substring(0, reqUrl.indexOf('?')).trim();
		}
		return resMap.get(reqUrl);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	private static Map<String,Collection<ConfigAttribute>> resMap = null;
	
	private void loadResource(){
		if(resMap == null){
			resMap = new HashMap<String,Collection<ConfigAttribute>>();
			List<MResourceVO> resources = res.findAll();
			for(MResourceVO resource : resources){
				Collection<ConfigAttribute> cfas = new ArrayList<ConfigAttribute>();
				ConfigAttribute cfa = new SecurityConfig("ROLE_"+resource.getMresourceno());
				cfas.add(cfa);
				resMap.put(resource.getMresourceurl(), cfas);
			}
		}
	}
	public void refreshMetadata(){
		loadResource();
	}
}
