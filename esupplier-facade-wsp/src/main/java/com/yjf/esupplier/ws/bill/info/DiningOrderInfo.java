/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 上午10:39:21 创建
 */
package com.yjf.esupplier.ws.bill.info;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;

/**
 *
 *
 * @author zhouwei
 *
 */
public class DiningOrderInfo implements Serializable {
	
	private static final long serialVersionUID = 8131904080939865698L;
	
	/** 订单金额 */
	private Money totalAmount = new Money(0, 0);
	
	/** 订单优惠卷金额 */
	private Money totalGainMoney = new Money(0, 0);
	
	/** 订单积分抵扣金额 */
	private Money totalUserPointMoney = new Money(0, 0);
	
	/** 订单红包抵扣金额 */
	private Money totalGiftMoney = new Money(0, 0);
	
	/** 总的服务费 */
	private Money totalPostFee = new Money(0, 0);
	
	/** 总的配送费 */
	private Money totalDiliveryFee = new Money(0, 0);

	/** 服务费率 */
	private double serviceChargeRate;

	private long supplierId;
	
	/** 商户名称 */
	private String supplierName;
	
	/** 商户下的订单 */
	private List<OrderInfo> orderInfos;
	
	/** 订单批次号 */
	private String batchNo;
	
	/** 地址 */
	private String diningAddress;
	
	/** 消费时间 下单时间 */
	private Date consumeTime;
	
	/** 就餐时间 */
	private Date diningTime;
	
	/** 配送时间 */
	private Date deliverTime;

	/** 送达时间 */
	private Date receiptTime;

	/** 配送员电话 */
	private String diliverymanPhone;
	
	/** 订单状态 */
	private OrderStatusEnum orderStatus;

	public Money getTotalPayAmont() {
		return totalAmount.subtract(totalGainMoney).subtract(totalUserPointMoney)
			.subtract(totalGiftMoney);
	}

	public Money getTotalGainMoney() {
		return totalGainMoney;
	}
	
	public void setTotalGainMoney(Money totalGainMoney) {
		this.totalGainMoney = totalGainMoney;
	}
	
	public Money getTotalUserPointMoney() {
		return totalUserPointMoney;
	}
	
	public void setTotalUserPointMoney(Money totalUserPointMoney) {
		this.totalUserPointMoney = totalUserPointMoney;
	}
	
	public Money getTotalGiftMoney() {
		return totalGiftMoney;
	}
	
	public void setTotalGiftMoney(Money totalGiftMoney) {
		this.totalGiftMoney = totalGiftMoney;
	}

	public Money getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public List<OrderInfo> getOrderInfos() {
		return orderInfos;
	}
	
	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public String getDiningAddress() {
		return diningAddress;
	}
	
	public void setDiningAddress(String diningAddress) {
		this.diningAddress = diningAddress;
	}
	
	public Date getConsumeTime() {
		return consumeTime;
	}
	
	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}
	
	public String getDiliverymanPhone() {
		return diliverymanPhone;
	}
	
	public void setDiliverymanPhone(String diliverymanPhone) {
		this.diliverymanPhone = diliverymanPhone;
	}

	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Date getDiningTime() {
		return diningTime;
	}
	
	public void setDiningTime(Date diningTime) {
		this.diningTime = diningTime;
	}
	
	public Date getDeliverTime() {
		return deliverTime;
	}
	
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	
	public Date getReceiptTime() {
		return receiptTime;
	}
	
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Money getTotalPostFee() {
		return totalPostFee;
	}
	
	public void setTotalPostFee(Money totalPostFee) {
		this.totalPostFee = totalPostFee;
	}

	public double getServiceChargeRate() {
		return serviceChargeRate;
	}
	
	public void setServiceChargeRate(double serviceChargeRate) {
		this.serviceChargeRate = serviceChargeRate;
	}
	
	public Money getTotalDiliveryFee() {
		return totalDiliveryFee;
	}
	
	public void setTotalDiliveryFee(Money totalDiliveryFee) {
		this.totalDiliveryFee = totalDiliveryFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DiningOrderInfo [totalAmount=");
		builder.append(totalAmount);
		builder.append(", totalGainMoney=");
		builder.append(totalGainMoney);
		builder.append(", totalUserPointMoney=");
		builder.append(totalUserPointMoney);
		builder.append(", totalGiftMoney=");
		builder.append(totalGiftMoney);
		builder.append(", totalPostFee=");
		builder.append(totalPostFee);
		builder.append(", totalDiliveryFee=");
		builder.append(totalDiliveryFee);
		builder.append(", serviceChargeRate=");
		builder.append(serviceChargeRate);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", supplierName=");
		builder.append(supplierName);
		builder.append(", orderInfos=");
		builder.append(orderInfos);
		builder.append(", batchNo=");
		builder.append(batchNo);
		builder.append(", diningAddress=");
		builder.append(diningAddress);
		builder.append(", consumeTime=");
		builder.append(consumeTime);
		builder.append(", diningTime=");
		builder.append(diningTime);
		builder.append(", deliverTime=");
		builder.append(deliverTime);
		builder.append(", receiptTime=");
		builder.append(receiptTime);
		builder.append(", diliverymanPhone=");
		builder.append(diliverymanPhone);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append("]");
		return builder.toString();
	}


}
