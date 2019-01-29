package com.yjf.esupplier.integration.openapi.enums;

/**
 * 
 PAYMENT:网页付款 PAYMENT_GATEWAY:网关支付
 * 
 * 
 * 
 * 
 * @author qch
 * 
 */
public enum YjfBizType {
	PAYMENT("PAYMENT", "网页付款"),
	PAYMENT_GATEWAY("PAYMENT_GATEWAY", "网关支付");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private YjfBizType(String code, String message) {
		this.code = code;
		this.message = message;
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
	 * @return YjfBizType
	 */
	public static YjfBizType getByCode(String code) {
		for (YjfBizType _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<YjfBizType>
	 */
	public static java.util.List<YjfBizType> getAllEnum() {
		java.util.List<YjfBizType> list = new java.util.ArrayList<YjfBizType>(values().length);
		for (YjfBizType _enum : values()) {
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
		for (YjfBizType _enum : values()) {
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
		YjfBizType _enum = getByCode(code);
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
	public static String getCode(YjfBizType _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
