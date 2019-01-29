package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.review.order.TradeReviewCreateOrder;

public class TradeReviewOrder extends ProcessOrder {
	
	private static final long serialVersionUID = 8095938059938752512L;
	TradeReviewCreateOrder reviewCreateOrder;
	
	public TradeReviewCreateOrder getReviewCreateOrder() {
		return this.reviewCreateOrder;
	}
	
	public void setReviewCreateOrder(TradeReviewCreateOrder reviewCreateOrder) {
		this.reviewCreateOrder = reviewCreateOrder;
	}
	
	@Override
	public void check() {
		super.check();
		validateNotNull(reviewCreateOrder, "评价信息");
		reviewCreateOrder.check();
	}
}
