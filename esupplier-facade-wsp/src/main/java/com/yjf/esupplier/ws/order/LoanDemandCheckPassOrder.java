package com.yjf.esupplier.ws.order;

import java.util.Date;

public class LoanDemandCheckPassOrder extends TradeProcessOrder {
	
	private static final long serialVersionUID = 2556816665282890184L;
	Date publishDate;
	
	public Date getPublishDate() {
		return this.publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandCheckPassOrder [publishDate=");
		builder.append(publishDate);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
