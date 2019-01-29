package com.yjf.esupplier.ws.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.InsureWayEnum;
import com.yjf.esupplier.ws.enums.InternetBankingBizTypeEnum;
import com.yjf.esupplier.ws.enums.LoanBizTypeEnum;
import com.yjf.esupplier.ws.enums.LoanDemandStatusEnum;
import com.yjf.esupplier.ws.enums.LoanPeriodUnitEnum;
import com.yjf.esupplier.ws.enums.TradeFullConditionEnum;

public class CreateLoanDemandOrder extends ProjectDetailOrder implements Order {
	
	private static final long serialVersionUID = 7770200593230659105L;
	/** 借款需求ID */
	private long demandId;
	/** 交易号 */
	private String tradeCode;
	/** 借款人ID */
	private long loanerId;
	/** 借款人用户名 */
	private String userName;
	/** 借款名称 */
	private String loanName;
	/** 借款人姓名 */
	private String loanerName;
	/** 借款规模 */
	private String dimensions;
	/** 借款金额 */
	private Money loanAmount = new Money(0, 0);
	
	/** 借款密码 */
	private String loanPassword;
	
	/** 借款期限的单位:枚举类型D：天，W：周期，M：月，Y：年 */
	private LoanPeriodUnitEnum timeLimitUnit;
	/** 借款期限 */
	private int timeLimit;
	/** 最低投资金额 */
	private Money leastInvestAmount = new Money(0, 0);
	/** 标满条件计算方式：amount：金额，rate：百分比，date：日期 */
	private TradeFullConditionEnum saturationConditionMethod;
	/** 标满条件 */
	private String saturationCondition;
	/** 借款用途 */
	private String loanPurpose;
	/** 有效期 */
	private Date deadline;
	/** 定义标题 */
	private String selfDefinedTitle;
	/** 标的物信息 */
	private String loanNote;
	/** 借款人补充话语 */
	private String loanStatement;
	/** 担保机构ID */
	private long guaranteeId;
	/** 担保机构名称 */
	private String guaranteeName;
	
	/** 担保人话语 */
	private String guaranteeStatement;
	/** 担保合同号 */
	private String guaranteeLicenceNo;
	/** 担保合同名称 */
	private String guaranteeLicenceName;
	/** 上传担保函附件 */
	private String guaranteeLicenseUrl;
	/** 保荐机构ID */
	private long sponsorId;
	/** 保荐机构名称 */
	private String sponsorName;
	
	/** 保荐人话语 */
	private String sponsorStatement;
	
	/** 筹资阶段分润模版 */
	private long investTemplateId;
	
	/** 还款阶段分润模版 */
	private long repayTemplateId;
	
	/** 发布时间 */
	private Date publishDate;
	
	/** 可投资时间 */
	private Date investAvlDate;
	/** 担保函pdf文件路径 */
	private String letterPdfUrl;
	/** 担保履约合同pdf文件路径 */
	private String contractPdfUrl;
	/** 业务类型：public所有人，其他类型 */
	private LoanBizTypeEnum bizType;
	/** 状态 */
	private LoanDemandStatusEnum status;
	
	/** 保障方式 */
	private InsureWayEnum insureWay;
	private String areaNbNo = "001";
	
	private String useGiftMoney;
	
	private String giftMoneyAmount;

    private String giftMoneyIncrease;


    private String [] useGiftMoneyRule;

    private String [] investGiftMoneyRule;

    private String useExperienceAmount;
	
	/** 发布人id */
	private long publishUserId;
	/** 发布人姓名 */
	private String publishUserName;
	/** 审核人id */
	private long checkUserId;
	/** 审核人姓名 */
	private String checkUserName;
	/** 项目信用类型 */
	private String loanType;
	/** 平台产品分类 */
	private String platformType;
	/** 递增金额 */
	private Money investAddAmount = new Money(0, 0);
	/** 合同模板 */
	private String contractTemplate;
	/** 担保金 */
	private Money loanGuaranteeAmount;
	
	private String guaranteeShow;
	
	/*合同模板*/
	private long contractTemplateId;
	/*投资凭证模板*/
	private long receiptTemplateId;
	/*担保函模板*/
	private long letterTemplateId;
	
	/** 抵押物信息 */
	private String guaranty;
	/** 保障信息 */
	private String guaranteeInfo;
	/** 项目信息自定义模块id */
	private String customId;
	/** 自定义模块信息 */
	private String customNote;
	/** 选中的信息模块demandInfoItemId */
	private String selItemId;
    /** 投资收益*/
    private String investmentIncome;


