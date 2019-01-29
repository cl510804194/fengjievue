package com.yjf.esupplier.ws.statistics;

import com.yjf.common.lang.util.money.Money;

public class TradeStatisticsInfo {
	//募集中的次数
	long collectingInvestCount = 0;
	long auditingInvestCount = 0;
	long repaingInvestCount = 0;
	long faildInvestCount = 0;
	long repayFaildInvestCount = 0;
	long doRepayInvestCount = 0;
	long repayFinishInvestCount = 0;
	long compensatoryRepayFinishInvestCount = 0;
	//投资总数
	long investCount = 0;
	//投资本金总额
	Money investPrincipleAmount = new Money(0);
	//投资成功的数量
	long investSuccessCount = 0;
	//投资成功的本金
	Money investSuccessPrincipleAmount = new Money(0);
	//等待回款的数量
	long waitSuccessCount = 0;
	//等待回款的本金
	Money waitSuccessPrincipleAmount = new Money(0);
	//募资的数量
	long investCollectingCount = 0;
	
	//募资的本金
	Money investCollectingPrincipleAmount = new Money(0);
	
	//失败的数量
	long investFailCount = 0;
	
	//失败的本金
	Money investFailPrincipleAmount = new Money(0);
	
	//投资总数
	long loanderCount = 0;
	//投资本金总额
	Money loanderAmount = new Money(0);
	//投资成功的数量
	long loanderSuccessCount = 0;
	//投资成功的本金
	Money loanderSuccessAmount = new Money(0);
	//等待回款的数量
	long loanderWaitSuccessCount = 0;
	//等待回款的本金
	Money loanderWaitSuccessAmount = new Money(0);
	//募资的数量
	long loanderCollectingCount = 0;
	
	//募资的本金
	Money loanderCollectingPrincipleAmount = new Money(0);
	
	//失败的数量
	long loanderFailCount = 0;
	
	//失败的本金
	Money loanderFailPrincipleAmount = new Money(0);
	
	/**
	 * 交易数（主页） //投资次数
	 */
	long totalCount = 0;
	//募集中的投资金额
	Money collectingInvestAmount = new Money(0);
	
	Money paidInvestAmount = new Money(0);
	
	Money faildInvestAmount = new Money(0);
	//待还款投资金额
	Money waitToPayInvestAmount = new Money(0);
	/**
	 * 所有交易融资金额（主页）//累计投资金额
	 */
	Money totalAmount = new Money(0);
	/**
	 * 已融资金额（主页）
	 */
	Money dealAmount = new Money(0);
	/**
	 * 还款本金（主页）
	 */
	Money repayAmount = new Money(0);
	
	public long getCollectingInvestCount() {
		return this.collectingInvestCount;
	}
	
	public void setCollectingInvestCount(long collectingInvestCount) {
		this.collectingInvestCount = collectingInvestCount;
	}
	
	public long getAuditingInvestCount() {
		return this.auditingInvestCount;
	}
	
	public void setAuditingInvestCount(long auditingInvestCount) {
		this.auditingInvestCount = auditingInvestCount;
	}
	
	public long getRepaingInvestCount() {
		return this.repaingInvestCount;
	}
	
	public void setRepaingInvestCount(long repaingInvestCount) {
		this.repaingInvestCount = repaingInvestCount;
	}
	
	public long getFaildInvestCount() {
		return this.faildInvestCount;
	}
	
	public void setFaildInvestCount(long faildInvestCount) {
		this.faildInvestCount = faildInvestCount;
	}
	
	public long getRepayFaildInvestCount() {
		return this.repayFaildInvestCount;
	}
	
	public void setRepayFaildInvestCount(long repayFaildInvestCount) {
		this.repayFaildInvestCount = repayFaildInvestCount;
	}
	
	public long getDoRepayInvestCount() {
		return this.doRepayInvestCount;
	}
	
	public void setDoRepayInvestCount(long doRepayInvestCount) {
		this.doRepayInvestCount = doRepayInvestCount;
	}
	
	public long getRepayFinishInvestCount() {
		return this.repayFinishInvestCount;
	}
	
