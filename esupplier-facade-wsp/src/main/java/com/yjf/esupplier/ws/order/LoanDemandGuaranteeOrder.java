package com.yjf.esupplier.ws.order;

public class LoanDemandGuaranteeOrder extends TradeProcessOrder {
	private static final long serialVersionUID = 2904905005749445215L;
	/** 担保合同名称 */
	private String guaranteeLicenceName;
	/** 担保函附件 */
	private String guaranteeLicenseUrl;
	
	public String getGuaranteeLicenseUrl() {
		return guaranteeLicenseUrl;
	}

	public void setGuaranteeLicenseUrl(String guaranteeLicenseUrl) {
		this.guaranteeLicenseUrl = guaranteeLicenseUrl;
	}

	public String getGuaranteeLicenceName() {
		return guaranteeLicenceName;
	}

	public void setGuaranteeLicenceName(String guaranteeLicenceName) {
		this.guaranteeLicenceName = guaranteeLicenceName;
	}

	@Override
	public void check() {
		super.check();
		validateHasText(guaranteeLicenceName, "项目信息");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandLoanNoteOrder [guaranteeLicenceName=");
		builder.append(guaranteeLicenceName);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
