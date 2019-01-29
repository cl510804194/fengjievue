package com.yjf.esupplier.ws.bill.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.bill.enums.BillSearchOrderByEnum;
import com.yjf.esupplier.ws.bill.enums.OrderFlowStatus;
import com.yjf.esupplier.ws.bill.enums.OrderRefundStatusEnum;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.PrintReceiptStatusEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class QueryOrderInfoSearchOrder extends QueryPageBase {
	private static final long serialVersionUID = -6259568458079951643L;
	/** 发布商品会员ID */
	private long supplierId;
	/** 发布商品会员名称 */
	private String supplierName;
	/** 买家名称 */
	private String buyerNickname;
	
	Date beginDate;
	
	Date endDate;
	
	/** 买家的ID */
	private long userId;
	/** 景区中心ID */
	private long belongTo;
	/** 付款方式 */
	private String paymentMethod;
	/** 订单状态 */
	private OrderStatusEnum orderStatus;
	
	private OrderFlowStatus workflowStatus;
	
	private OrderRefundStatusEnum refundStatus;
	/** 订单主键 */
	private long id;
	
	/** 产品主键 */
	private long itemProductId;
	/** 产品的名称 */
	private String itemProductName;
	
	private String takeWays;
	/** 订单编号或者订单名称 **/
	private String pNameOrId;
	
	String orderId;
	/*订单删除状态*/
	private String delStatus;
	
	private BillSearchOrderByEnum orderByEnum;
	
	private List supplierIds;
	
	private SaleTypeEnum saleTypeEnum;
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
	private BooleanEnum saleTypeOrderMeal;
	/**
	 * 是否支持酒店预订
	 */
	private BooleanEnum saleTypeHotels;

	/**
	 * 产品扩展类型：商品 门票等
	 */
	private ProductVaryEnum productVary = ProductVaryEnum.product;
	
	private List<OrderStatusEnum> statusList;
	
	private List<OrderRefundStatusEnum> refundStatusList;
	/**
	 * 订单批次号
	 */
	protected String batchNo;
	/**
	 * 点餐流水桌号
	 */
	protected String tableNumberSeq;
	
	/** 只查询团购和邮购订单 */
	protected String selectO2oAndB2c;
	
	/** 是否调餐 */
	protected BooleanEnum tuneMeal;
	
	/** 打印小票 */
	protected PrintReceiptStatusEnum receiptStatusEnum;
	
	/** 打印小票 */
	protected long diliverymanId;
	
	private List<String> batchIdList;
	
	private long resortsBusinessId;

	/** 指派技师Id */
	private long diliveryId;

	/** 就餐时间(预订服务时间） */
	private Date diningTime;
	
	public List getSupplierIds() {
		return supplierIds;
	}
	
	public void setSupplierIds(List supplierIds) {
		this.supplierIds = supplierIds;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public OrderStatusEnum getOrderStatus() {
		return this.orderStatus;
	}
	
	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getItemProductId() {
		return this.itemProductId;
	}
	
	public void setItemProductId(long itemProductId) {
		this.itemProductId = itemProductId;
	}
	
	public String getItemProductName() {
		return this.itemProductName;
	}
	
	public void setItemProductName(String itemProductName) {
		this.itemProductName = itemProductName;
	}
	
	public String getTakeWays() {
		return this.takeWays;
	}
	
	public void setTakeWays(String takeWays) {
		this.takeWays = takeWays;
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
	
	public List<OrderStatusEnum> getStatusList() {
		return this.statusList;
	}
	
	public void setStatusList(List<OrderStatusEnum> statusList) {
		this.statusList = statusList;
	}
	
	public String getBuyerNickname() {
		return this.buyerNickname;
	}
	
	public void setBuyerNickname(String buyerNickname) {
		this.buyerNickname = buyerNickname;
	}
	
	public BillSearchOrderByEnum getOrderByEnum() {
		return this.orderByEnum;
	}
	
	public void setOrderByEnum(BillSearchOrderByEnum orderByEnum) {
		this.orderByEnum = orderByEnum;
	}
	
	public OrderFlowStatus getWorkflowStatus() {
		return this.workflowStatus;
	}
	
	public void setWorkflowStatus(OrderFlowStatus workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	
	public OrderRefundStatusEnum getRefundStatus() {
		return this.refundStatus;
	}
	
	public void setRefundStatus(OrderRefundStatusEnum refundStatus) {
		this.refundStatus = refundStatus;
	}
	
	public String getPNameOrId() {
		return pNameOrId;
	}
	
	public void setPNameOrId(String pNameOrId) {
		this.pNameOrId = pNameOrId;
	}
	
	public String getDelStatus() {
		return delStatus;
	}
	
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
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
	
	public List<OrderRefundStatusEnum> getRefundStatusList() {
		return refundStatusList;
	}
	
	public void setRefundStatusList(List<OrderRefundStatusEnum> refundStatusList) {
		this.refundStatusList = refundStatusList;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public SaleTypeEnum getSaleTypeEnum() {
		return saleTypeEnum;
	}
	
	public void setSaleTypeEnum(SaleTypeEnum saleTypeEnum) {
		this.saleTypeEnum = saleTypeEnum;
	}
	
	public long getBelongTo() {
		return belongTo;
	}
	
	public void setBelongTo(long belongTo) {
		this.belongTo = belongTo;
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
	
	public String getTableNumberSeq() {
		return this.tableNumberSeq;
	}
	
	public void setTableNumberSeq(String tableNumberSeq) {
		this.tableNumberSeq = tableNumberSeq;
	}
	
	public String getSelectO2oAndB2c() {
		return selectO2oAndB2c;
	}
	
	public void setSelectO2oAndB2c(String selectO2oAndB2c) {
		this.selectO2oAndB2c = selectO2oAndB2c;
	}
	
	public BooleanEnum getTuneMeal() {
		return tuneMeal;
	}
	
	public void setTuneMeal(BooleanEnum tuneMeal) {
		this.tuneMeal = tuneMeal;
	}
	
	public PrintReceiptStatusEnum getReceiptStatusEnum() {
		return this.receiptStatusEnum;
	}
	
	public void setReceiptStatusEnum(PrintReceiptStatusEnum receiptStatusEnum) {
		this.receiptStatusEnum = receiptStatusEnum;
	}
	
	public long getDiliverymanId() {
		return this.diliverymanId;
	}
	
	public void setDiliverymanId(long diliverymanId) {
		this.diliverymanId = diliverymanId;
	}
	
	public List<String> getBatchIdList() {
		return batchIdList;
	}

	public void setBatchIdList(List<String> batchIdList) {
		this.batchIdList = batchIdList;
	}
	
	public long getResortsBusinessId() {
		return resortsBusinessId;
	}

	public void setResortsBusinessId(long resortsBusinessId) {
		this.resortsBusinessId = resortsBusinessId;
	}

	public long getDiliveryId() {
		return diliveryId;
	}

	public void setDiliveryId(long diliveryId) {
		this.diliveryId = diliveryId;
	}

	public Date getDiningTime() {
		return diningTime;
	}

	public void setDiningTime(Date diningTime) {
		this.diningTime = diningTime;
	}

	public ProductVaryEnum getProductVary() {
		return productVary;
	}

	public void setProductVary(ProductVaryEnum productVary) {
		this.productVary = productVary;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("QueryOrderInfoSearchOrder{");
		sb.append("supplierId=").append(supplierId);
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", buyerNickname='").append(buyerNickname).append('\'');
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", userId=").append(userId);
		sb.append(", belongTo=").append(belongTo);
		sb.append(", paymentMethod='").append(paymentMethod).append('\'');
		sb.append(", orderStatus=").append(orderStatus);
		sb.append(", workflowStatus=").append(workflowStatus);
		sb.append(", refundStatus=").append(refundStatus);
		sb.append(", id=").append(id);
		sb.append(", itemProductId=").append(itemProductId);
		sb.append(", itemProductName='").append(itemProductName).append('\'');
		sb.append(", takeWays='").append(takeWays).append('\'');
		sb.append(", pNameOrId='").append(pNameOrId).append('\'');
		sb.append(", orderId='").append(orderId).append('\'');
		sb.append(", delStatus='").append(delStatus).append('\'');
		sb.append(", orderByEnum=").append(orderByEnum);
		sb.append(", supplierIds=").append(supplierIds);
		sb.append(", saleTypeEnum=").append(saleTypeEnum);
		sb.append(", saleTypeO2o=").append(saleTypeO2o);
		sb.append(", saleTypeB2c=").append(saleTypeB2c);
		sb.append(", saleTypeOrderMeal=").append(saleTypeOrderMeal);
		sb.append(", saleTypeHotels=").append(saleTypeHotels);
		sb.append(", productVary=").append(productVary);
		sb.append(", statusList=").append(statusList);
		sb.append(", refundStatusList=").append(refundStatusList);
		sb.append(", batchNo='").append(batchNo).append('\'');
		sb.append(", tableNumberSeq='").append(tableNumberSeq).append('\'');
		sb.append(", selectO2oAndB2c='").append(selectO2oAndB2c).append('\'');
		sb.append(", tuneMeal=").append(tuneMeal);
		sb.append(", receiptStatusEnum=").append(receiptStatusEnum);
		sb.append(", diliverymanId=").append(diliverymanId);
		sb.append(", batchIdList=").append(batchIdList);
		sb.append(", resortsBusinessId=").append(resortsBusinessId);
		sb.append(", diliveryId=").append(diliveryId);
		sb.append(", diningTime=").append(diningTime);
		sb.append('}');
		return sb.toString();
	}


}
