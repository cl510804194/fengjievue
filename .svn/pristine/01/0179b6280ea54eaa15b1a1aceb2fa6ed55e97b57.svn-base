package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.DivisionWayEnum;
import com.yjf.esupplier.ws.enums.InternetBankingBizTypeEnum;
import com.yjf.esupplier.ws.enums.LoanBizTypeEnum;
import com.yjf.esupplier.ws.enums.LoanDemandStatusEnum;
import com.yjf.esupplier.ws.enums.LoanPeriodUnitEnum;
import com.yjf.esupplier.ws.enums.TradeFullConditionEnum;

public class LoanDemandData implements Serializable {
	protected static final long serialVersionUID = 1663412872486743290L;
	// ========== properties ==========
	/** 借款需求ID */
	protected long demandId;
	/** 交易号 */
	protected String tradeCode;
	/** 借款人ID */
	protected long loanerId;
	/** 借款人用户名 */
	protected String userName;
	/** 借款人姓名 */
	private String loanerName;
	/** 借款名称 */
	protected String loanName;
	/** 借款规模 */
	protected String dimensions;
	/** 借款金额 */
	protected Money loanAmount = new Money(0, 0);
	/** 借款密码 */
	protected String loanPassword;
	/** 利率 */
	protected double interestRate;
	/** 借款期限的单位:枚举类型D：天，W：周期，M：月，Y：年 */
	protected LoanPeriodUnitEnum timeLimitUnit;
	/** 借款期限 */
	protected int timeLimit;
	/** 最低投资金额 */
	protected Money leastInvestAmount = new Money(0, 0);
	/** 标满条件计算方式：amount：金额，rate：百分比，date：日期 */
	protected TradeFullConditionEnum saturationConditionMethod;
	/** 标满条件 */
	protected String saturationCondition;
	/** 借款用途 */
	protected String loanPurpose;
	/** 有效期 */
	protected Date deadline;
	/** 定义标题 */
	protected String selfDefinedTitle;
	/** 标的物信息 */
	protected String loanNote;
	/** 借款人补充话语 */
	protected String loanStatement;
	/** 担保机构ID */
	protected long guaranteeId;
	/** 担保机构名称 */
	protected String guaranteeName;
	
	/** 担保人话语 */
	protected String guaranteeStatement;
	/** 担保合同号 */
	protected String guaranteeLicenceNo;
	/** 担保合同名称 */
	protected String guaranteeLicenceName;
	/** 上传担保函附件 */
	protected String guaranteeLicenseUrl;
	/** 保荐机构ID */
	protected long sponsorId;
	/** 保荐机构名称 */
	protected String sponsorName;
	
	/** 保荐人话语 */
	protected String sponsorStatement;
	/** 状态 */
	protected LoanDemandStatusEnum status = LoanDemandStatusEnum.DRAFT;
	/** 分润模版baseId */
	protected long divisionTemplateId;
	
	/** 需求创建时间 */
	protected Date demandDate;
	/** 发布时间 */
	protected Date publishDate;
	/** 驳回原因 */
	protected String dismissReason;
	/** 担保公司是否审核 'IS','NO' */
	protected BooleanEnum guaranteeAudit = BooleanEnum.NO;
	/** 还款方式 */
	private DivisionWayEnum repayDivisionWay;
	
	/** 可投资时间 */
	protected Date investAvlDate;
	/** 担保函pdf文件路径 */
	protected String letterPdfUrl;
	/** 担保履约合同pdf文件路径 */
	protected String contractPdfUrl;
	/** 业务类型：public所有人，其他类型 */
	protected LoanBizTypeEnum bizType = LoanBizTypeEnum.PUBLIC;
	
	private String insureWay;// 默认为：其他
	private String areaNbNo;
	
	private Money loanGuaranteeAmount;
	private String guaranteeShow;
	
	private long publishUserId;
	private String publishUserName;
	private long checkUserId;
	private String checkUserName;
    private String investmentIncome;
	
	private InternetBankingBizTypeEnum bankingBizTypeEnum = InternetBankingBizTypeEnum.CLAIMS_RAISE;
	
	public String getAreaNbNo() {
		return areaNbNo;
	}
	
	public void setAreaNbNo(String areaNbNo) {
		this.areaNbNo = areaNbNo;
	}
	
	public String getLoanPassword() {
		return this.loanPassword;
	}
	
	public void setLoanPassword(String loanPassword) {
		this.loanPassword = loanPassword;
	}
	
	public long getDemandId() {
		return this.demandId;
	}
	
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	
	public String getTradeCode() {
		return this.tradeCode;
	}
	
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	public long getLoanerId() {
		return this.loanerId;
	}
	
