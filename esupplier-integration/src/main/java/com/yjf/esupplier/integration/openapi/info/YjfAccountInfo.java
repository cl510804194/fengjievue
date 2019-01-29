/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.info;

import java.io.Serializable;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.integration.openapi.enums.CertifyLevelEnum;
import com.yjf.esupplier.integration.openapi.enums.UserStatusEnum;
import com.yjf.esupplier.integration.openapi.enums.YjfUserTypeEnum;

/**
 * 
 * @Filename YjfAccountInfo.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class YjfAccountInfo implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 1488521729939362390L;
	/**
	 * 账户号
	 */
	private String accountNo;
	/**
	 * userId
	 */
	private String userId;
	/**
	 * 账户别名
	 */
	private String accountAlias;
	
	private String accountTitleId;
	
	private String titleName;
	/**
	 * 币种
	 */
	private String currency;
	/**
	 * 账户余额
	 */
	private Money balance;
	/**
	 * 账户类型
	 */
	private String accountType;
	/**
	 * 账户状态
	 */
	private String status;
	
	/**
	 * 账户信用额度
	 */
	private Money creditAmount = new Money();
	/**
	 * 账户可用信用额度
	 */
	private Money creditBalance = new Money();
	/**
	 * 账户冻结额度
	 */
	private Money freezeAmount = new Money();
	/**
	 * 系统冻结额度
	 */
	private Money systemAmount = new Money();
	
	Money availableBalance = new Money();
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 用户登录名
	 */
	private String userName;
	/**
	 * 用户真实名称
	 */
	private String realName;
	/**
	 * 用户状态
	 */
	private UserStatusEnum userStatus;
	/**
	 * 用户身份类型
	 */
	private String certType;
	/**
	 * 证件号
	 */
	private String certNo;
	/**
	 * 证件有效期
	 */
	private String licenseValidTime;
	/**
	 * 认证状态 未认证 已认证，认证中，被驳回
	 */
	private String certifyStatus;
	
	/**
	 * 运行时状态
	 */
	private String runtimeStatus;
	
	private String registerFrom;
	
	private CertifyLevelEnum certifyLevel = CertifyLevelEnum.NO_RANK;
	/**
	 * 详细地址
	 */
	private String address;
	
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	
	private YjfUserTypeEnum userType = YjfUserTypeEnum.PERSON;
	
	//	userId 	易极付用户ID 	字符串 	否 	易极付用户ID 	1234567980132456789
	//	userName 	用户名 	字符串 	否 	用户名 	易极付
	//	email 	用户邮箱 	字符串 	否 	用户邮箱 	xx@yiji.com
	//	mobileNo 	用户手机号 	字符串 	否 	用户手机号 	10086100101---------------
	//	realName 	用户真实姓名 	字符串 	否 	用户真实姓名 	易极付
	//	certType 	证件类型 	字符串 	否 	证件类型
	//
	//		Identity_Card
	//	certNo 	证件号码 	字符串 	否 	证件号码 	123456789012345678
	//	verifyCode 	会员身份验证码 	字符串 	否 	会员身份验证码 	sdfs
	//	bankCardCount 	绑定银行卡数量 	整型 	否 	绑定银行卡数量 	1
	//	userType 	用户类型 	字符串 	否 	用户类型 	PERSON---
	//	certifyStatus 	实名认证状态 	字符串 	否 	实名认证状态 	UNAUTHERIZED
	//	certifyLevel 	实名认证等级 	字符串 	否 	实名认证等级 	NO_RANK
	//	userStatus 	用户状态 	字符串 	否 	用户状态 	UNACTIVATED
	//	runtimeStatus
	
	public Money getAvailableBalance() {
		return availableBalance;
	}
	
	public void setAvailableBalance(Money availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public boolean isActive() {
		return UserStatusEnum.NORMAL == userStatus;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAccountAlias() {
		return accountAlias;
	}
	
	public void setAccountAlias(String accountAlias) {
		this.accountAlias = accountAlias;
	}
	
	public String getAccountTitleId() {
		return accountTitleId;
	}
	
	public void setAccountTitleId(String accountTitleId) {
		this.accountTitleId = accountTitleId;
	}
	
	public String getTitleName() {
		return titleName;
	}
	
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public Money getBalance() {
		return balance;
	}
	
	public void setBalance(Money balance) {
		this.balance = balance;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public UserStatusEnum getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
	}
	
	public String getCertType() {
		return certType;
	}
	
	public void setCertType(String certType) {
		this.certType = certType;
	}
	
	public String getCertNo() {
		return certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public String getLicenseValidTime() {
		return licenseValidTime;
	}
	
	public void setLicenseValidTime(String licenseValidTime) {
		this.licenseValidTime = licenseValidTime;
	}
	
	public String getCertifyStatus() {
		return certifyStatus;
	}
	
	public void setCertifyStatus(String certifyStatus) {
		this.certifyStatus = certifyStatus;
	}
	
	public String getRuntimeStatus() {
		return runtimeStatus;
	}
	
	public void setRuntimeStatus(String runtimeStatus) {
		this.runtimeStatus = runtimeStatus;
	}
	
	public String getRegisterFrom() {
		return registerFrom;
	}
	
	public void setRegisterFrom(String registerFrom) {
		this.registerFrom = registerFrom;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Money getCreditAmount() {
		return creditAmount;
	}
	
	public void setCreditAmount(Money creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	public Money getCreditBalance() {
		return creditBalance;
	}
	
	public void setCreditBalance(Money creditBalance) {
		this.creditBalance = creditBalance;
	}
	
	public Money getFreezeAmount() {
		return freezeAmount;
	}
	
	public void setFreezeAmount(Money freezeAmount) {
		this.freezeAmount = freezeAmount;
	}
	
	public Money getSystemAmount() {
		return systemAmount;
	}
	
	public void setSystemAmount(Money systemAmount) {
		this.systemAmount = systemAmount;
	}
	
	public YjfUserTypeEnum getUserType() {
		return this.userType;
	}
	
	public void setUserType(YjfUserTypeEnum userType) {
		this.userType = userType;
	}
	
	public CertifyLevelEnum getCertifyLevel() {
		return this.certifyLevel;
	}
	
	public void setCertifyLevel(CertifyLevelEnum certifyLevel) {
		this.certifyLevel = certifyLevel;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfAccountInfo [accountNo=");
		builder.append(accountNo);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", accountAlias=");
		builder.append(accountAlias);
		builder.append(", accountTitleId=");
		builder.append(accountTitleId);
		builder.append(", titleName=");
		builder.append(titleName);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creditAmount=");
		builder.append(creditAmount);
		builder.append(", creditBalance=");
		builder.append(creditBalance);
		builder.append(", freezeAmount=");
		builder.append(freezeAmount);
		builder.append(", systemAmount=");
		builder.append(systemAmount);
		builder.append(", email=");
		builder.append(email);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", userStatus=");
		builder.append(userStatus);
		builder.append(", certType=");
		builder.append(certType);
		builder.append(", certNo=");
		builder.append(certNo);
		builder.append(", licenseValidTime=");
		builder.append(licenseValidTime);
		builder.append(", certifyStatus=");
		builder.append(certifyStatus);
		builder.append(", runtimeStatus=");
		builder.append(runtimeStatus);
		builder.append(", registerFrom=");
		builder.append(registerFrom);
		builder.append(", certifyLevel=");
		builder.append(certifyLevel);
		builder.append(", address=");
		builder.append(address);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", country=");
		builder.append(country);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", userType=");
		builder.append(userType);
		builder.append("]");
		return builder.toString();
	}
	
}
