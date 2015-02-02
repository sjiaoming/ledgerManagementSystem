package com.iboray.lms.domain.entity.enums;


public enum PlanStateEnum{
	
	/** 10 未领取 */
	UNCLAIMED(10, "未领取"),
	
	/** 20 已领取 */
	CLAIMED(20, "已领取"),
	
	/** 30 采购寻源 */
	PROCUREMENTSC(30, "采购寻源"),
	
	/** 40 采购合同 */
	CGCONTRACT(40, "采购合同"),
	
	/** 50 销售合同 */
	XSCONTRACT(50, "销售合同"),
	
	/** 60 挂账 */
	CREDIT(60, "挂账"),
	
	/** 70 已付*/
	PAYED(90, "已付"),
	
	/** 80 开票 */
	BILLING(90, "开票"),
	
	/** 90 已收 */
	RECEIVED(90, "已收");
	
	private final int code;
	private final String description;

	/**
	 * 私有构造函数
	 * 
	 * @param code
	 * @param description
	 */
	PlanStateEnum(int code, String description) {
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
	public static PlanStateEnum getByCode(int code) {
		for (PlanStateEnum status : values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		return null;
	}
}
