package com.yjf.esupplier.ws.lottery;

import javax.jws.WebService;

import com.yjf.esupplier.ws.lottery.order.AddLotteryActivityOrder;
import com.yjf.esupplier.ws.lottery.order.DrawAwardOrder;
import com.yjf.esupplier.ws.lottery.order.GiveWinnerOrder;
import com.yjf.esupplier.ws.lottery.order.UpdateLotteryActivityOrder;
import com.yjf.esupplier.ws.lottery.query.result.LotteryResult;
import com.yjf.esupplier.ws.lottery.result.DrawAwardResult;
import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.AsynchronousService;

@WebService
public interface LotteryActivityService extends AsynchronousService {
	EsupplierBaseResult addLotteryActivity(AddLotteryActivityOrder activityOrder);
	
	EsupplierBaseResult removeLotteryActivity(ProcessOrder processOrder);
	
	EsupplierBaseResult updateLotteryActivity(UpdateLotteryActivityOrder activityOrder);
	
	EsupplierBaseResult endLotteryActivity(ProcessOrder processOrder);
	
	/**
	 * 抽奖
	 * @return
	 */
	DrawAwardResult drawAward(DrawAwardOrder drawAwardOrder);
	
	/**
	 * 是否能抽奖
	 * @return
	 */
	EsupplierBaseResult isCanDrawAward(DrawAwardOrder drawAwardOrder);
	
	/**
	 * 开始活动（开始中）
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult startLotteryActivity(ProcessOrder processOrder);
	
	/**
	 * 开始完成
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult startedLotteryActivity(ProcessOrder processOrder);
	
	/**
	 * 开始启动时候，出现异常
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult startErrorLotteryActivity(ProcessOrder processOrder);
	
	LotteryResult getStartedLotteryActivity();
	
	LotteryResult getStartedLotteryActivity(long activityId);
	
	EsupplierBaseResult giveWinner(GiveWinnerOrder giveWinnerOrder);
	
	/**
	 * 定时开始抽奖活动
	 */
	void startLotteryActivityTask();
	
	/**
	 * 定时结束抽奖活动
	 */
	void endLotteryActivityTask();
	
}
