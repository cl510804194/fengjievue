package com.yjf.esupplier.integration.openapi.enums;

public enum CertifyLevelEnum {
	NO_RANK("NO_RANK", 0, "未通过"),
	PERSON_QUICK_RANK("PERSON_QUICK_RANK", 1, "身份证快速认证"),
	CERT_EXPIRE("CERT_EXPIRE", 2, "证件过期"),
	PERSON_NORMAL_RANK("PERSON_NORMAL_RANK", 3, "个人普通认证"),
	PERSON_ENHANCE_RANK("PERSON_ENHANCE_RANK", 5, "个人增强认证"),
	PERSON_NON_MAIN_LAND_RANK("PERSON_NON_MAIN_LAND_RANK", 3, "个人非大陆担保认证"),
	NORMAL_BUSINESS_RANK("NORMAL_BUSINESS_RANK", 3, "普通企业认证"),
	INDIVIDUAL_BUSINESS_RANK("INDIVIDUAL_BUSINESS_RANK", 3, "个体工商户认证"),
	BUSINESS_NON_MAIN_LAND_RANK("BUSINESS_NON_MAIN_LAND_RANK", 3, "境外企业认证");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/**
	 * 级别
	 */
	private final int certifyLevel;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private CertifyLevelEnum(String code, int certifyLevel, String message) {
		this.code = code;
		this.message = message;
		this.certifyLevel = certifyLevel;
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
	 * 等级值
	 * @return
	 */
	public int getCertifyLevel() {
		return this.certifyLevel;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return CertifyLevelEnum
	 */
	public static CertifyLevelEnum getByCode(String code) {
		for (CertifyLevelEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return CertifyLevelEnum
	 */
	public static CertifyLevelEnum getByCertifyLevel(int certifyLevel) {
		for (CertifyLevelEnum _enum : values()) {
			if (_enum.certifyLevel == certifyLevel) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<CertifyLevelEnum>
	 */
	public static java.util.List<CertifyLevelEnum> getAllEnum() {
		java.util.List<CertifyLevelEnum> list = new java.util.ArrayList<CertifyLevelEnum>(
			values().length);
		for (CertifyLevelEnum _enum : values()) {
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
		for (CertifyLevelEnum _enum : values()) {
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
		CertifyLevelEnum _enum = getByCode(code);
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
	public static String getCode(CertifyLevelEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
