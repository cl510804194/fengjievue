/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename OptionEnum.java
 * 
 * @Description 状态
 * 
 * @Version 1.0
 * 
 * @Author Karott Chen
 * 
 * @Email chenlin@yiji.com
 * 
 * @History <li>Author: Karott Chen</li> <li>Date: 2012-9-6</li> <li>Version:
 * 1.0</li> <li>Content: create</li>
 * 
 */
public enum OptionEnum {
	
	Y("Y", "是"),
	
	N("N", "否"),
	
	NY("NY", "特殊")
	
	, ;
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>OptionEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private OptionEnum(String code, String message) {
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
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return OptionEnum
	 */
	public static OptionEnum getByCode(String code) {
		for (OptionEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<OptionEnum>
	 */
	public List<OptionEnum> getAllEnum() {
		List<OptionEnum> list = new ArrayList<OptionEnum>();
		for (OptionEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
}
