package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.LoanTypeEnum;
import com.yjf.esupplier.ws.enums.RefundEnum;
import com.yjf.esupplier.ws.enums.UserSexEnum;

public class RefundItemData implements Serializable {
	
	private static final long serialVersionUID = 1649839751175148370L;
	private long itemId;
	
	private String contractId;
	
	private String yjfAccountId;
	
	private String yjfAccountName;
	
	private Date salesDate;
	
	private String salesArea;
	
	private String customerName;
	
	private UserSexEnum customerSex;
	
	private String certificateCard;
	
	private Date customerBirthday;
	
	private String commodityType;
	
	private String commodityBrand;
	
	private Money commodityAmount = new Money(0, 0);
	
	private Money loanAmount = new Money(0, 0);
	
	private int stagesNum;
	
	private Money monthlyAmount = new Money(0, 0);
	
	private String userName;
	
	private String storeName;
	
	private int storeId;
	
	private String referrerName;
	
	private int stageNum;
	
	private int currentNum;
	
	private String refundBank;
	
	private String refundCardNumber;
	
	private LoanTypeEnum loanType;
	
	private String userId;
	
	private Money currentRefundAmount = new Money(0, 0);
	
	private Money breachOfContractAmount = new Money(0, 0);
	
	private Date refundTime;
	
	private Date actualRefundTime;
	
	private RefundEnum refundStatus;
	
	private String outBizNo;
	
	private String remark;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getItemId() {
		return this.itemId;
	}
	
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	
	public String getContractId() {
		return this.contractId;
	}
	
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public Date getSalesDate() {
		return this.salesDate;
	}
	
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	
	public String getSalesArea() {
		return this.salesArea;
	}
	
	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public UserSexEnum getCustomerSex() {
		return this.customerSex;
	}
	
	public void setCustomerSex(UserSexEnum customerSex) {
		this.customerSex = customerSex;
	}
	
	public Date getCustomerBirthday() {
		return this.customerBirthday;
	}
	
	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}
	
	public String getCommodityType() {
		return this.commodityType;
	}
	
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}
	
	public String getCommodityBrand() {
		return this.commodityBrand;
	}
	
	public void setCommodityBrand(String commodityBrand) {
		this.commodityBrand = commodityBrand;
	}
	
	public Money getCommodityAmount() {
		return this.commodityAmount;
	}
	
	public void setCommodityAmount(Money commodityAmount) {
		this.commodityAmount = commodityAmount;
	}
	
	public Money getLoanAmount() {
		return this.loanAmount;
	}
	
	public void setLoanAmount(Money loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public int getStagesNum() {
		return this.stagesNum;
	}
	
	public void setStagesNum(int stagesNum) {
		this.stagesNum = stagesNum;
	}
	
	public Money getMonthlyAmount() {
		return this.monthlyAmount;
	}
	
	public void setMonthlyAmount(Money monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getStoreName() {
		return this.storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public int getStoreId() {
		return this.storeId;
	}
	
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	public String getReferrerName() {
		return this.referrerName;
	}
	
	public void setReferrerName(String referrerName) {
		this.referrerName = referrerName;
	}
	
	public int getStageNum() {
		return this.stageNum;
	}
	
	public void setStageNum(int stageNum) {
		this.stageNum = stageNum;
	}
	
	public int getCurrentNum() {
		return this.currentNum;
	}
	
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	
	public String getRefundBank() {
		return this.refundBank;
	}
	
	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}
	
	public String getRefundCardNumber() {
		return this.refundCardNumber;
	}
	
	public void setRefundCardNumber(String refundCardNumber) {
		this.refundCardNumber = refundCardNumber;
	}
	
	public LoanTypeEnum getLoanType() {
		return this.loanType;
	}
	
	public void setLoanType(LoanTypeEnum loanType) {
		this.loanType = loanType;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Money getCurrentRefundAmount() {
		return this.currentRefundAmount;
	}
	
	public void setCurrentRefundAmount(Money currentRefundAmount) {
		this.currentRefundAmount = currentRefundAmount;
	}
	
	public Money getBreachOfContractAmount() {
		return this.breachOfContractAmount;
	}
	
	public void setBreachOfContractAmount(Money breachOfContractAmount) {
		this.breachOfContractAmount = breachOfContractAmount;
	}
	
	public Date getRefundTime() {
		return this.refundTime;
	}
	
	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}
	
	public Date getActualRefundTime() {
		return this.actualRefundTime;
	}
	
	public void setActualRefundTime(Date actualRefundTime) {
		this.actualRefundTime = actualRefundTime;
	}
	
	public RefundEnum getRefundStatus() {
		return this.refundStatus;
	}
	
	public void setRefundStatus(RefundEnum refundStatus) {
		this.refundStatus = refundStatus;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	public String getYjfAccountId() {
		return this.yjfAccountId;
	}
	
	public void setYjfAccountId(String yjfAccountId) {
		this.yjfAccountId = yjfAccountId;
	}
	
	public String getYjfAccountName() {
		return this.yjfAccountName;
	}
	
	public void setYjfAccountName(String yjfAccountName) {
		this.yjfAccountName = yjfAccountName;
	}
	
	public String getCertificateCard() {
		return this.certificateCard;
	}
	
	public void setCertificateCard(String certificateCard) {
		this.certificateCard = certificateCard;
	}
	
	public String getOutBizNo() {
		return this.outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundItemData [itemId=");
		builder.append(itemId);
		builder.append(", contractId=");
		builder.append(contractId);
		builder.append(", yjfAccountId=");
		builder.append(yjfAccountId);
		builder.append(", yjfAccountName=");
		builder.append(yjfAccountName);
		builder.append(", salesDate=");
		builder.append(salesDate);
		builder.append(", salesArea=");
		builder.append(salesArea);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", customerSex=");
		builder.append(customerSex);
		builder.append(", certificateCard=");
		builder.append(certificateCard);
		builder.append(", customerBirthday=");
		builder.append(customerBirthday);
		builder.append(", commodityType=");
		builder.append(commodityType);
		builder.append(", commodityBrand=");
		builder.append(commodityBrand);
		builder.append(", commodityAmount=");
		builder.append(commodityAmount);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", stagesNum=");
		builder.append(stagesNum);
		builder.append(", monthlyAmount=");
		builder.append(monthlyAmount);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", storeName=");
		builder.append(storeName);
		builder.append(", storeId=");
		builder.append(storeId);
		builder.append(", referrerName=");
		builder.append(referrerName);
		builder.append(", stageNum=");
		builder.append(stageNum);
		builder.append(", currentNum=");
		builder.append(currentNum);
		builder.append(", refundBank=");
		builder.append(refundBank);
		builder.append(", refundCardNumber=");
		builder.append(refundCardNumber);
		builder.append(", loanType=");
		builder.append(loanType);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", currentRefundAmount=");
		builder.append(currentRefundAmount);
		builder.append(", breachOfContractAmount=");
		builder.append(breachOfContractAmount);
		builder.append(", refundTime=");
		builder.append(refundTime);
		builder.append(", actualRefundTime=");
		builder.append(actualRefundTime);
		builder.append(", refundStatus=");
		builder.append(refundStatus);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
