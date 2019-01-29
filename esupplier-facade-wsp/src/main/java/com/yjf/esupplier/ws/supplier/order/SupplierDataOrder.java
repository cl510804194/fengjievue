package com.yjf.esupplier.ws.supplier.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class SupplierDataOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 7138922679848338462L;
	long supplierId;
	/**
	 * 房间最低价格
	 */
	Money roomLowestPrice = null;
	/**
	 * 正常价格
	 */
	Money roomNormalPrice = null;
	/**
	 * 是否有特价房
	 */
	BooleanEnum specialRoom;
	/**
	 * 是否有长租房
	 */
	BooleanEnum longRentRoom;
	/**
	 * 凌晨房
	 */
	BooleanEnum morningRoom;

	@Override
	public void check() {
		validateHasZore(supplierId, "商户id");
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public Money getRoomLowestPrice() {
		return this.roomLowestPrice;
	}
	
	public void setRoomLowestPrice(Money roomLowestPrice) {
		this.roomLowestPrice = roomLowestPrice;
	}
	
	public Money getRoomNormalPrice() {
		return this.roomNormalPrice;
	}
	
	public void setRoomNormalPrice(Money roomNormalPrice) {
		this.roomNormalPrice = roomNormalPrice;
	}
	
	public BooleanEnum getSpecialRoom() {
		return this.specialRoom;
	}
	
	public void setSpecialRoom(BooleanEnum specialRoom) {
		this.specialRoom = specialRoom;
	}
	
	public BooleanEnum getLongRentRoom() {
		return this.longRentRoom;
	}
	
	public void setLongRentRoom(BooleanEnum longRentRoom) {
		this.longRentRoom = longRentRoom;
	}
	
	public BooleanEnum getMorningRoom() {
		return this.morningRoom;
	}
	
	public void setMorningRoom(BooleanEnum morningRoom) {
		this.morningRoom = morningRoom;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplierDataOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", roomLowestPrice=");
		builder.append(roomLowestPrice);
		builder.append(", roomNormalPrice=");
		builder.append(roomNormalPrice);
		builder.append(", specialRoom=");
		builder.append(specialRoom);
		builder.append(", longRentRoom=");
		builder.append(longRentRoom);
		builder.append(", morningRoom=");
		builder.append(morningRoom);
		builder.append("]");
		return builder.toString();
	}
	
}
