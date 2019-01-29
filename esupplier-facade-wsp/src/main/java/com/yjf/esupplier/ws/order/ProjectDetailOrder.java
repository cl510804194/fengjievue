package com.yjf.esupplier.ws.order;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class ProjectDetailOrder extends ValidateOrderBase  implements Serializable{
	private static final long serialVersionUID = -7604639288415335656L;
	
	private long demandId;

	private String companyInfo;
	private String loanerInfo;

	private String projectInfo;

	private String moneyUse;

	private String creditInfo;

	private String repayInfo;

	private String measuresInfo;

	private String[] auditDataType;

	private String auditData1;

	private Date addTime;

	private String auditData2;

	private String auditData3;
	
	public long getDemandId() {
		return demandId;
	}

	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}

	public String getLoanerInfo() {
		return loanerInfo;
	}

	public void setLoanerInfo(String loanerInfo) {
		this.loanerInfo = loanerInfo;
	}

	public String getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(String projectInfo) {
		this.projectInfo = projectInfo;
	}

	public String getMoneyUse() {
		return moneyUse;
	}

	public void setMoneyUse(String moneyUse) {
		this.moneyUse = moneyUse;
	}

	public String getCreditInfo() {
		return creditInfo;
	}

	public void setCreditInfo(String creditInfo) {
		this.creditInfo = creditInfo;
	}

	public String getRepayInfo() {
		return repayInfo;
	}

	public void setRepayInfo(String repayInfo) {
		this.repayInfo = repayInfo;
	}

	public String getMeasuresInfo() {
		return measuresInfo;
	}

	public void setMeasuresInfo(String measuresInfo) {
		this.measuresInfo = measuresInfo;
	}

	public String[] getAuditDataType() {
		return auditDataType;
	}

	public void setAuditDataType(String[] auditDataType) {
		this.auditDataType = auditDataType;
	}

	public String getAuditData1() {
		return auditData1;
	}

	public void setAuditData1(String auditData1) {
		this.auditData1 = auditData1;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getAuditData2() {
		return auditData2;
	}

	public void setAuditData2(String auditData2) {
		this.auditData2 = auditData2;
	}

	public String getAuditData3() {
		return auditData3;
	}

	public void setAuditData3(String auditData3) {
		this.auditData3 = auditData3;
	}
	
	public String getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectDetailOrder [demandId=");
		builder.append(demandId);
		builder.append(", companyInfo=");
		builder.append(companyInfo);
		builder.append(", loanerInfo=");
		builder.append(loanerInfo);
		builder.append(", projectInfo=");
		builder.append(projectInfo);
		builder.append(", moneyUse=");
		builder.append(moneyUse);
		builder.append(", creditInfo=");
		builder.append(creditInfo);
		builder.append(", repayInfo=");
		builder.append(repayInfo);
		builder.append(", measuresInfo=");
		builder.append(measuresInfo);
		builder.append(", auditDataType=");
		builder.append(Arrays.toString(auditDataType));
		builder.append(", auditData1=");
		builder.append(auditData1);
		builder.append(", addTime=");
		builder.append(addTime);
		builder.append(", auditData2=");
		builder.append(auditData2);
		builder.append(", auditData3=");
		builder.append(auditData3);
		builder.append("]");
		return builder.toString();
	}
	
}
