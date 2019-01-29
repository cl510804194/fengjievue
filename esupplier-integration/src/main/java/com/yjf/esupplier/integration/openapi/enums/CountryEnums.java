package com.yjf.esupplier.integration.openapi.enums;

public enum CountryEnums {
	
	China("China", "中国大陆"),
	
	HongKong("HongKong", "中国香港"),
	
	Taiwan("Taiwan", "中国台湾"),
	
	Macau("Macau", "中国澳门"),
	
	Australia("Australia", "澳大利亚"),
	Canada("Canada", "加拿大"),
	France("France", "法国"),
	Germany("Germany", "德国"),
	Indonesia("Indonesia", "印度尼西亚"),
	Italy("Italy", "意大利"),
	Japan("Japan", "日本"),
	SouthKorea("SouthKorea", "韩国"),
	Malaysia("Malaysia", "马来西亚"),
	NewZealand("NewZealand", "新西兰"),
	Netherlands("Netherlands", "荷兰"),
	
	Philippines("Philippines", "菲律宾"),
	Russia("Russia", "俄罗斯"),
	Singapore("Singapore", "新加坡"),
	Sweden("Sweden", "瑞典"),
	Thailand("Thailand", "泰国"),
	Britain("Britain", "英国"),
	Ukraine("Ukraine", "乌克兰"),
	UnitedStates("UnitedStates", "美国"),
	Vietnam("Vietnam", "越南"),
	Other("Other", "其他");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private CountryEnums(String code, String message) {
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
	 * @return CountryEnums
	 */
	public static CountryEnums getByCode(String code) {
		for (CountryEnums _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<CountryEnums>
	 */
	public static java.util.List<CountryEnums> getAllEnum() {
		java.util.List<CountryEnums> list = new java.util.ArrayList<CountryEnums>(values().length);
		for (CountryEnums _enum : values()) {
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
		for (CountryEnums _enum : values()) {
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
		CountryEnums _enum = getByCode(code);
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
	public static String getCode(CountryEnums _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
