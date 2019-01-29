package com.yjf.esupplier.ws.integral.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.integral.enums.PointsStateEnum;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

public class UserPointsDetailQueryOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 8493006361509749649L;
	/** 用户id */
	private long userId;
	/** 用户名 */
	private String userName;
	/** 积分类型 */
	private PointsTypeEnum pointsType;
	/** 创建开始时间 */
	private Date startAddTime;
	/** 创建结束时间 */
	private Date endAddTime;
	
	private List<PointsTypeEnum> pointTypes;
	
	private long pointsRuleId;
	
	private String source;
	
	private UserLevelRuleType valueType = UserLevelRuleType.POINT;

	private String outBizNo;

	private PointsStateEnum state;
	private String addTimeOrder = null;
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public PointsTypeEnum getPointsType() {
		return pointsType;
	}
	
	public void setPointsType(PointsTypeEnum pointsType) {
		this.pointsType = pointsType;
	}
	
	public Date getStartAddTime() {
		return startAddTime;
	}
	
	public void setStartAddTime(Date startAddTime) {
		this.startAddTime = startAddTime;
	}
	
	public Date getEndAddTime() {
		return endAddTime;
	}
	
	public void setEndAddTime(Date endAddTime) {
		this.endAddTime = endAddTime;
	}
	
	public List<PointsTypeEnum> getPointTypes() {
		return this.pointTypes;
	}
	
	public void setPointTypes(List<PointsTypeEnum> pointTypes) {
		this.pointTypes = pointTypes;
	}
	
	public long getPointsRuleId() {
		return this.pointsRuleId;
	}
	
	public void setPointsRuleId(long pointsRuleId) {
		this.pointsRuleId = pointsRuleId;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public PointsStateEnum getState() {
		return this.state;
	}
	
	public void setState(PointsStateEnum state) {
		this.state = state;
	}
	
	public UserLevelRuleType getValueType() {
		return this.valueType;
	}
	
	public void setValueType(UserLevelRuleType valueType) {
		this.valueType = valueType;
	}
	
	public String getAddTimeOrder() {
		return this.addTimeOrder;
	}
	
	public void setAddTimeOrder(String addTimeOrder) {
		this.addTimeOrder = addTimeOrder;
	}


	public String getOutBizNo() {
		return outBizNo;
	}

	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserPointsDetailQueryOrder [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", pointsType=");
		builder.append(pointsType);
		builder.append(", startAddTime=");
		builder.append(startAddTime);
		builder.append(", endAddTime=");
		builder.append(endAddTime);
		builder.append(", pointTypes=");
		builder.append(pointTypes);
		builder.append(", pointsRuleId=");
		builder.append(pointsRuleId);
		builder.append(", source=");
		builder.append(source);
		builder.append(", valueType=");
		builder.append(valueType);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", state=");
		builder.append(state);
		builder.append(", addTimeOrder=");
		builder.append(addTimeOrder);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
