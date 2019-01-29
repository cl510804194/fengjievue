package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

public enum LoanDemandStatusEnum {
	
	WITE("wite", "未审核"),
	PASS("pass", "审核通过"),
	DISMISS("dismiss", "审核驳回"),
	DRAFT("draft", "草稿箱"),
	OFFLINE("offline", "下线");
	
	private final String code;
	
	private final String message;
	
	private LoanDemandStatusEnum(String code, String message) {
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
	public static LoanDemandStatusEnum getByCode(String code) {
		for (LoanDemandStatusEnum _enum : values()) {
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
	public List<LoanDemandStatusEnum> getAllEnum() {
		List<LoanDemandStatusEnum> list = new ArrayList<LoanDemandStatusEnum>();
		for (LoanDemandStatusEnum _enum : values()) {
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
		for (LoanDemandStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
}
