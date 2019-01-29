package com.yjf.esupplier.ws.storage.order;

import com.yjf.common.lang.util.money.Money;

public class AddHotelsStockOrder extends HotelsStockBaseOrder {
	
	private static final long serialVersionUID = 9170332745766649476L;
	/**
	 * 标准价格
	 */
	private Money productPrice = Money.zero();
	/**
	 * 库存
	 */
	private long inStock;
	
	@Override
	public void check() {
		validateMoneyGreaterThanZero(productPrice, "产品价格");
		validateHasZore(inStock, "房间数量");
	}
	
	public Money getProductPrice() {
		return this.productPrice;
	}
	
	public void setProductPrice(Money productPrice) {
		this.productPrice = productPrice;
	}
	
	public long getInStock() {
		return this.inStock;
	}
	
	public void setInStock(long inStock) {
		this.inStock = inStock;
	}
	
}
