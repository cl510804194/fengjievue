package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.DivisionPhaseEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.TradeDetailStatusEnum;
import com.yjf.esupplier.ws.enums.TradeDetailTransferStatusEnum;
import com.yjf.esupplier.ws.enums.TradeSourceEnum;

public class TradeDetailData implements Serializable {
	private static final long serialVersionUID = -6230593071119787534L;
	/** 借款明细ID */
	private long tradeDetailId;
	/** 用户ID */
	private long userId;
	/** 用户姓名 */
	private String realName;
	/** 用户登录名 */
	private String userName;
	/** 角色ID */
	private SysUserRoleEnum roleId;
	/** 交易ID */
	private long tradeId;
	/** 金额 */
	private Money amount = new Money(0, 0);
	/** '转账阶段：invest投资阶段，repay还款阶段, original 原始阶段,其它', */
	private DivisionPhaseEnum transferPhase;
	/** '日期' */
	private Date createDate;
	/** 备注 */
	private String note;
	/** 收益类型(0:普通收益，1：额外收益) */
	private boolean profitType;
	/** 年化收益率 */
	private double profitRate;
	/** 外部订单号 */
	private String extOrder;
	/** 交易流水号 */
	private String tradeFlowCode;
	/** 当为分润时 这是原始投资金额 */
	private Money originalAmount = new Money(0, 0);
	private String originalRealName;
	
	private String originalUserName;
	/**
	 * 资金处理状态
	 */
	private TradeDetailStatusEnum status = TradeDetailStatusEnum.UN_PROCESS;
	/**
	 * 债权转让状态
	 */
	private TradeDetailTransferStatusEnum transferStatus = TradeDetailTransferStatusEnum.NOT_TRANSFER;
	/**
	 * 还款期数
	 */
	private int repayPeriodNo;
	/**
	 * 还款总期数
	 */
	private int repayPeriodCount;
	/**
	 * 还款时间
	 */
	private Date repayDate;
	/**
	 * 每次还款的本金时间
	 */
	private Money repayPrincipalAmount = new Money(0, 0);
	
	/**
	 * 实际还款时间
	 */
	private Date actualRepayDate;
	/**
	 * 交易来源，是投资还是转让来的
	 */
	private TradeSourceEnum tradeSource = TradeSourceEnum.INVEST;
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public SysUserRoleEnum getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(SysUserRoleEnum roleId) {
		this.roleId = roleId;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public DivisionPhaseEnum getTransferPhase() {
		return this.transferPhase;
	}
	
	public void setTransferPhase(DivisionPhaseEnum transferPhase) {
		this.transferPhase = transferPhase;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public boolean isProfitType() {
		return this.profitType;
	}
	
	public void setProfitType(boolean profitType) {
		this.profitType = profitType;
	}
	
	public double getProfitRate() {
		return this.profitRate;
	}
	
	public void setProfitRate(double profitRate) {
		this.profitRate = profitRate;
	}
	
	public String getExtOrder() {
		return this.extOrder;
	}
	
	public void setExtOrder(String extOrder) {
		this.extOrder = extOrder;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getTradeFlowCode() {
		return this.tradeFlowCode;
	}
	
	public void setTradeFlowCode(String tradeFlowCode) {
		this.tradeFlowCode = tradeFlowCode;
	}
	
	public Money getOriginalAmount() {
		return this.originalAmount;
	}
	
	public void setOriginalAmount(Money originalAmount) {
		this.originalAmount = originalAmount;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public TradeDetailStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(TradeDetailStatusEnum status) {
		this.status = status;
	}
	
	public String getOriginalRealName() {
		return this.originalRealName;
	}
	
	public void setOriginalRealName(String originalRealName) {
		this.originalRealName = originalRealName;
	}
	
	public String getOriginalUserName() {
		return this.originalUserName;
	}
	
	public void setOriginalUserName(String originalUserName) {
		this.originalUserName = originalUserName;
	}
	
	public TradeDetailTransferStatusEnum getTransferStatus() {
		return this.transferStatus;
	}
	
	public void setTransferStatus(TradeDetailTransferStatusEnum transferStatus) {
		this.transferStatus = transferStatus;
	}
	
	public TradeSourceEnum getTradeSource() {
		return this.tradeSource;
	}
	
	public void setTradeSource(TradeSourceEnum tradeSource) {
		this.tradeSource = tradeSource;
	}
	
	public int getRepayPeriodNo() {
		return this.repayPeriodNo;
	}
	
	public void setRepayPeriodNo(int repayPeriodNo) {
		this.repayPeriodNo = repayPeriodNo;
	}
	
	public int getRepayPeriodCount() {
		return this.repayPeriodCount;
	}
	
	public void setRepayPeriodCount(int repayPeriodCount) {
		this.repayPeriodCount = repayPeriodCount;
	}
	
	public Date getRepayDate() {
		return this.repayDate;
	}
	
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}
	
	public Date getActualRepayDate() {
		return actualRepayDate;
	}
	
	public void setActualRepayDate(Date actualRepayDate) {
		this.actualRepayDate = actualRepayDate;
	}
	
	public Money getRepayPrincipalAmount() {
		return this.repayPrincipalAmount;
	}
	
	public void setRepayPrincipalAmount(Money repayPrincipalAmount) {
		this.repayPrincipalAmount = repayPrincipalAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeDetailData [tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", transferPhase=");
		builder.append(transferPhase);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", note=");
		builder.append(note);
		builder.append(", profitType=");
		builder.append(profitType);
		builder.append(", profitRate=");
		builder.append(profitRate);
		builder.append(", extOrder=");
		builder.append(extOrder);
		builder.append(", tradeFlowCode=");
		builder.append(tradeFlowCode);
		builder.append(", originalAmount=");
		builder.append(originalAmount);
		builder.append(", originalRealName=");
		builder.append(originalRealName);
		builder.append(", originalUserName=");
		builder.append(originalUserName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", transferStatus=");
		builder.append(transferStatus);
		builder.append(", repayPeriodNo=");
		builder.append(repayPeriodNo);
		builder.append(", repayPeriodCount=");
		builder.append(repayPeriodCount);
		builder.append(", repayDate=");
		builder.append(repayDate);
		builder.append(", repayPrincipalAmount=");
		builder.append(repayPrincipalAmount);
		builder.append(", actualRepayDate=");
		builder.append(actualRepayDate);
		builder.append(", tradeSource=");
		builder.append(tradeSource);
		builder.append("]");
		return builder.toString();
	}
	
}
