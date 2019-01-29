package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

public class InstitutionsVOInfo implements Serializable {
	// ========== properties ==========
	
	private static final long serialVersionUID = -4062267591589457509L;
	
	private long id;
	
	private String userBaseId;
	
	private String enterpriseName;
	
	private String organizationCode;
	
	private String taxRegistrationNo;
	
	private String businessLicenseNo;
	
	private String businessLicenseProvince;
	
	private String businessLicenseCity;
	
	private String commonlyUsedAddress;
	
	private String businessPeriod;
	
	private String legalRepresentativeName;
	
	private String legalRepresentativeCardNo;
	
	private String businessLicensePath;
	
	private String businessLicenseCachetPath;
	
	private String certFrontPath;
	
	private String certBackPath;
	
	private String openingLicensePath;
	
	private String bankOpenName;
	
	private String bankCardNo;
	
	private String bankType;
	
	private String bankKey;
	
	private String bankProvince;
	
	private String bankCity;
	
	private String bankAddress;
	
	private String institutionsInCode;
	
	private String institutionsThemRoughly;
	
	private String referees;
	
	private String contactName;
	/*身份证期限*/
	private String cardPeriod;
	/*联系人身份证号*/
	private String contactCertNo;
	/*comPhone公司联系电话*/
	private String comPhone;
	/** 邮政编码 */
	private String zipCode;
	
	private double distributionQuota = -1.0;
	
	private long userId;
	
	private String userName;
	
	private String realName;
	
	private String logPassword;
	
	private String payPassword;
	
	private String accountId;
	
	private String accountName;
	
	private String mobile;
	
	private final String mobileBinding = "NO";
	
	private String mail;
	
	private final String mailBinding = "NO";;
	
	private String type;
	
	private String state;
	
	private final Date rowAddTime = new Date();
	
	private Date rowUpdateTime;
	
	private String identityName;
	
	private String identityStartNo;
	
	private String identityEndNo;
	
	private String exIdentityNo;
	
	private String realNameAuthentication;
	
	private Integer pwdErrorCount;
	
	private Date changeLockTime;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserBaseId() {
		return this.userBaseId;
	}
	
	public void setUserBaseId(String userBaseId) {
		this.userBaseId = userBaseId;
	}
	
	public String getEnterpriseName() {
		return this.enterpriseName;
	}
	
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	public String getOrganizationCode() {
		return this.organizationCode;
	}
	
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	
	public String getTaxRegistrationNo() {
		return this.taxRegistrationNo;
	}
	
	public void setTaxRegistrationNo(String taxRegistrationNo) {
		this.taxRegistrationNo = taxRegistrationNo;
	}
	
