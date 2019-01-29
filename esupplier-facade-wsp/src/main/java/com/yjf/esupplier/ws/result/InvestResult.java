package com.yjf.esupplier.ws.result;

public class InvestResult extends EsupplierBaseResult {
	private static final long serialVersionUID = 1679608213931322290L;
	long tradeDetailId = 0;
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	private boolean giftMoneySuccess;
	
	private String giftMoneyMessage;
	
	public InvestResult() {
	}
	
	public InvestResult(EsupplierBaseResult baseRs, long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
		this.microbankResultEnum = baseRs.getCreditsysResultEnum();
		this.setUrl(baseRs.getUrl());
		this.setSuccess(baseRs.isSuccess());
		this.setMessage(baseRs.getMessage());
	}
	
	public boolean isGiftMoneySuccess() {
		return giftMoneySuccess;
	}
	
	public void setGiftMoneySuccess(boolean giftMoneySuccess) {
		this.giftMoneySuccess = giftMoneySuccess;
	}
	
	public String getGiftMoneyMessage() {
		return giftMoneyMessage;
	}
	
	public void setGiftMoneyMessage(String giftMoneyMessage) {
		this.giftMoneyMessage = giftMoneyMessage;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvestResult [tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
