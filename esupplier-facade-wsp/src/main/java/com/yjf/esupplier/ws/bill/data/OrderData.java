package com.yjf.esupplier.ws.bill.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.enums.OrderFlowStatus;
import com.yjf.esupplier.ws.bill.enums.OrderRefundStatusEnum;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.PaymentMethodEnum;
import com.yjf.esupplier.ws.bill.enums.PrintReceiptStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundProcessStatusEnum;
import com.yjf.esupplier.ws.bill.enums.TakeWaysEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.QrStatusEnum;
import com.yjf.esupplier.ws.info.DeliveryPlaceInfo;
import com.yjf.esupplier.ws.product.enums.PostFeeTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.product.enums.RefundRuleEnum;

public class OrderData implements Serializable {
	
	protected static final long serialVersionUID = 7191652746167531063L;
	/** 订单主键 */
	protected long id;
	/** 省 */
	protected String province;
	/** 城市 */
	protected String city;
	/** 区 */
	protected String county;
	/** 地址编码 */
	protected String areaCode;
	/** 详细地址 */
	protected String detailAddress;
	/** 收货人姓名 */
	protected String drawerName;
	/** 收取人联系电话(手机) */
	protected String drawerNumber;
	/** 邮编 */
	protected String zipCode;
	/** 备注 */
	protected String specialExplain;
	/** 付款方式 */
	protected PaymentMethodEnum paymentMethod = PaymentMethodEnum.ONLINE;
	/** 订单状态 */
	protected OrderStatusEnum orderStatus;
	/** 发布商品会员ID */
	protected long supplierId;
	/** 发布商品会员名称 */
	protected String supplierName;
	
	/** 发布商品会员名称昵称 */
	protected String supplierNickname;
	/**
	 * 游客中心
	 */
	protected long resortsBusinessId;
	/**
	 * 游客用户名
	 */
	protected String resortsBusinessName;
	/**
	 * 游客真实名称
	 */
	protected String resortsBusinessRealName;
	/** 创建时间 */
	protected Date createTime;
	/** 会员的ID */
	protected long userId;
	/** 会员的ID */
	protected String buyerNickname;
	/** 订单操作人 */
	protected long operatorId;
	/** 操作时间 */
	protected Date operatorTime;
	/** 邮递费用 */
	protected Money postFee = Money.zero();
	/** 邮递费用承担类型 */
	protected PostFeeTypeEnum postType;
	/** 订单的总金额 */
	protected Money totalAmount = Money.zero();
	
	protected String productName; //只用于支付页面的订单展示产品的名称,不需要存入数据库
	protected long productId; //只用于支付页面的订单展示产品的超链接,不需要存入数据库
	
	protected BooleanEnum isPayed = BooleanEnum.NO;//平台是否向被担保商户付款
	protected Date payedTime;//平台向被担保商户付款时间
	
	//////////**客户提货方式 2011-03-22 cl add*/
	protected TakeWaysEnum takeWays = TakeWaysEnum.DELIVERY;
	//////////**客户提货地点 2016-9-1 qch add 在点餐 中 就餐商户id*/ 
	protected long takegoodsId;
	
	protected OrderFlowStatus workflowStatus;
	
	protected String sellerMemo;
	
	protected DeliveryPlaceInfo deliveryPlace; //关联提货地址
	
	protected Date confirmReceiptTime;
	
	protected OrderRefundStatusEnum refundStatus;
	
	protected Money gainMoney = new Money(0, 0);
	
	protected Money giftMoney = new Money(0, 0);
	
	protected long userPoint;
	
	protected Money userPointAmount = new Money(0, 0);
	
	protected Date rawAddTime;
	
	protected Date rawUpdateTime;
	
	protected String qrCode;
	
	protected QrStatusEnum sendStatus;
	
	protected Date sendTime;
	
	protected Date validationTime;
	/**
	 * 团购开始时间
	 */
	protected Date groupPurchaseBeginTime;
	/**
	 * 团购结束时间
	 */
	protected Date groupPurchaseEndTime;
	/**
	 * 付款流水
	 */
	protected String paymentFlowId;
	
	/**
	 * 作为易极付外部订单号，处理同一笔订单重复付款，订单内容更改问题
	 */
	protected String orderNo;
	
	protected BooleanEnum validationStatus = BooleanEnum.NO;
	
	protected BooleanEnum delStatus = BooleanEnum.NO;
	/**
	 * 收款人座机
	 */
	protected String drawerTel;
	
	protected RefundRuleEnum facade;
	/**
	 * 是否是o2o NO
	 */
	protected BooleanEnum saleTypeO2o = BooleanEnum.NO;
	
	/**
	 * 是否是B2c
	 */
	protected BooleanEnum saleTypeB2c = BooleanEnum.NO;
	
