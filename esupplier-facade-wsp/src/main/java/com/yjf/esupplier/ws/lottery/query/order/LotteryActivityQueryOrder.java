package com.yjf.esupplier.ws.lottery.query.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.lottery.enums.LotteryActivityStatusEnum;
import com.yjf.esupplier.ws.lottery.enums.LotteryTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class LotteryActivityQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = 7867881330587681332L;
	String name;
	
	LotteryTypeEnum lotteryType;
	
	List<LotteryActivityStatusEnum> statusEnums;
	
	Date beginStartDate;
	
	Date endStartDate;
	
	Date beginEndDate;
	
	Date endEndDate;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LotteryTypeEnum getLotteryType() {
		return this.lotteryType;
	}
	
	public void setLotteryType(LotteryTypeEnum lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public List<LotteryActivityStatusEnum> getStatusEnums() {
		return this.statusEnums;
	}
	
	public void setStatusEnums(List<LotteryActivityStatusEnum> statusEnums) {
		this.statusEnums = statusEnums;
	}
	
	public Date getBeginStartDate() {
		return this.beginStartDate;
	}
	
	public void setBeginStartDate(Date beginStartDate) {
		this.beginStartDate = beginStartDate;
	}
	
	public Date getEndStartDate() {
		return this.endStartDate;
	}
	
	public void setEndStartDate(Date endStartDate) {
		this.endStartDate = endStartDate;
	}
	
	public Date getBeginEndDate() {
		return this.beginEndDate;
	}
	
	public void setBeginEndDate(Date beginEndDate) {
		this.beginEndDate = beginEndDate;
	}
	
	public Date getEndEndDate() {
		return this.endEndDate;
	}
	
	public void setEndEndDate(Date endEndDate) {
		this.endEndDate = endEndDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryActivityQueryOrder [name=");
		builder.append(name);
		builder.append(", lotteryType=");
		builder.append(lotteryType);
		builder.append(", statusEnums=");
		builder.append(statusEnums);
		builder.append(", beginStartDate=");
		builder.append(beginStartDate);
		builder.append(", endStartDate=");
		builder.append(endStartDate);
		builder.append(", beginEndDate=");
		builder.append(beginEndDate);
		builder.append(", endEndDate=");
		builder.append(endEndDate);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
