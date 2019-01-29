package com.yjf.esupplier.ws.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.BooleanEnum;

public class ProcessOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -2405554275676903075L;
	/**
	 * 业务流水号(业务数据唯一id)
	 */
	protected long bizNo;
	/** 操作人id */
	protected long processorId;
	/** 所属用户id */
	protected long belongTo;
	/** 操作人名称 */
	protected String processName;
	/** 处理意见 */
	protected String processAdvice;
	/** 摘要 */
	protected String remark;
	/** 通过标志 */
	protected BooleanEnum passFlag = BooleanEnum.YES;
	
	protected String orderType;

	@Override
	public void check() {
		validateNotNull(belongTo, "所属会员id");
	}
	
	public long getBizNo() {
		return this.bizNo;
	}
	
	public void setBizNo(long bizNo) {
		this.bizNo = bizNo;
	}
	
	public long getProcessorId() {
		return this.processorId;
	}
	
	public void setProcessorId(long processorId) {
		this.processorId = processorId;
	}
	
	public String getProcessName() {
		return this.processName;
	}
	
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	public String getProcessAdvice() {
		return this.processAdvice;
	}
	
	public void setProcessAdvice(String processAdvice) {
		this.processAdvice = processAdvice;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public BooleanEnum getPassFlag() {
		return this.passFlag;
	}
	
	public void setPassFlag(BooleanEnum passFlag) {
		this.passFlag = passFlag;
	}
	
	public long getBelongTo() {
		return this.belongTo;
	}
	
	public void setBelongTo(long belongTo) {
		this.belongTo = belongTo;
	}
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcessOrder [bizNo=");
		builder.append(bizNo);
		builder.append(", processorId=");
		builder.append(processorId);
		builder.append(", belongTo=");
		builder.append(belongTo);
		builder.append(", processName=");
		builder.append(processName);
		builder.append(", processAdvice=");
		builder.append(processAdvice);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", passFlag=");
		builder.append(passFlag);
		builder.append(", orderType=");
		builder.append(orderType);
		builder.append("]");
		return builder.toString();
	}
	
}
