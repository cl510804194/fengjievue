package com.yjf.esupplier.integration.openapi.info;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zjialin@yiji.com on 2014/4/15.
 */
public class SignBankInfo implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -1082687867844169129L;
	
	/**
	 * 签约号
	 */
	private String				pactNo;
	
	/**
	 * 用户号
	 */
	private String				userId;
	
	/**
	 * 卡号
	 */
	private String				cardNo;
	
	/**
	 * 银行卡类型
	 */
	private String				cardType;
	
	/**
	 * 银行卡类型名称
	 */
	private String				cardTypeName;
	
	/**
	 * 证件号
	 */
	private String				certNo;
	
	/**
	 * 持卡人姓名
	 */
	private String				cardName;
	
	/**
	 * 使用人手机号
	 */
	private String				userPhoneNo;
	
	/**
	 * 商户号
	 */
	private String				upUserNo;
	
	/**
	 * 所属银行
	 */
	private String				bankShort;
	
	/**
	 * 所属银行名称
	 */
	private String				bankName;
	
	/**
	 * 所属银行url
	 */
	private String				bankGifUrl;
	
	/**
	 * 状态
	 */
	private String				status;
	
	/**
	 * 创建时间
	 */
	private Date				creatTime;
	
	/**
	 * 更新时间
	 */
	private Date				updateTime;
	
	public String getPactNo() {
		return pactNo;
	}
	
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	public String getCardTypeName() {
		return cardTypeName;
	}
	
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	
	public String getCertNo() {
		return certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public String getCardName() {
		return cardName;
	}
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	
	public String getUpUserNo() {
		return upUserNo;
	}
	
	public void setUpUserNo(String upUserNo) {
		this.upUserNo = upUserNo;
	}
	
	public String getBankShort() {
		return bankShort;
	}
	
	public void setBankShort(String bankShort) {
		this.bankShort = bankShort;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankGifUrl() {
		return bankGifUrl;
	}
	
	public void setBankGifUrl(String bankGifUrl) {
		this.bankGifUrl = bankGifUrl;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getCreatTime() {
		return creatTime;
	}
	
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("SignBankInfo{");
		sb.append("pactNo='").append(pactNo).append('\'');
		sb.append(", userId='").append(userId).append('\'');
		sb.append(", cardNo='").append(cardNo).append('\'');
		sb.append(", cardType='").append(cardType).append('\'');
		sb.append(", cardTypeName='").append(cardTypeName).append('\'');
		sb.append(", certNo='").append(certNo).append('\'');
		sb.append(", cardName='").append(cardName).append('\'');
		sb.append(", userPhoneNo='").append(userPhoneNo).append('\'');
		sb.append(", upUserNo='").append(upUserNo).append('\'');
		sb.append(", bankShort='").append(bankShort).append('\'');
		sb.append(", bankName='").append(bankName).append('\'');
		sb.append(", bankGifUrl='").append(bankGifUrl).append('\'');
		sb.append(", status='").append(status).append('\'');
		sb.append(", creatTime=").append(creatTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append('}');
		return sb.toString();
	}
}
