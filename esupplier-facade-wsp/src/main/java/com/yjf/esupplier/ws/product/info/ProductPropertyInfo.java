/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.product.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.enums.PropertyTypeEnum;

/**
 * 商品属性信息
 *
 * @Filename ProductPropertyInfo.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-29下午4:41:25</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
public class ProductPropertyInfo implements Serializable {

	private static final long serialVersionUID = 5965230272234045319L;
	
	private long propertyId;

	private String propertyCode;

	private String propertyName;

	private PropertyTypeEnum propertyType;

	private String productType;

	private String productTypeName;

	private Date rawAddTime;

	private Date rawUpdateTime;
	
	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

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

	public PropertyTypeEnum getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyTypeEnum propertyType) {
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

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductPropertyInfo [propertyId=");
		builder.append(propertyId);
		builder.append(", propertyCode=");
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
