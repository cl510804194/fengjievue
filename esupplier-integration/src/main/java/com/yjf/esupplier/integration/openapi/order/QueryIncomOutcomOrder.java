package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 收支明细查询参数
 * */

public class QueryIncomOutcomOrder extends ValidateOrderBase implements Order{
	
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1047762468792298679L;

	/** 账户id */
	protected String			userId;
	
	/** 当前页 */
	protected int				pageNo			= 1;
	
	/** 页大小 0 表示不分页 */
	protected int				pageSize		= 20;
	
	/** 起始时间,业务发生时间 :yyyy-MM-dd HH:mm:ss*/
	protected String				beginDate;
	
	/** 终止时间,业务发生时间：yyyy-MM-dd HH:mm:ss */
	protected String				endTime;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	@Override
	public String toString() {
		return "QueryIncomOutcomOrder [userId=" + userId + ", pageNo=" + pageNo + ", pageSize="
				+ pageSize + ", beginDate=" + beginDate + ", endTime=" + endTime + "]";
	}
	


}
