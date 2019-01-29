package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.enums.DivisionWayEnum;
import com.yjf.esupplier.ws.enums.RepayPlanStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class RepayPlanQueryOrder extends QueryPageBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5589386352556047956L;
	long tradeId;
	long repayUserId;
	String repayUserName;
	String repayUserRealName;
	String tradeName;
	String actualRepayUserName;
	String actualRepayUserRealName;
	
	public String getActualRepayUserRealName() {
		return actualRepayUserRealName;
	}
	
	public void setActualRepayUserRealName(String actualRepayUserRealName) {
		this.actualRepayUserRealName = actualRepayUserRealName;
	}
	
	DivisionWayEnum repayDivisionWay;
	Date startRepayDate;
	Date endRepayDate;
	Date actualStartRepayDate;
	Date actualEndRepayDate;
	String orderBy;
	int periodNo = -1;
	
	public String getOrderBy() {
		return orderBy;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public int getPeriodNo() {
		return periodNo;
	}
	
	public void setPeriodNo(int periodNo) {
		this.periodNo = periodNo;
	}
	
	public Date getActualStartRepayDate() {
		return actualStartRepayDate;
	}
	
	public void setActualStartRepayDate(Date actualStartRepayDate) {
		this.actualStartRepayDate = actualStartRepayDate;
	}
	
	public String getActualRepayUserName() {
		return actualRepayUserName;
	}
	
	public void setActualRepayUserName(String actualRepayUserName) {
		this.actualRepayUserName = actualRepayUserName;
	}
	
	public Date getActualEndRepayDate() {
		return actualEndRepayDate;
	}
	
	public void setActualEndRepayDate(Date actualEndRepayDate) {
		this.actualEndRepayDate = actualEndRepayDate;
	}
	
	List<RepayPlanStatusEnum> statusList;
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public long getRepayUserId() {
		return this.repayUserId;
	}
	
	public void setRepayUserId(long repayUserId) {
		this.repayUserId = repayUserId;
	}
	
	public String getRepayUserName() {
		return this.repayUserName;
	}
	
	public void setRepayUserName(String repayUserName) {
		this.repayUserName = repayUserName;
	}
	
	public String getRepayUserRealName() {
		return this.repayUserRealName;
	}
	
	public void setRepayUserRealName(String repayUserRealName) {
		this.repayUserRealName = repayUserRealName;
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public DivisionWayEnum getRepayDivisionWay() {
		return this.repayDivisionWay;
	}
	
	public void setRepayDivisionWay(DivisionWayEnum repayDivisionWay) {
		this.repayDivisionWay = repayDivisionWay;
	}
	
	public Date getStartRepayDate() {
		return this.startRepayDate;
	}
	
	public void setStartRepayDate(Date startRepayDate) {
		this.startRepayDate = startRepayDate;
	}
	
	public Date getEndRepayDate() {
		return this.endRepayDate;
	}
	
	public void setEndRepayDate(Date endRepayDate) {
		this.endRepayDate = endRepayDate;
	}
	
	public List<RepayPlanStatusEnum> getStatusList() {
		return this.statusList;
	}
	
	public void setStatusList(List<RepayPlanStatusEnum> statusList) {
		this.statusList = statusList;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RepayPlanQueryOrder [tradeId=");
		builder.append(tradeId);
		builder.append(", repayUserId=");
		builder.append(repayUserId);
		builder.append(", repayUserName=");
		builder.append(repayUserName);
		builder.append(", repayUserRealName=");
		builder.append(repayUserRealName);
		builder.append(", tradeName=");
		builder.append(tradeName);
		builder.append(", actualRepayUserName=");
		builder.append(actualRepayUserName);
		builder.append(", actualRepayUserRealName=");
		builder.append(actualRepayUserRealName);
		builder.append(", repayDivisionWay=");
		builder.append(repayDivisionWay);
		builder.append(", startRepayDate=");
		builder.append(startRepayDate);
		builder.append(", endRepayDate=");
		builder.append(endRepayDate);
		builder.append(", actualStartRepayDate=");
		builder.append(actualStartRepayDate);
		builder.append(", actualEndRepayDate=");
		builder.append(actualEndRepayDate);
		builder.append(", orderBy=");
		builder.append(orderBy);
		builder.append(", periodNo=");
		builder.append(periodNo);
		builder.append(", statusList=");
		builder.append(statusList);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
