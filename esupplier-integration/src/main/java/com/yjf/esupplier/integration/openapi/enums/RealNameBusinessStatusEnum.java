/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename RealNameBusinessStatusEnum.java
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
 *<li>Date: 2014-4-7</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum RealNameBusinessStatusEnum {
	
	UNAUTHERIZED("UNAUTHERIZED", "未认证"),
	
	NEW_APP("NEW_APP", "待认证"),
	
	AUDIT_DENY("AUDIT_DENY", "公安部驳回"),
	
	AUDIT_PASSED("AUDIT_PASSED", "公安部通过"),
	
	CHECK_DENY("CHECK_DENY", "审核驳回"),
	
	CHECK_PASSED("CHECK_PASSED", "审核通过"),
	
	FORCE_DENY("FORCE_DENY", "强制驳回"),
	
	NEW_APP_DENY("NEW_APP_DENY", "待认证驳回");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>RealNameBusinessStatusEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 * @return 
	 */
	private RealNameBusinessStatusEnum(String code, String message) {
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
	 * @return RealNameBusinessStatusEnum
	 */
	public static RealNameBusinessStatusEnum getByCode(String code) {
		for (RealNameBusinessStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<RealNameBusinessStatusEnum>
	 */
	public List<RealNameBusinessStatusEnum> getAllEnum() {
		List<RealNameBusinessStatusEnum> list = new ArrayList<RealNameBusinessStatusEnum>();
		for (RealNameBusinessStatusEnum _enum : values()) {
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
		for (RealNameBusinessStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 正在处理中(ture:处理中)
	 */
	public boolean isProcessing() {
		if (this.code().equals(RealNameBusinessStatusEnum.NEW_APP.getCode())
			|| this.code().equals(RealNameBusinessStatusEnum.AUDIT_PASSED.getCode())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否驳回 (true:驳回)
	 */
	public boolean isDeny() {
		if (RealNameBusinessStatusEnum.AUDIT_DENY.getCode().equals(this.code())
			|| RealNameBusinessStatusEnum.CHECK_DENY.getCode().equals(this.code())
			|| RealNameBusinessStatusEnum.FORCE_DENY.getCode().equals(this.code())
			|| RealNameBusinessStatusEnum.NEW_APP_DENY.getCode().equals(this.code())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 能否提交实名，正在处理中或者已实名成功不能提交    (false:不能重复提交数据，ture:可以提交)
	 */
	public boolean isChecking() {
		if (this.code().equals(RealNameBusinessStatusEnum.NEW_APP.getCode())
			|| this.code().equals(RealNameBusinessStatusEnum.AUDIT_PASSED.getCode())
			|| this.code().equals(RealNameBusinessStatusEnum.CHECK_PASSED.getCode())) {
			return false;
		}
		return true;
	}
}
