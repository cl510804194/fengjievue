/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename DivisionWayEnum.java
 * 
 * @Description 分润方式
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-11</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public enum DivisionWayEnum {
	
	/**
	 * 按笔坐返
	 */
	SIT_WAY("sit", "到期归还本金及利息", "ONE_ALL_RETURN"),
	/**
	 * 按月期返
	 */
	MONTH_WAY("month", "按月还息，到期还本", "AVG_CAPITAL_AND_INTEREST"),
	/**
	 * 
	 */
	MONTH_PI_WAY("month_pi_way", "按月还息，到期还本", "AVG_CAPITAL_AND_INTEREST"),
	
	MONTH_PRINCIPAL_INTEREST("month_principal_interest", "按月等额本息", "AVG_MONTH_PRINCIPAL_INTEREST"),
	
	OTHER("other", "其他", "NONE_REVERSE");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/** 枚举描述 */
	private final String bornFinanaceName;
	
	/**
	 * 构造一个<code>DivisionWayEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private DivisionWayEnum(String code, String message, String bornFinanaceName) {
		this.code = code;
		this.message = message;
		this.bornFinanaceName = bornFinanaceName;
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
	
	public String getBornFinanaceName() {
		return this.bornFinanaceName;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return DivisionWayEnum
	 */
	public static DivisionWayEnum getByCode(String code) {
		for (DivisionWayEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DivisionWayEnum>
	 */
	public List<DivisionWayEnum> getAllEnum() {
		List<DivisionWayEnum> list = new ArrayList<DivisionWayEnum>();
		for (DivisionWayEnum _enum : values()) {
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
		for (DivisionWayEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
