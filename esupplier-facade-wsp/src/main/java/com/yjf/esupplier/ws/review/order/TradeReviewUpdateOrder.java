package com.yjf.esupplier.ws.review.order;

public class TradeReviewUpdateOrder extends TradeReviewCreateOrder {
	
	private static final long serialVersionUID = -8823008399289619404L;
	long reviewId;
	
	@Override
	public void check() {
		super.check();
		validateHasZore(reviewId, "评价id");
	}
	
	public long getReviewId() {
		return this.reviewId;
	}
	
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeReviewUpdateOrder [reviewId=");
		builder.append(reviewId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
