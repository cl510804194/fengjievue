/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename TradeFullConditionEnum.java
 *
 * @Description 交易满标条件常量
 *
 * @Version 1.0
 *
 * @Author qichunhai
 *
 * @Email qchunhai@yiji.com
 *       
 * @History
 *<li>Author: qichunhai</li>
 *<li>Date: 2014-4-11</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum TradeFullConditionEnum {
	
	/** 金额 */
	AMOUNT("amount", "金额"),
	
	/** 百分比 */
	PERCENTAGE("rate", "百分比"),
	/** 百分比 */
	DATE("date", "日期");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>TradeFullConditionEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private TradeFullConditionEnum(String code, String message) {
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
	 * @return TradeFullConditionEnum
	 */
	public static TradeFullConditionEnum getByCode(String code) {
		for (TradeFullConditionEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<TradeFullConditionEnum>
	 */
	public List<TradeFullConditionEnum> getAllEnum() {
		List<TradeFullConditionEnum> list = new ArrayList<TradeFullConditionEnum>();
		for (TradeFullConditionEnum _enum : values()) {
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
		for (TradeFullConditionEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
