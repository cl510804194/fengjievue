package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

public enum BankCodeEnum {
	
	华夏银行("HXB","HXB"),
	CITIC("中信银行","CITIC");
	
	private final String	code;
	private final String	message;
	
	private BankCodeEnum(String code, String message) {
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
	public static BankCodeEnum getByCode(String code) {
		for (BankCodeEnum _enum : values()) {
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
	public List<BankCodeEnum> getAllEnum() {
		List<BankCodeEnum> list = new ArrayList<BankCodeEnum>();
		for (BankCodeEnum _enum : values()) {
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
		for (BankCodeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	public static void main(String [] args){
		System.out.println(BankCodeEnum.getByCode("HXB"));
	}

}
