package com.yjf.esupplier.ws.directsend.enums;

import java.util.ArrayList;
import java.util.List;

public enum DirectSendStatusEnum {
	FAIL("FAIL", "发送失败"),
	SUCESS("SUCESS", "发送成功");
	
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * @param code
	 * @param message
	 */
	private DirectSendStatusEnum(String code, String message) {
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
	 * @param code
	 * @return UserStatusEnum
	 */
	public static DirectSendStatusEnum getByCode(String code) {
		for (DirectSendStatusEnum _enum : values()) {
			if (_enum.code().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static DirectSendStatusEnum getByMessage(String message) {
		for (DirectSendStatusEnum _enum : values()) {
			if (_enum.message().equals(message)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<UserStatusEnum>
	 */
	public static List<DirectSendStatusEnum> getAllEnum() {
		List<DirectSendStatusEnum> list = new ArrayList<DirectSendStatusEnum>();
		for (DirectSendStatusEnum _enum : values()) {
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
		for (DirectSendStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
