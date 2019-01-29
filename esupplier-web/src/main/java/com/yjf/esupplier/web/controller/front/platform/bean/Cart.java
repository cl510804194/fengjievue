package com.yjf.esupplier.web.controller.front.platform.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.google.common.collect.Lists;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.product.enums.ShopingCartResultEnum;
import com.yjf.esupplier.ws.product.enums.ShopingCartTypeEnum;
import com.yjf.esupplier.ws.product.result.ShopingCartResult;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// 购物车总集合
	private final Map<Long, List<CartItemInfo>> list = new HashMap<Long, List<CartItemInfo>>();
	int count = 0;
	Money totalPrice = new Money(0);
	Money selectTotalAmount = new Money(0);
	//购物车类型 
	private ShopingCartTypeEnum shopingCartType;
	
	//点餐地址
	private long diningAddressId;

	public Cart(ShopingCartTypeEnum shopingCartType) {
		this.shopingCartType = shopingCartType;
	}
	/**
	 * 清空购物车
	 */
	public void clear() {
		list.clear();
		count = 0;
		totalPrice = new Money(0);
		selectTotalAmount = new Money(0);
	}
	
	/**
	 * 计算验证预添加数据数量合计
	 * @param cartItemInfo
	 * @return
	 */
	public long preAddCartItemQuantity(CartItemInfo cartItemInfo) {
		List<CartItemInfo> cartItemInfos = list.get(cartItemInfo.getSupplierId());
		if (cartItemInfos == null) {
			return cartItemInfo.getQuantity();
		}
		if (ListUtil.isNotEmpty(cartItemInfos)) {
			for (CartItemInfo itemInfo : cartItemInfos) {
				if (itemInfo.getProductId().equals(cartItemInfo.getProductId())
					&& StringUtil.equals(cartItemInfo.getAllDimensions(),
						itemInfo.getAllDimensions())) {
					return itemInfo.getQuantity() + cartItemInfo.getQuantity();
					
				}
			}
		}
		return cartItemInfo.getQuantity();
	}
	
	public ShopingCartResult addCartItemInfo(CartItemInfo cartItemInfo) {
		
		ShopingCartResult cartResult = new ShopingCartResult();
		if (count > 100)
			return cartResult;
		totalPrice.addTo(cartItemInfo.getTotalAmountNoShipment());
		List<CartItemInfo> cartItemInfos = list.get(cartItemInfo.getSupplierId());
		if (cartItemInfos == null) {
			synchronized (list) {
				cartItemInfos = Lists.newArrayList();
				list.put(cartItemInfo.getSupplierId(), cartItemInfos);
			}
			
		}
		if (ListUtil.isNotEmpty(cartItemInfos)) {
			synchronized (cartItemInfos) {
				boolean isAdd = false;
				for (CartItemInfo itemInfo : cartItemInfos) {
					if (itemInfo.getProductId().equals(cartItemInfo.getProductId())
						&& StringUtil.equals(cartItemInfo.getAllDimensions(),
							itemInfo.getAllDimensions())) {
						long quantity = itemInfo.getQuantity() + cartItemInfo.getQuantity();
						itemInfo.setQuantity(quantity);
						cartItemInfo.setQuantity(quantity);
						cartResult.setShopingCartResultEnum(ShopingCartResultEnum.UPDTAE);
						isAdd = true;
						break;
					}
				}
				if (!isAdd) {
					cartResult.setShopingCartResultEnum(ShopingCartResultEnum.ADD);
					count++;
					cartItemInfos.add(cartItemInfo);
				}
			}
		} else {
			synchronized (cartItemInfos) {
				cartItemInfos.add(cartItemInfo);
				count++;
			}
			cartResult.setShopingCartResultEnum(ShopingCartResultEnum.ADD);
		}
		cartResult.setCartItemInfo(cartItemInfo);
		cartResult.setSuccess(true);
		return cartResult;
	}
	
	public ShopingCartResult setQuantity(Long supplierId, Long productId, int quantity) {
		ShopingCartResult cartResult = new ShopingCartResult();
		List<CartItemInfo> cartItemInfos = list.get(supplierId);
		if (quantity <= 0) {
			quantity = 0;
			if (quantity == 0) {
				for (int i = cartItemInfos.size() - 1; i >= 0; i--) {
					if (cartItemInfos.get(i).getProductId().longValue() == productId.doubleValue()) {
						CartItemInfo cartItemInfo = cartItemInfos.remove(i);
						cartResult.setCartItemInfo(cartItemInfo);
						cartResult.setShopingCartResultEnum(ShopingCartResultEnum.DELETE);
						cartResult.setSuccess(true);
						totalPrice.subtractFrom(cartItemInfo.getTotalAmountNoShipment());
					}
				}
				//要是一个供应商下面没有了商品就要将该供应商也要从session中移除
				if (cartItemInfos.size() == 0) {
					list.remove(supplierId);
				}
				count--;
			}
			return cartResult;
		}
		
		// 取得已有的个别供应商项目的集合
		
		if (ListUtil.isNotEmpty(cartItemInfos)) {
			synchronized (cartItemInfos) {
				boolean isAdd = false;
				for (CartItemInfo itemInfo : cartItemInfos) {
					if (itemInfo.getProductId().equals(productId)) {
						totalPrice.subtractFrom(itemInfo.getTotalAmountNoShipment());
						itemInfo.setQuantity(quantity);
						cartResult.setCartItemInfo(itemInfo);
						cartResult.setShopingCartResultEnum(ShopingCartResultEnum.UPDTAE);
						cartResult.setSuccess(true);
						totalPrice.addTo(itemInfo.getTotalAmountNoShipment());
						isAdd = true;
						break;
					}
				}
			}
		}
		return cartResult;
	}
	
	public ShopingCartResult removeCartItemInfo(CartItemInfo cartItemInfo) {
		ShopingCartResult cartResult = new ShopingCartResult();
		List<CartItemInfo> cartItemInfos = list.get(cartItemInfo.getSupplierId());
		if (cartItemInfos == null) {
			cartResult.setSuccess(false);
			return cartResult;
		}
		if (ListUtil.isNotEmpty(cartItemInfos)) {
			synchronized (cartItemInfos) {
				synchronized (list) {
					boolean isRemove = false;
					int index = 0;
					for (CartItemInfo itemInfo : cartItemInfos) {
						if (itemInfo.getProductId().longValue() == cartItemInfo.getProductId()
							.longValue()
							&& StringUtil.equals(cartItemInfo.getAllDimensions(),
								itemInfo.getAllDimensions())) {
							itemInfo.setQuantity(itemInfo.getQuantity()
													- cartItemInfo.getQuantity());
							if (itemInfo.getQuantity() == 0) {
								isRemove = true;
								cartResult.setShopingCartResultEnum(ShopingCartResultEnum.DELETE);
								cartResult.setCartItemInfo(itemInfo);
							}
							break;
						}
						index++;
					}
					if (isRemove) {
						cartItemInfos.remove(index);
						count--;
					}
					if (cartItemInfos.isEmpty()) {
						list.remove(cartItemInfo.getSupplierId());
					}
					
				}
				
			}
		}
		totalPrice.subtractFrom(cartItemInfo.getTotalAmountNoShipment());
		cartResult.setSuccess(true);
		return cartResult;
	}
	
	public Money getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setTotalPrice(Money totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	  /**
     * 生成JSON格式的数据，供浏览器端显示
     * @return
     */
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        Iterator<Map.Entry<Long, List<CartItemInfo>>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, List<CartItemInfo>> entry = iterator.next();
            Map<String, Map> map = new HashMap<String, Map>();
            List<CartItemInfo> cartItemInfos = entry.getValue();
            for (CartItemInfo cartItemInfo : cartItemInfos) {
                Map<String, Object> cartItemInfoMap = MiscUtil.covertPoToMap(cartItemInfo);
                if(cartItemInfo.getIsBuy()!=null){
                    cartItemInfoMap.put("isBuy",cartItemInfo.getIsBuy().code());
                }
                cartItemInfoMap.remove("deliveryInfo");
                if (cartItemInfo.getDeliveryInfo() != null) {
                    cartItemInfoMap.put("deliveryInfo",
                            MiscUtil.covertPoToMap(cartItemInfo.getDeliveryInfo()));
                }
                map.put(String.valueOf(cartItemInfo.getProductId()), cartItemInfoMap);
            }
            jsonObject.put(String.valueOf(entry.getKey()), map);

        }
        return jsonObject;
    }
	
	/**
	 * 得到信息 2010-4-2
	 * @author yuwenqiang
	 * @return
	 */
	public Map<Long, List<CartItemInfo>> getValue() {
		Map<Long, List<CartItemInfo>> copyHashMap = new HashMap<Long, List<CartItemInfo>>();
		Iterator<Map.Entry<Long, List<CartItemInfo>>> iterator = list.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Long, List<CartItemInfo>> entry = iterator.next();
			List<CartItemInfo> cartItemInfos = entry.getValue();
			List<CartItemInfo> newItemInfos = Lists.newArrayList();
			MiscUtil.convertList(cartItemInfos, newItemInfos, CartItemInfo.class);
			copyHashMap.put(entry.getKey(), newItemInfos);
		}
		return list;
	}
	
	public long getCount() {
		return count;
	}
	
	public List<CartItem> getViewCartList() {
		List<CartItem> cartItems = Lists.newArrayList();
		Iterator<Map.Entry<Long, List<CartItemInfo>>> iterator = list.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Long, List<CartItemInfo>> entry = iterator.next();
			List<CartItemInfo> cartItemInfos = entry.getValue();
			List<CartItemInfo> newItemInfos = Lists.newArrayList();
			MiscUtil.convertList(cartItemInfos, newItemInfos, CartItemInfo.class);
			CartItem cartItem = new CartItem();
			cartItem.setItemInfos(newItemInfos);
			cartItem.setSupplierFullName(cartItemInfos.get(0).getSupplierName());
			cartItem.setSupplierId(entry.getKey());
			cartItems.add(cartItem);
			for (CartItemInfo cartItemInfo : cartItemInfos) {
				cartItem.setEveryPriceVal(cartItemInfo.getTotalAmount().add(
					cartItem.getEveryPriceVal()));
			}
		}
		return cartItems;
	}
	
	public List<CartItem> getViewCartList(Map<Long, List<CartItemInfo>> list) {
		List<CartItem> cartItems = Lists.newArrayList();
		selectTotalAmount = new Money(0);
		Iterator<Map.Entry<Long, List<CartItemInfo>>> iterator = list.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Long, List<CartItemInfo>> entry = iterator.next();
			List<CartItemInfo> cartItemInfos = entry.getValue();
			CartItem cartItem = new CartItem();
			List<CartItemInfo> newItemInfos = Lists.newArrayList();
			MiscUtil.convertList(cartItemInfos, newItemInfos, CartItemInfo.class);
			cartItem.setItemInfos(newItemInfos);
			cartItem.setSupplierFullName(cartItemInfos.get(0).getSupplierName());
			cartItem.setSupplierId(entry.getKey());
			cartItems.add(cartItem);
			for (CartItemInfo cartItemInfo : cartItemInfos) {
				cartItem.setEveryPriceVal(cartItemInfo.getTotalAmount().add(
					cartItem.getEveryPriceVal()));
				selectTotalAmount = selectTotalAmount.add(cartItemInfo.getTotalAmount());
				
			}
		}
		return cartItems;
	}
	
	public Money getSelectTotalAmount() {
		return this.selectTotalAmount;
	}
	
	public void setSelectTotalAmount(Money selectTotalAmount) {
		this.selectTotalAmount = selectTotalAmount;
	}
	
	public ShopingCartTypeEnum getShopingCartType() {
		return shopingCartType;
	}
	
	public void setShopingCartType(ShopingCartTypeEnum shopingCartType) {
		this.shopingCartType = shopingCartType;
	}

	public long getDiningAddressId() {
		return diningAddressId;
	}
	
	public void setDiningAddressId(long diningAddressId) {
		this.diningAddressId = diningAddressId;
	}

	public static final class CartItem {
		List<CartItemInfo> itemInfos;
		long supplierId;
		String supplierFullName;
		Money everyPriceVal = Money.zero();
		
		public List<CartItemInfo> getItemInfos() {
			return this.itemInfos;
		}
		
		public void setItemInfos(List<CartItemInfo> itemInfos) {
			this.itemInfos = itemInfos;
		}
		
		public long getSupplierId() {
			return this.supplierId;
		}
		
		public void setSupplierId(long supplierId) {
			this.supplierId = supplierId;
		}
		
		public String getSupplierFullName() {
			return this.supplierFullName;
		}
		
		public void setSupplierFullName(String supplierFullName) {
			this.supplierFullName = supplierFullName;
		}
		
		public Money getEveryPriceVal() {
			return this.everyPriceVal;
		}
		
		public void setEveryPriceVal(Money everyPriceVal) {
			this.everyPriceVal = everyPriceVal;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CartItem [itemInfos=");
			builder.append(itemInfos);
			builder.append(", supplierId=");
			builder.append(supplierId);
			builder.append(", supplierFullName=");
			builder.append(supplierFullName);
			builder.append(", everyPriceVal=");
			builder.append(everyPriceVal);
			builder.append("]");
			return builder.toString();
		}
		
	}
}