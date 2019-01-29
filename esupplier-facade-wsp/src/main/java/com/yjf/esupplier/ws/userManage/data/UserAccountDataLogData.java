package com.yjf.esupplier.ws.userManage.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.userManage.enums.AccountChangeTypeEnum;
import com.yjf.esupplier.ws.userManage.enums.AccountDirectionEnum;
import com.yjf.esupplier.ws.userManage.enums.AccountTypeEnum;

public class UserAccountDataLogData implements Serializable {
	
	private static final long serialVersionUID = 8808416781016876755L;
	protected long userAccountDataLogId;
	
	protected long userId;
	
	protected AccountDirectionEnum direction;
	
	protected AccountTypeEnum accountType;
	
	protected AccountChangeTypeEnum changeType;
	
	protected Money amount = new Money(0, 0);
	
	protected Money balance = new Money(0, 0);
	
	protected String memo;
	
	protected String outBizNo;
	
	protected Date rawAddTime;
	
	protected Date rawUpdateTime;
	
	public long getUserAccountDataLogId() {
		return this.userAccountDataLogId;
	}
	
	public void setUserAccountDataLogId(long userAccountDataLogId) {
		this.userAccountDataLogId = userAccountDataLogId;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public AccountDirectionEnum getDirection() {
		return this.direction;
	}
	
	public void setDirection(AccountDirectionEnum direction) {
		this.direction = direction;
	}
	
	public AccountTypeEnum getAccountType() {
		return this.accountType;
	}
	
	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}
	
	public AccountChangeTypeEnum getChangeType() {
		return this.changeType;
	}
	
	public void setChangeType(AccountChangeTypeEnum changeType) {
		this.changeType = changeType;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public Money getBalance() {
		return this.balance;
	}
	
	public void setBalance(Money balance) {
		this.balance = balance;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getOutBizNo() {
		return this.outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAccountDataLogDomain [userAccountDataLogId=");
		builder.append(userAccountDataLogId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", changeType=");
		builder.append(changeType);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
}
