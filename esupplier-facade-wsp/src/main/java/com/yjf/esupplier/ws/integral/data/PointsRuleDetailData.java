package com.yjf.esupplier.ws.integral.data;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.userManage.enums.UserLevelEnum;

/**
 * Created by min on 2014/11/17.
 */
public class PointsRuleDetailData implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4282603875229233564L;
	
	//========== properties ==========
	
	private long pointsRuleDetailId;
	
	private long pointsRuleId;
	
	private Money amount = new Money(0, 0);
	
	private UserLevelEnum userLevel;
	
	private long priority;
	
	private double coefficient;
	
	private long pointsValue;
	
	private String def1;
	
	private String def2;
	
	private String def3;
	
	private String def4;
	
	private String def5;
	
	private String def6;
	
	private String def7;
	
	private String def8;
	
	//========== getters and setters ==========
	
	public long getPointsRuleDetailId() {
		return pointsRuleDetailId;
	}
	
	public void setPointsRuleDetailId(long pointsRuleDetailId) {
		this.pointsRuleDetailId = pointsRuleDetailId;
	}
	
	public long getPointsRuleId() {
		return pointsRuleId;
	}
	
	public void setPointsRuleId(long pointsRuleId) {
		this.pointsRuleId = pointsRuleId;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public UserLevelEnum getUserLevel() {
		return this.userLevel;
	}
	
	public void setUserLevel(UserLevelEnum userLevel) {
		this.userLevel = userLevel;
	}
	
	public long getPointsValue() {
		return pointsValue;
	}
	
	public void setPointsValue(long pointsValue) {
		this.pointsValue = pointsValue;
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
	
	public String getDef4() {
		return def4;
	}
	
	public void setDef4(String def4) {
		this.def4 = def4;
	}
	
	public String getDef5() {
		return def5;
	}
	
	public void setDef5(String def5) {
		this.def5 = def5;
	}
	
	public String getDef6() {
		return def6;
	}
	
	public void setDef6(String def6) {
		this.def6 = def6;
	}
	
	public String getDef7() {
		return def7;
	}
	
	public void setDef7(String def7) {
		this.def7 = def7;
	}
	
	public String getDef8() {
		return def8;
	}
	
	public void setDef8(String def8) {
		this.def8 = def8;
	}
	
	public long getPriority() {
		return this.priority;
	}
	
	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	public double getCoefficient() {
		return this.coefficient;
	}
	
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	/**
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddPointsOrder [pointsRuleId=");
		builder.append(pointsRuleId);
		builder.append(", userLevel=");
		builder.append(userLevel);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", coefficient=");
		builder.append(coefficient);
		builder.append(", pointsValue=");
		builder.append(pointsValue);
		builder.append("]");
		return builder.toString();
	}
}
