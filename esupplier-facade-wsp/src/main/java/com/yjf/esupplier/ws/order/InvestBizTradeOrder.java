package com.yjf.esupplier.ws.order;

import java.util.Arrays;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.BooleanEnum;

public class InvestBizTradeOrder extends TradeProcessOrder implements Order {
	
	private static final long serialVersionUID = -6127537629123934484L;
	/** 投资金额 */
	Money investAmount = new Money(0);
	/** 投资人支付账号id */
	String accountId;
	/** 投资人userId */
	long userId;
	
	Money giftMoneyAmount = new Money();

    Money experienceAmount = new Money();

	BooleanEnum isSendUrl = BooleanEnum.YES;
	
	@Override
	public void check() {
		validateMoneyGreaterThanZero(investAmount, "投资金额");
		validateHasText(accountId, "投资人支付账号");
		validateHasZore(userId, "投资人userId");
		super.check();
	}
	
	public Money getInvestAmount() {
		return this.investAmount;
	}
	
	public void setInvestAmount(Money investAmount) {
		this.investAmount = investAmount;
	}
	
	public String getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}

    public Money getGiftMoneyAmount() {
        return giftMoneyAmount;
    }

    public void setGiftMoneyAmount(Money giftMoneyAmount) {
        this.giftMoneyAmount = giftMoneyAmount;
    }

    public BooleanEnum getIsSendUrl() {
		return this.isSendUrl;
	}
	
	public void setIsSendUrl(BooleanEnum isSendUrl) {
		this.isSendUrl = isSendUrl;
	}

    public Money getExperienceAmount() {
        return experienceAmount;
    }

    public void setExperienceAmount(Money experienceAmount) {
        this.experienceAmount = experienceAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvestBizTradeOrder{");
        sb.append("investAmount=").append(investAmount);
        sb.append(", accountId='").append(accountId).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", giftMoneyAmount=").append(giftMoneyAmount);
        sb.append(", experienceAmount=").append(experienceAmount);
        sb.append(", isSendUrl=").append(isSendUrl);
        sb.append('}');
        return sb.toString();
    }
}
