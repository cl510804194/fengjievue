package com.yjf.esupplier.ws.friend.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.RecommendRuleWayTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

import java.util.Date;

public class GiftRecommendFriendOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 8060079402917808781L;
    private long childId;
    private RecommendRuleWayTypeEnum wayType;
    private Money investAmount = new Money();

    public long getChildId() {
        return childId;
    }

    public void setChildId(long childId) {
        this.childId = childId;
    }

    public RecommendRuleWayTypeEnum getWayType() {
        return wayType;
    }

    public void setWayType(RecommendRuleWayTypeEnum wayType) {
        this.wayType = wayType;
    }

    public Money getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(Money investAmount) {
        this.investAmount = investAmount;
    }
}
