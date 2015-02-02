package com.iboray.lms.infrastructure.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import com.iboray.lms.userinterface.common.JqGridSearchDetailTo;
import com.iboray.lms.userinterface.common.JqGridSearchTo;

public class JqGridToVO {
	public static <T> Object getVOfromJqGrid(JqGridSearchTo to , Class clazz){
		Object obj = null;
		try {
				obj = clazz.newInstance();
			if (to.is_search() && to.getSearchField() != null && to.getSearchOper() != null ){
				
			}else if(to.is_search() && to.getGroupOp() != null && to.getRules()!= null && to.getRules().size() != 0){
				for(Iterator<JqGridSearchDetailTo> it = to.getRules().iterator();it.hasNext();){
						try {
							JqGridSearchDetailTo jsd = it.next();
							String fieldName = jsd.getField();
							Field vof =  clazz.getDeclaredField(fieldName);
							Class voft = vof.getType();
							Method vofm = clazz.getDeclaredMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), voft);
							if(voft==Integer.class)
								vofm.invoke(obj, Integer.parseInt(jsd.getData()));
							else if(voft==Double.class)
								vofm.invoke(obj, Double.parseDouble(jsd.getData()));
							else
								vofm.invoke(obj, jsd.getData());
							
							String fieldNameOp = fieldName+"Op";
							Field vofop =  clazz.getDeclaredField(fieldNameOp);
							Class voftop = vofop.getType();
							Method vofmop = clazz.getDeclaredMethod("set"+fieldNameOp.substring(0,1).toUpperCase()+fieldNameOp.substring(1), voftop);
							vofmop.invoke(obj, jsd.getOp());
							
							} catch (NoSuchMethodException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}catch (NoSuchFieldException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				}
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return obj;
	}
	

}
