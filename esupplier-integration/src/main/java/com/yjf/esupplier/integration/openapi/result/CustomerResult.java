/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * @Filename CustomerResult.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class CustomerResult extends EsupplierBaseResult {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 3284687900762814235L;
	/**
	 * 资金账户id
	 */
	String userId;
	boolean isExsit = false;
	/**
	 * 跳转请求返回url
	 */
	String url;
	
	String loginId;
	/**
	 * 签约开户号
	 */
	String subscribeCode;
	
	String userAccountName;
	
	public String getUserAccountName() {
		return userAccountName;
	}

	public void setUserAccountName(String userAccountName) {
		this.userAccountName = userAccountName;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public boolean isExsit() {
		return isExsit;
	}
	
	public void setExsit(boolean isExsit) {
		this.isExsit = isExsit;
	}
	
	@Override
	public String getUrl() {
		return url;
	}
	
	@Override
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getLoginId() {
		return this.loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getSubscribeCode() {
		return this.subscribeCode;
	}
	
	public void setSubscribeCode(String subscribeCode) {
		this.subscribeCode = subscribeCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerResult [userId=");
		builder.append(userId);
		builder.append(", isExsit=");
		builder.append(isExsit);
		builder.append("]");
		return builder.toString();
	}
	
}
