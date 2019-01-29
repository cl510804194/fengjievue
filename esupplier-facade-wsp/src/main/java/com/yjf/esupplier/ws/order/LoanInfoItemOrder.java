package com.yjf.esupplier.ws.order;


import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LoanInfoItemOrder implements Serializable {
	
	private static final long serialVersionUID = -4282603875229233564L;

    //========== properties ==========

	private long demandInfoItemId;

	private String infoName;

	private int sortNo;

	private String infoType;

	private String status;

	private String note;

	private Date rawAddTime;

	private Date rawUpdateTime;

    //========== getters and setters ==========

	public long getDemandInfoItemId() {
		return demandInfoItemId;
	}
	
	public void setDemandInfoItemId(long demandInfoItemId) {
		this.demandInfoItemId = demandInfoItemId;
	}

	public String getInfoName() {
		return infoName;
	}
	
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public int getSortNo() {
		return sortNo;
	}
	
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public String getInfoType() {
		return infoType;
	}
	
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
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
