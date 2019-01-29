/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @Filename PropertyTypeEnum.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-29下午4:46:04</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
public enum PropertyTypeEnum {
	/** 款式 */
    STYLE("STYLE", "商品分类"),

	/** 题材 */
    THEME("THEME", "题材");

	private final String code;
	private final String message;

	private PropertyTypeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
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
	 * @return LogResultEnum
	 */
	public static PropertyTypeEnum getByCode(String code) {
		for (PropertyTypeEnum _enum : values()) {
			if (_enum.getCode().equalsIgnoreCase(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 *
	 * @return List<LogResultEnum>
	 */
	public List<PropertyTypeEnum> getAllEnum() {
		List<PropertyTypeEnum> list = new ArrayList<PropertyTypeEnum>();
		for (PropertyTypeEnum _enum : values()) {
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
		for (PropertyTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
