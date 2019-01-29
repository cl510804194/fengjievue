package com.yjf.esupplier.ws.review.services;

import javax.jws.WebService;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.review.info.TradeReviewInfo;
import com.yjf.esupplier.ws.review.order.TradeReviewCreateOrder;
import com.yjf.esupplier.ws.review.order.TradeReviewQueryOrder;
import com.yjf.esupplier.ws.review.order.TradeReviewUpdateOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@WebService
public interface TradeReviewService {
	
	QueryBaseBatchResult<TradeReviewInfo> queryTradeReview(TradeReviewQueryOrder queryOrder);
	
	EsupplierBaseResult addTradeReview(TradeReviewCreateOrder tr);
	
	EsupplierBaseResult delTradeReview(long trId);
	
	EsupplierBaseResult updateTradeReview(TradeReviewUpdateOrder tradeReviewUpdateOrder)
																						throws Exception;
	
}
