package com.yjf.esupplier.ws.lottery.query.order;

import java.util.List;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class LotteryWinnerQueryOrder extends QueryPageBase {
	private long id;
	private List<Long> activityIdList;
	private List<String> statusList;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public List<Long> getActivityIdList() {
		return activityIdList;
	}
	
	public void setActivityIdList(List<Long> activityIdList) {
		this.activityIdList = activityIdList;
	}
	
	public List<String> getStatusList() {
		return statusList;
	}
	
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}
}
