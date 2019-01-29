package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.order.ProcessOrder;

/**
 * 退货处理订单
 * 
 * 
 * @author qch
 * 
 */
public class RefundGoodsProcessOrder extends ProcessOrder {
	
	private static final long serialVersionUID = 4218689497345518618L;
	private String logisticsCompanies;
	
	private String logisticsNo;
	
	@Override
	public void check() {
		super.check();
		validateHasText(logisticsCompanies, "退款");
		validateHasText(logisticsNo, "退货");
	}
	
	public String getLogisticsCompanies() {
		return this.logisticsCompanies;
	}
	
	public void setLogisticsCompanies(String logisticsCompanies) {
		this.logisticsCompanies = logisticsCompanies;
	}
	
	public String getLogisticsNo() {
		return this.logisticsNo;
	}
	
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundGoodsPorocessOrder [logisticsCompanies=");
		builder.append(logisticsCompanies);
		builder.append(", logisticsNo=");
		builder.append(logisticsNo);
		builder.append("]");
		return builder.toString();
	}
	
}
