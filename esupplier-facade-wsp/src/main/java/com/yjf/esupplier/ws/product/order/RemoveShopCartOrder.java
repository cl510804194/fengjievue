package com.yjf.esupplier.ws.product.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.product.enums.ShopingCartTypeEnum;

public class RemoveShopCartOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 1L;
	private long productId;
	private long userId;
	private ShopingCartTypeEnum saleType;
	@Override
	public void check() {
		validateHasZore(userId, "用户id");
		validateHasZore(productId, "产品id");
		validateNotNull(saleType, "购物车类型");
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public ShopingCartTypeEnum getSaleType() {
		return saleType;
	}
	
	public void setSaleType(ShopingCartTypeEnum saleType) {
		this.saleType = saleType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RemoveShopCartOrder [productId=");
		builder.append(productId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", saleType=");
		builder.append(saleType);
		builder.append("]");
		return builder.toString();
	}

	
}
