package com.yjf.esupplier.ws.product.enums;

/**
 * 运费支付方式
 * 
 * 
 * @author qch
 * 
 */
public enum PostFeeTypeEnum {
	//0：卖家承担，1：联系卖家，2：买家承担;
	SELLER("SELLER", "卖家承担", 0),
	
	CONTACT_SELLER("CONTACT_SELLER", "联系卖家", 1),
	
	BUYER("BUYER", "买家承担", 2);
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/**
	 * DBvalue
	 */
	private final int dbValue;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private PostFeeTypeEnum(String code, String message, int dbValue) {
		this.code = code;
		this.message = message;
		this.dbValue = dbValue;
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
	
	public int getDbValue() {
		return this.dbValue;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return PostFeeTypeEnum
	 */
	public static PostFeeTypeEnum getByCode(String code) {
		for (PostFeeTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static PostFeeTypeEnum getByDBValue(int value) {
		for (PostFeeTypeEnum _enum : values()) {
			if (_enum.dbValue == value) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<PostFeeTypeEnum>
	 */
	public static java.util.List<PostFeeTypeEnum> getAllEnum() {
		java.util.List<PostFeeTypeEnum> list = new java.util.ArrayList<PostFeeTypeEnum>(
			values().length);
		for (PostFeeTypeEnum _enum : values()) {
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
		for (PostFeeTypeEnum _enum : values()) {
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
		PostFeeTypeEnum _enum = getByCode(code);
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
	public static String getCode(PostFeeTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
