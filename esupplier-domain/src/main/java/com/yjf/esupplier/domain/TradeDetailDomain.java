package com.yjf.esupplier.domain;

import org.springframework.util.Assert;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.data.TradeDetailData;

public class TradeDetailDomain extends TradeDetailData implements Domain {
	private static final long serialVersionUID = -3251154475932449359L;
	
	private TradeFlowCodeDomain tradeFlowCodeDomain;
	
	public TradeFlowCodeDomain getTradeFlowCodeDomain() {
		return this.tradeFlowCodeDomain;
	}
	
	public void setTradeFlowCodeDomain(TradeFlowCodeDomain tradeFlowCodeDomain) {
		this.tradeFlowCodeDomain = tradeFlowCodeDomain;
	}
	
	@Override
	public void examSelf() throws Exception {
		Assert.isTrue(this.getUserId() > 0 || this.getUserId() == -1);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeDetailDomain [tradeFlowCodeDomain=");
		builder.append(tradeFlowCodeDomain);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
