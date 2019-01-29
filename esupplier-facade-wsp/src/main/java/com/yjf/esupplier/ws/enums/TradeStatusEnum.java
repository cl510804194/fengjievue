/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename TradeStatusEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-6</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum TradeStatusEnum {
	

	/** 通过数据修改删除的标的 */
	DISTROY("DISTROY", -1, "手工删除", "已手工删除", "已手工删除", "已删除"),
	/** 待审核 */
	CHECK_PENDING("CHECK_PENDING", 0, "待审核", "合约创建", "", ""),
	
	/** 募集中-待成立 */
	TRADING("TRADING", 1, "募集中-待成立", "合约签发", "待成立", "待成立"),
	
	/** 已成立 */
	REPAYING("REPAYING", 2, " 已成立", "合约履行中", "未到期", "已成立"),
	
	/** 交易完成 */
	REPAY_FINISH("REPAY_FINISH", 3, "交易完成", "合约完毕", "正常收款", "已正常还款"),
	
	/** 交易失败 */
	FAILED("FAILED", 4, "交易失败", "合约失效", "未成立", "未成立"),
	
	/** 还款失败 */
	REPAYING_FAILD("REPAYING_FAILD", 5, "交易失败", "合约违约", "违约处理中", "违约处理中"),
	
	/** 担保公司审核中 */
	GUARANTEE_AUDITING("GUARANTEE_AUDITING", 6, "承诺机构审核中", "承诺机构审核中", "承诺机构审核中", "承诺机构审核中"),
	
	/** 违约代偿完成 */
	COMPENSATORY_REPAY_FINISH("COMPENSATORY_REPAY_FINISH", 7, "违约代偿完成", "违约代偿完成", "违约代偿完成",
								"违约代偿完成"),
	
	/** 待还款 */
	DOREPAY("DOREPAY", 8, "待还款", "待还款", "超期收款", "逾期");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 存储值 */
	private final int value;
	/** 担保状态 */
	private final String guaranteeStatus;
	/** 投资人状态 */
	private final String investorStatus;
	/** 融资状态 */
	private final String loanderStatus;
	
	/**
	 * 构造一个<code>TradeStatusEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private TradeStatusEnum(String code, int value, String message, String guaranteeStatus,
							String investorStatus, String loanderStatus) {
		this.code = code;
		this.message = message;
		this.value = value;
		this.guaranteeStatus = guaranteeStatus;
		this.investorStatus = investorStatus;
		this.loanderStatus = loanderStatus;
	}
	
	public String getInvestorStatus() {
		return this.investorStatus;
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
	
	public String getGuaranteeStatus() {
		return this.guaranteeStatus;
	}
	
	public String getLoanderStatus() {
		return this.loanderStatus;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return TradeStatusEnum
	 */
	public static TradeStatusEnum getByCode(String code) {
		for (TradeStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public static TradeStatusEnum getByValue(int value) {
		for (TradeStatusEnum _enum : values()) {
			if (_enum.value == value) {
				return _enum;
			}
		}
		return null;
	}
	
	public int getValue() {
		return this.value;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<TradeStatusEnum>
	 */
	public List<TradeStatusEnum> getAllEnum() {
		List<TradeStatusEnum> list = new ArrayList<TradeStatusEnum>();
		for (TradeStatusEnum _enum : values()) {
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
		for (TradeStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
