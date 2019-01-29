package com.yjf.esupplier.ws.integral.info;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;

public class UserPointInfo implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = -4282603875229233564L;

    //========== properties ==========

	private long userPointsId;
	private String userBaseId;
	private long pointsTotal;
	private String state;
	private String userName;
	private String realName;
	private int roleId;
	private PointsTypeEnum pointsType;
	private Date addTime;

    //========== getters and setters ==========

	public long getUserPointsId() {
		return userPointsId;
	}
	
	public void setUserPointsId(long userPointsId) {
		this.userPointsId = userPointsId;
	}

	public String getUserBaseId() {
		return userBaseId;
	}
	
	public void setUserBaseId(String userBaseId) {
		this.userBaseId = userBaseId;
	}

	public long getPointsTotal() {
		return pointsTotal;
	}
	
	public void setPointsTotal(long pointsTotal) {
		this.pointsTotal = pointsTotal;
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public PointsTypeEnum getPointsType() {
		return pointsType;
	}

	public void setPointsType(PointsTypeEnum pointsType) {
		this.pointsType = pointsType;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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
