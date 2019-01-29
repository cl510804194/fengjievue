package com.yjf.esupplier.ws.bill.info;

import java.io.Serializable;
import java.util.Date;

public class ProductScoreInfo implements Serializable {
	
	private static final long serialVersionUID = -6840694275912809236L;
	private long id;
	
	private long objectId;
	
	private long score;

	/*点赞数*/
	private long likeCount;
	
	private String clientIp;
	
	private Date createTime;
	
	private long memberId;

	private String userName;
	
	private String PComment;
	
	private long orderId;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;

	private long supplierId;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getObjectId() {
		return this.objectId;
	}
	
	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}
	
	public long getScore() {
		return this.score;
	}
	
	public void setScore(long score) {
		this.score = score;
	}
	
	public String getClientIp() {
		return this.clientIp;
	}
	
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public long getMemberId() {
		return this.memberId;
	}
	
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	
	public String getPComment() {
		return this.PComment;
	}
	
	public void setPComment(String pComment) {
		PComment = pComment;
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}
}
