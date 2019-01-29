package com.yjf.esupplier.ws.product.enums;

/*订单分类*/
public enum SaleTypeEnum {
	O2O("O2O", "美食",true),
	B2C("B2C", "邮购",false),
	ORDER_MEAL("ORDER_MEAL", "点餐",false),
	HOTELS("HOTELS", "酒店",true),

	TICKET("TICKET", "门票",false),
	PAY_TO_SHOP("PAY_TO_SHOP", "到店付",false),
	OFFLINE("OFFLINE", "线下支付",false),
	ALL("ALL", "ALL",false);

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/** 商品分类 */
	private final Boolean productType;
	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private SaleTypeEnum(String code, String message,Boolean productType) {
		this.code = code;
		this.message = message;
		this.productType = productType;
	}

	public Boolean getProductType() {
		return productType;
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
	 * @return SaleType
	 */
	public static SaleTypeEnum getByCode(String code) {
		for (SaleTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 *
	 * @return List<SaleType>
	 */
	public static java.util.List<SaleTypeEnum> getAllEnum() {
		java.util.List<SaleTypeEnum> list = new java.util.ArrayList<SaleTypeEnum>(values().length);
		for (SaleTypeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}

	/**
	 * 获取全部页面支持类型枚举
	 *
	 * @return List<SaleType>
	 */
	public static java.util.List<SaleTypeEnum> getProductTypeEnum() {
		java.util.List<SaleTypeEnum> list = new java.util.ArrayList<SaleTypeEnum>(values().length);
		for (SaleTypeEnum _enum : values()) {
			if(_enum.getProductType()) {
				list.add(_enum);
			}
		}
		return list;
	}

	/**
	 * 获取全部页面未选择支持类型枚举
	 *
	 * @return List<SaleType>
	 */
	public static java.util.List<SaleTypeEnum> getProductTypeNotEnum(String ckValue) {
		java.util.List<SaleTypeEnum> list = new java.util.ArrayList<SaleTypeEnum>(values().length);
		for (SaleTypeEnum _enum : values()) {
			if(_enum.getProductType()&&!ckValue.contains(_enum.getCode())) {
				list.add(_enum);
			}
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
		for (SaleTypeEnum _enum : values()) {
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
		SaleTypeEnum _enum = getByCode(code);
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
	public static String getCode(SaleTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}

