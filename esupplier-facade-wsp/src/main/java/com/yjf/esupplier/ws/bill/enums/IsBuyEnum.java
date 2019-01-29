package com.yjf.esupplier.ws.bill.enums;

public enum IsBuyEnum {
	/**
	 * 购买
	 */
	YES("YES", "购买商品"),
	/**
	 * 获取样品(B2B)
	 */
	NO("NO", "获取样品");

	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 */
	private final boolean isCanRefound;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private IsBuyEnum(String code, String message, boolean isCanRefound) {
		this.code = code;
		this.message = message;
		this.isCanRefound = isCanRefound;
	}
	
	private IsBuyEnum(String code, String message) {
		this.code = code;
		this.message = message;
		this.isCanRefound = false;
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
	
	public boolean isCanRefound() {
		return this.isCanRefound;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return OrderStatusEnum
	 */
	public static IsBuyEnum getByCode(String code) {
		for (IsBuyEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<OrderStatusEnum>
	 */
	public static java.util.List<IsBuyEnum> getAllEnum() {
		java.util.List<IsBuyEnum> list = new java.util.ArrayList<IsBuyEnum>(
			values().length);
		for (IsBuyEnum _enum : values()) {
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
		for (IsBuyEnum _enum : values()) {
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
		IsBuyEnum _enum = getByCode(code);
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
	public static String getCode(IsBuyEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
