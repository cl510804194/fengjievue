/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

/**
 *
 *
 * @Filename PropertyTypeEnum.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author HUANGXL
 **
 * @History <li>Author: HUANGXL</li> <li>Date: 2016-6-7下午4:46:04</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */
public enum PopTypeEnum {
	//2：攻略管理，3：帮助中心，4：简介;
	FOOT_NEWS("FOOT_NEWS", "页脚介绍信息", 1),
	
	TIPS("TIPS", "攻略管理", 2),
	
	HELP("HELP", "帮助中心", 3),
	
	SUMMARY("SUMMARY", "简介", 4),
	
	DISCOUNTDAY("DISCOUNTDAY", "长包房天数", 6),
	
	WEIXIN_BANNER("WEIXIN_BANNER", "微信导航图", 10),

	WEIXIN_TODAY("WEIXIN_TODAY", "微信今日推荐", 101),

	WEIXIN_ACT("WEIXIN_ACT", "微信精彩活动", 102),

	BANNER("BANNER", "APP导航图", 11),

	PC_BANNER("PC_BANNER", "PC导航图", 12),

	ANDROID_VERSION("ANDROID_VERSION", "安卓版本", 21),
	
	IOS_VERSION("IOS_VERSION", "苹果版本", 22),
	
	SELLER_VERSION("SELLER_VERSION", "商家版本", 23),
	
	DILIVERY_VERSION("DILIVERY_VERSION", "配送员版本", 24),
	
	PAD_VERSION("PAD_VERSION", "PAD版本", 25);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/**
	 * DBvalue
	 */
	private final int dbValue;
	
	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private PopTypeEnum(String code, String message, int dbValue) {
		this.code = code;
		this.message = message;
		this.dbValue = dbValue;
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
	
	public int getDbValue() {
		return this.dbValue;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return PopTypeEnum
	 */
	public static PopTypeEnum getByCode(String code) {
		for (PopTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static PopTypeEnum getByDBValue(int value) {
		for (PopTypeEnum _enum : values()) {
			if (_enum.dbValue == value) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 *
	 * @return List<PopTypeEnum>
	 */
	public static java.util.List<PopTypeEnum> getAllEnum() {
		java.util.List<PopTypeEnum> list = new java.util.ArrayList<PopTypeEnum>(values().length);
		for (PopTypeEnum _enum : values()) {
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
		for (PopTypeEnum _enum : values()) {
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
		PopTypeEnum _enum = getByCode(code);
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
	public static String getCode(PopTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
