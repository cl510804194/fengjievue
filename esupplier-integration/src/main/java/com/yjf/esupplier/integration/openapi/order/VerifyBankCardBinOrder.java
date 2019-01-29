package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class VerifyBankCardBinOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -4137432040801853710L;
	String bankCardNo;
	String bankCode;
	
	public String getBankCardNo() {
		return this.bankCardNo;
	}
	
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	
	public String getBankCode() {
		return this.bankCode;
	}
	
	@Override
	public void check() {
		super.check();
		validateHasText(bankCardNo, "银行卡号");
		validateHasText(bankCode, "银行编码");
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VerifyBankCardBinOrder [bankCardNo=");
		builder.append(bankCardNo);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
