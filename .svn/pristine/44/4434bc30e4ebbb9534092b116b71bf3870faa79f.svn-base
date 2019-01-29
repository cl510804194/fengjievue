package com.yjf.esupplier.ws.bill.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.bill.enums.BillSearchOrderByEnum;
import com.yjf.esupplier.ws.bill.enums.RefundProcessStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundTypeEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class QueryRefundOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 5181795297293019541L;
	
	long orderId;
	/**
	 * 买家id
	 */
	long buyerUserId;
	/**
	 * 商家
	 */
	long supplierId;
	/**
	 * 景区id
	 */
	private long resortsBusinessId;
	/**
	 * 产品名称
	 */
	String productName;
	/**
	 * 退款状态
	 */
	RefundProcessStatusEnum statusEnum;
	
	Date beginDate;
	Date endDate;
	Date beginCheckDate;
	Date endCheckDate;
	
	private BooleanEnum saleTypeO2o;
	
	private BooleanEnum saleTypeB2c;
	/**
	 * 物流单号
	 */
	String logisticsNo;

	private ProductVaryEnum productVaryEnum;

	private BillSearchOrderByEnum orderByEnum;
	
	private RefundTypeEnum refundTypeEnum;
	
	private List<Long> supplierIds = new ArrayList<Long>();
	
	private List<String> refundStatusList = new ArrayList<String>();
	

	public long getBuyerUserId() {
		return this.buyerUserId;
	}
	
	public void setBuyerUserId(long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public RefundProcessStatusEnum getStatusEnum() {
		return this.statusEnum;
	}
	
	public void setStatusEnum(RefundProcessStatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}
	
	public Date getBeginDate() {
		return this.beginDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getBeginCheckDate() {
		return this.beginCheckDate;
	}
	
	public void setBeginCheckDate(Date beginCheckDate) {
		this.beginCheckDate = beginCheckDate;
	}
	
	public Date getEndCheckDate() {
		return this.endCheckDate;
	}
	
	public void setEndCheckDate(Date endCheckDate) {
		this.endCheckDate = endCheckDate;
	}
	
	public BillSearchOrderByEnum getOrderByEnum() {
		return this.orderByEnum;
	}
	
	public void setOrderByEnum(BillSearchOrderByEnum orderByEnum) {
		this.orderByEnum = orderByEnum;
	}
	
	public RefundTypeEnum getRefundTypeEnum() {
		return this.refundTypeEnum;
	}
	
	public void setRefundTypeEnum(RefundTypeEnum refundTypeEnum) {
		this.refundTypeEnum = refundTypeEnum;
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public String getLogisticsNo() {
		return this.logisticsNo;
	}
	
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
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
	
	public List<Long> getSupplierIds() {
		return supplierIds;
	}
	
	public void setSupplierIds(List<Long> supplierIds) {
		this.supplierIds = supplierIds;
	}
	
	public long getResortsBusinessId() {
		return this.resortsBusinessId;
	}
	
	public void setResortsBusinessId(long resortsBusinessId) {
		this.resortsBusinessId = resortsBusinessId;
	}


	public List<String> getRefundStatusList() {
		return refundStatusList;
	}

	public void setRefundStatusList(List<String> refundStatusList) {
		this.refundStatusList = refundStatusList;
	}

	public ProductVaryEnum getProductVaryEnum() {
		return productVaryEnum;
	}

	public void setProductVaryEnum(ProductVaryEnum productVaryEnum) {
		this.productVaryEnum = productVaryEnum;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("QueryRefundOrder{");
		sb.append("orderId=").append(orderId);
		sb.append(", buyerUserId=").append(buyerUserId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", productName='").append(productName).append('\'');
		sb.append(", statusEnum=").append(statusEnum);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", beginCheckDate=").append(beginCheckDate);
		sb.append(", endCheckDate=").append(endCheckDate);
		sb.append(", saleTypeO2o=").append(saleTypeO2o);
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", logisticsNo='").append(logisticsNo).append('\'');
		sb.append(", productVaryEnum=").append(productVaryEnum);
		sb.append(", orderByEnum=").append(orderByEnum);
		sb.append(", refundTypeEnum=").append(refundTypeEnum);
		sb.append(", supplierIds=").append(supplierIds);
		sb.append(", refundStatusList=").append(refundStatusList);
		sb.append('}');
		return sb.toString();
	}

}
