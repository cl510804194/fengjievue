package com.yjf.esupplier.ws.bill.enums;

public enum OrderStatusEnum {
	
	/**
	 * 等待买家付款
	 */
	WFK("WFK", "等待买家付款", false, "等待买家付款", "等待买家付款", "待支付","待付款"),
	/**
	 * 等待卖家发货
	 */
	YFK("YFK", "买家已付款", true, "等待线下消费", "等待卖家发货", "等待商家接单","待入住"),
	
	MERCHANT_ORDERS("MERCHANT_ORDERS", "商家已接单", true, "", "", "商家已接单,准备配送",""),
	/**
	 * 货已发出,请查收
	 */
	YFH("YFH", "货已发出,请查收", true, "", "货已发出,请查收", "配送中",""),
	/**
	 * 该订单已经被关闭
	 */
	YGB("YGB", "该订单已经被关闭", false, "该订单已经被关闭", "该订单已经被关闭", "已关闭","该订单已经关闭"),
	/**
	 * JYC
	 */
	JYC("JYC", "交易完成", true, "交易完成", "交易完成", "已完成","交易完成"),
	/**
	 * JYC
	 */
	YQX("YQX", "该订单已经被取消", false, "该订单已经被取消", "该订单已经被取消", "已取消","该订单已经被取消"),
	
	PAD_ORDER("PAD_ORDER", "点餐", false, "", "", "",""),
	PAD_ORDER_CONFIRM("PAD_ORDER_CONFIRM", "确认下单", false, "", "", "等待结算","");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	private final String o2oMessage;
	
	private final String b2cMessage;
	
	private final String orderMealMessage;
	
	private final String hotelMessage;


	/**
	 * 
	 */
	private final boolean isCanRefound;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private OrderStatusEnum(String code, String message, boolean isCanRefound, String o2oMessage,
							String b2cMessage, String orderMealMessage,String hotelMessage) {
		this.code = code;
		this.message = message;
		this.isCanRefound = isCanRefound;
		this.o2oMessage = o2oMessage;
		this.b2cMessage = b2cMessage;
		this.orderMealMessage = orderMealMessage;
		this.hotelMessage = hotelMessage;
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
	
	public String getO2oMessage() {
		return this.o2oMessage;
	}
	
	public String getB2cMessage() {
		return this.b2cMessage;
	}
	
	public boolean isCanRefound() {
		return this.isCanRefound;
	}
	
	public String getOrderMealMessage() {
		return orderMealMessage;
	}
	
	public String getHotelMessage() {
		return hotelMessage;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return OrderStatusEnum
	 */
	public static OrderStatusEnum getByCode(String code) {
		for (OrderStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<OrderStatusEnum>
	 */
	public static java.util.List<OrderStatusEnum> getAllEnum() {
		java.util.List<OrderStatusEnum> list = new java.util.ArrayList<OrderStatusEnum>(
			values().length);
		for (OrderStatusEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	public static java.util.List<OrderStatusEnum> getAllEnumWithOut(String withOutCode) {
		java.util.List<OrderStatusEnum> list = new java.util.ArrayList<OrderStatusEnum>(
			values().length);
		for (OrderStatusEnum _enum : values()) {
			if (withOutCode.contains(_enum.code()))
				continue;
			list.add(_enum);
		}
		return list;
	}
	
	public static java.util.List<OrderStatusEnum> getAllEnumIn(String withOutCode) {
		java.util.List<OrderStatusEnum> list = new java.util.ArrayList<OrderStatusEnum>(
			values().length);
		for (OrderStatusEnum _enum : values()) {
			if (!withOutCode.contains(_enum.code()))
				continue;
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
		for (OrderStatusEnum _enum : values()) {
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
		OrderStatusEnum _enum = getByCode(code);
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
	public static String getCode(OrderStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
