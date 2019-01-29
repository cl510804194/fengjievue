package com.yjf.esupplier.ws.result;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;

public class ValidateCanDebtTransferResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -6654296683886342215L;
	/**
	 * 转让金额下限
	 */
	Money downMoney = new Money(0);
	/**
	 * 转让金额上限
	 */
	Money upMoney = new Money(0);
	/**
	 * 转让截至时间
	 */
	Date deadline;
	
	public Money getDownMoney() {
		return this.downMoney;
	}
	
	public void setDownMoney(Money downMoney) {
		this.downMoney = downMoney;
	}
	
	public Money getUpMoney() {
		return this.upMoney;
	}
	
	public void setUpMoney(Money upMoney) {
		this.upMoney = upMoney;
	}
	
	public Date getDeadline() {
		return this.deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidateCanDebtTransferResult [downMoney=");
		builder.append(downMoney);
		builder.append(", upMoney=");
		builder.append(upMoney);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append(", isSuccess()=");
		builder.append(isSuccess());
		builder.append("]");
		return builder.toString();
	}
	
}
