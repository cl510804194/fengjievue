package com.yjf.esupplier.ws.enums;

public enum UserBizTypeEnum {
	
	BUYER("BUYER", "会员", "/do/mainHome.htm", 1),
	VISITOR_CENTER("VISITOR_CENTER", "景区", "/do/mainHome.htm", 1),
	SELLER("SELLER", "景区商户", "/do/mainHome.htm", 2),
	VISITOR_OPERATOR("VISITOR_OPERATOR", "景区操作员", "/do/mainHome.htm", 3),
	DELIVERY_PERSON("DELIVERY_PERSON", "配送员", "/do/mainHome.htm", 5),
	TEC("TEC", "技师", "/do/mainHome.htm", 6),
	ADMIN("ADMIN", "平台管理员", "/admin/mainHome.htm", 4);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	private final String mainUrl;
	private final int index;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private UserBizTypeEnum(String code, String message, String mainUrl, int index) {
		this.code = code;
		this.message = message;
		this.mainUrl = mainUrl;
		this.index = index;
	}
	
	public String getMainUrl() {
		return this.mainUrl;
	}
	
	public int getIndex() {
		return this.index;
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
	 * @return UserBizTypeEnum
	 */
	public static UserBizTypeEnum getByCode(String code) {
		for (UserBizTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<UserBizTypeEnum>
	 */
	public static java.util.List<UserBizTypeEnum> getAllEnum() {
		java.util.List<UserBizTypeEnum> list = new java.util.ArrayList<UserBizTypeEnum>(
			values().length);
		for (UserBizTypeEnum _enum : values()) {
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
		for (UserBizTypeEnum _enum : values()) {
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
		UserBizTypeEnum _enum = getByCode(code);
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
	public static String getCode(UserBizTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
