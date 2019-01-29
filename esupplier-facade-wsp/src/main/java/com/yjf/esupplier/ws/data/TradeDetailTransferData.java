package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.DebtTransferStatus;
import com.yjf.esupplier.ws.enums.LoanPeriodUnitEnum;

public class TradeDetailTransferData implements Serializable {
	
	private static final long serialVersionUID = 3872575632183287209L;
	protected long tradeTransferId;
	/**
	 * 申请转让用户ID
	 */
	protected long applyUserId;
	/**
	 * 申请转让用户登录名
	 */
	protected String applyUserName;
	/**
	 * 申请转让用户真实名称
	 */
	protected String applyRealName;
	/**
	 * 转让金额
	 */
	protected Money amount = new Money(0, 0);
	/**
	 * 原始金额
	 */
	protected Money originalAmount = new Money(0, 0);
	/**
	 * 备注
	 */
	protected String note;
	/**
	 * 年化收益率
	 */
	protected double profitRate;
	/**
	 * 关联交易id
	 */
	protected long tradeId;
	/**
	 * 交易名称
	 */
	protected String tradeName;
	/**
	 * 关联投资id
	 */
	protected long tradeDetailId;
	/**
	 * 转让状态
	 */
	protected DebtTransferStatus status;
	
	protected String extOrder;
	/**
	 * 转让接受用户ID
	 */
	protected long recipientId;
	/**
	 * 转让接受用户登录名
	 */
	protected String recipientName;
	/**
	 * 转让接受用户真实名称
	 */
	protected String recipientRealName;
	/**
	 * 发布时间
	 */
	private Date releaseDate;
	/**
	 * 转让时间
	 */
	protected Date transferDate;
	/**
	 * 贷款期限数量
	 */
	protected int timeLimit;
	/**
	 * '借款期限单位：D：天，W：周期，M：月，Y：年'
	 */
	protected LoanPeriodUnitEnum timeLimitUnit;
	/**
	 * 借款成立日期
	 */
	protected Date tradeEffectiveDate;
	/**
	 * 借款到期日期
	 */
	protected Date tradeExpireDate;
	/**
	 * 转让后真实利率
	 */
	protected double realProfitRate;
	
	protected Date rawAddTime;
	
	protected Date rawUpdateTime;
	
	public long getTradeTransferId() {
		return this.tradeTransferId;
	}
	
	public void setTradeTransferId(long tradeTransferId) {
		this.tradeTransferId = tradeTransferId;
	}
	
	public long getApplyUserId() {
		return this.applyUserId;
	}
	
	public void setApplyUserId(long applyUserId) {
		this.applyUserId = applyUserId;
	}
	
	public String getApplyUserName() {
		return this.applyUserName;
	}
	
	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}
	
	public String getApplyRealName() {
		return this.applyRealName;
	}
	
	public void setApplyRealName(String applyRealName) {
		this.applyRealName = applyRealName;
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
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public double getProfitRate() {
		return this.profitRate;
	}
	
	public void setProfitRate(double profitRate) {
		this.profitRate = profitRate;
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public DebtTransferStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(DebtTransferStatus status) {
		this.status = status;
	}
	
	public String getExtOrder() {
		return this.extOrder;
	}
	
	public void setExtOrder(String extOrder) {
		this.extOrder = extOrder;
	}
	
	public long getRecipientId() {
		return this.recipientId;
	}
	
	public void setRecipientId(long recipientId) {
		this.recipientId = recipientId;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public String getRecipientName() {
		return this.recipientName;
	}
	
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	public String getRecipientRealName() {
		return this.recipientRealName;
	}
	
	public void setRecipientRealName(String recipientRealName) {
		this.recipientRealName = recipientRealName;
	}
	
	public Date getTransferDate() {
		return this.transferDate;
	}
	
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
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
	
	public double getRealProfitRate() {
		return this.realProfitRate;
	}
	
	public void setRealProfitRate(double realProfitRate) {
		this.realProfitRate = realProfitRate;
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
	
	public Date getReleaseDate() {
		return this.releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeDetailTransferData [tradeTransferId=");
		builder.append(tradeTransferId);
		builder.append(", applyUserId=");
		builder.append(applyUserId);
		builder.append(", applyUserName=");
		builder.append(applyUserName);
		builder.append(", applyRealName=");
		builder.append(applyRealName);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", originalAmount=");
		builder.append(originalAmount);
		builder.append(", note=");
		builder.append(note);
		builder.append(", profitRate=");
		builder.append(profitRate);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", tradeName=");
		builder.append(tradeName);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", extOrder=");
		builder.append(extOrder);
		builder.append(", recipientId=");
		builder.append(recipientId);
		builder.append(", recipientName=");
		builder.append(recipientName);
		builder.append(", recipientRealName=");
		builder.append(recipientRealName);
		builder.append(", releaseDate=");
		builder.append(releaseDate);
		builder.append(", transferDate=");
		builder.append(transferDate);
		builder.append(", timeLimit=");
		builder.append(timeLimit);
		builder.append(", timeLimitUnit=");
		builder.append(timeLimitUnit);
		builder.append(", tradeEffectiveDate=");
		builder.append(tradeEffectiveDate);
		builder.append(", tradeExpireDate=");
		builder.append(tradeExpireDate);
		builder.append(", realProfitRate=");
		builder.append(realProfitRate);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
