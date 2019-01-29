package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

public class CustomerCompanyData implements Serializable {
	
	private static final long serialVersionUID = -5478084090428442936L;
	
	/**
	 * 客户id
	 */
	private long customerId;
	
	/**
	 * 合同id
	 */
	private String contractId;
	
	/**
	 * 月收入
	 */
	private long monthlyIncome;
	
	/**
	 * 其他月收入
	 */
	private long otherAmount;
	
	/**
	 * 总月收入
	 */
	private long allAmount;
	
	/**
	 * 所在单位/学校
	 */
	private String companyCategory;
	
	/**
	 * 单位名称
	 */
	private String companyName;
	
	/**
	 * 大学名称
	 */
	private String university;
	
	/**
	 * 任职部门/班级
	 */
	private String department;
	
	/**
	 * 工作年限
	 */
	private String workTime;
	
	/**
	 * 开始工作时间 年
	 */
	private String startWorkTime;
	
	/**
	 * 所属行业
	 */
	private String industry;
	
	/**
	 * 单位性质
	 */
	private String unitType;
	
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 单位联系电话
	 */
	private String companyPhone;
	
	/**
	 * 单位 省
	 */
	private String unitProvince;
	
	/**
	 * 单位 市
	 */
	private String unitCity;
	
	/**
	 * 单位 县
	 */
	private String unitCountry;
	
	/**
	 * 单位详细地址
	 */
	private String unitAddress;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public String getContractId() {
		return this.contractId;
	}
	
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public long getMonthlyIncome() {
		return this.monthlyIncome;
	}
	
	public void setMonthlyIncome(long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	
	public long getOtherAmount() {
		return this.otherAmount;
	}
	
	public void setOtherAmount(long otherAmount) {
		this.otherAmount = otherAmount;
	}
	
	public long getAllAmount() {
		return this.allAmount;
	}
	
	public void setAllAmount(long allAmount) {
		this.allAmount = allAmount;
	}
	
	public String getCompanyCategory() {
		return this.companyCategory;
	}
	
	public void setCompanyCategory(String companyCategory) {
		this.companyCategory = companyCategory;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getUniversity() {
		return this.university;
	}
	
	public void setUniversity(String university) {
		this.university = university;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getWorkTime() {
		return this.workTime;
	}
	
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
	public String getStartWorkTime() {
		return this.startWorkTime;
	}
	
	public void setStartWorkTime(String startWorkTime) {
		this.startWorkTime = startWorkTime;
	}
	
	public String getIndustry() {
		return this.industry;
	}
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getUnitType() {
		return this.unitType;
	}
	
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getCompanyPhone() {
		return this.companyPhone;
	}
	
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	
	public String getUnitProvince() {
		return this.unitProvince;
	}
	
	public void setUnitProvince(String unitProvince) {
		this.unitProvince = unitProvince;
	}
	
	public String getUnitCity() {
		return this.unitCity;
	}
	
	public void setUnitCity(String unitCity) {
		this.unitCity = unitCity;
	}
	
	public String getUnitCountry() {
		return this.unitCountry;
	}
	
	public void setUnitCountry(String unitCountry) {
		this.unitCountry = unitCountry;
	}
	
	public String getUnitAddress() {
		return this.unitAddress;
	}
	
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
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
		builder.append("CustomerCompanyData [customerId=");
		builder.append(customerId);
		builder.append(", contractId=");
		builder.append(contractId);
		builder.append(", monthlyIncome=");
		builder.append(monthlyIncome);
		builder.append(", otherAmount=");
		builder.append(otherAmount);
		builder.append(", allAmount=");
		builder.append(allAmount);
		builder.append(", companyCategory=");
		builder.append(companyCategory);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", university=");
		builder.append(university);
		builder.append(", department=");
		builder.append(department);
		builder.append(", workTime=");
		builder.append(workTime);
		builder.append(", startWorkTime=");
		builder.append(startWorkTime);
		builder.append(", industry=");
		builder.append(industry);
		builder.append(", unitType=");
		builder.append(unitType);
		builder.append(", position=");
		builder.append(position);
		builder.append(", companyPhone=");
		builder.append(companyPhone);
		builder.append(", unitProvince=");
		builder.append(unitProvince);
		builder.append(", unitCity=");
		builder.append(unitCity);
		builder.append(", unitCountry=");
		builder.append(unitCountry);
		builder.append(", unitAddress=");
		builder.append(unitAddress);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
