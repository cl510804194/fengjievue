package com.yjf.esupplier.ws.userManage.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;

public class UserAccountData implements Serializable {
	private static final long serialVersionUID = -6087623821123357620L;
	/**
	 * 用户id
	 */
	protected long userId;
	/**
	 * 用户积分
	 */
	protected long userIntegral;
	/**
	 * 用户累计积分
	 */
	protected long userIntegralGrandTotal;
	/**
	 * 用户优惠券张数
	 */
	protected long userCouponCount;
	/**
	 * 用户优惠券累计张数
	 */
	protected long userCouponCountGrandTotal;
	/**
	 * 用户优惠券金额
	 */
	protected Money userCouponAmount = new Money(0, 0);
	/**
	 * 用户优惠券累计金额
	 */
	protected Money userCouponAmountGrandTotal = new Money(0, 0);
	/**
	 * 用户红包金额
	 */
	protected Money userGiftAmount = new Money(0, 0);
	/**
	 * 用户累计红包金额
	 */
	protected Money userGiftAmountGrandTotal = new Money(0, 0);
	/**
	 * 用户红包个数
	 */
	protected long userGiftAmountCount;
	/**
	 * 用户红包累计
	 */
	protected long userGiftAmountGrandCount;
	
	/**
	 * 现金红包
	 */
	protected Money userGiftAmountCash = new Money(0, 0);
	/**
	 * 现金红包累计
	 */
	protected Money userGiftAmountCashGrandTotal = new Money(0, 0);
	/**
	 * 用户付款金额
	 */
	protected Money userPayedAmount = new Money(0, 0);
	/**
	 * 用户成长值
	 */
	protected long userGrowthValue;
	
	/**
	 * 用户余额
	 */
	protected Money userBalance = new Money(0, 0);
	
	/**
	 * 用户交易金额
	 */
	protected Money userTradeAmount = new Money(0, 0);
	/**
	 * 充值累计金额
	 */
	protected Money userRechargeAmount = new Money(0, 0);
	/**
	 * 用户提现金额
	 */
	protected Money userWithdrawAmount = new Money(0, 0);
	/**
	 * 用户冻结金额
	 */
	protected Money userFreezeAmount = new Money(0, 0);
	/**
	 * 用户交易天数
	 */
	protected long userTradeDay;
	/**
	 * 最后交易时间
	 */
	protected String lastTradeDay;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getUserIntegral() {
		return this.userIntegral;
	}
	
	public void setUserIntegral(long userIntegral) {
		this.userIntegral = userIntegral;
	}
	
	public long getUserIntegralGrandTotal() {
		return this.userIntegralGrandTotal;
	}
	
	public void setUserIntegralGrandTotal(long userIntegralGrandTotal) {
		this.userIntegralGrandTotal = userIntegralGrandTotal;
	}
	
	public long getUserCouponCount() {
		return this.userCouponCount;
	}
	
	public void setUserCouponCount(long userCouponCount) {
		this.userCouponCount = userCouponCount;
	}
	
	public long getUserCouponCountGrandTotal() {
		return this.userCouponCountGrandTotal;
	}
	
	public void setUserCouponCountGrandTotal(long userCouponCountGrandTotal) {
		this.userCouponCountGrandTotal = userCouponCountGrandTotal;
	}
	
	public Money getUserCouponAmount() {
		return this.userCouponAmount;
	}
	
	public void setUserCouponAmount(Money userCouponAmount) {
		this.userCouponAmount = userCouponAmount;
	}
	
	public Money getUserCouponAmountGrandTotal() {
		return this.userCouponAmountGrandTotal;
	}
	
	public void setUserCouponAmountGrandTotal(Money userCouponAmountGrandTotal) {
		this.userCouponAmountGrandTotal = userCouponAmountGrandTotal;
	}
	
	public Money getUserGiftAmount() {
		return this.userGiftAmount;
	}
	
	public void setUserGiftAmount(Money userGiftAmount) {
		this.userGiftAmount = userGiftAmount;
	}
	
	public Money getUserGiftAmountGrandTotal() {
		return this.userGiftAmountGrandTotal;
	}
	
	public void setUserGiftAmountGrandTotal(Money userGiftAmountGrandTotal) {
		this.userGiftAmountGrandTotal = userGiftAmountGrandTotal;
	}
	
	public Money getUserGiftAmountCash() {
		return this.userGiftAmountCash;
	}
	
	public void setUserGiftAmountCash(Money userGiftAmountCash) {
		this.userGiftAmountCash = userGiftAmountCash;
	}
	
