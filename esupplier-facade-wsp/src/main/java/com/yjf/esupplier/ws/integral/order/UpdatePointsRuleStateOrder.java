package com.yjf.esupplier.ws.integral.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.integral.enums.PointsRuleStateEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class UpdatePointsRuleStateOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 8060079402917808781L;
	
	protected long pointsRuleId;
	
	protected PointsRuleStateEnum state;
	
	@Override
	public void check() {
		this.validateHasZore(pointsRuleId, "积分规则ID");
		this.validateNotNull(state, "积分状态");
	}
	
	public long getPointsRuleId() {
		return pointsRuleId;
	}
	
	public void setPointsRuleId(long pointsRuleId) {
		this.pointsRuleId = pointsRuleId;
	}
	
	public PointsRuleStateEnum getState() {
		return state;
	}
	
	public void setState(PointsRuleStateEnum state) {
		this.state = state;
	}
	
}
