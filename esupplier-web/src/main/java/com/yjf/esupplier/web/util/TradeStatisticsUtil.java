/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.web.util;

import java.util.Map;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.ws.statistics.TradeAmountStatisticsInfo;
import com.yjf.esupplier.ws.statistics.TradeStatisticsInfo;
import com.yjf.esupplier.ws.statistics.result.TradeStatisticsResult;

/**
 * 
 * @Filename TradeStatisticsUtil.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-5-21</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public class TradeStatisticsUtil {
	protected static final Logger logger = LoggerFactory.getLogger(TradeStatisticsUtil.class);
	
	public static void countInvestedMoney(	TradeStatisticsResult<TradeAmountStatisticsInfo> tradeStatisticsResult,
											Map<String, Object> investCountMap) {
		
		//		if (investTradeDetails != null && investTradeDetails.size() > 0) {
		//			for (TradeQueryDetail tradeDetail : investTradeDetails) {
		//				if (tradeDetail != null) {
		//					if (DivisionPhaseEnum.ORIGINAL_PHASE.code().equals(
		//						tradeDetail.getTransferPhase())) {
		//						long tradeAmount = tradeDetail.getAmount();
		//						totalInvestedAmount += tradeAmount;
		//						totalTransactions++;
		//						switch (tradeDetail.getStatus()) {
		//							case YrdConstants.TradeStatus.REPAYING_FAILD:
		//								repayFaildLoanedAmount += tradeAmount;
		//								notPaidInvestedProfitAmount += tradeAmount;
		//								totalNotPaidInvestedProfit++;
		//								break;
		//							case YrdConstants.TradeStatus.TRADING:
		//								collectingInvestedAmount += tradeAmount;//不计算待成立的投资  
		//								totalCollectingInvested++;
		//								break;
		//							case YrdConstants.TradeStatus.REPAYING:
		//								toPayInvestedAmount += tradeAmount;
		//								totalNotPaidInvestedProfit++;
		//								//notPaidInvestedAmount += tradeAmount;
		//								notPaidInvestedProfitAmount += tradeAmount;
		//								break;
		//							case YrdConstants.TradeStatus.FAILED:
		//								faildTransactions++;
		//								faildInvestedAmount += tradeAmount;
		//								break;
		//							case YrdConstants.TradeStatus.REPAY_FINISH:
		//								paidInvestedPrincipleAmount += tradeAmount;
		//								paidInvestedAmount += tradeAmount;
		//								totalPaidInvestedProfit++;
		//								totalPaidInvestedPrinciple++;
		//								break;
		//							case YrdConstants.TradeStatus.GUARANTEE_AUDITING:
		//								collectingInvestedAmount += tradeAmount;
		//								totalCollectingInvested++;
		//								break;
		//							case YrdConstants.TradeStatus.DOREPAY:
		//								toPayInvestedAmount += tradeAmount;
		//								notPaidInvestedProfitAmount += tradeAmount;
		//								totalNotPaidInvestedProfit++;
		//								break;
		//							case YrdConstants.TradeStatus.COMPENSATORY_REPAY_FINISH:
		//								paidInvestedPrincipleAmount += tradeAmount;
		//								totalPaidInvestedPrinciple++;
		//								totalPaidInvestedProfit++;
		//								break;
		//							default:
		//								logger.info("统计异常！");
		//								break;
		//						}
		//					} else {
		//						long benefitAmount = tradeDetail.getAmount();
		//						investedProfitAmount += benefitAmount;
		//						switch (tradeDetail.getStatus()) {
		//							case YrdConstants.TradeStatus.REPAYING_FAILD:
		//								//notPaidInvestedProfitAmount += benefitAmount;
		//								//totalNotPaidInvestedProfit++;
		//								break;
		//							case YrdConstants.TradeStatus.TRADING: //不计算待成立的投资  
		//								break;
		//							case YrdConstants.TradeStatus.REPAYING:
		//								notPaidInvestedAmount += benefitAmount;
		//								//notPaidInvestedProfitAmount += benefitAmount;
		//								//totalNotPaidInvestedProfit++;
		//								break;
		//							case YrdConstants.TradeStatus.FAILED://不计算未成立的投资  
		//								break;
		//							case YrdConstants.TradeStatus.REPAY_FINISH:
		//								paidInvestedProfitAmount += benefitAmount;
		//								totalPaidInvestedProfit++;
		//								break;
		//							case YrdConstants.TradeStatus.GUARANTEE_AUDITING:
		//								//notPaidInvestedProfitAmount += benefitAmount;
		//								//totalNotPaidInvestedProfit++;
		//								break;
		//							case YrdConstants.TradeStatus.DOREPAY:
		//								//notPaidInvestedProfitAmount += benefitAmount;
		//								totalNotPaidInvestedProfit++;
		//								notPaidInvestedAmount += benefitAmount;
		//								break;
		//							case YrdConstants.TradeStatus.COMPENSATORY_REPAY_FINISH:
		//								paidInvestedProfitAmount += benefitAmount;
		//								totalPaidInvestedProfit++;
		//								break;
		//						}
		//					}
		//				}
		//			}
		//			notPaidInvestedPrincipleAmount = toPayInvestedAmount + repayFaildLoanedAmount;
		//			paidInvestedAmount = paidInvestedPrincipleAmount + paidInvestedProfitAmount;
		//			
		//		}
		TradeStatisticsInfo statisticsInfo = tradeStatisticsResult.getStatisticsInfo();
		investCountMap.put("totalTransactions", tradeStatisticsResult.getStatisticsInfo()
			.getInvestCount());
		investCountMap.put("faildTransactions", tradeStatisticsResult.getStatisticsInfo()
			.getInvestFailCount());
		investCountMap.put("totalInvestedAmount", tradeStatisticsResult.getStatisticsInfo()
			.getInvestPrincipleAmount());
		investCountMap.put("collectingInvestedAmount", tradeStatisticsResult.getStatisticsInfo()
			.getInvestCollectingPrincipleAmount());
		
		investCountMap.put("paidInvestedAmount", tradeStatisticsResult.getStatisticsInfo()
			.getWaitToPayInvestAmount());
		investCountMap.put("faildInvestedAmount", tradeStatisticsResult.getStatisticsInfo()
			.getInvestFailPrincipleAmount());
		
		investCountMap.put("notPaidInvestedProfitAmount", tradeStatisticsResult.getStatisticsInfo()
			.getWaitSuccessPrincipleAmount());
		investCountMap.put("investedProfitAmount", tradeStatisticsResult.getStatisticsInfo()
			.getTotalAmount());
		investCountMap.put("notPaidInvestedAmount", statisticsInfo.getWaitToPayInvestAmount());
		investCountMap.put("totalCollectingInvested", statisticsInfo.getInvestCollectingCount());
		investCountMap.put("totalPaidInvestedPrinciple", statisticsInfo.getInvestSuccessCount());
		investCountMap.put("totalNotPaidInvestedProfit", statisticsInfo.getWaitSuccessCount());
		investCountMap.put("paidInvestedPrincipleAmount",
			statisticsInfo.getInvestSuccessPrincipleAmount());
	}
	
	public static void countLoanedMoney(TradeStatisticsResult<TradeAmountStatisticsInfo> tradeStatisticsResult,
										Map<String, Object> loanedCountMap) {
		
		TradeStatisticsInfo statisticsInfo = tradeStatisticsResult.getStatisticsInfo();
		loanedCountMap.put("totalTransactions", statisticsInfo.getLoanderCount());
		loanedCountMap.put("faildTransactions", statisticsInfo.getFaildInvestCount());
		
		loanedCountMap.put("totalToPayLoaned", statisticsInfo.getLoanderWaitSuccessCount());
		loanedCountMap.put("toPayLoanedAmount", statisticsInfo.getLoanderWaitSuccessAmount());
		loanedCountMap.put("totalPaidLoaned", statisticsInfo.getLoanderSuccessCount());
		loanedCountMap.put("collectingLoanedAmount",
			statisticsInfo.getLoanderCollectingPrincipleAmount());
		
		loanedCountMap.put("totalLoanedMoney", statisticsInfo.getLoanderAmount());
		loanedCountMap.put("totalCollectingLoaned", statisticsInfo.getLoanderCollectingCount());
		loanedCountMap.put("paidLoanedAmount", statisticsInfo.getLoanderSuccessAmount());
		
	}
}
