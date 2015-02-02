package com.lms.test;

import com.iboray.lms.infrastructure.utils.JsonPojoMapper;




public class Tests {

	public static void main(String[] args) {
		String str = "success";
		System.out.println(JsonPojoMapper.toJson(str, false));
	}

}
