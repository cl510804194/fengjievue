package com.yjf.esupplier.domain;

import org.springframework.util.Assert;

import com.yjf.common.domain.api.Domain;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.integral.data.PointsRuleDetailData;

/**
 * Created by min on 2014/11/17.
 */
public class PointsRuleDetailDomain extends PointsRuleDetailData implements Domain {
	private static final long serialVersionUID = -4247424585258280718L;
	
	@Override
	public void examSelf() throws Exception {
		Assert.isTrue(this.getAmount().greaterThan(Money.zero()));
		Assert.isTrue(this.getCoefficient() > 0 || this.getPointsValue() > 0);
	}
}
