package com.yjf.esupplier.ws.gifamount.enums;

import java.util.ArrayList;
import java.util.List;

public enum GiftMoneyTypeEnum {
	GIFT_MONEY("GIFT_MONEY", "红包"),
	@Deprecated
	EXPERIENCE_AMOUNT("EXPERIENCE_AMOUNT", "体验金"),
	GIFT_MONEY_CASH("GIFT_MONEY_CASH", "现金优惠券"),
	GAIN_AMOUNT("GAIN_AMOUNT", "优惠劵"),
	@Deprecated
	VIRTUAL_EXPERIENCE_AMOUNT("VIRTUAL_EXPERIENCE_AMOUNT", "虚拟体验金");
	
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	private GiftMoneyTypeEnum(String code, String message) {
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
	public static GiftMoneyTypeEnum getByCode(String code) {
		for (GiftMoneyTypeEnum _enum : values()) {
			if (_enum.code().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static GiftMoneyTypeEnum getByMessage(String message) {
		for (GiftMoneyTypeEnum _enum : values()) {
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
	public static List<GiftMoneyTypeEnum> getAllEnum() {
		List<GiftMoneyTypeEnum> list = new ArrayList<GiftMoneyTypeEnum>();
		for (GiftMoneyTypeEnum _enum : values()) {
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
		for (GiftMoneyTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
