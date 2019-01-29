package com.yjf.esupplier.ws.supplier.info;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.supplier.enums.StoreStyleColorEnum;
import com.yjf.esupplier.ws.supplier.enums.SupplierApproveStateEnum;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;
import com.yjf.esupplier.ws.supplier.enums.VouchStateEnum;

public class SupplierInfo implements Serializable {
	
	private static final long serialVersionUID = 3423160737464030118L;
	private long supplierId; // 供应商编号
	/**
	 * 真实名称
	 */
	private String realName;
	/**
	 * 昵称
	 */
	private String nickname;
	
	private String bizDomain; // 经营范围
	private String productType; // 拟供品种
	
	/** 是否支持团、邮 */
	private BooleanEnum o2o;

	/** 是否支持点餐 */
	private BooleanEnum orderMeal;
	/** 是否支持酒店预订 */
	private BooleanEnum hotels;
	/** 叫餐最低配送金额 */
	private Money lowestHandselAmount = new Money(0, 0);
	private String storeName; // 网店名称
	private long supplierType; // 供应商类型1 单位2个人
	private SupplierApproveStateEnum approveState; // 审核状态
	private String locked; // 是否锁定
	private String voucherId; // 担保机构
	private VouchStateEnum vouchState; // 担保状态
	private SupplierRunStateEnum runState; //运营状态
	//+++ 评价信息
	private double reviewProduct; //一致性评价
	private double reviewDelivery; //配送评价
	private double reviewCommunication; //服务评价
	private double reviewAverage; //供应商综合评价
	private String promiseState; //供应商诚信承诺状态
	private String introduction;//企业简介
	
	private StoreStyleColorEnum storeStyle = StoreStyleColorEnum.GREEN; //风格//orange,blue,red,green
	private String storeUrl; //非本站网店地址
	private long productAmount; //供应商产品总数
	private Date checkTime;
	
	BigDecimal amount;
	String area;
	String contactor;
	
	private String address;

	private String openTime;

	private String closeTime;

	private MerchantStateEnum merchantStateEnum;

	private Money spendPer = new Money(0, 0);

	private String merchantType;

	private String merchantPicPath1;

	private String merchantPicPath2;

	private String merchantPicPath3;

	private String merchantPicPath4;

	private String longitude;

	private String latitude;

	private String mobile;
	/** 景区名**/
	private String scenicName;
	
	private String scenicId;

	private long distance = 0;
	/** 酒店排序分**/
	private long hotelOrderScore = 0;

	private List<ProductInfo> productInfo;
    /*总评分数*/
	private long scoreSum;
	/*评价次数*/
	private long rateSum;
	/*销售总数*/
	private long productSum;
	/*是否支持到店付(YES,NO)*/
	private BooleanEnum toShop = BooleanEnum.NO ;
	/*商户等级(一级 二级。。)*/
	private String shopGrade;

	/** 餐桌总数 */
	private long tableNumber;
	
	/** 房间最低价格 */
	private Money roomLowestPrice = new Money(0, 0);
	
	/** 正常价格 */
	private Money roomNormalPrice = new Money(0, 0);

	/** 是否有推荐房 */
	private BooleanEnum recommendRoom;

	/** 是否有特价房 */
	private BooleanEnum specialRoom;
	
	/** 是否有长租房 */
	private BooleanEnum longRentRoom;
	
	/** 凌晨房 */
	private BooleanEnum morningRoom;
	
	/** 是否收餐 */
	private BooleanEnum dining;

	private String diningSupplierType;
	
	private SupplierRunStateEnum diningRunState; //运营状态
	
	/** 调餐服务费率 */
	private double serviceChargeRate;

	/** 是否推荐商户 */
	private BooleanEnum recommend;
	/** 商户到店付折扣 */
	private Double productDiscount;
	
	private String aroundLine;

	private Money  totalSale = new Money(0);
	
	public Date getCheckTime() {
		return checkTime;
	}
	
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	
	public long getProductAmount() {
		return productAmount;
	}
	
