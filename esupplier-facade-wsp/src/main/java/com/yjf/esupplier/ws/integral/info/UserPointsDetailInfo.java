package com.yjf.esupplier.ws.integral.info;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yjf.esupplier.ws.integral.enums.PointsStateEnum;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

public class UserPointsDetailInfo implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4282603875229233564L;
	
	//========== properties ==========
	
	private long pointsDetailId;
	
	private long userId;
	
	private PointsTypeEnum pointsType;
	
	private UserLevelRuleType valueType = UserLevelRuleType.POINT;
	
	private PointsStateEnum state;
	
	private String goods;
	/**
	 * 获取积分
	 */
	private long pointValue;
	/**
	 * 获取余额
	 */
	private long pointBalance;
	/**
	 * 消费积分
	 */
	private long consumerPointValue;
	
	private String source;
	
	private long pointsRuleId;
	
	private String content;
	
	private String def1;
	
	private String def2;
	
	private String def3;
	/**
	 * 外部订单号用于唯一性处理
	 */
	private String outBizNo;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	//========== getters and setters ==========
	
	public long getPointsDetailId() {
		return pointsDetailId;
	}
	
	public void setPointsDetailId(long pointsDetailId) {
		this.pointsDetailId = pointsDetailId;
	}
	
	public PointsTypeEnum getPointsType() {
		return pointsType;
	}
	
	public void setPointsType(PointsTypeEnum pointsType) {
		this.pointsType = pointsType;
	}
	
	public String getGoods() {
		return goods;
	}
	
	public void setGoods(String goods) {
		this.goods = goods;
	}
	
	public long getPointValue() {
		return pointValue;
	}
	
	public void setPointValue(long pointValue) {
		this.pointValue = pointValue;
	}
	
	public long getRemainingPoints() {
		return pointValue - consumerPointValue;
	}
	
	public long getConsumerPointValue() {
		return this.consumerPointValue;
	}
	
	public void setConsumerPointValue(long consumerPointValue) {
		this.consumerPointValue = consumerPointValue;
	}
	
	public long getPointBalance() {
		return pointBalance;
	}
	
	public void setPointBalance(long pointBalance) {
		this.pointBalance = pointBalance;
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
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public void setState(PointsStateEnum state) {
		this.state = state;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public PointsStateEnum getState() {
		return this.state;
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
