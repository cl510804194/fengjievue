package com.yjf.esupplier.ws.gifamount.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;

/**
 * Created by min on 2014/11/17.
 */
public class GiftMoneyData implements Serializable {
	private static final long serialVersionUID = 368416569119205811L;
	/** 优惠券id */
	protected long giftId;
	/** 优惠券名称 */
	protected String giftName;
	
	/** 优惠券金额 */
	protected Money amount = new Money(0, 0);
	/** 优惠券发放金额 */
	protected Money totalAmount = new Money(0, 0);
	
	protected Money usedAmount = new Money(0, 0);
	/** 优惠券使用类型 */
	protected String useType;
	
	protected GiftMoneyTypeEnum type;
	
	protected String useAmount;
	
	protected GiftMoneyGiveTypeEnum giveType;
	
	protected String giveAmount;
	
	private long giftNum;
	
	private long personNum;
	private long usedGiftNum;
	
	/** 优惠券使用结束日期 */
	
	protected Date endDate;
	/** 优惠券使用开始日期 */
	protected Date startDate;
	
	protected Date useEndDate;
	/** 优惠券使用开始日期 */
	protected Date useStartDate;
	
	/** 状态 */
	protected String status;
	/** 优惠券创建者 */
	protected long createUserid;
	/** 优惠券创建者名称 */
	protected String createUsername;
	/** 优惠券添加时间 */
	protected Date rawAddTime;
	/** 红优惠券更新时间 */
	protected Date rawUpdateTime;
	/** 优惠券描述 */
	protected String description;
	
	protected String increase;
	
	protected String timeLimit;
	protected String outBizNo;
	
	protected String loanBizType;
	
	public long getUsedGiftNum() {
		return usedGiftNum;
	}
	
	public void setUsedGiftNum(long usedGiftNum) {
		this.usedGiftNum = usedGiftNum;
	}
	
	public Money getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Money getUsedAmount() {
		return usedAmount;
	}
	
	public void setUsedAmount(Money usedAmount) {
		this.usedAmount = usedAmount;
	}
	
	public String getUseAmount() {
		return useAmount;
	}
	
	public void setUseAmount(String useAmount) {
		this.useAmount = useAmount;
	}
	
	public GiftMoneyGiveTypeEnum getGiveType() {
		return giveType;
	}
	
	public void setGiveType(GiftMoneyGiveTypeEnum giveType) {
		this.giveType = giveType;
	}
	
	public String getGiveAmount() {
		return giveAmount;
	}
	
	public void setGiveAmount(String giveAmount) {
		this.giveAmount = giveAmount;
	}
	
	public long getGiftNum() {
		return giftNum;
	}
	
	public void setGiftNum(long giftNum) {
		this.giftNum = giftNum;
	}
	
	public long getPersonNum() {
		return personNum;
	}
	
	public void setPersonNum(long personNum) {
		this.personNum = personNum;
	}
	
	public long getGiftId() {
		return giftId;
	}
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	
	public String getGiftName() {
		return giftName;
	}
	
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getUseType() {
		return useType;
	}
	
	public void setUseType(String useType) {
		this.useType = useType;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getCreateUserid() {
		return createUserid;
	}
	
	public void setCreateUserid(long createUserid) {
		this.createUserid = createUserid;
	}
	
	public String getCreateUsername() {
		return createUsername;
	}
	
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getUseEndDate() {
		return useEndDate;
	}
	
	public void setUseEndDate(Date useEndDate) {
		this.useEndDate = useEndDate;
	}
	
	public Date getUseStartDate() {
		return useStartDate;
	}
	
	public void setUseStartDate(Date useStartDate) {
		this.useStartDate = useStartDate;
	}
	
	public GiftMoneyTypeEnum getType() {
		return type;
	}
	
	public void setType(GiftMoneyTypeEnum type) {
		this.type = type;
	}
	
	public String getIncrease() {
		return increase;
	}
	
	public void setIncrease(String increase) {
		this.increase = increase;
	}
	
	public String getTimeLimit() {
		return timeLimit;
	}
	
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public String getOutBizNo() {
		return outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public String getLoanBizType() {
		return loanBizType;
	}
	
	public void setLoanBizType(String loanBizType) {
		this.loanBizType = loanBizType;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("GiftMoneyData{");
		sb.append("giftId=").append(giftId);
		sb.append(", giftName='").append(giftName).append('\'');
		sb.append(", amount=").append(amount);
		sb.append(", totalAmount=").append(totalAmount);
		sb.append(", usedAmount=").append(usedAmount);
		sb.append(", useType=").append(useType);
		sb.append(", type=").append(type);
		sb.append(", useAmount='").append(useAmount).append('\'');
		sb.append(", giveType=").append(giveType);
		sb.append(", giveAmount='").append(giveAmount).append('\'');
		sb.append(", giftNum=").append(giftNum);
		sb.append(", personNum=").append(personNum);
		sb.append(", usedGiftNum=").append(usedGiftNum);
		sb.append(", endDate=").append(endDate);
		sb.append(", startDate=").append(startDate);
		sb.append(", useEndDate=").append(useEndDate);
		sb.append(", useStartDate=").append(useStartDate);
		sb.append(", status='").append(status).append('\'');
		sb.append(", createUserid=").append(createUserid);
		sb.append(", createUsername='").append(createUsername).append('\'');
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append(", description='").append(description).append('\'');
		sb.append(", increase='").append(increase).append('\'');
		sb.append(", timeLimit='").append(timeLimit).append('\'');
		sb.append(", outBizNo='").append(outBizNo).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
