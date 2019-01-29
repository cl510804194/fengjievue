package com.yjf.esupplier.ws.enums;

public enum CertifyStatusEnum {
	/** 未认证 */
	UNAUTHERIZED("U", "未认证"),
	/** 已认证 */
	AUTHORIZED("A", "已认证"),
	/** 认证中 */
	INAUTHORIZED("I", "认证中"),
	/** 已认证 */
	REJECT("R", "被驳回"),
	/** 过期 */
	CERT_EXPIRE("E", "过期");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private CertifyStatusEnum(String code, String message) {
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
	 * @return CertifyStatusEnum
	 */
	public static CertifyStatusEnum getByCode(String code) {
		for (CertifyStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<CertifyStatusEnum>
	 */
	public static java.util.List<CertifyStatusEnum> getAllEnum() {
		java.util.List<CertifyStatusEnum> list = new java.util.ArrayList<CertifyStatusEnum>(
			values().length);
		for (CertifyStatusEnum _enum : values()) {
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
		for (CertifyStatusEnum _enum : values()) {
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
		CertifyStatusEnum _enum = getByCode(code);
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
	public static String getCode(CertifyStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
