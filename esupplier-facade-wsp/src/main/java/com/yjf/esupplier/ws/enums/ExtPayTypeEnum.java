/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author zeyong
 * 
 */
public enum ExtPayTypeEnum {
	
	DEPOSIT("DEPOSIT", "充值"),
	
	WITHDRAW("WITHDRAW", "提现"),
	
	DEPOSIT_WITHDRAW("DEPOSIT_WITHDRAW", "充值提现"),
	
	DEDUCT("DEDUCT", "代扣"),
	
	EBANK("EBANK", "网银"),
	
	RECHARGE("RECHARGE", "充值"),
	
	/** 投标 */
	INVEST("INVEST", "投标"),
	
	/** 回款 */
	REPAY("REPAY", "回款"),
	
	/** 分润 */
	DIVISION("DIVISION", "分润"),
	
	/** 手续费 */
	CHARGEFEE("CHARGEFEE", "手续费"),
	
	/** 其他 */
	OTHER("OTHER", "其他"),
	
	;
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>PayTypeEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private ExtPayTypeEnum(String code, String message) {
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
	 * @return PayTypeEnum
	 */
	public static ExtPayTypeEnum getByCode(String code) {
		for (ExtPayTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<PayTypeEnum>
	 */
	public List<ExtPayTypeEnum> getAllEnum() {
		List<ExtPayTypeEnum> list = new ArrayList<ExtPayTypeEnum>();
		for (ExtPayTypeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (ExtPayTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
