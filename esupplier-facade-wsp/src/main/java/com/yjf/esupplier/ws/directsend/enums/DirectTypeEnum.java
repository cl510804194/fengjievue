package com.yjf.esupplier.ws.directsend.enums;

import java.util.ArrayList;
import java.util.List;

public enum DirectTypeEnum {
	GIFT_MONEY("GIFT_MONEY", "红包"), //元
	EXPERIENCE_AMOUNT("EXPERIENCE_AMOUNT", "体验金"), //元
	GAIN_MONEY("GAIN_MONEY", "优惠券"), //百分比
	GIFT_MONEY_CASH("GIFT_MONEY_CASH", "现金红包"), //元
	POINT("POINT", "积分"), //分
	DRAW_COUNT("DRAW_COUNT", "抽奖次数"), //次
	VIP("VIP", "VIP特权");//
	
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * @param code
	 * @param message
	 */
	private DirectTypeEnum(String code, String message) {
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
	public static DirectTypeEnum getByCode(String code) {
		for (DirectTypeEnum _enum : values()) {
			if (_enum.code().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static DirectTypeEnum getByMessage(String message) {
		for (DirectTypeEnum _enum : values()) {
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
	public static List<DirectTypeEnum> getAllEnum() {
		List<DirectTypeEnum> list = new ArrayList<DirectTypeEnum>();
		for (DirectTypeEnum _enum : values()) {
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
		for (DirectTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
