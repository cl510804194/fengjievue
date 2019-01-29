package com.yjf.esupplier.web.controller.front.platform;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.service.product.DeliveryService;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.controller.front.platform.bean.Cart;
import com.yjf.esupplier.web.util.WebSessionUtil;
import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.result.ShopingCartResult;
import com.yjf.esupplier.ws.storage.info.ProductStorageInfo;

@Controller
@RequestMapping("/front")
public class ShoppingCartController extends FrontAutowiredBaseController {
	
	@Autowired
	DeliveryService deliveryService;
	
	/**
	 * 向购物车中添加商品信息 2010-2-23
	 * @author yuwenqiang
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("platform/mall/shoppingCart/toShoppingCart.htm")
	public String saveShoppingCartInfo(HttpServletRequest request, HttpServletResponse response,
										Model model, long productId, long count) {
		JSONObject jsonObject = new JSONObject();
		//查询产品的信息
		ProductInfo productInfo = productService.findProductById(productId);
		long supplierId = productInfo.getSupplierId();
		UserInfo supplierInfo = userQueryService.queryByUserId(supplierId).getQueryUserInfo();
		if(supplierInfo==null){
			jsonObject.put("isSuccess", false);
			jsonObject.put("message", "对不起，商品的供应商已不存在！");
			printHttpResponse(response, jsonObject);
			return null;
		}
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		CartItemInfo item = new CartItemInfo(productId, supplierId, (int) count);
		item.setName(productInfo.getProductName());
		item.setPrice(productInfo.getPrice1());
		item.setImage(productInfo.getSmallPicPath());
		item.setSupplierName(supplierInfo.getRealName());
		item.setUnit(productInfo.getProductUnit());
		item.setPriceOriginal(productInfo.getMarketPrice());
		if (productInfo.getPostType() != null)
			item.setPostType(productInfo.getPostType().getDbValue());
		else
			item.setPostType(0);
		/*邮费单独计算*/
		item.setDeliveryInfo(null);
		ProductStorageInfo productStorageInfo = storageService.getStorageInfo(productInfo
			.getProductId());
		long addAfterQuantity = cart.preAddCartItemQuantity(item);
		if (addAfterQuantity > productStorageInfo.getStockAmount()
								- productStorageInfo.getPayedCount()) {
			jsonObject.put("isSuccess", false);
			jsonObject.put("message", "库存不足，不能增加购买数量");
			printHttpResponse(response, jsonObject);
			return null;
		}
		ShopingCartResult cartResult = cart.addCartItemInfo(item);
		persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
		//将新的信息放入session之中去
		if (cartResult.isSuccess()) {
			jsonObject.put("isSuccess", true);
		} else {
			jsonObject.put("isSuccess", false);
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	@RequestMapping("/platform/mall/shoppingCart/listCart.htm")
	public String listCart(HttpServletRequest request, HttpServletResponse response, Model model) {
		JSONObject jsonObject = new JSONObject();
		//查询产品的信息
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		
		//将新的信息放入session之中去
		jsonObject.put("isSuccess", true);
		printHttpResponse(response, cart.toJson());
		return null;
	}
	
	@RequestMapping("/platform/mall/shoppingCart/setQuantity.htm")
	public String setQuantity(HttpServletRequest request, HttpServletResponse response,
							  Long productId, int count, Model model) {
		JSONObject jsonObject = new JSONObject();
		//查询产品的信息
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		ProductInfo productInfo = productService.findProductById(productId);
		long supplierId = productInfo.getSupplierId();
		ProductStorageInfo productStorageInfo = storageService.getStorageInfo(productInfo
				.getProductId());
		if (count > productStorageInfo.getStockAmount() - productStorageInfo.getPayedCount()) {
			jsonObject.put("isSuccess", false);
			jsonObject.put("message", "库存不足，不能增加购买数量");
			printHttpResponse(response, jsonObject);
			return null;
		}

		ShopingCartResult cartResult = cart.setQuantity(supplierId, productId, count);
		persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
		if (cartResult.isSuccess()) {

			jsonObject.put("isSuccess", true);
		} else {
			jsonObject.put("isSuccess", false);
		}
		//将新的信息放入session之中去
		jsonObject.put("isSuccess", true);
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	/**
	 * 是否可以更改数量到指定的值
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/platform/mall/shoppingCart/canSetQuantity.htm")
	public String canSetQuantity(HttpServletRequest request, HttpServletResponse response,
									Model model, long productId, int count) {
		boolean ret = true; // 是否可订购
		JSONObject jsonObject = new JSONObject();
		ProductStorageInfo pro = storageService.getStorageInfo(productId);
		if (count == 0) {
			jsonObject.put("result", true);
			jsonObject.put("min", 1);
			jsonObject.put("max", pro.getStockAmount() - pro.getPayedCount());
		} else if (count > pro.getStockAmount() - pro.getPayedCount() && count > 0) {
			jsonObject.put("result", false);
			jsonObject.put("min", 1);
			jsonObject.put("max", pro.getStockAmount() - pro.getPayedCount());
		} else if (count > 0) {
			jsonObject.put("result", true);
			jsonObject.put("min", 1);
			jsonObject.put("max", pro.getStockAmount() - pro.getPayedCount());
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
}
