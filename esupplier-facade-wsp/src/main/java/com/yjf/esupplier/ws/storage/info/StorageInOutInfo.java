package com.yjf.esupplier.ws.storage.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.storage.enums.StorageBillTypeEnum;

public class StorageInOutInfo implements Serializable {
	private static final long serialVersionUID = -8582433272854251996L;
	
	private long id;
	
	private String billNo;
	
	private Date billTime;
	
	private StorageBillTypeEnum billType;
	
	private long handleMan;
	
	private Date handleTime;
	
	private Date rawUpdateTime;
	
	private Date rawAddTime;
	
	private long billAmount;
	long productId;
	String productName;
	String smallPicPath;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getBillTime() {
		return billTime;
	}
	
	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}
	
	public StorageBillTypeEnum getBillType() {
		return billType;
	}
	
	public void setBillType(StorageBillTypeEnum billType) {
		this.billType = billType;
	}
	
	public long getHandleMan() {
		return handleMan;
	}
	
	public void setHandleMan(long handleMan) {
		this.handleMan = handleMan;
	}
	
	public Date getHandleTime() {
		return handleTime;
	}
	
	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}
	
	public long getBillAmount() {
		return this.billAmount;
	}
	
	public void setBillAmount(long billAmount) {
		this.billAmount = billAmount;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getSmallPicPath() {
		return this.smallPicPath;
	}
	
	public void setSmallPicPath(String smallPicPath) {
		this.smallPicPath = smallPicPath;
	}
	
	public String getBillNo() {
		return this.billNo;
	}
	
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StorageInOutInfo [id=");
		builder.append(id);
		builder.append(", billNo=");
		builder.append(billNo);
		builder.append(", billTime=");
		builder.append(billTime);
		builder.append(", billType=");
		builder.append(billType);
		builder.append(", handleMan=");
		builder.append(handleMan);
		builder.append(", handleTime=");
		builder.append(handleTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", billAmount=");
		builder.append(billAmount);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", smallPicPath=");
		builder.append(smallPicPath);
		builder.append("]");
		return builder.toString();
	}
}
