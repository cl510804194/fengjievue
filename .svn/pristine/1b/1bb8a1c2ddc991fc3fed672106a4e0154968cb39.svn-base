/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.integration.openapi.enums.PeasonSexEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.CertTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 
 * @Filename RegisterOrder.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class RegisterOrder extends ValidateOrderBase implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -5137145119038902180L;
	/** 核心会员账户id */
	String userId;
	/** 用户名 */
	String userName;
	
	/** 注册类型 */
//	String userType = "P";
	String userType = "PERSON"; //PERSONAL 个人用户注册 /ENTERPRISE 企业用户注册 /INDIVIDUAL:个体户用户注册  ｛企业付通 PERSON BUSINESS｝
	/** 用户名 */
	String realName;
	/** 用户身份类型 */
	private CertTypeEnum certType = CertTypeEnum.Identity_Card;
	/** 证件号 */
	private String certNo;
	/** 手机 */
	private String mobile;
	
	/** 省份 */
	protected String province;
	
	/** 邮件地址 */
	protected String email;
	/** 国籍 */
	protected String country = "中国大陆";
	/** 性别 */
	protected PeasonSexEnum gender = PeasonSexEnum.MAN;
	
	/** 匿名注册标志 */
	protected BooleanEnum anonymousRegister = BooleanEnum.NO;
	
	/** 职业 */
	protected String profession = "自由";
	/** 证件有效期 */
	protected String licenseValidTime = "0";
	protected String userStatus = "";
	/** 经营范围 */
	protected String enterpriseBusinessScope = "";
	/**
	 * 营业执照副本图片
	 */
	protected String licence;
	
	/**
	 * 组织机构代码
	 * 
	 */
	protected String organizationCode;
	
	/**
	 * 注册地址
	 * @return
	 */
	protected String regAddress;
	/**
	 * 法人代表证件类型
	 */
	protected String legalCertType;
	/**
	 * 法人代表证件有效期
	 */
	protected String legalLicValidTime;
	/**
	 * 法人或者经营者证件正面图片
	 */
	protected String legalPersonCertFrontPath;
	
	/**
	 * 法人或者经营者证件背面图片
	 */
	protected String legalPersonCertBackPath;
	/**
	 * 法人或者经营者真实姓名
	 */
	protected String legalPersonName;
	
	/**
	 * legalPersonCertNo
	 * @return
	 */
	/**
	 * 法人或者经营者证件号
	 */
	protected String legalPersonCertNo;
	
	protected String merchOrderNo;
	
	public String getMerchOrderNo() {
		return merchOrderNo;
	}

	public void setMerchOrderNo(String merchOrderNo) {
		this.merchOrderNo = merchOrderNo;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public CertTypeEnum getCertType() {
		return certType;
	}
	
	public void setCertType(CertTypeEnum certType) {
		this.certType = certType;
	}
	
	public String getCertNo() {
		return certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @see com.yjf.common.service.Order#check()
	 */
	@Override
	public void check() {
		if (StringUtil.isBlank(userId)) {
			Assert.hasText(userName);
			Assert.hasText(userType);
		}
	}
	
	public BooleanEnum getAnonymousRegister() {
		return this.anonymousRegister;
	}
	
	public void setAnonymousRegister(BooleanEnum anonymousRegister) {
		this.anonymousRegister = anonymousRegister;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public PeasonSexEnum getGender() {
		return this.gender;
	}
	
	public void setGender(PeasonSexEnum gender) {
		this.gender = gender;
	}
	
	public String getProfession() {
		return this.profession;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String getLicenseValidTime() {
		return this.licenseValidTime;
	}
	
	public void setLicenseValidTime(String licenseValidTime) {
		this.licenseValidTime = licenseValidTime;
	}
	
	public String getUserStatus() {
		return this.userStatus;
	}
	
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	public String getEnterpriseBusinessScope() {
		return this.enterpriseBusinessScope;
	}
	
	public void setEnterpriseBusinessScope(String enterpriseBusinessScope) {
		this.enterpriseBusinessScope = enterpriseBusinessScope;
	}
	
	public String getLicence() {
		return this.licence;
	}
	
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
	public String getOrganizationCode() {
		return this.organizationCode;
	}
	
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	
	public String getRegAddress() {
		return this.regAddress;
	}
	
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
	
	public String getLegalCertType() {
		return this.legalCertType;
	}
	
	public void setLegalCertType(String legalCertType) {
		this.legalCertType = legalCertType;
	}
	
	public String getLegalLicValidTime() {
		return this.legalLicValidTime;
	}
	
	public void setLegalLicValidTime(String legalLicValidTime) {
		this.legalLicValidTime = legalLicValidTime;
	}
	
	public String getLegalPersonCertFrontPath() {
		return this.legalPersonCertFrontPath;
	}
	
	public void setLegalPersonCertFrontPath(String legalPersonCertFrontPath) {
		this.legalPersonCertFrontPath = legalPersonCertFrontPath;
	}
	
	public String getLegalPersonCertBackPath() {
		return this.legalPersonCertBackPath;
	}
	
	public void setLegalPersonCertBackPath(String legalPersonCertBackPath) {
		this.legalPersonCertBackPath = legalPersonCertBackPath;
	}
	
	public String getLegalPersonName() {
		return this.legalPersonName;
	}
	
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
	
	public String getLegalPersonCertNo() {
		return this.legalPersonCertNo;
	}
	
	public void setLegalPersonCertNo(String legalPersonCertNo) {
		this.legalPersonCertNo = legalPersonCertNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterOrder [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userType=");
		builder.append(userType);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", certType=");
		builder.append(certType);
		builder.append(", certNo=");
		builder.append(certNo);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", province=");
		builder.append(province);
		builder.append(", email=");
		builder.append(email);
		builder.append(", country=");
		builder.append(country);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", anonymousRegister=");
		builder.append(anonymousRegister);
		builder.append(", profession=");
		builder.append(profession);
		builder.append(", licenseValidTime=");
		builder.append(licenseValidTime);
		builder.append(", userStatus=");
		builder.append(userStatus);
		builder.append(", enterpriseBusinessScope=");
		builder.append(enterpriseBusinessScope);
		builder.append(", licence=");
		builder.append(licence);
		builder.append(", organizationCode=");
		builder.append(organizationCode);
		builder.append(", regAddress=");
		builder.append(regAddress);
		builder.append(", legalCertType=");
		builder.append(legalCertType);
		builder.append(", legalLicValidTime=");
		builder.append(legalLicValidTime);
		builder.append(", legalPersonCertFrontPath=");
		builder.append(legalPersonCertFrontPath);
		builder.append(", legalPersonCertBackPath=");
		builder.append(legalPersonCertBackPath);
		builder.append(", legalPersonName=");
		builder.append(legalPersonName);
		builder.append(", legalPersonCertNo=");
		builder.append(legalPersonCertNo);
		builder.append("]");
		return builder.toString();
	}
	
}
