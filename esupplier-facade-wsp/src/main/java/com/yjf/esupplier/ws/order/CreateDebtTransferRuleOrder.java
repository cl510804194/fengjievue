package com.yjf.esupplier.ws.order;

import java.util.Date;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.DebtTransferRuleVerEnum;

public class CreateDebtTransferRuleOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -1416050223061472975L;
	protected long ruleId;
	
	protected long holdingDate;
	
	protected long validDate;
	
	protected double priceOnline;
	
	protected double priceOffline;
	
	protected double transCharge;
	
	protected String handCancel;
	
	protected String version;
	
	protected String remark;
	
	protected Date rawAddTime;
	
	protected Date rawUpdateTime;
	
	@Override
	public void check() {
		super.check();
		validateGreaterThanEqualZero(holdingDate, "债权持有期");
		validateGreaterThanEqualZero(validDate, "债权转让有效期");
		Assert.isTrue(priceOnline * 100 >= 0 && priceOnline * 100 <= 50, "本金上浮比例必须大于0%小于50%!");
		Assert.isTrue((priceOnline * 1000) % 1 == 0, "本金上浮比例必须按照0.1%递增");
		Assert.isTrue(priceOffline * 100 >= 0 && priceOffline * 100 <= 50, "本金下浮比例必须大于0%小于50%!");
		Assert.isTrue((priceOffline * 1000) % 1 == 0, "本金下浮比例必须按照0.1%递增");
		Assert.isTrue(StringUtil.equals(version, DebtTransferRuleVerEnum.NOW.getCode()),
			"规则版本只能为NOW");
		validateGreaterThanEqualZero(transCharge, "债权转让服务费");
		validateHasText(handCancel, "手动撤销功能");
		
	}
	
	public long getRuleId() {
		return ruleId;
	}
	
	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}
	
	public long getHoldingDate() {
		return holdingDate;
	}
	
	public void setHoldingDate(long holdingDate) {
		this.holdingDate = holdingDate;
	}
	
	public long getValidDate() {
		return validDate;
	}
	
	public void setValidDate(long validDate) {
		this.validDate = validDate;
	}
	
	public double getPriceOnline() {
		return priceOnline;
	}
	
	public void setPriceOnline(double priceOnline) {
		this.priceOnline = priceOnline;
	}
	
	public double getPriceOffline() {
		return priceOffline;
	}
	
	public void setPriceOffline(double priceOffline) {
		this.priceOffline = priceOffline;
	}
	
	public double getTransCharge() {
		return transCharge;
	}
	
	public void setTransCharge(double transCharge) {
		this.transCharge = transCharge;
	}
	
	public String getHandCancel() {
		return handCancel;
	}
	
	public void setHandCancel(String handCancel) {
		this.handCancel = handCancel;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CreateDebtTransferRuleOrder{");
		sb.append("ruleId=").append(ruleId);
		sb.append(", holdingDate=").append(holdingDate);
		sb.append(", validDate=").append(validDate);
		sb.append(", priceOnline=").append(priceOnline);
		sb.append(", priceOffline=").append(priceOffline);
		sb.append(", transCharge=").append(transCharge);
		sb.append(", handCancel='").append(handCancel).append('\'');
		sb.append(", version='").append(version).append('\'');
		sb.append(", remark='").append(remark).append('\'');
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append('}');
		return sb.toString();
	}
}
