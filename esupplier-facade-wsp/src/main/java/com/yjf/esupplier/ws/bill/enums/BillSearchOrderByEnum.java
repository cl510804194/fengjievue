package com.yjf.esupplier.ws.bill.enums;

public enum BillSearchOrderByEnum {
	PAY_TIEM_DESC("PAY_TIEM_DESC", "支付时间倒序", "order by payed_time desc"),
	PAY_TIEM_ASC("PAY_TIEM_ASC", "支付时间正序", "order by payed_time asc"),
	ADD_DATE_DESC("PAY_TIEM_DESC", "支付时间倒序", "order by raw_add_time desc"),
	ADD_DATE_ASC("ADD_DATE_ASC", "支付时间正序", "order by raw_add_time asc"),
	DINING_TIME_ASC("DINING_TIME_ASC", "预约就餐时间正序", "order by dining_time asc,batch_no"),
	ORDERS_TIME_ASC("ORDERS_TIME_ASC", "下单时间正序", "order by dining_time asc,batch_no"),
	RECEIPT_TIME_ASC("RECEIPT_TIME_ASC", "收货时间正序", "order by confirm_receipt_time asc,batch_no"),
	RECEIPT_TIME_DESC("RECEIPT_TIME_DESC", "收货时间倒序",
						"order by confirm_receipt_time desc,batch_no");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/** 枚举描述 */
	private final String orderSql;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private BillSearchOrderByEnum(String code, String message, String orderSql) {
		this.code = code;
		this.message = message;
		this.orderSql = orderSql;
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
	
	public String getOrderSql() {
		return this.orderSql;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return BillSearchOrderByEnum
	 */
	public static BillSearchOrderByEnum getByCode(String code) {
		for (BillSearchOrderByEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<BillSearchOrderByEnum>
	 */
	public static java.util.List<BillSearchOrderByEnum> getAllEnum() {
		java.util.List<BillSearchOrderByEnum> list = new java.util.ArrayList<BillSearchOrderByEnum>(
			values().length);
		for (BillSearchOrderByEnum _enum : values()) {
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
		for (BillSearchOrderByEnum _enum : values()) {
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
		BillSearchOrderByEnum _enum = getByCode(code);
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
	public static String getCode(BillSearchOrderByEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
