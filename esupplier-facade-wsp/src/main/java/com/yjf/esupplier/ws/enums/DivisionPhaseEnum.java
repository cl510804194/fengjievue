/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename DivisionPhaseEnum.java
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
 *<li>Date: 2014-4-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum DivisionPhaseEnum {
	
	/** 投资阶段*/
	INVESET_PHASE("invest", "投资阶段"),
	/** 还款阶段*/
	REPAY_PHASE("repay", "还款阶段"),
	/** 原始资金建立阶段*/
	ORIGINAL_PHASE("original", "原始资金建立阶段"),
	/** 投资转账阶段*/
	INVESET_TRANSITION_PHASE("invtranz", "投资转账阶段"),
	/** 还款阶段*/
	REPAY_TRANSITION_PHASE("reptranz", "还款阶段");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>DivisionPhaseEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private DivisionPhaseEnum(String code, String message) {
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
	 * @return DivisionPhaseEnum
	 */
	public static DivisionPhaseEnum getByCode(String code) {
		for (DivisionPhaseEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DivisionPhaseEnum>
	 */
	public List<DivisionPhaseEnum> getAllEnum() {
		List<DivisionPhaseEnum> list = new ArrayList<DivisionPhaseEnum>();
		for (DivisionPhaseEnum _enum : values()) {
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
		for (DivisionPhaseEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