	public Money getUserGiftAmountCashGrandTotal() {
		return this.userGiftAmountCashGrandTotal;
	}
	
	public void setUserGiftAmountCashGrandTotal(Money userGiftAmountCashGrandTotal) {
		this.userGiftAmountCashGrandTotal = userGiftAmountCashGrandTotal;
	}
	
	public Money getUserBalance() {
		return this.userBalance;
	}
	
	public void setUserBalance(Money userBalance) {
		this.userBalance = userBalance;
	}
	
	public Money getUserRechargeAmount() {
		return this.userRechargeAmount;
	}
	
	public void setUserRechargeAmount(Money userRechargeAmount) {
		this.userRechargeAmount = userRechargeAmount;
	}
	
	public Money getUserWithdrawAmount() {
		return this.userWithdrawAmount;
	}
	
	public void setUserWithdrawAmount(Money userWithdrawAmount) {
		this.userWithdrawAmount = userWithdrawAmount;
	}
	
	public Money getUserFreezeAmount() {
		return this.userFreezeAmount;
	}
	
	public void setUserFreezeAmount(Money userFreezeAmount) {
		this.userFreezeAmount = userFreezeAmount;
	}
	
	public long getUserGiftAmountCount() {
		return this.userGiftAmountCount;
	}
	
	public void setUserGiftAmountCount(long userGiftAmountCount) {
		this.userGiftAmountCount = userGiftAmountCount;
	}
	
	public long getUserGiftAmountGrandCount() {
		return this.userGiftAmountGrandCount;
	}
	
	public void setUserGiftAmountGrandCount(long userGiftAmountGrandCount) {
		this.userGiftAmountGrandCount = userGiftAmountGrandCount;
	}
	
	public Money getUserTradeAmount() {
		return this.userTradeAmount;
	}
	
	public void setUserTradeAmount(Money userTradeAmount) {
		this.userTradeAmount = userTradeAmount;
	}
	
	public long getUserGrowthValue() {
		return this.userGrowthValue;
	}
	
	public void setUserGrowthValue(long userGrowthValue) {
		this.userGrowthValue = userGrowthValue;
	}
	
	public long getUserTradeDay() {
		return this.userTradeDay;
	}
	
	public void setUserTradeDay(long userTradeDay) {
		this.userTradeDay = userTradeDay;
	}
	
	public String getLastTradeDay() {
		return this.lastTradeDay;
	}
	
	public void setLastTradeDay(String lastTradeDay) {
		this.lastTradeDay = lastTradeDay;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public Money getUserPayedAmount() {
		return this.userPayedAmount;
	}
	
	public void setUserPayedAmount(Money userPayedAmount) {
		this.userPayedAmount = userPayedAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAccountData [userId=");
		builder.append(userId);
		builder.append(", userIntegral=");
		builder.append(userIntegral);
		builder.append(", userIntegralGrandTotal=");
		builder.append(userIntegralGrandTotal);
		builder.append(", userCouponCount=");
		builder.append(userCouponCount);
		builder.append(", userCouponCountGrandTotal=");
		builder.append(userCouponCountGrandTotal);
		builder.append(", userCouponAmount=");
		builder.append(userCouponAmount);
		builder.append(", userCouponAmountGrandTotal=");
		builder.append(userCouponAmountGrandTotal);
		builder.append(", userGiftAmount=");
		builder.append(userGiftAmount);
		builder.append(", userGiftAmountGrandTotal=");
		builder.append(userGiftAmountGrandTotal);
		builder.append(", userGiftAmountCount=");
		builder.append(userGiftAmountCount);
		builder.append(", userGiftAmountGrandCount=");
		builder.append(userGiftAmountGrandCount);
		builder.append(", userGiftAmountCash=");
		builder.append(userGiftAmountCash);
		builder.append(", userGiftAmountCashGrandTotal=");
		builder.append(userGiftAmountCashGrandTotal);
		builder.append(", userGrowthValue=");
		builder.append(userGrowthValue);
		builder.append(", userBalance=");
		builder.append(userBalance);
		builder.append(", userTradeAmount=");
		builder.append(userTradeAmount);
		builder.append(", userRechargeAmount=");
		builder.append(userRechargeAmount);
		builder.append(", userWithdrawAmount=");
		builder.append(userWithdrawAmount);
		builder.append(", userFreezeAmount=");
		builder.append(userFreezeAmount);
		builder.append("]");
		return builder.toString();
	}
	
}
