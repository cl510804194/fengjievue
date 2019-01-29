package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.math.BigDecimal;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.data.LoanDemandData;
import com.yjf.esupplier.ws.enums.DivisionWayEnum;

public class LoanDemandInfo extends LoanDemandData implements Serializable {
	
	private static final long serialVersionUID = 7531119429621412946L;
	TradeInfo tradeInfo;
	Money repayAmount = Money.zero();
	Money brokerAmount = Money.zero();
	BigDecimal brokerInterest;
	boolean isFullScale = false;
	
	BigDecimal guaranteePct;
	BigDecimal marketingPct;
	BigDecimal plateformPct;
	BigDecimal investPct;
	long divisionTempId;
	long repayTempId;
	DivisionWayEnum repayDivisionWay;
	
	boolean newVersion = false;
	
	public TradeInfo getTradeInfo() {
		return this.tradeInfo;
	}
	
	public void setTradeInfo(TradeInfo tradeInfo) {
		this.tradeInfo = tradeInfo;
	}
	
	public Money getRepayAmount() {
		return this.repayAmount;
	}
	
	public void setRepayAmount(Money repayAmount) {
		this.repayAmount = repayAmount;
	}
	
	public Money getBrokerAmount() {
		return this.brokerAmount;
	}
	
	public void setBrokerAmount(Money brokerAmount) {
		this.brokerAmount = brokerAmount;
	}
	
	public BigDecimal getBrokerInterest() {
		return this.brokerInterest;
	}
	
	public void setBrokerInterest(BigDecimal brokerInterest) {
		this.brokerInterest = brokerInterest;
	}
	
	public boolean isFullScale() {
		return this.isFullScale;
	}
	
	public void setFullScale(boolean isFullScale) {
		this.isFullScale = isFullScale;
	}
	
	public BigDecimal getGuaranteePct() {
		return this.guaranteePct;
	}
	
	public void setGuaranteePct(BigDecimal guaranteePct) {
		this.guaranteePct = guaranteePct;
	}
	
	public BigDecimal getMarketingPct() {
		return this.marketingPct;
	}
	
	public void setMarketingPct(BigDecimal marketingPct) {
		this.marketingPct = marketingPct;
	}
	
	public BigDecimal getPlateformPct() {
		return this.plateformPct;
	}
	
	public void setPlateformPct(BigDecimal plateformPct) {
		this.plateformPct = plateformPct;
	}
	
	public BigDecimal getInvestPct() {
		return this.investPct;
	}
	
	public void setInvestPct(BigDecimal investPct) {
		this.investPct = investPct;
	}
	
	public long getDivisionTempId() {
		return this.divisionTempId;
	}
	
	public void setDivisionTempId(long divisionTempId) {
		this.divisionTempId = divisionTempId;
	}
	
	public long getRepayTempId() {
		return this.repayTempId;
	}
	
	public void setRepayTempId(long repayTempId) {
		this.repayTempId = repayTempId;
	}
	
	public DivisionWayEnum getRepayDivisionWay() {
		return this.repayDivisionWay;
	}
	
	public void setRepayDivisionWay(DivisionWayEnum repayDivisionWay) {
		this.repayDivisionWay = repayDivisionWay;
	}
	
	public boolean isNewVersion() {
		return newVersion;
	}

	public void setNewVersion(boolean newVersion) {
		this.newVersion = newVersion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandInfo [tradeInfo=");
		builder.append(tradeInfo);
		builder.append(", repayAmount=");
		builder.append(repayAmount);
		builder.append(", brokerAmount=");
		builder.append(brokerAmount);
		builder.append(", brokerInterest=");
		builder.append(brokerInterest);
		builder.append(", isFullScale=");
		builder.append(isFullScale);
		builder.append(", guaranteePct=");
		builder.append(guaranteePct);
		builder.append(", marketingPct=");
		builder.append(marketingPct);
		builder.append(", plateformPct=");
		builder.append(plateformPct);
		builder.append(", investPct=");
		builder.append(investPct);
		builder.append(", divisionTempId=");
		builder.append(divisionTempId);
		builder.append(", repayTempId=");
		builder.append(repayTempId);
		builder.append(", repayDivisionWay=");
		builder.append(repayDivisionWay);
		builder.append("]");
		return builder.toString();
	}
	
}
