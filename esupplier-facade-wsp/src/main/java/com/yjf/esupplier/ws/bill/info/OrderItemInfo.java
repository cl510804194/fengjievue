package com.yjf.esupplier.ws.bill.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;

public class OrderItemInfo implements Serializable {
	
	private static final long serialVersionUID = -8991949395072854631L;
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
	private Money proPrice;
	/** 图片路径 */
	private String picPath;
	
	private Money postFree; // 运费说明 cl 2010-07-20 add

	private Date beginTime;

	private Date endTime;

	private long days;

	private HotelTypeEnum roomType;

	public Money getPostFree() {
		return postFree;
	}
	
	public void setPostFree(Money postFree) {
		this.postFree = postFree;
	}
	
	public long getId() {
		return id;
	}
	
	public String getPicPath() {
		return picPath;
	}
	
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getItemProductId() {
		return itemProductId;
	}
	
	public void setItemProductId(long itemProductId) {
		this.itemProductId = itemProductId;
	}
	
	public String getItemProductName() {
		return itemProductName;
	}
	
	public void setItemProductName(String itemProductName) {
		this.itemProductName = itemProductName;
	}
	
	public long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	public Money getProPrice() {
		return proPrice;
	}
	
	public void setProPrice(Money proPrice) {
		this.proPrice = proPrice;
	}
	
	public Money getTotalAmount() {
		if (postFree == null) {
			return proPrice.multiply(quantity);
		} else {
			return proPrice.multiply(quantity).add(postFree);
		}
		
	}
	
	public Money getTotalAmountNoPostFree() {
		
		return proPrice.multiply(quantity);
		
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


	public HotelTypeEnum getRoomType() {
		return roomType;
	}

	public void setRoomType(HotelTypeEnum roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("OrderItemInfo{");
		sb.append("id=").append(id);
		sb.append(", orderId=").append(orderId);
		sb.append(", itemProductId=").append(itemProductId);
		sb.append(", itemProductName='").append(itemProductName).append('\'');
		sb.append(", quantity=").append(quantity);
		sb.append(", proPrice=").append(proPrice);
		sb.append(", picPath='").append(picPath).append('\'');
		sb.append(", postFree=").append(postFree);
		sb.append(", beginTime=").append(beginTime);
		sb.append(", endTime=").append(endTime);
		sb.append(", days=").append(days);
		sb.append(", roomType=").append(roomType);
		sb.append('}');
		return sb.toString();
	}

}
