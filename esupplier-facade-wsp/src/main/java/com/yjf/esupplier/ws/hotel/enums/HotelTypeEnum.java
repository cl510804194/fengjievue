package com.yjf.esupplier.ws.hotel.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum HotelTypeEnum {
	ALL("ALL", "不限",false),
	NORMAL("NORMAL", "普通房",true),
	SPECIAL("SPECIAL", "特价房",false),
	MORNING("MORNING", "凌晨房",false),
	LONGRENT("LONGRENT", "长包房",false);

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/** 是否支持退款 */
	private final boolean canRefund;

	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private HotelTypeEnum(String code, String message,boolean canRefund) {
		this.code = code;
		this.message = message;
		this.canRefund = canRefund;
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


	public boolean isCanRefund() {
		return canRefund;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return ProductStatusEnum
	 */
	public static HotelTypeEnum getByCode(String code) {
		for (HotelTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<ProductStatusEnum>
	 */
	public static java.util.List<HotelTypeEnum> getAllEnum() {
		java.util.List<HotelTypeEnum> list = new java.util.ArrayList<HotelTypeEnum>(
			values().length);
		for (HotelTypeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public static java.util.List<String> getAllEnumCode() {
		java.util.List<String> list = new java.util.ArrayList<String>(values().length);
		for (HotelTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}

	/**
	 * 获取全部枚举值
	 *
	 * @return List<String>
	 */
	public static List<Map<String, String>> getAllEnumList() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>(values().length);
		for (HotelTypeEnum _enum : values()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("code",_enum.code());
			map.put("name",_enum.getMessage());
			list.add(map);
		}
		return list;
	}

	/**
	 * 通过code获取msg
	 * @param code 枚举值
	 * @return
	 */
	public static String getMsgByCode(String code) {
		if (code == null) {
			return null;
		}
		HotelTypeEnum _enum = getByCode(code);
		if (_enum == null) {
			return null;
		}
		return _enum.getMessage();
	}
	
	/**
	 * 获取枚举code
	 * @param _enum
	 * @return
	 */
	public static String getCode(HotelTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
