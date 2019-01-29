package com.yjf.esupplier.ws.product.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;
import com.yjf.esupplier.ws.supplier.enums.SupplierApproveStateEnum;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;

public class SupplierProductSearchOrder extends QueryPageBase {
	
	private static final long serialVersionUID = -8975387453076749771L;
	
	/*----------------商品查询条件-------------------*/
	/**
	 * 产品名称||供应商名称||供应商昵称(统查）
	 */
	private String name;
	
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品类型（code）
	 */
	private String productType;
	/**
	 * 是否邮购
	 */
	private BooleanEnum saleTypeB2c;
	/**
	 * 是否团购
	 */
	private BooleanEnum saleTypeO2O;
	/**
	 * 是否团购和邮购
	 */
	private BooleanEnum saleTypeO2OAndB2C;
	
	private BooleanEnum saleTypeO2OAndHotels;
	/**
	 * 是否支持订餐
	 */
	private BooleanEnum saleTypeOrderMeal;
	/**
	 * 是否支持酒店预订
	 */
	private BooleanEnum saleTypeHotels;
	
	/** 是否支持调餐 */
	private BooleanEnum tuneMeal;
	/**
	 * 产品状态
	 */
	ProductStatusEnum productStatus = ProductStatusEnum.ON;
	/**
	 * 产品状态
	 */
	ProductVaryEnum productVaryEnum = ProductVaryEnum.product;
	/**
	 * 产品关键词
	 */
	private String ptKeyWords;
	
	//排序
	/**
	 * 销售数量
	 */
	String saleCountSort;
	/**
	 * 价格
	 */
	String priceSort;
	/**
	 * 评价次数
	 */
	String scoreSort;
	/**
	 * 供应商评分
	 */
	String supplierScoreSort;
	
	/*----------------供应商查询条件-------------------*/
	/**
	 * 供应商网店名称
	 */
	private String spStoreName;
	/**
	 * 供应商真实名称
	 */
	private String spRealName;
	/**
	 * 供应商昵称
	 */
	private String spNickname;
	
	/**
	 * 供应商上三个字段模糊查询
	 */
	private String supplierSearchName;

	/*商户等级(一级 二级。。)*/
	private String shopGrade;
	/**
	 * 供应商审核状态
	 */
	private String approveState = SupplierApproveStateEnum.Completed.code();
	/**
	 * 供应商状态
	 */
	private String merchantState = MerchantStateEnum.IN.code();
	/**
	 * 供应商运营状态
	 */
	private String runState = SupplierRunStateEnum.Opening.code();
	/** 查询起始 **/
	private long firstRecord = -1;
	
	/*----------------商品查询其他条件-------------------*/
	//产品id
	long productId;
	//供应商id
	long supplierId;
	//供应商名称--在商品表中
	String supplierName;
	/**
	 * 审核状态
	 */
	long censor;
	
	/**
	 * 产品编号
	 */
	String productNumber;
	
	Money beginPrice;
	Money endPrice;
	
	/**
	 * 交易方式
	 */
	String tradeType;
	Date beginDate;
	Date endDate;
	
	//产品款式、题材
	String productStyle;
	String productTheme;
	
	/**
	 * 创建人
	 */
	long resortsBusinessId;

	/*用户经纬度*/
    /*经度*/
	private String longitude;
    /*维度*/
	private String latitude;
	
	public BooleanEnum getSaleTypeO2OAndB2C() {
		return saleTypeO2OAndB2C;
	}

