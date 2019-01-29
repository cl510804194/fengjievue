package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;

import com.yjf.esupplier.ws.integral.enums.PointsRuleStateEnum;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

public class PointsRuleQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = 4637443397492729265L;
	
	private long pointsRuleId;
	private String ruleName;
	private PointsTypeEnum ruleType;
	private UserLevelRuleType valueType;
	private Date startDate;
	private Date endDate;
	private PointsRuleStateEnum state;
	/**
	 * 超期时间
	 */
	private Date expireDate;
	
	public long getPointsRuleId() {
		return this.pointsRuleId;
	}
	
	public void setPointsRuleId(long pointsRuleId) {
		this.pointsRuleId = pointsRuleId;
	}
	
	public String getRuleName() {
		return this.ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	public PointsTypeEnum getRuleType() {
		return this.ruleType;
	}
	
	public void setRuleType(PointsTypeEnum ruleType) {
		this.ruleType = ruleType;
	}
	
	public UserLevelRuleType getValueType() {
		return this.valueType;
	}
	
	public void setValueType(UserLevelRuleType valueType) {
		this.valueType = valueType;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public PointsRuleStateEnum getState() {
		return this.state;
	}
	
	public void setState(PointsRuleStateEnum state) {
		this.state = state;
	}
	
	public Date getExpireDate() {
		return this.expireDate;
	}
	
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PointsRuleQueryOrder [pointsRuleId=");
		builder.append(pointsRuleId);
		builder.append(", ruleName=");
		builder.append(ruleName);
		builder.append(", ruleType=");
		builder.append(ruleType);
		builder.append(", valueType=");
		builder.append(valueType);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", state=");
		builder.append(state);
		builder.append("]");
		return builder.toString();
	}
	
}
