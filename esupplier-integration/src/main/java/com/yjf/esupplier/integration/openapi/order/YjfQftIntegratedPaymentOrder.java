package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;

public class YjfQftIntegratedPaymentOrder extends PayOrder {
	private static final long serialVersionUID = 1284998104314445851L;
	String outOrderNo;//"外部付款单号"
	String outTradeTitle;//"交易名称"
	String tradeChannel;//"GATEWAY"|"CASHIER_PC"|"CASHIER_MOBILE"|"CASHIER_WXPAY"|""CASHIER_POS"//交易渠道
	Money money = Money.zero();//交易金额
	Money moneyReal = Money.zero();//支付金额
	Money moneyGift = null;//红包金额
	String memo;//交易备注
	String outPayerShopId;//买家外部会员ID
	String payerUserId;//买家id
	String outPayeeShopId;//卖家外部会员	ID
	String payeeUserId;//卖家id
	String origin;//MOBILE:PC:SDK
	String goodList;//{title:商品名称,code:商品编码,description:商品描述,price:商品单价,price:商品单价,quantity:商品数量,unit:商品单位}
	String terminalBelongs;//POS终端归属(:"DISTRIBUTOR:经销商|"SUPPLIER:供应商")
	
	@Override
	public void check() {
		super.check();
		validateHasText(outOrderNo, "外部付款单号");
		validateHasText(outTradeTitle, "交易名称");
		validateHasText(tradeChannel, "交易渠道");
		validateMoneyGreaterThanZero(money, "交易金额");
		validateMoneyGreaterThanZero(moneyReal, "支付金额");
		validateHasText(goodList, "商品信息");
	}
	
	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	
	public String getOutTradeTitle() {
		return this.outTradeTitle;
	}
	
	public void setOutTradeTitle(String outTradeTitle) {
		this.outTradeTitle = outTradeTitle;
	}
	
	public String getTradeChannel() {
		return this.tradeChannel;
	}
	
	public void setTradeChannel(String tradeChannel) {
		this.tradeChannel = tradeChannel;
	}
	
	public Money getMoney() {
		return this.money;
	}
	
	public void setMoney(Money money) {
		this.money = money;
	}
	
	public Money getMoneyReal() {
		return this.moneyReal;
	}
	
	public void setMoneyReal(Money moneyReal) {
		this.moneyReal = moneyReal;
	}
	
	public Money getMoneyGift() {
		return this.moneyGift;
	}
	
	public void setMoneyGift(Money moneyGift) {
		this.moneyGift = moneyGift;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getOutPayerShopId() {
		return this.outPayerShopId;
	}
	
	public void setOutPayerShopId(String outPayerShopId) {
		this.outPayerShopId = outPayerShopId;
	}
	
	public String getPayerUserId() {
		return this.payerUserId;
	}
	
	public void setPayerUserId(String payerUserId) {
		this.payerUserId = payerUserId;
	}
	
	public String getOutPayeeShopId() {
		return this.outPayeeShopId;
	}
	
	public void setOutPayeeShopId(String outPayeeShopId) {
		this.outPayeeShopId = outPayeeShopId;
	}
	
	public String getPayeeUserId() {
		return this.payeeUserId;
	}
	
	public void setPayeeUserId(String payeeUserId) {
		this.payeeUserId = payeeUserId;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getGoodList() {
		return this.goodList;
	}
	
	public void setGoodList(String goodList) {
		this.goodList = goodList;
	}
	
	public String getTerminalBelongs() {
		return this.terminalBelongs;
	}
	
	public void setTerminalBelongs(String terminalBelongs) {
		this.terminalBelongs = terminalBelongs;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfQftIntegratedPaymentOrder [outOrderNo=");
		builder.append(outOrderNo);
		builder.append(", outTradeTitle=");
		builder.append(outTradeTitle);
		builder.append(", tradeChannel=");
		builder.append(tradeChannel);
		builder.append(", money=");
		builder.append(money);
		builder.append(", moneyReal=");
		builder.append(moneyReal);
		builder.append(", moneyGift=");
		builder.append(moneyGift);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", outPayerShopId=");
		builder.append(outPayerShopId);
		builder.append(", payerUserId=");
		builder.append(payerUserId);
		builder.append(", outPayeeShopId=");
		builder.append(outPayeeShopId);
		builder.append(", payeeUserId=");
		builder.append(payeeUserId);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", goodList=");
		builder.append(goodList);
		builder.append(", terminalBelongs=");
		builder.append(terminalBelongs);
		builder.append("]");
		return builder.toString();
	}
	
}
