package com.iboray.lms.infrastructure.utils;

import java.util.Arrays;
import java.util.List;


public class ArrayUtil {
	
	private ArrayUtil(){}
	
	public static final String array2Str(Object[] args){
		StringBuffer strbuf = new StringBuffer();
		
		if(args==null || args.length==0){
			return "";
		}
		
		for(Object obj : args){
			strbuf.append(obj).append("|");
		}
		
		return strbuf.substring(0,strbuf.toString().length()-1);
	}
	public static final List<String> Strs2List(String[] args){
		return Arrays.asList(args);
	}
}
