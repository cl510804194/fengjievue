package com.yjf.esupplier.ws.integral.data;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yjf.esupplier.ws.integral.enums.PointsRuleStateEnum;
import com.yjf.esupplier.ws.integral.enums.PointsRuleValidityTypeEnum;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

/**
 * Created by min on 2014/11/17.
 */
public class PointsRuleData implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4282603875229233564L;
	
	//========== properties ==========
	
	private long pointsRuleId;
	
	private String ruleName;
	
	private Date startTime;
	
	private Date endTime;
	
	private PointsTypeEnum ruleType;
	
	private UserLevelRuleType valueType;
	
	private PointsRuleStateEnum state;
	
	private double pointValue;
	
	private long pointsValid;
	
	private PointsRuleValidityTypeEnum validityType;
	
	private String def1;
	
	private String def2;
	
	private String def3;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	//========== getters and setters ==========
	
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
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
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
	
	public long getPointsValid() {
		return this.pointsValid;
	}
	
	public void setPointsValid(long pointsValid) {
		this.pointsValid = pointsValid;
	}
	
	public PointsRuleValidityTypeEnum getValidityType() {
		return this.validityType;
	}
	
	public void setValidityType(PointsRuleValidityTypeEnum validityType) {
		this.validityType = validityType;
	}
	
	/**
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
