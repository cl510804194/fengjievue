package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

public enum SignedWay {

	//
	// NOSIGN("1",1,""), COUNTERSIGN("2",2,"柜台签约"), INSTEADOFSIGN("3",3,"代签"),
	// INTERSIGN(
	// "4",4,"网签");

	NOSIGN("1", 1, "支持"), COUNTERSIGN("0", 0, "不支持");

	/** 枚举值 */
	private final String code;

	/** 枚举描述 */
	private final String message;

	private final int value;

	/**
	 * 构造一个<code>MemberScal</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private SignedWay(String code, int value, String message) {
		this.code = code;
		this.message = message;
		this.value = value;
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

	public int getValue() {
		return value;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return MemberScal
	 */
	public static SignedWay getByCode(String code) {
		for (SignedWay _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<MemberScal>
	 */
	public List<SignedWay> getAllEnum() {
		List<SignedWay> list = new ArrayList<SignedWay>();
		for (SignedWay _enum : values()) {
			list.add(_enum);
		}
		return list;
	}

	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public static List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (SignedWay _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
