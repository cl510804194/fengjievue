/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename PublicTagEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author Karott Chen
 * 
 * @Email chenlin@yiji.com
 * 
 * @History <li>Author: Karott Chen</li> <li>Date: 2012-9-18</li> <li>Version:
 * 1.0</li> <li>Content: create</li>
 * 
 */
public enum PublicTagEnum {
	
	/** 对公账户 */
	PUBLIC("PUBLIC", "对公"),
	
	/** 个人账户 */
	PERSONAL("PERSONAL", "对私");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>AccountTypeEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private PublicTagEnum(String code, String message) {
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
	 * @return AccountTypeEnum
	 */
	public static PublicTagEnum getByCode(String code) {
		for (PublicTagEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<AccountTypeEnum>
	 */
	public List<PublicTagEnum> getAllEnum() {
		List<PublicTagEnum> list = new ArrayList<PublicTagEnum>();
		for (PublicTagEnum _enum : values()) {
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
		for (PublicTagEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