	public void setLoanerId(long loanerId) {
		this.loanerId = loanerId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getLoanName() {
		return this.loanName;
	}
	
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	
	public String getDimensions() {
		return this.dimensions;
	}
	
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
	public Money getLoanAmount() {
		return this.loanAmount;
	}
	
	public void setLoanAmount(Money loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public LoanPeriodUnitEnum getTimeLimitUnit() {
		return this.timeLimitUnit;
	}
	
	public void setTimeLimitUnit(LoanPeriodUnitEnum timeLimitUnit) {
		this.timeLimitUnit = timeLimitUnit;
	}
	
	public int getTimeLimit() {
		return this.timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
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
	
	public String getLoanPurpose() {
		return this.loanPurpose;
	}
	
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	
	public Date getDeadline() {
		return this.deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public String getSelfDefinedTitle() {
		return this.selfDefinedTitle;
	}
	
	public void setSelfDefinedTitle(String selfDefinedTitle) {
		this.selfDefinedTitle = selfDefinedTitle;
	}
	
	public String getLoanNote() {
		return this.loanNote;
	}
	
	public void setLoanNote(String loanNote) {
		this.loanNote = loanNote;
	}
	
	public String getLoanStatement() {
		return this.loanStatement;
	}
	
	public void setLoanStatement(String loanStatement) {
		this.loanStatement = loanStatement;
	}
	
	public long getGuaranteeId() {
		return this.guaranteeId;
	}
	
	public void setGuaranteeId(long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}
	
	public String getGuaranteeName() {
		return this.guaranteeName;
	}
	
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	
	public String getGuaranteeStatement() {
		return this.guaranteeStatement;
	}
	
	public void setGuaranteeStatement(String guaranteeStatement) {
		this.guaranteeStatement = guaranteeStatement;
	}
	
	public String getGuaranteeLicenceNo() {
		return this.guaranteeLicenceNo;
	}
	
	public void setGuaranteeLicenceNo(String guaranteeLicenceNo) {
		this.guaranteeLicenceNo = guaranteeLicenceNo;
	}
	
	public String getGuaranteeLicenceName() {
		return this.guaranteeLicenceName;
	}
	
	public void setGuaranteeLicenceName(String guaranteeLicenceName) {
		this.guaranteeLicenceName = guaranteeLicenceName;
	}
	
	public String getGuaranteeLicenseUrl() {
		return this.guaranteeLicenseUrl;
	}
	
	public void setGuaranteeLicenseUrl(String guaranteeLicenseUrl) {
		this.guaranteeLicenseUrl = guaranteeLicenseUrl;
	}
	
	public long getSponsorId() {
		return this.sponsorId;
	}
	
	public void setSponsorId(long sponsorId) {
		this.sponsorId = sponsorId;
	}
	
	public String getSponsorName() {
		return this.sponsorName;
	}
	
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	
	public String getSponsorStatement() {
		return this.sponsorStatement;
	}
	
	public void setSponsorStatement(String sponsorStatement) {
		this.sponsorStatement = sponsorStatement;
	}
	
	public LoanDemandStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(LoanDemandStatusEnum status) {
		this.status = status;
	}
	
	public long getDivisionTemplateId() {
		return this.divisionTemplateId;
	}
	
	public void setDivisionTemplateId(long divisionTemplateId) {
		this.divisionTemplateId = divisionTemplateId;
	}
	
	public Date getDemandDate() {
		return this.demandDate;
	}
	
	public void setDemandDate(Date demandDate) {
		this.demandDate = demandDate;
	}
	
	public Date getPublishDate() {
		return this.publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getDismissReason() {
		return this.dismissReason;
	}
	
	public void setDismissReason(String dismissReason) {
		this.dismissReason = dismissReason;
	}
	
	public BooleanEnum getGuaranteeAudit() {
		return this.guaranteeAudit;
	}
	
	public void setGuaranteeAudit(BooleanEnum guaranteeAudit) {
		this.guaranteeAudit = guaranteeAudit;
	}
	
	public Date getInvestAvlDate() {
		return this.investAvlDate;
	}
	
	public void setInvestAvlDate(Date investAvlDate) {
		this.investAvlDate = investAvlDate;
	}
	
	public String getLetterPdfUrl() {
		return this.letterPdfUrl;
	}
	
	public void setLetterPdfUrl(String letterPdfUrl) {
		this.letterPdfUrl = letterPdfUrl;
	}
	
	public String getContractPdfUrl() {
		return this.contractPdfUrl;
	}
	
	public void setContractPdfUrl(String contractPdfUrl) {
		this.contractPdfUrl = contractPdfUrl;
	}
	
	public LoanBizTypeEnum getBizType() {
		return this.bizType;
	}
	
	public void setBizType(LoanBizTypeEnum bizType) {
		this.bizType = bizType;
	}
	
	public Money getLeastInvestAmount() {
		return this.leastInvestAmount;
	}
	
	public void setLeastInvestAmount(Money leastInvestAmount) {
		this.leastInvestAmount = leastInvestAmount;
	}
	
	public String getLoanerName() {
		return this.loanerName;
	}
	
	public void setLoanerName(String loanerName) {
		this.loanerName = loanerName;
	}
	
	public DivisionWayEnum getRepayDivisionWay() {
		return this.repayDivisionWay;
	}
	
	public void setRepayDivisionWay(DivisionWayEnum repayDivisionWay) {
		this.repayDivisionWay = repayDivisionWay;
	}
	
	public String getInsureWay() {
		return insureWay;
	}
	
	public void setInsureWay(String insureWay) {
		this.insureWay = insureWay;
	}
	
	public long getPublishUserId() {
		return publishUserId;
	}
	
	public void setPublishUserId(long publishUserId) {
		this.publishUserId = publishUserId;
	}
	
	public String getPublishUserName() {
		return publishUserName;
	}
	
	public void setPublishUserName(String publishUserName) {
		this.publishUserName = publishUserName;
	}
	
	public long getCheckUserId() {
		return checkUserId;
	}
	
	public void setCheckUserId(long checkUserId) {
		this.checkUserId = checkUserId;
	}
	
	public String getCheckUserName() {
		return checkUserName;
	}
	
	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
	
	public Money getLoanGuaranteeAmount() {
		return loanGuaranteeAmount;
	}
	
	public void setLoanGuaranteeAmount(Money loanGuaranteeAmount) {
		this.loanGuaranteeAmount = loanGuaranteeAmount;
	}
	
	public String getGuaranteeShow() {
		return guaranteeShow;
	}
	
	public void setGuaranteeShow(String guaranteeShow) {
		this.guaranteeShow = guaranteeShow;
	}
	
	public InternetBankingBizTypeEnum getBankingBizTypeEnum() {
		return this.bankingBizTypeEnum;
	}
	
	public void setBankingBizTypeEnum(InternetBankingBizTypeEnum bankingBizTypeEnum) {
		this.bankingBizTypeEnum = bankingBizTypeEnum;
	}

    public String getInvestmentIncome() {
        return investmentIncome;
    }

    public void setInvestmentIncome(String investmentIncome) {
        this.investmentIncome = investmentIncome;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandData [demandId=");
		builder.append(demandId);
		builder.append(", tradeCode=");
		builder.append(tradeCode);
		builder.append(", loanerId=");
		builder.append(loanerId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", loanerName=");
		builder.append(loanerName);
		builder.append(", loanName=");
		builder.append(loanName);
		builder.append(", dimensions=");
		builder.append(dimensions);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", loanPassword=");
		builder.append(loanPassword);
		builder.append(", interestRate=");
		builder.append(interestRate);
		builder.append(", timeLimitUnit=");
		builder.append(timeLimitUnit);
		builder.append(", timeLimit=");
		builder.append(timeLimit);
		builder.append(", leastInvestAmount=");
		builder.append(leastInvestAmount);
		builder.append(", saturationConditionMethod=");
		builder.append(saturationConditionMethod);
		builder.append(", saturationCondition=");
		builder.append(saturationCondition);
		builder.append(", loanPurpose=");
		builder.append(loanPurpose);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append(", selfDefinedTitle=");
		builder.append(selfDefinedTitle);
		builder.append(", loanNote=");
		builder.append(loanNote);
		builder.append(", loanStatement=");
		builder.append(loanStatement);
		builder.append(", guaranteeId=");
		builder.append(guaranteeId);
		builder.append(", guaranteeName=");
		builder.append(guaranteeName);
		builder.append(", guaranteeStatement=");
		builder.append(guaranteeStatement);
		builder.append(", guaranteeLicenceNo=");
		builder.append(guaranteeLicenceNo);
		builder.append(", guaranteeLicenceName=");
		builder.append(guaranteeLicenceName);
		builder.append(", guaranteeLicenseUrl=");
		builder.append(guaranteeLicenseUrl);
		builder.append(", sponsorId=");
		builder.append(sponsorId);
		builder.append(", sponsorName=");
		builder.append(sponsorName);
		builder.append(", sponsorStatement=");
		builder.append(sponsorStatement);
		builder.append(", status=");
		builder.append(status);
		builder.append(", divisionTemplateId=");
		builder.append(divisionTemplateId);
		builder.append(", demandDate=");
		builder.append(demandDate);
		builder.append(", publishDate=");
		builder.append(publishDate);
		builder.append(", dismissReason=");
		builder.append(dismissReason);
		builder.append(", guaranteeAudit=");
		builder.append(guaranteeAudit);
		builder.append(", repayDivisionWay=");
		builder.append(repayDivisionWay);
		builder.append(", investAvlDate=");
		builder.append(investAvlDate);
		builder.append(", letterPdfUrl=");
		builder.append(letterPdfUrl);
		builder.append(", contractPdfUrl=");
		builder.append(contractPdfUrl);
		builder.append(", bizType=");
		builder.append(bizType);
		builder.append(", insureWay=");
		builder.append(insureWay);
		builder.append(", areaNbNo=");
		builder.append(areaNbNo);
		builder.append(", loanGuaranteeAmount=");
		builder.append(loanGuaranteeAmount);
		builder.append(", guaranteeShow=");
		builder.append(guaranteeShow);
		builder.append(", publishUserId=");
		builder.append(publishUserId);
		builder.append(", publishUserName=");
		builder.append(publishUserName);
		builder.append(", checkUserId=");
		builder.append(checkUserId);
		builder.append(", checkUserName=");
		builder.append(checkUserName);
		builder.append(", bankingBizTypeEnum=");
		builder.append(bankingBizTypeEnum);
		builder.append("]");
		return builder.toString();
	}
	
}
