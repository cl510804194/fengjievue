package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.BooleanEnum;

public class ClearMealOrder extends MealBaseOrder {
	
	private static final long serialVersionUID = 1443165534896695088L;
	BooleanEnum isComplete = BooleanEnum.NO;
	
	@Override
	public void check() {
		super.check();
		validateNotNull(isComplete, "是否结帐完成");
	}
	
	public BooleanEnum getIsComplete() {
		return this.isComplete;
	}
	
	public void setIsComplete(BooleanEnum isComplete) {
		this.isComplete = isComplete;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClearMealOrder [isComplete=");
		builder.append(isComplete);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
