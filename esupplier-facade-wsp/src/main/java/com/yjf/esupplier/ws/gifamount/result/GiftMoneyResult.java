package com.yjf.esupplier.ws.gifamount.result;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class GiftMoneyResult extends EsupplierBaseResult {
	private static final long serialVersionUID = 2385891149939852661L;
	protected Money giftMoneyAmount = new Money(0, 0);
	private long giftMoneyRuleId;
	
	protected long num;
	protected Money gainAmount;
	
	public long getGiftMoneyRuleId() {
		return giftMoneyRuleId;
	}
	
	public void setGiftMoneyRuleId(long giftMoneyRuleId) {
		this.giftMoneyRuleId = giftMoneyRuleId;
	}
	
	public long getNum() {
		return num;
	}
	
	public void setNum(long num) {
		this.num = num;
	}
	
	public Money getGainAmount() {
		return this.gainAmount;
	}
	
	public void setGainAmount(Money gainAmount) {
		this.gainAmount = gainAmount;
	}
	
	public Money getGiftMoneyAmount() {
		return giftMoneyAmount;
	}
	
	public void setGiftMoneyAmount(Money giftMoneyAmount) {
		this.giftMoneyAmount = giftMoneyAmount;
	}
}
