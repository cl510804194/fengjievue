/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename EstateTradeAttachmentTypeEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-4-10</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public enum CommonAttachmentTypeEnum {
	
	/** 评估报告 */
	ASSESSMENT_REPORT("ASSESSMENT_REPORT", "二手房", "评估报告"),
	
	/** 银行信息 */
	BANK_INFO("BANK_INFO", "二手房", "银行信息"),
	
	/** 贷后管理 */
	LOAN_MANAGEMENT("LOAN_MANAGEMENT", "P2P", "其他资料"),
	
	/** 其他附件 */
	OTHER("OTHER", "ALL", "其他附件"),
	
	/** 借款人信息附件 */
	LOANER_INFO("LOANER_INFO", "借款人信息", "借款人信息附件"),
	
	/** 项目信息附件 */
	LOAN_NOTE("LOAN_NOTE", "项目信息", "项目信息附件"),
	
	/** 抵押物信息附件 */
	GUARANTY_INFO("GUARANTY_INFO", "抵押物信息", "抵押物信息附件"),
	
	/** 订单退款信息 */
	ORDER_REFUND_INFO("ORDER_REFUND_INFO", "订单退款", "订单退款附件");
	
	/** 枚举值 */
	private final String code;
	
	/** 行业类型 */
	private final String industryType;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * CommonAttachmentTypeEnum
	 * @param code 编码
	 * @param industryType 行业类型
	 * @param message 描述
	 */
	private CommonAttachmentTypeEnum(String code, String industryType, String message) {
		this.code = code;
		this.industryType = industryType;
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
	
	public String getIndustryType() {
		return this.industryType;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return EstateTradeAttachmentTypeEnum
	 */
	public static CommonAttachmentTypeEnum getByCode(String code) {
		for (CommonAttachmentTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	public List<CommonAttachmentTypeEnum> getAllEnum() {
		List<CommonAttachmentTypeEnum> list = new ArrayList<CommonAttachmentTypeEnum>();
		for (CommonAttachmentTypeEnum _enum : values()) {
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
		for (CommonAttachmentTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
