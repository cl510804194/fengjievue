package com.yjf.esupplier.ws.service.query.order;

import java.io.Serializable;

public class IndexQueryOrder implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2874889736244100090L;
	
	Integer status;
	String  guarantee;
	String  areaCode;
	String  interestRateBegin;
	String  interestRateEnd;
	String  insureWay;
	String  bizType;
    String bankingBizTypeEnum;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getGuarantee() {
		return guarantee;
	}
	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
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

    public String getBankingBizTypeEnum() {
        return bankingBizTypeEnum;
    }

    public void setBankingBizTypeEnum(String bankingBizTypeEnum) {
        this.bankingBizTypeEnum = bankingBizTypeEnum;
    }
}
