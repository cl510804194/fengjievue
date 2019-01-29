package com.yjf.esupplier.ws.info;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.data.TradeData;
import com.yjf.esupplier.ws.enums.DivisionPhaseEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;

public class TradeDetailVOInfo extends TradeData {
	
	private static final long serialVersionUID = -6306183311164459906L;
	DivisionPhaseEnum transferPhase;
	Money benefitAmount;
	Money originalAmount;
	//这个投资项目的收益
	String thisBenefit;
	Date createDate;
	String realName;
	long userId;
	String note;
	long tradeDetailId;
	SysUserRoleEnum roleEnum;
	String originalRealName;
	String originalUserName;
    String brokerUserName;
    String brokerRealName;
    //角色名称，从数据库里面取，不同的分支，名称不一样
	String roleName;
    //能否转让
    String canTrans;

	public String getThisBenefit() {
		return this.thisBenefit;
	}

	public void setThisBenefit(String thisBenefit) {
		this.thisBenefit = thisBenefit;
	}

	public DivisionPhaseEnum getTransferPhase() {
		return this.transferPhase;
	}
	
	public void setTransferPhase(DivisionPhaseEnum transferPhase) {
		this.transferPhase = transferPhase;
	}
	
	public Money getBenefitAmount() {
		return this.benefitAmount;
	}
	
	public void setBenefitAmount(Money benefitAmount) {
		this.benefitAmount = benefitAmount;
	}
	
	public Money getOriginalAmount() {
		return this.originalAmount;
	}
	
	public void setOriginalAmount(Money originalAmount) {
		this.originalAmount = originalAmount;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public SysUserRoleEnum getRoleEnum() {
		return this.roleEnum;
	}
	
	public void setRoleEnum(SysUserRoleEnum roleEnum) {
		this.roleEnum = roleEnum;
	}
	
	public String getOriginalRealName() {
		return this.originalRealName;
	}
	
	public void setOriginalRealName(String originalRealName) {
		this.originalRealName = originalRealName;
	}
	
	public String getOriginalUserName() {
		return this.originalUserName;
	}
	
	public void setOriginalUserName(String originalUserName) {
		this.originalUserName = originalUserName;
	}

    public String getRoleName() {
        return roleName;
    }

    public String getBrokerUserName() {
        return brokerUserName;
    }

    public void setBrokerUserName(String brokerUserName) {
        this.brokerUserName = brokerUserName;
    }

    public String getBrokerRealName() {
        return brokerRealName;
    }

    public void setBrokerRealName(String brokerRealName) {
        this.brokerRealName = brokerRealName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCanTrans() {
        return canTrans;
    }

    public void setCanTrans(String canTrans) {
        this.canTrans = canTrans;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeDetailVOInfo [transferPhase=");
		builder.append(transferPhase);
		builder.append(", benefitAmount=");
		builder.append(benefitAmount);
		builder.append(", originalAmount=");
		builder.append(originalAmount);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", note=");
		builder.append(note);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", roleEnum=");
		builder.append(roleEnum);
		builder.append(", originalRealName=");
		builder.append(originalRealName);
		builder.append(", originalUserName=");
		builder.append(originalUserName);
		builder.append(", originalUserName=");
		builder.append(originalUserName);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
