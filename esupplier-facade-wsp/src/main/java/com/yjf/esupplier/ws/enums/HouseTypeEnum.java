package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Filename MatchStatusEnum.java
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
public enum HouseTypeEnum {

		/** 自由住房 */
        OWN("OWN", "自由住房"),

		/** 租房 */
        TENEMENT("TENEMENT", "租房"),

		/** 集团房产 */
        GROUP_HOUSE("GROUP_HOUSE", "集团房产"),

        /** 父母房产 */
        PARENT_HOUSE("PARENT_HOUSE", "父母房产"),

        /** 宿舍 */
        DORMITORY("DORMITORY", "宿舍");

		private final String code;
		private final String message;

		private HouseTypeEnum(String code, String message) {
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
	public static HouseTypeEnum getByCode(String code) {
		for (HouseTypeEnum _enum : values()) {
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
	public List<HouseTypeEnum> getAllEnum() {
		List<HouseTypeEnum> list = new ArrayList<HouseTypeEnum>();
		for (HouseTypeEnum _enum : values()) {
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
		for (HouseTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
