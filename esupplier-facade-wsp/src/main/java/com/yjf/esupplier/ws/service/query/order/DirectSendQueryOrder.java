package com.yjf.esupplier.ws.service.query.order;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class DirectSendQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = 4637443397492729265L;
	
	private long directSendId;
	private String content;
	private String directType;
	private String sendType;
	private String startDate;
	private String endDate;
	private String status;
	
	public long getDirectSendId() {
		return directSendId;
	}
	
	public void setDirectSendId(long directSendId) {
		this.directSendId = directSendId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDirectType() {
		return directType;
	}
	
	public void setDirectType(String directType) {
		this.directType = directType;
	}
	
	public String getSendType() {
		return sendType;
	}
	
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
