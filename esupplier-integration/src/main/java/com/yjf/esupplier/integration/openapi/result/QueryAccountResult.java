/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * @Filename QueryAccountResult.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class QueryAccountResult extends EsupplierBaseResult {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1113927000041346504L;
	YjfAccountInfo yjfAccountInfo = new YjfAccountInfo();
	
	public YjfAccountInfo getYjfAccountInfo() {
		return yjfAccountInfo;
	}
	
	public void setYjfAccountInfo(YjfAccountInfo yjfAccountInfo) {
		this.yjfAccountInfo = yjfAccountInfo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryAccountResult [yjfAccountInfo=");
		builder.append(yjfAccountInfo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
