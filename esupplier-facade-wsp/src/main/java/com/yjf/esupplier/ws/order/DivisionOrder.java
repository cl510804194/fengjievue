package com.yjf.esupplier.ws.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;

public class DivisionOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -178649406303962968L;
	/** 业务编码 */
	private String businessCode;
	/** 用户userId */
	private long userId;
	/** 交易Id */
	private long tradeId;
	/** 金额 */
	private Money amount = new Money(0, 0);
	/** false：未分润成功或分润失败，true：分润成功 */
	private boolean divisionStatus;
	/** 分润日期 */
	private Date divisionDate;
	/** 交易明细ID */
	private long tradeDetailId;
	/** 用户登录名 */
	private String userName;
	/** 用户真实名称 */
	private String realName;
	
	@Override
	public void check() {
		validateHasText(businessCode, "businessCode");
		validateGreaterThan(userId, " 用户userId");
		validateGreaterThan(tradeId, "tradeId");
		validateGreaterThan(tradeDetailId, "交易明细ID");
		validateNotNull(divisionDate, "分润日期 ");
		validateGreaterThan(amount.getAmount(), " 金额");
		super.check();
	}
	
	public String getBusinessCode() {
		return this.businessCode;
	}
	
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public boolean isDivisionStatus() {
		return this.divisionStatus;
	}
	
	public void setDivisionStatus(boolean divisionStatus) {
		this.divisionStatus = divisionStatus;
	}
	
	public Date getDivisionDate() {
		return this.divisionDate;
	}
	
	public void setDivisionDate(Date divisionDate) {
		this.divisionDate = divisionDate;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DivisionOrder [businessCode=");
		builder.append(businessCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", divisionStatus=");
		builder.append(divisionStatus);
		builder.append(", divisionDate=");
		builder.append(divisionDate);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append("]");
		return builder.toString();
	}
	
}
