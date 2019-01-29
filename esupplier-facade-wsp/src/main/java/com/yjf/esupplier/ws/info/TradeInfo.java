package com.yjf.esupplier.ws.info;

import java.io.Serializable;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.data.TradeData;

public class TradeInfo extends TradeData implements Serializable {
	
	private static final long serialVersionUID = -692752574146466997L;
	private static final Money ZERO = Money.zero();
	
	public boolean isLastInvestAvailable() {
		return (this.getTradeAmount().subtract(this.getLoanedAmount())).greaterThan(ZERO)
				&& (this.getLeastInvestAmount().subtract(this.getTradeAmount().subtract(
					this.getLoanedAmount()))).greaterThan(ZERO);
	}
}