    private String movie_imgUrl;
	
	private InternetBankingBizTypeEnum bankingBizTypeEnum = InternetBankingBizTypeEnum.CLAIMS_RAISE;
	




	@Override
	public void check() {
		this.validateHasText(userName, "借款用户名");
		this.validateMoneyGreaterThanZero(loanAmount, "借款金额");
		this.validateHasZore(guaranteeId, "担保机构ID");
		this.validateGreaterThan(investTemplateId, "筹资阶段分润模版ID");
		this.validateGreaterThan(repayTemplateId, "还款阶段分润模版ID");
		
		// this.validateHasZore(sponsorId, "保荐机构ID");
		this.validateHasText(dimensions, "借款规模");
		this.validateNotNull(timeLimitUnit, "借款期限的单位");
		this.validateNotNull(saturationConditionMethod, "标满条件计算方式");
		this.validateHasText(saturationCondition, "标满条件");
		this.validateHasText(loanPurpose, "借款用途");
		this.validateHasText(guaranteeLicenceNo, "担保合同号");
		this.validateHasText(guaranteeLicenceName, "担保合同名称");
		this.validateHasText(areaNbNo, "项目所属地区的代码");
		this.validateNotNull(bankingBizTypeEnum, "互联网金融类型");
	}
	
	public String getLoanType() {
		return loanType;
	}
	
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public String getPlatformType() {
		return platformType;
	}
	
	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}
	
	public Money getInvestAddAmount() {
		return investAddAmount;
	}
	
	public void setInvestAddAmount(Money investAddAmount) {
		this.investAddAmount = investAddAmount;
	}
	
	public String getContractTemplate() {
		return contractTemplate;
	}
	
	public void setContractTemplate(String contractTemplate) {
		this.contractTemplate = contractTemplate;
	}
	
	public String getSelItemId() {
		return selItemId;
	}
	
	public void setSelItemId(String selItemId) {
		this.selItemId = selItemId;
	}
	
	public String getCustomNote() {
		return customNote;
	}
	
	public void setCustomNote(String customNote) {
		this.customNote = customNote;
	}
	
	public String getCustomId() {
		return customId;
	}
	
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	
	public String getGuaranteeInfo() {
		return guaranteeInfo;
	}
	
	public void setGuaranteeInfo(String guaranteeInfo) {
		this.guaranteeInfo = guaranteeInfo;
	}
	
	public String getGuaranty() {
		return guaranty;
	}
	
	public void setGuaranty(String guaranty) {
		this.guaranty = guaranty;
	}
	
	public String getLoanPassword() {
		return this.loanPassword;
	}
	
	public void setLoanPassword(String loanPassword) {
		this.loanPassword = loanPassword;
	}
	
	@Override
	public long getDemandId() {
		return this.demandId;
	}
	
	@Override
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
	
	public long getInvestTemplateId() {
		return this.investTemplateId;
	}
	
	public void setInvestTemplateId(long investTemplateId) {
		this.investTemplateId = investTemplateId;
	}
	
	public long getRepayTemplateId() {
		return this.repayTemplateId;
	}
	
	public void setRepayTemplateId(long repayTemplateId) {
		this.repayTemplateId = repayTemplateId;
	}
	
	public Date getPublishDate() {
		return this.publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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
	
	public LoanDemandStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(LoanDemandStatusEnum status) {
		this.status = status;
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
	
	public InsureWayEnum getInsureWay() {
		return insureWay;
	}
	
	public void setInsureWay(InsureWayEnum insureWay) {
		this.insureWay = insureWay;
	}
	
	public String getAreaNbNo() {
		return areaNbNo;
	}
	
	public void setAreaNbNo(String areaNbNo) {
		this.areaNbNo = areaNbNo;
	}
	
	public String getGiftMoneyAmount() {
		return giftMoneyAmount;
	}
	
	public void setGiftMoneyAmount(String giftMoneyAmount) {
		this.giftMoneyAmount = giftMoneyAmount;
	}
	
	public String getUseGiftMoney() {
		return useGiftMoney;
	}
	
	public void setUseGiftMoney(String useGiftMoney) {
		this.useGiftMoney = useGiftMoney;
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
	
	public long getContractTemplateId() {
		return contractTemplateId;
	}
	
	public void setContractTemplateId(long contractTemplateId) {
		this.contractTemplateId = contractTemplateId;
	}
	
	public long getReceiptTemplateId() {
		return receiptTemplateId;
	}
	
	public void setReceiptTemplateId(long receiptTemplateId) {
		this.receiptTemplateId = receiptTemplateId;
	}
	
	public long getLetterTemplateId() {
		return letterTemplateId;
	}
	
	public void setLetterTemplateId(long letterTemplateId) {
		this.letterTemplateId = letterTemplateId;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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

    public String getMovie_imgUrl() {
        return movie_imgUrl;
    }

    public void setMovie_imgUrl(String movie_imgUrl) {
        this.movie_imgUrl = movie_imgUrl;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateLoanDemandOrder [demandId=");
		builder.append(demandId);
		builder.append(", tradeCode=");
		builder.append(tradeCode);
		builder.append(", loanerId=");
		builder.append(loanerId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", loanName=");
		builder.append(loanName);
		builder.append(", loanerName=");
		builder.append(loanerName);
		builder.append(", dimensions=");
		builder.append(dimensions);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", loanPassword=");
		builder.append(loanPassword);
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
		builder.append(", investTemplateId=");
		builder.append(investTemplateId);
		builder.append(", repayTemplateId=");
		builder.append(repayTemplateId);
		builder.append(", publishDate=");
		builder.append(publishDate);
		builder.append(", investAvlDate=");
		builder.append(investAvlDate);
		builder.append(", letterPdfUrl=");
		builder.append(letterPdfUrl);
		builder.append(", contractPdfUrl=");
		builder.append(contractPdfUrl);
		builder.append(", bizType=");
		builder.append(bizType);
		builder.append(", status=");
		builder.append(status);
		builder.append(", insureWay=");
		builder.append(insureWay);
		builder.append(", areaNbNo=");
		builder.append(areaNbNo);
		builder.append(", useGiftMoney=");
		builder.append(useGiftMoney);
		builder.append(", giftMoneyAmount=");
		builder.append(giftMoneyAmount);
		builder.append(", publishUserId=");
		builder.append(publishUserId);
		builder.append(", publishUserName=");
		builder.append(publishUserName);
		builder.append(", checkUserId=");
		builder.append(checkUserId);
		builder.append(", checkUserName=");
		builder.append(checkUserName);
		builder.append(", loanType=");
		builder.append(loanType);
		builder.append(", platformType=");
		builder.append(platformType);
		builder.append(", investAddAmount=");
		builder.append(investAddAmount);
		builder.append(", contractTemplate=");
		builder.append(contractTemplate);
		builder.append(", loanGuaranteeAmount=");
		builder.append(loanGuaranteeAmount);
		builder.append(", guaranteeShow=");
		builder.append(guaranteeShow);
		builder.append(", contractTemplateId=");
		builder.append(contractTemplateId);
		builder.append(", receiptTemplateId=");
		builder.append(receiptTemplateId);
		builder.append(", letterTemplateId=");
		builder.append(letterTemplateId);
		builder.append(", guaranty=");
		builder.append(guaranty);
		builder.append(", guaranteeInfo=");
		builder.append(guaranteeInfo);
		builder.append(", customId=");
		builder.append(customId);
		builder.append(", customNote=");
		builder.append(customNote);
		builder.append(", selItemId=");
		builder.append(selItemId);
		builder.append(", bankingBizTypeEnum=");
		builder.append(bankingBizTypeEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
    public String[] getUseGiftMoneyRule() {
        return useGiftMoneyRule;
    }

    public void setUseGiftMoneyRule(String[] useGiftMoneyRule) {
        this.useGiftMoneyRule = useGiftMoneyRule;
    }

    public String[] getInvestGiftMoneyRule() {
        return investGiftMoneyRule;
    }

    public void setInvestGiftMoneyRule(String[] investGiftMoneyRule) {
        this.investGiftMoneyRule = investGiftMoneyRule;
    }

    public String getUseExperienceAmount() {
        return useExperienceAmount;
    }

    public void setUseExperienceAmount(String useExperienceAmount) {
        this.useExperienceAmount = useExperienceAmount;
    }

    public String getGiftMoneyIncrease() {
        return giftMoneyIncrease;
    }

    public void setGiftMoneyIncrease(String giftMoneyIncrease) {
        this.giftMoneyIncrease = giftMoneyIncrease;
    }
}
