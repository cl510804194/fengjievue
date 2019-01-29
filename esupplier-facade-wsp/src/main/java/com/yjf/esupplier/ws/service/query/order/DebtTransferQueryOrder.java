package com.yjf.esupplier.ws.service.query.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.enums.DebtTransferStatus;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class DebtTransferQueryOrder extends QueryPageBase {
	
	private static final long serialVersionUID = -6087031601221993057L;
	/**
	 * 申请转让用户ID
	 */
	protected long applyUserId;
	/**
	 * 申请转让用户登录名
	 */
	protected String applyUserName;
	/**
	 * 申请转让用户真实名称
	 */
	protected String applyRealName;
	
	/**
	 * 转让接受用户ID
	 */
	protected long recipientId;
	/**
	 * 转让接受用户登录名
	 */
	protected String recipientName;
	/**
	 * 转让接受用户真实名称
	 */
	protected String recipientRealName;
	
	/**
	 * 关联交易id
	 */
	protected long tradeId;
	/**
	 * 交易名称
	 */
	protected String tradeName;
	/**
	 * 关联投资id
	 */
	protected long tradeDetailId;
	/**
	 * 查询状态
	 * 
	 */
	protected List<DebtTransferStatus> statusList = new ArrayList<DebtTransferStatus>();
	/**
	 * 转让开始时间
	 * 
	 */
	protected Date startTransferDate;
	/**
	 * 转让结束时间
	 */
	protected Date endTransferDate;
	
	/**
	 * 发布开始时间
	 * 
	 */
	protected Date startCreateDate;
	/**
	 * 发布结束时间
	 */
	protected Date endCreateDate;
	
	public long getApplyUserId() {
		return this.applyUserId;
	}
	
	public void setApplyUserId(long applyUserId) {
		this.applyUserId = applyUserId;
	}
	
	public String getApplyUserName() {
		return this.applyUserName;
	}
	
	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}
	
	public String getApplyRealName() {
		return this.applyRealName;
	}
	
	public void setApplyRealName(String applyRealName) {
		this.applyRealName = applyRealName;
	}
	
	public long getRecipientId() {
		return this.recipientId;
	}
	
	public void setRecipientId(long recipientId) {
		this.recipientId = recipientId;
	}
	
	public String getRecipientName() {
		return this.recipientName;
	}
	
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	public String getRecipientRealName() {
		return this.recipientRealName;
	}
	
	public void setRecipientRealName(String recipientRealName) {
		this.recipientRealName = recipientRealName;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public String getTradeName() {
		return this.tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public List<DebtTransferStatus> getStatusList() {
		return this.statusList;
	}
	
	public void setStatusList(List<DebtTransferStatus> statusList) {
		this.statusList = statusList;
	}
	
	public Date getStartTransferDate() {
		return this.startTransferDate;
	}
	
	public void setStartTransferDate(Date startTransferDate) {
		this.startTransferDate = startTransferDate;
	}
	
	public Date getEndTransferDate() {
		return this.endTransferDate;
	}
	
	public void setEndTransferDate(Date endTransferDate) {
		this.endTransferDate = endTransferDate;
	}
	
	public Date getStartCreateDate() {
		return this.startCreateDate;
	}
	
	public void setStartCreateDate(Date startCreateDate) {
		this.startCreateDate = startCreateDate;
	}
	
	public Date getEndCreateDate() {
		return this.endCreateDate;
	}
	
	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferQueryOrder [applyUserId=");
		builder.append(applyUserId);
		builder.append(", applyUserName=");
		builder.append(applyUserName);
		builder.append(", applyRealName=");
		builder.append(applyRealName);
		builder.append(", recipientId=");
		builder.append(recipientId);
		builder.append(", recipientName=");
		builder.append(recipientName);
		builder.append(", recipientRealName=");
		builder.append(recipientRealName);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", tradeName=");
		builder.append(tradeName);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", statusList=");
		builder.append(statusList);
		builder.append(", startTransferDate=");
		builder.append(startTransferDate);
		builder.append(", endTransferDate=");
		builder.append(endTransferDate);
		builder.append(", startCreateDate=");
		builder.append(startCreateDate);
		builder.append(", endCreateDate=");
		builder.append(endCreateDate);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
