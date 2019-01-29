package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;

import com.yjf.esupplier.ws.enums.YrdAuthTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class LoanAuthRecordQueryOrder extends ValidateOrderBase {
	private static final long serialVersionUID = 3272704900366647069L;
	long baseId;
	long authUserId;
	long loanDemandId;
	YrdAuthTypeEnum authType;
	Date startTime;
	Date endTime;
	
	public long getBaseId() {
		return this.baseId;
	}
	
	public void setBaseId(long baseId) {
		this.baseId = baseId;
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
	
	public Date getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
