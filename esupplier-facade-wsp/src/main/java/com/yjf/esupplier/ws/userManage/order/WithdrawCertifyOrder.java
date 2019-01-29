package com.yjf.esupplier.ws.userManage.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class WithdrawCertifyOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 3795110063600131914L;
	/**
	 * 用户真实姓名
	 */
	String realName;
	/**
	 * 用户易极付id
	 */
	long userId;
	
	@Override
	public void check() {
		validateHasText(realName, "用户真实姓名");
		validateHasZore(userId, "用户易极付id");
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WithdrawCertifyOrder [realName=");
		builder.append(realName);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
	
}
