package com.yjf.esupplier.ws.gifamount.enums;

import java.util.ArrayList;
import java.util.List;

public enum GiftMoneyGiveTypeEnum {
	REWARD("REWARD", "推荐", false),
	BIND_CARD("BIND_CARD", "绑卡", false),
	DIRECT("DIRECT", "定向赠送", true),
	LOTTERY("LOTTERY", "抽奖", false),
	REGISTER("REGISTER", "注册", true),
	ALL_TRADE("ALL_TRADE", "累计交易", false),
	AUTHENTICATION("AUTHENTICATION", "实名", false),
	DEDUCT_DEPOSIT("DEDUCT_DEPOSIT", "充值", false),
	ONLY_TRADE("ONLY_TRADE", "单笔交易满", false),
	REGISTER_24_TRADE("REGISTER_24_TRADE", "注册24小时内交易", false),
	FIRST_DEDUCT_DEPOSIT("FIRST_DEDUCT_DEPOSIT", "首次充值", false),
	WITHDRAW("WITHDRAW", "提现", false),
	FIRST_TRADE("FIRST_TRADE", "完成首次交易", false),
	POINT_EXCHANGE("POINT_EXCHANGE", "积分兑换", false),
	FIRST_TRADE_TOTAL("FIRST_INVEST_TOTAL", "首次交易满", false),
	USING_RULES("USING_RULES", "使用规则", false);
	
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * 是否启用
	 */
	private final boolean isEnable;
	
	/**
	 * @param code
	 * @param message
	 */
	private GiftMoneyGiveTypeEnum(String code, String message, boolean isEnable) {
		this.code = code;
		this.message = message;
		this.isEnable = isEnable;
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
	
	/*
	* huangxl 改方法名 ，不然macros里面分不清是属性和方法名
	* */
	public boolean getIsEnable() {
		return this.isEnable;
	}
	
	/**
	 * @param code
	 * @return UserStatusEnum
	 */
	public static GiftMoneyGiveTypeEnum getByCode(String code) {
		for (GiftMoneyGiveTypeEnum _enum : values()) {
			if (_enum.code().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static GiftMoneyGiveTypeEnum getByMessage(String message) {
		for (GiftMoneyGiveTypeEnum _enum : values()) {
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
	public static List<GiftMoneyGiveTypeEnum> getAllEnum() {
		List<GiftMoneyGiveTypeEnum> list = new ArrayList<GiftMoneyGiveTypeEnum>();
		for (GiftMoneyGiveTypeEnum _enum : values()) {
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
		for (GiftMoneyGiveTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