	/**
	 * 是否支持订餐
	 */
	protected BooleanEnum saleTypeOrderMeal = BooleanEnum.NO;
	/**
	 * 是否支持酒店预订
	 */
	protected BooleanEnum saleTypeHotels = BooleanEnum.NO;

	/**
	 * 产品扩展类型：商品 门票等
	 */
	protected ProductVaryEnum productVary = ProductVaryEnum.product;
	/**
	 * 订单批次号
	 */
	protected String batchNo;
	/**
	 * 是否调餐
	 */
	protected BooleanEnum tuneMeal = BooleanEnum.NO;
	/**
	 * 餐桌流水号
	 */
	protected String tableNumberSeq;
	/**
	 * 餐桌号
	 */
	protected String tableNumber;
	
	/** 是否打印小票 */
	private PrintReceiptStatusEnum printReceipt = PrintReceiptStatusEnum.NOT_PRINT;

	/** 配送员（技师）Id */
	private long diliverymanId;
	
	/** 配送员（技师）名字 */
	private String diliverymanName;
	/** 指派技师Id */
	private long diliveryId;
	/** 指派技师名字 */
	private String diliveryName;
	
	/** 就餐时间(预订服务时间） */
	private Date diningTime;
	
	/** 下单时间 */
	private Date ordersTime;
	
	/** 发货时间（派送时间） */
	private Date deliverTime;
	
	private RefundProcessStatusEnum refundProcessStatus;
	
	/** 配送费 */
	protected Money diliveryFee = new Money(0, 0);

	public Money getPayAmount() {
		return totalAmount.subtract(gainMoney).subtract(giftMoney).subtract(userPointAmount);
	}

	/** 折扣类型 1优惠券 2 积分 3 红包 **/
	public String getDiscountType() {
		String discountType = "";
		if (gainMoney.greaterThan(Money.zero())) {
			discountType = discountType + "1";
		}
		if (userPointAmount.greaterThan(Money.zero())) {
			discountType = discountType + "2";
		}
		if (giftMoney.greaterThan(Money.zero())) {
			discountType = discountType + "3";
		}
		if (StringUtil.isEmpty(discountType))
			return "";
		return discountType.substring(1);
	}
	
	public Date getValidationTime() {
		return this.validationTime;
	}
	
	public void setValidationTime(Date validationTime) {
		this.validationTime = validationTime;
	}
	
	public void setPostFee(Money postFee) {
		this.postFee = postFee;
	}
	
	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCounty() {
		return this.county;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	public String getAreaCode() {
		return this.areaCode;
	}
	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getDetailAddress() {
		return this.detailAddress;
	}
	
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	public String getDrawerName() {
		return this.drawerName;
	}
	
	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}
	
	public String getDrawerNumber() {
		return this.drawerNumber;
	}
	
