package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Filename UnitTypeEnum.java
 *
 * @Description 单位性质
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
public enum UnitTypeEnum {
		/** 国有单位 */
    STATE_OWN("STATE_OWN", "国有单位"),

    /** 个体经营 */
    SELF_EMPLOYED("SELF_EMPLOYED", "个体经营"),

    /** 集体 */
    GROP("GROP", "集体"),

    /** 外贸 */
    FOREIGN_TRADE("FOREIGN_TRADE", "外贸"),

    /** 农民 */
    FARMER("FARMER", "农民"),

    /** 其它 */
    OTHER("OTHER", "其它");

    private final String code;
    private final String message;

    private UnitTypeEnum(String code, String message) {
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
	public static UnitTypeEnum getByCode(String code) {
		for (UnitTypeEnum _enum : values()) {
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
	public List<UnitTypeEnum> getAllEnum() {
		List<UnitTypeEnum> list = new ArrayList<UnitTypeEnum>();
		for (UnitTypeEnum _enum : values()) {
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
		for (UnitTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
