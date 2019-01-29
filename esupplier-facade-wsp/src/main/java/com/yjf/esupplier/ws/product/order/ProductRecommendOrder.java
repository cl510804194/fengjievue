/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.product.order;

import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

/**
 * 
 * 
 * @Filename ProductRecommendOrder.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author min
 * 
 * @Email oyangnuo@yiji.com
 * 
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-17上午10:25:58</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */
public class ProductRecommendOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 6995296646753129241L;
	
	long productRecommendId;
	
	long productId;
	
	long supplierId;
	
	long userId;
	
	String productName;
	
	Date rawAddTime;
	
	Date rawUpdateTime;
	
	Date beginDate;
	
	Date endDate;
	ProductStatusEnum productStatus;
	
	String productType;
	/*商品推荐分类*/
	ProductRecommendTypeEnum recommendType;

	/*商品扩展属性*/
	ProductVaryEnum productVaryEnum;
	/**
	 * 产品编号
	 */
	String productNumber;
	
	/**
	 * 供应商名称
	 */
	String supplierName;
	/**
	 * 不为空，按照正常排序（景区 商户 商品新增日期）空就是随机排序
	 */
	String orderNormal;
	/** 只查询团购邮购 */
	BooleanEnum saleTypeO2oAndB2c;
	
	BooleanEnum saleTypeO2o;
	
	BooleanEnum saleTypeB2c;

	BooleanEnum saleTypeHotels;
	/**
	 * 创建人
	 */
	long resortsBusinessId;
	
	String saleType;
	
	public String getSaleType() {
		return saleType;
	}
	
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
	public long getProductRecommendId() {
		return productRecommendId;
	}
	
	public void setProductRecommendId(long productRecommendId) {
		this.productRecommendId = productRecommendId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
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
	
	public ProductStatusEnum getProductStatus() {
		return this.productStatus;
	}
	
	public void setProductStatus(ProductStatusEnum productStatus) {
		this.productStatus = productStatus;
	}
	
	public String getProductType() {
		return this.productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getOrderNormal() {
		return orderNormal;
	}
	
	public void setOrderNormal(String orderNormal) {
		this.orderNormal = orderNormal;
	}
	
	public long getResortsBusinessId() {
		return resortsBusinessId;
	}
	
	public void setResortsBusinessId(long resortsBusinessId) {
		this.resortsBusinessId = resortsBusinessId;
	}
	
	public ProductRecommendTypeEnum getRecommendType() {
		return recommendType;
	}
	
	public void setRecommendType(ProductRecommendTypeEnum recommendType) {
		this.recommendType = recommendType;
	}
	
	public BooleanEnum getSaleTypeO2oAndB2c() {
		return saleTypeO2oAndB2c;
	}
	
	public void setSaleTypeO2oAndB2c(BooleanEnum saleTypeO2oAndB2c) {
		this.saleTypeO2oAndB2c = saleTypeO2oAndB2c;
	}
	
	public BooleanEnum getSaleTypeO2o() {
		return saleTypeO2o;
	}
	
	public void setSaleTypeO2o(BooleanEnum saleTypeO2o) {
		this.saleTypeO2o = saleTypeO2o;
	}
	
	public BooleanEnum getSaleTypeB2c() {
		return saleTypeB2c;
	}
	
	public void setSaleTypeB2c(BooleanEnum saleTypeB2c) {
		this.saleTypeB2c = saleTypeB2c;
	}

	public ProductVaryEnum getProductVaryEnum() {
		return productVaryEnum;
	}

	public void setProductVaryEnum(ProductVaryEnum productVaryEnum) {
		this.productVaryEnum = productVaryEnum;
	}

	public BooleanEnum getSaleTypeHotels() {
		return saleTypeHotels;
	}

	public void setSaleTypeHotels(BooleanEnum saleTypeHotels) {
		this.saleTypeHotels = saleTypeHotels;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ProductRecommendOrder{");
		sb.append("productRecommendId=").append(productRecommendId);
		sb.append(", productId=").append(productId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", userId=").append(userId);
		sb.append(", productName='").append(productName).append('\'');
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", productStatus=").append(productStatus);
		sb.append(", productType='").append(productType).append('\'');
		sb.append(", recommendType=").append(recommendType);
		sb.append(", productVaryEnum=").append(productVaryEnum);
		sb.append(", productNumber='").append(productNumber).append('\'');
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", orderNormal='").append(orderNormal).append('\'');
		sb.append(", saleTypeO2oAndB2c=").append(saleTypeO2oAndB2c);
		sb.append(", saleTypeO2o=").append(saleTypeO2o);
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", saleType='").append(saleType).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
