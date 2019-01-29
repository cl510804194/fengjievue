package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename RefundEnum.java
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
public enum RefundEnum {
	/** 还款成功 */
	REFUND_SUCCESS("REFUND_SUCCESS", "还款成功"),
	
	REFUND_PROCESS("REFUND_PROCESS", "还款处理中"),
	
	/** 未还款 */
	NOT_REFUND("NOT_REFUND", "未还款"),
	
	/** 超期还款 */
	EXTENDED_REFUND("EXTENDED_REFUND", "超期还款"),
	
	/** 还款失败 */
	REFUND_FAILED("REFUND_FAILED", "还款失败");
	
	private final String code;
	private final String message;
	
	private RefundEnum(String code, String message) {
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
	public static RefundEnum getByCode(String code) {
		for (RefundEnum _enum : values()) {
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
	public List<RefundEnum> getAllEnum() {
		List<RefundEnum> list = new ArrayList<RefundEnum>();
		for (RefundEnum _enum : values()) {
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
		for (RefundEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
