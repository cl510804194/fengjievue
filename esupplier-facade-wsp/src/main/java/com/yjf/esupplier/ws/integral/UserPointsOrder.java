package com.yjf.esupplier.ws.integral;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

public class UserPointsOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = 703872127852215528L;
	
	/** 用户id */
	protected long userId;
	/** 积分类型 */
	protected PointsTypeEnum pointsTypeEnum;
	
	/** 值类型 */
	protected UserLevelRuleType valueType = UserLevelRuleType.POINT;
	
	/** 积分值 */
	protected long pointValue;
	/** 积分来源 */
	protected String source;
	/** 积分规则ID */
	protected long pointsRuleId;
	/** 积分事由 */
	protected String content;
	/** 外部订单号 */
	protected String outBizNo;
	
	/**
	 * 
	 * @see com.yjf.common.service.Order#check()
	 */
	@Override
	public void check() {
		validateHasZore(userId, "用户id");
		validateHasZore(pointValue, "积分值");
		validateNotNull(pointsTypeEnum, "积分类型");
		validateNotNull(valueType, "值类型");
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public PointsTypeEnum getPointsTypeEnum() {
		return pointsTypeEnum;
	}
	
	public void setPointsTypeEnum(PointsTypeEnum pointsTypeEnum) {
		this.pointsTypeEnum = pointsTypeEnum;
	}
	
	public long getPointValue() {
		return pointValue;
	}
	
	public void setPointValue(long pointValue) {
		this.pointValue = pointValue;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public long getPointsRuleId() {
		return pointsRuleId;
	}
	
	public void setPointsRuleId(long pointsRuleId) {
		this.pointsRuleId = pointsRuleId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public UserLevelRuleType getValueType() {
		return this.valueType;
	}
	
	public void setValueType(UserLevelRuleType valueType) {
		this.valueType = valueType;
	}
	
	public String getOutBizNo() {
		return this.outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserPointsOrder [userId=");
		builder.append(userId);
		builder.append(", pointsTypeEnum=");
		builder.append(pointsTypeEnum);
		builder.append(", valueType=");
		builder.append(valueType);
		builder.append(", pointValue=");
		builder.append(pointValue);
		builder.append(", source=");
		builder.append(source);
		builder.append(", pointsRuleId=");
		builder.append(pointsRuleId);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}
	
}
