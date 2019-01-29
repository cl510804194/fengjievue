/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.integral.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename PointsTypeEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author lzb
 * 
 * @Email caigen@yiji.com
 * 
 * @History <li>Author: lzb</li> <li>Date: 2014-8-22</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum PointsTypeEnum {
	
	REGISTER("REGISTER", "注册送积分", true,false),
	SINGLE_CONSUME_PAY("SINGLE_CONSUME_PAY", "用户单笔消费支付成功", true,true),
	SINGLE_CONSUME_COMPLETE("SINGLE_CONSUME_COMPLETE", "用户单笔消费完成", true,true),
	LOGIN("LOGIN", "用户每天登陆送积分", true,false),
	ORDERCANCEL("ORDERCANCEL", "订单取消返还积分", true,true),
	EVALUATION("EVALUATION", "评价送积分", true,true),
	UPLOAD_AVATAR("UPLOAD_AVATAR", "上传头像", true,false),
	BINDING_MAILBOX("BINDING_MAILBOX", "绑定邮箱", true,false),
	
	AUTHENTICATION("AUTHENTICATION", "强实名积分", true,false),
	BANKCARD("BANKCARD", "绑定银行卡积分", true,false),
	ACCOUNT("ACCOUNT", "激活第三方账户积分", true,false),
	REFEREE("REFEREE", "推荐积分", true,true),
	CONSUMER_SEND("CONSUMER_SEND", "消费送积分", true,true),
	SOUDONG("SOUDONG", "手动定向积分", true,true),
	CHOUJIANG("CHOUJIANG", "抽奖积分", true,true),
	USE("USE", "消费积分", false,true),
	SIGN("SIGN", "签到积分", true,true),
	CLEAR("CLEAR", "积分清零", false,true),
	CUT("CUT", "手动扣除积分", false,true);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/**
	 * 是否增加积分
	 */
	private final boolean isAddIntegral;
	/**
	 * 是否获取多次(一天多次重复）
	 */
	private final boolean addCycle;
	
	/**
	 * 构造一个<code>BooleanEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private PointsTypeEnum(String code, String message, boolean isAddIntegral,boolean addCycle) {
		this.code = code;
		this.message = message;
		this.isAddIntegral = isAddIntegral;
		this.addCycle = addCycle;
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
	
	public boolean isAddIntegral() {
		return this.isAddIntegral;
	}

	public boolean isAddCycle() {
		return addCycle;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return BooleanEnum
	 */
	public static PointsTypeEnum getByCode(String code) {
		for (PointsTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<BooleanEnum>
	 */
	public static List<PointsTypeEnum> getAllEnum() {
		List<PointsTypeEnum> list = new ArrayList<PointsTypeEnum>();
		for (PointsTypeEnum _enum : values()) {
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
		for (PointsTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
