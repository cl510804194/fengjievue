package com.yjf.esupplier.ws.bill.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.enums.RefundProcessStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundTypeEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;

public class RefundOrderData implements Serializable {
	
	private static final long serialVersionUID = 5677919262169251939L;
	/**
	 * 退款id
	 */
	private long refundId;
	/**
	 * 订单明细id
	 */
	private long orderItemId;
	/**
	 * 订单id
	 */
	private long orderId;
	/**
	 * 产品id
	 */
	private long productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品价格
	 */
	private Money price = new Money(0, 0);
	/**
	 * 退款数量
	 */
	private long quantity;
	/**
	 * 原购买数量
	 */
	private long oldQuantity;
	/**
	 * 图片
	 */
	private String picPath;
	/**
	 * 买家id
	 */
	private long buyerUserId;
	/**
	 * 买家名称
	 */
	private String buyerRealName;
	/**
	 * 买家用户名
	 */
	private String buyerUserName;
	/**
	 * 退款类型
	 */
	private RefundTypeEnum refundType;
	/**
	 * 退款金额
	 */
	private Money refundAmount = new Money(0, 0);
	/**
	 * 退款数量
	 */
	private long refundQuantity;
	/**
	 * 卖家id
	 */
	private long supplierId;
	/**
	 * 供应商名称
	 */
	private String supplierName;
	/**
	 * 供应商昵称
	 */
	private String supplierNickname;
	
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
	
	private BooleanEnum saleTypeO2o;
	
	private BooleanEnum saleTypeB2c;
	
	private BooleanEnum saleTypeHotels;
	
	private BooleanEnum refundBackStage = BooleanEnum.NO;
	/**
	 * 审核时间
	 */
	private Date checkPassDate;
	/**
	 * 退款原因
	 */
	private String refundReason;
	/**
	 * 退款描述
	 */
	private String refundDesc;
	/**
	 * 申请时间
	 */
	private Date applyDate;
	/**
	 * 审核意见
	 */
	private String checkAdvice;
	/**
	 * 物流公司
	 */
	private String logisticsCompanies;
	/**
	 * 物流单号
	 */
	private String logisticsNo;
	/**
	 * 状态
	 */
	private RefundProcessStatusEnum status;

	/**
	 * 状态
	 */
	private ProductVaryEnum productVaryEnum;

	/**
	 * 申请时间
	 */
	private Date arriveDate;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getRefundId() {
		return this.refundId;
	}
	
	public void setRefundId(long refundId) {
		this.refundId = refundId;
	}
	
	public long getOrderItemId() {
		return this.orderItemId;
	}
	
	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Money getPrice() {
		return this.price;
	}
	
	public void setPrice(Money price) {
		this.price = price;
	}
	
	public long getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	public long getOldQuantity() {
		return this.oldQuantity;
	}
	
	public void setOldQuantity(long oldQuantity) {
		this.oldQuantity = oldQuantity;
	}
	
	public String getPicPath() {
		return this.picPath;
	}
	
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public long getBuyerUserId() {
		return this.buyerUserId;
	}
	
	public void setBuyerUserId(long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	
	public String getBuyerRealName() {
		return this.buyerRealName;
	}
	
	public void setBuyerRealName(String buyerRealName) {
		this.buyerRealName = buyerRealName;
	}
	
	public String getBuyerUserName() {
		return this.buyerUserName;
	}
	
	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}
	
	public RefundTypeEnum getRefundType() {
		return this.refundType;
	}
	
	public void setRefundType(RefundTypeEnum refundType) {
		this.refundType = refundType;
	}
	
	public Money getRefundAmount() {
		return this.refundAmount;
	}
	
	public void setRefundAmount(Money refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	public long getRefundQuantity() {
		return this.refundQuantity;
	}
	
	public void setRefundQuantity(long refundQuantity) {
		this.refundQuantity = refundQuantity;
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
	
	public Date getCheckPassDate() {
		return this.checkPassDate;
	}
	
	public void setCheckPassDate(Date checkPassDate) {
		this.checkPassDate = checkPassDate;
	}
	
	public String getRefundReason() {
		return this.refundReason;
	}
	
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	
	public String getRefundDesc() {
		return this.refundDesc;
	}
	
	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}
	
	public Date getApplyDate() {
		return this.applyDate;
	}
	
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
	public String getCheckAdvice() {
		return this.checkAdvice;
	}
	
	public void setCheckAdvice(String checkAdvice) {
		this.checkAdvice = checkAdvice;
	}
	
	public String getLogisticsCompanies() {
		return this.logisticsCompanies;
	}
	
	public void setLogisticsCompanies(String logisticsCompanies) {
		this.logisticsCompanies = logisticsCompanies;
	}
	
	public String getLogisticsNo() {
		return this.logisticsNo;
	}
	
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	
	public RefundProcessStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(RefundProcessStatusEnum status) {
		this.status = status;
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
	
	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}

	public Money getTotalAmount() {
		return this.price.multiply(this.quantity);
	}
	
	public BooleanEnum getSaleTypeHotels() {
		return saleTypeHotels;
	}

	public void setSaleTypeHotels(BooleanEnum saleTypeHotels) {
		this.saleTypeHotels = saleTypeHotels;
	}
	
	public BooleanEnum getRefundBackStage() {
		return refundBackStage;
	}

	public void setRefundBackStage(BooleanEnum refundBackStage) {
		this.refundBackStage = refundBackStage;
	}

	public ProductVaryEnum getProductVaryEnum() {
		return productVaryEnum;
	}

	public void setProductVaryEnum(ProductVaryEnum productVaryEnum) {
		this.productVaryEnum = productVaryEnum;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("RefundOrderData{");
		sb.append("refundId=").append(refundId);
		sb.append(", orderItemId=").append(orderItemId);
		sb.append(", orderId=").append(orderId);
		sb.append(", productId=").append(productId);
		sb.append(", productName='").append(productName).append('\'');
		sb.append(", price=").append(price);
		sb.append(", quantity=").append(quantity);
		sb.append(", oldQuantity=").append(oldQuantity);
		sb.append(", picPath='").append(picPath).append('\'');
		sb.append(", buyerUserId=").append(buyerUserId);
		sb.append(", buyerRealName='").append(buyerRealName).append('\'');
		sb.append(", buyerUserName='").append(buyerUserName).append('\'');
		sb.append(", refundType=").append(refundType);
		sb.append(", refundAmount=").append(refundAmount);
		sb.append(", refundQuantity=").append(refundQuantity);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", supplierNickname='").append(supplierNickname).append('\'');
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", resortsBusinessName='").append(resortsBusinessName).append('\'');
		sb.append(", resortsBusinessRealName='").append(resortsBusinessRealName).append('\'');
		sb.append(", saleTypeO2o=").append(saleTypeO2o);
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", saleTypeHotels=").append(saleTypeHotels);
		sb.append(", refundBackStage=").append(refundBackStage);
		sb.append(", checkPassDate=").append(checkPassDate);
		sb.append(", refundReason='").append(refundReason).append('\'');
		sb.append(", refundDesc='").append(refundDesc).append('\'');
		sb.append(", applyDate=").append(applyDate);
		sb.append(", checkAdvice='").append(checkAdvice).append('\'');
		sb.append(", logisticsCompanies='").append(logisticsCompanies).append('\'');
		sb.append(", logisticsNo='").append(logisticsNo).append('\'');
		sb.append(", status=").append(status);
		sb.append(", productVaryEnum=").append(productVaryEnum);
		sb.append(", arriveDate=").append(arriveDate);
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append('}');
		return sb.toString();
	}


}
