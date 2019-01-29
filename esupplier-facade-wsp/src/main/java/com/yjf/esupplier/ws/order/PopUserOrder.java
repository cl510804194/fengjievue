/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.order;

import com.yjf.esupplier.ws.enums.PopUserTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;
import org.springframework.util.Assert;

import java.util.Date;

/**
 *
 *
 * @Filename ProductUserOrder.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-17上午10:25:58</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
public class PopUserOrder extends QueryPageBase {

	private static final long serialVersionUID = 6995296646753129241L;

	long popUserId;

	long popId;

	long userId;

	String popIds;

	/*信息分类：收藏|点赞*/
	private PopUserTypeEnum type;

	Date rawAddTime;

	Date rawUpdateTime;
	
	Date beginDate;
	
	Date endDate;


	public long getPopUserId() {
		return popUserId;
	}

	public void setPopUserId(long popUserId) {
		this.popUserId = popUserId;
	}

	public long getPopId() {
		return popId;
	}

	public void setPopId(long popId) {
		this.popId = popId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getPopIds() {
		return popIds;
	}

	public void setPopIds(String popIds) {
		this.popIds = popIds;
	}

	public PopUserTypeEnum getType() {
		return type;
	}

	public void setType(PopUserTypeEnum type) {
		this.type = type;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductUserOrder [popUserId=");
		builder.append(popUserId);
		builder.append(", popId=");
		builder.append(popId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", popId in ( ");
		builder.append(popIds);
		builder.append(")");
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}
}
