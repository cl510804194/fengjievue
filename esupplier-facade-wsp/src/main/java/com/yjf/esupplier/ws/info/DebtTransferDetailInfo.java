package com.yjf.esupplier.ws.info;

import java.io.Serializable;

public class DebtTransferDetailInfo implements Serializable {
	private static final long serialVersionUID = -7312714774916240650L;
	/**
	 * 融资需求信息
	 */
	LoanDemandInfo loanDemandInfo;
	/**
	 * 转让的交易详细
	 */
	TradeDetailInfo tradeDetailInfo;
	/**
	 * 转让详细
	 */
	TradeDetailTransferInfo detailTransferInfo;
	/**
	 * 这个项目交易基本信息
	 */
	TradeInfo tradeInfo;
	
	public LoanDemandInfo getLoanDemandInfo() {
		return this.loanDemandInfo;
	}
	
	public void setLoanDemandInfo(LoanDemandInfo loanDemandInfo) {
		this.loanDemandInfo = loanDemandInfo;
	}
	
	public TradeDetailInfo getTradeDetailInfo() {
		return this.tradeDetailInfo;
	}
	
	public void setTradeDetailInfo(TradeDetailInfo tradeDetailInfo) {
		this.tradeDetailInfo = tradeDetailInfo;
	}
	
	public TradeDetailTransferInfo getDetailTransferInfo() {
		return this.detailTransferInfo;
	}
	
	public void setDetailTransferInfo(TradeDetailTransferInfo detailTransferInfo) {
		this.detailTransferInfo = detailTransferInfo;
	}
	
	public TradeInfo getTradeInfo() {
		return this.tradeInfo;
	}
	
	public void setTradeInfo(TradeInfo tradeInfo) {
		this.tradeInfo = tradeInfo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferDetailInfo [loanDemandInfo=");
		builder.append(loanDemandInfo);
		builder.append(", tradeDetailInfo=");
		builder.append(tradeDetailInfo);
		builder.append(", detailTransferInfo=");
		builder.append(detailTransferInfo);
		builder.append(", tradeInfo=");
		builder.append(tradeInfo);
		builder.append("]");
		return builder.toString();
	}
	
}
