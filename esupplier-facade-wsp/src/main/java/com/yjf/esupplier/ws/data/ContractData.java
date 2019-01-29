package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.ContractStatusEnum;
import com.yjf.esupplier.ws.enums.MatchStatusEnum;
import com.yjf.esupplier.ws.enums.RefundEnum;
import com.yjf.esupplier.ws.enums.SettlementStatusEnum;

public class ContractData implements Serializable {
	private static final long serialVersionUID = -7859473336704325972L;
	
	/**
	 * 合同id
	 */
	private String contractId;

    /**
     * 门店id
     */
    private int storeId;
	
	/**
	 * 用户姓名
	 */
	private String customerName;
	
	/**
	 * 易极付账户id
	 */
	private String yjfAccountId;
	
	/**
	 * 易极付账户名
	 */
	private String yjfAccountName;
	
	/**
	 * 违约金额
	 */
	private long penaltyAmount;
	
	/**
	 * 贷款类型
	 */
	private String loanType;
	
	/**
	 * 商品总价
	 */
	private Money commodityAmount = Money.zero();
	
	/**
	 * 销售人员提成金额
	 */
	private Money percentageAmount = Money.zero();
	
	/**
	 * 贷款期数
	 */
	private int stagesNum;
	
	/**
	 * 贷款金额
	 */
	private Money loanAmount = Money.zero();
	
	/**
	 * 最低还款
	 */
	private Money downPayment = Money.zero();
	
	/**
	 * 每月还款金额
	 */
	private Money monthlyAmount = Money.zero();
	
	/**
	 * 每月还款时间 20150326
	 */
	private Date monthlyLoanTime;
	
	/**
	 * 首次还款日
	 */
	private Date fristLoanTime;
	
	/**
	 * 还款银行卡号
	 */
	private String loanBankNumber;
	
	/**
	 * 开户行
	 */
	private String bank;
	
	/**
	 * 邮寄地址
	 */
	private String postAddress;
	
	/**
	 * 还款状态
	 */
	private RefundEnum refundStatus = RefundEnum.NOT_REFUND;
	
	/**
	 * 合同状态
	 */
	private ContractStatusEnum status = ContractStatusEnum.WAIT;
	
	/**
	 * 认领状态
	 */
	private BooleanEnum takeStatus = BooleanEnum.NO;
	/**
	 * 认领人
	 */
	private int takeUserId;
	/**
	 * 审核时间
	 */
	private Date auditTime;
	
	/**
	 * 审核人id
	 */
	private String auditUserId;
	
	/**
	 * 审核人姓名
	 */
	private String auditUserName;
	
	/**
	 * 校对状态
	 */
	private MatchStatusEnum matchStatus = MatchStatusEnum.WAIT;
	
	/**
	 * 校对时间
	 */
	private Date matchTime;
	
	/**
	 * 校对人id
	 */
	private String matchUserId;
	
	/**
	 * 校对人姓名
	 */
	private String matchUserName;
	
	/**
	 * 结算状态
	 */
	private SettlementStatusEnum settlementStatus = SettlementStatusEnum.WAIT;
	
	/**
	 * 审核备注
	 */
	private String auditRemark;
	
	/**
	 * 校对备注
	 */
	private String matchRemark;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getContractId() {
		return this.contractId;
	}
	
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getYjfAccountId() {
		return this.yjfAccountId;
	}
	
	public void setYjfAccountId(String yjfAccountId) {
		this.yjfAccountId = yjfAccountId;
	}
	
	public String getYjfAccountName() {
		return this.yjfAccountName;
	}
	
	public void setYjfAccountName(String yjfAccountName) {
		this.yjfAccountName = yjfAccountName;
	}
	
	public long getPenaltyAmount() {
		return this.penaltyAmount;
	}
	
	public void setPenaltyAmount(long penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}
	
	public String getLoanType() {
		return this.loanType;
	}
	
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public Money getCommodityAmount() {
		return this.commodityAmount;
	}
	
	public void setCommodityAmount(Money commodityAmount) {
		this.commodityAmount = commodityAmount;
	}
	
	public Money getPercentageAmount() {
		return this.percentageAmount;
	}
	
	public void setPercentageAmount(Money percentageAmount) {
		this.percentageAmount = percentageAmount;
	}
	
	public int getStagesNum() {
		return this.stagesNum;
	}
	
	public void setStagesNum(int stagesNum) {
		this.stagesNum = stagesNum;
	}
	
	public Money getLoanAmount() {
		return this.loanAmount;
	}
	
