package com.yjf.esupplier.ws.service;

import com.yjf.esupplier.ws.info.TradeFlowCodeInfo;

public interface TradeFlowCodeManager {
	TradeFlowCodeInfo queryInvestFlowCodesByTradeDetailId(long tradeDetailId);
}
