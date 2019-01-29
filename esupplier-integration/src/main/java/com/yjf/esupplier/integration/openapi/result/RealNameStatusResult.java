/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.integration.openapi.enums.RealNameBusinessStatusEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 *                       
 * @Filename RealNameStatusResult.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author qichunhai
 *
 * @Email qchunhai@yiji.com
 *       
 * @History
 *<li>Author: qichunhai</li>
 *<li>Date: 2014-4-7</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class RealNameStatusResult extends EsupplierBaseResult {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 5998956869098507976L;
	RealNameBusinessStatusEnum	businessStatusEnum	= RealNameBusinessStatusEnum.UNAUTHERIZED;
	private String				msg;
	
	public RealNameBusinessStatusEnum getBusinessStatusEnum() {
		return businessStatusEnum;
	}
	
	public void setBusinessStatusEnum(RealNameBusinessStatusEnum businessStatusEnum) {
		this.businessStatusEnum = businessStatusEnum;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RealNameStatusResult [businessStatusEnum=");
		builder.append(businessStatusEnum);
		builder.append(", msg=");
		builder.append(msg);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
