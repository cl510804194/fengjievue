package com.yjf.esupplier.ws.order;

import java.util.List;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.LoanPeriodUnitEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class TradeDetailQueryOrder extends QueryPageBase implements Order {
	private static final long serialVersionUID = 1996094007003616306L;
	/** 用户ID */
	private long userId = 0;
	/** 角色ID **/
	private long roleId = 0;
	/** 用户名称 **/
	private String userName;
	/** 申请号 */
	private String tradeCode;
	/** 交易名称 */
	private String tradeName;
	/** 最小金额 */
	private Long minLoanAmount;
	/** 最大金额 */
	private Long maxLoanAmount;
	/** 最小时间 */
	private String startDate;
	/** 最大时间 */
	private String endDate;
	/** 阶段 */
	private String transferPhase;
	/** 投资用户姓名 */
	private String originalRealName;
	/**
	 * 是否查分润
	 */
	private String isDivision;
	private long tradeId = 0;
	/** 状态 */
	private List<String> status;
	
	/** 借款期限 */
	private int timeLimit;
	
	/** 借款期限单位：D：天，W：周期，M：月，Y：年 */
	private LoanPeriodUnitEnum timeLimitUnit;
	/** 担保方式 */
	private String insureWay;

    /**
     * 不包含转让中的
     */
    private String notHasTransfering;
	
	public String getTradeCode() {
		return this.tradeCode;
	}
	
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public Long getMinLoanAmount() {
		return this.minLoanAmount;
	}
	
	public void setMinLoanAmount(Long minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	
	public Long getMaxLoanAmount() {
		return this.maxLoanAmount;
	}
	
	public void setMaxLoanAmount(Long maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public long getRoleId() {
		return this.roleId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<String> getStatus() {
		return this.status;
	}
	
	public void setStatus(List<String> status) {
		this.status = status;
	}
	
	public String getIsDivision() {
		return this.isDivision;
	}
	
	public void setIsDivision(String isDivision) {
		this.isDivision = isDivision;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public String getTransferPhase() {
		return this.transferPhase;
	}
	
	public void setTransferPhase(String transferPhase) {
		this.transferPhase = transferPhase;
	}
	
	public String getOriginalRealName() {
		return this.originalRealName;
	}
	
	public void setOriginalRealName(String originalRealName) {
		this.originalRealName = originalRealName;
	}
	
	
	public int getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public LoanPeriodUnitEnum getTimeLimitUnit() {
		return this.timeLimitUnit;
	}

	public void setTimeLimitUnit(LoanPeriodUnitEnum timeLimitUnit) {
		this.timeLimitUnit = timeLimitUnit;
	}

	public String getInsureWay() {
		return this.insureWay;
	}

	public void setInsureWay(String insureWay) {
		this.insureWay = insureWay;
	}

    public String getNotHasTransfering() {
        return notHasTransfering;
    }

    public void setNotHasTransfering(String notHasTransfering) {
        this.notHasTransfering = notHasTransfering;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeDetailQueryOrder [userId=");
		builder.append(userId);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", tradeCode=");
		builder.append(tradeCode);
		builder.append(", tradeName=");
		builder.append(tradeName);
		builder.append(", minLoanAmount=");
		builder.append(minLoanAmount);
		builder.append(", maxLoanAmount=");
		builder.append(maxLoanAmount);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", transferPhase=");
		builder.append(transferPhase);
		builder.append(", originalRealName=");
		builder.append(originalRealName);
		builder.append(", isDivision=");
		builder.append(isDivision);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", timeLimit=");
		builder.append(timeLimit);
		builder.append(", timeLimitUnit=");
		builder.append(timeLimitUnit);
		builder.append(", insureWay=");
		builder.append(insureWay);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public void check() {
		//Assert.isTrue(userId > 0, "userid 大于0");
	}
	
	@Override
	public String getGid() {
		return null;
	}
	
	@Override
	public void setGid(String gid) {
	}
	
}
