package com.yjf.esupplier.ws.product.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.info.Discount2productInfo;
import com.yjf.esupplier.ws.product.enums.*;

public class ProductData implements Serializable {
	private static final long serialVersionUID = -5838945199297278605L;
	/**
	 * 产品id
	 */
	private long productId;
	/**
	 * 买家id
	 */
	private long supplierId;
	/**
	 * 买家名称
	 */
	private String supplierName;
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
	/**
	 * 操作员 游客中心
	 */
	private long operatorId;
	/**
	 * 操作员用户名 游客中心
	 */
	private String operatorName;
	/**
	 * 操作员真实名称 游客中心
	 */
	private String operatorRealName;
	
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品的供应商自编号
	 */
	private String productNumber;//
	/**
	 * 产品状态
	 */
	private ProductStatusEnum productStatus;
	/**
	 * 产品单位
	 */
	private String productUnit;
	/**
	 * 产品价格1
	 */
	private Money price1;
	/**
	 * 产品价格2
	 */
	private Money price2;
	/**
	 * 产品价格3
	 */
	private Money price3;
	/**
	 * 产品价格(范围1)
	 */
	private String price1Range;
	/**
	 * 产品价格(范围2)
	 */
	private String price2Range;
	/**
	 * 产品价格(范围3)
	 */
	private String price3Range;
	/**
	 * 产品类型
	 */
	private String productType;
	/**
	 * 产品类型名称
	 */
	private String productTypeName;

	/**
	 * 产品扩展类型：商品 门票等
	 */
	private ProductVaryEnum productVary = ProductVaryEnum.product;

	/**
	 * 产品小图
	 */
	private String smallPicPath;
	
	/**
	 * 微信端使用图片
	 */
	private String middlePicPath;
	/**
	 * 产品大图
	 */
	private String bigPicPath;
	/**
	 * 产品小图1
	 */
	private String smallPicPath1;
	
	/**
	 * 微信端使用图片1
	 */
	private String middlePicPath1;
	/**
	 * 产品大图1
	 */
	private String bigPicPath1;
	/**
	 * 产品小图2
	 */
	private String smallPicPath2;
	
	/**
	 * 微信端使用图片2
	 */
	private String middlePicPath2;
	/**
	 * 产品大图2
	 */
	private String bigPicPath2;
	/**
	 * 产品小图3
	 */
	private String smallPicPath3;
	
	/**
	 * 微信端使用图片
	 */
	private String middlePicPath3;
	/**
	 * 产品大图3
	 */
	private String bigPicPath3;
	/**
	 * 是否支持网上订购
	 */
	private String webOrder;//
	/**
	 * 起订量
	 */
	private long startOrderCount;//
	/**
	 * 酒店库存量
	 */
	private long wareCount;//
	/**
	 * 预订量
	 */
	private long reservedCount = 0;//
	/**
	 * 销售量停用
	 */
	private long saleCount = 0;//
	/**
	 * 是否是o2o商品
	 */
	private BooleanEnum saleTypeO2o = BooleanEnum.YES;
	/**
	 * 是否是b2c商品
	 */
	private BooleanEnum saleTypeB2c = BooleanEnum.YES;
	
	/**
	 * 是否支持订餐
	 */
	private BooleanEnum saleTypeOrderMeal = BooleanEnum.NO;
	/**
	 * 是否支持酒店预订
	 */
	private BooleanEnum saleTypeHotels = BooleanEnum.NO;
	/**
	 * 团购开始时间
	 */
	protected Date groupPurchaseBeginTime;
	/**
	 * 团购结束时间
	 */
	protected Date groupPurchaseEndTime;
	
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
	 * 产品描述
	 */
	private String productDetail;
	/**
	 * 批发说明||预约提示
	 */
	private String wholesaleDetail;//
	/**
	 * 运费说明||温馨提示
	 */
	private String transportDetail;//
	/**
	 * 交易方式
	 */
	private String tradeType;//
	/**
	 * 产品发布日期
	 */
	private Date productStartDate;//
	/**
	 * 产品修改日期
	 */
	private Date productModifyDate;//
	/**
	 * 产品删除日期
	 */
	private Date productEndDate;//
	/**
	 * ip地址
	 */
	private String ipAddress;
	/**
	 * 退款规则
	 */
	private RefundRuleEnum facade;//
	
	private Date lastViewTime;//最近点击时间
	private long viewCount = 0;//点击量
	/**
	 * 产品审核
	 */
	private ProductCheckEnum censor;//审核状态
	/**
	 * 运费支付方式，0：卖家承担，1：联系卖家，2：买家承担
	 */
	private PostFeeTypeEnum postType;//运费支付方式，0：卖家承担，1：联系卖家，2：买家承担
	/**
	 * 市场价格
	 */
	private Money marketPrice;
	/**
	 * 折扣信息
	 */
	private Discount2productInfo discount2Product;
	/**
	 * 图片
	 */
	private String picPath;//描述图片
	/**
	 * html地址
	 */
	private String htmlPath;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	/**
	 * 审核人员id
	 */
	private long checkId;
	/**
	 * 审核人员name
	 */
	private String checkName;
	/**
	 * 审核人员真实名称
	 */
	private String checkRealName;
	
