package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Filename CutstomerImageTypeEnum.java
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
public enum CutstomerImageTypeEnum {

		/** 身份证图片 */
		CARD("CARD", "身份证图片"),

		/** 户口薄 */
		HOUSEHOLD("HOUSEHOLD", "户口薄"),

		/** 驾驶证 */
		DRIVING_LICENCE("DRIVING_LICENCE", "驾驶证"),

		/** 社保卡 */
		MEDICAL_CARD("MEDICAL_CARD", "社保卡"),

		/** 银行卡 */
		BANK_CARD("BANK_CARD", "银行卡"),

		/** 工卡 */
		WORK_CARD("WORK_CARD", "工卡"),

	    /** 银行对账单**/
	    BANK_STATEMENT("BANK_STATEMENT","银行对账单"),

	    /** 银行存折**/
		BANK_BOOK("BANK_BOOK","银行存折"),

		/** 学生证**/
		STUDENT_CARD("STUDENT_CARD","学生证"),

		/** 学生证明**/
		STUDENT_CERTIFY("STUDENT_CERTIFY","学生证明");

		private final String code;
		private final String message;

		private CutstomerImageTypeEnum(String code, String message) {
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
	public static CutstomerImageTypeEnum getByCode(String code) {
		for (CutstomerImageTypeEnum _enum : values()) {
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
	public List<CutstomerImageTypeEnum> getAllEnum() {
		List<CutstomerImageTypeEnum> list = new ArrayList<CutstomerImageTypeEnum>();
		for (CutstomerImageTypeEnum _enum : values()) {
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
		for (CutstomerImageTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