	public String getBusinessLicenseNo() {
		return this.businessLicenseNo;
	}
	
	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}
	
	public String getBusinessLicenseProvince() {
		return this.businessLicenseProvince;
	}
	
	public void setBusinessLicenseProvince(String businessLicenseProvince) {
		this.businessLicenseProvince = businessLicenseProvince;
	}
	
	public String getBusinessLicenseCity() {
		return this.businessLicenseCity;
	}
	
	public void setBusinessLicenseCity(String businessLicenseCity) {
		this.businessLicenseCity = businessLicenseCity;
	}
	
	public String getCommonlyUsedAddress() {
		return this.commonlyUsedAddress;
	}
	
	public void setCommonlyUsedAddress(String commonlyUsedAddress) {
		this.commonlyUsedAddress = commonlyUsedAddress;
	}
	
	public String getBusinessPeriod() {
		return this.businessPeriod;
	}
	
	public void setBusinessPeriod(String businessPeriod) {
		this.businessPeriod = businessPeriod;
	}
	
	public String getLegalRepresentativeName() {
		return this.legalRepresentativeName;
	}
	
	public void setLegalRepresentativeName(String legalRepresentativeName) {
		this.legalRepresentativeName = legalRepresentativeName;
	}
	
	public String getLegalRepresentativeCardNo() {
		return this.legalRepresentativeCardNo;
	}
	
	public void setLegalRepresentativeCardNo(String legalRepresentativeCardNo) {
		this.legalRepresentativeCardNo = legalRepresentativeCardNo;
	}
	
	public String getBusinessLicensePath() {
		return this.businessLicensePath;
	}
	
	public void setBusinessLicensePath(String businessLicensePath) {
		this.businessLicensePath = businessLicensePath;
	}
	
	public String getBusinessLicenseCachetPath() {
		return this.businessLicenseCachetPath;
	}
	
	public void setBusinessLicenseCachetPath(String businessLicenseCachetPath) {
		this.businessLicenseCachetPath = businessLicenseCachetPath;
	}
	
	public String getCertFrontPath() {
		return this.certFrontPath;
	}
	
	public void setCertFrontPath(String certFrontPath) {
		this.certFrontPath = certFrontPath;
	}
	
	public String getCertBackPath() {
		return this.certBackPath;
	}
	
	public void setCertBackPath(String certBackPath) {
		this.certBackPath = certBackPath;
	}
	
	public String getOpeningLicensePath() {
		return this.openingLicensePath;
	}
	
	public void setOpeningLicensePath(String openingLicensePath) {
		this.openingLicensePath = openingLicensePath;
	}
	
	public String getBankOpenName() {
		return this.bankOpenName;
	}
	
	public void setBankOpenName(String bankOpenName) {
		this.bankOpenName = bankOpenName;
	}
	
	public String getBankCardNo() {
		return this.bankCardNo;
	}
	
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	
	public String getBankType() {
		return this.bankType;
	}
	
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	
	public String getBankKey() {
		return this.bankKey;
	}
	
	public void setBankKey(String bankKey) {
		this.bankKey = bankKey;
	}
	
	public String getBankProvince() {
		return this.bankProvince;
	}
	
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	
	public String getBankCity() {
		return this.bankCity;
	}
	
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	
	public String getBankAddress() {
		return this.bankAddress;
	}
	
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	
	public String getInstitutionsInCode() {
		return this.institutionsInCode;
	}
	
	public void setInstitutionsInCode(String institutionsInCode) {
		this.institutionsInCode = institutionsInCode;
	}
	
	public String getInstitutionsThemRoughly() {
		return this.institutionsThemRoughly;
	}
	
	public void setInstitutionsThemRoughly(String institutionsThemRoughly) {
		this.institutionsThemRoughly = institutionsThemRoughly;
	}
	
	public String getReferees() {
		return this.referees;
	}
	
	public void setReferees(String referees) {
		this.referees = referees;
	}
	
	public String getContactName() {
		return this.contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getCardPeriod() {
		return this.cardPeriod;
	}
	
	public void setCardPeriod(String cardPeriod) {
		this.cardPeriod = cardPeriod;
	}
	
	public String getContactCertNo() {
		return this.contactCertNo;
	}
	
	public void setContactCertNo(String contactCertNo) {
		this.contactCertNo = contactCertNo;
	}
	
	public String getComPhone() {
		return this.comPhone;
	}
	
	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public double getDistributionQuota() {
		return this.distributionQuota;
	}
	
	public void setDistributionQuota(double distributionQuota) {
		this.distributionQuota = distributionQuota;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getLogPassword() {
		return this.logPassword;
	}
	
	public void setLogPassword(String logPassword) {
		this.logPassword = logPassword;
	}
	
	public String getPayPassword() {
		return this.payPassword;
	}
	
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	
	public String getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountName() {
		return this.accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Date getRowUpdateTime() {
		return this.rowUpdateTime;
	}
	
	public void setRowUpdateTime(Date rowUpdateTime) {
		this.rowUpdateTime = rowUpdateTime;
	}
	
	public String getIdentityName() {
		return this.identityName;
	}
	
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}
	
	public String getIdentityStartNo() {
		return this.identityStartNo;
	}
	
	public void setIdentityStartNo(String identityStartNo) {
		this.identityStartNo = identityStartNo;
	}
	
	public String getIdentityEndNo() {
		return this.identityEndNo;
	}
	
	public void setIdentityEndNo(String identityEndNo) {
		this.identityEndNo = identityEndNo;
	}
	
	public String getExIdentityNo() {
		return this.exIdentityNo;
	}
	
	public void setExIdentityNo(String exIdentityNo) {
		this.exIdentityNo = exIdentityNo;
	}
	
	public String getRealNameAuthentication() {
		return this.realNameAuthentication;
	}
	
	public void setRealNameAuthentication(String realNameAuthentication) {
		this.realNameAuthentication = realNameAuthentication;
	}
	
	public Integer getPwdErrorCount() {
		return this.pwdErrorCount;
	}
	
	public void setPwdErrorCount(Integer pwdErrorCount) {
		this.pwdErrorCount = pwdErrorCount;
	}
	
	public Date getChangeLockTime() {
		return this.changeLockTime;
	}
	
	public void setChangeLockTime(Date changeLockTime) {
		this.changeLockTime = changeLockTime;
	}
	
	public String getMobileBinding() {
		return this.mobileBinding;
	}
	
	public String getMailBinding() {
		return this.mailBinding;
	}
	
	public Date getRowAddTime() {
		return this.rowAddTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstitutionsVOInfo [id=");
		builder.append(id);
		builder.append(", userBaseId=");
		builder.append(userBaseId);
		builder.append(", enterpriseName=");
		builder.append(enterpriseName);
		builder.append(", organizationCode=");
		builder.append(organizationCode);
		builder.append(", taxRegistrationNo=");
		builder.append(taxRegistrationNo);
		builder.append(", businessLicenseNo=");
		builder.append(businessLicenseNo);
		builder.append(", businessLicenseProvince=");
		builder.append(businessLicenseProvince);
		builder.append(", businessLicenseCity=");
		builder.append(businessLicenseCity);
		builder.append(", commonlyUsedAddress=");
		builder.append(commonlyUsedAddress);
		builder.append(", businessPeriod=");
		builder.append(businessPeriod);
		builder.append(", legalRepresentativeName=");
		builder.append(legalRepresentativeName);
		builder.append(", legalRepresentativeCardNo=");
		builder.append(legalRepresentativeCardNo);
		builder.append(", businessLicensePath=");
		builder.append(businessLicensePath);
		builder.append(", businessLicenseCachetPath=");
		builder.append(businessLicenseCachetPath);
		builder.append(", certFrontPath=");
		builder.append(certFrontPath);
		builder.append(", certBackPath=");
		builder.append(certBackPath);
		builder.append(", openingLicensePath=");
		builder.append(openingLicensePath);
		builder.append(", bankOpenName=");
		builder.append(bankOpenName);
		builder.append(", bankCardNo=");
		builder.append(bankCardNo);
		builder.append(", bankType=");
		builder.append(bankType);
		builder.append(", bankKey=");
		builder.append(bankKey);
		builder.append(", bankProvince=");
		builder.append(bankProvince);
		builder.append(", bankCity=");
		builder.append(bankCity);
		builder.append(", bankAddress=");
		builder.append(bankAddress);
		builder.append(", institutionsInCode=");
		builder.append(institutionsInCode);
		builder.append(", institutionsThemRoughly=");
		builder.append(institutionsThemRoughly);
		builder.append(", referees=");
		builder.append(referees);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", cardPeriod=");
		builder.append(cardPeriod);
		builder.append(", contactCertNo=");
		builder.append(contactCertNo);
		builder.append(", comPhone=");
		builder.append(comPhone);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", distributionQuota=");
		builder.append(distributionQuota);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", logPassword=");
		builder.append(logPassword);
		builder.append(", payPassword=");
		builder.append(payPassword);
		builder.append(", accountId=");
		builder.append(accountId);
		builder.append(", accountName=");
		builder.append(accountName);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", mobileBinding=");
		builder.append(mobileBinding);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", mailBinding=");
		builder.append(mailBinding);
		builder.append(", type=");
		builder.append(type);
		builder.append(", state=");
		builder.append(state);
		builder.append(", rowAddTime=");
		builder.append(rowAddTime);
		builder.append(", rowUpdateTime=");
		builder.append(rowUpdateTime);
		builder.append(", identityName=");
		builder.append(identityName);
		builder.append(", identityStartNo=");
		builder.append(identityStartNo);
		builder.append(", identityEndNo=");
		builder.append(identityEndNo);
		builder.append(", exIdentityNo=");
		builder.append(exIdentityNo);
		builder.append(", realNameAuthentication=");
		builder.append(realNameAuthentication);
		builder.append(", pwdErrorCount=");
		builder.append(pwdErrorCount);
		builder.append(", changeLockTime=");
		builder.append(changeLockTime);
		builder.append("]");
		return builder.toString();
	}
	
}
