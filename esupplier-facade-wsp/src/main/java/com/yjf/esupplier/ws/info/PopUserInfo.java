/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.info;


import com.yjf.esupplier.ws.enums.PopUserTypeEnum;

import java.util.Date;

/**
 *
 *
 * @Filename ProductUserCollectInfo.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-17上午10:39:37</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
public class PopUserInfo {

	/*ID*/
	private long popUserId;
	/*攻略信息ID*/
	private long popId;
	/*用户ID*/
	private long userId;
	/*信息分类：收藏|点赞*/
	private PopUserTypeEnum type;

	private Date rawAddTime;

	private Date rawUpdateTime;

	private PopInfo popInfo;


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public PopUserTypeEnum getType() {
		return type;
	}

	public void setType(PopUserTypeEnum type) {
		this.type = type;
	}

	public long getPopId() {
		return popId;
	}

	public void setPopId(long popId) {
		this.popId = popId;
	}

	public long getPopUserId() {
		return popUserId;
	}

	public void setPopUserId(long popUserId) {
		this.popUserId = popUserId;
	}

	public PopInfo getPopInfo() {
		return popInfo;
	}

	public void setPopInfo(PopInfo popInfo) {
		this.popInfo = popInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductUserCollectInfo [popUserId=");
		builder.append(popUserId);
		builder.append(", popId=");
		builder.append(popId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
}
