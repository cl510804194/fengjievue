package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Filename MaritalTatusEnum.java
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
public enum MaritalTatusEnum {

		/** 未婚 */
		SINGLE("SINGLE", "未婚"),

		/** 已婚 */
		MARRIED("MARRIED", "已婚"),

		/** 其它 */
		OTHER("OTHER", "其它");

		private final String code;
		private final String message;

		private MaritalTatusEnum(String code, String message) {
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
	public static MaritalTatusEnum getByCode(String code) {
		for (MaritalTatusEnum _enum : values()) {
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
	public List<MaritalTatusEnum> getAllEnum() {
		List<MaritalTatusEnum> list = new ArrayList<MaritalTatusEnum>();
		for (MaritalTatusEnum _enum : values()) {
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
		for (MaritalTatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
