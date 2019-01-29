/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.hotel.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;

/**
 * 酒店库存信息
 *
 * @Filename HotelStockInfo.java
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
public class HotelStockInfo implements Serializable {

	private static final long serialVersionUID = 5965230272234045319L;

	private long id;
    /*房型id*/
	private long productId;
    /*房型名称*/
	private String productName;
    /*商户ID*/
	private long supplierId;
    /*日期*/
	private Date priceDate;
	/*价格*/
	private Money productPrice = new Money(0, 0);
	/*折扣价*/
	private Money marketPrice = new Money(0, 0);
	/*执行价-最低价*/
	private Money execPrice = new Money(0, 0);
	/*特价房价格*/
	private Money specialRoomPrice = new Money(0, 0);
	/*凌晨房价格*/
	private Money morningRoomPrice = new Money(0, 0);
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
	
	/** 长包房预订数量 */
	private long longRoomNum;
	/*状态*/
	private HotelStockStatusEnum status;


	public Money getLowestPrice() {
		Money lowestPrice = productPrice;
		if(specialRoomTotalNum>specialRoomNum&&lowestPrice.greaterThan(specialRoomPrice)){
			lowestPrice = specialRoomPrice;
		}
		if(morningRoomTotalNum>morningRoomNum&&lowestPrice.greaterThan(morningRoomPrice)){
			lowestPrice = morningRoomPrice;
		}
		return lowestPrice;
	}

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

	public Money getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Money marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Money getSpecialRoomPrice() {
		return specialRoomPrice;
	}

	public void setSpecialRoomPrice(Money specialRoomPrice) {
		this.specialRoomPrice = specialRoomPrice;
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

	public long getCanUseStock() {
		return availableStock-ordainNum;
	}

	public long getNormalStock() {
		return availableStock-morningRoomTotalNum-specialRoomTotalNum;
	}

	public long getNormalOrdain() {
		return ordainNum-morningRoomNum-specialRoomNum;
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

	public long getLongRoomNum() {
		return longRoomNum;
	}
	
	public void setLongRoomNum(long longRoomNum) {
		this.longRoomNum = longRoomNum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelStockInfo [id=");
		builder.append(id);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", priceDate=");
		builder.append(priceDate);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", marketPrice=");
		builder.append(marketPrice);
		builder.append(", execPrice=");
		builder.append(execPrice);
		builder.append(", specialRoomPrice=");
		builder.append(specialRoomPrice);
		builder.append(", morningRoomPrice=");
		builder.append(morningRoomPrice);
		builder.append(", inStock=");
		builder.append(inStock);
		builder.append(", availableStock=");
		builder.append(availableStock);
		builder.append(", ordainNum=");
		builder.append(ordainNum);
		builder.append(", morningRoomTotalNum=");
		builder.append(morningRoomTotalNum);
		builder.append(", morningRoomNum=");
		builder.append(morningRoomNum);
		builder.append(", specialRoomTotalNum=");
		builder.append(specialRoomTotalNum);
		builder.append(", specialRoomNum=");
		builder.append(specialRoomNum);
		builder.append(", longRoomNum=");
		builder.append(longRoomNum);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}


}
