package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

public class ProfitAsignInfo implements Serializable {
	private static final long serialVersionUID = 8630635245062712232L;
	
	private long tblBaseId;
	
	private long receiveId;
	
	private long distributionId;
	
	private double distributionQuota;
	
	private String note;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	private String rem1;
	
	public long getTblBaseId() {
		return this.tblBaseId;
	}
	
	public void setTblBaseId(long tblBaseId) {
		this.tblBaseId = tblBaseId;
	}
	
	public long getReceiveId() {
		return this.receiveId;
	}
	
	public void setReceiveId(long receiveId) {
		this.receiveId = receiveId;
	}
	
	public long getDistributionId() {
		return this.distributionId;
	}
	
	public void setDistributionId(long distributionId) {
		this.distributionId = distributionId;
	}
	
	public double getDistributionQuota() {
		return this.distributionQuota;
	}
	
	public void setDistributionQuota(double distributionQuota) {
		this.distributionQuota = distributionQuota;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
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
	
	public String getRem1() {
		return this.rem1;
	}
	
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfitAsignInfo [tblBaseId=");
		builder.append(tblBaseId);
		builder.append(", receiveId=");
		builder.append(receiveId);
		builder.append(", distributionId=");
		builder.append(distributionId);
		builder.append(", distributionQuota=");
		builder.append(distributionQuota);
		builder.append(", note=");
		builder.append(note);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", rem1=");
		builder.append(rem1);
		builder.append("]");
		return builder.toString();
	}
	
}
