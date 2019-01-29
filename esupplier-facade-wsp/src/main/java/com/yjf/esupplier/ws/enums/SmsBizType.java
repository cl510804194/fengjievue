/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename SmsBizType.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-9</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum SmsBizType {
	
	REGISTER("register", "注册", 10, 5, 50, "bornsoft_fjly_zc注册验证码"),
	
	LOGIN("login", "快捷登录", 10, 5, 200, "bornsoft_fjly_sjkjdl手机快捷登录的验证码"),
	
	ACTIVATE("activate", "激活", 10, 5, 200, "bornsoft_fjly_jh激活验证码"),
	
	ForgetLoginPassWord("ForgetLoginPassWord", "找回登录密码", 10, 3, 200, "bornsoft_fjly_zhmm找回密码的验证码"),
	
	ForgetPayPassWord("ForgetPayPassWord", "找回支付密码", 5, 3),
	
	PAYPASS("payPass", "修改支付密码", 5, 3),
	
	ADDCELLPHONE("addcellphone", "申请绑定手机号码", 10, 5, 200, "bornsoft_fjly_bdsjhm绑定手机号码的验证码"),
	
	CELLPHONE("cellphone", "修改绑定手机号码", 10, 5),
	
	OLDCELLPHONE("oldCellphone", "修改手机号码，旧手机", 10, 5, 200, "bornsoft_fjly_xgjsjhm修改旧手机号码"),
	
	NEWCELLPHONE("newCellphone", "修改手机号码，新手机", 10, 5, 200, "bornsoft_fjly_xgxsjhm修改新手机号码"),

	ORDERPAYCODE("orderPayCode", "商品消费码", 10, 5, 200, "bornsoft_zmm_spxfm商品消费码"),
		
	PERSONAL("personal", "修改个人信息", 10, 5),
	
	ADDOPERATOR("addOperator", "添加成员", 50, 10),
	
	EDITOPERATOR("editOperator", "修改成员", 50, 10),
	
	AUTHORIZED("authorized", "权限分配", 50, 10),
	
	OPERATORFIRSTTIME("operatorFirstTime", "操作员首次登录", 10, 10),
	
	WITHDRAW("withdraw", "提现", 10, 5),
	
	TRANSFER("transfer", "转账", 20, 3),
	
	INVEST("invest", "投资", 20, 5),
	
	TRANSFERTOCARD("transferToCard", "转账到卡", 20, 3),
	
	BATCHTRANSFERTOCARD("batchTransferToCard", "批量转账到卡", 10, 3),
	
	WITHDRAWVERIFY("withdrawVerify", "提现审核", 10, 3),
	
	INNERVERIFYTRANSFER("innerVerifyTransfer", "站内转账审核", 10, 3),
	
	CARDVERIFYTRANSFER("cardVerifyTransfer", "转账到卡审核", 10, 3),
	
	BATCHVERIFYTRANSFER("batchVerifyTransfer", "批量审核", 10, 3),
	
	DEDUCT("deduct", "申请代扣", 100, 5),
	
	SIGN("sign", "签约", 10, 5),
	
	SALARY("salary", "发工资", 10, 5),
	
	DEPOSIT("deposit", "充值", 100, 5),
	
	INVESTMENT("investment", "投资", 100, 5),
	
	REPAYMENT("repayment", "还款", 100, 5),
	
	LOAN_APPLAY("loanApply", "借款申请", 10, 3);
	
	private final String code;
	private final String message;
	private final int daySendCount;
	private final int errorCount;
	private final int maxErrorCount;
	private final String templateName;
	
	private SmsBizType(String code, String message, int daySendCount, int errorCount,
						int maxErrorCount) {
		this.code = code;
		this.message = message;
		this.daySendCount = daySendCount;
		this.errorCount = errorCount;
		this.maxErrorCount = maxErrorCount;
		this.templateName = "";
	}
	
	private SmsBizType(String code, String message, int daySendCount, int errorCount,
						int maxErrorCount, String templateName) {
		this.code = code;
		this.message = message;
		this.daySendCount = daySendCount;
		this.errorCount = errorCount;
		this.maxErrorCount = maxErrorCount;
		this.templateName = templateName;
	}
	
	private SmsBizType(String code, String message, int daySendCount, int errorCount) {
		this.code = code;
		this.message = message;
		this.daySendCount = daySendCount;
		this.errorCount = errorCount;
		this.maxErrorCount = 200;
		this.templateName = "";
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getDaySendCount() {
		return daySendCount;
	}
	
	public int getErrorCount() {
		return this.errorCount;
	}
	
	public int getMaxErrorCount() {
		return this.maxErrorCount;
	}
	
	public String getTemplateName() {
		return this.templateName;
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
	 * @return LogResultEnum
	 */
	public static SmsBizType getByCode(String code) {
		for (SmsBizType _enum : values()) {
			if (_enum.getCode().equalsIgnoreCase(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LogResultEnum>
	 */
	public List<SmsBizType> getAllEnum() {
		List<SmsBizType> list = new ArrayList<SmsBizType>();
		for (SmsBizType _enum : values()) {
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
		for (SmsBizType _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
}