	/**
	 * 产品分类1
	 */
	private String productStyle;
	/**
	 * 产品分类2
	 */
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
	 * 评价平均分
	 */
	private double scoreAvg;
	/**
	 * 总评价分
	 */
	private long scoreSum;
	/**
	 * 评价次数
	 */
	private long rateSum;
	
	/**
	 * 该商品获取积分倍数
	 */
	private int points;
	
	/** 是否支持调餐 */
	private BooleanEnum tuneMeal;
	/** 是否推荐商品 */
	private BooleanEnum recommend;
	/** 是否特价房 */
	private BooleanEnum specialRoom;
	/** 是否长租房 */
	private BooleanEnum longRentRoom;
	/** 是否凌晨房 */
	private BooleanEnum morningRoom;
	/** 商品排序分 */
	private long orderScore;
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
		return this.supplierName;
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
	
	public long getReservedCount() {
		return this.reservedCount;
	}
	
	public void setReservedCount(long reservedCount) {
		this.reservedCount = reservedCount;
	}
	
	public long getSaleCount() {
		return this.saleCount;
	}
	
	public void setSaleCount(long saleCount) {
		this.saleCount = saleCount;
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
	
	public Date getProductStartDate() {
		return this.productStartDate;
	}
	
	public void setProductStartDate(Date productStartDate) {
		this.productStartDate = productStartDate;
	}
	
	public Date getProductModifyDate() {
		return this.productModifyDate;
	}
	
	public void setProductModifyDate(Date productModifyDate) {
		this.productModifyDate = productModifyDate;
	}
	
	public Date getProductEndDate() {
		return this.productEndDate;
	}
	
	public void setProductEndDate(Date productEndDate) {
		this.productEndDate = productEndDate;
	}
	
	public String getIpAddress() {
		return this.ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public RefundRuleEnum getFacade() {
		return this.facade;
	}
	
	public void setFacade(RefundRuleEnum facade) {
		this.facade = facade;
	}
	
	public Date getLastViewTime() {
		return this.lastViewTime;
	}
	
	public void setLastViewTime(Date lastViewTime) {
		this.lastViewTime = lastViewTime;
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
	
	public Discount2productInfo getDiscount2Product() {
		return this.discount2Product;
	}
	
	public void setDiscount2Product(Discount2productInfo discount2Product) {
		this.discount2Product = discount2Product;
	}
	
	public String getPicPath() {
		return this.picPath;
	}
	
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public String getHtmlPath() {
		return this.htmlPath;
	}
	
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	
	public String getProductStyle() {
		return this.productStyle;
	}
	
	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}
	
	public String getProductTheme() {
		return this.productTheme;
	}
	
	public void setProductTheme(String productTheme) {
		this.productTheme = productTheme;
	}
	
	public String getProductCusAdd1() {
		return this.productCusAdd1;
	}
	
	public void setProductCusAdd1(String productCusAdd1) {
		this.productCusAdd1 = productCusAdd1;
	}
	
	public String getProductCusAdd2() {
		return this.productCusAdd2;
	}
	
	public void setProductCusAdd2(String productCusAdd2) {
		this.productCusAdd2 = productCusAdd2;
	}
	
	public String getProductCusAdd3() {
		return this.productCusAdd3;
	}
	
	public void setProductCusAdd3(String productCusAdd3) {
		this.productCusAdd3 = productCusAdd3;
	}
	
	public String getProductCusAdd4() {
		return this.productCusAdd4;
	}
	
	public void setProductCusAdd4(String productCusAdd4) {
		this.productCusAdd4 = productCusAdd4;
	}
	
	public String getProductCusAdd5() {
		return this.productCusAdd5;
	}
	
	public void setProductCusAdd5(String productCusAdd5) {
		this.productCusAdd5 = productCusAdd5;
	}
	
	public long getViewCount() {
		return this.viewCount;
	}
	
	public BooleanEnum getSaleTypeO2o() {
		return this.saleTypeO2o;
	}
	
	public void setSaleTypeO2o(BooleanEnum saleTypeO2o) {
		this.saleTypeO2o = saleTypeO2o;
	}
	
	public BooleanEnum getSaleTypeB2c() {
		return this.saleTypeB2c;
	}
	
	public void setSaleTypeB2c(BooleanEnum saleTypeB2c) {
		this.saleTypeB2c = saleTypeB2c;
	}
	
	public String getGroupBuyDetail() {
		return this.groupBuyDetail;
	}
	
	public void setGroupBuyDetail(String groupBuyDetail) {
		this.groupBuyDetail = groupBuyDetail;
	}
	
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	
	public void setCensor(ProductCheckEnum censor) {
		this.censor = censor;
	}
	
	public ProductCheckEnum getCensor() {
		return this.censor;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public long getResortsBusinessId() {
		return this.resortsBusinessId;
	}
	
	public void setResortsBusinessId(long resortsBusinessId) {
		this.resortsBusinessId = resortsBusinessId;
	}
	
	public String getResortsBusinessName() {
		return this.resortsBusinessName;
	}
	
	public void setResortsBusinessName(String resortsBusinessName) {
		this.resortsBusinessName = resortsBusinessName;
	}
	
	public String getResortsBusinessRealName() {
		return this.resortsBusinessRealName;
	}
	
	public void setResortsBusinessRealName(String resortsBusinessRealName) {
		this.resortsBusinessRealName = resortsBusinessRealName;
	}
	
	public long getOperatorId() {
		return this.operatorId;
	}
	
	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}
	
	public String getOperatorName() {
		return this.operatorName;
	}
	
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	public String getOperatorRealName() {
		return this.operatorRealName;
	}
	
	public void setOperatorRealName(String operatorRealName) {
		this.operatorRealName = operatorRealName;
	}
	
	public long getCheckId() {
		return this.checkId;
	}
	
	public void setCheckId(long checkId) {
		this.checkId = checkId;
	}
	
	public String getCheckName() {
		return this.checkName;
	}
	
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	
	public String getCheckRealName() {
		return this.checkRealName;
	}
	
	public void setCheckRealName(String checkRealName) {
		this.checkRealName = checkRealName;
	}
	
	public Date getGroupPurchaseEndTime() {
		return this.groupPurchaseEndTime;
	}
	
	public void setGroupPurchaseEndTime(Date groupPurchaseEndTime) {
		this.groupPurchaseEndTime = groupPurchaseEndTime;
	}
	
	public Date getGroupPurchaseBeginTime() {
		return this.groupPurchaseBeginTime;
	}
	
	public void setGroupPurchaseBeginTime(Date groupPurchaseBeginTime) {
		this.groupPurchaseBeginTime = groupPurchaseBeginTime;
	}
	
	public String getPtTag() {
		return ptTag;
	}
	
	public void setPtTag(String ptTag) {
		this.ptTag = ptTag;
	}
	
	public String getPtKeyWords() {
		return ptKeyWords;
	}
	
	public void setPtKeyWords(String ptKeyWords) {
		this.ptKeyWords = ptKeyWords;
	}
	
	public String getAppointment() {
		return appointment;
	}
	
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	
	public double getScoreAvg() {
		return scoreAvg;
	}
	
	public void setScoreAvg(double scoreAvg) {
		this.scoreAvg = scoreAvg;
	}
	
	public long getScoreSum() {
		return scoreSum;
	}
	
	public void setScoreSum(long scoreSum) {
		this.scoreSum = scoreSum;
	}
	
	public long getRateSum() {
		return rateSum;
	}
	
	public void setRateSum(long rateSum) {
		this.rateSum = rateSum;
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
	
	public BooleanEnum getRecommend() {
		return recommend;
	}
	
	public void setRecommend(BooleanEnum recommend) {
		this.recommend = recommend;
	}
	
	public BooleanEnum getLongRentRoom() {
		return longRentRoom;
	}
	
	public void setLongRentRoom(BooleanEnum longRentRoom) {
		this.longRentRoom = longRentRoom;
	}
	
	public BooleanEnum getSpecialRoom() {
		return specialRoom;
	}
	
	public void setSpecialRoom(BooleanEnum specialRoom) {
		this.specialRoom = specialRoom;
	}
	
	public BooleanEnum getMorningRoom() {
		return morningRoom;
	}
	
	public void setMorningRoom(BooleanEnum morningRoom) {
		this.morningRoom = morningRoom;
	}
	
	public long getOrderScore() {
		return orderScore;
	}
	
	public void setOrderScore(long orderScore) {
		this.orderScore = orderScore;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public Date getExecEndTime() {
		return execEndTime;
	}
	
	public void setExecEndTime(Date execEndTime) {
		this.execEndTime = execEndTime;
	}
	
	public Date getExecBeginTime() {
		return execBeginTime;
	}
	
	public void setExecBeginTime(Date execBeginTime) {
		this.execBeginTime = execBeginTime;
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
	
	public String getMiddlePicPath() {
		return middlePicPath;
	}
	
	public void setMiddlePicPath(String middlePicPath) {
		this.middlePicPath = middlePicPath;
	}
	
	public String getMiddlePicPath1() {
		return middlePicPath1;
	}
	
	public void setMiddlePicPath1(String middlePicPath1) {
		this.middlePicPath1 = middlePicPath1;
	}
	
	public String getMiddlePicPath2() {
		return middlePicPath2;
	}
	
	public void setMiddlePicPath2(String middlePicPath2) {
		this.middlePicPath2 = middlePicPath2;
	}
	
	public String getMiddlePicPath3() {
		return middlePicPath3;
	}
	
	public void setMiddlePicPath3(String middlePicPath3) {
		this.middlePicPath3 = middlePicPath3;
	}

	public ProductVaryEnum getProductVary() {
		return productVary;
	}

	public void setProductVary(ProductVaryEnum productVary) {
		this.productVary = productVary;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ProductData{");
		sb.append("productId=").append(productId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", resortsBusinessName='").append(resortsBusinessName).append('\'');
		sb.append(", resortsBusinessRealName='").append(resortsBusinessRealName).append('\'');
		sb.append(", operatorId=").append(operatorId);
		sb.append(", operatorName='").append(operatorName).append('\'');
		sb.append(", operatorRealName='").append(operatorRealName).append('\'');
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
		sb.append(", middlePicPath='").append(middlePicPath).append('\'');
		sb.append(", bigPicPath='").append(bigPicPath).append('\'');
		sb.append(", smallPicPath1='").append(smallPicPath1).append('\'');
		sb.append(", middlePicPath1='").append(middlePicPath1).append('\'');
		sb.append(", bigPicPath1='").append(bigPicPath1).append('\'');
		sb.append(", smallPicPath2='").append(smallPicPath2).append('\'');
		sb.append(", middlePicPath2='").append(middlePicPath2).append('\'');
		sb.append(", bigPicPath2='").append(bigPicPath2).append('\'');
		sb.append(", smallPicPath3='").append(smallPicPath3).append('\'');
		sb.append(", middlePicPath3='").append(middlePicPath3).append('\'');
		sb.append(", bigPicPath3='").append(bigPicPath3).append('\'');
		sb.append(", webOrder='").append(webOrder).append('\'');
		sb.append(", startOrderCount=").append(startOrderCount);
		sb.append(", wareCount=").append(wareCount);
		sb.append(", reservedCount=").append(reservedCount);
		sb.append(", saleCount=").append(saleCount);
		sb.append(", saleTypeO2o=").append(saleTypeO2o);
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", saleTypeOrderMeal=").append(saleTypeOrderMeal);
		sb.append(", saleTypeHotels=").append(saleTypeHotels);
		sb.append(", groupPurchaseBeginTime=").append(groupPurchaseBeginTime);
		sb.append(", groupPurchaseEndTime=").append(groupPurchaseEndTime);
		sb.append(", execBeginTime=").append(execBeginTime);
		sb.append(", execEndTime=").append(execEndTime);
		sb.append(", groupBuyDetail='").append(groupBuyDetail).append('\'');
		sb.append(", productDetail='").append(productDetail).append('\'');
		sb.append(", wholesaleDetail='").append(wholesaleDetail).append('\'');
		sb.append(", transportDetail='").append(transportDetail).append('\'');
		sb.append(", tradeType='").append(tradeType).append('\'');
		sb.append(", productStartDate=").append(productStartDate);
		sb.append(", productModifyDate=").append(productModifyDate);
		sb.append(", productEndDate=").append(productEndDate);
		sb.append(", ipAddress='").append(ipAddress).append('\'');
		sb.append(", facade=").append(facade);
		sb.append(", lastViewTime=").append(lastViewTime);
		sb.append(", viewCount=").append(viewCount);
		sb.append(", censor=").append(censor);
		sb.append(", postType=").append(postType);
		sb.append(", marketPrice=").append(marketPrice);
		sb.append(", discount2Product=").append(discount2Product);
		sb.append(", picPath='").append(picPath).append('\'');
		sb.append(", htmlPath='").append(htmlPath).append('\'');
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append(", checkId=").append(checkId);
		sb.append(", checkName='").append(checkName).append('\'');
		sb.append(", checkRealName='").append(checkRealName).append('\'');
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
		sb.append(", scoreAvg=").append(scoreAvg);
		sb.append(", scoreSum=").append(scoreSum);
		sb.append(", rateSum=").append(rateSum);
		sb.append(", points=").append(points);
		sb.append(", tuneMeal=").append(tuneMeal);
		sb.append(", recommend=").append(recommend);
		sb.append(", specialRoom=").append(specialRoom);
		sb.append(", longRentRoom=").append(longRentRoom);
		sb.append(", morningRoom=").append(morningRoom);
		sb.append(", orderScore=").append(orderScore);
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
