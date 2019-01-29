package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;

public class UpdateFileUploadUrlOrder extends TradeProcessOrder {
	
	private static final long serialVersionUID = 7584241485620130027L;
	String newUrl;
	Money loanAmout;
	String audit;
	
	public String getNewUrl() {
		return this.newUrl;
	}
	
	public void setNewUrl(String newUrl) {
		this.newUrl = newUrl;
	}
	
	public Money getLoanAmout() {
		return this.loanAmout;
	}
	
	public void setLoanAmout(Money loanAmout) {
		this.loanAmout = loanAmout;
	}
	
	public String getAudit() {
		return this.audit;
	}
	
	public void setAudit(String audit) {
		this.audit = audit;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateFileUploadUrlOrder [newUrl=");
		builder.append(newUrl);
		builder.append(", loanAmout=");
		builder.append(loanAmout);
		builder.append(", audit=");
		builder.append(audit);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
