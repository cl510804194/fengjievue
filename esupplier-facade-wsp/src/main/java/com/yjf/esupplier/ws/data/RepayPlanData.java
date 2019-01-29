package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.DivisionWayEnum;
import com.yjf.esupplier.ws.enums.RepayPlanStatusEnum;

public class RepayPlanData implements Serializable {
	//========== properties ==========
	
	private static final long serialVersionUID = 7377717298522638009L;
	
	private long repayPlanId;
	/**
	 * 还款期号 如第1,2,3 期
	 */
	private int periodNo;
	/**
	 * 还款总期数
	 */
	private int periodCount;
	
	private String tradeName;
	
	private long tradeId;
	
	private long repayUserId;
	
	private String repayUserName;
	
	private String repayUserRealName;
	/**
	 * 还款方式
	 */
	private DivisionWayEnum repayDivisionWay;
	
	/**
	 * 还款金额
	 */
	private Money amount = new Money(0, 0);
	/**
	 * 本次还款本金
	 */
	private Money repayPrincipalAmount = new Money(0, 0);
	/**
	 * 项目借款金额
	 */
	private Money originalAmount = new Money(0, 0);
	
	private RepayPlanStatusEnum status;
	/**
	 * 实际还款时间
	 */
	private Date actualRepayDate;
	
	/**
	 * 计划还款时间
	 */
	private Date repayDate;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	private String note;
	
	private long acutualUserId;

	private Date selfPayActualUserTime;
	
	private String actualRepayUserName;
	
	private String actualRepayUserRealName;
	
	private long repayRoleId;
	
	private String isPay;
	
	public String getIsPay() {
		return isPay;
	}
	
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	
	public long getActualUserId() {
		return acutualUserId;
	}
	
	public void setActualUserId(long acutualUserId) {
		this.acutualUserId = acutualUserId;
	}
	
	public String getActualRepayUserName() {
		return actualRepayUserName;
	}
	
	public void setActualRepayUserName(String actualRepayUserName) {
		this.actualRepayUserName = actualRepayUserName;
	}
	
	public String getActualRepayUserRealName() {
		return actualRepayUserRealName;
	}
	
	public void setActualRepayUserRealName(String actualRepayUserRealName) {
		this.actualRepayUserRealName = actualRepayUserRealName;
	}
	
	public long getRepayRoleId() {
		return repayRoleId;
	}
	
	public void setRepayRoleId(long repayRoleId) {
		this.repayRoleId = repayRoleId;
	}
	
	public long getRepayPlanId() {
		return this.repayPlanId;
	}
	
	public void setRepayPlanId(long repayPlanId) {
		this.repayPlanId = repayPlanId;
	}
	
	public int getPeriodNo() {
		return this.periodNo;
	}
	
	public void setPeriodNo(int periodNo) {
		this.periodNo = periodNo;
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
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
	
	public DivisionWayEnum getRepayDivisionWay() {
		return this.repayDivisionWay;
	}
	
	public void setRepayDivisionWay(DivisionWayEnum repayDivisionWay) {
		this.repayDivisionWay = repayDivisionWay;
	}
	
	public RepayPlanStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(RepayPlanStatusEnum status) {
		this.status = status;
	}
	
	public Date getRepayDate() {
		return this.repayDate;
	}
	
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
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
	
	public Date getActualRepayDate() {
		return this.actualRepayDate;
	}
	
	public void setActualRepayDate(Date actualRepayDate) {
		this.actualRepayDate = actualRepayDate;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public Money getOriginalAmount() {
		return this.originalAmount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public void setOriginalAmount(Money originalAmount) {
		this.originalAmount = originalAmount;
	}
	
	public int getPeriodCount() {
		return this.periodCount;
	}
	
	public void setPeriodCount(int periodCount) {
		this.periodCount = periodCount;
	}
	
	public Money getRepayPrincipalAmount() {
		return this.repayPrincipalAmount;
	}
	
	public void setRepayPrincipalAmount(Money repayPrincipalAmount) {
		this.repayPrincipalAmount = repayPrincipalAmount;
	}
	
	
	public Date getSelfPayActualUserTime() {
		return selfPayActualUserTime;
	}

	public void setSelfPayActualUserTime(Date selfPayActualUserTime) {
		this.selfPayActualUserTime = selfPayActualUserTime;
	}

	public long getAcutualUserId() {
		return this.acutualUserId;
	}
	
	public void setAcutualUserId(long acutualUserId) {
		this.acutualUserId = acutualUserId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RepayPlanData [repayPlanId=");
		builder.append(repayPlanId);
		builder.append(", periodNo=");
		builder.append(periodNo);
		builder.append(", periodCount=");
		builder.append(periodCount);
		builder.append(", tradeName=");
		builder.append(tradeName);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", repayUserId=");
		builder.append(repayUserId);
		builder.append(", repayUserName=");
		builder.append(repayUserName);
		builder.append(", repayUserRealName=");
		builder.append(repayUserRealName);
		builder.append(", repayDivisionWay=");
		builder.append(repayDivisionWay);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", repayPrincipalAmount=");
		builder.append(repayPrincipalAmount);
		builder.append(", originalAmount=");
		builder.append(originalAmount);
		builder.append(", status=");
		builder.append(status);
		builder.append(", actualRepayDate=");
		builder.append(actualRepayDate);
		builder.append(", repayDate=");
		builder.append(repayDate);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", note=");
		builder.append(note);
		builder.append(", acutualUserId=");
		builder.append(acutualUserId);
		builder.append(", actualRepayUserName=");
		builder.append(actualRepayUserName);
		builder.append(", actualRepayUserRealName=");
		builder.append(actualRepayUserRealName);
		builder.append(", repayRoleId=");
		builder.append(repayRoleId);
		builder.append(", isPay=");
		builder.append(isPay);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
