package com.yjf.esupplier.ws.storage.info;

import java.io.Serializable;
import java.util.Date;

public class StorageInOutDetailInfo implements Serializable {
	
	private static final long serialVersionUID = 2857538694670951874L;
	private long id;
	
	private long parentId;
	
	private long productId;
	
	private long billAmount;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getParentId() {
		return this.parentId;
	}
	
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getBillAmount() {
		return this.billAmount;
	}
	
	public void setBillAmount(long billAmount) {
		this.billAmount = billAmount;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StorageInOutDetailInfo [id=");
		builder.append(id);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", billAmount=");
		builder.append(billAmount);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}