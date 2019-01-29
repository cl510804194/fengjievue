/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Version 1.0
 * 
 * @Author peigen
 * 
 * @Email peigen@yiji.com
 * 
 * @History <li>Author: peigen</li> <li>Date: 2012-6-16</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum BusinessCategoryEnum {
	
	DEFAULT("DEFAULT", "默认"),
	
	EASY_PAY("EASY_PAYMENT", "易缴费"),
	
	EASY_TRADE("EASY_TRADE", "易交易"),
	
	EASY_EXCHANGE("EASY_EXCHANGE", "易结汇"),
	
	PAY_MOBILE("PAY_MOBILE", "移动支付"),
	
	PERSONAL("PERSONAL", "个人版"),
	
	MERCHANT("MERCHANT", "商户版"),
	
	SPECIAL_MERCHANT("SPECIAL_MERCHANT", "特约商户版"),
	
	OFFLINE("OFFLINE", "线下手工"),
	
	EASY_PAYING("EASY_PAYING", "易支付"),
	
	ESTATE_CQ("ESTATE_CQ", "重庆二手房"),
	
	EASY_TURNOVER("EASY_TURNOVER", "易周转"),
	
	EASY_FINANCE("EASY_FINANCE", "易融通"),
	
	EASY_LOAN("EASY_LOAN", "易贷款(易久)"),
	
	CASHIER("CASHIER", "收银台"),
	
	;
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>BusinessTypeEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private BusinessCategoryEnum(String code, String message) {
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
	 * @return BusinessTypeEnum
	 */
	public static BusinessCategoryEnum getByCode(String code) {
		for (BusinessCategoryEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<BusinessTypeEnum>
	 */
	public List<BusinessCategoryEnum> getAllEnum() {
		List<BusinessCategoryEnum> list = new ArrayList<BusinessCategoryEnum>();
		for (BusinessCategoryEnum _enum : values()) {
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
		for (BusinessCategoryEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
}
