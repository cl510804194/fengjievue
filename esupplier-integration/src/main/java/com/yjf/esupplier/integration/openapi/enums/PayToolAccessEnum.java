/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename PayToolAccessEnum.java
 * 
 * @Description <p>
 * 这里的“接入方式”是针对各类支付渠道API<b>充值</b>行为的<b>系统</b>公用处理模式而定义的；与具体支付渠道API所属的支付工具接入方式无必然
 * <br>
 * 对应关系；如此处的“EBANK”接入方式代表异步清算的系统处理模式，支付渠道API接入方式属于“EBANK”的，如网银B2C、B2B等均使用此系统接入方式
 * </p>
 * 
 * @Version 1.0
 * 
 * @Author peigen
 * 
 * @Email peigen@yiji.com
 * 
 * @History <li>Author: peigen</li> <li>Date: 2012-6-2</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum PayToolAccessEnum {
	
	EBANK_B2C("EBANK_B2C", "异步网关B2C"),
	
	EBANK_B2B("EBANK_B2B", "异步网关B2B"),
	
	OFFLINE("OFFLINE", "线下"),
	
	DEDUCT("DEDUCT", "代扣"),
	
	QUICK("QUICK", "快捷支付"),
	
	CERTIFY("CERTIFY", "证书充值"),
	
	;
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>PayToolAccessEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private PayToolAccessEnum(String code, String message) {
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
	 * @return PayToolAccessEnum
	 */
	public static PayToolAccessEnum getByCode(String code) {
		for (PayToolAccessEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<PayToolAccessEnum>
	 */
	public List<PayToolAccessEnum> getAllEnum() {
		List<PayToolAccessEnum> list = new ArrayList<PayToolAccessEnum>();
		for (PayToolAccessEnum _enum : values()) {
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
		for (PayToolAccessEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
