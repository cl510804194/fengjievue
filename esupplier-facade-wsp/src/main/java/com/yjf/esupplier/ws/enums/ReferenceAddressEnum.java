package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Filename ReferenceAddressEnum.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author sxiaomeng
 *
 * @Email weizhi@yiji.com
 *
 * @History <li>Author: sxiaomeng</li> <li>Date: 2015-3-26</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public enum ReferenceAddressEnum {

		/** 户籍地址 */
        HOUSEHOLD("HOUSEHOLD", "户籍地址"),

		/** 现居地址 */
        LIVE("LIVE", "现居地址"),

		/** 单位地址 */
        COMPANY("COMPANY", "单位地址"),

        /** 家庭成员地址 **/
        MEMBER_ADDRESS("MEMBER_ADDRESS", "单位地址"),;

		private final String code;

		private final String message;

		private ReferenceAddressEnum(String code, String message) {
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
	public static ReferenceAddressEnum getByCode(String code) {
		for (ReferenceAddressEnum _enum : values()) {
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
	public List<ReferenceAddressEnum> getAllEnum() {
		List<ReferenceAddressEnum> list = new ArrayList<ReferenceAddressEnum>();
		for (ReferenceAddressEnum _enum : values()) {
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
		for (ReferenceAddressEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
