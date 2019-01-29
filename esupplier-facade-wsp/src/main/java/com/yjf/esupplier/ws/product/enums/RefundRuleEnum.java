package com.yjf.esupplier.ws.product.enums;

public enum RefundRuleEnum {
	ANY_TIME("ANY_TIME", "随时可以退", SaleTypeEnum.ALL),
	SEVEN_AFTER("SEVEN_AFTER", "7天可以退", SaleTypeEnum.B2C),
	CAN_NOT("CAN_NOT", "不能退", SaleTypeEnum.ALL),
	EXPIRED("EXPIRED", "过期退", SaleTypeEnum.O2O);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 枚举描述 */
	private final SaleTypeEnum saleTypeEnum;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private RefundRuleEnum(String code, String message, SaleTypeEnum saleTypeEnum) {
		this.code = code;
		this.message = message;
		this.saleTypeEnum = saleTypeEnum;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return RefundRuleEnum
	 */
	public static RefundRuleEnum getByCode(String code) {
		for (RefundRuleEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<RefundRuleEnum>
	 */
	public static java.util.List<RefundRuleEnum> getAllEnum() {
		java.util.List<RefundRuleEnum> list = new java.util.ArrayList<RefundRuleEnum>(
			values().length);
		for (RefundRuleEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public static java.util.List<String> getAllEnumCode() {
		java.util.List<String> list = new java.util.ArrayList<String>(values().length);
		for (RefundRuleEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 通过code获取msg
	 * @param code 枚举值
	 * @return
	 */
	public static String getMsgByCode(String code) {
		if (code == null) {
			return null;
		}
		RefundRuleEnum _enum = getByCode(code);
		if (_enum == null) {
			return null;
		}
		return _enum.getMessage();
	}
	
	/**
	 * 获取枚举code
	 * @param _enum
	 * @return
	 */
	public static String getCode(RefundRuleEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
