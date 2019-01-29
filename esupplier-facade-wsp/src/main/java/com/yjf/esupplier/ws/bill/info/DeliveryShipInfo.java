package com.yjf.esupplier.ws.bill.info;

import java.util.Date;

public class DeliveryShipInfo {
	private long id;
	
	private long billNo;
	
	private long logisticsId;
	
	private String logisticsName;
	
	private String deliveryId;
	
	private String logisticsMan;
	
	private Date logisticsTime;
	
	private String deliverer;
	
	private Date deliveryDate;
	
	private String status;
	
	private String createMan;
	
	private Date createTime;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	private LogisticInfo logistics;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getBillNo() {
		return this.billNo;
	}
	
	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}
	
	public long getLogisticsId() {
		return this.logisticsId;
	}
	
	public void setLogisticsId(long logisticsId) {
		this.logisticsId = logisticsId;
	}
	
	public String getLogisticsName() {
		return this.logisticsName;
	}
	
	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}
	
	public String getDeliveryId() {
		return this.deliveryId;
	}
	
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	public String getLogisticsMan() {
		return this.logisticsMan;
	}
	
	public void setLogisticsMan(String logisticsMan) {
		this.logisticsMan = logisticsMan;
	}
	
	public Date getLogisticsTime() {
		return this.logisticsTime;
	}
	
	public void setLogisticsTime(Date logisticsTime) {
		this.logisticsTime = logisticsTime;
	}
	
	public String getDeliverer() {
		return this.deliverer;
	}
	
	public void setDeliverer(String deliverer) {
		this.deliverer = deliverer;
	}
	
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}
	
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCreateMan() {
		return this.createMan;
	}
	
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public LogisticInfo getLogistics() {
		return this.logistics;
	}
	
	public void setLogistics(LogisticInfo logistics) {
		this.logistics = logistics;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryShipInfo [id=");
		builder.append(id);
		builder.append(", billNo=");
		builder.append(billNo);
		builder.append(", logisticsId=");
		builder.append(logisticsId);
		builder.append(", logisticsName=");
		builder.append(logisticsName);
		builder.append(", deliveryId=");
		builder.append(deliveryId);
		builder.append(", logisticsMan=");
		builder.append(logisticsMan);
		builder.append(", logisticsTime=");
		builder.append(logisticsTime);
		builder.append(", deliverer=");
		builder.append(deliverer);
		builder.append(", deliveryDate=");
		builder.append(deliveryDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createMan=");
		builder.append(createMan);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", logistics=");
		builder.append(logistics);
		builder.append("]");
		return builder.toString();
	}
	
}
