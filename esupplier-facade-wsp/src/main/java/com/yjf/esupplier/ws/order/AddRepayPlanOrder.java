package com.yjf.esupplier.ws.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.DivisionWayEnum;
import com.yjf.esupplier.ws.enums.RepayPlanStatusEnum;

public class AddRepayPlanOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 5054261062039851133L;
	
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
	
	private long acutalUserId;
	
	private String actualRepayUserName;
	
	private String actualRepayUserRealName;
	
	private long repayRoleId;
	
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
	
	public int getPeriodCount() {
		return this.periodCount;
	}
	
	public void setPeriodCount(int periodCount) {
		this.periodCount = periodCount;
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
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public Money getOriginalAmount() {
		return this.originalAmount;
	}
	
	public void setOriginalAmount(Money originalAmount) {
		this.originalAmount = originalAmount;
	}
	
	public RepayPlanStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(RepayPlanStatusEnum status) {
		this.status = status;
	}
	
	public Date getActualRepayDate() {
		return this.actualRepayDate;
	}
	
	public void setActualRepayDate(Date actualRepayDate) {
		this.actualRepayDate = actualRepayDate;
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
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public long getAcutalUserId() {
		return this.acutalUserId;
	}
	
	public void setAcutalUserId(long acutalUserId) {
		this.acutalUserId = acutalUserId;
	}
	
	public String getActualRepayUserName() {
		return this.actualRepayUserName;
	}
	
	public void setActualRepayUserName(String actualRepayUserName) {
		this.actualRepayUserName = actualRepayUserName;
	}
	
	public String getActualRepayUserRealName() {
		return this.actualRepayUserRealName;
	}
	
	public void setActualRepayUserRealName(String actualRepayUserRealName) {
		this.actualRepayUserRealName = actualRepayUserRealName;
	}
	
	public long getRepayRoleId() {
		return this.repayRoleId;
	}
	
	public void setRepayRoleId(long repayRoleId) {
		this.repayRoleId = repayRoleId;
	}
	
	@Override
	public void check() {
		validateHasZore(tradeId, "交易流水号");
		validateHasZore(repayUserId, "还款人用户Id");
		validateHasZore(repayPlanId, "还款计划Id");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddRepayPlanOrder [repayPlanId=");
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
		builder.append(", acutalUserId=");
		builder.append(acutalUserId);
		builder.append(", actualRepayUserName=");
		builder.append(actualRepayUserName);
		builder.append(", actualRepayUserRealName=");
		builder.append(actualRepayUserRealName);
		builder.append(", repayRoleId=");
		builder.append(repayRoleId);
		builder.append("]");
		return builder.toString();
	}
	
}
