package com.yjf.esupplier.ws.integral.result;

import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

public class UserPointsDetailQueryResult<T> extends QueryBaseBatchResult<T> {
	
	private static final long serialVersionUID = -8286915572174869167L;
	long effectivePoint;
	long totalPoint;
	
	public long getEffectivePoint() {
		return this.effectivePoint;
	}
	
	public void setEffectivePoint(long effectivePoint) {
		this.effectivePoint = effectivePoint;
	}
	
	public long getTotalPoint() {
		return this.totalPoint;
	}
	
	public void setTotalPoint(long totalPoint) {
		this.totalPoint = totalPoint;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserPointsDetailQueryResult [effectivePoint=");
		builder.append(effectivePoint);
		builder.append(", totalPoint=");
		builder.append(totalPoint);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
