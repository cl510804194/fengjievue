/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename YrdAuthTypeEnum.java
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
 *<li>Date: 2014-4-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum YrdAuthTypeEnum {
	
	//'DEPLOYLVONE','DEPLOYLVTWO','MAKELOANLVONE','MAKELOANLVTWO','OTHERS','DEMANDDEPLOY','DEMANDPASS','DEMANDDIMISS','MATERIALDEPLOY','MATERIALPASS','MATERIALDIMISS'
	/** 发布审核第一步 */
	DEPLOYLVONE("DEPLOYLVONE", "发布审核第一步"),
	
	/** 发布审核第二步  */
	DEPLOYLVTWO("DEPLOYLVTWO", "发布审核第二步"),
	
	/** 放款审核第一步 */
	MAKELOANLVONE("MAKELOANLVONE", "放款审核第一步"),
	
	/** 放款审核第二步 */
	MAKELOANLVTWO("MAKELOANLVTWO", "放款审核第二步"),
	/** 需求发布 */
	DEMANDDEPLOY("DEMANDDEPLOY", "需求发布"),
	/** 需求审核通过 */
	DEMANDPASS("DEMANDPASS", "需求审核通过"),
	/** 需求驳回 */
	DEMANDDIMISS("DEMANDDIMISS", "需求驳回"),
	/** 资料上传 */
	MATERIALDEPLOY("MATERIALDEPLOY", "资料上传"),
	/** 资料审核通过 */
	MATERIALPASS("MATERIALPASS", "资料审核通过"),
	/** 资料审核驳回 */
	MATERIALDIMISS("MATERIALDIMISS", "资料审核驳回");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>YrdAuthTypeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private YrdAuthTypeEnum(String code, String message) {
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
	 * @return YrdAuthTypeEnum
	 */
	public static YrdAuthTypeEnum getByCode(String code) {
		for (YrdAuthTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<YrdAuthTypeEnum>
	 */
	public List<YrdAuthTypeEnum> getAllEnum() {
		List<YrdAuthTypeEnum> list = new ArrayList<YrdAuthTypeEnum>();
		for (YrdAuthTypeEnum _enum : values()) {
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
		for (YrdAuthTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
