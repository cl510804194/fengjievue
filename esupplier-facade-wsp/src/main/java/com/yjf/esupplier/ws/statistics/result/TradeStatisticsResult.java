package com.yjf.esupplier.ws.statistics.result;

import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.statistics.TradeStatisticsInfo;

public class TradeStatisticsResult<T> extends QueryBaseBatchResult<T> {
	
	private static final long serialVersionUID = 8399878627678437948L;
	TradeStatisticsInfo statisticsInfo;
	
	public TradeStatisticsInfo getStatisticsInfo() {
		return this.statisticsInfo;
	}
	
	public void setStatisticsInfo(TradeStatisticsInfo statisticsInfo) {
		this.statisticsInfo = statisticsInfo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeStatisticsResult [statisticsInfo=");
		builder.append(statisticsInfo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
