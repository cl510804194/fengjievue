package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

public class TradeFlowCodeInfo implements Serializable {
	private static final long serialVersionUID = -3535589592813410269L;
	
	private String tblBaseId;
	
	private long tradeDetailId;
	
	private String tradeFlowCode;
	
	private Date rowAddTime;
	
	private String note;
	
	private String rem1;
	
	private boolean state;
	
	public String getTblBaseId() {
		return this.tblBaseId;
	}
	
	public void setTblBaseId(String tblBaseId) {
		this.tblBaseId = tblBaseId;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public String getTradeFlowCode() {
		return this.tradeFlowCode;
	}
	
	public void setTradeFlowCode(String tradeFlowCode) {
		this.tradeFlowCode = tradeFlowCode;
	}
	
	public Date getRowAddTime() {
		return this.rowAddTime;
	}
	
	public void setRowAddTime(Date rowAddTime) {
		this.rowAddTime = rowAddTime;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getRem1() {
		return this.rem1;
	}
	
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	
	public boolean isState() {
		return this.state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeFlowCodeInfo [tblBaseId=");
		builder.append(tblBaseId);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", tradeFlowCode=");
		builder.append(tradeFlowCode);
		builder.append(", rowAddTime=");
		builder.append(rowAddTime);
		builder.append(", note=");
		builder.append(note);
		builder.append(", rem1=");
		builder.append(rem1);
		builder.append(", state=");
		builder.append(state);
		builder.append("]");
		return builder.toString();
	}
	
}