	public void setDrawerNumber(String drawerNumber) {
		this.drawerNumber = drawerNumber;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getSpecialExplain() {
		return this.specialExplain;
	}
	
	public void setSpecialExplain(String specialExplain) {
		this.specialExplain = specialExplain;
	}
	
	public PaymentMethodEnum getPaymentMethod() {
		return this.paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public OrderStatusEnum getOrderStatus() {
		return this.orderStatus;
	}
	
	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
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
	
	public String getSupplierNickname() {
		return this.supplierNickname;
	}
	
	public void setSupplierNickname(String supplierNickname) {
		this.supplierNickname = supplierNickname;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getBuyerNickname() {
		return this.buyerNickname;
	}
	
	public void setBuyerNickname(String buyerNickname) {
		this.buyerNickname = buyerNickname;
	}
	
	public long getOperatorId() {
		return this.operatorId;
	}
	
	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}
	
	public Date getOperatorTime() {
		return this.operatorTime;
	}
	
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	
	public PostFeeTypeEnum getPostType() {
		return this.postType;
	}
	
	public void setPostType(PostFeeTypeEnum postType) {
		this.postType = postType;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public BooleanEnum getIsPayed() {
		return this.isPayed;
	}
	
	public void setIsPayed(BooleanEnum isPayed) {
		this.isPayed = isPayed;
	}
	
	public Date getPayedTime() {
		return this.payedTime;
	}
	
	public void setPayedTime(Date payedTime) {
		this.payedTime = payedTime;
	}
	
	public TakeWaysEnum getTakeWays() {
		return this.takeWays;
	}
	
	public void setTakeWays(TakeWaysEnum takeWays) {
		this.takeWays = takeWays;
	}
	
	public long getTakegoodsId() {
		return this.takegoodsId;
	}
	
	public void setTakegoodsId(long takegoodsId) {
		this.takegoodsId = takegoodsId;
	}
	
	public OrderFlowStatus getWorkflowStatus() {
		return this.workflowStatus;
	}
	
	public void setWorkflowStatus(OrderFlowStatus workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	
	public String getSellerMemo() {
		return this.sellerMemo;
	}
	
	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}
	
	public DeliveryPlaceInfo getDeliveryPlace() {
		return this.deliveryPlace;
	}
	
	public void setDeliveryPlace(DeliveryPlaceInfo deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}
	
	public Date getConfirmReceiptTime() {
		return this.confirmReceiptTime;
	}
	
	public void setConfirmReceiptTime(Date confirmReceiptTime) {
		this.confirmReceiptTime = confirmReceiptTime;
	}
	
	public OrderRefundStatusEnum getRefundStatus() {
		return this.refundStatus;
	}
	
	public void setRefundStatus(OrderRefundStatusEnum refundStatus) {
		this.refundStatus = refundStatus;
	}
	
	public Money getGainMoney() {
		return this.gainMoney;
	}
	
	public void setGainMoney(Money gainMoney) {
		this.gainMoney = gainMoney;
	}
	
	public Money getGiftMoney() {
		return this.giftMoney;
	}
	
	public void setGiftMoney(Money giftMoney) {
		this.giftMoney = giftMoney;
	}
	
	public long getUserPoint() {
		return this.userPoint;
	}
	
	public void setUserPoint(long userPoint) {
		this.userPoint = userPoint;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public String getQrCode() {
		return this.qrCode;
	}
	
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
	public QrStatusEnum getSendStatus() {
		return this.sendStatus;
	}
	
	public void setSendStatus(QrStatusEnum sendStatus) {
		this.sendStatus = sendStatus;
	}
	
	public Date getSendTime() {
		return this.sendTime;
	}
	
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
	public String getPaymentFlowId() {
		return this.paymentFlowId;
	}
	
	public void setPaymentFlowId(String paymentFlowId) {
		this.paymentFlowId = paymentFlowId;
	}
	
	public BooleanEnum getValidationStatus() {
		return this.validationStatus;
	}
	
	public void setValidationStatus(BooleanEnum validationStatus) {
		this.validationStatus = validationStatus;
	}
	
	public String getDrawerTel() {
		return this.drawerTel;
	}
	
	public void setDrawerTel(String drawerTel) {
		this.drawerTel = drawerTel;
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
	
	public Money getPostFee() {
		return this.postFee;
	}
	
	public Money getTotalAmount() {
		return this.totalAmount;
	}
	
	public RefundRuleEnum getFacade() {
		return this.facade;
	}
	
	public void setFacade(RefundRuleEnum facade) {
		this.facade = facade;
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
	
	public BooleanEnum getDelStatus() {
		return this.delStatus;
	}
	
	public void setDelStatus(BooleanEnum delStatus) {
		this.delStatus = delStatus;
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
	
	public Money getUserPointAmount() {
		return this.userPointAmount;
	}
	
	public void setUserPointAmount(Money userPointAmount) {
		this.userPointAmount = userPointAmount;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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
		return this.tuneMeal;
	}
	
	public void setTuneMeal(BooleanEnum tuneMeal) {
		this.tuneMeal = tuneMeal;
	}
	
	public String getTableNumberSeq() {
		return this.tableNumberSeq;
	}
	
	public void setTableNumberSeq(String tableNumberSeq) {
		this.tableNumberSeq = tableNumberSeq;
	}
	
	public String getTableNumber() {
		return this.tableNumber;
	}
	
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public PrintReceiptStatusEnum getPrintReceipt() {
		return printReceipt;
	}
	
	public void setPrintReceipt(PrintReceiptStatusEnum printReceipt) {
		this.printReceipt = printReceipt;
	}
	
	public long getDiliverymanId() {
		return diliverymanId;
	}
	
	public void setDiliverymanId(long diliverymanId) {
		this.diliverymanId = diliverymanId;
	}
	
	public String getDiliverymanName() {
		return diliverymanName;
	}
	
	public void setDiliverymanName(String diliverymanName) {
		this.diliverymanName = diliverymanName;
	}
	
	public Date getDiningTime() {
		return diningTime;
	}
	
	public void setDiningTime(Date diningTime) {
		this.diningTime = diningTime;
	}
	
	public Date getOrdersTime() {
		return ordersTime;
	}
	
	public void setOrdersTime(Date ordersTime) {
		this.ordersTime = ordersTime;
	}
	
	public Date getDeliverTime() {
		return deliverTime;
	}
	
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}

	public RefundProcessStatusEnum getRefundProcessStatus() {
		return refundProcessStatus;
	}

	public void setRefundProcessStatus(RefundProcessStatusEnum refundProcessStatus) {
		this.refundProcessStatus = refundProcessStatus;
	}
	
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}

	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}

	public Money getDiliveryFee() {
		return diliveryFee;
	}
	
	public void setDiliveryFee(Money diliveryFee) {
		this.diliveryFee = diliveryFee;
	}
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public long getDiliveryId() {
		return diliveryId;
	}

	public void setDiliveryId(long diliveryId) {
		this.diliveryId = diliveryId;
	}

	public String getDiliveryName() {
		return diliveryName;
	}

	public void setDiliveryName(String diliveryName) {
		this.diliveryName = diliveryName;
	}

	public ProductVaryEnum getProductVary() {
		return productVary;
	}

	public void setProductVary(ProductVaryEnum productVary) {
		this.productVary = productVary;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("OrderData{");
		sb.append("id=").append(id);
		sb.append(", province='").append(province).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append(", county='").append(county).append('\'');
		sb.append(", areaCode='").append(areaCode).append('\'');
		sb.append(", detailAddress='").append(detailAddress).append('\'');
		sb.append(", drawerName='").append(drawerName).append('\'');
		sb.append(", drawerNumber='").append(drawerNumber).append('\'');
		sb.append(", zipCode='").append(zipCode).append('\'');
		sb.append(", specialExplain='").append(specialExplain).append('\'');
		sb.append(", paymentMethod=").append(paymentMethod);
		sb.append(", orderStatus=").append(orderStatus);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", supplierNickname='").append(supplierNickname).append('\'');
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", resortsBusinessName='").append(resortsBusinessName).append('\'');
		sb.append(", resortsBusinessRealName='").append(resortsBusinessRealName).append('\'');
		sb.append(", createTime=").append(createTime);
		sb.append(", userId=").append(userId);
		sb.append(", buyerNickname='").append(buyerNickname).append('\'');
		sb.append(", operatorId=").append(operatorId);
		sb.append(", operatorTime=").append(operatorTime);
		sb.append(", postFee=").append(postFee);
		sb.append(", postType=").append(postType);
		sb.append(", totalAmount=").append(totalAmount);
		sb.append(", productName='").append(productName).append('\'');
		sb.append(", productId=").append(productId);
		sb.append(", isPayed=").append(isPayed);
		sb.append(", payedTime=").append(payedTime);
		sb.append(", takeWays=").append(takeWays);
		sb.append(", takegoodsId=").append(takegoodsId);
		sb.append(", workflowStatus=").append(workflowStatus);
		sb.append(", sellerMemo='").append(sellerMemo).append('\'');
		sb.append(", deliveryPlace=").append(deliveryPlace);
		sb.append(", confirmReceiptTime=").append(confirmReceiptTime);
		sb.append(", refundStatus=").append(refundStatus);
		sb.append(", gainMoney=").append(gainMoney);
		sb.append(", giftMoney=").append(giftMoney);
		sb.append(", userPoint=").append(userPoint);
		sb.append(", userPointAmount=").append(userPointAmount);
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append(", qrCode='").append(qrCode).append('\'');
		sb.append(", sendStatus=").append(sendStatus);
		sb.append(", sendTime=").append(sendTime);
		sb.append(", validationTime=").append(validationTime);
		sb.append(", groupPurchaseBeginTime=").append(groupPurchaseBeginTime);
		sb.append(", groupPurchaseEndTime=").append(groupPurchaseEndTime);
		sb.append(", paymentFlowId='").append(paymentFlowId).append('\'');
		sb.append(", orderNo='").append(orderNo).append('\'');
		sb.append(", validationStatus=").append(validationStatus);
		sb.append(", delStatus=").append(delStatus);
		sb.append(", drawerTel='").append(drawerTel).append('\'');
		sb.append(", facade=").append(facade);
		sb.append(", saleTypeO2o=").append(saleTypeO2o);
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", saleTypeOrderMeal=").append(saleTypeOrderMeal);
		sb.append(", saleTypeHotels=").append(saleTypeHotels);
		sb.append(", productVary=").append(productVary);
		sb.append(", batchNo='").append(batchNo).append('\'');
		sb.append(", tuneMeal=").append(tuneMeal);
		sb.append(", tableNumberSeq='").append(tableNumberSeq).append('\'');
		sb.append(", tableNumber='").append(tableNumber).append('\'');
		sb.append(", printReceipt=").append(printReceipt);
		sb.append(", diliverymanId=").append(diliverymanId);
		sb.append(", diliverymanName='").append(diliverymanName).append('\'');
		sb.append(", diliveryId=").append(diliveryId);
		sb.append(", diliveryName='").append(diliveryName).append('\'');
		sb.append(", diningTime=").append(diningTime);
		sb.append(", ordersTime=").append(ordersTime);
		sb.append(", deliverTime=").append(deliverTime);
		sb.append(", refundProcessStatus=").append(refundProcessStatus);
		sb.append(", diliveryFee=").append(diliveryFee);
		sb.append('}');
		return sb.toString();
	}


}
