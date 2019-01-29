/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename UserStatusEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-5-17</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public enum UserStatusEnum {
	
	/** 未激活 */
	UNACTIVATED("UNACTIVATED", "未激活"),
	/** 快速注册用户 */
	QUICK_REGISTER("QUICK_REGISTER", "快速注册用户"),
	/** 正常用户 */
	NORMAL("NORMAL", "正常用户"),
	UNKNOWN("UNKNOWN", "未知状态");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>UserStatusEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private UserStatusEnum(String code, String message) {
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
	 * @return UserStatusEnum
	 */
	public static UserStatusEnum getByCode(String code) {
		for (UserStatusEnum _enum : values()) {
			if (_enum.code().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static UserStatusEnum getByMessage(String message) {
		for (UserStatusEnum _enum : values()) {
			if (_enum.message().equals(message)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<UserStatusEnum>
	 */
	public static List<UserStatusEnum> getAllEnum() {
		List<UserStatusEnum> list = new ArrayList<UserStatusEnum>();
		for (UserStatusEnum _enum : values()) {
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
		for (UserStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
