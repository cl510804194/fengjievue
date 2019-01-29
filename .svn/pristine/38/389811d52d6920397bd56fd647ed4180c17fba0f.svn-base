package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.InternetBankingBizTypeEnum;
import com.yjf.esupplier.ws.enums.LoanPeriodUnitEnum;
import com.yjf.esupplier.ws.enums.TradeFullConditionEnum;
import com.yjf.esupplier.ws.enums.TradeStatusEnum;

public class TradeData implements Serializable {
	
	protected static final long serialVersionUID = -354739643562354600L;
	/** 交易ID */
	protected long tradeId;
	/** 交易编号 */
	protected String tradeCode;
	/** 借款需求ID */
	protected long demandId;
	/** 交易名称 */
	protected String tradeName;
	/** 借款金额(以分为单位) */
	protected Money tradeAmount = new Money(0, 0);
	/** 利率 */
	protected double interestRate;
	/** 最低投资金额 */
	protected Money leastInvestAmount = new Money(0, 0);
	/** 标满条件计算方式：amount：金额，rate：百分比，date：日期 */
	protected TradeFullConditionEnum saturationConditionMethod;
	/** 标满条件值 */
	protected String saturationCondition;
	/** 交易状态 */
	protected TradeStatusEnum tradeStatus;
	/** 借款期限 */
	protected int timeLimit;
	/** 借款期限单位：D：天，W：周期，M：月，Y：年 */
	protected LoanPeriodUnitEnum timeLimitUnit;
	/** 有效期 (募集到期时间) */
	protected Date deadline;
	/** 已借款金额(以分为单位) */
	protected Money loanedAmount = new Money(0, 0);
	/** 借款成立日期 */
	protected Date tradeEffectiveDate;
	/** 借款到期日期 */
	protected Date tradeExpireDate;
	/** 创建日期 */
	protected Date tradeCreateDate;
	/** 完成日期 */
	protected Date tradeFinishDate;
	/** 满标时间 */
	private Date investFinishDate;
	/** 当前投资数量 */
	private int investCount = 0;
	/** 描述 */
	protected String tradeNote;
	/** '是否已通知还款人'YES NO */
	protected BooleanEnum tradeIsNotifiedLoaner;
	
	/** '当天是否已通知还款人'YES NO */
	protected BooleanEnum hadIntradayNotify;
	
	protected InternetBankingBizTypeEnum bankingBizTypeEnum = InternetBankingBizTypeEnum.CLAIMS_RAISE;
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public String getTradeCode() {
		return this.tradeCode;
	}
	
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	public long getDemandId() {
		return this.demandId;
	}
	
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public Money getTradeAmount() {
		return this.tradeAmount;
	}
	
