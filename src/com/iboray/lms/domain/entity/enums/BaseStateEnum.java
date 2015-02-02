package com.iboray.lms.domain.entity.enums;


public enum BaseStateEnum {
	
	/** 10 启用 */
	VALID(10, "VALID"),
	
	/** 20 停用 */
	INVALID(20, "INVALID"),
	
	/** 30 冻结 */
	FROZEN(30, "FROZEN"),
	
	/** 40 删除 */
	DELETE(40, "DELETE");
	
	private final int code;
	private final String description;

	/**
	 * 私有构造函数
	 * 
	 * @param code
	 * @param description
	 */
	BaseStateEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return Returns the code.
	 */
	public int getCode() {
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
	public static BaseStateEnum getByCode(int code) {
		for (BaseStateEnum status : values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		return null;
	}
}
