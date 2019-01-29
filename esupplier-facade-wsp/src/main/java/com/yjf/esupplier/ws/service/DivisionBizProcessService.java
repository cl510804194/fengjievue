package com.yjf.esupplier.ws.service;

import javax.jws.WebService;

import com.yjf.esupplier.ws.order.DivisionOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@WebService
public interface DivisionBizProcessService {
	/**
	 * 添加分润记录
	 * @param divisionOrder
	 * @return
	 */
	EsupplierBaseResult addDivisionInfo(DivisionOrder divisionOrder);
	
	/**
	 * 定时分润
	 */
	void runDivisionTransfer();
	
	/**
	 * 定时执行转账任务
	 */
	void runTransfer();
}
