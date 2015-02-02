package com.iboray.lms.infrastructure.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	private DateFormatUtil(){}
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static String date2Str(Date date){
		String str = sdf.format(date);
		return str;
	}
	
	public static String now2Str(){
		String str = sdf.format(new Date());
		return str;
	}
	
	public static Date str2Date(String str){
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			new RuntimeException("String Format is not yyyyMMddHHmmss");
		}
		return date;
	}
	
	public static void main(String[] args) {
		
		String str = DateFormatUtil.date2Str(new Date());
		System.out.println(str);
		
		Date date = DateFormatUtil.str2Date(str);
		System.out.println(date);
	}

}
