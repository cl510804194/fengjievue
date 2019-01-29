package com.yjf.esupplier.ws.order;

import com.yjf.esupplier.ws.enums.YrdAuthTypeEnum;

public class LoanAuthOrder extends TradeProcessOrder {
	
	private static final long serialVersionUID = 7745263743585364825L;
	YrdAuthTypeEnum authType;
	String serverPath;
	
	public YrdAuthTypeEnum getAuthType() {
		return this.authType;
	}
	
	public void setAuthType(YrdAuthTypeEnum authType) {
		this.authType = authType;
	}
	
	public String getServerPath() {
		return this.serverPath;
	}
	
	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanAuthOrder [authType=");
		builder.append(authType);
		builder.append(", serverPath=");
		builder.append(serverPath);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public void check() {
		validateNotNull(authType, "审核类型");
		validateHasZore(bizNo, "交易流水号");
		validateHasZore(processorId, "审核人用户ID");
		
	}
}
