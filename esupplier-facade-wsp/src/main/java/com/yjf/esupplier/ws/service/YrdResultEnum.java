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
public enum YrdResultEnum {
	
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
	
	/** 余额不足 */
	NO_BALANCE("NO_BALANCE", "余额不足"),
	
	/** 快捷投资-投资已满 */
	INVEST_FULL("INVEST_FULL", "投资已满"),
	
	/** 快捷投资-投资已满 */
	TOO_EARLY("TOO_EARLY", "未到投资时间"),
	
	/** 快捷投资-投资已满 */
	TOO_MUCH("TOO_MUCH", "投资超限"),
	/** 未实名认证 */
	NO_REAL_NAME("NO_REAL_NAME", "未实名认证"),
	
	/** 密码错误 */
	PASSWORD_ERROR("PASSWORD_ERROR", "密码错误"),
	/** 用户冻结 */
	USER_DISABLE("USER_DISABLE", "用户冻结"),
	
	/** 用户机构用户最大数 */
	USER_MAX_LENGTH("USER_MAX_LENGTH", "用户机构用户最大数"),
	
	/** 功能为开通 */
	FUNCTION_NOT_OPEN("FUNCTION_NOT_OPEN", "功能未开通"),
	/** 用户已经存在 */
	USER_EXIST("USER_EXIST", "用户已经存在"),
	
	/** 执行成功 */
	EXECUTE_SUCCESS("EXECUTE_SUCCESS", "执行成功"),
	
	/** 执行失败 */
	EXECUTE_FAILURE("EXECUTE_FAILURE", "执行失败"),
	
	/** 执行失败 */
	EXECUTE_FAIL("EXECUTE_FAIL", "执行失败");
	
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
	private YrdResultEnum(String code, String message) {
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
	public static YrdResultEnum getByCode(String code) {
		for (YrdResultEnum _enum : values()) {
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
	public List<YrdResultEnum> getAllEnum() {
		List<YrdResultEnum> list = new ArrayList<YrdResultEnum>();
		for (YrdResultEnum _enum : values()) {
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
		for (YrdResultEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
