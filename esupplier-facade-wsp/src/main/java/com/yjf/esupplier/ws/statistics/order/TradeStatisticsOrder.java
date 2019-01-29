package com.yjf.esupplier.ws.statistics.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.enums.TradeStatusEnum;

public class TradeStatisticsOrder {
	/** 创建时间开始 */
	Date startDate;
	/** 创建时间结束 */
	Date endDate;
	List<TradeStatusEnum> statusEnums;
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public List<TradeStatusEnum> getStatusEnums() {
		return this.statusEnums;
	}
	
	public void setStatusEnums(List<TradeStatusEnum> statusEnums) {
		this.statusEnums = statusEnums;
	}
	
}
