package com.yjf.esupplier.ws.bill.info;

public class OrderFlowStatusCountInfo {
	/**
	 * 等待收货
	 */
	long waitPayCount;
	/**
	 * 等待发货
	 */
	long waitForDeliveryCount;
	/**
	 * 等待收货
	 */
	long waitConfirmReceiptCount;
	/**
	 * 等待评价
	 */
	long waitEvaluateCount;
	
	public long getWaitPayCount() {
		return this.waitPayCount;
	}
	
	public void setWaitPayCount(long waitPayCount) {
		this.waitPayCount = waitPayCount;
	}
	
	public long getWaitForDeliveryCount() {
		return this.waitForDeliveryCount;
	}
	
	public void setWaitForDeliveryCount(long waitForDeliveryCount) {
		this.waitForDeliveryCount = waitForDeliveryCount;
	}
	
	public long getWaitConfirmReceiptCount() {
		return this.waitConfirmReceiptCount;
	}
	
	public void setWaitConfirmReceiptCount(long waitConfirmReceiptCount) {
		this.waitConfirmReceiptCount = waitConfirmReceiptCount;
	}
	
	public long getWaitEvaluateCount() {
		return this.waitEvaluateCount;
	}
	
	public void setWaitEvaluateCount(long waitEvaluateCount) {
		this.waitEvaluateCount = waitEvaluateCount;
	}
	
}
