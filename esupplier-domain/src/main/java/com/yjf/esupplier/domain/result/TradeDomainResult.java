package com.yjf.esupplier.domain.result;

import com.yjf.esupplier.domain.TradeDomain;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class TradeDomainResult extends EsupplierBaseResult {
	private static final long serialVersionUID = 7540940631305221223L;
	TradeDomain tradeDomain;
	
	public TradeDomain getTradeDomain() {
		return this.tradeDomain;
	}
	
	public void setTradeDomain(TradeDomain tradeDomain) {
		this.tradeDomain = tradeDomain;
	}
	
}
