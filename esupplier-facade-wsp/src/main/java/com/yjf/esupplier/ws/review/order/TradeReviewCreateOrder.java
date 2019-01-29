package com.yjf.esupplier.ws.review.order;

import com.yjf.esupplier.ws.enums.ReviewTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class TradeReviewCreateOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 942962394123122213L;
	private long supplierId = 0; //供应商编号;
	private ReviewTypeEnum type = ReviewTypeEnum.product; //评价对象;
	private long orderId = 0; //对应的订单号;
	private long buyerId = 0; //卖家编号;
	private String buyerName = ""; //买家名称;
	private String buyerIp = ""; //买家的IP地址;
	private int product = 0; //宣传与实物一致性评分;
	private int delivery = 0; //发货及时性评分;
	private int communication = 0; //服务态度评分;
	private String remark = ""; //评语和说明;
	//供应商名称
	private String supplierName = "";
	
	private long productId;
	
	@Override
	public void check() {
		//validateHasZore(supplierId, "供应商");
		validateHasZore(orderId, "订单号");
		validateHasZore(buyerId, "买家编号");
//		validateHasText(buyerName, "买家名称");
		//validateHasText(supplierName, "供应商名称");
	}

	public ReviewTypeEnum getType() {
		return type;
	}

	public void setType(ReviewTypeEnum type) {
		this.type = type;
	}

	public long getSupplierId() {
		return this.supplierId;
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public long getBuyerId() {
		return this.buyerId;
	}
	
	public String getBuyerName() {
		return this.buyerName;
	}
	
	public String getBuyerIp() {
		return this.buyerIp;
	}
	
	public int getProduct() {
		return this.product;
	}
	
	public int getDelivery() {
		return this.delivery;
	}
	
	public int getCommunication() {
		return this.communication;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public String getSupplierName() {
		return this.supplierName;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public void setBuyerIp(String buyerIp) {
		this.buyerIp = buyerIp;
	}
	
	public void setProduct(int product) {
		this.product = product;
	}
	
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	
	public void setCommunication(int communication) {
		this.communication = communication;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("TradeReviewCreateOrder{");
		sb.append("supplierId=").append(supplierId);
		sb.append(", type=").append(type);
		sb.append(", orderId=").append(orderId);
		sb.append(", buyerId=").append(buyerId);
		sb.append(", buyerName='").append(buyerName).append('\'');
		sb.append(", buyerIp='").append(buyerIp).append('\'');
		sb.append(", product=").append(product);
		sb.append(", delivery=").append(delivery);
		sb.append(", communication=").append(communication);
		sb.append(", remark='").append(remark).append('\'');
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", productId=").append(productId);
		sb.append('}');
		return sb.toString();
	}

}
