package com.yjf.esupplier.ws.service;

import javax.jws.WebService;

import com.yjf.esupplier.ws.order.LoanAuthOrder;
import com.yjf.esupplier.ws.order.TradeProcessOrder;
import com.yjf.esupplier.ws.order.TradeRepayOrder;
import com.yjf.esupplier.ws.order.UpdateTradeExpireDateOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@WebService
public interface TradeBizProcessService {
	/**
	 * 满标检查定时任务
	 */
	public void executeOverDueLoanDemandProcessJob();
	
	/**
	 * 满标检查定时任务
	 */
	public void executeDivisionException();
	
	/**
	 * 满标处理
	 * @param processOrder
	 * @return
	 */
	public EsupplierBaseResult fullScaleProcess(TradeProcessOrder processOrder);
	
	/**
	 * 流标处理
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult denyloanDemandUnfull(TradeProcessOrder processOrder);
	
	/**
	 * 交易审核
	 * @param loanAuthOrder
	 * @return
	 */
	EsupplierBaseResult tradeCheck(LoanAuthOrder loanAuthOrder);
	
	/**
	 * 担保公司生成合同
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult guaranteeMakeContract(TradeProcessOrder processOrder);
	
	/**
	 * 担保公司审核完成
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult guaranteeAuditingFinish(LoanAuthOrder processOrder);
	
	/**
	 * 贷款超期处理
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult loanExpireProcess(TradeProcessOrder processOrder);
	
	/**
	 * 检查超期贷款
	 */
	void executeAutoChangeExpireLoanJob();
	
	/**
	 * 自动还款
	 */
	void executeAutoPayLoanJob();
	
	/**
	 * 提前通知还款人还款
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult noticeRepay(TradeProcessOrder processOrder);
	
	/**
	 * 当天通知还款人还款
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult noticeIntradayRepay(TradeProcessOrder processOrder);
	
	/**
	 * 自动检测即将到期还款交易且 发送通知
	 */
	void executeRepayAdvanceNotificationJob();
	
	/**
	 * 自动检测当天到期还款交易且 发送通知
	 */
	void executeRepayIntradayNotificationJob();
	
	/**
	 * 交易下线
	 * @param processOrder
	 * @return
	 * @throws Exception
	 */
	EsupplierBaseResult offLineTrade(TradeProcessOrder processOrder) throws Exception;
	
	EsupplierBaseResult updateTradeExpireDate(UpdateTradeExpireDateOrder processOrder);
	
	/**
	 * 还款
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult repay(TradeRepayOrder processOrder);
	
	/**
	 * 补充还款
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult reRepay(TradeRepayOrder processOrder);
	
	/**
	 * 最后一次自动帮借款人还款失败
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult repayFail(TradeRepayOrder processOrder);
	
	/**
	 * 通知担保机构的审核员审核
	 * @param guaranteeId
	 * @param tradeName
	 * @param operatorType
	 */
	public void notifyGuaranteeAudit(long guaranteeId, String tradeName, int operatorType);
	
	public long getYrdUserId();
	
	/**
	 * 非产权，债权，交易关闭
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult completeTrade(TradeProcessOrder processOrder);
}
