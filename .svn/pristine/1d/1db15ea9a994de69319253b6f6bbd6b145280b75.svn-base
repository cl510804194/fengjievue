package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;

public class GuaranteeCheckOrder extends TradeProcessOrder implements Order {

	private static final long serialVersionUID = -6814660994743166061L;

	/** 贷款金额id */
	protected Money loanAmount = null;
	/** 上传担保函附件 */
	protected String guaranteeLicenseUrl;

	public Money getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(Money loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getGuaranteeLicenseUrl() {
		return this.guaranteeLicenseUrl;
	}

	public void setGuaranteeLicenseUrl(String guaranteeLicenseUrl) {
		this.guaranteeLicenseUrl = guaranteeLicenseUrl;
	}

	@Override
	public void check() {
		super.check();
		validateHasText(guaranteeLicenseUrl, "担保函地址");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuaranteeCheckOrder [loanAmount=");
		builder.append(loanAmount);
		builder.append(", guaranteeLicenseUrl=");
		builder.append(guaranteeLicenseUrl);

		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
