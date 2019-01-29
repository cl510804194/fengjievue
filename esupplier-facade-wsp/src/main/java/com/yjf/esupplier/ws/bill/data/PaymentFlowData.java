package com.yjf.esupplier.ws.bill.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.common.enums.PaymentTypeEnum;
import com.yjf.esupplier.ws.pay.enums.PaymentFlowMode;
import com.yjf.esupplier.ws.pay.enums.PaymentFlowReturnStatus;
import com.yjf.esupplier.ws.pay.enums.PaymentFlowStatus;

public class PaymentFlowData implements Serializable {
	
	private static final long serialVersionUID = 7856026260415156738L;
	/**
	 * 付款流水
	 */
	private String paymentFlowId;
	/**
	 * 付款订单号
	 */
	private String orderNo;
	/**
	 * 付款金额
	 */
	private Money paymentAmount = new Money(0, 0);
	/**
	 * 付款用户id
	 */
	private long userId;
	/**
	 * 付款用户
	 */
	private String userName;
	/**
	 * 付款用户真实名称
	 */
	private String realName;
	/**
	 * 银行渠道编码
	 */
	private String bankCode;
	/**
	 * 支付时间
	 */
	private Date paymentDate;
	/**
	 * 支付成功时间
	 */
	private Date paymentSuccessDate;
	/**
	 * 支付方式
	 */
	private PaymentTypeEnum paymentType;
	/**
	 * 支付状态
	 */
	private PaymentFlowStatus status;
	/**
	 * 
	 */
	private PaymentFlowMode paymentMode = PaymentFlowMode.TRADE_PAY;
	/**
	 * 多个订单id
	 */
	private String orderIds;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	/**
	 * 红包支付金额
	 */
	private Money redPay = new Money(0, 0);
	/**
	 * 积分支付金额
	 */
	private long integralPay;
	/**
	 * 优惠券支付金额
	 */
	private Money ticketAmount = new Money(0, 0);
	/**
	 * 
	 */
	private PaymentFlowReturnStatus refundStatus;
	/**
	 * 退款金额
	 */
	private Money refundAmount = new Money(0, 0);
	/**
	 * 优惠券id
	 */
	private long ticketId;
	/**
	 * 交易号
	 */
	private String tradeNo;
	/**
	 * 退款交易的父 支付流水号
	 */
	private String extOrder;
	
	private String extOrder1;
	
	public String getPaymentFlowId() {
		return this.paymentFlowId;
	}
	
	public void setPaymentFlowId(String paymentFlowId) {
		this.paymentFlowId = paymentFlowId;
	}
	
	public String getOrderNo() {
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public Money getPaymentAmount() {
		return this.paymentAmount;
	}
	
	public void setPaymentAmount(Money paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getBankCode() {
		return this.bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public Date getPaymentDate() {
		return this.paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public Date getPaymentSuccessDate() {
		return this.paymentSuccessDate;
	}
	
	public void setPaymentSuccessDate(Date paymentSuccessDate) {
		this.paymentSuccessDate = paymentSuccessDate;
	}
	
	public PaymentTypeEnum getPaymentType() {
		return this.paymentType;
	}
	
	public void setPaymentType(PaymentTypeEnum paymentType) {
		this.paymentType = paymentType;
	}
	
	public PaymentFlowStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(PaymentFlowStatus status) {
		this.status = status;
	}
	
	public String getOrderIds() {
		return this.orderIds;
	}
	
	public void setOrderIds(String orderIds) {
		this.orderIds = orderIds;
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
	
	public Money getRedPay() {
		return this.redPay;
	}
	
	public void setRedPay(Money redPay) {
		this.redPay = redPay;
	}
	
	public long getIntegralPay() {
		return this.integralPay;
	}
	
	public void setIntegralPay(long integralPay) {
		this.integralPay = integralPay;
	}
	
	public Money getTicketAmount() {
		return this.ticketAmount;
	}
	
	public void setTicketAmount(Money ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	
	public PaymentFlowReturnStatus getRefundStatus() {
		return this.refundStatus;
	}
	
	public void setRefundStatus(PaymentFlowReturnStatus refundStatus) {
		this.refundStatus = refundStatus;
	}
	
	public Money getRefundAmount() {
		return this.refundAmount;
	}
	
	public void setRefundAmount(Money refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	public long getTicketId() {
		return this.ticketId;
	}
	
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	public String getExtOrder() {
		return this.extOrder;
	}
	
	public void setExtOrder(String extOrder) {
		this.extOrder = extOrder;
	}
	
	public String getExtOrder1() {
		return this.extOrder1;
	}
	
	public void setExtOrder1(String extOrder1) {
		this.extOrder1 = extOrder1;
	}
	
	public PaymentFlowMode getPaymentMode() {
		return this.paymentMode;
	}
	
	public void setPaymentMode(PaymentFlowMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentFlowData [paymentFlowId=");
		builder.append(paymentFlowId);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", paymentAmount=");
		builder.append(paymentAmount);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", paymentDate=");
		builder.append(paymentDate);
		builder.append(", paymentSuccessDate=");
		builder.append(paymentSuccessDate);
		builder.append(", paymentType=");
		builder.append(paymentType);
		builder.append(", status=");
		builder.append(status);
		builder.append(", orderIds=");
		builder.append(orderIds);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", redPay=");
		builder.append(redPay);
		builder.append(", integralPay=");
		builder.append(integralPay);
		builder.append(", ticketAmount=");
		builder.append(ticketAmount);
		builder.append(", refundStatus=");
		builder.append(refundStatus);
		builder.append(", refundAmount=");
		builder.append(refundAmount);
		builder.append(", ticketId=");
		builder.append(ticketId);
		builder.append(", tradeNo=");
		builder.append(tradeNo);
		builder.append(", extOrder=");
		builder.append(extOrder);
		builder.append(", extOrder1=");
		builder.append(extOrder1);
		builder.append("]");
		return builder.toString();
	}
	
}
