/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename CertTypeEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author jiajie
 * 
 * @Email hjiajie@yiji.com
 * 
 * @History <li>Author: jiajie</li> <li>Date: 2013-7-22</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum CertTypeEnum {
	
	/** 身份证 */
	Identity_Card("ID", "Identity_Card", "1010010000", "身份证"),
	/** 军官证 */
	Army_Identity_Card("ARMY_ID", "Army_Identity_Card", "1010020000", "军官证"),
	/** 护照 */
	Passport("PASSPORT", "Passport", "1010030000", "护照"),
	/** 营业执照 */
	BUSINESS_LICENCE("BUSINESS_LICENCE", "BUSINESS_LICENSE", "1010040000", "营业执照"),
	/** 组织机构代码证 */
	INSTITUTION_CODE("INSTITUTION_CODE", "Other", "1010050000", "组织机构代码证"),
	/** 社团证书 */
	CORPORATION_LETTER("CORPORATION_LETTER", "Other", "1010060000", "社团证书"),
	/** 户口薄 */
	residence_card("residence_card", "Other", "1010070000", "户口薄"),
	/** 回乡证 */
	Home_Return_Permit("HOME_RETURN", "HOME_RETURN", "1010080000", "回乡证"),
	/** 港澳居民来往内地通行证 */
	HOME_RETURN_LETTER("HOME_RETURN_LETTER", "Other", "1010090000", "港澳居民来往内地通行证"),
	/** 身份证（香港） */
	hong_kong_Identity("hong_kong_Identity", "Other", "1010100000", "身份证（香港）"),
	/** 台胞证 */
	Taiwan_Compatriot_Entry_Permit("TAIWAN", "TAIWAN", "1010110000", "台胞证"),
	/** 警官证 */
	OFFICERS_CARD("OFFICERS_CARD", "OFFICERS_CARD", "1010120000", "警官证"),
	/** 士兵证 */
	Soldiers_Card("SOLDIER_CARD", "SOLDIER_CARD", "1010130000", "士兵证"),
	/** 其它证件 */
	Other("Other", "Other", "1010140000", "其它证件");
	
	/** 枚举值 */
	private final String code;
	
	/** yjf code */
	private final String coreCode;
	
	/** 枚举值 */
	private final String num;
	
	/** 枚举描述 */
	private final String message;
	
	/**
	 * 构造一个<code>CertTypeEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private CertTypeEnum(String code, String coreCode, String num, String message) {
		this.code = code;
		this.coreCode = coreCode;
		this.num = num;
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
	
	public String getNum() {
		return num;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	public String getCoreCode() {
		return coreCode;
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
	 * @return CertTypeEnum
	 */
	public static CertTypeEnum getByCode(String code) {
		if ("Other".equals(code)) {
			return Other;
		}
		for (CertTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 通过枚举<code>num</code>获得枚举
	 * 
	 * @param num
	 * @return ObligeePropertiesEnum
	 */
	public static CertTypeEnum getByNum(String num) {
		for (CertTypeEnum _enum : values()) {
			if (_enum.getNum().equals(num)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<CertTypeEnum>
	 */
	public List<CertTypeEnum> getAllEnum() {
		List<CertTypeEnum> list = new ArrayList<CertTypeEnum>();
		for (CertTypeEnum _enum : values()) {
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
		for (CertTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 单位性质的证件类型
	 * @return List<CertTypeEnum>
	 */
	public List<CertTypeEnum> getAllCompanyEnum() {
		List<CertTypeEnum> list = new ArrayList<CertTypeEnum>();
		list.add(CertTypeEnum.BUSINESS_LICENCE);
		list.add(CertTypeEnum.INSTITUTION_CODE);
		list.add(CertTypeEnum.CORPORATION_LETTER);
		list.add(CertTypeEnum.Other);
		return list;
	}
	
	/**
	 * 个人性质的证件类型
	 * @return List<CertTypeEnum>
	 */
	public List<CertTypeEnum> getAllPersonalEnum() {
		List<CertTypeEnum> list = new ArrayList<CertTypeEnum>();
		list = CertTypeEnum.Army_Identity_Card.getAllEnum();
		list.remove(CertTypeEnum.BUSINESS_LICENCE);
		list.remove(CertTypeEnum.INSTITUTION_CODE);
		list.remove(CertTypeEnum.CORPORATION_LETTER);
		return list;
	}
}
