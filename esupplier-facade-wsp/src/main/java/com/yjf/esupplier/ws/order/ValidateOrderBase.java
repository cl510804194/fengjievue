package com.yjf.esupplier.ws.order;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.OrderBase;

public class ValidateOrderBase extends OrderBase {
	
	private static final long serialVersionUID = 1L;
	protected static final Money ZERO = Money.zero();
	
	@Override
	public String getGid() {
		return null;
	}
	
	@Override
	public void setGid(String gid) {
		
	}
	
	protected void validateHasText(String validateField, String fieldDes) {
		Assert.hasText(validateField, fieldDes + "不能为空!");
	}
	
	protected void validateHasZore(long vlaue, String fieldDes) {
		Assert.isTrue(vlaue > 0, fieldDes + "不能为空!");
	}
	
	protected void validateNotNull(Object validateField, String fieldDes) {
		Assert.notNull(validateField, fieldDes + "不能为空!");
	}
	
	protected void validateGreaterThan(Number validateField, String fieldDes) {
		Assert.isTrue(validateField.doubleValue() > 0, fieldDes + "必须大于零!");
	}
	
	protected void validateGreaterThanEqualZero(Number validateField, String fieldDes) {
		Assert.isTrue(validateField.doubleValue() >= 0, fieldDes + "必须大于等于零!");
	}
	
	protected void validateMoneyGreaterThanZero(Money validateField, String fieldDes) {
		Assert.notNull(validateField, fieldDes + "不能为空!");
		Assert.isTrue(validateField.greaterThan(ZERO), fieldDes + "必须大于零!");
	}
	
	@Override
	public boolean isCheckGid() {
		return false;
	}
}
