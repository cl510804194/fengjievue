package com.yjf.esupplier.ws.common.enums;

public enum SeqNameEnum {
	ADDRESS_SEQ("ADDRESS_SEQ", "收货地址", 10),
	ORDER_INFO_SEQ("ORDER_INFO_SEQ", "订单", 1),
    ORDER_BATCH_SEQ("ORDER_BATCH_SEQ", "订单批次号", 10),
	PRODUCT_ID_SEQ("PRODUCT_ID_SEQ", "产品id", 5),
	STORAGE_IN_OUT_SEQ("STORAGE_IN_OUT_SEQ", "库存订单", 10),
	STORAGE_IN_OUT_DETAIL_SEQ("STORAGE_IN_OUT_DETAIL_SEQ", "库存明细订单", 10),
	ORDER_ITEM_SEQ("ORDER_ITEM_SEQ", "交易明细订单", 30),
	PAYMENT_FLOW_ID_SEQ("PAYMENT_FLOW_ID_SEQ", "付款流水表", 30, 1),
	DINING_TABLE_SEQ("DINING_TABLE_SEQ", "点餐流水桌号", 30, 100);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/**
	 * 缓存个数
	 */
	private final int cacheCount;
	
	private final long beginIndex;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private SeqNameEnum(String code, String message, int cacheCount) {
		this.code = code;
		this.message = message;
		this.cacheCount = cacheCount;
		this.beginIndex = 1;
	}
	
	private SeqNameEnum(String code, String message, int cacheCount, long beginIndex) {
		this.code = code;
		this.message = message;
		this.cacheCount = cacheCount;
		this.beginIndex = beginIndex;
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
	
	public int getCacheCount() {
		return this.cacheCount;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return SeqNameEnum
	 */
	public static SeqNameEnum getByCode(String code) {
		for (SeqNameEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<SeqNameEnum>
	 */
	public static java.util.List<SeqNameEnum> getAllEnum() {
		java.util.List<SeqNameEnum> list = new java.util.ArrayList<SeqNameEnum>(values().length);
		for (SeqNameEnum _enum : values()) {
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
		for (SeqNameEnum _enum : values()) {
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
		SeqNameEnum _enum = getByCode(code);
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
	public static String getCode(SeqNameEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
