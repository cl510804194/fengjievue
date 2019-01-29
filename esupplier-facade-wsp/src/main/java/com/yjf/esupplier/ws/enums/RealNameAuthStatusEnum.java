/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * Administrator 下午6:14:16 创建
 */
package com.yjf.esupplier.ws.enums;

/**
 * 
 * 
 * @author Administrator
 * 
 */
public enum RealNameAuthStatusEnum {
	/** NO */
	NO("NO", "认证失败", "fail"),
	
	/** YES */
	IS("IS", "已认证", "success"),
	/** 审核中-实名认证 */
	IN("IN", "认证中", "precess"),
	
	APPLY("APPLY", "申请中", ""),
	/** 未认证- 实名认证 */
	N("N", "未认证", "");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 易极付状态值 */
	private final String yjfStatus;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private RealNameAuthStatusEnum(String code, String message, String yjfStatus) {
		this.code = code;
		this.message = message;
		this.yjfStatus = yjfStatus;
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
	
	public String getYjfStatus() {
		return this.yjfStatus;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return RealNameAuthStatusEnum
	 */
	public static RealNameAuthStatusEnum getByCode(String code) {
		for (RealNameAuthStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<RealNameAuthStatusEnum>
	 */
	public static java.util.List<RealNameAuthStatusEnum> getAllEnum() {
		java.util.List<RealNameAuthStatusEnum> list = new java.util.ArrayList<RealNameAuthStatusEnum>(
			values().length);
		for (RealNameAuthStatusEnum _enum : values()) {
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
		for (RealNameAuthStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 通过code获取msg
	 * 
	 * @param code 枚举值
	 * @return
	 */
	public static String getMsgByCode(String code) {
		if (code == null) {
			return null;
		}
		RealNameAuthStatusEnum _enum = getByCode(code);
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
	public static String getCode(RealNameAuthStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
