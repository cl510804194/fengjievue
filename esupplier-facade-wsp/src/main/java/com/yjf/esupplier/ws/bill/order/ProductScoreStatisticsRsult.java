package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class ProductScoreStatisticsRsult extends EsupplierBaseResult {
	private static final long serialVersionUID = -1003490311811954739L;
	private long score1Count;
	private long score2Count;
	private long score3Count;
	private long score4Count;
	private long score5Count;
	
	public long getScore1Count() {
		return this.score1Count;
	}
	
	public void setScore1Count(long score1Count) {
		this.score1Count = score1Count;
	}
	
	public long getScore2Count() {
		return this.score2Count;
	}
	
	public void setScore2Count(long score2Count) {
		this.score2Count = score2Count;
	}
	
	public long getScore3Count() {
		return this.score3Count;
	}
	
	public void setScore3Count(long score3Count) {
		this.score3Count = score3Count;
	}
	
	public long getScore4Count() {
		return this.score4Count;
	}
	
	public void setScore4Count(long score4Count) {
		this.score4Count = score4Count;
	}
	
	public long getScore5Count() {
		return this.score5Count;
	}
	
	public void setScore5Count(long score5Count) {
		this.score5Count = score5Count;
	}
	
	public long getTotalCount() {
		return this.score1Count + this.score2Count + this.score3Count + this.score4Count
				+ this.score5Count;
	}
	
	public long getGoodCount() {
		return  this.score5Count;
	}
	
	public long getMidCount() {
		return this.score4Count + this.score3Count;
	}
	
	public long getPoorCount() {
		return this.score1Count + this.score2Count;
	}
}
