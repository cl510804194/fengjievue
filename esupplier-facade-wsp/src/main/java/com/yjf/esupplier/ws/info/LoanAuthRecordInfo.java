package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.enums.YrdAuthTypeEnum;

public class LoanAuthRecordInfo implements Serializable {
	private static final long serialVersionUID = 8941968802247505610L;
	
	private String tbBaseId;
	
	private long authUserId;
	
	private long loanDemandId;
	
	private YrdAuthTypeEnum authType;
	
	private Date authTime;
	
	private String note;
	
	private String rem1;
	
	public String getTbBaseId() {
		return this.tbBaseId;
	}
	
	public void setTbBaseId(String tbBaseId) {
		this.tbBaseId = tbBaseId;
	}
	
	public long getAuthUserId() {
		return this.authUserId;
	}
	
	public void setAuthUserId(long authUserId) {
		this.authUserId = authUserId;
	}
	
	public long getLoanDemandId() {
		return this.loanDemandId;
	}
	
	public void setLoanDemandId(long loanDemandId) {
		this.loanDemandId = loanDemandId;
	}
	
	public YrdAuthTypeEnum getAuthType() {
		return this.authType;
	}
	
	public void setAuthType(YrdAuthTypeEnum authType) {
		this.authType = authType;
	}
	
	public Date getAuthTime() {
		return this.authTime;
	}
	
	public void setAuthTime(Date authTime) {
		this.authTime = authTime;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getRem1() {
		return this.rem1;
	}
	
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanAuthRecordInfo [tbBaseId=");
		builder.append(tbBaseId);
		builder.append(", authUserId=");
		builder.append(authUserId);
		builder.append(", loanDemandId=");
		builder.append(loanDemandId);
		builder.append(", authType=");
		builder.append(authType);
		builder.append(", authTime=");
		builder.append(authTime);
		builder.append(", note=");
		builder.append(note);
		builder.append(", rem1=");
		builder.append(rem1);
		builder.append("]");
		return builder.toString();
	}
	
}
