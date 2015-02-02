package com.iboray.lms.domain.entity.enums;


public enum JqGridOpEnum{
	
	/** eq equal */
	EQ("eq", "equal"),
	
	/** ne not equal */
	NE("ne", "not equal"),
	
	/** lt less */
	LT("lt", "less"),
	
	/** le less or equal */
	LE("le", "less or equal"),
	
	/** gt greater */
	GT("gt", "greater"),
	
	/** ge greater or equal */
	GE("ge", "greater or equal"),
	
	/** bw begins with */
	BW("bw", "begins with"),
	
	/** bn does not begin with */
	BN("bn", "does not begin with"),
	
	/** bn is in */
	IN("bn", "is in"),
	
	/** ni is not in */
	NI("ni", "is not in"),
	
	/** ew ends with */
	EW("ew", "ends with"),
	
	/** en does not end with */
	EN("en", "does not end with"),
	
	/** cn contains */
	CN("cn", "contains"),
	
	/** nc does not contain */
	NC("nc", "does not contain");
	
	private final String code;
	private final String description;

	/**
	 * 私有构造函数
	 * 
	 * @param code
	 * @param description
	 */
	JqGridOpEnum(String code, String description) {
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
	public static JqGridOpEnum getByCode(String code) {
		for (JqGridOpEnum status : values()) {
			if (status.getCode().equals(code)) {
				return status;
			}
		}
		return null;
	}
}
