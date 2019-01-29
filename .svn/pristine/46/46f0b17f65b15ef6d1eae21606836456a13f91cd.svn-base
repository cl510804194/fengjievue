package com.yjf.esupplier.ws.userManage.enums;

public enum UserExtendEnum {
	GUARANTEE_ACCOUNT_ID("GUARANTEE_ACCOUNT_ID", "担保公司担保账户"),
	
	REAL_NAME_AUTHENTICATION("REAL_NAME_AUTHENTICATION", "实名认证错误信息"),
	
	USER_CONTACT_WECHAT("USER_CONTACT_WECHAT", "用户联系微信"),
	
	CERT_HAND_PATH("CERT_HAND_PATH", "身份证手持照片"),
	
	USER_AGE("USER_AGE", "用户年龄"),
	
	USER_JOB("USER_JOB", "用户职业"),
	
	USER_OUT_ID("USER_OUT_ID", "外部用户ID"),
	
	USER_HEADER_IMG("USER_HEADER_IMG", "app用户头像"),
	
	NINE_ELEMENTS_COMPLETION("NINE_ELEMENTS_COMPLETION", "9九要素补全标志"),
	
	EXPIR_BUSINESS_PERIOD("EXPIR_BUSINESS_PERIOD", "提前更新的身份证到期时间"),
	EXPIR_CERT_FRONT("EXPIR_CERT_FRON", "提前更新的身份证正面照片"),
	EXPIR_CERT_BACK("EXPIR_CERT_BACK", "提前更新的身份证背面照片"),
	
	YJF_PROTOCOL_NO("YJF_PROTOCOL_NO", "易极付快捷协议号"),
	
	OFFLINE_PAYMENT("OFFLINE_PAYMENT", "线下支付");
	
	//易六需求：每满1W投资额即有权用1W金豆（积分）兑换10元现金红包；所有金豆以1W为单位换算，多余部分累计到下次；
	//金豆最低兑换单位为1w;
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private UserExtendEnum(String code, String message) {
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
	 * @return UserExtendEnum
	 */
	public static UserExtendEnum getByCode(String code) {
		for (UserExtendEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<UserExtendEnum>
	 */
	public static java.util.List<UserExtendEnum> getAllEnum() {
		java.util.List<UserExtendEnum> list = new java.util.ArrayList<UserExtendEnum>(
			values().length);
		for (UserExtendEnum _enum : values()) {
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
		for (UserExtendEnum _enum : values()) {
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
		UserExtendEnum _enum = getByCode(code);
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
	public static String getCode(UserExtendEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
