package com.yjf.esupplier.integration.industrial.api.result;

import java.util.List;

import com.yjf.esupplier.integration.industrial.api.info.LogisticsFlowInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class LogisticsInfoResult extends EsupplierBaseResult {
	private static final long serialVersionUID = 6009377082426474414L;
	String trackingNumber;
	List<LogisticsFlowInfo> flowInfos;
	
	public String getTrackingNumber() {
		return this.trackingNumber;
	}
	
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	public List<LogisticsFlowInfo> getFlowInfos() {
		return this.flowInfos;
	}
	
	public void setFlowInfos(List<LogisticsFlowInfo> flowInfos) {
		this.flowInfos = flowInfos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogisticsInfoResult [trackingNumber=");
		builder.append(trackingNumber);
		builder.append(", flowInfos=");
		builder.append(flowInfos);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
