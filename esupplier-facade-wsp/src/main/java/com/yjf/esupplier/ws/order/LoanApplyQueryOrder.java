package com.yjf.esupplier.ws.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.enums.LoanApplyStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class LoanApplyQueryOrder extends QueryPageBase {

	private static final long serialVersionUID = 4615369666746132177L;

	long applyId;
	long loanerId;
	String loanerName;
	String loanName;
	long loanAmount;
	int timeLimit;
	String loanerPhone;
	String loanerAddress;
	String loanerIdentity;
	Date applyTime;
//	LoanApplyStatusEnum status;
	List<LoanApplyStatusEnum> statusList;
	String userName;
	String loanPurpose;
	long guaranteeId;
	String guaranteeName;

	public long getApplyId() {
		return applyId;
	}

	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}

	public long getLoanerId() {
		return loanerId;
	}

	public void setLoanerId(long loanerId) {
		this.loanerId = loanerId;
	}

	public String getLoanerName() {
		return loanerName;
	}

	public void setLoanerName(String loanerName) {
		this.loanerName = loanerName;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getLoanerPhone() {
		return loanerPhone;
	}

	public void setLoanerPhone(String loanerPhone) {
		this.loanerPhone = loanerPhone;
	}

	public String getLoanerAddress() {
		return loanerAddress;
	}

	public void setLoanerAddress(String loanerAddress) {
		this.loanerAddress = loanerAddress;
	}

	public String getLoanerIdentity() {
		return loanerIdentity;
	}

	public void setLoanerIdentity(String loanerIdentity) {
		this.loanerIdentity = loanerIdentity;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

//	public LoanApplyStatusEnum getStatus() {
//		return status;
//	}
//
//	public void setStatus(LoanApplyStatusEnum status) {
//		this.status = status;
//	}
	
	public List<LoanApplyStatusEnum> getStatusList() {
		return statusList;
	}
	
	public void setStatusList(List<LoanApplyStatusEnum> statusList) {
		this.statusList = statusList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public long getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getGuaranteeName() {
		return guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanApplyQueryOrder [applyId=");
		builder.append(applyId);
		builder.append(", loanerId=");
		builder.append(loanerId);
		builder.append(", loanerName=");
		builder.append(loanerName);
		builder.append(", loanName=");
		builder.append(loanName);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", timeLimit=");
		builder.append(timeLimit);
		builder.append(", loanerPhone=");
		builder.append(loanerPhone);
		builder.append(", loanerAddress=");
		builder.append(loanerAddress);
		builder.append(", loanerIdentity=");
		builder.append(loanerIdentity);
		builder.append(", applyTime=");
		builder.append(applyTime);
		builder.append(", statusList=");
		builder.append(statusList);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", loanPurpose=");
		builder.append(loanPurpose);
		builder.append(", guaranteeId=");
		builder.append(guaranteeId);
		builder.append(", guaranteeName=");
		builder.append(guaranteeName);
		builder.append("]");
		return builder.toString();
	}


}
