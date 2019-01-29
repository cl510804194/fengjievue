package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Filename EducationLevelEnum.java
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
public enum EducationLevelEnum {

		/** 小学 */
		PRIMARY("PRIMARY", "小学"),

		/** 中学 */
		MIDDLE_SCHOOL("MIDDLE_SCHOOL", "中学"),

		/** 职高/中专 */
		AVERAGE("AVERAGE", "职高/中专"),

		/** 大专 */
		COLLEGE("COLLEGE", "大专"),

		/** 本科 */
		UNDERGRADUATE("UNDERGRADUATE", "本科"),

		/** 硕士及以上 */
		MASTER("MASTER", "硕士及以上");

		private final String code;
		private final String message;

		private EducationLevelEnum(String code, String message) {
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
	public static EducationLevelEnum getByCode(String code) {
		for (EducationLevelEnum _enum : values()) {
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
	public List<EducationLevelEnum> getAllEnum() {
		List<EducationLevelEnum> list = new ArrayList<EducationLevelEnum>();
		for (EducationLevelEnum _enum : values()) {
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
		for (EducationLevelEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
