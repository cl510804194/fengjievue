/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.integral.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename PointsStateEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author lzb
 * 
 * @Email caigen@yiji.com
 * 
 * @History <li>Author: lzb</li> <li>Date: 2014-8-22</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum PointsRuleStateEnum {
	
	NORMAL("normal", "正常"),
	EXPIRED("expired", "过期"),
	EXPIRE_PROCESSING("expire_processing", "过期处理中"),
	WAIT("wait", "待生效"),
	STOP("stop", "已停用");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>BooleanEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private PointsRuleStateEnum(String code, String message) {
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
	 * @return BooleanEnum
	 */
	public static PointsRuleStateEnum getByCode(String code) {
		for (PointsRuleStateEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<BooleanEnum>
	 */
	public List<PointsRuleStateEnum> getAllEnum() {
		List<PointsRuleStateEnum> list = new ArrayList<PointsRuleStateEnum>();
		for (PointsRuleStateEnum _enum : values()) {
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
		for (PointsRuleStateEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
