package com.yjf.esupplier.integration.openapi.enums;

public enum InvestNotifyTypeEnum {
	INVEST("INVEST", "投资申请中", "1"),
	INVEST_FINISHED("INVEST_FINISHED", "已投资(投标成功--满标)", "3"),
	INVEST_FAILD("INVEST_FINISHED", "投标失败", "4"),
	REPAID("REPAID", "还款完成", "7");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 枚举描述 */
	private final String sendCode;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private InvestNotifyTypeEnum(String code, String message, String sendCode) {
		this.code = code;
		this.message = message;
		this.sendCode = sendCode;
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
	
	public String getSendCode() {
		return this.sendCode;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return InvestNotifyType
	 */
	public static InvestNotifyTypeEnum getByCode(String code) {
		for (InvestNotifyTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<InvestNotifyType>
	 */
	public static java.util.List<InvestNotifyTypeEnum> getAllEnum() {
		java.util.List<InvestNotifyTypeEnum> list = new java.util.ArrayList<InvestNotifyTypeEnum>(
			values().length);
		for (InvestNotifyTypeEnum _enum : values()) {
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
		for (InvestNotifyTypeEnum _enum : values()) {
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
		InvestNotifyTypeEnum _enum = getByCode(code);
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
	public static String getCode(InvestNotifyTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
