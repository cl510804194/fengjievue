package com.yjf.esupplier.web.controller.front.platform;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import rop.thirdparty.com.google.common.collect.Lists;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.service.product.DeliveryService;
import com.yjf.esupplier.service.product.ShopCartService;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.controller.front.platform.bean.Cart;
import com.yjf.esupplier.web.util.WebSessionUtil;
import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.product.enums.ShopingCartTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ShopCartInfo;
import com.yjf.esupplier.ws.product.order.ShopCartItemOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

public class ShoppingCartBaseController extends FrontAutowiredBaseController {
	@Autowired
	protected DeliveryService deliveryService;
	@Autowired
	protected ShopCartService shopCartService;
	
	protected void initShopCart(UserInfo userInfo) {
		initShopCart(userInfo, ShopingCartTypeEnum.O2O);
	}

	protected void initShopCart(UserInfo userInfo, ShopingCartTypeEnum shopingCartType) {
		QueryBaseBatchResult<ShopCartInfo> batchResult = shopCartService.getShopCartList(
			userInfo.getUserId(), shopingCartType.code());
		List<CartItemInfo> addNewCardItemList = Lists.newArrayList();
		Cart cart = null;
		if (ShopingCartTypeEnum.ORDER_MEAL == shopingCartType) {
			cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		} else {
			cart = WebSessionUtil.getStaticCurrentCart();
		}
		if (cart.getCount() > 0) {
			Map<Long, List<CartItemInfo>> cartItemMap = cart.getValue();
			Iterator<Entry<Long, List<CartItemInfo>>> iterator = cartItemMap.entrySet().iterator();
			
			while (iterator.hasNext()) {
				Entry<Long, List<CartItemInfo>> entry = iterator.next();
				for (CartItemInfo cartItemInfo : entry.getValue()) {
					boolean isExist = false;
					for (ShopCartInfo shopCartInfo : batchResult.getPageList()) {
						if (cartItemInfo.getProductId() == shopCartInfo.getProductId()) {
							isExist = true;
							ShopCartItemOrder cartItemOrder = new ShopCartItemOrder();
							cartItemOrder.setProductId(shopCartInfo.getProductId());
							cartItemOrder.setUserId(shopCartInfo.getUserId());
							cartItemOrder.setQuantity(cartItemInfo.getQuantity());
							cartItemOrder.setPicPath(cartItemInfo.getImage());
							cartItemOrder.setProductName(shopCartInfo.getProductName());
							cartItemOrder.setPrice(cartItemInfo.getPrice());
							cartItemOrder.setTotalPrice(cartItemOrder.getPrice().multiply(
								cartItemOrder.getQuantity()));
							cartItemOrder.setSupplierId(shopCartInfo.getSupplierId());
							cartItemOrder.setSupplierName(shopCartInfo.getSupplierName());
							cartItemOrder.setUserName(userInfo.getUserName());
							cartItemOrder.setUserNikename(userInfo.getNickname());
							cartItemOrder.setProductUnit(shopCartInfo.getProductUnit());
							cartItemOrder.setSaleType(cart.getShopingCartType().code());
							shopCartService.updateShopCartItem(cartItemOrder);
						}
					}
					if (!isExist) {
						addNewCardItemList.add(cartItemInfo);
					}
				}
			}
			
			for (CartItemInfo cartItemInfo : addNewCardItemList) {
				ProductInfo productInfo = productService.findProductById(cartItemInfo
					.getProductId());
				ShopCartItemOrder cartItemOrder = new ShopCartItemOrder();
				cartItemOrder.setPicPath(productInfo.getSmallPicPath());
				cartItemOrder.setProductId(productInfo.getProductId());
				cartItemOrder.setProductName(productInfo.getProductName());
				cartItemOrder.setQuantity(cartItemInfo.getQuantity());
				cartItemOrder.setPrice(cartItemInfo.getPrice());
				cartItemOrder.setTotalPrice(cartItemOrder.getPrice().multiply(
					cartItemOrder.getQuantity()));
				cartItemOrder.setSupplierId(productInfo.getSupplierId());
				cartItemOrder.setSupplierName(productInfo.getSupplierName());
				cartItemOrder.setUserId(userInfo.getUserId());
				cartItemOrder.setUserName(userInfo.getUserName());
				cartItemOrder.setUserNikename(userInfo.getNickname());
				cartItemOrder.setProductUnit(productInfo.getProductUnit());
				cartItemOrder.setSaleType(cart.getShopingCartType().code());
				shopCartService.addShopCartItem(cartItemOrder);
			}
			
		}
		for (ShopCartInfo shopCartInfo : batchResult.getPageList()) {
			if (StringUtil.equals("1", shopCartInfo.getIsDelete()))
				continue;
			CartItemInfo item = new CartItemInfo(shopCartInfo.getProductId(),
				shopCartInfo.getSupplierId(), (int) shopCartInfo.getQuantity());
			item.setName(shopCartInfo.getProductName());
			item.setPrice(shopCartInfo.getPrice());
			item.setImage(shopCartInfo.getPicPath());
			item.setSupplierName(shopCartInfo.getSupplierName());
			item.setUnit(shopCartInfo.getProductUnit());
			ProductInfo productInfo = productService.findProductById(shopCartInfo.getProductId());
			if (productInfo.getPostType() != null)
				item.setPostType(productInfo.getPostType().getDbValue());
			else
				item.setPostType(0);
			/*邮费单独计算*/
			item.setDeliveryInfo(null);
			cart.addCartItemInfo(item);
		}
	}
}
