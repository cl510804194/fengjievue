package com.yjf.esupplier.ws.product.info;

import java.io.Serializable;

import com.yjf.common.lang.util.money.Money;

/**
 * 前台页面商品展示使用的属性信息
 * @author yuwenqiang 2010-2-26
 */
public class ProductBeanInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/** 公司名字 */
	private String supName;
	/** 公司ID */
	private String supId;
	/** 产品 */
	private ProductInfo product;
	
	private String area;
	private int customerType;
	
	private String productUnit = ""; //liujunwei 2010-10-23 added
	private Money marketPrice; //liujunwei 2011-01-08 added

	private String province;
	private String city;
	private String groupBuyDetail;
	
	/**
	 * @return the productUnit
	 */
	public String getProductUnit() {
		return productUnit;
	}
	
	/**
	 * @param productUnit the productUnit to set
	 */
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	
	public ProductInfo getProduct() {
		return product;
	}
	
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public int getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	
	public String getSupName() {
		return supName;
	}
	
	public void setSupName(String supName) {
		this.supName = supName;
	}
	
	public String getSupId() {
		return supId;
	}
	
	public void setSupId(String supId) {
		this.supId = supId;
	}
	
	/**
	 * @return the marketPrice
	 */
	public Money getMarketPrice() {
		return marketPrice;
	}
	
	/**
	 * @param marketPrice the marketPrice to set
	 */
	public void setMarketPrice(Money marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGroupBuyDetail() {
		return groupBuyDetail;
	}

	public void setGroupBuyDetail(String groupBuyDetail) {
		this.groupBuyDetail = groupBuyDetail;
	}
	
}
