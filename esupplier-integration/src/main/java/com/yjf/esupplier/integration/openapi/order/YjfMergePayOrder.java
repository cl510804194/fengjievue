package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.integration.openapi.enums.GatewayTypeEnum;
import com.yjf.esupplier.integration.openapi.enums.YjfBizType;

public class YjfMergePayOrder extends PayOrder {
	
	private static final long serialVersionUID = 7126647730612707516L;
	String payFrom = "NORMAL";// NORMAL:单笔付款  MERGE:多笔合并付款 HIGHWAY_ADMIN:公路局
	YjfBizType bizType = YjfBizType.PAYMENT;
	String protocolNo;
	String chargeExtend;
	GatewayTypeEnum gatewayType = GatewayTypeEnum.QUICK;
	String bankCode;
	String personalCorporateType;// CORPORATE:对公  PERSONAL:对私
	String prodInfoList;
	/**
	 * outOrderNo 外部订单号 字符串(1-64) 是 外部订单号 13431268512346 -------------------
	 * tradeName 交易名称字符串(0-64) 否 交易名称 交易 ----------------------------------
	 * sellerUserId 卖家ID 字符串 是 卖家的易极付ID 12365478901234567890 ---------------
	 * tradeAmount 交易额 money类型 是 交易额 88.66 ---------------------------------
	 * gatheringType {交易类型 字符串 是
	 * 交易类型GOODS_BUY:商品购买;SERVICE_BUY:服务购买;MAKE_INVEST:投资理财;
	 * MOBILE_PAY:手机支付;REFUND:退款;TRANSFER_DAILY:日终转账;TRANSFER_NETTING:扎差转账
	 * GOODS_BUY}-----------------------------------------------------------
	 * goodsClauses 商品信息 数组对象类型 是 商品信息 [{"outId":"1235646","... extInfoClause
	 * 扩展信息 对象类型 否 扩展信息
	 * 
	 * {"buyerMarkerMemo":"买...
	 * 
	 * tradeMemo 交易备注 字符串(0-1024) 否 交易备注 交易 ---------------------------
	 * detailUrl 明细地址 字符串(0-256) 否 明细地址 http://www.yiji.com incidentalFeeClauses
	 * 附带费用
	 */
	String buyerUserId;
	
	String mergeOrderNo;
	String currency = "CNY";
	
	public String getPayFrom() {
		return this.payFrom;
	}
	
	public void setPayFrom(String payFrom) {
		this.payFrom = payFrom;
	}
	
	public YjfBizType getBizType() {
		return this.bizType;
	}
	
	public void setBizType(YjfBizType bizType) {
		this.bizType = bizType;
	}
	
	public String getProtocolNo() {
		return this.protocolNo;
	}
	
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	
	public String getChargeExtend() {
		return this.chargeExtend;
	}
	
	public void setChargeExtend(String chargeExtend) {
		this.chargeExtend = chargeExtend;
	}
	
	public String getBankCode() {
		return this.bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public String getPersonalCorporateType() {
		return this.personalCorporateType;
	}
	
	public void setPersonalCorporateType(String personalCorporateType) {
		this.personalCorporateType = personalCorporateType;
	}
	
	public String getProdInfoList() {
		return this.prodInfoList;
	}
	
	public void setProdInfoList(String prodInfoList) {
		this.prodInfoList = prodInfoList;
	}
	
	public String getBuyerUserId() {
		return this.buyerUserId;
	}
	
	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	
	public String getMergeOrderNo() {
		return this.mergeOrderNo;
	}
	
	public void setMergeOrderNo(String mergeOrderNo) {
		this.mergeOrderNo = mergeOrderNo;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public GatewayTypeEnum getGatewayType() {
		return this.gatewayType;
	}
	
	public void setGatewayType(GatewayTypeEnum gatewayType) {
		this.gatewayType = gatewayType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfMergePayOrder [payFrom=");
		builder.append(payFrom);
		builder.append(", bizType=");
		builder.append(bizType);
		builder.append(", protocolNo=");
		builder.append(protocolNo);
		builder.append(", chargeExtend=");
		builder.append(chargeExtend);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", personalCorporateType=");
		builder.append(personalCorporateType);
		builder.append(", prodInfoList=");
		builder.append(prodInfoList);
		builder.append(", buyerUserId=");
		builder.append(buyerUserId);
		builder.append(", mergeOrderNo=");
		builder.append(mergeOrderNo);
		builder.append(", currency=");
		builder.append(currency);
		builder.append("]");
		return builder.toString();
	}
	
}
