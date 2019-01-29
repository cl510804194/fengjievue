package com.yjf.esupplier.ws.gifamount.result;

import java.util.List;

import com.google.common.collect.Lists;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * Created by min on 2015/1/12.
 */
public class UseGainMoneyResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = 776616237612261780L;
	
	private double rateOfYear = 0.0;
	
	List<GiftMoneyTradeInfo> gainMoneyTrades = Lists.newArrayList();
	GiftMoneyTradeInfo giftMoneyTradeInfo;
	
	public double getRateOfYear() {
		return rateOfYear;
	}
	
	public void setRateOfYear(double rateOfYear) {
		this.rateOfYear = rateOfYear;
	}
	
	public List<GiftMoneyTradeInfo> getGainMoneyTrades() {
		return gainMoneyTrades;
	}
	
	public void setGainMoneyTrades(List<GiftMoneyTradeInfo> gainMoneyTrades) {
		this.gainMoneyTrades = gainMoneyTrades;
	}
	
	public GiftMoneyTradeInfo getGiftMoneyTradeInfo() {
		return this.giftMoneyTradeInfo;
	}
	
	public void setGiftMoneyTradeInfo(GiftMoneyTradeInfo giftMoneyTradeInfo) {
		this.giftMoneyTradeInfo = giftMoneyTradeInfo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UseGainMoneyResult [rateOfYear=");
		builder.append(rateOfYear);
		builder.append(", gainMoneyTrades=");
		builder.append(gainMoneyTrades);
		builder.append(", giftMoneyTradeInfo=");
		builder.append(giftMoneyTradeInfo);
		builder.append("]");
		return builder.toString();
	}
	
}
