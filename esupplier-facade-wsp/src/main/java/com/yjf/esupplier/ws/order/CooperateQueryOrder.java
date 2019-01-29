package com.yjf.esupplier.ws.order;

import java.util.Date;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

//合作机构

public class CooperateQueryOrder extends QueryPageBase{

	private static final long serialVersionUID = -5644202651471742815L;

	long cooId;

	String cooName;

	String cooHerf;

	String picName;

	String picUrl;

	String picPhyUrl;

	Date addTime;

	int sortNo;
	

	public long getCooId() {
		return this.cooId;
	}



	public void setCooId(long cooId) {
		this.cooId = cooId;
	}



	public String getCooName() {
		return this.cooName;
	}



	public void setCooName(String cooName) {
		this.cooName = cooName;
	}



	public String getCooHerf() {
		return this.cooHerf;
	}



	public void setCooHerf(String cooHerf) {
		this.cooHerf = cooHerf;
	}



	public String getPicName() {
		return this.picName;
	}



	public void setPicName(String picName) {
		this.picName = picName;
	}



	public String getPicUrl() {
		return this.picUrl;
	}



	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}



	public String getPicPhyUrl() {
		return this.picPhyUrl;
	}



	public void setPicPhyUrl(String picPhyUrl) {
		this.picPhyUrl = picPhyUrl;
	}



	public Date getAddTime() {
		return this.addTime;
	}



	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	
	
	public int getSortNo() {
		return this.sortNo;
	}



	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CooperateQueryOrder [cooId=");
		builder.append(cooId);
		builder.append(", cooName=");
		builder.append(cooName);
		builder.append(", cooHerf=");
		builder.append(cooHerf);
		builder.append(", picName=");
		builder.append(picName);
		builder.append(", picUrl=");
		builder.append(picUrl);
		builder.append(", picPhyUrl=");
		builder.append(picPhyUrl);
		builder.append(", addTime=");
		builder.append(addTime);
		builder.append(", sortNo=");
		builder.append(sortNo);
		builder.append("]");
		return builder.toString();
	}

}
