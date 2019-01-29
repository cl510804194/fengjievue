package com.yjf.esupplier.ws.order;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LoanDemandItemDetailOrder implements Serializable {
	private static final long serialVersionUID = -4282603875229233564L;

    //========== properties ==========

	private long demandItemDetailId;

	private long demandInfoItemId;

	private long demandId;
	
	private String[] selItemIds;

    //========== getters and setters ==========

	public long getDemandItemDetailId() {
		return demandItemDetailId;
	}
	
	public String[] getSelItemIds() {
		return selItemIds;
	}

	public void setSelItemIds(String[] selItemIds) {
		this.selItemIds = selItemIds;
	}

	public void setDemandItemDetailId(long demandItemDetailId) {
		this.demandItemDetailId = demandItemDetailId;
	}

	public long getDemandInfoItemId() {
		return demandInfoItemId;
	}
	
	public void setDemandInfoItemId(long demandInfoItemId) {
		this.demandInfoItemId = demandInfoItemId;
	}

	public long getDemandId() {
		return demandId;
	}
	
	public void setDemandId(long demandId) {
		this.demandId = demandId;
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
