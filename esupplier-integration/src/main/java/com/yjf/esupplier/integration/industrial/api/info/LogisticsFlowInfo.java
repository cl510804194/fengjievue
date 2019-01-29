package com.yjf.esupplier.integration.industrial.api.info;

import java.util.Date;

public class LogisticsFlowInfo {
	Date acceptTime;
	String acceptAddress;
	String remark;
	String opcode;
	
	public Date getAcceptTime() {
		return this.acceptTime;
	}
	
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	
	public String getAcceptAddress() {
		return this.acceptAddress;
	}
	
	public void setAcceptAddress(String acceptAddress) {
		this.acceptAddress = acceptAddress;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getOpcode() {
		return this.opcode;
	}
	
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogisticsFlowInfo [acceptTime=");
		builder.append(acceptTime);
		builder.append(", acceptAddress=");
		builder.append(acceptAddress);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", opcode=");
		builder.append(opcode);
		builder.append("]");
		return builder.toString();
	}
	
}
