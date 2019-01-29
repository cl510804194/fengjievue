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
public enum PointsStateEnum {
	
	POINTS_SENT("points_sent", "已发放"),
	CONSUMER("consumer", "消费"),
	EXPIRED("expired", "过期"),
	GOODS_SENT("goods_sent", "已寄送"),
	GOODS_WAIT("goods_wait", "待寄送");
	
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
	private PointsStateEnum(String code, String message) {
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
	public static PointsStateEnum getByCode(String code) {
		for (PointsStateEnum _enum : values()) {
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
	public List<PointsStateEnum> getAllEnum() {
		List<PointsStateEnum> list = new ArrayList<PointsStateEnum>();
		for (PointsStateEnum _enum : values()) {
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
		for (PointsStateEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
