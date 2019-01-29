package com.yjf.esupplier.ws.orderfood.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.orderfood.enums.DiningTableStatus;

public class DiningTableSituationInfo implements Serializable {
	
	private static final long serialVersionUID = -1452798485754525357L;
	
	private long id;
	
	private String tableNumber;
	
	private long supplierId;
	
	private Money consumeAmount = new Money(0, 0);
	
	private long orderCount;
	
	private Money settleAccountsAmount = new Money(0, 0);
	
	private long peopleNo;
	
	private DiningTableStatus status;
	
	private BooleanEnum canSettle;

	private String tableNumberSeq;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTableNumber() {
		return this.tableNumber;
	}
	
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public Money getConsumeAmount() {
		return this.consumeAmount;
	}
	
	public void setConsumeAmount(Money consumeAmount) {
		this.consumeAmount = consumeAmount;
	}
	
	public long getOrderCount() {
		return this.orderCount;
	}
	
	public void setOrderCount(long orderCount) {
		this.orderCount = orderCount;
	}
	
	public Money getSettleAccountsAmount() {
		return this.settleAccountsAmount;
	}
	
	public void setSettleAccountsAmount(Money settleAccountsAmount) {
		this.settleAccountsAmount = settleAccountsAmount;
	}
	
	public long getPeopleNo() {
		return this.peopleNo;
	}
	
	public void setPeopleNo(long peopleNo) {
		this.peopleNo = peopleNo;
	}
	
	public DiningTableStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(DiningTableStatus status) {
		this.status = status;
	}
	
	public String getTableNumberSeq() {
		return this.tableNumberSeq;
	}
	
	public void setTableNumberSeq(String tableNumberSeq) {
		this.tableNumberSeq = tableNumberSeq;
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
	
	public BooleanEnum getCanSettle() {
		return canSettle;
	}
	
	public void setCanSettle(BooleanEnum canSettle) {
		this.canSettle = canSettle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DiningTableSituationInfo [id=");
		builder.append(id);
		builder.append(", tableNumber=");
		builder.append(tableNumber);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", consumeAmount=");
		builder.append(consumeAmount);
		builder.append(", orderCount=");
		builder.append(orderCount);
		builder.append(", settleAccountsAmount=");
		builder.append(settleAccountsAmount);
		builder.append(", peopleNo=");
		builder.append(peopleNo);
		builder.append(", status=");
		builder.append(status);
		builder.append(", canSettle=");
		builder.append(canSettle);
		builder.append(", tableNumberSeq=");
		builder.append(tableNumberSeq);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
}
