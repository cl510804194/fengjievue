package com.yjf.esupplier.web.controller.backstage.enums;

public enum ProductTypeImageEnum {
	TYPE_81("81", "身体检测","0001-0001-0001"),
	TYPE_82("82", "运动医疗","0001-0001-0002"),
	TYPE_83("83", "随行医生","0001-0001-0003"),
	TYPE_84("84", "私人医生","0001-0001-0004");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/** 对应导航菜单code */
	private final String typeCode;

	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private ProductTypeImageEnum(String code, String message,String typeCode) {
		this.code = code;
		this.message = message;
		this.typeCode = typeCode;
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


	public String getTypeCode() {
		return typeCode;
	}


	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return RefundProcessStatusEnum
	 */
	public static ProductTypeImageEnum getByCode(String code) {
		for (ProductTypeImageEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param TypeCode
	 * @return RefundProcessStatusEnum
	 */
	public static ProductTypeImageEnum getByTypeCode(String TypeCode) {
		for (ProductTypeImageEnum _enum : values()) {
			if (_enum.getTypeCode().equals(TypeCode)) {
				return _enum;
			}
		}
		return null;
	}
	/**
	 * 获取全部枚举
	 *
	 * @return List<RefundProcessStatusEnum>
	 */
	public static java.util.List<ProductTypeImageEnum> getAllEnum() {
		java.util.List<ProductTypeImageEnum> list = new java.util.ArrayList<ProductTypeImageEnum>(
				values().length);
		for (ProductTypeImageEnum _enum : values()) {
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
		for (ProductTypeImageEnum _enum : values()) {
			list.add(_enum.code());
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
		ProductTypeImageEnum _enum = getByCode(code);
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
	public static String getCode(ProductTypeImageEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
