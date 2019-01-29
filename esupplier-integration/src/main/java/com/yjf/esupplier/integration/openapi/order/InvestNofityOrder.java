package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class InvestNofityOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -2115414179280337707L;
	String batchNo;
	String userId;
	Money amount = new Money(0, 0);
	Money profit = new Money(0, 0);
	int annualRate;
	int period;
	String productId;
	String product_type;
	String productName;
	Money productAmount = new Money(0, 0);
	String extId;
	String channelSrc = "E8";
	String receiptURL;
	String contractURL;
	String confirmTime; //审核通过后，交易成立日或起息日
	String repaymentTime; //还款日或结息日
	
	/**
	 * 1:投资申请中（投标申请中） 3:已投资(投标成功--满标) 4:投标失败（投标失败） 5:投资收益中(还款中) 7:投资结束(完标)
	 */
	String notifyType = "";
	
	@Override
	public void check() {
		validateHasText(batchNo, "batchNo");
		validateHasText(userId, "userId");
		validateMoneyGreaterThanZero(amount, "amount");
		validateMoneyGreaterThanZero(profit, "profit");
		validateMoneyGreaterThanZero(productAmount, "productAmount");
		validateHasText(productId, "productId");
		validateHasText(productName, "productName");
		validateHasText(extId, "extId");
		validateHasText(channelSrc, "channelSrc");
	}
	
	public String getBatchNo() {
		return this.batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public Money getProfit() {
		return this.profit;
	}
	
	public void setProfit(Money profit) {
		this.profit = profit;
	}
	
	public int getAnnualRate() {
		return this.annualRate;
	}
	
	public void setAnnualRate(int annualRate) {
		this.annualRate = annualRate;
	}
	
	public int getPeriod() {
		return this.period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public String getProductId() {
		return this.productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProduct_type() {
		return this.product_type;
	}
	
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Money getProductAmount() {
		return this.productAmount;
	}
	
	public void setProductAmount(Money productAmount) {
		this.productAmount = productAmount;
	}
	
	public String getExtId() {
		return this.extId;
	}
	
	public void setExtId(String extId) {
		this.extId = extId;
	}
	
	public String getChannelSrc() {
		return this.channelSrc;
	}
	
	public void setChannelSrc(String channelSrc) {
		this.channelSrc = channelSrc;
	}
	
	public String getNotifyType() {
		return this.notifyType;
	}
	
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	
	public String getReceiptURL() {
		return this.receiptURL;
	}
	
	public void setReceiptURL(String receiptURL) {
		this.receiptURL = receiptURL;
	}
	
	public String getContractURL() {
		return this.contractURL;
	}
	
	public void setContractURL(String contractURL) {
		this.contractURL = contractURL;
	}
	
	public String getConfirmTime() {
		return this.confirmTime;
	}
	
	public void setConfirmTime(String confirmTime) {
		this.confirmTime = confirmTime;
	}
	
	public String getRepaymentTime() {
		return this.repaymentTime;
	}
	
	public void setRepaymentTime(String repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	
}
