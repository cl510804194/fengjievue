package com.yjf.esupplier.ws.order;

public class LoanDemandLoanNoteOrder extends TradeProcessOrder {
	private static final long serialVersionUID = 2904905005749445215L;
	String loanNote = null;
	
	
	public String getLoanNote() {
		return loanNote;
	}

	public void setLoanNote(String loanNote) {
		this.loanNote = loanNote;
	}

	@Override
	public void check() {
		super.check();
		validateHasText(loanNote, "项目信息");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandLoanNoteOrder [loanNote=");
		builder.append(loanNote);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
