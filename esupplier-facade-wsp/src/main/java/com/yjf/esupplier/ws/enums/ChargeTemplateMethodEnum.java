/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename ChargeTemplateMethodEnum.java
 *
 * @Description  收费模版的收费方式
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
public enum ChargeTemplateMethodEnum {
	
	/**
	 * 按笔
	 */
	CHARGE_TEMPLATE_METHOD_TRADE("trade", "按笔"),
	/**
	 * 按月
	 */
	CHARGE_TEMPLATE_METHOD_MONTH("month", "按月"),
	/**
	 * 按季
	 */
	CHARGE_TEMPLATE_METHOD_SEASON("season", "按季"),
	/**
	 * 按年
	 */
	CHARGE_TEMPLATE_METHOD_YEAR("year", "按年");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>ChargeTemplateMethodEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private ChargeTemplateMethodEnum(String code, String message) {
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
	 * @return ChargeTemplateMethodEnum
	 */
	public static ChargeTemplateMethodEnum getByCode(String code) {
		for (ChargeTemplateMethodEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<ChargeTemplateMethodEnum>
	 */
	public List<ChargeTemplateMethodEnum> getAllEnum() {
		List<ChargeTemplateMethodEnum> list = new ArrayList<ChargeTemplateMethodEnum>();
		for (ChargeTemplateMethodEnum _enum : values()) {
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
		for (ChargeTemplateMethodEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
