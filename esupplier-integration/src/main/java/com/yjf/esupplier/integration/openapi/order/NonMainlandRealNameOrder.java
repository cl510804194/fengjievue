package com.yjf.esupplier.integration.openapi.order;

import java.util.Random;

import com.yjf.common.lang.enums.CertTypeEnum;
import com.yjf.esupplier.integration.openapi.enums.AttributionEnum;
import com.yjf.esupplier.integration.openapi.enums.CountryEnums;
import com.yjf.esupplier.integration.openapi.enums.OccupationEnum;
import com.yjf.esupplier.integration.openapi.enums.PeasonSexEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class NonMainlandRealNameOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -3873831811125486253L;
	static Random random = new Random();
	
	public NonMainlandRealNameOrder() {
		
		guaranteeOccupation = OccupationEnum.getAllEnum()
			.get(random.nextInt(OccupationEnum.getAllEnum().size())).code();
		occupation = OccupationEnum.getAllEnum()
			.get(random.nextInt(OccupationEnum.getAllEnum().size())).code();
	}
	
	@Override
	public void check() {
		super.check();
		validateHasText(userId, "用户易极付账户");
		validateHasText(realName, "真实名称");
		validateHasText(certNo, "证件号");
		validateHasText(certNo, "证件号");
		validateNotNull(certType, "证件类型");
		validateHasText(certFrontPath, "证件正面图片");
		validateHasText(certValidTime, "证件到期时间");
		validateHasText(guaranteeName, "担保人姓名");
		validateHasText(guaranteeCertNo, "担保人证件号");
		validateNotNull(guaranteeCertType, "担保人证件类型");
		validateHasText(guaranteeCertValidTime, "担保人证件到期时间");
		validateHasText(guaranteeCertFrontPath, "担保人证件正面图片");
		validateHasText(guaranteeCertBackPath, "担保人证件背面图片");
		
		validateHasText(guaranteePhone, "担保人手机号");
		validateHasText(guaranteeOccupation, "担保人职业");
		validateHasText(guaranteeAddress, "担保人地址");
		validateHasText(guaranteePic, "担保函");
		validateNotNull(attribution, "归属地");
		validateHasText(occupation, "职业");
		validateHasText(phone, "联系电话");
		validateNotNull(sex, "性别");
		validateNotNull(country, "国家");
		validateHasText(auditpic, "证件正面图片");
	}
	
	public static void main(String[] args) {
		NonMainlandRealNameOrder mainlandRealNameOrder = new NonMainlandRealNameOrder();
		System.out.println(mainlandRealNameOrder.toString());
	}
	
	/**
	 * 用户id
	 */
	String userId;
	/**
	 * 真实姓名
	 */
	String realName;
	/**
	 * 证件号
	 */
	String certNo;
	/**
	 * 证件类型
	 */
	CertTypeEnum certType = CertTypeEnum.Taiwan_Compatriot_Entry_Permit;
	/**
	 * 证件正面图片
	 */
	String certFrontPath;
	/**
	 * 证件背面图片
	 */
	String certBackPath;
	/**
	 * 证件到期时间如：正常：20120911, 长期为：0
	 */
	String certValidTime;
	/**
	 * 担保人姓名
	 */
	String guaranteeName;
	/**
	 * 担保人证件号
	 */
	String guaranteeCertNo;
	/**
	 * 担保人证件类型
	 */
	CertTypeEnum guaranteeCertType;
	
	/**
	 * 担保人证件到期时间
	 */
	String guaranteeCertValidTime;
	/**
	 * 担保人证件正面图片
	 */
	String guaranteeCertFrontPath;
	
	/**
	 * 担保人证件背面图片
	 */
	String guaranteeCertBackPath;
	/**
	 * 担保人手机号
	 */
	String guaranteePhone;
	
	/**
	 * 担保人职业
	 */
	String guaranteeOccupation;
	/**
	 * 担保人地址
	 */
	String guaranteeAddress;
	/**
	 * 担保函
	 */
	String guaranteePic;
	
	/**
	 * 归属地
	 */
	AttributionEnum attribution;
	/**
	 * 职业
	 */
	String occupation;
	/**
	 * 出生日期
	 */
	String birth;
	/**
	 * 收入
	 */
	String salary;
	/**
	 * 联系电话
	 */
	String phone;
	/**
	 * 性别
	 */
	PeasonSexEnum sex;
	/**
	 * 地址
	 */
	String address;
	/**
	 * 国家
	 */
	CountryEnums country;
	
	String auditpic;
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getCertNo() {
		return this.certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public CertTypeEnum getCertType() {
		return this.certType;
	}
	
	public void setCertType(CertTypeEnum certType) {
		this.certType = certType;
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
	
	public String getCertValidTime() {
		return this.certValidTime;
	}
	
	public void setCertValidTime(String certValidTime) {
		this.certValidTime = certValidTime;
	}
	
	public String getGuaranteeName() {
		return this.guaranteeName;
	}
	
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	
	public String getGuaranteeCertNo() {
		return this.guaranteeCertNo;
	}
	
	public void setGuaranteeCertNo(String guaranteeCertNo) {
		this.guaranteeCertNo = guaranteeCertNo;
	}
	
	public CertTypeEnum getGuaranteeCertType() {
		return this.guaranteeCertType;
	}
	
	public void setGuaranteeCertType(CertTypeEnum guaranteeCertType) {
		this.guaranteeCertType = guaranteeCertType;
	}
	
	public String getGuaranteeCertValidTime() {
		return this.guaranteeCertValidTime;
	}
	
	public void setGuaranteeCertValidTime(String guaranteeCertValidTime) {
		this.guaranteeCertValidTime = guaranteeCertValidTime;
	}
	
	public String getGuaranteeCertFrontPath() {
		return this.guaranteeCertFrontPath;
	}
	
	public void setGuaranteeCertFrontPath(String guaranteeCertFrontPath) {
		this.guaranteeCertFrontPath = guaranteeCertFrontPath;
	}
	
	public String getGuaranteeCertBackPath() {
		return this.guaranteeCertBackPath;
	}
	
	public void setGuaranteeCertBackPath(String guaranteeCertBackPath) {
		this.guaranteeCertBackPath = guaranteeCertBackPath;
	}
	
	public String getGuaranteePhone() {
		return this.guaranteePhone;
	}
	
	public void setGuaranteePhone(String guaranteePhone) {
		this.guaranteePhone = guaranteePhone;
	}
	
	public String getGuaranteeOccupation() {
		return this.guaranteeOccupation;
	}
	
	public void setGuaranteeOccupation(String guaranteeOccupation) {
		this.guaranteeOccupation = guaranteeOccupation;
	}
	
	public String getGuaranteeAddress() {
		return this.guaranteeAddress;
	}
	
	public void setGuaranteeAddress(String guaranteeAddress) {
		this.guaranteeAddress = guaranteeAddress;
	}
	
	public String getGuaranteePic() {
		return this.guaranteePic;
	}
	
	public void setGuaranteePic(String guaranteePic) {
		this.guaranteePic = guaranteePic;
	}
	
	public AttributionEnum getAttribution() {
		return this.attribution;
	}
	
	public void setAttribution(AttributionEnum attribution) {
		this.attribution = attribution;
		if (attribution == AttributionEnum.HK) {
			this.setCountry(CountryEnums.HongKong);
		}
		if (attribution == AttributionEnum.MC) {
			this.setCountry(CountryEnums.Macau);
		}
		if (attribution == AttributionEnum.TW) {
			this.setCountry(CountryEnums.Taiwan);
		}
	}
	
	public String getOccupation() {
		return this.occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getBirth() {
		return this.birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getSalary() {
		return this.salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public PeasonSexEnum getSex() {
		return this.sex;
	}
	
	public void setSex(PeasonSexEnum sex) {
		this.sex = sex;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public CountryEnums getCountry() {
		return this.country;
	}
	
	public void setCountry(CountryEnums country) {
		this.country = country;
	}
	
	public String getAuditpic() {
		return auditpic;
	}

	public void setAuditpic(String auditpic) {
		this.auditpic = auditpic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NonMainlandRealNameOrder [userId=");
		builder.append(userId);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", certNo=");
		builder.append(certNo);
		builder.append(", certType=");
		builder.append(certType);
		builder.append(", certFrontPath=");
		builder.append(certFrontPath);
		builder.append(", certBackPath=");
		builder.append(certBackPath);
		builder.append(", certValidTime=");
		builder.append(certValidTime);
		builder.append(", guaranteeName=");
		builder.append(guaranteeName);
		builder.append(", guaranteeCertNo=");
		builder.append(guaranteeCertNo);
		builder.append(", guaranteeCertType=");
		builder.append(guaranteeCertType);
		builder.append(", guaranteeCertValidTime=");
		builder.append(guaranteeCertValidTime);
		builder.append(", guaranteeCertFrontPath=");
		builder.append(guaranteeCertFrontPath);
		builder.append(", guaranteeCertBackPath=");
		builder.append(guaranteeCertBackPath);
		builder.append(", guaranteePhone=");
		builder.append(guaranteePhone);
		builder.append(", guaranteeOccupation=");
		builder.append(guaranteeOccupation);
		builder.append(", guaranteeAddress=");
		builder.append(guaranteeAddress);
		builder.append(", guaranteePic=");
		builder.append(guaranteePic);
		builder.append(", attribution=");
		builder.append(attribution);
		builder.append(", occupation=");
		builder.append(occupation);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", address=");
		builder.append(address);
		builder.append(", country=");
		builder.append(country);
		builder.append(", auditpic=");
		builder.append(auditpic);
		builder.append("]");
		return builder.toString();
	}
	
}
