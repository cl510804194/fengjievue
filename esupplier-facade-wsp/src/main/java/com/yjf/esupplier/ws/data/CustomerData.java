package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.enums.CustomerStatusEnum;
import com.yjf.esupplier.ws.enums.EducationLevelEnum;
import com.yjf.esupplier.ws.enums.MaritalTatusEnum;
import com.yjf.esupplier.ws.enums.UserSexEnum;

public class CustomerData implements Serializable {
	private static final long serialVersionUID = -5347637432411211996L;
	
	/**
	 * 合同id
	 */
	private String contractId;
	
	/**
	 * 用户id
	 */
	private long customerId;
	
	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * 邮件
	 */
	private String email;
	
	/**
	 * 客户性别
	 */
	private UserSexEnum sex;
	
	/**
	 * 客户年龄
	 */
	private int age;
	
	/**
	 * 学生号
	 */
	private String studentNumber;
	
	/**
	 * 证件号
	 */
	private String certificateCard;
	
	/**
	 * 证件有效期 20150326 长期（UNDATED）
	 */
	private String certificateDate;
	
	/**
	 * 发证所在地
	 */
	private String certificateSite;
	
	/**
	 * 联系手机号
	 */
	private String mobileNumber;
	
	/**
	 * 微信号
	 */
	private String weixinNumber;
	
	/**
	 * 受教育程度
	 */
	private EducationLevelEnum educationLevel;
	
	/**
	 * 婚姻状况
	 */
	private MaritalTatusEnum maritalTatus;
	
	/**
	 * 子女数目
	 */
	private int childrenNum;
	
	/**
	 * 住宅联系人姓名
	 */
	private String houseContactName;
	
	/**
	 * 住宅联系人电话
	 */
	private String houseContactPhone;
	
	/**
	 * 户籍所在省
	 */
	private String province;
	
	/**
	 * 户籍所在市
	 */
	private String city;
	
	/**
	 * 户籍所在区
	 */
	private String country;
	
	/**
	 * 户籍所在详细地址
	 */
	private String address;
	
	/**
	 * 客户状态
	 */
	private CustomerStatusEnum status;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public CustomerStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(CustomerStatusEnum status) {
		this.status = status;
	}
	
	public String getContractId() {
		return contractId;
	}
	
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserSexEnum getSex() {
		return sex;
	}
	
	public void setSex(UserSexEnum sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public String getCertificateCard() {
		return certificateCard;
	}
	
	public void setCertificateCard(String certificateCard) {
		this.certificateCard = certificateCard;
	}
	
	public String getCertificateDate() {
		return certificateDate;
	}
	
	public void setCertificateDate(String certificateDate) {
		this.certificateDate = certificateDate;
	}
	
	public String getCertificateSite() {
		return certificateSite;
	}
	
	public void setCertificateSite(String certificateSite) {
		this.certificateSite = certificateSite;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getWeixinNumber() {
		return weixinNumber;
	}
	
	public void setWeixinNumber(String weixinNumber) {
		this.weixinNumber = weixinNumber;
	}
	
	public EducationLevelEnum getEducationLevel() {
		return educationLevel;
	}
	
	public void setEducationLevel(EducationLevelEnum educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	public MaritalTatusEnum getMaritalTatus() {
		return maritalTatus;
	}
	
	public void setMaritalTatus(MaritalTatusEnum maritalTatus) {
		this.maritalTatus = maritalTatus;
	}
	
	public int getChildrenNum() {
		return childrenNum;
	}
	
	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}
	
	public String getHouseContactName() {
		return houseContactName;
	}
	
	public void setHouseContactName(String houseContactName) {
		this.houseContactName = houseContactName;
	}
	
	public String getHouseContactPhone() {
		return houseContactPhone;
	}
	
	public void setHouseContactPhone(String houseContactPhone) {
		this.houseContactPhone = houseContactPhone;
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
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerData [contractId=");
		builder.append(contractId);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", age=");
		builder.append(age);
		builder.append(", studentNumber=");
		builder.append(studentNumber);
		builder.append(", certificateCard=");
		builder.append(certificateCard);
		builder.append(", certificateDate=");
		builder.append(certificateDate);
		builder.append(", certificateSite=");
		builder.append(certificateSite);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", weixinNumber=");
		builder.append(weixinNumber);
		builder.append(", educationLevel=");
		builder.append(educationLevel);
		builder.append(", maritalTatus=");
		builder.append(maritalTatus);
		builder.append(", childrenNum=");
		builder.append(childrenNum);
		builder.append(", houseContactName=");
		builder.append(houseContactName);
		builder.append(", houseContactPhone=");
		builder.append(houseContactPhone);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", country=");
		builder.append(country);
		builder.append(", address=");
		builder.append(address);
		builder.append(", status=");
		builder.append(status);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
