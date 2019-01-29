package com.yjf.esupplier.ws.bill.result;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class BillSaveResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -2991004068247632474L;
	List<OrderInfo> orderInfos;
	
	String batchNo;
	
	Date ordersTime;

	public List<OrderInfo> getOrderInfos() {
		return this.orderInfos;
	}
	
	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public Date getOrdersTime() {
		return ordersTime;
	}
	
	public void setOrdersTime(Date ordersTime) {
		this.ordersTime = ordersTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillSaveResult [orderInfos=");
		builder.append(orderInfos);
		builder.append("]");
		return builder.toString();
	}
	
}
