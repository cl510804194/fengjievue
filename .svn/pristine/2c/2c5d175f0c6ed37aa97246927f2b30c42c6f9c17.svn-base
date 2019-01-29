package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class ConfirmReceiptRefundGoodsOrder extends ProcessOrder {
	
	private static final long serialVersionUID = -9179807098158877215L;
	BooleanEnum isAddStock = BooleanEnum.NO;
	long addStockQuantity;
	
	@Override
	public void check() {
		validateNotNull(isAddStock, "是否增加库存");
		if (isAddStock == BooleanEnum.YES) {
			validateGreaterThan(addStockQuantity, "库存增加量");
		}
		
	}
	
	public BooleanEnum getIsAddStock() {
		return this.isAddStock;
	}
	
	public void setIsAddStock(BooleanEnum isAddStock) {
		this.isAddStock = isAddStock;
	}
	
	public long getAddStockQuantity() {
		return this.addStockQuantity;
	}
	
	public void setAddStockQuantity(long addStockQuantity) {
		this.addStockQuantity = addStockQuantity;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfirmReceiptRefundGoodsOrder [isAddStock=");
		builder.append(isAddStock);
		builder.append(", addStockQuantity=");
		builder.append(addStockQuantity);
		builder.append("]");
		return builder.toString();
	}
	
}
