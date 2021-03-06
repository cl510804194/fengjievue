/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename TransferActionEnum.java
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
public enum TransferActionEnum {
	
	/** 正常 */
	NORMAL("NORMAL", "正常"),
	
	/** 解冻转账 */
	UN_FREEZE_TRANSFER("UN_FREEZE_TRANSFER", "解冻转账"),
	
	/** 转账冻结*/
	TRANSFER_FREEZE("TRANSFER_FREEZE", "转账冻结"),
	
	/** 转账冻结*/
	UN_FREEZE_TRANSFER_FREEZE("UN_FREEZE_TRANSFER_FREEZE", "解冻转账并冻结");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>TransferActionEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private TransferActionEnum(String code, String message) {
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
	 * @return TransferActionEnum
	 */
	public static TransferActionEnum getByCode(String code) {
		for (TransferActionEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<TransferActionEnum>
	 */
	public List<TransferActionEnum> getAllEnum() {
		List<TransferActionEnum> list = new ArrayList<TransferActionEnum>();
		for (TransferActionEnum _enum : values()) {
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
		for (TransferActionEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
