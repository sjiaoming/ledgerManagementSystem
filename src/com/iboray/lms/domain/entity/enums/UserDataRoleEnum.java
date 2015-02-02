package com.iboray.lms.domain.entity.enums;


public enum UserDataRoleEnum{
	
	/** 10 自己 */
	SELF("10", "SELF"),
	
	/** 20 本部 */
	DEPT("20", "DEPT"),
	
	/** 30 全体 */
	ALL("30", "ALL");
	
	private final String code;
	private final String description;

	/**
	 * 私有构造函数
	 * 
	 * @param code
	 * @param description
	 */
	UserDataRoleEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return
	 */
	public static UserDataRoleEnum getByCode(String code) {
		for (UserDataRoleEnum status : values()) {
			if (status.getCode().equals(code)) {
				return status;
			}
		}
		return null;
	}
}
