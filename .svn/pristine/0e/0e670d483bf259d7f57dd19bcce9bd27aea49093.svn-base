package com.yjf.esupplier.ws.gifamount.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class CreateGiftMoneyTemplateRuleOrder extends ValidateOrderBase implements Order {
    private static final long serialVersionUID = 8060079402917808781L;
    private long ruleId;

    private long templateId;

    private Money ruleAmount = new Money(0, 0);

    private double amount;

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public Money getRuleAmount() {
        return ruleAmount;
    }

    public void setRuleAmount(Money ruleAmount) {
        this.ruleAmount = ruleAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
