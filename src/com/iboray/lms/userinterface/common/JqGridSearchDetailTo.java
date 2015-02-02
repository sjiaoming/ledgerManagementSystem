package com.iboray.lms.userinterface.common;

import java.io.Serializable;

public class JqGridSearchDetailTo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4249044554694362308L;
	private String field;  	//查询字段
	private String op;		//查询操作
	private String data;	//选择的查询值
	
	public JqGridSearchDetailTo(){
		
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
