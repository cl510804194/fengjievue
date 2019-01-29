package com.yjf.esupplier.ws.bill.enums;

public enum RefundPayVmStatusEnum {
	/*不需要发货，仅仅页面显示*/
	REFUND_APPLY("REFUND_APPLY", "退款申请"),
	RETURN_CHECK_PASS("RETURN_CHECK_PASS", "退货审核通过"),
	REFUND_NO_PASS("REFUND_NO_PASS", "退款审核不通过"),
	RETURNED_PURCHASEING("RETURNED_PURCHASEING", "退货已发出"),
	REFUND_GOING("REFUND_GOING", "退款中"),
	REFUND_SUCCESS("REFUND_SUCCESS", "退款成功");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private RefundPayVmStatusEnum(String code, String message) {
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
	 * @return RefundProcessStatusEnum
	 */
	public static RefundPayVmStatusEnum getByCode(String code) {
		for (RefundPayVmStatusEnum _enum : values()) {
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
	public static java.util.List<RefundPayVmStatusEnum> getAllEnum() {
		java.util.List<RefundPayVmStatusEnum> list = new java.util.ArrayList<RefundPayVmStatusEnum>(
			values().length);
		for (RefundPayVmStatusEnum _enum : values()) {
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
		for (RefundPayVmStatusEnum _enum : values()) {
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
		RefundPayVmStatusEnum _enum = getByCode(code);
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
	public static String getCode(RefundPayVmStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
