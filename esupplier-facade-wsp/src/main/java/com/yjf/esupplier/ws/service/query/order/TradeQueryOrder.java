package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;
import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.TradeStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class TradeQueryOrder extends QueryPageBase {
	
	private static final long serialVersionUID = -1504962669496543078L;
	/** 贷款金额最小值 */
	Money minLoanAmount;
	/** 贷款金额最大值 */
	Money maxLoanAmount;
	/** 创建时间开始 */
	Date minCreateDate;
	/** 创建时间结束 */
	Date maxCreateDate;
	/** 状态集合 */
	List<TradeStatusEnum> statusList;
	/** 交易编号 */
	String tradeCode;
	/** 有效期 (小于) */
	protected Date deadline;
	
	/** 借款到期日期(小于) */
	protected Date tradeExpireDate;
	
	/** '是否已通知还款人'YES NO */
	protected BooleanEnum tradeIsNotifiedLoaner;
	
	/** '当天是否已通知还款人'YES NO */
	private BooleanEnum hadIntradayNotify;

	/** 借款成立日期 (小于) */
	protected Date tradeEffectiveDate;
	/** 借款超期时间开始 */
	protected Date tradeEndExpireDate;
	/** 借款超期时间结束 */
	protected Date tradeBeginExpireDate;
	
	public Money getMinLoanAmount() {
		return this.minLoanAmount;
	}
	
	public void setMinLoanAmount(Money minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	
	public Money getMaxLoanAmount() {
		return this.maxLoanAmount;
	}
	
	public void setMaxLoanAmount(Money maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	
	public Date getMinCreateDate() {
		return this.minCreateDate;
	}
	
	public void setMinCreateDate(Date minCreateDate) {
		this.minCreateDate = minCreateDate;
	}
	
	public Date getMaxCreateDate() {
		return this.maxCreateDate;
	}
	
	public void setMaxCreateDate(Date maxCreateDate) {
		this.maxCreateDate = maxCreateDate;
	}
	
	public List<TradeStatusEnum> getStatusList() {
		return this.statusList;
	}
	
	public void setStatusList(List<TradeStatusEnum> statusList) {
		this.statusList = statusList;
	}
	
	public String getTradeCode() {
		return this.tradeCode;
	}
	
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	public Date getDeadline() {
		return this.deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public Date getTradeExpireDate() {
		return this.tradeExpireDate;
	}
	
	public void setTradeExpireDate(Date tradeExpireDate) {
		this.tradeExpireDate = tradeExpireDate;
	}
	
	public BooleanEnum getTradeIsNotifiedLoaner() {
		return this.tradeIsNotifiedLoaner;
	}
	
	public void setTradeIsNotifiedLoaner(BooleanEnum tradeIsNotifiedLoaner) {
		this.tradeIsNotifiedLoaner = tradeIsNotifiedLoaner;
	}
	
	public Date getTradeEffectiveDate() {
		return this.tradeEffectiveDate;
	}
	
	public void setTradeEffectiveDate(Date tradeEffectiveDate) {
		this.tradeEffectiveDate = tradeEffectiveDate;
	}
	
	public Date getTradeEndExpireDate() {
		return this.tradeEndExpireDate;
	}
	
	public void setTradeEndExpireDate(Date tradeEndExpireDate) {
		this.tradeEndExpireDate = tradeEndExpireDate;
	}
	
	public Date getTradeBeginExpireDate() {
		return this.tradeBeginExpireDate;
	}
	
	public void setTradeBeginExpireDate(Date tradeBeginExpireDate) {
		this.tradeBeginExpireDate = tradeBeginExpireDate;
	}
	
	public BooleanEnum getHadIntradayNotify() {
		return hadIntradayNotify;
	}

	public void setHadIntradayNotify(BooleanEnum hadIntradayNotify) {
		this.hadIntradayNotify = hadIntradayNotify;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeQueryOrder [minLoanAmount=");
		builder.append(minLoanAmount);
		builder.append(", maxLoanAmount=");
		builder.append(maxLoanAmount);
		builder.append(", minCreateDate=");
		builder.append(minCreateDate);
		builder.append(", maxCreateDate=");
		builder.append(maxCreateDate);
		builder.append(", statusList=");
		builder.append(statusList);
		builder.append(", tradeCode=");
		builder.append(tradeCode);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append(", tradeExpireDate=");
		builder.append(tradeExpireDate);
		builder.append(", tradeIsNotifiedLoaner=");
		builder.append(tradeIsNotifiedLoaner);
		builder.append(", hadIntradayNotify=");
		builder.append(hadIntradayNotify);
		builder.append(", tradeEffectiveDate=");
		builder.append(tradeEffectiveDate);
		builder.append(", tradeEndExpireDate=");
		builder.append(tradeEndExpireDate);
		builder.append(", tradeBeginExpireDate=");
		builder.append(tradeBeginExpireDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
