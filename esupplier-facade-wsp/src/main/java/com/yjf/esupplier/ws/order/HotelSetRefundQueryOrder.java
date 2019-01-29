/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

import org.springframework.util.Assert;

import java.util.Date;

/**
 *
 *
 * @Filename HotelStockProductOrder.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email yunchuan@yiji.com
 *
 */
public class HotelSetRefundQueryOrder extends QueryPageBase  {

	private static final long serialVersionUID = -7241895295671953485L;
	private long hotelRefundId;

	private int userGrade;
	
	private String userGrades;

	private String refundTime;

	private long batchNo;

	private Date rawAddTime;

	private Date rawUpdateTime;

	@Override
	public void check() {
		super.check();
	};
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
	
	@Override
	public String toString() {
		return "HotelSetRefundInfo{" +
				"hotelRefundId=" + hotelRefundId +
				", userGrade=" + userGrade +
				", refundTime='" + refundTime + '\'' +
				", batchNo=" + batchNo +
				",userGrades" + userGrades +
				", rawAddTime=" + rawAddTime +
				", rawUpdateTime=" + rawUpdateTime +
				'}';
	}
}
