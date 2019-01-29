package com.yjf.esupplier.ws.bill.enums;


public enum RawAddTimeEnum {
	/**
	 * 近3个月
	 */
	SGY("SGY", "近三个月", true),
	/**
	 * 近6个月
	 */
	LGY("LGY", "近六个月"),
	/**
	 * 当前年
	 */
	DQN("DQN", "当前年", true),
	/**
	 * 前一年
	 */
	QYN("QYN", "前一年");
	
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
	private RawAddTimeEnum(String code, String message, boolean isCanRefound) {
		this.code = code;
		this.message = message;
		this.isCanRefound = isCanRefound;
	}
	
	private RawAddTimeEnum(String code, String message) {
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
	public static RawAddTimeEnum getByCode(String code) {
		for (RawAddTimeEnum _enum : values()) {
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
	public static java.util.List<RawAddTimeEnum> getAllEnum() {
		java.util.List<RawAddTimeEnum> list = new java.util.ArrayList<RawAddTimeEnum>(
			values().length);
		for (RawAddTimeEnum _enum : values()) {
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
		for (RawAddTimeEnum _enum : values()) {
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
		RawAddTimeEnum _enum = getByCode(code);
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
	public static String getCode(RawAddTimeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
