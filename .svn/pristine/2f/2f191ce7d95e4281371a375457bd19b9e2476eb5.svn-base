package com.yjf.esupplier.ws.enums;

public enum InvestmentDemandStatusEnum {
	/**
	 * CANCEL取消
	 */
	CANCEL("CANCEL", "取消"),
	/**
	 * INIT初始化
	 */
	INIT("INIT", "初始化"),
	/**
	 * ACCEPTED已接受
	 */
	ACCEPTED("ACCEPTED", "已接受"),
	/**
	 * INVEST 投资中
	 */
	INVEST("INVEST", "投资中"),
	
	/**
	 * INVEST_FULL 投资满额
	 */
	INVEST_FULL("INVEST_FULL", "投资满额"),
	
	/**
	 * INVEST_FINISHED 投资完成（审核）
	 */
	INVEST_FINISHED("INVEST_FINISHED", "投资完成"),
	
	INVEST_FAILD("INVEST_FAILD", "投资失败"),
	/**
	 * REPAY_FINISHED 还款完成
	 */
	REPAY_FINISHED("REPAY_FINISHED", "还款完成");
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private InvestmentDemandStatusEnum(String code, String message) {
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
	 * @return InvestmentDemandStatusEnum
	 */
	public static InvestmentDemandStatusEnum getByCode(String code) {
		for (InvestmentDemandStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<InvestmentDemandStatusEnum>
	 */
	public static java.util.List<InvestmentDemandStatusEnum> getAllEnum() {
		java.util.List<InvestmentDemandStatusEnum> list = new java.util.ArrayList<InvestmentDemandStatusEnum>(
			values().length);
		for (InvestmentDemandStatusEnum _enum : values()) {
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
		for (InvestmentDemandStatusEnum _enum : values()) {
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
		InvestmentDemandStatusEnum _enum = getByCode(code);
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
	public static String getCode(InvestmentDemandStatusEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
