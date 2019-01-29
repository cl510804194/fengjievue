package com.yjf.esupplier.ws.bill.enums;

public enum RefundProcessStatusEnum {
	REFUND_APPLY("REFUND_APPLY", "退款/退货申请","退款申请",true),
	RETURN_CHECK_PASS("RETURN_CHECK_PASS", "退货审核通过",false),
	REFUND_NO_PASS("REFUND_NO_PASS", "退款审核不通过","退款审核不通过",true),
	RETURNED_PURCHASEING("RETURNED_PURCHASEING", "退货已发出",false),
	REFUND_GOING("REFUND_GOING", "退款中","退款中",true),
	REFUND_SUCCESS("REFUND_SUCCESS", "退款成功","退款成功",true);

	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	private final String o2oMessage;
	
	private final boolean isO2o;

	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private RefundProcessStatusEnum(String code, String message,boolean isO2o) {
		this(code,message,"",isO2o);
	}
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private RefundProcessStatusEnum(String code, String message,String o2oMessage,boolean isO2o) {
		this.code = code;
		this.message = message;
		this.o2oMessage = o2oMessage;
		this.isO2o = isO2o;
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
		return o2oMessage;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return RefundProcessStatusEnum
	 */
	public static RefundProcessStatusEnum getByCode(String code) {
		for (RefundProcessStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
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
	public static java.util.List<RefundProcessStatusEnum> getAllEnum() {
		java.util.List<RefundProcessStatusEnum> list = new java.util.ArrayList<RefundProcessStatusEnum>(
			values().length);
		for (RefundProcessStatusEnum _enum : values()) {
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
		for (RefundProcessStatusEnum _enum : values()) {
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
		RefundProcessStatusEnum _enum = getByCode(code);
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
	public static String getCode(RefundProcessStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}

	public boolean isO2o() {
		return isO2o;
	}

}
