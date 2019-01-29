/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 下午5:12:45 创建
 */
package com.yjf.esupplier.ws.hotel.info;

import java.io.Serializable;

import com.yjf.common.lang.util.money.Money;

/**
 *
 *
 * @author zhouwei
 *
 */
public class HotelLongDetailInfo implements Serializable {
	
	private static final long serialVersionUID = -3962391023136382855L;
	
	private long id;
	
	private long setId;
	
	private long days;
	
	private long discount;
	
	private Money amount = new Money(0, 0);

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getSetId() {
		return setId;
	}
	
	public void setSetId(long setId) {
		this.setId = setId;
	}
	
	public long getDays() {
		return days;
	}
	
	public void setDays(long days) {
		this.days = days;
	}
	
	public long getDiscount() {
		return discount;
	}
	
	public void setDiscount(long discount) {
		this.discount = discount;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelLongDetailInfo [id=");
		builder.append(id);
		builder.append(", setId=");
		builder.append(setId);
		builder.append(", days=");
		builder.append(days);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}

}
