/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *           
 * 借款需求业务类型，代码 public所有人，其他类型
 * @Filename LoanBizTypeEnum.java
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
public enum LoanBizTypeEnum {
	
	/** 所有人*/
	PUBLIC("public", "所有人"),
	/** 定向标、定向投资*/
	PRIVATE("private", "私人"),

    RONG_ZI_BAO("rzb","融资宝"),

    ZHONG_CHOU_BAO("zcb","众筹宝"),

	
	/** 所有人*/
	YJF("YJF", "易极付");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>LoanBizTypeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private LoanBizTypeEnum(String code, String message) {
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
	 * @return LoanBizTypeEnum
	 */
	public static LoanBizTypeEnum getByCode(String code) {
		for (LoanBizTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LoanBizTypeEnum>
	 */
	public List<LoanBizTypeEnum> getAllEnum() {
		List<LoanBizTypeEnum> list = new ArrayList<LoanBizTypeEnum>();
		for (LoanBizTypeEnum _enum : values()) {
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
		for (LoanBizTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
