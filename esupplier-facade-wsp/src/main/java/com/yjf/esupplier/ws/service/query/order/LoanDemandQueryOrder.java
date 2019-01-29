package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;
import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.InternetBankingBizTypeEnum;
import com.yjf.esupplier.ws.enums.LoanDemandStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class LoanDemandQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = 4234897120927969588L;
	/** 贷款金额最小值 */
	Money minLoanAmount;
	/** 贷款金额最大值 */
	Money maxLoanAmount;
	/** 创建时间开始 */
	Date minDemandDate;
	/** 创建时间结束 */
	Date maxDemandDate;
	/** 状态集合 */
	List<LoanDemandStatusEnum> statusList;
	
	/** 发布时间 */
	protected Date publishDate;
	/** 保荐机构名称 */
	protected String sponsorName;
	
	/** 担保合同名称 */
	protected String guaranteeLicenceName;
	/** 担保函 */
	protected String guaranteeLicenceNo;
	
	/** 担保机构名称 */
	protected String guaranteeName;
	
	/** 借款人用户名 */
	protected String userName;
	
	/** 交易号 */
	protected String tradeCode;
	
	/** 担保机构ID */
	protected long guaranteeId;
	
	/** 借款人ID */
	protected long loanerId;
	/** id */
	protected long demandId;
	/**
	 * 担保函不为空（表示查询数据库字段为null）
	 */
	protected String letterPdfUrl;
	/**
	 * 合同不为空 （表示查询数据库字段为null）
	 */
	protected String contractPdfUrl;
	
	protected InternetBankingBizTypeEnum bankingBizTypeEnum;
	
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
	
	public Date getMinDemandDate() {
		return this.minDemandDate;
	}
	
	public void setMinDemandDate(Date minDemandDate) {
		this.minDemandDate = minDemandDate;
	}
	
	public Date getMaxDemandDate() {
		return this.maxDemandDate;
	}
	
	public void setMaxDemandDate(Date maxDemandDate) {
		this.maxDemandDate = maxDemandDate;
	}
	
	public List<LoanDemandStatusEnum> getStatusList() {
		return this.statusList;
	}
	
	public void setStatusList(List<LoanDemandStatusEnum> statusList) {
		this.statusList = statusList;
	}
	
	public Date getPublishDate() {
		return this.publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getSponsorName() {
		return this.sponsorName;
	}
	
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	
	public String getGuaranteeLicenceName() {
		return this.guaranteeLicenceName;
	}
	
	public void setGuaranteeLicenceName(String guaranteeLicenceName) {
		this.guaranteeLicenceName = guaranteeLicenceName;
	}
	
	public String getGuaranteeName() {
		return this.guaranteeName;
	}
	
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getTradeCode() {
		return this.tradeCode;
	}
	
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	public long getGuaranteeId() {
		return this.guaranteeId;
	}
	
	public void setGuaranteeId(long guaranteeId) {
		this.guaranteeId = guaranteeId;
	}
	
	public long getLoanerId() {
		return this.loanerId;
	}
	
	public void setLoanerId(long loanerId) {
		this.loanerId = loanerId;
	}
	
	public String getGuaranteeLicenceNo() {
		return this.guaranteeLicenceNo;
	}
	
	public void setGuaranteeLicenceNo(String guaranteeLicenceNo) {
		this.guaranteeLicenceNo = guaranteeLicenceNo;
	}
	
	public long getDemandId() {
		return this.demandId;
	}
	
	public void setDemandId(long demandId) {
		this.demandId = demandId;
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
	
	public InternetBankingBizTypeEnum getBankingBizTypeEnum() {
		return this.bankingBizTypeEnum;
	}
	
	public void setBankingBizTypeEnum(InternetBankingBizTypeEnum bankingBizTypeEnum) {
		this.bankingBizTypeEnum = bankingBizTypeEnum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandQueryOrder [minLoanAmount=");
		builder.append(minLoanAmount);
		builder.append(", maxLoanAmount=");
		builder.append(maxLoanAmount);
		builder.append(", minDemandDate=");
		builder.append(minDemandDate);
		builder.append(", maxDemandDate=");
		builder.append(maxDemandDate);
		builder.append(", statusList=");
		builder.append(statusList);
		builder.append(", publishDate=");
		builder.append(publishDate);
		builder.append(", sponsorName=");
		builder.append(sponsorName);
		builder.append(", guaranteeLicenceName=");
		builder.append(guaranteeLicenceName);
		builder.append(", guaranteeLicenceNo=");
		builder.append(guaranteeLicenceNo);
		builder.append(", guaranteeName=");
		builder.append(guaranteeName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", tradeCode=");
		builder.append(tradeCode);
		builder.append(", guaranteeId=");
		builder.append(guaranteeId);
		builder.append(", loanerId=");
		builder.append(loanerId);
		builder.append(", demandId=");
		builder.append(demandId);
		builder.append(", letterPdfUrl=");
		builder.append(letterPdfUrl);
		builder.append(", contractPdfUrl=");
		builder.append(contractPdfUrl);
		builder.append(", bankingBizTypeEnum=");
		builder.append(bankingBizTypeEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
