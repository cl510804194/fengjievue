package com.yjf.esupplier.ws.userManage.enums;

public enum UserLevelEnum {
	
	GENERAL("GENERAL", 0, "普通", true),
	
	VIP("VIP", 1, "VIP", false),
	
	SILVER("SILVER", 2, "白银", false),
	
	GOLD("GOLD", 3, "黄金", false),
	
	PLATINUM("PLATINUM", 4, "白金", false),
	
	DIAMOND("DIAMOND", 5, "钻石", false);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/**
	 * 等级码
	 */
	private final int level;
	
	/**
	 * 是否启用
	 */
	private final boolean isEnable;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private UserLevelEnum(String code, int level, String message, boolean isEnable) {
		this.code = code;
		this.message = message;
		this.level = level;
		this.isEnable = isEnable;
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
	
	public int getLevel() {
		return this.level;
	}
	
	public boolean getIsEnable() {
		return isEnable;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return UserLevelEnum
	 */
	public static UserLevelEnum getByCode(String code) {
		for (UserLevelEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static UserLevelEnum getByLevel(int level) {
		for (UserLevelEnum _enum : values()) {
			if (_enum.level == level) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<UserLevelEnum>
	 */
	public static java.util.List<UserLevelEnum> getAllEnum() {
		java.util.List<UserLevelEnum> list = new java.util.ArrayList<UserLevelEnum>(values().length);
		for (UserLevelEnum _enum : values()) {
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
		for (UserLevelEnum _enum : values()) {
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
		UserLevelEnum _enum = getByCode(code);
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
	public static String getCode(UserLevelEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
