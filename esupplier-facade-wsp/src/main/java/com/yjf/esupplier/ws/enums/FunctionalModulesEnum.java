/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename FunctionalModules.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-2-24</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public enum FunctionalModulesEnum {
	
	/** 找回密码功能 */
	//TODO  根据app测试需求由3更改为200 上线前更改回来
	FORGOT_PASSWORD("FORGOT_PASSWORD", "找回密码", 3),
	
	/** 账户激活功能 */
	ACCOUNT_ACTIVATION("ACCOUNT_ACTIVATION", "账户激活", 3),
	/** 维护借资方信息 */
	MAINTAIN_OWNEDLENDERINFO("MAINTAIN_OWNEDLENDERINFO", "维护借资方信息", 20),
	/** 权限管理 */
	MAINTAIN_MANAGERINFO("MAINTAIN_MANAGERINFO", "权限管理", 20),
	/** 绑定手机号修改 */
	MODIFY_MOBILEPHONE("MODIFY_MOBILEPHONE", "绑定手机号修改", 3),
	/** 绑定买卖双方银行卡信息 */
	CREATE_TRADE_BANK_CODE("LOCK_TRADE_BANK_CODE", "绑定买卖双方银行卡信息", 60),
	/** 修改买卖双方银行卡信息 */
	LOCK_TRADE_BANK_CODE("LOCK_TRADE_BANK_CODE", "绑定买卖双方银行卡信息", 60),
	/** 中介进行的代扣操作 */
	AGENCY_APPLY_DEDUCT_AMOUNT("AGENCY_APPLY_DEDUCT_AMOUNT", "中介进行的代扣操作", 60),
	/** 中介进行的修改操作 */
	AGENCY_APPLY_MODIFY_TRADE("AGENCY_APPLY_MODIFY_TRADE", "中介进行的修改操作", 100),
	/** 中介进行的买方卖方手机验证操作 */
	AGENCY_TRADE_MOBILE_CHECK("AGENCY_TRADE_MOBILE_CHECK", "中介进行的买方卖方手机验证操作", 100),
	/** 中介进行的取消交易操作 */
	AGENCY_APPLY_CANCEL_TRADE("AGENCY_APPLY_CANCEL_TRADE", "中介进行的取消交易操作", 100),
	/** 中介进行的提前清分交易操作 */
	AGENCY_APPLY_CLEARING_TRADE("AGENCY_APPLY_CLEARING_TRADE", "中介进行的提前清分交易操作", 100),
	/** 交易查询 */
	CUSTOMER_QUERY_TRADE("CUSTOMER_QUERY_TRADE", "交易查询", 100),
	/** 绑定买卖双方银行卡信息 */
	USER_LOGIN("USER_LOGIN", "登录系统", 60),
	/** 其他功能 */
	OTHER("OTHER", "其他", 3);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 枚举描述 */
	private final int sendCount;
	
	/**
	 * 构造一个<code>FunctionalModulesEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private FunctionalModulesEnum(String code, String message, int sendCount) {
		this.code = code;
		this.message = message;
		this.sendCount = sendCount;
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
	
	public int getSendCount() {
		return sendCount;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return FunctionalModulesEnum
	 */
	public static FunctionalModulesEnum getByCode(String code) {
		for (FunctionalModulesEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<FunctionalModulesEnum>
	 */
	public List<FunctionalModulesEnum> getAllEnum() {
		List<FunctionalModulesEnum> list = new ArrayList<FunctionalModulesEnum>();
		for (FunctionalModulesEnum _enum : values()) {
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
		for (FunctionalModulesEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
