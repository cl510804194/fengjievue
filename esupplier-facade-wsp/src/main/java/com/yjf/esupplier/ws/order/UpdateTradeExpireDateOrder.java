package com.yjf.esupplier.ws.order;

import java.util.Date;

import org.springframework.util.Assert;

public class UpdateTradeExpireDateOrder extends TradeProcessOrder {
	
	private static final long serialVersionUID = 8583244956723899406L;
	Date expireDate;
	
	@Override
	public void check() {
		validateNotNull(expireDate, "还款时间");
		Assert.isTrue(new Date().before(expireDate), "还款时间不能小于当前时间");
		super.check();
	}
	
	public Date getExpireDate() {
		return this.expireDate;
	}
	
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateTradeexpireDateOrder [expireDate=");
		builder.append(expireDate);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
