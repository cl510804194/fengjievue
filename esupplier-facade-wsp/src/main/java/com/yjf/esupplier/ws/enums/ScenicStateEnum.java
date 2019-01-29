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
 * @History
 * <li>Author: huangxl</li>
 * <li>Date: 2016-05-28</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum ScenicStateEnum {
								
	NORMAL("normal", "正常"),
	DISABLE("disable", "禁用");
								
	private final String code;
	private final String message;
	
	private ScenicStateEnum(String code, String message) {
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
	public static ScenicStateEnum getByCode(String code) {
		for (ScenicStateEnum _enum : values()) {
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
	public List<ScenicStateEnum> getAllEnum() {
		List<ScenicStateEnum> list = new ArrayList<ScenicStateEnum>();
		for (ScenicStateEnum _enum : values()) {
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
		for (ScenicStateEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
}
