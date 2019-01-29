package com.yjf.esupplier.ws.service;

import javax.jws.WebService;

import com.yjf.esupplier.ws.order.InvestBizTradeOrder;
import com.yjf.esupplier.ws.order.TradeProcessOrder;
import com.yjf.esupplier.ws.result.InvestResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@WebService
public interface InvestBizProcessService {
	InvestResult invest(InvestBizTradeOrder tradeOrder);
	
	EsupplierBaseResult investValidate(InvestBizTradeOrder tradeOrder);
	
	EsupplierBaseResult checkTrade(TradeProcessOrder tradeOrder);
}
