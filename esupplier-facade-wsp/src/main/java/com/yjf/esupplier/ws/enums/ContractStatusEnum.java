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
public enum ContractStatusEnum {
	
	/** 待审核 */
	WAIT("WAIT", "待审核"),
	
	/** 草稿 */
	DRAFT("DRAFT", "草稿"),
	
	/** 审核通过 */
	PASSED("PASSED", "审核通过"),
	
	/** 驳回 */
	REJECT("REJECT", "驳回"),
	
	/** 已发货 */
	DELIVER("DELIVER", "已发货"),
	
	/** 还款中 */
	REFUNDING("REFUNDING", "还款中"),
	
	/** 已完成 */
	SUCCESS("SUCCESS", "已完成"),
	
	/** 待修改 **/
	WAIT_UPDATE("WAIT_UPDATE", "待修改");
	
	private final String code;
	private final String message;
	
	private ContractStatusEnum(String code, String message) {
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
	public static ContractStatusEnum getByCode(String code) {
		for (ContractStatusEnum _enum : values()) {
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
	public List<ContractStatusEnum> getAllEnum() {
		List<ContractStatusEnum> list = new ArrayList<ContractStatusEnum>();
		for (ContractStatusEnum _enum : values()) {
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
		for (ContractStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
