package com.yjf.esupplier.ws.orderfood.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 点餐汇总信息
 * 
 * 
 * @author qch
 * 
 */
public class UseingDiningOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -6495068710600530196L;
	
	private long addOrderCount;
	private Money addConsumeAmount = new Money(0, 0);
	private String tableNumberSeq;
	BooleanEnum isAddOrder = BooleanEnum.YES;
	BooleanEnum canSettle;
	
	@Override
	public void check() {
		if (canSettle == null) {
			validateMoneyGreaterThanZero(addConsumeAmount, "消费金额");
			validateHasZore(addOrderCount, "菜品数量");
			validateNotNull(isAddOrder, "点餐标志");
		}
	}
	
	public long getAddOrderCount() {
		return this.addOrderCount;
	}
	
	public void setAddOrderCount(long addOrderCount) {
		this.addOrderCount = addOrderCount;
	}
	
	public Money getAddConsumeAmount() {
		return this.addConsumeAmount;
	}
	
	public void setAddConsumeAmount(Money addConsumeAmount) {
		this.addConsumeAmount = addConsumeAmount;
	}
	
	public String getTableNumberSeq() {
		return this.tableNumberSeq;
	}
	
	public void setTableNumberSeq(String tableNumberSeq) {
		this.tableNumberSeq = tableNumberSeq;
	}
	
	public BooleanEnum getIsAddOrder() {
		return this.isAddOrder;
	}
	
	public void setIsAddOrder(BooleanEnum isAddOrder) {
		this.isAddOrder = isAddOrder;
	}
	
	public BooleanEnum getCanSettle() {
		return canSettle;
	}
	
	public void setCanSettle(BooleanEnum canSettle) {
		this.canSettle = canSettle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UseingDiningOrder [addOrderCount=");
		builder.append(addOrderCount);
		builder.append(", addConsumeAmount=");
		builder.append(addConsumeAmount);
		builder.append(", tableNumberSeq=");
		builder.append(tableNumberSeq);
		builder.append(", isAddOrder=");
		builder.append(isAddOrder);
		builder.append(", canSettle=");
		builder.append(canSettle);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
}
