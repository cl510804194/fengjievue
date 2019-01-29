/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 下午5:00:09 创建
 */
package com.yjf.esupplier.ws.hotel.info;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.hotel.enums.HotelRuleTypeEnum;

/**
 * 
 * 长包房设置信息
 * @author zhouwei
 * 
 */
public class HotelLongSetInfo implements Serializable {
	
	private static final long serialVersionUID = 7309878066680033218L;
	
	private long id;
	
	private long supplierId;
	
	private long productId;
	
	/** 房间类型 */
	private String type;
	
	/** 有效开始日期 */
	private Date beginDate;
	
	/** 有效结束日期 */
	private Date endDate;
	
	/** 定价规则 */
	private HotelRuleTypeEnum ruleType;
	
	/** 房间数量 */
	private long roomNum;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;

	/** 折扣明细 */
	private List<HotelLongDetailInfo> hotelLongDetailInfos;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public HotelRuleTypeEnum getRuleType() {
		return ruleType;
	}
	
	public void setRuleType(HotelRuleTypeEnum ruleType) {
		this.ruleType = ruleType;
	}
	
	public long getRoomNum() {
		return roomNum;
	}
	
	public void setRoomNum(long roomNum) {
		this.roomNum = roomNum;
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
	
	public List<HotelLongDetailInfo> getHotelLongDetailInfos() {
		return hotelLongDetailInfos;
	}
	
	public void setHotelLongDetailInfos(List<HotelLongDetailInfo> hotelLongDetailInfos) {
		this.hotelLongDetailInfos = hotelLongDetailInfos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelLongSetInfo [id=");
		builder.append(id);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", ruleType=");
		builder.append(ruleType);
		builder.append(", roomNum=");
		builder.append(roomNum);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", hotelLongDetailInfos=");
		builder.append(hotelLongDetailInfos);
		builder.append("]");
		return builder.toString();
	}
	

}
