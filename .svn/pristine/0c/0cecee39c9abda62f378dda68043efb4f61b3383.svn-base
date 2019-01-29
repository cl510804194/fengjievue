package com.yjf.esupplier.ws.userManage.enums;

public enum AccountTypeEnum {
	DEPOSIT("DEPOSIT", "充值", AccountDirectionEnum.DEBIT),
	WITHDRAW("WITHDRAW", "提现", AccountDirectionEnum.CREDIT),
	REFUND("REFUND", "退款", AccountDirectionEnum.DEBIT),
	REFUND_OUT("REFUND_OUT", "退款", AccountDirectionEnum.CREDIT),
	PAY("PAY", "交易支付", AccountDirectionEnum.CREDIT),
	RECEIVABLES("RECEIVABLES", "交易收款", AccountDirectionEnum.DEBIT),
	TRANSFERS("TRANSFERS", "转账", AccountDirectionEnum.CREDIT),
	TRANSFER_PAYMENT("TRANSFER_PAYMENT", "转账收款", AccountDirectionEnum.DEBIT),
	COMMISSION_INCOME("COMMISSION_INCOME", "佣金收入", AccountDirectionEnum.DEBIT),
	COMMISSION_EXPENSE("COMMISSION_EXPENSE", "佣金支出", AccountDirectionEnum.CREDIT),
	FREEZE("FREEZE", "冻结", AccountDirectionEnum.NONE),
	UNFREEZE("UNFREEZE", "解冻", AccountDirectionEnum.NONE);
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 枚举描述 */
	private final AccountDirectionEnum direction;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private AccountTypeEnum(String code, String message, AccountDirectionEnum direction) {
		this.code = code;
		this.message = message;
		this.direction = direction;
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
	
	public AccountDirectionEnum getDirection() {
		return this.direction;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return AccountTypeEnum
	 */
	public static AccountTypeEnum getByCode(String code) {
		for (AccountTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<AccountTypeEnum>
	 */
	public static java.util.List<AccountTypeEnum> getAllEnum() {
		java.util.List<AccountTypeEnum> list = new java.util.ArrayList<AccountTypeEnum>(
			values().length);
		for (AccountTypeEnum _enum : values()) {
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
		for (AccountTypeEnum _enum : values()) {
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
		AccountTypeEnum _enum = getByCode(code);
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
	public static String getCode(AccountTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
