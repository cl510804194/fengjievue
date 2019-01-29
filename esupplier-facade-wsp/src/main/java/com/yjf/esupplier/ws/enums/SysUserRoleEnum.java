/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename SysUserRoleEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum SysUserRoleEnum {
	
	BUYER("2", 2, "买家", "BUYER"),
	/** 操作员14 */
	VISITOR_OPERATOR("5", 5, "操作员", "VISITOR_OPERATOR"),
	/** 商户会员 13 */
	SELLER("3", 3, "商户会员", "SELLER"),
	/** 游客中心 */
	VISITOR_CENTER("4", 4, "游客中心", "VISITOR_CENTER"),
	
	/** 配送员 */
	DELIVERY_PERSON("6", 6, "配送员", "DELIVERY_PERSON"),
	
	/** 管理员 */
	ADMIN("1", 1, "管理员", "ADMIN");
	
	/** 角色id */
	private final String code;
	
	/** 角色编码 */
	private final String roleCode;
	
	/** 枚举描述 */
	private final String message;
	/** 角色id */
	private final int value;
	
	/**
	 * 构造一个<code>SysUserRoleEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private SysUserRoleEnum(String code, int value, String message, String roleCode) {
		this.code = code;
		this.message = message;
		this.value = value;
		this.roleCode = roleCode;
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
	
	public int getValue() {
		return value;
	}
	
	public String getRoleCode() {
		return roleCode;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return SysUserRoleEnum
	 */
	public static SysUserRoleEnum getByCode(String code) {
		for (SysUserRoleEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static SysUserRoleEnum getByValue(int value) {
		for (SysUserRoleEnum _enum : values()) {
			if (_enum.getValue() == value) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<SysUserRoleEnum>
	 */
	public List<SysUserRoleEnum> getAllEnum() {
		List<SysUserRoleEnum> list = new ArrayList<SysUserRoleEnum>();
		for (SysUserRoleEnum _enum : values()) {
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
		for (SysUserRoleEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 通过值判断是否是预置的角色
	 * @param value
	 * @return
	 */
	public static boolean isSysRoleByValue(int value) {
		for (SysUserRoleEnum _enum : values()) {
			if (_enum.getValue() == value) {
				return true;
			}
		}
		return false;
	}
}
