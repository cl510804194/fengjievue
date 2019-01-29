/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.hotel.info;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 酒店折扣信息
 *
 * @Filename HotelStockInfo.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author lihu
 *
 * @Email dgetian@yiji.com
 *
 */
public class HotelSetRefundInfo implements Serializable {

	private static final long serialVersionUID = 5965230272234045319L;

	private long hotelRefundId;

	private int userGrade;
	
	private String userGrades;
	
	private String showUserGrades;

	private List userGradeList;
	
	private String refundTime;

	private long batchNo;

	private Date rawAddTime;

	private Date rawUpdateTime;

    //========== getters and setters ==========

	public long getHotelRefundId() {
		return hotelRefundId;
	}
	
	public void setHotelRefundId(long hotelRefundId) {
		this.hotelRefundId = hotelRefundId;
	}

	public int getUserGrade() {
		return userGrade;
	}
	
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}

	public String getRefundTime() {
		return refundTime;
	}
	
	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public long getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(long batchNo) {
		this.batchNo = batchNo;
	}

	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}

	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}

	public String getUserGrades() {
		return userGrades;
	}

	public void setUserGrades(String userGrades) {
		this.userGrades = userGrades;
	}

	public String getShowUserGrades() {
		return showUserGrades;
	}
	
	public void setShowUserGrades(String showUserGrades) {
		this.showUserGrades = showUserGrades;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelSetRefundInfo [hotelRefundId=");
		builder.append(hotelRefundId);
		builder.append(", userGrade=");
		builder.append(userGrade);
		builder.append(", userGrades=");
		builder.append(userGrades);
		builder.append(", showUserGrades=");
		builder.append(showUserGrades);
		builder.append(", userGradeList=");
		builder.append(userGradeList);
		builder.append(", refundTime=");
		builder.append(refundTime);
		builder.append(", batchNo=");
		builder.append(batchNo);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}

	public List getUserGradeList() {
		return userGradeList;
	}

	public void setUserGradeList(List userGradeList) {
		this.userGradeList = userGradeList;
	}



}
