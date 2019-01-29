package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.ExtPayTypeEnum;
import com.yjf.esupplier.ws.enums.ToCardFlowStatusEnum;

/**
 * 
 * 
 * 
 * @author zeyong
 * 
 */
public class ToCardFlowInfo implements Serializable {
	
	private static final long serialVersionUID = 3846405500890849723L;
	
	private long flowId;
	
	private long userId;
	
	private String yjfAccountId;
	
	private String userName;
	
	private String userRealName;
	
	private long outUserId;
	
	private String outYjfAccountId;
	
	private String outUserName;
	
	private String outUserRealName;
	
	private String outBizNo;
	
	private String bankName;
	
	private String bankCode;
	
	private String bankAccountNo;
	
	private String bankAcountName;
	
	private String bankProvince;
	
	private String bankCity;
	
	private Money amount = new Money(0, 0);
	
	private ExtPayTypeEnum payType;
	/**
	 * 对公对私
	 */
	private BooleanEnum publicTag;
	/**
	 * in out
	 */
	private String inOutType;
	
	private Date payTime;
	
	private ToCardFlowStatusEnum status;// 状态:
	/**
	 * 备注
	 */
	private String rem1;

	private Date rawAddTime;

	public Date getRawAddTime() {
		return rawAddTime ;
	}

	private String applyTime;

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = DateUtil.simpleFormat(applyTime);
	}

	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}

	public long getFlowId() {
		return this.flowId;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getYjfAccountId() {
		return this.yjfAccountId;
	}
	
	public void setYjfAccountId(String yjfAccountId) {
		this.yjfAccountId = yjfAccountId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserRealName() {
		return this.userRealName;
	}
	
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	
	public void setFlowId(long flowId) {
		this.flowId = flowId;
	}
	
	public long getOutUserId() {
		return this.outUserId;
	}
	
	public void setOutUserId(long outUserId) {
		this.outUserId = outUserId;
	}
	
	public String getOutYjfAccountId() {
		return this.outYjfAccountId;
	}
	
	public void setOutYjfAccountId(String outYjfAccountId) {
		this.outYjfAccountId = outYjfAccountId;
	}
	
	public String getOutUserName() {
		return this.outUserName;
	}
	
	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
	}
	
	public String getOutUserRealName() {
		return this.outUserRealName;
	}
	
	public void setOutUserRealName(String outUserRealName) {
		this.outUserRealName = outUserRealName;
	}
	
	public String getOutBizNo() {
		return this.outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public String getBankName() {
		return this.bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankAccountNo() {
		return this.bankAccountNo;
	}
	
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	public String getBankAcountName() {
		return this.bankAcountName;
	}
	
	public void setBankAcountName(String bankAcountName) {
		this.bankAcountName = bankAcountName;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public ExtPayTypeEnum getPayType() {
		return this.payType;
	}
	
	public void setPayType(ExtPayTypeEnum payType) {
		this.payType = payType;
	}
	
	public String getInOutType() {
		return this.inOutType;
	}
	
	public void setInOutType(String inOutType) {
		this.inOutType = inOutType;
	}
	
	public Date getPayTime() {
		return this.payTime;
	}
	
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
	public String getRem1() {
		return this.rem1;
	}
	
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	
	public String getBankProvince() {
		return this.bankProvince;
	}
	
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	
	public String getBankCity() {
		return this.bankCity;
	}
	
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	
	public BooleanEnum getPublicTag() {
		return this.publicTag;
	}
	
	public void setPublicTag(BooleanEnum publicTag) {
		this.publicTag = publicTag;
	}
	
	public ToCardFlowStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(ToCardFlowStatusEnum status) {
		this.status = status;
	}
	
	public String getBankCode() {
		return this.bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ToCardFlowInfo [flowId=");
		builder.append(flowId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", yjfAccountId=");
		builder.append(yjfAccountId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userRealName=");
		builder.append(userRealName);
		builder.append(", outUserId=");
		builder.append(outUserId);
		builder.append(", outYjfAccountId=");
		builder.append(outYjfAccountId);
		builder.append(", outUserName=");
		builder.append(outUserName);
		builder.append(", outUserRealName=");
		builder.append(outUserRealName);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", bankAccountNo=");
		builder.append(bankAccountNo);
		builder.append(", bankAcountName=");
		builder.append(bankAcountName);
		builder.append(", bankProvince=");
		builder.append(bankProvince);
		builder.append(", bankCity=");
		builder.append(bankCity);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", payType=");
		builder.append(payType);
		builder.append(", publicTag=");
		builder.append(publicTag);
		builder.append(", inOutType=");
		builder.append(inOutType);
		builder.append(", payTime=");
		builder.append(payTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", rem1=");
		builder.append(rem1);
		builder.append("]");
		return builder.toString();
	}
	
}
