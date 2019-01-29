package com.yjf.esupplier.web.util;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.web.controller.front.platform.bean.Cart;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.product.enums.ShopingCartTypeEnum;

public class WebSessionUtil {
	public static String SHOP_CART_KEY = "shopCart";
	public static String ORDER_MEAL_SHOP_CART_KEY = "orderMealShopCart";
	private final SessionLocal sessionLocal;
	Cart cart = null;
	//点餐购物车
	Cart orderMealCart = null;
	public WebSessionUtil(SessionLocal sessionLocal) {
		this.sessionLocal = sessionLocal;
		cart = getStaticCurrentCart();
		orderMealCart = getStaticCurrentOrderMealCart();
	}
	
	public boolean isLogin() {
		return sessionLocal != null && StringUtil.isNotBlank(sessionLocal.getUserName());
	}
	
	public String getUserViewName() {
		
		if (sessionLocal != null) {
			if (StringUtil.isNotBlank(sessionLocal.getRealName())) {
				return sessionLocal.getRealName();
			} else {
				return sessionLocal.getUserName();
			}
		}
		return "";
	}
	
	public boolean isEnterprise() {
		
		if (sessionLocal != null) {
			return sessionLocal.getUserTypeEnum() == UserTypeEnum.JG;
		}
		return false;
	}
	
	public static SessionLocal getCurrentSessionLocal() {
		return ShiroSessionUtils.getSessionLocal();
	}
	
	public Cart getCurrentCart() {
		return cart;
	}
	
	public static Cart getStaticCurrentCart() {
		Cart cart = null;
		cart = (Cart) ShiroSessionUtils.getSessionValue(SHOP_CART_KEY);
		if (cart == null) {
			cart = new Cart(ShopingCartTypeEnum.O2O);
			ShiroSessionUtils.setSessionValue(SHOP_CART_KEY, cart);
		}
		return cart;
	}
	
	public Cart getCurrentOrderMealCart() {
		return orderMealCart;
	}
	/**
	 * 获取点餐购物车
	 * @return
	 */
	public static Cart getStaticCurrentOrderMealCart() {
		Cart cart = null;
		cart = (Cart) ShiroSessionUtils.getSessionValue(ORDER_MEAL_SHOP_CART_KEY);
		if (cart == null) {
			cart = new Cart(ShopingCartTypeEnum.ORDER_MEAL);
			ShiroSessionUtils.setSessionValue(ORDER_MEAL_SHOP_CART_KEY, cart);
		}
		return cart;
	}
}
