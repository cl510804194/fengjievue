package com.yjf.esupplier.ws.enums;

public enum LoginFromTypeEnum {
	/**
	 * 登录方式
	 */
	APP_USER("APP_USER", "会员APP登录"),
	APP_MERCHANT("APP_MERCHANT", "商户APP登录"),
	PC_USER("PC_USER", "会员电脑登录"),
	PC_CENTER("PC_CENTER", "中心后台登录"),
	PC_MERCHANT("PC_MERCHANT", "商户后台登录"),
	PC_ADMIN("PC_ADMIN", "运营后台登录"),
	WEIXIN_USER("WEIXIN_USER", "微信用户登录"),
	APP_DELIVERY_PERSON("APP_DELIVERY_PERSON", "配送员");
	//YQX("YQX", "该订单已经被取消")
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;

	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private LoginFromTypeEnum(String code, String message) {
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
	 * @return OrderStatusEnum
	 */
	public static LoginFromTypeEnum getByCode(String code) {
		for (LoginFromTypeEnum _enum : values()) {
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
	public static java.util.List<LoginFromTypeEnum> getAllEnum() {
		java.util.List<LoginFromTypeEnum> list = new java.util.ArrayList<LoginFromTypeEnum>(
			values().length);
		for (LoginFromTypeEnum _enum : values()) {
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
		for (LoginFromTypeEnum _enum : values()) {
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
		LoginFromTypeEnum _enum = getByCode(code);
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
	public static String getCode(LoginFromTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
