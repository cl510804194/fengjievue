package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 交易枚举
 * 
 * */
public enum IncomeOutcomeEnum {
	CHARGE("CHARGE","收费"),

	COLLECT("COLLECT","收款"),

	PAYMENT("PAYMENT","付款"),

	RECHARGE("RECHARGE","充值"),
	
	WITHDRAW("WITHDRAW","提现"),

	CONSUME("CONSUME","消费"),

	RECHARGE_BACK("RECHARGE_BACK","充退"),

	CANCEL("CANCEL","退货"),

	SHARE("SHARE","分润"),

	COLLECT_CHARGE("COLLECT_CHARGE","入金收费"),

	PAY_CHARGE("PAY_CHARGE","出金收费"),

	WITHDRAW_BACK("WITHDRAW_BACK","退票"),

	REVERSE("REVERSE","冲正");

	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>BooleanEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private IncomeOutcomeEnum(String code, String message) {
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
	 * 通过枚举<code>code</code>获得枚举message
	 *
	 * @param object
	 * @return String
	 */
	public static String getByCode(Object object) {
		for (IncomeOutcomeEnum _enum : values()) {
			if (_enum.getCode().equals(object)) {
				return _enum.getMessage();
			}
		}
		return "";
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<BooleanEnum>
	 */
	public List<IncomeOutcomeEnum> getAllEnum() {
		List<IncomeOutcomeEnum> list = new ArrayList<IncomeOutcomeEnum>();
		for (IncomeOutcomeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	
}
