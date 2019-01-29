package com.yjf.esupplier.ws.enums;

public enum ProductRecommendTypeEnum {

	/*商品推荐分类*/
	PRODUCT_TOP("PRODUCT_TOP", " 商品首页推荐"),

	PERSON_TOP("PERSON_TOP", "个人首页推荐");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private ProductRecommendTypeEnum(String code, String message) {
		this.code = code;
		this.message = message;
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
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return DepositStatusEnum
	 */
	public static ProductRecommendTypeEnum getByCode(String code) {
		for (ProductRecommendTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DepositStatusEnum>
	 */
	public static java.util.List<ProductRecommendTypeEnum> getAllEnum() {
		java.util.List<ProductRecommendTypeEnum> list = new java.util.ArrayList<ProductRecommendTypeEnum>(
			values().length);
		for (ProductRecommendTypeEnum _enum : values()) {
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
		for (ProductRecommendTypeEnum _enum : values()) {
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
		ProductRecommendTypeEnum _enum = getByCode(code);
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
	public static String getCode(ProductRecommendTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
