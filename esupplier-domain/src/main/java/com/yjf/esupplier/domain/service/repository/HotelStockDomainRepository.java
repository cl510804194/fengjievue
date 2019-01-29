package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.HotelStockDomain;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;

public interface HotelStockDomainRepository {
	void store(HotelStockDomain domain);
	
	void reStore(HotelStockDomain domain);

	HotelStockDomain active(long hotelId, boolean isLock);

	/*
	酒店房间预订数量 预订数增加
	*/
	void addOrderNum(HotelStockDomain domain,HotelTypeEnum hotelTypeEnum,long orderNum);

	/*
	酒店房间退订数量 预订数减少
	*/
	void delOrderNum(HotelStockDomain domain,HotelTypeEnum hotelTypeEnum,long orderNum);

}
