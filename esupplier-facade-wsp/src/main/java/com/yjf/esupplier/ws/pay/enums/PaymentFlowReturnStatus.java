package com.yjf.esupplier.ws.pay.enums;

public enum PaymentFlowReturnStatus {
	PAYMENT_FLOW_RETURNING("PAYMENT_FLOW_RETURNING", "退款申请中"),
	INIT("INIT", "初始化"),
	PAYMENT_FLOW_PARTLY_COMPLETED("PAYMENT_FLOW_PARTLY_COMPLETED", "部分退款完成"),
	PAYMENT_FLOW_RETURN_COMPLETED("PAYMENT_FLOW_RETURN_COMPLETED", "退款完成"),
	PAYMENT_FLOW_RETURN_PROCESSING("PAYMENT_FLOW_RETURN_PROCESSING", "退款处理中");
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private PaymentFlowReturnStatus(String code, String message) {
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
	 * @return PaymentFlowReturnStatus
	 */
	public static PaymentFlowReturnStatus getByCode(String code) {
		for (PaymentFlowReturnStatus _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<PaymentFlowReturnStatus>
	 */
	public static java.util.List<PaymentFlowReturnStatus> getAllEnum() {
		java.util.List<PaymentFlowReturnStatus> list = new java.util.ArrayList<PaymentFlowReturnStatus>(
			values().length);
		for (PaymentFlowReturnStatus _enum : values()) {
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
		for (PaymentFlowReturnStatus _enum : values()) {
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
		PaymentFlowReturnStatus _enum = getByCode(code);
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
	public static String getCode(PaymentFlowReturnStatus _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
