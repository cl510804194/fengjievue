package com.yjf.esupplier.ws.product.result;

import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.product.enums.ShopingCartResultEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class ShopingCartResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -1657720725588412931L;
	ShopingCartResultEnum shopingCartResultEnum;
	CartItemInfo cartItemInfo;
	
	public ShopingCartResultEnum getShopingCartResultEnum() {
		return this.shopingCartResultEnum;
	}
	
	public void setShopingCartResultEnum(ShopingCartResultEnum shopingCartResultEnum) {
		this.shopingCartResultEnum = shopingCartResultEnum;
	}
	
	public CartItemInfo getCartItemInfo() {
		return this.cartItemInfo;
	}
	
	public void setCartItemInfo(CartItemInfo cartItemInfo) {
		this.cartItemInfo = cartItemInfo;
	}
	
}
