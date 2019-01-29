package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename UserTypeEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-6-8</li> <li>Version: 1.0</li>
 *          <li>Content: create</li>
 * 
 */
public enum UserTypeEnum {
	/** 个人用户 */
	GR("GR", "个人用户"),
	/** 机构用户 */
	JG("JG", "机构用户"),
	/** 高级机构 */
	GJJG("高级机构", "高级机构");
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>UserTypeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private UserTypeEnum(String code, String message) {
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
	 * @return UserTypeEnum
	 */
	public static UserTypeEnum getByCode(String code) {
		for (UserTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<UserTypeEnum>
	 */
	public List<UserTypeEnum> getAllEnum() {
		List<UserTypeEnum> list = new ArrayList<UserTypeEnum>();
		for (UserTypeEnum _enum : values()) {
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
		for (UserTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
