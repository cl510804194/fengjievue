package com.yjf.esupplier.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.yjf.common.domain.api.Domain;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.YrdConstants;
import com.yjf.esupplier.domain.util.DomainUtils;
import com.yjf.esupplier.ws.data.TradeData;
import com.yjf.esupplier.ws.enums.LoanPeriodUnitEnum;
import com.yjf.esupplier.ws.enums.TradeFullConditionEnum;
import com.yjf.esupplier.ws.enums.TradeStatusEnum;

public class TradeDomain extends TradeData implements Domain {
	private static final long serialVersionUID = -9166523287492359575L;
	
	List<TradeDetailDomain> detailDomains;
	
	public List<TradeDetailDomain> getDetailDomains() {
		return this.detailDomains;
	}
	
	public void setDetailDomains(List<TradeDetailDomain> detailDomains) {
		this.detailDomains = detailDomains;
	}
	
	public boolean isCanInvest() {
		return this.getTradeStatus() == TradeStatusEnum.TRADING;
	}
	
	/**
	 * 是否投标超期
	 * 
	 * @return
	 */
	public boolean isExtended() {
		Date nowDate = DomainUtils.getNowData();
		if (nowDate.after(this.getDeadline())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否满标
	 * 
	 * @return
	 */
	public boolean isFullScale() {
		
		TradeFullConditionEnum method = this.getSaturationConditionMethod();
		if (getLoanedAmount().equals(tradeAmount)) {
			return true;
		}
		Date nowDate = DomainUtils.getNowData();
		if (nowDate.after(this.getDeadline())) {
			if (method == TradeFullConditionEnum.AMOUNT) {
				long scale = Long.parseLong(saturationCondition);
				Money scaleMoney = new Money();
				scaleMoney.setCent(scale);
				if (!scaleMoney.greaterThan(this.getLoanedAmount())) {
					return true;
				}
			} else if (method == TradeFullConditionEnum.PERCENTAGE) {
				BigDecimal percentage = loanedAmount.getAmount().divide(tradeAmount.getAmount(), 4,
					BigDecimal.ROUND_HALF_EVEN);
				
				if (percentage.doubleValue() >= Double.parseDouble(saturationCondition)) {
					return true;
				}
			} else if (method == TradeFullConditionEnum.DATE) {
				if (System.currentTimeMillis() >= DateUtil.parse(saturationCondition).getTime()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Money getDaysRuleRate(double rule, Money amount) {
		int daysOfAYear = YrdConstants.TimeRelativeConstants.DAYSOFAYEAR;
		int timeLimit = this.getTimeLimit();
		double days = 0;
		if (LoanPeriodUnitEnum.LOAN_BY_DAY == this.getTimeLimitUnit()) {
			days = timeLimit;
		} else if (LoanPeriodUnitEnum.LOAN_BY_YEAR == this.getTimeLimitUnit()) {
			days = timeLimit * daysOfAYear;
		} else {
			days = Math.round(timeLimit * daysOfAYear / 12);
		}
		Money money = amount.multiply(rule).multiply(days)
			.divide(new BigDecimal(daysOfAYear), BigDecimal.ROUND_DOWN);
		return money;
	}
	
	public int getMonthCount() {
		int monthCount = 1;
		if (LoanPeriodUnitEnum.LOAN_BY_DAY == this.getTimeLimitUnit()) {
			return monthCount;
		} else if (LoanPeriodUnitEnum.LOAN_BY_YEAR == this.getTimeLimitUnit()) {
			monthCount = timeLimit * 12;
		} else {
			monthCount = timeLimit;
		}
		return monthCount;
	}
	
	/**
	 * 获取超期时间
	 * 
	 * @return
	 */
	public Date calculateExpireDateTime() {
		Date expireDateTime = null;
		
		LoanPeriodUnitEnum limitUnit = this.timeLimitUnit;
		int timeLimit = this.getTimeLimit();
		Date currentDate = DomainUtils.getNowData();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		if (LoanPeriodUnitEnum.LOAN_BY_DAY == limitUnit) {
			calendar.add(Calendar.DATE, timeLimit);
			expireDateTime = calendar.getTime();
		} else if (LoanPeriodUnitEnum.LOAN_BY_MONTH == limitUnit) {
			calendar.add(Calendar.MONTH, timeLimit);
			expireDateTime = calendar.getTime();
			
		} else if (LoanPeriodUnitEnum.LOAN_BY_PEROIDW == limitUnit) {
			calendar.add(Calendar.MONTH, timeLimit);
			expireDateTime = calendar.getTime();
			
		} else if (LoanPeriodUnitEnum.LOAN_BY_YEAR == limitUnit) {
			calendar.add(Calendar.YEAR, timeLimit);
			expireDateTime = calendar.getTime();
		}
		return DateUtil.getEndTimeOfTheDate(expireDateTime);
	}
	
	@Override
	public void examSelf() throws Exception {
		//		Assert.isNull(saturationConditionMethod);
		//		Assert.isNull(loanedAmount);
		//		Assert.isNull(tradeAmount);
		
	}
}
