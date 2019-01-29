package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class MoreMerchantSignBankOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = -5363506443882530408L;
	String userId;
	String upUserNos;
	
	@Override
	public void check() {
		super.check();
		validateHasText(userId, "userId");
		validateHasText(upUserNos, "多个商户号");
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUpUserNos() {
		return this.upUserNos;
	}
	
	public void setUpUserNos(String upUserNos) {
		this.upUserNos = upUserNos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MoreMerchantSignBankOrder [userId=");
		builder.append(userId);
		builder.append(", upUserNos=");
		builder.append(upUserNos);
		builder.append("]");
		return builder.toString();
	}
	
}
