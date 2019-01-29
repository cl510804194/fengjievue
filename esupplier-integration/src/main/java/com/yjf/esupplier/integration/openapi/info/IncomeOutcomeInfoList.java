package com.yjf.esupplier.integration.openapi.info;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.IncomeOutcomeEnum;

/**
 *   收支明细查询结果参数
 *
 */

public class IncomeOutcomeInfoList {

	/** 账户id */
	protected String			userId;  
	
	/** 交易额  */
	protected Money				transAmount;
	
	/** 资金流向*/
	protected String			direction;
	
	/** 交易事后余额 */
	protected Money				balance;
	
	/** 收支备注 */
	protected String			memo;
	
	/** 交易开始时间 */
	protected String			tradeBeginTime;
	
	/** 交易更新时间 */
	protected String			tradeUpdateTime;
	
	/** 操作 */
	protected String			tradeType;

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Money getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(Money transAmount) {
		this.transAmount = transAmount;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getTradeBeginTime() {
		return tradeBeginTime;
	}

	public void setTradeBeginTime(String tradeBeginTime) {
		this.tradeBeginTime = tradeBeginTime;
	}

	public String getTradeUpdateTime() {
		return tradeUpdateTime;
	}

	public void setTradeUpdateTime(String tradeUpdateTime) {
		this.tradeUpdateTime = tradeUpdateTime;
	}

	@Override
	public String toString() {
		return "IncomeOutcomeInfoList [userId=" + userId + ", transAmount="
				+ transAmount + ", direction=" + direction + ", balance="
				+ balance + ", memo=" + memo + ", tradeBeginTime="
				+ tradeBeginTime + ", tradeUpdateTime=" + tradeUpdateTime
				+ ", tradeType=" + tradeType + "]";
	}

	
	
	
	
}
