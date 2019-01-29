/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.order;

import java.util.Date;

import org.springframework.util.Assert;

import com.yjf.common.service.Order;

/**
 *
 *
 * @Filename ProductPropertyAddOrder.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-29下午4:56:38</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
public class ProductPropertyAddOrder implements Order {

	private static final long serialVersionUID = -7241895295671953485L;

	private String propertyCode;

	private String propertyName;
	
	private String propertyType;

	private String productType;

	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
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


	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public void check() {
		Assert.hasText(propertyName, "属性名称不能为空");
		Assert.hasText(propertyType, "属性类型不能为空");
	}

	@Override
	public String getGid() {
		return null;
	}

	@Override
	public void setGid(String gid) {
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductPropertyAddOrder [propertyCode=");
		builder.append(propertyCode);
		builder.append(", propertyName=");
		builder.append(propertyName);
		builder.append(", propertyType=");
		builder.append(propertyType);
		builder.append(", productType=");
		builder.append(productType);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}

}
