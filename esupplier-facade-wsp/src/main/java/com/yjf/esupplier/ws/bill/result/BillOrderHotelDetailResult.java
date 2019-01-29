package com.yjf.esupplier.ws.bill.result;

import com.yjf.esupplier.ws.bill.data.OrderHotelDetailData;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

import java.util.List;

public class BillOrderHotelDetailResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -2991004068247632474L;
	List<OrderHotelDetailData> orderHotelDetailDataList;

	public List<OrderHotelDetailData> getOrderHotelDetailDataList() {
		return orderHotelDetailDataList;
	}

	public void setOrderHotelDetailDataList(List<OrderHotelDetailData> orderHotelDetailDataList) {
		this.orderHotelDetailDataList = orderHotelDetailDataList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillSaveResult [orderHotelDetailDataList=");
		builder.append(orderHotelDetailDataList);
		builder.append("]");
		return builder.toString();
	}
	
}
