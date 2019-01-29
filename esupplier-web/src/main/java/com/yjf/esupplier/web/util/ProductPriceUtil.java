package com.yjf.esupplier.web.util;

import com.yjf.esupplier.ws.product.info.ProductBeanInfo;
import com.yjf.esupplier.ws.product.info.ProductInfo;

public class ProductPriceUtil {
	
	public static String getPrice(ProductInfo productInfo) {
		if (productInfo.getPrice1() == null || productInfo.getPrice1().getCent() == 0) {
			return "<font color=green>面议</font>" + "/" + productInfo.getProductUnit();
		} else {
			return "￥" + productInfo.getPrice1().toStandardString() + "元/"
					+ productInfo.getProductUnit();
		}
	}
	
	public static String getMarketPrice(ProductBeanInfo productInfo) {
		String strValue = "";
		if (productInfo.getMarketPrice() == null || productInfo.getMarketPrice().getCent() == 0) {
			if (productInfo.getProduct().getPrice1() == null
				|| productInfo.getProduct().getPrice1().getCent() == 0) {
				strValue = "<font color=green>面议</font>";
			} else {
				strValue = "￥"
							+ productInfo.getProduct().getPrice1().multiply(1.1).toStandardString();
			}
		} else {
			strValue = "￥" + productInfo.getProduct().getMarketPrice().toStandardString();
		}
		
		return strValue + "/" + productInfo.getProductUnit();
	}
}
