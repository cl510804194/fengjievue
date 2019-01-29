package com.yjf.esupplier.ws.service;

import com.yjf.esupplier.ws.order.CustomRepayOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface CustomRepayService {
	/**
	 * 产权分润还款
	 * @param customRepayOrder
	 * @return
	 */
	EsupplierBaseResult customRepay(CustomRepayOrder customRepayOrder);
	
}
