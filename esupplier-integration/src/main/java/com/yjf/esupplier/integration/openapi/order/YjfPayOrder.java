package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;

public class YjfPayOrder extends PayOrder {
	private static final long serialVersionUID = 8625998021666660731L;
	
	String tradeName;
	String outOrderNo;
	String currency = "CNY";
	String goodsClauses = "";/*{outId:"商品的外部ID" 	字符串 	否 	商品的外部ID 	1235646
								"name": 	商品名称 	字符串 	是 	商品名称 	笔记本电脑
								"memo": 	商品详情 	字符串 	否 	商品详情 	笔记本电脑
								"price": 	商品单价 	money类型 	否 	商品单价 	88.66
								"quantity": 	商品数量 	整型 	否 	商品数量 	10
								"otherFee": 	商品其它费用 	money类型 	否 	商品其它费用 	88.66
								"unit": 	商品单位 	字符串 	否 	商品单位 	台
								"detailUrl": 	商品描述网址 	字符串 	否 	商品描述网址 	http://www.yiji.com/
								"referUrl": 	商品来源网址 	字符串 	否 	商品来源网址 	http://www.yiji.com/
								"category": 	商品类目};*/
	/**
	 * 分润
	 */
	String profitClauses;
	/*
	 参数 	参数名称 	类型 	必填 	参数说明 	示例
	payerUserId 	付款方会员号 	字符串 	是 	付款方会员号 	20140821010000051558
	payerCardNo 	付款方卡号 	字符串 	否 	付款方卡号 	12345678901234567890
	payerAccountNo 	付款方账号 	字符串 	否 	付款方账号 	12345678901234567890
	payeeUserId 	收款方会员号 	字符串 	是 	收款方会员号 	20140821010000051558
	payeeCardNo 	收款方卡号 	字符串 	否 	收款方卡号 	12345697803124567980
	payeeAccountNo 	收费方账号 	字符串 	否 	收费方账号 	12345678901234568789
	profitAmount 	分润金额 	money类型 	是 	分润金额 	88.66
	profitMemo 	分润描述 	字符串(0-128) 	否 	分润描述 	协商分润 
	 * */
	Money tradeAmount = Money.zero();
	String tradeMemo;
	
	@Override
	public void check() {
		super.check();
		validateHasText(tradeName, "交易名称");
		validateHasText(outOrderNo, "outOrderNo");
		validateHasText(goodsClauses, "商品详情");
		validateHasText(serviceName, "serviceName");
		validateMoneyGreaterThanZero(tradeAmount, "交易金额");
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getGoodsClauses() {
		return this.goodsClauses;
	}
	
	public void setGoodsClauses(String goodsClauses) {
		this.goodsClauses = goodsClauses;
	}
	
	public Money getTradeAmount() {
		return this.tradeAmount;
	}
	
	public void setTradeAmount(Money tradeAmount) {
		this.tradeAmount = tradeAmount;
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
		builder.append("YjfPayOrder [tradeName=");
		builder.append(tradeName);
		builder.append(", outOrderNo=");
		builder.append(outOrderNo);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", goodsClauses=");
		builder.append(goodsClauses);
		builder.append(", profitClauses=");
		builder.append(profitClauses);
		builder.append(", tradeAmount=");
		builder.append(tradeAmount);
		builder.append(", tradeMemo=");
		builder.append(tradeMemo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
