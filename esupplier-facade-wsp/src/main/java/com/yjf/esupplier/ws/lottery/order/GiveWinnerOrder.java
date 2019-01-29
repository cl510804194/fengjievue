package com.yjf.esupplier.ws.lottery.order;

import com.yjf.esupplier.ws.lottery.enums.WinnerStatusEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class GiveWinnerOrder extends ProcessOrder {
	private long winnerId;
	private WinnerStatusEnum status;
	private String expressNo;
	
	@Override
	public void check() {
		validateHasZore(winnerId, "活动事例id");
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("GiveWinnerOrder=[");
		sb.append("winnerId=").append(winnerId);
		sb.append(", status=").append(status);
		sb.append(", expressNo='").append(expressNo);
		sb.append(']');
		return sb.toString();
	}
	
	public long getWinnerId() {
		return winnerId;
	}
	
	public void setWinnerId(long winnerId) {
		this.winnerId = winnerId;
	}
	
	public WinnerStatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(WinnerStatusEnum status) {
		this.status = status;
	}
	
	public String getExpressNo() {
		return expressNo;
	}
	
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
}
