package com.yjf.esupplier.domain;

import java.util.Date;

import com.yjf.common.domain.api.Domain;

public class TradeFlowCodeDomain implements Domain {
	private static final long serialVersionUID = 4051524590468048340L;
	/** 表主键 */
	private String tblBaseId;
	/** 投资交易ID */
	private long tradeDetailId;
	/** 交易生成流水号 */
	private String tradeFlowCode;
	/** 生成时间 */
	private Date rowAddTime;
	/** 备注信息 */
	private String note;
	/** 预留字段 */
	private String rem1;
	/** 状态(0:无效，1：有效) */
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
		builder.append("TradeFlowCodeDomain [tblBaseId=");
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
	
	@Override
	public void examSelf() throws Exception {
	}
	
}
