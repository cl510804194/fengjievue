package com.yjf.esupplier.ws.gifamount.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * Created by min on 2014/11/21.
 */
public class GiftMoneyCancelPersonalOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -681905050281849585L;

    private long userId;
    private Money money = Money.zero();

	
	@Override
	public void check() {
        validateHasZore(userId,"必须输入userId");
	}


    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GiftMoneyCancelPersonalOrder{");
        sb.append("money=").append(money);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
