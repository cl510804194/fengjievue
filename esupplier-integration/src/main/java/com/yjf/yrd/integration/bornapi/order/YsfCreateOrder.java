package com.yjf.yrd.integration.bornapi.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.lang.util.money.MoneyUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class YsfCreateOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = -1964286333080617113L;
	String tradeName;
	String sellerUserId;
	String partnerUserId;
	Money amount;
	String tradeMemo;
	
	@Override
	public void check() {
		validateHasText(tradeName, "交易名");
		//		validateHasText(sellerUserId, "商家ID"); 默认为平台Id
		validateHasText(partnerUserId, "买家ID");
		validateMoneyGreaterThanZero(amount, "交易金额");
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public String getSellerUserId() {
		return this.sellerUserId;
	}
	
	public void setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
	}
	
	public String getPartnerUserId() {
		return this.partnerUserId;
	}
	
	public void setPartnerUserId(String partnerUserId) {
		this.partnerUserId = partnerUserId;
	}
	
	public String getTradeAmount() {
		String m = MoneyUtil.format(getAmount());
		if (m.indexOf(",") > -1) {
			m = m.replaceAll(",", "");
		}
		return m;
	}
	
	public String getTradeMemo() {
		return this.tradeMemo;
	}
	
	public void setTradeMemo(String tradeMemo) {
		this.tradeMemo = tradeMemo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YsfCreateOrder [tradeName=");
		builder.append(tradeName);
		builder.append(", sellerUserId=");
		builder.append(sellerUserId);
		builder.append(", partnerUserId=");
		builder.append(partnerUserId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", tradeMemo=");
		builder.append(tradeMemo);
		builder.append("]");
		return builder.toString();
	}
	
}
