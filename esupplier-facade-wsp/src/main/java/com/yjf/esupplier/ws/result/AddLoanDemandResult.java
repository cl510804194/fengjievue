package com.yjf.esupplier.ws.result;

public class AddLoanDemandResult extends EsupplierBaseResult {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8969648130682531875L;
	long demandId;
	
	public long getDemandId() {
		return demandId;
	}
	
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddLoanDemandResult [demandId=");
		builder.append(demandId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
