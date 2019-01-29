package com.yjf.esupplier.web.controller.front.api;

/**
 * 真美美接口汇总
 * */
public enum GxtApiEnum {
	synMerchantInfo("synMerchantInfo", "景区和商户信息同步"),
	synCustomerInfo("synCustomerInfo", "会员信息同步"),
	synTradeInfo("synTradeInfo", "交易信息同步"),
	synPwdInfo("synPwdInfo", "密码同步"), ;
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 检查服务是否存在
	 * */
	public static boolean isExist(String service) {
		for (GxtApiEnum _enum : values()) {
			if (_enum.getCode().equals(service)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private GxtApiEnum(String code, String message) {
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
	 * @return GxtApiEnum
	 */
	public static GxtApiEnum getByCode(String code) {
		for (GxtApiEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
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
		GxtApiEnum _enum = getByCode(code);
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
	public static String getCode(GxtApiEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
