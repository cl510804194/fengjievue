/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.hotel.info;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;

import java.io.Serializable;
import java.util.Date;

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
public class HotelDiscountInfo implements Serializable {

	private static final long serialVersionUID = 5965230272234045319L;

	private long hotelDiscountId;

	private long scenicId;
	
	private String scenicName;

	private HotelTypeEnum type;

	private String setTime;

	private int discountBegin;

	private int discountEnd;

	private Date rawAddTime;

	private Date rawUpdateTime;

    //========== getters and setters ==========

	public long getHotelDiscountId() {
		return hotelDiscountId;
	}
	
	public void setHotelDiscountId(long hotelDiscountId) {
		this.hotelDiscountId = hotelDiscountId;
	}

	public long getScenicId() {
		return scenicId;
	}
	
	public void setScenicId(long scenicId) {
		this.scenicId = scenicId;
	}

	public String getSetTime() {
		return setTime;
	}
	
	public void setSetTime(String setTime) {
		this.setTime = setTime;
	}

	public int getDiscountBegin() {
		return discountBegin;
	}
	
	public void setDiscountBegin(int discountBegin) {
		this.discountBegin = discountBegin;
	}

	public int getDiscountEnd() {
		return discountEnd;
	}
	
	public void setDiscountEnd(int discountEnd) {
		this.discountEnd = discountEnd;
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

	public HotelTypeEnum getType() {
		return type;
	}

	public void setType(HotelTypeEnum type) {
		this.type = type;
	}

	public String getScenicName() {
		return scenicName;
	}

	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}
	@Override
	public String toString() {
		return "HotelDiscountInfo{" +
				"hotelDiscountId=" + hotelDiscountId +
				", scenicId=" + scenicId +
				", type='" + type + '\'' +
				", setTime=" + setTime +
				", discountBegin=" + discountBegin +
				", discountEnd=" + discountEnd +
				", rawAddTime=" + rawAddTime +
				", rawUpdateTime=" + rawUpdateTime 	+	
				'}';
	}


}
