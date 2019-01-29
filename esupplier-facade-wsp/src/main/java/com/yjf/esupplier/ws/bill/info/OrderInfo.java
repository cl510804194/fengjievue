package com.yjf.esupplier.ws.bill.info;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.data.OrderData;
import com.yjf.esupplier.ws.bill.enums.RefundProcessStatusEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;

public class OrderInfo extends OrderData implements Serializable {
	private static final long serialVersionUID = -272911842828421930L;
	List<OrderItemInfo> orderItems;
	OrderItemInfo orderItemInfo;
	DeliveryShipInfo deliveryShipInfo;
	RefundProcessStatusEnum refundProcessStatusEnum;
	BooleanEnum orangeWarning = BooleanEnum.NO;
	BooleanEnum redWarning = BooleanEnum.NO;
	String scenicName;
	String canRefund;
	private long diliveryId;
	public long getDiliveryId() {
		return diliveryId;
	}

	public void setDiliveryId(long diliveryId) {
		this.diliveryId = diliveryId;
	}

	public String getCanRefund() {
		return canRefund;
	}

	public void setCanRefund(String canRefund) {
		this.canRefund = canRefund;
	}

	public String getScenicName() {
		return scenicName;
	}

	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}

	public BooleanEnum getOrangeWarning() {
		return orangeWarning;
	}

	public void setOrangeWarning(BooleanEnum orangeWarning) {
		this.orangeWarning = orangeWarning;
	}

	public BooleanEnum getRedWarning() {
		return redWarning;
	}

	public void setRedWarning(BooleanEnum redWarning) {
		this.redWarning = redWarning;
	}
	public List<OrderItemInfo> getOrderItems() {
		return this.orderItems;
	}
	
	public void setOrderItems(List<OrderItemInfo> orderItems) {
		this.orderItems = orderItems;
		if (ListUtil.isNotEmpty(orderItems)) {
			orderItemInfo = orderItems.get(0);
		}
	}
	
	public OrderItemInfo getOrderItemInfo() {
		return this.orderItemInfo;
	}
	
	public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
		this.orderItemInfo = orderItemInfo;
	}
	
	public Money getPreferentialAmount() {
		return (gainMoney).add(giftMoney);
	}

	public DeliveryShipInfo getDeliveryShipInfo() {
		return deliveryShipInfo;
	}

	public void setDeliveryShipInfo(DeliveryShipInfo deliveryShipInfo) {
		this.deliveryShipInfo = deliveryShipInfo;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderInfo [orderItems=");
		builder.append(orderItems);
		builder.append(", orderItemInfo=");
		builder.append(orderItemInfo);
		builder.append(", redWarning=");
		builder.append(redWarning);
		builder.append(", orangeWarning=");
		builder.append(orangeWarning);
		builder.append(", canRefund=");
		builder.append(canRefund);
		builder.append(", diliveryId=");
		builder.append(diliveryId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
}
