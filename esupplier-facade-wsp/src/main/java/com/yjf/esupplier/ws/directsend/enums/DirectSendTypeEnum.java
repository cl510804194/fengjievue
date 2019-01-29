package com.yjf.esupplier.ws.directsend.enums;

import java.util.ArrayList;
import java.util.List;

public enum DirectSendTypeEnum {
	USERGROUP("USERGROUP", "用户群"),
	MUTIUSER("MULTIUSER", "多个用户"),
	MARKETING_CHILDREN("MARKETING_CHILDREN", "营销机构下所有用户"),
	MARKETING_CHILDREN_BORKER("MARKETING_CHILDREN_BORKER", "营销机构下所有经纪人"),
	BROKER_CHILDREN("BROKER_CHILDREN", "经纪人下所有投资人"),
	BROKER_CHILDREN_INVESTOR("BROKER_CHILDREN_INVESTOR", "经纪人下直属投资人"),
	SINGLEUSER("SINGLEUSER", "单个用户");
	
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * @param code
	 * @param message
	 */
	private DirectSendTypeEnum(String code, String message) {
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
	public static DirectSendTypeEnum getByCode(String code) {
		for (DirectSendTypeEnum _enum : values()) {
			if (_enum.code().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static DirectSendTypeEnum getByMessage(String message) {
		for (DirectSendTypeEnum _enum : values()) {
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
	public static List<DirectSendTypeEnum> getAllEnum() {
		List<DirectSendTypeEnum> list = new ArrayList<DirectSendTypeEnum>();
		for (DirectSendTypeEnum _enum : values()) {
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
		for (DirectSendTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
