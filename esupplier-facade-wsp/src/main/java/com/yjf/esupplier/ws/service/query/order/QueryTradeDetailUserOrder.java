package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.DivisionPhaseEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class QueryTradeDetailUserOrder extends QueryPageBase implements Order {
	private static final long serialVersionUID = 2022966343111516785L;
	long userId;
	long tradeId;
	SysUserRoleEnum roleEnum;
	DivisionPhaseEnum transferPhase;
	String tradeDetailId;
	String detailStatus;
	Date startDate;
	Date endDate;
	Date startRepayDate;
	Date endRepayDate;
	Date startActualRepayDate;
	Date endActualRepayDate;
	Money startAmount;
	Money endAmount;
	String userName;
	String realName;
	String profitType;  //0:普通收益，1：额外收益
	int periodNo = 0;
    /**
     * 是否收款
     */
    boolean isCollection = false;

    /**
     * 不包含失败交易
     */
    String notHasTradeFail;
	
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
	
	public Money getStartAmount() {
		return this.startAmount;
	}
	
	public void setStartAmount(Money startAmount) {
		this.startAmount = startAmount;
	}
	
	public Money getEndAmount() {
		return this.endAmount;
	}
	
	public void setEndAmount(Money endAmount) {
		this.endAmount = endAmount;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public SysUserRoleEnum getRoleEnum() {
		return this.roleEnum;
	}
	
	public void setRoleEnum(SysUserRoleEnum roleEnum) {
		this.roleEnum = roleEnum;
	}
	
	public DivisionPhaseEnum getTransferPhase() {
		return this.transferPhase;
	}
	
	public void setTransferPhase(DivisionPhaseEnum transferPhase) {
		this.transferPhase = transferPhase;
	}
	
	public String getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(String tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public String getDetailStatus() {
		return this.detailStatus;
	}
	
	public void setDetailStatus(String detailStatus) {
		this.detailStatus = detailStatus;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public int getPeriodNo() {
		return this.periodNo;
	}
	
	public void setPeriodNo(int periodNo) {
		this.periodNo = periodNo;
	}
	
	public Date getStartRepayDate() {
		return startRepayDate;
	}

	public void setStartRepayDate(Date startRepayDate) {
		this.startRepayDate = startRepayDate;
	}

	public Date getEndRepayDate() {
		return endRepayDate;
	}

	public void setEndRepayDate(Date endRepayDate) {
		this.endRepayDate = endRepayDate;
	}

	public Date getStartActualRepayDate() {
		return startActualRepayDate;
	}

	public void setStartActualRepayDate(Date startActualRepayDate) {
		this.startActualRepayDate = startActualRepayDate;
	}

	public Date getEndActualRepayDate() {
		return endActualRepayDate;
	}

	public void setEndActualRepayDate(Date endActualRepayDate) {
		this.endActualRepayDate = endActualRepayDate;
	}

	public String getProfitType() {
		return profitType;
	}

	public void setProfitType(String profitType) {
		this.profitType = profitType;
	}

    public String getNotHasTradeFail() {
        return notHasTradeFail;
    }

    public void setNotHasTradeFail(String notHasTradeFail) {
        this.notHasTradeFail = notHasTradeFail;
    }


    public boolean getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(boolean isCollection) {
        this.isCollection = isCollection;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryTradeDetailUserOrder [userId=");
		builder.append(userId);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", roleEnum=");
		builder.append(roleEnum);
		builder.append(", transferPhase=");
		builder.append(transferPhase);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", detailStatus=");
		builder.append(detailStatus);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", startRepayDate=");
		builder.append(startRepayDate);
		builder.append(", endRepayDate=");
		builder.append(endRepayDate);
		builder.append(", startActualRepayDate=");
		builder.append(startActualRepayDate);
		builder.append(", endActualRepayDate=");
		builder.append(endActualRepayDate);
		builder.append(", startAmount=");
		builder.append(startAmount);
		builder.append(", endAmount=");
		builder.append(endAmount);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", periodNo=");
		builder.append(periodNo);
		builder.append(", profitType=");
		builder.append(profitType);
		builder.append("]");
		
		return builder.toString();
	}
	
	@Override
	public void check() {
		
	}
}