	public void setLoanAmount(Money loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public Money getDownPayment() {
		return this.downPayment;
	}
	
	public void setDownPayment(Money downPayment) {
		this.downPayment = downPayment;
	}
	
	public Money getMonthlyAmount() {
		return this.monthlyAmount;
	}
	
	public void setMonthlyAmount(Money monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}
	
	public Date getMonthlyLoanTime() {
		return this.monthlyLoanTime;
	}
	
	public void setMonthlyLoanTime(Date monthlyLoanTime) {
		this.monthlyLoanTime = monthlyLoanTime;
	}
	
	public Date getFristLoanTime() {
		return this.fristLoanTime;
	}
	
	public void setFristLoanTime(Date fristLoanTime) {
		this.fristLoanTime = fristLoanTime;
	}
	
	public String getLoanBankNumber() {
		return this.loanBankNumber;
	}
	
	public void setLoanBankNumber(String loanBankNumber) {
		this.loanBankNumber = loanBankNumber;
	}
	
	public String getBank() {
		return this.bank;
	}
	
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	public String getPostAddress() {
		return this.postAddress;
	}
	
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	
	public RefundEnum getRefundStatus() {
		return this.refundStatus;
	}
	
	public void setRefundStatus(RefundEnum refundStatus) {
		this.refundStatus = refundStatus;
	}
	
	public ContractStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(ContractStatusEnum status) {
		this.status = status;
	}
	
	public Date getAuditTime() {
		return this.auditTime;
	}
	
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	
	public String getAuditUserId() {
		return this.auditUserId;
	}
	
	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}
	
	public String getAuditUserName() {
		return this.auditUserName;
	}
	
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}
	
	public MatchStatusEnum getMatchStatus() {
		return this.matchStatus;
	}
	
	public void setMatchStatus(MatchStatusEnum matchStatus) {
		this.matchStatus = matchStatus;
	}
	
	public Date getMatchTime() {
		return this.matchTime;
	}
	
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}
	
	public String getMatchUserId() {
		return this.matchUserId;
	}
	
	public void setMatchUserId(String matchUserId) {
		this.matchUserId = matchUserId;
	}
	
	public String getMatchUserName() {
		return this.matchUserName;
	}
	
	public void setMatchUserName(String matchUserName) {
		this.matchUserName = matchUserName;
	}
	
	public SettlementStatusEnum getSettlementStatus() {
		return this.settlementStatus;
	}
	
	public void setSettlementStatus(SettlementStatusEnum settlementStatus) {
		this.settlementStatus = settlementStatus;
	}
	
	public String getAuditRemark() {
		return this.auditRemark;
	}
	
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	
	public String getMatchRemark() {
		return this.matchRemark;
	}
	
	public void setMatchRemark(String matchRemark) {
		this.matchRemark = matchRemark;
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
	
	public BooleanEnum getTakeStatus() {
		return this.takeStatus;
	}
	
	public void setTakeStatus(BooleanEnum takeStatus) {
		this.takeStatus = takeStatus;
	}

    public int getTakeUserId() {
        return takeUserId;
    }

    public void setTakeUserId(int takeUserId) {
        this.takeUserId = takeUserId;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContractData [contractId=");
		builder.append(contractId);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", yjfAccountId=");
		builder.append(yjfAccountId);
		builder.append(", yjfAccountName=");
		builder.append(yjfAccountName);
		builder.append(", penaltyAmount=");
		builder.append(penaltyAmount);
		builder.append(", loanType=");
		builder.append(loanType);
		builder.append(", commodityAmount=");
		builder.append(commodityAmount);
		builder.append(", percentageAmount=");
		builder.append(percentageAmount);
		builder.append(", stagesNum=");
		builder.append(stagesNum);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", downPayment=");
		builder.append(downPayment);
		builder.append(", monthlyAmount=");
		builder.append(monthlyAmount);
		builder.append(", monthlyLoanTime=");
		builder.append(monthlyLoanTime);
		builder.append(", fristLoanTime=");
		builder.append(fristLoanTime);
		builder.append(", loanBankNumber=");
		builder.append(loanBankNumber);
		builder.append(", bank=");
		builder.append(bank);
		builder.append(", postAddress=");
		builder.append(postAddress);
		builder.append(", refundStatus=");
		builder.append(refundStatus);
		builder.append(", status=");
		builder.append(status);
		builder.append(", auditTime=");
		builder.append(auditTime);
		builder.append(", auditUserId=");
		builder.append(auditUserId);
		builder.append(", auditUserName=");
		builder.append(auditUserName);
		builder.append(", matchStatus=");
		builder.append(matchStatus);
		builder.append(", matchTime=");
		builder.append(matchTime);
		builder.append(", matchUserId=");
		builder.append(matchUserId);
		builder.append(", matchUserName=");
		builder.append(matchUserName);
		builder.append(", settlementStatus=");
		builder.append(settlementStatus);
		builder.append(", auditRemark=");
		builder.append(auditRemark);
		builder.append(", matchRemark=");
		builder.append(matchRemark);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
