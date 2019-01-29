package com.yjf.esupplier.ws.statistics;

import java.io.Serializable;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.DivisionPhaseEnum;
import com.yjf.esupplier.ws.enums.TradeStatusEnum;

public class TradeAmountStatisticsInfo implements Serializable {
	private static final long serialVersionUID = 3559973140695268607L;
	private long totalCount;
	private TradeStatusEnum tradeStatus;
	private Money benefitAmount;
	private DivisionPhaseEnum transferPhase;
	
	public long getTotalCount() {
		return this.totalCount;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public TradeStatusEnum getTradeStatus() {
		return this.tradeStatus;
	}
	
	public void setTradeStatus(TradeStatusEnum tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
	public Money getBenefitAmount() {
		return this.benefitAmount;
	}
	
	public void setBenefitAmount(Money benefitAmount) {
		this.benefitAmount = benefitAmount;
	}
	
	public DivisionPhaseEnum getTransferPhase() {
		return this.transferPhase;
	}
	
	public void setTransferPhase(DivisionPhaseEnum transferPhase) {
		this.transferPhase = transferPhase;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeAmountStatisticsInfo [totalCount=");
		builder.append(totalCount);
		builder.append(", tradeStatus=");
		builder.append(tradeStatus);
		builder.append(", benefitAmount=");
		builder.append(benefitAmount);
		builder.append(", transferPhase=");
		builder.append(transferPhase);
		builder.append("]");
		return builder.toString();
	}
	
}
