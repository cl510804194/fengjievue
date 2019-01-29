package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;

public class GuaranteeAmountInfo implements Serializable {
	
	private static final long serialVersionUID = -6521859966522253112L;
	Money guaranteeAmount = new Money();
	Date lastDate = new Date();
	
	public Money getGuaranteeAmount() {
		return this.guaranteeAmount;
	}
	
	public void setGuaranteeAmount(Money guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}
	
	public Date getLastDate() {
		return this.lastDate;
	}
	
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuaranteeAmountInfo [guaranteeAmount=");
		builder.append(guaranteeAmount);
		builder.append(", lastDate=");
		builder.append(lastDate);
		builder.append("]");
		return builder.toString();
	}
	
}
