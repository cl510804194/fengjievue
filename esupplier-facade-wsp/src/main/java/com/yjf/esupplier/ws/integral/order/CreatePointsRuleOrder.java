package com.yjf.esupplier.ws.integral.order;

import java.util.Date;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.integral.enums.PointsRuleStateEnum;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

public class CreatePointsRuleOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 8060079402917808781L;
	
	protected long pointsRuleId;
	
	protected String ruleName;
	
	protected String startTime;
	
	protected String endTime;
	
	protected PointsTypeEnum ruleType;
	
	private UserLevelRuleType valueType;
	
	protected PointsRuleStateEnum state;
	
	private double pointValue;
	
	protected String def1;
	
	protected String def2;
	
	protected String def3;
	
	protected String s_pointsValue;
	
	protected String i_pointsValue;
	
	protected String[] userLevel;
	
	protected String[] tradeAmount;
	
	protected String[] pointsValue;
	
	protected String[] coefficient;
	protected String r_time;
	
	protected String r_invest;
	
	protected String action;
	
	@Override
	public void check() {
		if ("delete".equalsIgnoreCase(action)) {
			this.validateHasZore(pointsRuleId, "积分规则ID");
		} else {
			this.validateHasText(ruleName, "积分规则名称");
			this.validateNotNull(ruleType, "积分活动类型");
			
			Date nowDate = new Date();
			Date nextDate = DateUtil.getEndTimeOfTheDate(nowDate);
			Date startDate = null;
			Date endDate = null;
			String format = "yyyy-MM-dd HH:mm:ss";
			
			if (StringUtil.isNotEmpty(startTime)) {
				startDate = DateUtil.string2Date(startTime, format);
			}
			if (StringUtil.isNotEmpty(endTime)) {
				endDate = DateUtil.string2Date(endTime, format);
				if (StringUtil.isNotEmpty(startTime)) {
					Assert.isTrue(startDate.before(endDate), "活动结束时间必须大于开始时间!");
				}
			}
			
			if (startTime != null || endTime != null) {
				this.validateHasText(startTime, "活动开始时间");
				Assert.isTrue(startDate.compareTo(nextDate) > 0, "活动开始时间最近只能选择次日！");
				this.validateHasText(endTime, "活动结束时间");
			}
		}
		
	}
	
	public long getPointsRuleId() {
		return pointsRuleId;
	}
	
	public void setPointsRuleId(long pointsRuleId) {
		this.pointsRuleId = pointsRuleId;
	}
	
	public String getRuleName() {
		return ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public PointsTypeEnum getRuleType() {
		return ruleType;
	}
	
	public void setRuleType(PointsTypeEnum ruleType) {
		this.ruleType = ruleType;
	}
	
	public PointsRuleStateEnum getState() {
		return state;
	}
	
	public void setState(PointsRuleStateEnum state) {
		this.state = state;
	}
	
	public String getDef1() {
		return def1;
	}
	
	public void setDef1(String def1) {
		this.def1 = def1;
	}
	
	public String getDef2() {
		return def2;
	}
	
	public void setDef2(String def2) {
		this.def2 = def2;
	}
	
	public String getDef3() {
		return def3;
	}
	
	public void setDef3(String def3) {
		this.def3 = def3;
	}
	
	public String[] getTradeAmount() {
		return this.tradeAmount;
	}
	
	public void setTradeAmount(String[] tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	
	public String[] getPointsValue() {
		return pointsValue;
	}
	
	public void setPointsValue(String[] pointsValue) {
		this.pointsValue = pointsValue;
	}
	
	public String getR_time() {
		return r_time;
	}
	
	public void setR_time(String r_time) {
		this.r_time = r_time;
	}
	
	public String getR_invest() {
		return r_invest;
	}
	
	public void setR_invest(String r_invest) {
		this.r_invest = r_invest;
	}
	
	public String getS_pointsValue() {
		return s_pointsValue;
	}
	
	public void setS_pointsValue(String s_pointsValue) {
		this.s_pointsValue = s_pointsValue;
	}
	
	public String getI_pointsValue() {
		return i_pointsValue;
	}
	
	public void setI_pointsValue(String i_pointsValue) {
		this.i_pointsValue = i_pointsValue;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public UserLevelRuleType getValueType() {
		return this.valueType;
	}
	
	public void setValueType(UserLevelRuleType valueType) {
		this.valueType = valueType;
	}
	
	public double getPointValue() {
		return this.pointValue;
	}
	
	public void setPointValue(double pointValue) {
		this.pointValue = pointValue;
	}
	
	public String[] getUserLevel() {
		return this.userLevel;
	}
	
	public void setUserLevel(String[] userLevel) {
		this.userLevel = userLevel;
	}
	
	public String[] getCoefficient() {
		return this.coefficient;
	}
	
	public void setCoefficient(String[] coefficient) {
		this.coefficient = coefficient;
	}
	
}
