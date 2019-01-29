/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.supplier.order;

import com.yjf.esupplier.ws.enums.SupplierRecommendTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

import java.util.Date;

/**
 * 
 * 
 * @Filename SupplierRecommendOrder.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author min
 * 
 * @Email yunchuan@yiji.com
 * 
 * @History <li>Author: yunchuan</li> <li>Date: 2016-10-09上午10:25:58</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */
public class SupplierRecommendOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 6995296646753129241L;
	
	long supplierRecommendId;

	long supplierId;

	long userId;
	
	Date beginDate;
	
	Date endDate;

	String belongTo;
	
	/*商户推荐分类*/
	SupplierRecommendTypeEnum recommendType;
	
	/**
	 * 不为空，按照正常排序（景区 商户 商户新增日期）空就是随机排序
	 */
	String orderNormal;

	public long getSupplierRecommendId() {
		return supplierRecommendId;
	}

	public void setSupplierRecommendId(long supplierRecommendId) {
		this.supplierRecommendId = supplierRecommendId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public SupplierRecommendTypeEnum getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(SupplierRecommendTypeEnum recommendType) {
		this.recommendType = recommendType;
	}

	public String getOrderNormal() {
		return orderNormal;
	}

	public void setOrderNormal(String orderNormal) {
		this.orderNormal = orderNormal;
	}

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("SupplierRecommendOrder{");
		sb.append("supplierRecommendId=").append(supplierRecommendId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", userId=").append(userId);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", belongTo='").append(belongTo).append('\'');
		sb.append(", recommendType=").append(recommendType);
		sb.append(", orderNormal='").append(orderNormal).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
