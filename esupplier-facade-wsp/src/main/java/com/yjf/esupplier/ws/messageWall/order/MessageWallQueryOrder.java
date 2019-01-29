/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 上午9:38:22 创建
 */
package com.yjf.esupplier.ws.messageWall.order;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

/**
 *
 *
 * @author zhouwei
 *
 */
public class MessageWallQueryOrder extends QueryPageBase {
	
	private static final long serialVersionUID = -4409232850793060304L;
	
	private long id;

	private long userId;
	
	private String userName;

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
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageWallQueryOrder [id=");
		builder.append(id);
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
