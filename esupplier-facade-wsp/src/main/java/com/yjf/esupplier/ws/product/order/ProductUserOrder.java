/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.product.order;

import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.CollectionStateEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

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
public class ProductUserOrder extends QueryPageBase {

	private static final long serialVersionUID = 6995296646753129241L;

	long productUserId;

	long productId;

	long userId;
	
	long supplierId;

	String productIds;

	Date rawAddTime;

	Date rawUpdateTime;
	
	Date beginDate;
	
	Date endDate;

	BooleanEnum hotels ;

	CollectionStateEnum collectionStateEnum;
	
	public CollectionStateEnum getCollectionStateEnum() {
		return collectionStateEnum;
	}

	public void setCollectionStateEnum(CollectionStateEnum collectionStateEnum) {
		this.collectionStateEnum = collectionStateEnum;
	}

	public long getProductUserId() {
		return productUserId;
	}

	public void setProductUserId(long productUserId) {
		this.productUserId = productUserId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
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
	
	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public BooleanEnum getHotels() {
		return hotels;
	}

	public void setHotels(BooleanEnum hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "ProductUserOrder{" +
				"productUserId=" + productUserId +
				", productId=" + productId +
				", userId=" + userId +
				", supplierId=" + supplierId +
				", productIds='" + productIds + '\'' +
				", rawAddTime=" + rawAddTime +
				", rawUpdateTime=" + rawUpdateTime +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				", hotels=" + hotels +
				", collectionStateEnum=" + collectionStateEnum +
				'}';
	}
}
