package com.yjf.esupplier.ws.enums;

public enum DepositStatusEnum {
	
	INITIAL("INITIAL", "初始"),
	
	SUBMIT_SETTLED("SUBMIT_SETTLED", "已报清算"),
	
	DEPOSITED("DEPOSITED", "已充值"),
	
	SUCCESS("SUCCESS", "处理成功"),
	
	FAILURE("FAILURE", "处理失败"),
	
	DEPOSIT_BACKED("DEPOSIT_BACKED", "已充退"),
	
	CHARGED("CHARGED", "已收费"),
	
	PRE_SETTLED("PRE_SETTLED", "已预清算"),
	
	CANCELED("CANCELED", "已撤销");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private DepositStatusEnum(String code, String message) {
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
	 * @return DepositStatusEnum
	 */
	public static DepositStatusEnum getByCode(String code) {
		for (DepositStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DepositStatusEnum>
	 */
	public static java.util.List<DepositStatusEnum> getAllEnum() {
		java.util.List<DepositStatusEnum> list = new java.util.ArrayList<DepositStatusEnum>(
			values().length);
		for (DepositStatusEnum _enum : values()) {
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
		for (DepositStatusEnum _enum : values()) {
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
		DepositStatusEnum _enum = getByCode(code);
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
	public static String getCode(DepositStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