	public void setTradeAmount(Money tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public TradeFullConditionEnum getSaturationConditionMethod() {
		return this.saturationConditionMethod;
	}
	
	public void setSaturationConditionMethod(TradeFullConditionEnum saturationConditionMethod) {
		this.saturationConditionMethod = saturationConditionMethod;
	}
	
	public String getSaturationCondition() {
		return this.saturationCondition;
	}
	
	public void setSaturationCondition(String saturationCondition) {
		this.saturationCondition = saturationCondition;
	}
	
	public TradeStatusEnum getTradeStatus() {
		return this.tradeStatus;
	}
	
	public void setTradeStatus(TradeStatusEnum tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
	public int getTimeLimit() {
		return this.timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public LoanPeriodUnitEnum getTimeLimitUnit() {
		return this.timeLimitUnit;
	}
	
	public void setTimeLimitUnit(LoanPeriodUnitEnum timeLimitUnit) {
		this.timeLimitUnit = timeLimitUnit;
	}
	
	public Date getDeadline() {
		return this.deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public Money getLoanedAmount() {
		return this.loanedAmount;
	}
	
	public void setLoanedAmount(Money loanedAmount) {
		this.loanedAmount = loanedAmount;
	}
	
	public Date getTradeEffectiveDate() {
		return this.tradeEffectiveDate;
	}
	
	public void setTradeEffectiveDate(Date tradeEffectiveDate) {
		this.tradeEffectiveDate = tradeEffectiveDate;
	}
	
	public Date getTradeExpireDate() {
		return this.tradeExpireDate;
	}
	
	public void setTradeExpireDate(Date tradeExpireDate) {
		this.tradeExpireDate = tradeExpireDate;
	}
	
	public Date getTradeCreateDate() {
		return this.tradeCreateDate;
	}
	
	public void setTradeCreateDate(Date tradeCreateDate) {
		this.tradeCreateDate = tradeCreateDate;
	}
	
	public Date getTradeFinishDate() {
		return this.tradeFinishDate;
	}
	
	public void setTradeFinishDate(Date tradeFinishDate) {
		this.tradeFinishDate = tradeFinishDate;
	}
	
	public int getInvestCount() {
		return this.investCount;
	}
	
	public void setInvestCount(int investCount) {
		this.investCount = investCount;
	}
	
	public String getTradeNote() {
		return this.tradeNote;
	}
	
	public void setTradeNote(String tradeNote) {
		this.tradeNote = tradeNote;
	}
	
	public BooleanEnum getTradeIsNotifiedLoaner() {
		return this.tradeIsNotifiedLoaner;
	}
	
	public void setTradeIsNotifiedLoaner(BooleanEnum tradeIsNotifiedLoaner) {
		this.tradeIsNotifiedLoaner = tradeIsNotifiedLoaner;
	}
	
	public Money getLeastInvestAmount() {
		return this.leastInvestAmount;
	}
	
	public void setLeastInvestAmount(Money leastInvestAmount) {
		this.leastInvestAmount = leastInvestAmount;
	}
	
	public Date getInvestFinishDate() {
		return this.investFinishDate;
	}
	
	public void setInvestFinishDate(Date investFinishDate) {
		this.investFinishDate = investFinishDate;
	}
	
	public BooleanEnum getHadIntradayNotify() {
		return hadIntradayNotify;
	}
	
	public void setHadIntradayNotify(BooleanEnum hadIntradayNotify) {
		this.hadIntradayNotify = hadIntradayNotify;
	}
	
	public InternetBankingBizTypeEnum getBankingBizTypeEnum() {
		return this.bankingBizTypeEnum;
	}
	
	public void setBankingBizTypeEnum(InternetBankingBizTypeEnum bankingBizTypeEnum) {
		this.bankingBizTypeEnum = bankingBizTypeEnum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeData [tradeId=");
		builder.append(tradeId);
		builder.append(", tradeCode=");
		builder.append(tradeCode);
		builder.append(", demandId=");
		builder.append(demandId);
		builder.append(", tradeName=");
		builder.append(tradeName);
		builder.append(", tradeAmount=");
		builder.append(tradeAmount);
		builder.append(", interestRate=");
		builder.append(interestRate);
		builder.append(", leastInvestAmount=");
		builder.append(leastInvestAmount);
		builder.append(", saturationConditionMethod=");
		builder.append(saturationConditionMethod);
		builder.append(", saturationCondition=");
		builder.append(saturationCondition);
		builder.append(", tradeStatus=");
		builder.append(tradeStatus);
		builder.append(", timeLimit=");
		builder.append(timeLimit);
		builder.append(", timeLimitUnit=");
		builder.append(timeLimitUnit);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append(", loanedAmount=");
		builder.append(loanedAmount);
		builder.append(", tradeEffectiveDate=");
		builder.append(tradeEffectiveDate);
		builder.append(", tradeExpireDate=");
		builder.append(tradeExpireDate);
		builder.append(", tradeCreateDate=");
		builder.append(tradeCreateDate);
		builder.append(", tradeFinishDate=");
		builder.append(tradeFinishDate);
		builder.append(", investFinishDate=");
		builder.append(investFinishDate);
		builder.append(", investCount=");
		builder.append(investCount);
		builder.append(", tradeNote=");
		builder.append(tradeNote);
		builder.append(", tradeIsNotifiedLoaner=");
		builder.append(tradeIsNotifiedLoaner);
		builder.append(", hadIntradayNotify=");
		builder.append(hadIntradayNotify);
		builder.append(", bankingBizTypeEnum=");
		builder.append(bankingBizTypeEnum);
		builder.append("]");
		return builder.toString();
	}
	
}
