package com.yjf.esupplier.ws.bill.data;

import com.yjf.common.lang.util.money.Money;

import java.io.Serializable;
import java.util.Date;

public class OrderHotelDetailData implements Serializable {
	private static final long serialVersionUID = -2448798177800787375L;
	/** 主键 */
	private long id;
	/** 订单明细号 */
	private long orderId;
	/** 订单明细号 */
	private long itemId;
	/** 房价类型 */
	private String roomType;
	/** 日期 */
	private Date inDate;
	/** 房间数量 */
	private long orderNum;
	/** 房间单价 */
	private Money price = new Money(0, 0);

	private Date rawAddTime;

	private Date rawUpdateTime;

	public long getId() {
		return id;
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

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
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

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("OrderHotelDetailData{");
		sb.append("id=").append(id);
		sb.append(", orderId=").append(orderId);
		sb.append(", itemId=").append(itemId);
		sb.append(", roomType='").append(roomType).append('\'');
		sb.append(", inDate=").append(inDate);
		sb.append(", orderNum=").append(orderNum);
		sb.append(", price=").append(price);
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append('}');
		return sb.toString();
	}

}