	public void setRepayFinishInvestCount(long repayFinishInvestCount) {
		this.repayFinishInvestCount = repayFinishInvestCount;
	}
	
	public long getCompensatoryRepayFinishInvestCount() {
		return this.compensatoryRepayFinishInvestCount;
	}
	
	public void setCompensatoryRepayFinishInvestCount(long compensatoryRepayFinishInvestCount) {
		this.compensatoryRepayFinishInvestCount = compensatoryRepayFinishInvestCount;
	}
	
	public Money getCollectingInvestAmount() {
		return this.collectingInvestAmount;
	}
	
	public void setCollectingInvestAmount(Money collectingInvestAmount) {
		this.collectingInvestAmount = collectingInvestAmount;
	}
	
	public Money getPaidInvestAmount() {
		return this.paidInvestAmount;
	}
	
	public void setPaidInvestAmount(Money paidInvestAmount) {
		this.paidInvestAmount = paidInvestAmount;
	}
	
	public Money getFaildInvestAmount() {
		return this.faildInvestAmount;
	}
	
	public void setFaildInvestAmount(Money faildInvestAmount) {
		this.faildInvestAmount = faildInvestAmount;
	}
	
	public Money getWaitToPayInvestAmount() {
		return this.waitToPayInvestAmount;
	}
	
	public void setWaitToPayInvestAmount(Money waitToPayInvestAmount) {
		this.waitToPayInvestAmount = waitToPayInvestAmount;
	}
	
	public Money getTotalAmount() {
		return this.totalAmount;
	}
	
	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Money getDealAmount() {
		return this.dealAmount;
	}
	
	public void setDealAmount(Money dealAmount) {
		this.dealAmount = dealAmount;
	}
	
