package com.yjf.esupplier.domain;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.bill.data.OrderHotelDetailData;
import com.yjf.esupplier.ws.bill.data.OrderItemData;

import java.util.List;

public class OrderItemDomain extends OrderItemData implements Domain {
	
	private static final long serialVersionUID = -5202437323329876916L;

	List<OrderHotelDetailData> hotelDetailDataList;
	@Override
	public void examSelf() throws Exception {
	}

	public List<OrderHotelDetailData> getHotelDetailDataList() {
		return hotelDetailDataList;
	}

	public void setHotelDetailDataList(List<OrderHotelDetailData> hotelDetailDataList) {
		this.hotelDetailDataList = hotelDetailDataList;
	}
}
