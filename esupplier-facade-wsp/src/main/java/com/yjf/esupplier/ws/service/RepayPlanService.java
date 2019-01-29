package com.yjf.esupplier.ws.service;

import com.yjf.esupplier.ws.order.TradeRepayOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface RepayPlanService {

	/**
	 * 补充还款
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult reRepay(TradeRepayOrder processOrder);
	
}
 