package com.yjf.esupplier.ws.lottery.enums;

/**
 * 抽奖次数限制类型
 * 
 * 
 * @author qch
 * 
 */
public enum LotteryTimesTypeEnum {
	
	EVERY_DAY_TIMES("EVERY_DAY_TIMES", "每天n次"),
	EXTRA_DRAW_TIME("EXTRA_DRAW_TIME", "额外抽奖次数"),
	TOTAL_TIMES("TOTAL_TIMES", "总共n次");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private LotteryTimesTypeEnum(String code, String message) {
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
	 * @return LotteryTimesTypeEnum
	 */
	public static LotteryTimesTypeEnum getByCode(String code) {
		for (LotteryTimesTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LotteryTimesTypeEnum>
	 */
	public static java.util.List<LotteryTimesTypeEnum> getAllEnum() {
		java.util.List<LotteryTimesTypeEnum> list = new java.util.ArrayList<LotteryTimesTypeEnum>(
			values().length);
		for (LotteryTimesTypeEnum _enum : values()) {
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
		for (LotteryTimesTypeEnum _enum : values()) {
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
		LotteryTimesTypeEnum _enum = getByCode(code);
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
	public static String getCode(LotteryTimesTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
