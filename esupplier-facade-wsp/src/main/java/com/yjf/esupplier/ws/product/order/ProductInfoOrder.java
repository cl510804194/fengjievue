package com.yjf.esupplier.ws.product.order;

import java.util.Date;

import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.product.enums.PostFeeTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.RefundRuleEnum;

public class ProductInfoOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -5736929542761119013L;
	private long productId;
	private long supplierId;
	private String supplierName;
	private String productName;
	private String productNumber;//产品的供应商自编号
	private ProductStatusEnum productStatus = ProductStatusEnum.ON;
	private String productUnit;
	private Money price1 = new Money(0, 0);
	private Money price2 = new Money(0, 0);
	private Money price3 = new Money(0, 0);
	private String price1Range;
	private String price2Range;
	private String price3Range;
	private String productType;
	private String productTypeName;
	/**
	 * 产品扩展类型：商品 门票等
	 */
	private ProductVaryEnum productVary;

	private String smallPicPath;
	private String bigPicPath;
	private String smallPicPath1;
	private String bigPicPath1;
	private String smallPicPath2;
	private String bigPicPath2;
	private String smallPicPath3;
	private String bigPicPath3;
	private String webOrder;//是否支持网上订购
	private long startOrderCount;//起订量
	private long wareCount;//库存量
	private long reservedCount = 0;//预订量
	private long saleCount = 0;//销售量
	private String productDetail;
	
	private String tradeType;//交易方式
	private String ipAddress;
	private PostFeeTypeEnum postType;//运费支付方式，0：卖家承担，1：联系卖家，2：买家承担
	private Money marketPrice;
	private String htmlPath;
	
	private String productStyle;
	
	private String productTheme;
	
	/**
	 * 产品自定义属性1
	 */
	private String productCusAdd1;
	/**
	 * 产品自定义属性2
	 */
	private String productCusAdd2;
	/**
	 * 产品自定义属性3
	 */
	private String productCusAdd3;
	/**
	 * 产品自定义属性4
	 */
	private String productCusAdd4;
	/**
	 * 产品自定义属性5
	 */
	private String productCusAdd5;
	/**
	 * 商品标签
	 */
	private String ptTag;
	
	/**
	 * 商品关键字
	 */
	private String ptKeyWords;
	
	/**
	 * 是否预约
	 */
	private String appointment;
	/**
	 * 退款规则
	 */
	private RefundRuleEnum facade;//
	/**
	 * 是否是o2o商品
	 */
	private BooleanEnum saleTypeO2o;
	/**
	 * 是否是b2c商品
	 */
	private BooleanEnum saleTypeB2c;
	
	/**
	 * 是否支持订餐
	 */
	private BooleanEnum saleTypeOrderMeal;
	/**
	 * 是否支持酒店预订
	 */
	private BooleanEnum saleTypeHotels;
	/**
	 * 批发说明||预约提示
	 */
	private String wholesaleDetail;//
	/**
	 * 运费说明||温馨提示
	 */
	private String transportDetail;//
	/**
	 * 团购开始时间(酒店执行日期)
	 */
	private Date groupPurchaseBeginTime;
	/**
	 * 团购结束时间(酒店执行日期)
	 */
	private Date groupPurchaseEndTime;

	/**
	 * 酒店预订执行开始时间
	 */
	protected Date execBeginTime;
	/**
	 * 酒店预订执行结束时间
	 */
	protected Date execEndTime;
	
	/**
	 * 团购描述||商品简介
	 */
	private String groupBuyDetail;
	/**
	 * 该商品获取积分倍数
	 */
	private int points;
	
	private BooleanEnum tuneMeal;

	/**
	 * 游客中心
	 */
	private long resortsBusinessId;
	/**
	 * 游客用户名
	 */
	private String resortsBusinessName;
	/**
	 * 游客真实名称
	 */
	private String resortsBusinessRealName;

	/*是否到店*/
	private BooleanEnum customType1;
	/*是否上门*/
	private BooleanEnum customType2;
	/*预留*/
	private String customType3;
	/*服务时长*/
	private String customValue1;
	/*预留*/
	private String customValue2;
	/*预留*/
	private String customValue3;

	@Override
	public void check() {
		validateHasZore(supplierId, "商户id");
		validateHasText(productName, "产品名称");
		validateNotNull(productVary, "产品支持分类");
		validateHasText(productNumber, "产品编号");
		validateHasText(productUnit, "产品单位");
		validateMoneyGreaterThanZero(price1, "产品价格");
		validateNotNull(postType, "运费支付方式");

	}

	public ProductVaryEnum getProductVary() {
		return productVary;
	}

	public void setProductVary(ProductVaryEnum productVary) {
		this.productVary = productVary;
	}

	public BooleanEnum getCustomType1() {
		return customType1;
	}

	public void setCustomType1(BooleanEnum customType1) {
		this.customType1 = customType1;
	}

	public BooleanEnum getCustomType2() {
		return customType2;
	}

	public void setCustomType2(BooleanEnum customType2) {
		this.customType2 = customType2;
	}

	public String getCustomType3() {
		return customType3;
	}

	public void setCustomType3(String customType3) {
		this.customType3 = customType3;
	}

	public String getCustomValue1() {
		return customValue1;
	}

	public void setCustomValue1(String customValue1) {
		this.customValue1 = customValue1;
	}

	public String getCustomValue2() {
		return customValue2;
	}

	public void setCustomValue2(String customValue2) {
		this.customValue2 = customValue2;
	}

	public String getCustomValue3() {
		return customValue3;
	}

	public void setCustomValue3(String customValue3) {
		this.customValue3 = customValue3;
	}

	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductNumber() {
		return this.productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public ProductStatusEnum getProductStatus() {
		return this.productStatus;
	}
	
	public void setProductStatus(ProductStatusEnum productStatus) {
		this.productStatus = productStatus;
	}
	
	public String getProductUnit() {
		return this.productUnit;
	}
	
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	
	public Money getPrice1() {
		return this.price1;
	}
	
	public void setPrice1(Money price1) {
		this.price1 = price1;
	}
	
	public Money getPrice2() {
		return this.price2;
	}
	
	public void setPrice2(Money price2) {
		this.price2 = price2;
	}
	
	public Money getPrice3() {
		return this.price3;
	}
	
	public void setPrice3(Money price3) {
		this.price3 = price3;
	}
	
	public String getPrice1Range() {
		return this.price1Range;
	}
	
	public void setPrice1Range(String price1Range) {
		this.price1Range = price1Range;
	}
	
	public String getPrice2Range() {
		return this.price2Range;
	}
	
	public void setPrice2Range(String price2Range) {
		this.price2Range = price2Range;
	}
	
	public String getPrice3Range() {
		return this.price3Range;
	}
	
	public void setPrice3Range(String price3Range) {
		this.price3Range = price3Range;
	}
	
	public String getProductType() {
		return this.productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getProductTypeName() {
		return this.productTypeName;
	}
	
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	
	public String getSmallPicPath() {
		return this.smallPicPath;
	}
	
	public void setSmallPicPath(String smallPicPath) {
		this.smallPicPath = smallPicPath;
	}
	
	public String getBigPicPath() {
		return this.bigPicPath;
	}
	
	public void setBigPicPath(String bigPicPath) {
		this.bigPicPath = bigPicPath;
	}
	
	public String getSmallPicPath1() {
		return this.smallPicPath1;
	}
	
	public void setSmallPicPath1(String smallPicPath1) {
		this.smallPicPath1 = smallPicPath1;
	}
	
	public String getBigPicPath1() {
		return this.bigPicPath1;
	}
	
	public void setBigPicPath1(String bigPicPath1) {
		this.bigPicPath1 = bigPicPath1;
	}
	
	public String getSmallPicPath2() {
		return this.smallPicPath2;
	}
	
	public void setSmallPicPath2(String smallPicPath2) {
		this.smallPicPath2 = smallPicPath2;
	}
	
	public String getBigPicPath2() {
		return this.bigPicPath2;
	}
	
	public void setBigPicPath2(String bigPicPath2) {
		this.bigPicPath2 = bigPicPath2;
	}
	
	public String getSmallPicPath3() {
		return this.smallPicPath3;
	}
	
	public void setSmallPicPath3(String smallPicPath3) {
		this.smallPicPath3 = smallPicPath3;
	}
	
	public String getBigPicPath3() {
		return this.bigPicPath3;
	}
	
	public void setBigPicPath3(String bigPicPath3) {
		this.bigPicPath3 = bigPicPath3;
	}
	
	public String getWebOrder() {
		return this.webOrder;
	}
	
	public void setWebOrder(String webOrder) {
		this.webOrder = webOrder;
	}
	
	public long getStartOrderCount() {
		return this.startOrderCount;
	}
	
	public void setStartOrderCount(long startOrderCount) {
		this.startOrderCount = startOrderCount;
	}
	
	public long getWareCount() {
		return this.wareCount;
	}
	
	public void setWareCount(long wareCount) {
		this.wareCount = wareCount;
	}
	
	public String getProductDetail() {
		return this.productDetail;
	}
	
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
	public String getWholesaleDetail() {
		return this.wholesaleDetail;
	}
	
	public void setWholesaleDetail(String wholesaleDetail) {
		this.wholesaleDetail = wholesaleDetail;
	}
	
	public String getTransportDetail() {
		return this.transportDetail;
	}
	
	public void setTransportDetail(String transportDetail) {
		this.transportDetail = transportDetail;
	}
	
	public String getTradeType() {
		return this.tradeType;
	}
	
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	
	public String getIpAddress() {
		return this.ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public PostFeeTypeEnum getPostType() {
		return this.postType;
	}
	
	public void setPostType(PostFeeTypeEnum postType) {
		this.postType = postType;
	}
	
	public Money getMarketPrice() {
		return this.marketPrice;
	}
	
	public void setMarketPrice(Money marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	public long getReservedCount() {
		return this.reservedCount;
	}
	
	public long getSaleCount() {
		return this.saleCount;
	}
	
	public String getHtmlPath() {
		return this.htmlPath;
	}
	
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	
	public String getProductStyle() {
		return productStyle;
	}
	
	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}
	
	public String getProductTheme() {
		return productTheme;
	}
	
	public void setProductTheme(String productTheme) {
		this.productTheme = productTheme;
	}
	
	public String getProductCusAdd1() {
		return productCusAdd1;
	}
	
	public void setProductCusAdd1(String productCusAdd1) {
		this.productCusAdd1 = productCusAdd1;
	}
	
	public String getProductCusAdd2() {
		return productCusAdd2;
	}
	
	public void setProductCusAdd2(String productCusAdd2) {
		this.productCusAdd2 = productCusAdd2;
	}
	
	public String getProductCusAdd3() {
		return productCusAdd3;
	}
	
	public void setProductCusAdd3(String productCusAdd3) {
		this.productCusAdd3 = productCusAdd3;
	}
	
	public String getProductCusAdd4() {
		return productCusAdd4;
	}
	
	public void setProductCusAdd4(String productCusAdd4) {
		this.productCusAdd4 = productCusAdd4;
	}
	
	public String getProductCusAdd5() {
		return productCusAdd5;
	}
	
	public void setProductCusAdd5(String productCusAdd5) {
		this.productCusAdd5 = productCusAdd5;
	}
	
	public void setReservedCount(long reservedCount) {
		this.reservedCount = reservedCount;
	}
	
	public void setSaleCount(long saleCount) {
		this.saleCount = saleCount;
	}
	
	public String getPtTag() {
		return ptTag;
	}
	
	public void setPtTag(String ptTag) {
		this.ptTag = ptTag;
	}
	
	public String getAppointment() {
		return appointment;
	}
	
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	
	public BooleanEnum getSaleTypeO2o() {
		return saleTypeO2o;
	}
	
	public void setSaleTypeO2o(BooleanEnum saleTypeO2o) {
		this.saleTypeO2o = saleTypeO2o;
	}
	
	public BooleanEnum getSaleTypeB2c() {
		return saleTypeB2c;
	}
	
	public void setSaleTypeB2c(BooleanEnum saleTypeB2c) {
		this.saleTypeB2c = saleTypeB2c;
	}
	
	public Date getGroupPurchaseBeginTime() {
		return groupPurchaseBeginTime;
	}
	
	public void setGroupPurchaseBeginTime(Date groupPurchaseBeginTime) {
		this.groupPurchaseBeginTime = groupPurchaseBeginTime;
	}
	
	public Date getGroupPurchaseEndTime() {
		return groupPurchaseEndTime;
	}
	
	public void setGroupPurchaseEndTime(Date groupPurchaseEndTime) {
		this.groupPurchaseEndTime = groupPurchaseEndTime;
	}
	
	public RefundRuleEnum getFacade() {
		return facade;
	}
	
	public void setFacade(RefundRuleEnum facade) {
		this.facade = facade;
	}
	
	public String getGroupBuyDetail() {
		return groupBuyDetail;
	}
	
	public void setGroupBuyDetail(String groupBuyDetail) {
		this.groupBuyDetail = groupBuyDetail;
	}
	
	public String getPtKeyWords() {
		return ptKeyWords;
	}
	
	public void setPtKeyWords(String ptKeyWords) {
		this.ptKeyWords = ptKeyWords;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public BooleanEnum getSaleTypeOrderMeal() {
		return saleTypeOrderMeal;
	}
	
	public void setSaleTypeOrderMeal(BooleanEnum saleTypeOrderMeal) {
		this.saleTypeOrderMeal = saleTypeOrderMeal;
	}
	
	public BooleanEnum getSaleTypeHotels() {
		return saleTypeHotels;
	}
	
	public void setSaleTypeHotels(BooleanEnum saleTypeHotels) {
		this.saleTypeHotels = saleTypeHotels;
	}
	
	public BooleanEnum getTuneMeal() {
		return tuneMeal;
	}
	
	public void setTuneMeal(BooleanEnum tuneMeal) {
		this.tuneMeal = tuneMeal;
	}

	public long getResortsBusinessId() {
		return resortsBusinessId;
	}

	public void setResortsBusinessId(long resortsBusinessId) {
		this.resortsBusinessId = resortsBusinessId;
	}

	public String getResortsBusinessName() {
		return resortsBusinessName;
	}

	public void setResortsBusinessName(String resortsBusinessName) {
		this.resortsBusinessName = resortsBusinessName;
	}

	public String getResortsBusinessRealName() {
		return resortsBusinessRealName;
	}

	public void setResortsBusinessRealName(String resortsBusinessRealName) {
		this.resortsBusinessRealName = resortsBusinessRealName;
	}

	public Date getExecBeginTime() {
		return execBeginTime;
	}

	public void setExecBeginTime(Date execBeginTime) {
		this.execBeginTime = execBeginTime;
	}

	public Date getExecEndTime() {
		return execEndTime;
	}

	public void setExecEndTime(Date execEndTime) {
		this.execEndTime = execEndTime;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ProductInfoOrder{");
		sb.append("productId=").append(productId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", productName='").append(productName).append('\'');
		sb.append(", productNumber='").append(productNumber).append('\'');
		sb.append(", productStatus=").append(productStatus);
		sb.append(", productUnit='").append(productUnit).append('\'');
		sb.append(", price1=").append(price1);
		sb.append(", price2=").append(price2);
		sb.append(", price3=").append(price3);
		sb.append(", price1Range='").append(price1Range).append('\'');
		sb.append(", price2Range='").append(price2Range).append('\'');
		sb.append(", price3Range='").append(price3Range).append('\'');
		sb.append(", productType='").append(productType).append('\'');
		sb.append(", productTypeName='").append(productTypeName).append('\'');
		sb.append(", productVary='").append(productVary).append('\'');
		sb.append(", smallPicPath='").append(smallPicPath).append('\'');
		sb.append(", bigPicPath='").append(bigPicPath).append('\'');
		sb.append(", smallPicPath1='").append(smallPicPath1).append('\'');
		sb.append(", bigPicPath1='").append(bigPicPath1).append('\'');
		sb.append(", smallPicPath2='").append(smallPicPath2).append('\'');
		sb.append(", bigPicPath2='").append(bigPicPath2).append('\'');
		sb.append(", smallPicPath3='").append(smallPicPath3).append('\'');
		sb.append(", bigPicPath3='").append(bigPicPath3).append('\'');
		sb.append(", webOrder='").append(webOrder).append('\'');
		sb.append(", startOrderCount=").append(startOrderCount);
		sb.append(", wareCount=").append(wareCount);
		sb.append(", reservedCount=").append(reservedCount);
		sb.append(", saleCount=").append(saleCount);
		sb.append(", productDetail='").append(productDetail).append('\'');
		sb.append(", tradeType='").append(tradeType).append('\'');
		sb.append(", ipAddress='").append(ipAddress).append('\'');
		sb.append(", postType=").append(postType);
		sb.append(", marketPrice=").append(marketPrice);
		sb.append(", htmlPath='").append(htmlPath).append('\'');
		sb.append(", productStyle='").append(productStyle).append('\'');
		sb.append(", productTheme='").append(productTheme).append('\'');
		sb.append(", productCusAdd1='").append(productCusAdd1).append('\'');
		sb.append(", productCusAdd2='").append(productCusAdd2).append('\'');
		sb.append(", productCusAdd3='").append(productCusAdd3).append('\'');
		sb.append(", productCusAdd4='").append(productCusAdd4).append('\'');
		sb.append(", productCusAdd5='").append(productCusAdd5).append('\'');
		sb.append(", ptTag='").append(ptTag).append('\'');
		sb.append(", ptKeyWords='").append(ptKeyWords).append('\'');
		sb.append(", appointment='").append(appointment).append('\'');
		sb.append(", facade=").append(facade);
		sb.append(", saleTypeO2o=").append(saleTypeO2o);
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", saleTypeOrderMeal=").append(saleTypeOrderMeal);
		sb.append(", saleTypeHotels=").append(saleTypeHotels);
		sb.append(", wholesaleDetail='").append(wholesaleDetail).append('\'');
		sb.append(", transportDetail='").append(transportDetail).append('\'');
		sb.append(", groupPurchaseBeginTime=").append(groupPurchaseBeginTime);
		sb.append(", groupPurchaseEndTime=").append(groupPurchaseEndTime);
		sb.append(", execBeginTime=").append(execBeginTime);
		sb.append(", execEndTime=").append(execEndTime);
		sb.append(", groupBuyDetail='").append(groupBuyDetail).append('\'');
		sb.append(", points=").append(points);
		sb.append(", tuneMeal=").append(tuneMeal);
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", resortsBusinessName='").append(resortsBusinessName).append('\'');
		sb.append(", resortsBusinessRealName='").append(resortsBusinessRealName).append('\'');
		sb.append(", customType1=").append(customType1);
		sb.append(", customType2=").append(customType2);
		sb.append(", customType3='").append(customType3).append('\'');
		sb.append(", customValue1='").append(customValue1).append('\'');
		sb.append(", customValue2='").append(customValue2).append('\'');
		sb.append(", customValue3='").append(customValue3).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
