/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Filename YrdResultEnum.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author qichunhai
 *
 * @Email qchunhai@yiji.com
 *
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-3</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public enum EsupplierResultEnum {

	/** 未知异常 */
	UN_KNOWN_EXCEPTION("UN_KNOWN_EXCEPTION", "未知异常"),
	/** 请求参数不完整 */
	INCOMPLETE_REQ_PARAM("INCOMPLETE_REQ_PARAM", "请求参数不完整"),
	/** 数据库异常 */
	DATABASE_EXCEPTION("DATABASE_EXCEPTION", "数据库异常"),
	/** 没有数据 */
	HAVE_NOT_DATA("HAVE_NOT_DATA", "没有数据"),

	/** 该用户对该数据无访问权限 */
	NO_ACCESS("NO_ACCESS", "该用户对该数据无访问权限"),
	/** 执行OPENAPI失败 */
	OPENAPI_ACCESS_FAILURE("OPENAPI_ACCESS_FAILURE", "执行OPENAPI失败"),
	/** OPENAPI重复回执 */
	OPENAPI_REPEAT_NOTIFY("OPENAPI_ACCESS_FAILURE", "OPENAPI重复回执"),
	/** 数据处理状态不对或已经处理完成 */
	DO_ACTION_STATUS_ERROR("DO_ACTION_STATUS_ERROR", "数据处理状态不对或已经处理完成"),

	/** 签名不正确 */
	ILLEGAL_SIGN("ILLEGAL_SIGN", "签名不正确"),

	/** 冻结异常 */
	FREEZE_ERROR("FREEZE_ERROR", "冻结异常"),

	/** 付款流水号 */
	NOPAY_ERROR("NOPAY_ERROR", "付款流水号异常"),

	/** 余额不足 */
	NO_BALANCE("NO_BALANCE", "余额不足"),

	/** 资金账户未开通 */

	FUNDING_ACCOUNT_NO_OPEN("FUNDING_ACCOUNT_NO_OPEN", "资金账户未开通"),

	/** 快捷投资-投资已满 */
	INVEST_FULL("INVEST_FULL", "投资已满"),

	/** 快捷投资-投资已满 */
	TOO_EARLY("TOO_EARLY", "未到投资时间"),

	/** 贷款超限制 */
	TOO_MUCH("TOO_MUCH", "贷款超限制"),
	/** 未实名认证 */
	NO_REAL_NAME("NO_REAL_NAME", "未实名认证"),

	/** 密码错误 */
	PASSWORD_ERROR("PASSWORD_ERROR", "密码错误"),
	/** 用户冻结 */
	USER_DISABLE("USER_DISABLE", "用户冻结"),
	/** 用户锁定 */
	USER_LOCKED("USER_LOCKED", "用户锁定"),

	/** 功能为开通 */
	FUNCTION_NOT_OPEN("FUNCTION_NOT_OPEN", "功能未开通"),

	/** 执行成功 */
	EXECUTE_SUCCESS("EXECUTE_SUCCESS", "执行成功"),

	/** 运行脚本出错 */
	RUN_JAVCSCRIPT_ERROR("RUN_JAVCSCRIPT_ERROR", "运行脚本出错"),
	/** 用户已经存在 */
	USER_EXIST("USER_EXIST", "用户已经存在"),
	/** 不存在该用户 */
	USER_NOEXIST("USER_EXIST", "不存在该用户"),
	/** 已开通供应商 */
	HAVE_SUPPLIER("HAVE_SUPPLIER", "已开通供应商"),

	/** 交易状态未完成 */
	TRADE_STATUS_NO_FINISHED("TRADE_STATUS_NO_FINISHED", "交易状态未完成"),

	INVENTORY_SHORTAGE("INVENTORY_SHORTAGE", "库存不足"),

	WRITE_IMAGE_ERROR("WRITE_IMAGE_ERROR", "写入图片失败"),

	REFUND_RULE_ERROR("REFUND_RULE_ERROR", "不满足退款规则"),

	REFUND_AMOUNT_OVERRUN("REFUND_AMOUNT_OVERRUN", "退款金额超限"),

	WRONG_RULE_ERROR("WRONG_RULE_ERROR", "不满足规则"),
	/** 执行失败 */
	EXECUTE_FAILURE("EXECUTE_FAILURE", "执行失败"),
	/** 执行失败 */
	SYNC_FAILURE("SYNC_FAILURE", "接口同步失败"),
	/** 执行失败 */
	QUERY_FAILURE("QUERY_FAILURE", "查询数据失败");

	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>EstateResultEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private EsupplierResultEnum(String code, String message) {
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
	 * @return EstateResultEnum
	 */
	public static EsupplierResultEnum getByCode(String code) {
		for (EsupplierResultEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<EstateResultEnum>
	 */
	public List<EsupplierResultEnum> getAllEnum() {
		List<EsupplierResultEnum> list = new ArrayList<EsupplierResultEnum>();
		for (EsupplierResultEnum _enum : values()) {
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
		for (EsupplierResultEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
