package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.BooleanEnum;

public class TradeProcessOrder extends ProcessOrder implements Order {
	private static final long serialVersionUID = -2405554275676903075L;
	
	/** 处理金额 */
	protected Money processAmount = Money.zero();
	
	/**
	 * 
	 * @see com.yjf.common.service.Order#check()
	 */
	@Override
	public void check() {
		
		super.check();
		
	}
	
	@Override
	public long getBizNo() {
		return this.bizNo;
	}
	
	@Override
	public void setBizNo(long bizNo) {
		this.bizNo = bizNo;
	}
	
	@Override
	public long getProcessorId() {
		return this.processorId;
	}
	
	@Override
	public void setProcessorId(long processorId) {
		this.processorId = processorId;
	}
	
	@Override
	public String getProcessName() {
		return this.processName;
	}
	
	@Override
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	@Override
	public String getProcessAdvice() {
		return this.processAdvice;
	}
	
	@Override
	public void setProcessAdvice(String processAdvice) {
		this.processAdvice = processAdvice;
	}
	
	@Override
	public String getRemark() {
		return this.remark;
	}
	
	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public BooleanEnum getPassFlag() {
		return this.passFlag;
	}
	
	@Override
	public void setPassFlag(BooleanEnum passFlag) {
		this.passFlag = passFlag;
	}
	
	public Money getProcessAmount() {
		return this.processAmount;
	}
	
	public void setProcessAmount(Money processAmount) {
		this.processAmount = processAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeProcessOrder [processAmount=");
		builder.append(processAmount);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
