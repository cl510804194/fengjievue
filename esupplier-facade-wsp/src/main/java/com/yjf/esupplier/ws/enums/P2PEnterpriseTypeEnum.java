/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * Administrator 下午2:20:18 创建
 */
package com.yjf.esupplier.ws.enums;

/**
 * 
 * 
 * @author Administrator
 * 
 */
public enum P2PEnterpriseTypeEnum {
	NONE("NONE", "未知"),

	TICKET("TICKET", "持票企业"),

	SMALL_AND_MICRO("SMALL_AND_MICRO", "持票企业");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 * 
	 * @param code
	 *            枚举值
	 * @param message
	 *            枚举描述
	 */
	private P2PEnterpriseTypeEnum(String code, String message) {
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
	 * @return P2PEnterpriseTypeEnum
	 */
	public static P2PEnterpriseTypeEnum getByCode(String code) {
		for (P2PEnterpriseTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<P2PEnterpriseTypeEnum>
	 */
	public static java.util.List<P2PEnterpriseTypeEnum> getAllEnum() {
		java.util.List<P2PEnterpriseTypeEnum> list = new java.util.ArrayList<P2PEnterpriseTypeEnum>(
				values().length);
		for (P2PEnterpriseTypeEnum _enum : values()) {
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
		java.util.List<String> list = new java.util.ArrayList<String>(
				values().length);
		for (P2PEnterpriseTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}

	/**
	 * 通过code获取msg
	 * 
	 * @param code
	 *            枚举值
	 * @return
	 */
	public static String getMsgByCode(String code) {
		if (code == null) {
			return null;
		}
		P2PEnterpriseTypeEnum _enum = getByCode(code);
		if (_enum == null) {
			return null;
		}
		return _enum.getMessage();
	}

	/**
	 * 获取枚举code
	 * 
	 * @param _enum
	 * @return
	 */
	public static String getCode(P2PEnterpriseTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
