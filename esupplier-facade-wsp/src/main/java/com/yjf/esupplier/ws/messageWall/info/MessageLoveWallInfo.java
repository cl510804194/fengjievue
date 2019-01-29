/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 下午5:57:57 创建
 */
package com.yjf.esupplier.ws.messageWall.info;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author zhouwei
 *
 */
public class MessageLoveWallInfo implements Serializable {
	
	private static final long serialVersionUID = 3908923852146229327L;
	
	private long id;
	
	private long userId;
	
	private String userName;
	
	private String boy;
	
	private String girl;
	
	private String message;
	
	private String image;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public String getBoy() {
		return boy;
	}
	
	public void setBoy(String boy) {
		this.boy = boy;
	}
	
	public String getGirl() {
		return girl;
	}
	
	public void setGirl(String girl) {
		this.girl = girl;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageLoveWallInfo [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", boy=");
		builder.append(boy);
		builder.append(", girl=");
		builder.append(girl);
		builder.append(", message=");
		builder.append(message);
		builder.append(", image=");
		builder.append(image);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}

}