	public void setSaleTypeO2OAndB2C(BooleanEnum saleTypeO2OAndB2C) {
		this.saleTypeO2OAndB2C = saleTypeO2OAndB2C;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public BooleanEnum getSaleTypeB2c() {
		return saleTypeB2c;
	}
	
	public void setSaleTypeB2c(BooleanEnum saleTypeB2c) {
		this.saleTypeB2c = saleTypeB2c;
	}
	
	public ProductStatusEnum getProductStatus() {
		return productStatus;
	}
	
	public void setProductStatus(ProductStatusEnum productStatus) {
		this.productStatus = productStatus;
	}
	
	public String getSaleCountSort() {
		return saleCountSort;
	}
	
	public void setSaleCountSort(String saleCountSort) {
		this.saleCountSort = saleCountSort;
	}
	
	public String getPriceSort() {
		return priceSort;
	}
	
	public void setPriceSort(String priceSort) {
		this.priceSort = priceSort;
	}
	
	public String getSupplierScoreSort() {
		return supplierScoreSort;
	}
	
	public void setSupplierScoreSort(String supplierScoreSort) {
		this.supplierScoreSort = supplierScoreSort;
	}
	
	public String getSpStoreName() {
		return spStoreName;
	}
	
	public void setSpStoreName(String spStoreName) {
		this.spStoreName = spStoreName;
	}
	
	public String getSpRealName() {
		return spRealName;
	}
	
	public void setSpRealName(String spRealName) {
		this.spRealName = spRealName;
	}
	
	public String getSpNickname() {
		return spNickname;
	}
	
	public void setSpNickname(String spNickname) {
		this.spNickname = spNickname;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getCensor() {
		return censor;
	}
	
	public void setCensor(long censor) {
		this.censor = censor;
	}
	
	public String getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public Money getBeginPrice() {
		return beginPrice;
	}
	
	public void setBeginPrice(Money beginPrice) {
		this.beginPrice = beginPrice;
	}
	
	public Money getEndPrice() {
		return endPrice;
	}
	
	public void setEndPrice(Money endPrice) {
		this.endPrice = endPrice;
	}
	
	public String getTradeType() {
		return tradeType;
	}
	
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	
	public Date getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
	public String getSupplierSearchName() {
		return supplierSearchName;
	}
	
	public void setSupplierSearchName(String supplierSearchName) {
		this.supplierSearchName = supplierSearchName;
	}
	
	public String getApproveState() {
		return approveState;
	}
	
	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
	
	public long getResortsBusinessId() {
		return resortsBusinessId;
	}
	
	public void setResortsBusinessId(long resortsBusinessId) {
		this.resortsBusinessId = resortsBusinessId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public long getFirstRecord() {
		return this.firstRecord;
	}
	
	public void setFirstRecord(long firstRecord) {
		this.firstRecord = firstRecord;
	}

	public String getPtKeyWords() {
		return ptKeyWords;
	}

	public void setPtKeyWords(String ptKeyWords) {
		this.ptKeyWords = ptKeyWords;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getScoreSort() {
		return scoreSort;
	}

	public void setScoreSort(String scoreSort) {
		this.scoreSort = scoreSort;
	}


	public BooleanEnum getSaleTypeO2O() {
		return saleTypeO2O;
	}

	public void setSaleTypeO2O(BooleanEnum saleTypeO2O) {
		this.saleTypeO2O = saleTypeO2O;
	}

	public String getShopGrade() {
		return shopGrade;
	}

	public void setShopGrade(String shopGrade) {
		this.shopGrade = shopGrade;
	}

	public String getMerchantState() {
		return merchantState;
	}

	public void setMerchantState(String merchantState) {
		this.merchantState = merchantState;
	}

	public String getRunState() {
		return runState;
	}

	public void setRunState(String runState) {
		this.runState = runState;
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

	public ProductVaryEnum getProductVaryEnum() {
		return productVaryEnum;
	}

	public void setProductVaryEnum(ProductVaryEnum productVaryEnum) {
		this.productVaryEnum = productVaryEnum;
	}

	public BooleanEnum getSaleTypeO2OAndHotels() {
		return saleTypeO2OAndHotels;
	}

	public void setSaleTypeO2OAndHotels(BooleanEnum saleTypeO2OAndHotels) {
		this.saleTypeO2OAndHotels = saleTypeO2OAndHotels;
	}
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("SupplierProductSearchOrder{");
		sb.append("name='").append(name).append('\'');
		sb.append(", productName='").append(productName).append('\'');
		sb.append(", productType='").append(productType).append('\'');
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", saleTypeO2O=").append(saleTypeO2O);
		sb.append(", saleTypeO2OAndB2C=").append(saleTypeO2OAndB2C);
		sb.append(", saleTypeO2OAndHotels=").append(saleTypeO2OAndHotels);
		sb.append(", saleTypeOrderMeal=").append(saleTypeOrderMeal);
		sb.append(", saleTypeHotels=").append(saleTypeHotels);
		sb.append(", tuneMeal=").append(tuneMeal);
		sb.append(", productStatus=").append(productStatus);
		sb.append(", productVaryEnum=").append(productVaryEnum);
		sb.append(", ptKeyWords='").append(ptKeyWords).append('\'');
		sb.append(", saleCountSort='").append(saleCountSort).append('\'');
		sb.append(", priceSort='").append(priceSort).append('\'');
		sb.append(", scoreSort='").append(scoreSort).append('\'');
		sb.append(", supplierScoreSort='").append(supplierScoreSort).append('\'');
		sb.append(", spStoreName='").append(spStoreName).append('\'');
		sb.append(", spRealName='").append(spRealName).append('\'');
		sb.append(", spNickname='").append(spNickname).append('\'');
		sb.append(", supplierSearchName='").append(supplierSearchName).append('\'');
		sb.append(", shopGrade='").append(shopGrade).append('\'');
		sb.append(", approveState='").append(approveState).append('\'');
		sb.append(", merchantState='").append(merchantState).append('\'');
		sb.append(", runState='").append(runState).append('\'');
		sb.append(", firstRecord=").append(firstRecord);
		sb.append(", productId=").append(productId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", censor=").append(censor);
		sb.append(", productNumber='").append(productNumber).append('\'');
		sb.append(", beginPrice=").append(beginPrice);
		sb.append(", endPrice=").append(endPrice);
		sb.append(", tradeType='").append(tradeType).append('\'');
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", productStyle='").append(productStyle).append('\'');
		sb.append(", productTheme='").append(productTheme).append('\'');
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", longitude='").append(longitude).append('\'');
		sb.append(", latitude='").append(latitude).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
