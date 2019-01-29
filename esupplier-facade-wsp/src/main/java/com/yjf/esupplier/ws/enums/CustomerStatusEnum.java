package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename ContractStatusEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author sxiaomeng
 * 
 * @Email weizhi@yiji.com
 * 
 * @History <li>Author: sxiaomeng</li> <li>Date: 2015-3-26</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public enum CustomerStatusEnum {
	
	NORMAL("NORMAL", "正常"),
	
	BLACKLIST("BLACKLIST", "黑名单");
	
	private final String code;
	private final String message;
	
	private CustomerStatusEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
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
	 * @return LogResultEnum
	 */
	public static CustomerStatusEnum getByCode(String code) {
		for (CustomerStatusEnum _enum : values()) {
			if (_enum.getCode().equalsIgnoreCase(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LogResultEnum>
	 */
	public static List<CustomerStatusEnum> getAllEnum() {
		List<CustomerStatusEnum> list = new ArrayList<CustomerStatusEnum>();
		for (CustomerStatusEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public static List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (CustomerStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
