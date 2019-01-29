package com.yjf.esupplier.ws.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.AmountFlowEnum;

public class AddAmountFlowOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 9192862241964908439L;
	
	/** 流水号 */
	private String flowCode;
	/** 进账用户id */
	private long inUserId;
	/** 出账用户id */
	private long outUserId;
	/** 出账账户accountId */
	private String amountOut;
	/** 进账账户accountId */
	private String amountIn;
	/** 金额 */
	private Money amount = new Money(0, 0);
	/** 流水类型 */
	private AmountFlowEnum amountFlowType;
	/** 备注 */
	private String note;
	/** 交易id */
	private long tradeId;
	/** 交易明细id */
	private long tradeDetailId;
	/** 还款明细id */
	private long repayPlanId;
	/** 创建时间, */
	private Date rawAddTime;
	
	@Override
	public void check() {
		validateNotNull(amountFlowType, "资金类型");
		if (amountFlowType == AmountFlowEnum.AMOUNT_FLOW_INVEST
			|| amountFlowType == AmountFlowEnum.AMOUNT_FLOW_DIVISION) {
			validateGreaterThan(inUserId, "inUserId");
			validateGreaterThan(outUserId, "outUserId");
			validateHasText(amountOut, "amountOut");
		}
		
	}
	
	public String getFlowCode() {
		return this.flowCode;
	}
	
	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}
	
	public long getInUserId() {
		return this.inUserId;
	}
	
	public void setInUserId(long inUserId) {
		this.inUserId = inUserId;
	}
	
	public long getOutUserId() {
		return this.outUserId;
	}
	
	public void setOutUserId(long outUserId) {
		this.outUserId = outUserId;
	}
	
	public String getAmountOut() {
		return this.amountOut;
	}
	
	public void setAmountOut(String amountOut) {
		this.amountOut = amountOut;
	}
	
	public String getAmountIn() {
		return this.amountIn;
	}
	
	public void setAmountIn(String amountIn) {
		this.amountIn = amountIn;
	}
	
	public AmountFlowEnum getAmountFlowType() {
		return this.amountFlowType;
	}
	
	public void setAmountFlowType(AmountFlowEnum amountFlowType) {
		this.amountFlowType = amountFlowType;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public long getRepayPlanId() {
		return repayPlanId;
	}

	public void setRepayPlanId(long repayPlanId) {
		this.repayPlanId = repayPlanId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddAmountFlowOrder [flowCode=");
		builder.append(flowCode);
		builder.append(", inUserId=");
		builder.append(inUserId);
		builder.append(", outUserId=");
		builder.append(outUserId);
		builder.append(", amountOut=");
		builder.append(amountOut);
		builder.append(", amountIn=");
		builder.append(amountIn);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", amountFlowType=");
		builder.append(amountFlowType);
		builder.append(", note=");
		builder.append(note);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append("]");
		return builder.toString();
	}
	
}
