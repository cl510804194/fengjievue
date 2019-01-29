package com.yjf.esupplier.ws.bill.order;

import java.util.Date;

import com.yjf.esupplier.ws.order.ProcessOrder;

public class ScanningQRcodeOrder extends ProcessOrder {
	
	private static final long serialVersionUID = -4413940940165783879L;
	
	private long merchantId;
	
	private Date createDate;
	
	public long getMerchantId() {
		return this.merchantId;
	}
	
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScanningQRcodeOrder [merchantId=");
		builder.append(merchantId);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append("]");
		return builder.toString();
	}
	
}
