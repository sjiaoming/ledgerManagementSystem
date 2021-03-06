package com.iboray.lms.domain.entity.enums;


public enum PlanChangeStatusEnum{
	
	ADD("10", "增加"),
	
	MODIFY("20", "修改"),
	
	DEL("30", "删除"),
	
	OTHER("40", "其他");
	
	private final String code;
	private final String description;

	/**
	 * 私有构造函数
	 * 
	 * @param code
	 * @param description
	 */
	PlanChangeStatusEnum(String code, String description) {
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
	public static PlanChangeStatusEnum getByCode(String code) {
		for (PlanChangeStatusEnum status : values()) {
			if (status.getCode().equals(code)) {
				return status;
			}
		}
		return null;
	}
}