	public void setProductAmount(long productAmount) {
		this.productAmount = productAmount;
	}
	
	public StoreStyleColorEnum getStoreStyle() {
		return this.storeStyle;
	}
	
	public void setStoreStyle(StoreStyleColorEnum storeStyle) {
		this.storeStyle = storeStyle;
	}
	
	public String getStoreUrl() {
		return storeUrl;
	}
	
	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getPromiseState() {
		return promiseState;
	}
	
	public void setPromiseState(String promiseState) {
		this.promiseState = promiseState;
	}
	
	public double getReviewProduct() {
		return reviewProduct;
	}
	
	public void setReviewProduct(double reviewProduct) {
		this.reviewProduct = reviewProduct;
	}
	
	public double getReviewDelivery() {
		return reviewDelivery;
	}
	
	public void setReviewDelivery(double reviewDelivery) {
		this.reviewDelivery = reviewDelivery;
	}
	
	public double getReviewCommunication() {
		return reviewCommunication;
	}
	
	public void setReviewCommunication(double reviewCommunication) {
		this.reviewCommunication = reviewCommunication;
	}
	
	public double getReviewAverage() {
		return reviewAverage;
	}

	public double getReviewAverageDefault() {
		if(reviewAverage<=0){
			return 5.0;
		}
		return reviewAverage;
	}


	public void setReviewAverage(double reviewAverage) {
		this.reviewAverage = reviewAverage;
	}
	
	public SupplierRunStateEnum getRunState() {
		return runState;
	}
	
