package com.yjf.esupplier.ws.gifamount.order;

import java.util.Date;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class CreateGiftMoneyTemplateOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 8060079402917808781L;
	protected long templateId;
	protected String templateName;
	protected String status;
	protected Date rawAddTime;
	protected Date rawUpdateTime;
	protected String[] ruleAmount;
	protected String[] amount;
	protected String increase;
	
	@Override
	public void check() {
		this.validateHasText(templateName, "优惠券模板名称");
		this.validateNotNull(ruleAmount, "满足优惠券发放的金额");
		this.validateNotNull(amount, "优惠券发放利率");
	}
	
	public long getTemplateId() {
		return templateId;
	}
	
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	
	public String getTemplateName() {
		return templateName;
	}
	
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public String[] getRuleAmount() {
		return ruleAmount;
	}
	
	public void setRuleAmount(String[] ruleAmount) {
		this.ruleAmount = ruleAmount;
	}
	
	public String[] getAmount() {
		return amount;
	}
	
	public void setAmount(String[] amount) {
		this.amount = amount;
	}
	
	public String getIncrease() {
		return increase;
	}
	
	public void setIncrease(String increase) {
		this.increase = increase;
	}
}
