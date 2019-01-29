package com.yjf.esupplier.ws.bill.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;

public class OrderItemData implements Serializable {
	private static final long serialVersionUID = -2448798177800787375L;
	/** 主键 */
	private long id;
	/** 订单号 */
	private long orderId;
	/** 产品主键 */
	private long itemProductId;
	/** 产品的名称 */
	private String itemProductName;
	/** 产品的数量 */
	private long quantity;
	/** 产品的价格 */
	private Money proPrice = new Money(0, 0);
	/** 图片路径 */
	private String picPath;

	private Date beginTime;

	private Date endTime;

	private long days;

	private Money postFree = new Money(0, 0); // 运费说明 cl 2010-07-20 add

	private Date rawAddTime;

	private Date rawUpdateTime;
	
	private HotelTypeEnum roomType;

	public HotelTypeEnum getRoomType() {
		return roomType;
	}

	public void setRoomType(HotelTypeEnum roomType) {
		this.roomType = roomType;
	}

	public Money getTotalAmountNoShipment() {
		long numDays = days<1?1:days;
		return proPrice.multiply(quantity).multiply(numDays);
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getItemProductId() {
		return this.itemProductId;
	}

	public void setItemProductId(long itemProductId) {
		this.itemProductId = itemProductId;
	}

	public String getItemProductName() {
		return this.itemProductName;
	}

	public void setItemProductName(String itemProductName) {
		this.itemProductName = itemProductName;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Money getProPrice() {
		return this.proPrice;
	}

	public void setProPrice(Money proPrice) {
		this.proPrice = proPrice;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Money getPostFree() {
		return this.postFree;
	}

	public void setPostFree(Money postFree) {
		this.postFree = postFree;
	}

	public Date getRawAddTime() {
		return this.rawAddTime;
	}

	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}

	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}

	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public long getDays() {
		return days;
	}

	public void setDays(long days) {
		this.days = days;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("OrderItemData{");
		sb.append("id=").append(id);
		sb.append(", orderId=").append(orderId);
		sb.append(", itemProductId=").append(itemProductId);
		sb.append(", itemProductName='").append(itemProductName).append('\'');
		sb.append(", quantity=").append(quantity);
		sb.append(", proPrice=").append(proPrice);
		sb.append(", picPath='").append(picPath).append('\'');
		sb.append(", beginTime=").append(beginTime);
		sb.append(", endTime=").append(endTime);
		sb.append(", days=").append(days);
		sb.append(", postFree=").append(postFree);
		sb.append(", roomType=").append(roomType);
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
	
		sb.append('}');
		return sb.toString();
	}


}
