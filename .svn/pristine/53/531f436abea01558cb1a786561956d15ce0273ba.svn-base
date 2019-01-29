/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

import java.util.Date;

/**
 *
 *
 * @Filename ProductPropertyQueryOrder.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email yunchuan@yiji.com
 *
 */
public class HotelStockOrder extends QueryPageBase  {

	private static final long serialVersionUID = -7241895295671953485L;

	private long id;
	/*房型id*/
	private long productId;
	/*房型名称*/
	private String productName;
	/** 房间商品状态*/
	private ProductStatusEnum productStatus;
	/*商户ID*/
	private long supplierId;
	/*日期*/
	private Date priceDate;
	/*价格*/
	private Money productPrice = new Money(0, 0);
	/*折扣价*/
	private Money discountPrice = new Money(0, 0);
	/*凌晨房价格*/
	private Money morningRoomPrice = new Money(0, 0);
	/*执行价-最低价*/
	private Money execPrice = new Money(0, 0);
	/*特价房价格*/
	private Money specialRoomPrice = new Money(0, 0);
	/*总库存*/
	private long inStock;
	/*可用库存*/
	private long availableStock;
	/*预订数量*/
	private long ordainNum;
	/*凌晨房数量*/
	private long morningRoomTotalNum;
	/*凌晨房预定数量*/
	private long morningRoomNum;
	/*特价房预定总数量*/
	private long specialRoomTotalNum;
	/*特价房预定数量*/
	private long specialRoomNum;
	/*状态*/
	private HotelStockStatusEnum status;
	/*开始日期*/
	private Date beginDate;
	/*结束日期*/
	private Date endDate;

	/*>=剩余房间数*/
	private long leftStock;
	/*>=剩余普通房间数*/
	private long normalStock;
	/*>=剩余特价房房间数*/
	private long leftSpeStock;
	/*>=剩余凌晨房房间数*/
	private long leftMorStock;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public Money getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Money productPrice) {
		this.productPrice = productPrice;
	}

	public Money getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Money discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Money getMorningRoomPrice() {
		return morningRoomPrice;
	}

	public void setMorningRoomPrice(Money morningRoomPrice) {
		this.morningRoomPrice = morningRoomPrice;
	}

	public long getInStock() {
		return inStock;
	}

	public void setInStock(long inStock) {
		this.inStock = inStock;
	}

	public long getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(long availableStock) {
		this.availableStock = availableStock;
	}

	public long getOrdainNum() {
		return ordainNum;
	}

	public void setOrdainNum(long ordainNum) {
		this.ordainNum = ordainNum;
	}

	public long getMorningRoomTotalNum() {
		return morningRoomTotalNum;
	}

	public void setMorningRoomTotalNum(long morningRoomTotalNum) {
		this.morningRoomTotalNum = morningRoomTotalNum;
	}

	public long getMorningRoomNum() {
		return morningRoomNum;
	}

	public void setMorningRoomNum(long morningRoomNum) {
		this.morningRoomNum = morningRoomNum;
	}

	public long getSpecialRoomTotalNum() {
		return specialRoomTotalNum;
	}

	public void setSpecialRoomTotalNum(long specialRoomTotalNum) {
		this.specialRoomTotalNum = specialRoomTotalNum;
	}

	public long getSpecialRoomNum() {
		return specialRoomNum;
	}

	public void setSpecialRoomNum(long specialRoomNum) {
		this.specialRoomNum = specialRoomNum;
	}

	public HotelStockStatusEnum getStatus() {
		return status;
	}

	public void setStatus(HotelStockStatusEnum status) {
		this.status = status;
	}

	public Money getExecPrice() {
		return execPrice;
	}

	public void setExecPrice(Money execPrice) {
		this.execPrice = execPrice;
	}

	public Money getSpecialRoomPrice() {
		return specialRoomPrice;
	}

	public void setSpecialRoomPrice(Money specialRoomPrice) {
		this.specialRoomPrice = specialRoomPrice;
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

	public long getLeftStock() {
		return leftStock;
	}

	public void setLeftStock(long leftStock) {
		this.leftStock = leftStock;
	}

	public long getLeftSpeStock() {
		return leftSpeStock;
	}

	public void setLeftSpeStock(long leftSpeStock) {
		this.leftSpeStock = leftSpeStock;
	}

	public long getLeftMorStock() {
		return leftMorStock;
	}

	public void setLeftMorStock(long leftMorStock) {
		this.leftMorStock = leftMorStock;
	}

	public long getNormalStock() {
		return normalStock;
	}

	public void setNormalStock(long normalStock) {
		this.normalStock = normalStock;
	}

	public ProductStatusEnum getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatusEnum productStatus) {
		this.productStatus = productStatus;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("HotelStockOrder{");
		sb.append("id=").append(id);
		sb.append(", productId=").append(productId);
		sb.append(", productName='").append(productName).append('\'');
		sb.append(", productStatus=").append(productStatus);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", priceDate=").append(priceDate);
		sb.append(", productPrice=").append(productPrice);
		sb.append(", discountPrice=").append(discountPrice);
		sb.append(", morningRoomPrice=").append(morningRoomPrice);
		sb.append(", execPrice=").append(execPrice);
		sb.append(", specialRoomPrice=").append(specialRoomPrice);
		sb.append(", inStock=").append(inStock);
		sb.append(", availableStock=").append(availableStock);
		sb.append(", ordainNum=").append(ordainNum);
		sb.append(", morningRoomTotalNum=").append(morningRoomTotalNum);
		sb.append(", morningRoomNum=").append(morningRoomNum);
		sb.append(", specialRoomTotalNum=").append(specialRoomTotalNum);
		sb.append(", specialRoomNum=").append(specialRoomNum);
		sb.append(", status=").append(status);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", leftStock=").append(leftStock);
		sb.append(", normalStock=").append(normalStock);
		sb.append(", leftSpeStock=").append(leftSpeStock);
		sb.append(", leftMorStock=").append(leftMorStock);
		sb.append('}');
		return sb.toString();
	}
}
