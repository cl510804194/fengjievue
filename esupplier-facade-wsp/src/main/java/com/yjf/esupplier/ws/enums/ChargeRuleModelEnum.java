/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename ChargeRuleModelEnum.java
 *
 * @Description 
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
public enum ChargeRuleModelEnum {
	
	/** 固定金额 */
	CHARGE_RULE_MODEL_AMOUNT("amount", "固定金额"),
	/** 百分比 */
	CHARGE_RULE_MODEL_PERCENTAGE("percentage", "百分比"),
	/**  阶梯收费*/
	CHARGE_RULE_MODEL_INTERVAL("interval", " 阶梯收费");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>ChargeRuleModelEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private ChargeRuleModelEnum(String code, String message) {
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
	 * @return ChargeRuleModelEnum
	 */
	public static ChargeRuleModelEnum getByCode(String code) {
		for (ChargeRuleModelEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<ChargeRuleModelEnum>
	 */
	public List<ChargeRuleModelEnum> getAllEnum() {
		List<ChargeRuleModelEnum> list = new ArrayList<ChargeRuleModelEnum>();
		for (ChargeRuleModelEnum _enum : values()) {
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
		for (ChargeRuleModelEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
