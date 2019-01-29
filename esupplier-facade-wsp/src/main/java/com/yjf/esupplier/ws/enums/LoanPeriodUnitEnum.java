/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename LoanLimitUnitEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-11</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public enum LoanPeriodUnitEnum {
	
	/** 按天 */
	LOAN_BY_DAY("D", " 按天", "天"),
	/** 按周期 */
	LOAN_BY_PEROIDW("W", "按周期", "个月"),
	/** 按月 */
	LOAN_BY_MONTH("M", "按月", "个月"),
	/** 按年 */
	LOAN_BY_YEAR("Y", "按年", "年");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 枚举描述 */
	private final String viewName;
	
	/**
	 * 构造一个<code>LoanLimitUnitEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private LoanPeriodUnitEnum(String code, String message, String viewName) {
		this.code = code;
		this.message = message;
		this.viewName = viewName;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	public String getViewName() {
		return this.viewName;
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
	 * @return LoanLimitUnitEnum
	 */
	public static LoanPeriodUnitEnum getByCode(String code) {
		for (LoanPeriodUnitEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LoanLimitUnitEnum>
	 */
	public List<LoanPeriodUnitEnum> getAllEnum() {
		List<LoanPeriodUnitEnum> list = new ArrayList<LoanPeriodUnitEnum>();
		for (LoanPeriodUnitEnum _enum : values()) {
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
		for (LoanPeriodUnitEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
