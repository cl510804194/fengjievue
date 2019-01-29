/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename SettleResultEnum.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author qichunhai
 *
 * @Email qchunhai@yiji.com
 *       
 * @History
 *<li>Author: qichunhai</li>
 *<li>Date: 2013-2-25</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum SettleResultEnum {
	
	//====================共同==========================
	/** 未知异常 */
	UN_KNOWN_EXCEPTION("UN_KNOWN_EXCEPTION", "未知异常"),

	/** 数据库异常 **/
	DB_EXCEPTION("DB_EXCEPTION", "数据库异常"),

	/** 系统异常 */
	SYSTEM_EXCEPTION("SYSTEM_EXCEPTION", "系统异常"),

	/** 执行成功 */
	EXECUTE_SUCCESS("EXECUTE_SUCCESS", "执行成功"),

	/** 参数不合法 */
	ILLEGAL_ARGUMENTS("ILLEGAL_ARGUMENTS", "参数不合法"),

	/** 数据库中的数据逻辑错误 */
	DATABASE_DATE_ERROR("DATABASE_DATE_ERROR", "数据库中的数据逻辑错误"),

	/** 当前条件查询不到数据 */
	DATABASE_DATE_NULL("DATABASE_DATE_NULL", "当前条件查询不到数据"),

	/**校验失败*/
	CHECK_FAIL("CHECK_FAIL", "校验失败"),

	/** 清算处理中 */
	SETTLE_PROCESSING("SETTLE_PROCESSING", "清算处理中"),
	//====================共同==========================
	
	//====================充值==========================
	/** 充值流水号重复 **/
	DEPOSITNO_REPEAT("DEPOSITNO_REPEAT", "充值流水号重复"),

	/** 调用渠道路由出错 **/
	CALL_CHANNELROUTE_ERROR("CALL_CHANNELROUTE_ERROR", "调用渠道路由出错"),

	/** 路由失败 **/
	ROUTE_FAIL("ROUTE_FAIL", "路由失败"),

	/** 没有可用的渠道 **/
	NO_USED_CHANNEL("NO_USED_CHANNEL", "没有可用的渠道"),

	/** 调用网关出错 **/
	CALL_GATEWAY_ERROR("CALL_GATEWAY_ERROR", "调用网关出错"),

	/** 调用网关异常 **/
	CALL_GATEWAY_EXCEPTION("CALL_GATEWAY_ERROR", "调用网关异常"),

	/** 网关接收失败 **/
	GATEWAY_ACCEPT_FAIL("GATEWAY_ACCEPT_FAIL", "网关接收失败"),

	/** 交易已经成功后的异常 */
	EXCEPTION_AFTER_SUCCESS("EXCEPTION_AFTER_SUCCESS", "交易已经成功后的异常"),

	/** 充值成功金额大于充值金额 **/
	DEPOSITSUCAMOUNT_BIGTHAN_DEPOSITAMOUNT("DEPOSITSUCAMOUNT_BIGTHAN_DEPOSITAMOUNT", "充值成功金额大于充值金额"),

	/** 充值流水号不存在 **/
	DEPOSITNO_NOT_EXIST("DEPOSITNO_NOT_EXIST", "充值流水号不存在"),

	/** 充值状态已经确定过 **/
	DEPOSITSTATUS_CONFIRMED("DEPOSITSTATUS_CONFIRMED", "充值状态已经确定过"),

	/** 充值状态不正常,比如从IT状态到BS状态 **/
	DEPOSITSTATUS_ABNORMAL("DEPOSITSTATUS_ABNORMAL", "充值状态不正常"),

	/** 非法的充值状态 **/
	ILLEGAL_DEPOSITSTATUS("ILLEGAL_DEPOSITSTATUS", "非法的充值状态"),

	/** 银行代扣失败 **/
	BANK_DEDUCT_FAIL("BANK_DEDUCT_FAIL", "银行代扣失败"),
	//====================充值==========================
	/** 没有可用的银行联行号 **/
	NO_USED_BANK_CNAPS("NO_USED_BANK_CNAPS", " 没有可用的银行联行号"),
	//====================提现==========================
	/**提现清算出现异常**/
	WITHDRAW_SETTLE_ERROR("WITHDRAW_SETTLE_ERROR", "提现清算出现异常"),
	/** 提现流水的状态错误 **/
	WITHDRAW_STATUS_ERROR("WITHDRAW_STATUS_ERROR", "提现流水的状态错误"),
	/** 渠道路由失败 **/
	CHANNEL_ROUTE_FAIL("CHANNEL_ROUTE_FAIL", "渠道路由失败"),

	/** 支付核心失败 **/
	PAYCORE_FAIL("CHANNEL_ROUTE_FAIL", "支付核心失败"),
	/** 提现流水号重复 **/
	WITHDRAW_REPEAT("WITHDRAW_REPEAT", "提现流水号重复"),

	WITHDRAW_NO_EXIST("WITHDRAW_NO_EXIST", "提现流水号不存在"),

	WITHDRAW_NO_MODIFY("WITHDRAW_NO_MODIFY", "批次号已存在，无法编辑"),

	WITHDRAW_BATCH_EXIST("WITHDRAW_BATCH_EXIST", "当前流水的批次号已存在，无法插入"),

	WITHDRAW_COMPARISON_FILE_NODIFF("WITHDRAW_COMPARISON_FILE_NODIFF", "会计与审核员审核后的提现文件，无差异"),

	WITHDRAW_COMPARISON_FILE_DIFF("WITHDRAW_COMPARISON_FILE_DIFF", "会计与审核员审核后的提现文件，有差异"),

	WITHDRAW_AUTID_NO_PASS("WITHDRAW_AUTID_NO_PASS", "当前批次审核未通过"),

	WITHDRAW_AUTID_NO_BEGIN("WITHDRAW_AUTID_NO_BEGIN", "当前批次审核未开始审查"),

	WITHDRAW_FILE_ISNULL("WITHDRAW_FILE_ISNULL", "文件路径为空"),
	//====================提现==========================
	
	//====================结汇==========================
	/**  结汇流水号重复 **/
	EXCHANGENO_REPEAT("EXCHANGENO_REPEAT", "结汇流水号重复"),

	/**  调用易结汇失败 **/
	CALL_YJH_FAIL("CALL_YJH_FAIL", "调用易结汇失败"),

	/** 结汇流水号不存在 **/
	EXCHANGENO_NOT_EXIST("EXCHANGENO_NOT_EXIST", "充值流水号不存在"),
	//====================结汇==========================
	//====================冲退==============================
	/** 请求用户ID与支付流水用户ID不一致**/
	DEPOSIT_BACK_USER_DISACCORD("DEPOSIT_BACK_USER_DISACCORD", "请求用户ID与支付流水用户ID不一致"),
	/** 查询清算核心渠道API出错 **/
	DEPOSIT_BACK_SETTLE_API_QUERY_ERROR("DEPOSIT_BACK_SETTLE_API_QUERY_ERROR", "查询清算核心渠道API出错"),
	/** 流水号重复 **/
	DEPOSIT_BACK_REPEAT("DEPOSIT_BACK_REPEAT", "流水号重复");
	//====================冲退==============================
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>DeductResultEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private SettleResultEnum(String code, String message) {
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
	 * @return DeductResultEnum
	 */
	public static SettleResultEnum getByCode(String code) {
		for (SettleResultEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DeductResultEnum>
	 */
	public List<SettleResultEnum> getAllEnum() {
		List<SettleResultEnum> list = new ArrayList<SettleResultEnum>();
		for (SettleResultEnum _enum : values()) {
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
		for (SettleResultEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
