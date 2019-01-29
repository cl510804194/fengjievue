package com.yjf.esupplier.ws.bill.enums;

public enum QrValidationStatusEnum {
	/**
	 * 已验证
	 */
	YES("YES", "已验证"),
	
	/**
	 * 未验证
	 */
	NO("NO", "未验证");
	//YQX("YQX", "该订单已经被取消")
	
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
	private QrValidationStatusEnum(String code, String message, boolean isCanRefound) {
		this.code = code;
		this.message = message;
		this.isCanRefound = isCanRefound;
	}
	
	private QrValidationStatusEnum(String code, String message) {
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
	public static QrValidationStatusEnum getByCode(String code) {
		for (QrValidationStatusEnum _enum : values()) {
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
	public static java.util.List<QrValidationStatusEnum> getAllEnum() {
		java.util.List<QrValidationStatusEnum> list = new java.util.ArrayList<QrValidationStatusEnum>(
			values().length);
		for (QrValidationStatusEnum _enum : values()) {
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
		for (QrValidationStatusEnum _enum : values()) {
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
		QrValidationStatusEnum _enum = getByCode(code);
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
	public static String getCode(QrValidationStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
