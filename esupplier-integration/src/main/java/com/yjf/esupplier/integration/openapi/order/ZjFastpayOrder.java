package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;

public class ZjFastpayOrder extends PayOrder {
	
	private static final long serialVersionUID = 1384305577613955445L;
	String userId;
	/*单位:元*/
	Money payAmount = new Money();
	/*商品描述*/
	String remark;
	/*参考银行简称表，测试环境用”CFCA_TEST”*/
	String bankCode;
	/*debit借记卡(默认) credit贷记卡 */
	String cardType;
	/*用户类型：B 企业 P个人 */
	String userType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Money getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Money payAmount) {
		this.payAmount = payAmount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AliFastpayOrder [userId=");
		builder.append(userId);
		builder.append(", payAmount=");
		builder.append(payAmount);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", userType=");
		builder.append(userType);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
