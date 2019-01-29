package com.yjf.esupplier.integration.openapi.enums;

public enum OccupationEnum {
	J("J", "计算机/互联网/通信/电子"),
	S("S", "销售/客服/技术支持"),
	K("K", "会计/金融/银行/保险"),
	C("C", "生产/运营/采购/物流"),
	W("W", "生物/制药/医疗/护理"),
	G("G", "广告/市场/媒体/艺术"),
	R("R", "人事/行政/高级管理"),
	X("X", "咨询/法律/教育/科研"),
	F("F", "服务业"),
	Y("Y", "公务员/翻译/其他"),
	E("E", "职员");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private OccupationEnum(String code, String message) {
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
	 * @return OccupationEnum
	 */
	public static OccupationEnum getByCode(String code) {
		for (OccupationEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<OccupationEnum>
	 */
	public static java.util.List<OccupationEnum> getAllEnum() {
		java.util.List<OccupationEnum> list = new java.util.ArrayList<OccupationEnum>(
			values().length);
		for (OccupationEnum _enum : values()) {
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
		for (OccupationEnum _enum : values()) {
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
		OccupationEnum _enum = getByCode(code);
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
	public static String getCode(OccupationEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
