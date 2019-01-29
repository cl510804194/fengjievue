package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename UserStateEnum.java
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
 * <li>Content: create</li>
 * 
 */
public enum MerchantStateEnum {
	
	OFFLINE("OFFLINE", "已禁用"),
	
	NOT_IN("NOT_IN", "待入驻"),
	
	IN("IN", "已入驻");
	
	private final String code;
	private final String message;
	
	private MerchantStateEnum(String code, String message) {
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
	public static MerchantStateEnum getByCode(String code) {
		for (MerchantStateEnum _enum : values()) {
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
	public List<MerchantStateEnum> getAllEnum() {
		List<MerchantStateEnum> list = new ArrayList<MerchantStateEnum>();
		for (MerchantStateEnum _enum : values()) {
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
		for (MerchantStateEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
}
