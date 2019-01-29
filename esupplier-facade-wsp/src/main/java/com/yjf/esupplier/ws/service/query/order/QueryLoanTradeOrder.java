package com.yjf.esupplier.ws.service.query.order;

import java.util.ArrayList;
import java.util.List;

import com.yjf.common.lang.util.money.Money;
import org.springframework.util.Assert;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class QueryLoanTradeOrder extends QueryPageBase implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 85077599464527497L;
	/** 用户ID */
	private long userId = 0;
	/** 角色ID **/
	private long roleId = 0;
	/** 申请号 */
	private String tradeCode;
	/** 交易名称 */
	private String tradeName;
	/** 借款人用户名 */
	private String userName;
	/** 最小借款金额 */
	private Money minLoanAmount;
	/** 最大借款金额 */
	private Money maxLoanAmount;
	/** 担保机构名称 */
	private String guaranteeName;
	/** 担保函编号 */
	private String guaranteeLicenceNo;
	/** 担保函名称 */
	private String guaranteeLicenceName;
	/** 担保函pdf路径 */
	private String letterPdfUrl;
	/** 担保合同pdf路径 */
	private String contractPdfUrl;
	/** 保荐机构名称 */
	private String sponsorName;
	/** 最小时间 */
	private String startDate;
	/** 最大时间 */
	private String endDate;
	/** 最小还款时间 */
	private String startExpireDate;
	/** 最大还款时间 */
	private String endExpireDate;
	/** 单个状态 */
	private String singleState;
	/** 状态 **/
	private List<String> status = new ArrayList<String>();
	/** 用户ID */
	private long guaranteeId = 0;
	/** 用户ID */
	private long loanderId = 0;
	/** 可投资截止时间 **/
	private String executionDateTime;
	/** 借款生效时间 **/
	private String effectiveDateTime;
	/** 还款时间 **/
	private String expireDateTime;
	/** 充值类型 */
	private String payType;
	/** 是否有担保费 null 表示没有 */
	private String hasBenefitAmount = null;
	private String accountId;
	private String guaranteeAudit;
	
	/**函编号*/
	private String guaranteeLicenseNo;
	/**函名称*/
	private String guaranteeLicenseName;

    private Money minLeastInvestAmount;

    private Money maxLeastInvestAmount;

    private int loanPeriod;

    private String insureWay;
    private String bizType;
    
	String  areaCode;
	String  interestRateBegin;
	String  interestRateEnd;

    String bankingBizTypeEnum;

	public QueryLoanTradeOrder() {
		
	}
	
	public String getGuaranteeLicenseNo() {
		return guaranteeLicenseNo;
	}

	public void setGuaranteeLicenseNo(String guaranteeLicenseNo) {
		this.guaranteeLicenseNo = guaranteeLicenseNo;
	}

	public String getGuaranteeLicenseName() {
		return guaranteeLicenseName;
	}

	public void setGuaranteeLicenseName(String guaranteeLicenseName) {
		this.guaranteeLicenseName = guaranteeLicenseName;
	}

	public QueryLoanTradeOrder(long roleId, String tradeCode) {
		this.roleId = roleId;
		this.tradeCode = tradeCode;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	public String getTradeCode() {
		return tradeCode;
	}
	
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Money getMaxLoanAmount() {
		return maxLoanAmount;
	}
	
	public void setMaxLoanAmount(Money maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	
	public String getGuaranteeName() {
		return guaranteeName;
	}
	
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	
	public String getSponsorName() {
		return sponsorName;
	}
	
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public List<String> getStatus() {
		return status;
	}
	
	public void setStatus(List<String> status) {
		this.status = status;
	}
	
	public String getExecutionDateTime() {
		return executionDateTime;
	}
	
	public void setExecutionDateTime(String executionDateTime) {
		this.executionDateTime = executionDateTime;
	}
	
	public String getEffectiveDateTime() {
		return effectiveDateTime;
	}
	
	public void setEffectiveDateTime(String effectiveDateTime) {
		this.effectiveDateTime = effectiveDateTime;
	}
	
	public long getGuaranteeId() {
		return guaranteeId;
	}
	
	public void setGuaranteeId(long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}
	
	public String getTradeName() {
		return tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public String getStartExpireDate() {
		return startExpireDate;
	}
	
	public void setStartExpireDate(String startExpireDate) {
		this.startExpireDate = startExpireDate;
	}
	
	public String getEndExpireDate() {
		return endExpireDate;
	}
	
	public void setEndExpireDate(String endExpireDate) {
		this.endExpireDate = endExpireDate;
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
	
	public String getSingleState() {
		return singleState;
	}
	
	public void setSingleState(String singleState) {
		this.singleState = singleState;
	}
	
	public String getExpireDateTime() {
		return expireDateTime;
	}
	
	public void setExpireDateTime(String expireDateTime) {
		this.expireDateTime = expireDateTime;
	}
	
	public String getPayType() {
		return payType;
	}
	
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getLetterPdfUrl() {
		return letterPdfUrl;
	}
	
	public void setLetterPdfUrl(String letterPdfUrl) {
		this.letterPdfUrl = letterPdfUrl;
	}
	
	public String getContractPdfUrl() {
		return contractPdfUrl;
	}
	
	public void setContractPdfUrl(String contractPdfUrl) {
		this.contractPdfUrl = contractPdfUrl;
	}
	
	public String getGuaranteeAudit() {
		return guaranteeAudit;
	}
	
	public void setGuaranteeAudit(String guaranteeAudit) {
		this.guaranteeAudit = guaranteeAudit;
	}
	
	public Money getMinLoanAmount() {
		return this.minLoanAmount;
	}
	
	public void setMinLoanAmount(Money minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	
	public long getLoanderId() {
		return this.loanderId;
	}
	
	public void setLoanderId(long loanderId) {
		this.loanderId = loanderId;
	}


    public Money getMinLeastInvestAmount() {
        return minLeastInvestAmount;
    }

    public void setMinLeastInvestAmount(Money minLeastInvestAmount) {
        this.minLeastInvestAmount = minLeastInvestAmount;
    }

    public Money getMaxLeastInvestAmount() {
        return maxLeastInvestAmount;
    }

    public void setMaxLeastInvestAmount(Money maxLeastInvestAmount) {
        this.maxLeastInvestAmount = maxLeastInvestAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getInsureWay() {
        return insureWay;
    }

    public void setInsureWay(String insureWay) {
        this.insureWay = insureWay;
    }
    
    

    public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getInterestRateBegin() {
		return interestRateBegin;
	}

	public void setInterestRateBegin(String interestRateBegin) {
		this.interestRateBegin = interestRateBegin;
	}

	public String getInterestRateEnd() {
		return interestRateEnd;
	}

	public void setInterestRateEnd(String interestRateEnd) {
		this.interestRateEnd = interestRateEnd;
	}

    public String getBankingBizTypeEnum() {
        return bankingBizTypeEnum;
    }

    public void setBankingBizTypeEnum(String bankingBizTypeEnum) {
        this.bankingBizTypeEnum = bankingBizTypeEnum;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryLoanTradeOrder [userId=");
		builder.append(userId);
		builder.append(", guaranteeLicenseName=");
		builder.append(guaranteeLicenseName);
		builder.append(", guaranteeLicenseNo=");
		builder.append(guaranteeLicenseNo);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append(", tradeCode=");
		builder.append(tradeCode);
		builder.append(", tradeName=");
		builder.append(tradeName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", minLoanAmount=");
		builder.append(minLoanAmount);
		builder.append(", maxLoanAmount=");
		builder.append(maxLoanAmount);
		builder.append(", guaranteeName=");
		builder.append(guaranteeName);
		builder.append(", guaranteeLicenceNo=");
		builder.append(guaranteeLicenceNo);
		builder.append(", guaranteeLicenceName=");
		builder.append(guaranteeLicenceName);
		builder.append(", letterPdfUrl=");
		builder.append(letterPdfUrl);
		builder.append(", contractPdfUrl=");
		builder.append(contractPdfUrl);
		builder.append(", sponsorName=");
		builder.append(sponsorName);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", startExpireDate=");
		builder.append(startExpireDate);
		builder.append(", endExpireDate=");
		builder.append(endExpireDate);
		builder.append(", singleState=");
		builder.append(singleState);
		builder.append(", status=");
		builder.append(status);
		builder.append(", guaranteeId=");
		builder.append(guaranteeId);
		builder.append(", loanderId=");
		builder.append(loanderId);
		builder.append(", executionDateTime=");
		builder.append(executionDateTime);
		builder.append(", effectiveDateTime=");
		builder.append(effectiveDateTime);
		builder.append(", expireDateTime=");
		builder.append(expireDateTime);
		builder.append(", payType=");
		builder.append(payType);
		builder.append(", hasBenefitAmount=");
		builder.append(hasBenefitAmount);
		builder.append(", accountId=");
		builder.append(accountId);
		builder.append(", guaranteeAudit=");
		builder.append(guaranteeAudit);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	public String getHasBenefitAmount() {
		return this.hasBenefitAmount;
	}
	
	public void setHasBenefitAmount(String hasBenefitAmount) {
		this.hasBenefitAmount = hasBenefitAmount;
	}
	
	@Override
	public void check() {
		// TODO Auto-generated method stub
		if (StringUtil.isNotBlank(hasBenefitAmount)) {
			Assert.isTrue(guaranteeId > 0, "担保公司id不能为空");
		}
		super.check();
	}
	
	/**
	 * @return
	 * @see com.yjf.common.service.Order#getGid()
	 */
	@Override
	public String getGid() {
		return null;
	}
	
	/**
	 * @param gid
	 * @see com.yjf.common.service.Order#setGid(java.lang.String)
	 */
	@Override
	public void setGid(String gid) {
	}
	
}
