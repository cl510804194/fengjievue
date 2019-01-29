package com.yjf.esupplier.ws.gifamount.order;

import java.util.Arrays;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;


public class GiftMoneyUseOrder extends ValidateOrderBase implements Order {
	private long[] giftMoneyIds;
	private long demandId;
	private long detailDomainId;
	private long tradeDomainId;
	private Date currentDate;
	private long userId;
	
	private GiftMoneyTypeEnum type;
	
	private String orderNo;
	
	private Money investAmount;
	
	private Money amount;

	private long giftMoneyTradeId;
	
	@Override
	public void check() {
		this.validateHasZore(demandId, "借款需求ID");
		this.validateHasZore(detailDomainId, "投资详情ID");
		this.validateHasZore(tradeDomainId, "交易ID");
		this.validateHasText(orderNo, "交易流号");
		this.validateHasZore(userId, "用户ID");
		this.validateNotNull(amount, "优惠券使用金额");
		this.validateNotNull(investAmount, "投资金额");
		this.validateNotNull(type, "业务类型");
		
	}
	
	public Money getInvestAmount() {
		return investAmount;
	}
	
	public void setInvestAmount(Money investAmount) {
		this.investAmount = investAmount;
	}
	
	public long[] getGiftMoneyIds() {
		return giftMoneyIds;
	}
	
	public void setGiftMoneyIds(long[] giftMoneyIds) {
		this.giftMoneyIds = giftMoneyIds;
	}
	
	public long getDemandId() {
		return demandId;
	}
	
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	
	public long getDetailDomainId() {
		return detailDomainId;
	}
	
	public void setDetailDomainId(long detailDomainId) {
		this.detailDomainId = detailDomainId;
	}
	
	public long getTradeDomainId() {
		return tradeDomainId;
	}
	
	public void setTradeDomainId(long tradeDomainId) {
		this.tradeDomainId = tradeDomainId;
	}
	
	public Date getCurrentDate() {
		return currentDate;
	}
	
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public GiftMoneyTypeEnum getType() {
		return type;
	}
	
	public void setType(GiftMoneyTypeEnum type) {
		this.type = type;
	}

	public long getGiftMoneyTradeId() {
		return giftMoneyTradeId;
	}

	public void setGiftMoneyTradeId(long giftMoneyTradeId) {
		this.giftMoneyTradeId = giftMoneyTradeId;
	}

	@Override
	public String toString() {
		return "GiftMoneyUseOrder{" +
				"giftMoneyIds=" + Arrays.toString(giftMoneyIds) +
				", demandId=" + demandId +
				", detailDomainId=" + detailDomainId +
				", tradeDomainId=" + tradeDomainId +
				", currentDate=" + currentDate +
				", userId=" + userId +
				", type=" + type +
				", orderNo='" + orderNo + '\'' +
				", investAmount=" + investAmount +
				", amount=" + amount +
				", giftMoneyTradeId=" + giftMoneyTradeId +
				'}';
	}
}
