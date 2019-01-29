/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

import com.yjf.common.lang.util.StringUtil;

/**
 * 
 * @Filename EstateTableSeqNameEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author peigen
 * 
 * @Email peigen@yiji.com
 * 
 * @History <li>Author: peigen</li> <li>Date: 2013-2-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum YrdOutBizNoEnum {
	
	/** 代扣流水SEQ */
	WITHHOLDING_SEQ("WITHHOLDING_SEQ", "WITHHOLDING_SEQ", "001"),
	/** 冻结 */
	WITHDRAW_SEQ("WITHDRAW_SEQ", "WITHDRAW_SEQ", "002"),
	/** 冻结 */
	FREZZ_SEQ("FREZZ_SEQ", "FREZZ_SEQ", "003"),
	/** 解冻冻结 */
	UNFREZZ_SEQ("UNFREZZ_SEQ", "UNFREZZ_SEQ", "004"),
	
	/** 转账 */
	TRANSFER_SEQ("TRANSFER_SEQ", "TRANSFER_SEQ", "005");
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	private final String bizCode;
	
	/**
	 * 构造一个<code>TradeTableSeqNameEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private YrdOutBizNoEnum(String code, String message, String bizCode) {
		this.code = code;
		this.message = message;
		this.bizCode = bizCode;
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
	
	public String getBizCode() {
		return bizCode;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return TradeTableSeqNameEnum
	 */
	public static YrdOutBizNoEnum getByCode(String code) {
		for (YrdOutBizNoEnum _enum : values()) {
			if (StringUtil.equals(_enum.getCode(), code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<TradeTableSeqNameEnum>
	 */
	public List<YrdOutBizNoEnum> getAllEnum() {
		List<YrdOutBizNoEnum> list = new ArrayList<YrdOutBizNoEnum>();
		for (YrdOutBizNoEnum _enum : values()) {
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
		for (YrdOutBizNoEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
