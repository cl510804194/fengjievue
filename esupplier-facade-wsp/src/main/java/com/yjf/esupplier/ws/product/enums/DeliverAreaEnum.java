package com.yjf.esupplier.ws.product.enums;

public enum DeliverAreaEnum {
	NORMAL("NORMAL", "普通地区");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private DeliverAreaEnum(String code, String message) {
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
	 * @return SaleType
	 */
	public static DeliverAreaEnum getByCode(String code) {
		for (DeliverAreaEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<SaleType>
	 */
	public static java.util.List<DeliverAreaEnum> getAllEnum() {
		java.util.List<DeliverAreaEnum> list = new java.util.ArrayList<DeliverAreaEnum>(values().length);
		for (DeliverAreaEnum _enum : values()) {
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
		for (DeliverAreaEnum _enum : values()) {
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
		DeliverAreaEnum _enum = getByCode(code);
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
	public static String getCode(DeliverAreaEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
