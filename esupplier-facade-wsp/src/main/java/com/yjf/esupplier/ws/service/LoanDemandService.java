package com.yjf.esupplier.ws.service;

import javax.jws.WebService;

import com.yjf.esupplier.ws.order.CreateLoanDemandOrder;
import com.yjf.esupplier.ws.order.GuaranteeCheckOrder;
import com.yjf.esupplier.ws.order.LoanDemandCheckPassOrder;
import com.yjf.esupplier.ws.order.LoanDemandGuaranteeOrder;
import com.yjf.esupplier.ws.order.LoanDemandLoanNoteOrder;
import com.yjf.esupplier.ws.order.LoanDemandUploadContractOrder;
import com.yjf.esupplier.ws.order.TradeProcessOrder;
import com.yjf.esupplier.ws.result.AddLoanDemandResult;
import com.yjf.esupplier.ws.result.LoanDemandCalculateResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@WebService
public interface LoanDemandService {
	/***
	 * 发布借款需求
	 * 
	 * @param loanDemandDO
	 * @return
	 * @throws Exception
	 */
	public AddLoanDemandResult addLoanDemand(CreateLoanDemandOrder loanDemandOrder);
	
	/***
	 * 修改借款需求
	 * 
	 * @param loanDemandDO
	 * @return
	 * @throws Exception
	 */
	public EsupplierBaseResult updateLoanDemand(CreateLoanDemandOrder loanDemandOrder);
	
	/**
	 * 驳回借款需求
	 * 
	 * @param demandId
	 * @param publishDate
	 * @param demandId
	 * @return
	 * @throws DataAccessException
	 * */
	public EsupplierBaseResult dismissLoanDemand(TradeProcessOrder processOrder);
	
	/**
	 * 审核借款需求
	 * 
	 * @param demandId
	 * @param publishDate
	 * @param demandId
	 * @return
	 * @throws DataAccessException
	 * */
	public EsupplierBaseResult checkPassLoanDemand(LoanDemandCheckPassOrder processOrder);
	
	/**
	 * 更新上传图片地址
	 * @param id
	 * @param newUrl
	 * @return
	 */
	public EsupplierBaseResult guaranteeCheck(GuaranteeCheckOrder guaranteeCheckOrder);
	
	/**
	 * 交易上线
	 * @param loanId
	 */
	public EsupplierBaseResult onlineTrade(TradeProcessOrder processOrder);
	
	/**
	 * 定时任务执行定时发布需求
	 * @return
	 */
	public void executeOnTimePublishLoanDemandJob();
	
	/**
	 * 计算各角色费率
	 * @param demandId
	 * @return
	 */
	LoanDemandCalculateResult calculateInterestByRole(long demandId);
	
	/**
	 * 上传正式担保函
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult uploadContractPdfUrl(LoanDemandUploadContractOrder processOrder);
	
	/**
	 * 更新项目信息
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult updateLoanNote(LoanDemandLoanNoteOrder processOrder);
	
	/**
	 * 更新保障信息
	 * @param processOrder
	 * @return
	 */
	EsupplierBaseResult updateGuaranteeInfo(LoanDemandGuaranteeOrder processOrder);
}