	public long getTotalCount() {
		return this.totalCount;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public Money getRepayAmount() {
		return this.repayAmount;
	}
	
	public void setRepayAmount(Money repayAmount) {
		this.repayAmount = repayAmount;
	}
	
	public long getInvestCount() {
		return this.investCount;
	}
	
	public void setInvestCount(long investCount) {
		this.investCount = investCount;
	}
	
	public Money getInvestPrincipleAmount() {
		return this.investPrincipleAmount;
	}
	
	public void setInvestPrincipleAmount(Money investPrincipleAmount) {
		this.investPrincipleAmount = investPrincipleAmount;
	}
	
	public long getInvestSuccessCount() {
		return this.investSuccessCount;
	}
	
	public void setInvestSuccessCount(long investSuccessCount) {
		this.investSuccessCount = investSuccessCount;
	}
	
	public Money getInvestSuccessPrincipleAmount() {
		return this.investSuccessPrincipleAmount;
	}
	
	public void setInvestSuccessPrincipleAmount(Money investSuccessPrincipleAmount) {
		this.investSuccessPrincipleAmount = investSuccessPrincipleAmount;
	}
	
	public long getWaitSuccessCount() {
		return this.waitSuccessCount;
	}
	
	public void setWaitSuccessCount(long waitSuccessCount) {
		this.waitSuccessCount = waitSuccessCount;
	}
	
	public Money getWaitSuccessPrincipleAmount() {
		return this.waitSuccessPrincipleAmount;
	}
	
	public void setWaitSuccessPrincipleAmount(Money waitSuccessPrincipleAmount) {
		this.waitSuccessPrincipleAmount = waitSuccessPrincipleAmount;
	}
	
	public long getInvestCollectingCount() {
		return this.investCollectingCount;
	}
	
	public void setInvestCollectingCount(long investCollectingCount) {
		this.investCollectingCount = investCollectingCount;
	}
	
	public Money getInvestCollectingPrincipleAmount() {
		return this.investCollectingPrincipleAmount;
	}
	
	public void setInvestCollectingPrincipleAmount(Money investCollectingPrincipleAmount) {
		this.investCollectingPrincipleAmount = investCollectingPrincipleAmount;
	}
	
	public long getInvestFailCount() {
		return this.investFailCount;
	}
	
	public void setInvestFailCount(long investFailCount) {
		this.investFailCount = investFailCount;
	}
	
	public Money getInvestFailPrincipleAmount() {
		return this.investFailPrincipleAmount;
	}
	
	public void setInvestFailPrincipleAmount(Money investFailPrincipleAmount) {
		this.investFailPrincipleAmount = investFailPrincipleAmount;
	}
	
	public long getLoanderCount() {
		return this.loanderCount;
	}
	
	public void setLoanderCount(long loanderCount) {
		this.loanderCount = loanderCount;
	}
	
	public Money getLoanderAmount() {
		return this.loanderAmount;
	}
	
	public void setLoanderAmount(Money loanderAmount) {
		this.loanderAmount = loanderAmount;
	}
	
	public long getLoanderSuccessCount() {
		return this.loanderSuccessCount;
	}
	
	public void setLoanderSuccessCount(long loanderSuccessCount) {
		this.loanderSuccessCount = loanderSuccessCount;
	}
	
	public Money getLoanderSuccessAmount() {
		return this.loanderSuccessAmount;
	}
	
	public void setLoanderSuccessAmount(Money loanderSuccessAmount) {
		this.loanderSuccessAmount = loanderSuccessAmount;
	}
	
	public long getLoanderWaitSuccessCount() {
		return this.loanderWaitSuccessCount;
	}
	
	public void setLoanderWaitSuccessCount(long loanderWaitSuccessCount) {
		this.loanderWaitSuccessCount = loanderWaitSuccessCount;
	}
	
	public Money getLoanderWaitSuccessAmount() {
		return this.loanderWaitSuccessAmount;
	}
	
	public void setLoanderWaitSuccessAmount(Money loanderWaitSuccessAmount) {
		this.loanderWaitSuccessAmount = loanderWaitSuccessAmount;
	}
	
	public long getLoanderCollectingCount() {
		return this.loanderCollectingCount;
	}
	
	public void setLoanderCollectingCount(long loanderCollectingCount) {
		this.loanderCollectingCount = loanderCollectingCount;
	}
	
	public Money getLoanderCollectingPrincipleAmount() {
		return this.loanderCollectingPrincipleAmount;
	}
	
	public void setLoanderCollectingPrincipleAmount(Money loanderCollectingPrincipleAmount) {
		this.loanderCollectingPrincipleAmount = loanderCollectingPrincipleAmount;
	}
	
	public long getLoanderFailCount() {
		return this.loanderFailCount;
	}
	
	public void setLoanderFailCount(long loanderFailCount) {
		this.loanderFailCount = loanderFailCount;
	}
	
	public Money getLoanderFailPrincipleAmount() {
		return this.loanderFailPrincipleAmount;
	}
	
	public void setLoanderFailPrincipleAmount(Money loanderFailPrincipleAmount) {
		this.loanderFailPrincipleAmount = loanderFailPrincipleAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeStatisticsInfo [collectingInvestCount=");
		builder.append(collectingInvestCount);
		builder.append(", auditingInvestCount=");
		builder.append(auditingInvestCount);
		builder.append(", repaingInvestCount=");
		builder.append(repaingInvestCount);
		builder.append(", faildInvestCount=");
		builder.append(faildInvestCount);
		builder.append(", repayFaildInvestCount=");
		builder.append(repayFaildInvestCount);
		builder.append(", doRepayInvestCount=");
		builder.append(doRepayInvestCount);
		builder.append(", repayFinishInvestCount=");
		builder.append(repayFinishInvestCount);
		builder.append(", compensatoryRepayFinishInvestCount=");
		builder.append(compensatoryRepayFinishInvestCount);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", collectingInvestAmount=");
		builder.append(collectingInvestAmount);
		builder.append(", paidInvestAmount=");
		builder.append(paidInvestAmount);
		builder.append(", faildInvestAmount=");
		builder.append(faildInvestAmount);
		builder.append(", waitToPayInvestAmount=");
		builder.append(waitToPayInvestAmount);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", dealAmount=");
		builder.append(dealAmount);
		builder.append(", repayAmount=");
		builder.append(repayAmount);
		builder.append("]");
		return builder.toString();
	}
	
}