	public void setRunState(SupplierRunStateEnum runState) {
		this.runState = runState;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getBizDomain() {
		return bizDomain;
	}
	
	public void setBizDomain(String bizDomain) {
		this.bizDomain = bizDomain;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public BooleanEnum getOrderMeal() {
		return orderMeal;
	}
	
	public void setOrderMeal(BooleanEnum orderMeal) {
		this.orderMeal = orderMeal;
	}
	
	public BooleanEnum getHotels() {
		return hotels;
	}
	
	public void setHotels(BooleanEnum hotels) {
		this.hotels = hotels;
	}

	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public long getSupplierType() {
		return supplierType;
	}
	
	public void setSupplierType(long supplierType) {
		this.supplierType = supplierType;
	}
	
	public SupplierApproveStateEnum getApproveState() {
		return approveState;
	}
	
	public void setApproveState(SupplierApproveStateEnum approveState) {
		this.approveState = approveState;
	}
	
	public String getLocked() {
		return locked;
	}
	
	public void setLocked(String locked) {
		this.locked = locked;
	}
	
	public String getVoucherId() {
		return voucherId;
	}
	
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}
	
	public VouchStateEnum getVouchState() {
		return vouchState;
	}
	
	public void setVouchState(VouchStateEnum vouchState) {
		this.vouchState = vouchState;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getArea() {
		return this.area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getContactor() {
		return this.contactor;
	}
	
	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public Money getSpendPer() {
		return spendPer;
	}

	public void setSpendPer(Money spendPer) {
		this.spendPer = spendPer;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantPicPath1() {
		return merchantPicPath1;
	}

	public void setMerchantPicPath1(String merchantPicPath1) {
		this.merchantPicPath1 = merchantPicPath1;
	}

	public String getMerchantPicPath2() {
		return merchantPicPath2;
	}

	public void setMerchantPicPath2(String merchantPicPath2) {
		this.merchantPicPath2 = merchantPicPath2;
	}

	public String getMerchantPicPath3() {
		return merchantPicPath3;
	}

	public void setMerchantPicPath3(String merchantPicPath3) {
		this.merchantPicPath3 = merchantPicPath3;
	}

	public String getMerchantPicPath4() {
		return merchantPicPath4;
	}

	public void setMerchantPicPath4(String merchantPicPath4) {
		this.merchantPicPath4 = merchantPicPath4;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public MerchantStateEnum getMerchantStateEnum() {
		return merchantStateEnum;
	}

	public void setMerchantStateEnum(MerchantStateEnum merchantStateEnum) {
		this.merchantStateEnum = merchantStateEnum;
	}

	public String getScenicName() {
		return scenicName;
	}
	
	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}

	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}

	public String getScenicId() {
		return scenicId;
	}

	public void setScenicId(String scenicId) {
		this.scenicId = scenicId;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
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

	public long getProductSum() {
		return productSum;
	}

	public void setProductSum(long productSum) {
		this.productSum = productSum;
	}

	public BooleanEnum getToShop() {
		return toShop;
	}

	public void setToShop(BooleanEnum toShop) {
		this.toShop = toShop;
	}

	public String getShopGrade() {
		return shopGrade;
	}

	public void setShopGrade(String shopGrade) {
		this.shopGrade = shopGrade;
	}
	
	public Money getLowestHandselAmount() {
		return lowestHandselAmount;
	}

	public void setLowestHandselAmount(Money lowestHandselAmount) {
		this.lowestHandselAmount = lowestHandselAmount;
	}
	
	public BooleanEnum getO2o() {
		return o2o;
	}
	
	public void setO2o(BooleanEnum o2o) {
		this.o2o = o2o;
	}

	public long getTableNumber() {
		return tableNumber;
	}
	
	public void setTableNumber(long tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public Money getRoomLowestPrice() {
		return roomLowestPrice;
	}
	
	public void setRoomLowestPrice(Money roomLowestPrice) {
		this.roomLowestPrice = roomLowestPrice;
	}
	
	public Money getRoomNormalPrice() {
		return roomNormalPrice;
	}
	
	public void setRoomNormalPrice(Money roomNormalPrice) {
		this.roomNormalPrice = roomNormalPrice;
	}

	public BooleanEnum getRecommendRoom() {
		return recommendRoom;
	}

	public void setRecommendRoom(BooleanEnum recommendRoom) {
		this.recommendRoom = recommendRoom;
	}

	public BooleanEnum getSpecialRoom() {
		return specialRoom;
	}

	public void setSpecialRoom(BooleanEnum specialRoom) {
		this.specialRoom = specialRoom;
	}

	public BooleanEnum getLongRentRoom() {
		return longRentRoom;
	}

	public void setLongRentRoom(BooleanEnum longRentRoom) {
		this.longRentRoom = longRentRoom;
	}

	public BooleanEnum getMorningRoom() {
		return morningRoom;
	}

	public void setMorningRoom(BooleanEnum morningRoom) {
		this.morningRoom = morningRoom;
	}

	public BooleanEnum getDining() {
		return dining;
	}
	
	public void setDining(BooleanEnum dining) {
		this.dining = dining;
	}

	public String getDiningSupplierType() {
		return diningSupplierType;
	}
	
	public void setDiningSupplierType(String diningSupplierType) {
		this.diningSupplierType = diningSupplierType;
	}
	
	public SupplierRunStateEnum getDiningRunState() {
		return diningRunState;
	}
	
	public void setDiningRunState(SupplierRunStateEnum diningRunState) {
		this.diningRunState = diningRunState;
	}
	
	public double getServiceChargeRate() {
		return serviceChargeRate;
	}
	
	public void setServiceChargeRate(double serviceChargeRate) {
		this.serviceChargeRate = serviceChargeRate;
	}

	public Money getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(Money totalSale) {
		this.totalSale = totalSale;
	}

	public long getHotelOrderScore() {
		return hotelOrderScore;
	}

	public void setHotelOrderScore(long hotelOrderScore) {
		this.hotelOrderScore = hotelOrderScore;
	}

	public BooleanEnum getRecommend() {
		return recommend;
	}

	public void setRecommend(BooleanEnum recommend) {
		this.recommend = recommend;
	}

	public Double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getAroundLine() {
		return aroundLine;
	}

	public void setAroundLine(String aroundLine) {
		this.aroundLine = aroundLine;
	}
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("SupplierInfo{");
		sb.append("supplierId=").append(supplierId);
		sb.append(", realName='").append(realName).append('\'');
		sb.append(", nickname='").append(nickname).append('\'');
		sb.append(", bizDomain='").append(bizDomain).append('\'');
		sb.append(", productType='").append(productType).append('\'');
		sb.append(", o2o=").append(o2o);
		sb.append(", orderMeal=").append(orderMeal);
		sb.append(", hotels=").append(hotels);
		sb.append(", lowestHandselAmount=").append(lowestHandselAmount);
		sb.append(", storeName='").append(storeName).append('\'');
		sb.append(", supplierType=").append(supplierType);
		sb.append(", approveState=").append(approveState);
		sb.append(", locked='").append(locked).append('\'');
		sb.append(", voucherId='").append(voucherId).append('\'');
		sb.append(", vouchState=").append(vouchState);
		sb.append(", runState=").append(runState);
		sb.append(", reviewProduct=").append(reviewProduct);
		sb.append(", reviewDelivery=").append(reviewDelivery);
		sb.append(", reviewCommunication=").append(reviewCommunication);
		sb.append(", reviewAverage=").append(reviewAverage);
		sb.append(", promiseState='").append(promiseState).append('\'');
		sb.append(", introduction='").append(introduction).append('\'');
		sb.append(", storeStyle=").append(storeStyle);
		sb.append(", storeUrl='").append(storeUrl).append('\'');
		sb.append(", productAmount=").append(productAmount);
		sb.append(", checkTime=").append(checkTime);
		sb.append(", amount=").append(amount);
		sb.append(", area='").append(area).append('\'');
		sb.append(", contactor='").append(contactor).append('\'');
		sb.append(", address='").append(address).append('\'');
		sb.append(", openTime='").append(openTime).append('\'');
		sb.append(", closeTime='").append(closeTime).append('\'');
		sb.append(", merchantStateEnum=").append(merchantStateEnum);
		sb.append(", spendPer=").append(spendPer);
		sb.append(", merchantType='").append(merchantType).append('\'');
		sb.append(", merchantPicPath1='").append(merchantPicPath1).append('\'');
		sb.append(", merchantPicPath2='").append(merchantPicPath2).append('\'');
		sb.append(", merchantPicPath3='").append(merchantPicPath3).append('\'');
		sb.append(", merchantPicPath4='").append(merchantPicPath4).append('\'');
		sb.append(", longitude='").append(longitude).append('\'');
		sb.append(", latitude='").append(latitude).append('\'');
		sb.append(", mobile='").append(mobile).append('\'');
		sb.append(", scenicName='").append(scenicName).append('\'');
		sb.append(", scenicId='").append(scenicId).append('\'');
		sb.append(", distance=").append(distance);
		sb.append(", hotelOrderScore=").append(hotelOrderScore);
		sb.append(", productInfo=").append(productInfo);
		sb.append(", scoreSum=").append(scoreSum);
		sb.append(", rateSum=").append(rateSum);
		sb.append(", productSum=").append(productSum);
		sb.append(", toShop=").append(toShop);
		sb.append(", shopGrade='").append(shopGrade).append('\'');
		sb.append(", tableNumber=").append(tableNumber);
		sb.append(", roomLowestPrice=").append(roomLowestPrice);
		sb.append(", roomNormalPrice=").append(roomNormalPrice);
		sb.append(", recommendRoom=").append(recommendRoom);
		sb.append(", specialRoom=").append(specialRoom);
		sb.append(", longRentRoom=").append(longRentRoom);
		sb.append(", morningRoom=").append(morningRoom);
		sb.append(", dining=").append(dining);
		sb.append(", diningSupplierType='").append(diningSupplierType).append('\'');
		sb.append(", diningRunState=").append(diningRunState);
		sb.append(", serviceChargeRate=").append(serviceChargeRate);
		sb.append(", recommend=").append(recommend);
		sb.append(", productDiscount=").append(productDiscount);
		sb.append(", totalSale=").append(totalSale);
		sb.append(", aroundLine=").append(aroundLine);
		sb.append('}');
		return sb.toString();
	}


}
