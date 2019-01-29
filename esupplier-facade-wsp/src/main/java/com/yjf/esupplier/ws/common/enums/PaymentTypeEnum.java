package com.yjf.esupplier.ws.common.enums;

public enum PaymentTypeEnum {
	BALANCE_PAYMENT("BALANCE_PAYMENT", "余额支付", false, false),
	POINT_PAYMENT("POINT_PAYMENT", "全积分支付", false, false),
	CASH_PAYMENT("CASH_PAYMENT", "现金支付", false, false),
	OFFLINE_BANK_CARD("OFFLINE_BANK_CARD", "银行卡（线下）", false, false),
	OFFLINE_GXT_CARD("OFFLINE_GXT_CARD", "真美美卡（线下）", false, false),
	SHORTCUT_PAYMENT("SHORTCUT_PAYMENT", "快捷支付", true, false),
	ALIPAY("ALIPAY", "支付宝", false, false),
	WECHATS_PAY("WECHATS_PAY", "微信", true, false),
	WECHATS_SANCODE("WECHATS_SANCODE", "微信扫码", true, false),
	WECHATS_SANCODE_APP("WECHATS_SANCODE_APP", "手机微信扫码", true, false),
	ZHONGJIN_PAYMENT("ZHONGJIN_PAYMENT", "中金支付", false, false),
	ONLINE_BANKING("ONLINE_BANKING", "网银支付", true, false),
	YI_SHOU_FU("YI_SHOU_FU", "易手富", true, false),
	YIJI_GATEWAY("YIJI_GATEWAY", "企业富通-网关", true, true),
	YIJI_CASHIER_PC("YIJI_CASHIER_PC", "企业富通-PC收银台", true, true),
	YIJI_CASHIER_MOBILE("YIJI_CASHIER_MOBILE", "企业富通-移动支付", true, true),
	YIJI_CASHIER_WXPAY("YIJI_CASHIER_WXPAY", "企业富通-微信支付", true, true),
	YIJI_CASHIER_POS("YIJI_CASHIER_POS", "企业富通-POS", true, true);
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	private final boolean yjfPay;
	
	/** 是否企富通 */
	private final boolean yjfQftPay;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private PaymentTypeEnum(String code, String message, boolean yjfPay, boolean yjfQftPay) {
		this.code = code;
		this.message = message;
		this.yjfPay = yjfPay;
		this.yjfQftPay = yjfQftPay;
	}
	
	public boolean isYjfPay() {
		return this.yjfPay;
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
	 * @return PaymentType
	 */
	public static PaymentTypeEnum getByCode(String code) {
		for (PaymentTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<PaymentType>
	 */
	public static java.util.List<PaymentTypeEnum> getAllEnum() {
		java.util.List<PaymentTypeEnum> list = new java.util.ArrayList<PaymentTypeEnum>(
			values().length);
		for (PaymentTypeEnum _enum : values()) {
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
		for (PaymentTypeEnum _enum : values()) {
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
		PaymentTypeEnum _enum = getByCode(code);
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
	public static String getCode(PaymentTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
	
	public boolean isYjfQftPay() {
		return yjfQftPay;
	}
}
