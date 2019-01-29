package com.yjf.esupplier.ws.bill.enums;

public enum OrderFlowStatus {
	/**
	 * 等待买家付款
	 */
	WAIT_BUYER_PAY("WAIT_BUYER_PAY", "等待买家付款", "等待买家付款", "等待买家付款"),
	/**
	 * 订单关闭
	 */
	ORDER_COLSE("ORDER_COLSE", "订单关闭", "订单关闭", "订单关闭"),
	/**
	 * 等待卖家发货
	 */
	WAIT_SELLER_SHIP("WAIT_SELLER_SHIP", "买家已付款", "等待线下消费", "等待卖家发货"),
	/**
	 * 货已发出,请查收
	 */
	HAVE_BEEN_ISSUED("HAVE_BEEN_ISSUED", "货已发出,请查收", "", "货已发出,请查收"),
	/**
	 * 确认收货
	 */
	CONFIRMATION_OF_RECEIPT("CONFIRMATION_OF_RECEIPT", "交易完成", "线下消费完成,等待买家评价", "确认收货,等待买家评价"),
	/**
	 * 评价
	 */
	EVALUATION("EVALUATION", "等待卖家评价", "等待卖家评价", "等待卖家评价"),
	
	EVALUATION_BY_SELLER("EVALUATION_BY_SELLER", "卖家评价完成", "卖家评价完成", "卖家评价完成"),
	/**
	 * 追加评价
	 */
	ADDITIONAL_EVALUATION("ADDITIONAL_EVALUATION", "追加评价完成", "追加评价完成", "追加评价完成");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	private final String o2oMessage;
	
	private final String b2cMessage;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private OrderFlowStatus(String code, String message, String o2oMessage, String b2cMessage) {
		this.code = code;
		this.message = message;
		
		this.o2oMessage = o2oMessage;
		this.b2cMessage = b2cMessage;
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
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return OrderFlowStatus
	 */
	public static OrderFlowStatus getByCode(String code) {
		for (OrderFlowStatus _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<OrderFlowStatus>
	 */
	public static java.util.List<OrderFlowStatus> getAllEnum() {
		java.util.List<OrderFlowStatus> list = new java.util.ArrayList<OrderFlowStatus>(
			values().length);
		for (OrderFlowStatus _enum : values()) {
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
		for (OrderFlowStatus _enum : values()) {
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
		OrderFlowStatus _enum = getByCode(code);
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
	public static String getCode(OrderFlowStatus _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
