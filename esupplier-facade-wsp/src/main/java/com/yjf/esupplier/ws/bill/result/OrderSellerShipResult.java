package com.yjf.esupplier.ws.bill.result;

import com.yjf.esupplier.ws.bill.info.DeliveryShipInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class OrderSellerShipResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -8744260242152326468L;
	DeliveryShipInfo deliveryShipInfo;
	
	public DeliveryShipInfo getDeliveryShipInfo() {
		return this.deliveryShipInfo;
	}
	
	public void setDeliveryShipInfo(DeliveryShipInfo deliveryShipInfo) {
		this.deliveryShipInfo = deliveryShipInfo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderSellerShipResult [deliveryShipInfo=");
		builder.append(deliveryShipInfo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
