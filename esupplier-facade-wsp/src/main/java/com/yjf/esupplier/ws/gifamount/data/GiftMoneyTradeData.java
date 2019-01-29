package com.yjf.esupplier.ws.gifamount.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTradeTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;

/**
 * Created by min on 2014/11/17.
 */
public class GiftMoneyTradeData implements Serializable {
	
	private static final long serialVersionUID = 7485980446963044887L;
	protected long giftTradeId;
	/*红包,优惠券ID*/
	protected long giftId;
	/*金额*/
	protected Money amount = new Money(0, 0);
	/*已经使用金额*/
	protected Money usedAmount = new Money(0, 0);
	/*用户ID*/
	protected long userid;
	/*用户名称*/
	protected String username;
	/*红包,优惠券名称*/
	protected String giftName;
	/*使用限制类型(不用）*/
	protected String useType;
	/*使用限制金额(不用）*/
	protected String useAmount;
	/*使用规则金额*/
	protected String useRuleAmount;
	/*使用优惠券金额*/
	protected Money payAmount = new Money(0, 0);

	protected GiftMoneyStatusEnum status = GiftMoneyStatusEnum.NORMAL;
	/*分类*/
	protected GiftMoneyTypeEnum type;
	/*开始时间*/
	protected Date startDate;
	/*结束时间*/
	protected Date endDate;
	/*交易详情id*/
	protected long tradeDetailId;
	/*交易详情名称*/
	protected String tradeName;
	
	protected Date rawAddTime;
	
	protected Date rawUpdateTime;
	/*订单ID*/
	protected String outBizNo;
	
	protected GiftMoneyTradeTypeEnum tradeType;
	
	protected double rateOfYear;
	
	protected BooleanEnum notify;

	private String sendAccountCode;

	private String sendAccountName;

	private String sendReason;
	
	public GiftMoneyTradeTypeEnum getTradeType() {
		return tradeType;
	}
	
	public void setTradeType(GiftMoneyTradeTypeEnum tradeType) {
		this.tradeType = tradeType;
	}
	
	public long getGiftTradeId() {
		return giftTradeId;
	}
	
	public void setGiftTradeId(long giftTradeId) {
		this.giftTradeId = giftTradeId;
	}
	
	public long getGiftId() {
		return giftId;
	}
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public long getUserid() {
		return userid;
	}
	
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUseType() {
		return useType;
	}
	
	public void setUseType(String useType) {
		this.useType = useType;
	}
	
	public GiftMoneyTypeEnum getType() {
		return type;
	}
	
	public void setType(GiftMoneyTypeEnum type) {
		this.type = type;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getTradeName() {
		return tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
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
	
	public String getGiftName() {
		return giftName;
	}
	
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	
	public String getUseAmount() {
		return useAmount;
	}
	
	public void setUseAmount(String useAmount) {
		this.useAmount = useAmount;
	}
	
	public GiftMoneyStatusEnum getStatus() {
		return status;
	}
	
	public long getTradeDetailId() {
		return tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public void setStatus(GiftMoneyStatusEnum status) {
		this.status = status;
	}
	
	public String getOutBizNo() {
		return outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public Money getUsedAmount() {
		return usedAmount;
	}
	
	public void setUsedAmount(Money usedAmount) {
		this.usedAmount = usedAmount;
	}
	
	public double getRateOfYear() {
		return rateOfYear;
	}
	
	public void setRateOfYear(double rateOfYear) {
		this.rateOfYear = rateOfYear;
	}
	
	public BooleanEnum getNotify() {
		return notify;
	}
	
	public void setNotify(BooleanEnum notify) {
		this.notify = notify;
	}
	
	public String getSendAccountCode() {
		return sendAccountCode;
	}

	public void setSendAccountCode(String sendAccountCode) {
		this.sendAccountCode = sendAccountCode;
	}

	public String getSendAccountName() {
		return sendAccountName;
	}

	public void setSendAccountName(String sendAccountName) {
		this.sendAccountName = sendAccountName;
	}

	public String getSendReason() {
		return sendReason;
	}

	public void setSendReason(String sendReason) {
		this.sendReason = sendReason;
	}
	
	public String getUseRuleAmount() {
		return useRuleAmount;
	}

	public void setUseRuleAmount(String useRuleAmount) {
		this.useRuleAmount = useRuleAmount;
	}

	public Money getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Money payAmount) {
		this.payAmount = payAmount;
	}
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("GiftMoneyTradeData{");
		sb.append("giftTradeId=").append(giftTradeId);
		sb.append(", giftId=").append(giftId);
		sb.append(", amount=").append(amount);
		sb.append(", usedAmount=").append(usedAmount);
		sb.append(", userid=").append(userid);
		sb.append(", username='").append(username).append('\'');
		sb.append(", giftName='").append(giftName).append('\'');
		sb.append(", useType=").append(useType);
		sb.append(", useAmount='").append(useAmount).append('\'');
		sb.append(", status='").append(status).append('\'');
		sb.append(", type=").append(type);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", tradeDetailId=").append(tradeDetailId);
		sb.append(", tradeName='").append(tradeName).append('\'');
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append(", outBizNo='").append(outBizNo).append('\'');
		sb.append(", tradeType=").append(tradeType);
		sb.append(", rateOfYear=").append(rateOfYear);
		sb.append(", sendAccountCode=").append(sendAccountCode);
		sb.append(", sendAccountName=").append(sendAccountName);
		sb.append(", sendReason=").append(sendReason);
		sb.append(", useRuleAmount=").append(useRuleAmount);
		sb.append(", payAmount=").append(payAmount);
		sb.append('}');
		return sb.toString();
	}
}
