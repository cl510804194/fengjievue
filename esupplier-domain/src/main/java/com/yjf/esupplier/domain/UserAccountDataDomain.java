package com.yjf.esupplier.domain;

import java.util.Date;
import java.util.List;

import org.springframework.util.Assert;

import com.google.common.collect.Lists;
import com.yjf.common.domain.api.Domain;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.domain.context.EsupplierDomainHolder;
import com.yjf.esupplier.ws.userManage.data.UserAccountData;

public class UserAccountDataDomain extends UserAccountData implements Domain {
	
	private static final long serialVersionUID = 3823684760595402723L;
	public final Money ZERO = Money.zero();
	List<UserAccountDataLogDomain> accountDataLogDomains = Lists.newArrayList();
	@Override
	public void examSelf() throws Exception {
		Assert.isTrue(userIntegral >= 0);
		Assert.isTrue(userIntegralGrandTotal >= 0);
		
		Assert.isTrue(userCouponCount >= 0);
		Assert.isTrue(userCouponCountGrandTotal >= 0);
		
		Assert.isTrue(!ZERO.greaterThan(userCouponAmount));
		Assert.isTrue(!ZERO.greaterThan(userCouponAmountGrandTotal));
		
		Assert.isTrue(!ZERO.greaterThan(userGiftAmount));
		
		Assert.isTrue(!ZERO.greaterThan(userGiftAmountGrandTotal));
		Assert.isTrue(!ZERO.greaterThan(userGiftAmountCash));
		Assert.isTrue(!ZERO.greaterThan(userGiftAmountCashGrandTotal));
		Assert.isTrue(!ZERO.greaterThan(userBalance));
		Assert.isTrue(!ZERO.greaterThan(userRechargeAmount));
		Assert.isTrue(!ZERO.greaterThan(userWithdrawAmount));
		Assert.isTrue(!ZERO.greaterThan(userFreezeAmount));
	}
	
	public void addUserGrowthValue(double value) {
		this.userGrowthValue += (long) (value);
	}
	
	public void addUserIntegral(long value) {
		userIntegral += value;
		if (value > 0)
			userIntegralGrandTotal += value;
	}
	
	public void addUserCouponCount() {
		userCouponCount++;
	}
	
	public void removeUserCouponCount() {
		userCouponCount--;
	}
	
	public void addUserCouponCountGrandTotal() {
		userCouponCountGrandTotal++;
	}
	
	public void addUserPayedAmount(Money money) {
		this.userPayedAmount.addTo(money);
	}
	
	public void addUserTradeAmount(Money money) {
		this.userTradeAmount.addTo(money);
		Date nowDate = null;
		if (EsupplierDomainHolder.get() != null) {
			nowDate = EsupplierDomainHolder.get().getSysDate();
		}
		if (nowDate == null) {
			nowDate = new Date();
		}
		String lastDate = DateUtil.dtSimpleFormat(nowDate);
		if (StringUtil.notEquals(this.lastTradeDay, lastDate)) {
			this.userTradeDay++;
			this.setLastTradeDay(lastDate);
		}
		
	}
	public void withdrawApply(Money money) {
		Assert.isTrue(!money.greaterThan(userBalance.subtract(userFreezeAmount)), "余额不足");
		this.userFreezeAmount.addTo(money);
	}
	public void setAccountDataLogDomains(List<UserAccountDataLogDomain> accountDataLogDomains) {
		this.accountDataLogDomains = accountDataLogDomains;
	}
}
