package com.yjf.esupplier.ws.lottery.result;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class DrawAwardResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = 3337353116260364736L;
	BooleanEnum isWinner;
	String winnerDesc;
	
	public BooleanEnum getIsWinner() {
		return this.isWinner;
	}
	
	public void setIsWinner(BooleanEnum isWinner) {
		this.isWinner = isWinner;
	}
	
	public String getWinnerDesc() {
		return this.winnerDesc;
	}
	
	public void setWinnerDesc(String winnerDesc) {
		this.winnerDesc = winnerDesc;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrawAwardResult [isWinner=");
		builder.append(isWinner);
		builder.append(", winnerDesc=");
		builder.append(winnerDesc);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
