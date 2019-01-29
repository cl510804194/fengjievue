/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename RegisterFromEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zhangming
 * 
 * @Email zhangming@yiji.com
 * 
 * @History <li>Author: zhangming</li> <li>Date: 2012-7-5</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum RegisterFromEnum {
	
	/** 个人版 */
	PERSONAL_EDITION("PERSONAL_EDITION", "个人版"),
	/** 企业版 */
	ENTERPRISE_EDITION("ENTERPRISE_EDITION", "企业版"),
	/** 特约商户 */
	SPECIAL_MER("SPECIAL_MER", "特约商户"),
	/** 后台 */
	BOPS("BOPS", "后台"),
	/** 无线 */
	WIRELESS("WIRELESS", "无线"),
	/** 系统 */
	SYSTEM("SYSTEM", "系统"),
	/** 易缴费 */
	EASY_PAY("EASY_PAY", "易缴费"),
	/** 易生活 */
	EASY_LIFE("EASY_LIFE", "易生活"),
	/** 易结汇代理 */
	EASY_EXCHANGE_AGENT("EASY_EXCHANGE_AGENT", "易结汇代理"),
	/** 易结汇 */
	EASY_EXCHANGE("EASY_EXCHANGE", "易结汇"),
	/** 易交易 */
	EASY_TRADE("EASY_TRADE", "易交易"),
	/** 房产交易 */
	ESTATE("ESTATE", "房产交易"),
	/** 易汇通 */
	E_CROSS_BORDER_PAY("E_CROSS_BORDER_PAY", "易汇通"),
	/** 猪八戒 */
	ZBJ("ZBJ", "猪八戒"),
	/** 外部引入 */
	EXT_IMPORT("EXT_IMPORT", "外部引入"),
	/** 易周转 */
	E_TURNOVER("E_TURNOVER", "易周转"),
	/** 易融通 */
	E_ACCOMMODATION("E_ACCOMMODATION", "易融通");
	//	/** 易贷网*/
	//	ELOAN("ELOAN", "易贷网");
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>RegisterFromEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private RegisterFromEnum(String code, String message) {
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
	 * @return RegisterFromEnum
	 */
	public static RegisterFromEnum getByCode(String code) {
		for (RegisterFromEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<RegisterFromEnum>
	 */
	public List<RegisterFromEnum> getAllEnum() {
		List<RegisterFromEnum> list = new ArrayList<RegisterFromEnum>();
		for (RegisterFromEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (RegisterFromEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
