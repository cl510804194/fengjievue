package com.yjf.esupplier.ws.info;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.data.LoanDemandData;
import com.yjf.esupplier.ws.enums.TradeStatusEnum;

public class LoanDemandTradeVOInfo extends LoanDemandData {
	private static final long serialVersionUID = 1648861078000577188L;
	/**
	 * 担保函状态
	 */
	private TradeStatusEnum tradeStatus;
	/**
	 * 交易id
	 */
	private long tradeId;
	/**
	 * 担保费
	 */
	private Money benefitAmount;
	
	private String guaranteeStatus;
	/** 借款成立日期 */
	protected Date tradeEffectiveDate;
	/** 借款到期日期 */
	protected Date tradeExpireDate;
	/** 创建日期 */
	protected Date tradeCreateDate;
	/** 完成日期 */
	protected Date tradeFinishDate;
	/** 已借款金额(以分为单位) */
	protected Money loanedAmount = new Money(0, 0);
	
	protected Money tradeAmount = new Money(0, 0);
	/** 投资完成时间 */
	protected Date investFinishDate;
	
	/**到还款当天*/
	boolean isExpireRepayDate;
	/** 项目图片 */
	private String loanDemandImgUrl;

    private String investmentIncome;

    private boolean canUseGiftMoney;
	
	
	public boolean isExpireRepayDate() {
		return this.isExpireRepayDate;
	}

	public void setExpireRepayDate(boolean isExpireRepayDate) {
		this.isExpireRepayDate = isExpireRepayDate;
	}

	public TradeStatusEnum getTradeStatus() {
		return this.tradeStatus;
	}
	
	public void setTradeStatus(TradeStatusEnum tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public Money getBenefitAmount() {
		return this.benefitAmount;
	}
	
	public void setBenefitAmount(Money benefitAmount) {
		this.benefitAmount = benefitAmount;
	}
	
	public String getGuaranteeStatus() {
		return this.guaranteeStatus;
	}
	
	public void setGuaranteeStatus(String guaranteeStatus) {
		this.guaranteeStatus = guaranteeStatus;
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
	
	public Money getLoanedAmount() {
		return this.loanedAmount;
	}
	
	public void setLoanedAmount(Money loanedAmount) {
		this.loanedAmount = loanedAmount;
	}
	
	public Money getTradeAmount() {
		return this.tradeAmount;
	}
	
	public void setTradeAmount(Money tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	
	public Date getInvestFinishDate() {
		return this.investFinishDate;
	}
	
	public void setInvestFinishDate(Date investFinishDate) {
		this.investFinishDate = investFinishDate;
	}
	
	public String getLoanDemandImgUrl() {
		return loanDemandImgUrl;
	}

	public void setLoanDemandImgUrl(String loanDemandImgUrl) {
		this.loanDemandImgUrl = loanDemandImgUrl;
	}

    public String getInvestmentIncome() {
        return investmentIncome;
    }

    public void setInvestmentIncome(String investmentIncome) {
        this.investmentIncome = investmentIncome;
    }

    public boolean isCanUseGiftMoney() {
        return canUseGiftMoney;
    }

    public void setCanUseGiftMoney(boolean canUseGiftMoney) {
        this.canUseGiftMoney = canUseGiftMoney;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandTradeVOInfo [tradeStatus=");
		builder.append(tradeStatus);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", benefitAmount=");
		builder.append(benefitAmount);
		builder.append(", guaranteeStatus=");
		builder.append(guaranteeStatus);
		builder.append(", tradeEffectiveDate=");
		builder.append(tradeEffectiveDate);
		builder.append(", tradeExpireDate=");
		builder.append(tradeExpireDate);
		builder.append(", tradeCreateDate=");
		builder.append(tradeCreateDate);
		builder.append(", tradeFinishDate=");
		builder.append(tradeFinishDate);
		builder.append(", loanedAmount=");
		builder.append(loanedAmount);
		builder.append(", tradeAmount=");
		builder.append(tradeAmount);
		builder.append(", investFinishDate=");
		builder.append(investFinishDate);
		builder.append(", loanDemandImgUrl=");
		builder.append(loanDemandImgUrl);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
