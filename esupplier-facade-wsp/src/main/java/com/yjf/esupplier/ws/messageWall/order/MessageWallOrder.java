/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 下午4:48:40 创建
 */
package com.yjf.esupplier.ws.messageWall.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 *
 *
 * @author zhouwei
 *
 */
public class MessageWallOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = -4688572052702818804L;

	private String title;
	
	private long userId;
	
	private String userName;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageWallOrder [title=");
		builder.append(title);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
