package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.OrderDomain;
import com.yjf.esupplier.domain.OrderItemDomain;
import com.yjf.esupplier.ws.bill.data.OrderHotelDetailData;

public interface OrderDomainRepository {
	void store(OrderDomain domain);
	
	void reStore(OrderDomain domain);
	
	OrderDomain active(long orderId, boolean isLock);
	
	void remove(OrderDomain domain);
	
	OrderItemDomain activeOrderItem(long orderId);
	
	OrderItemDomain activeOrderItemByItemId(long orderItemId);

}
