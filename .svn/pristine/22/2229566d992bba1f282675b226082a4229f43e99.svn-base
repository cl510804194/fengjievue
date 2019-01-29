package com.yjf.esupplier.ws.bill.order;

import java.util.Date;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class SaveDeliveryShipOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 5978375685372394571L;
	
	@Override
	public void check() {
		validateHasZore(billNo, "订单编号");
		validateHasText(logisticsName, "物流公司");
	}
	
	private long id;
	/**
	 * 订单编号
	 */
	private long billNo;
	/**
	 * 物流公司id
	 */
	private long logisticsId;
	/**
	 * 物流公司
	 */
	private String logisticsName;
	/**
	 * 发货单号
	 */
	private String deliveryId;
	/**
	 * 配送人
	 */
	private String logisticsMan;
	/**
	 * 配送时间
	 */
	private Date logisticsTime;
	/**
	 * 发货人
	 */
	private String deliverer;
	/**
	 * 发货时间
	 */
	private Date deliveryDate;
	
	private String createMan;

	/*卖家备注*/
	private String sellerMemo;

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getBillNo() {
		return this.billNo;
	}
	
	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}
	
	public long getLogisticsId() {
		return this.logisticsId;
	}
	
	public void setLogisticsId(long logisticsId) {
		this.logisticsId = logisticsId;
	}
	
	public String getLogisticsName() {
		return this.logisticsName;
	}
	
	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}
	
	public String getDeliveryId() {
		return this.deliveryId;
	}
	
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	public String getLogisticsMan() {
		return this.logisticsMan;
	}
	
	public void setLogisticsMan(String logisticsMan) {
		this.logisticsMan = logisticsMan;
	}
	
	public Date getLogisticsTime() {
		return this.logisticsTime;
	}
	
	public void setLogisticsTime(Date logisticsTime) {
		this.logisticsTime = logisticsTime;
	}
	
	public String getDeliverer() {
		return this.deliverer;
	}
	
	public void setDeliverer(String deliverer) {
		this.deliverer = deliverer;
	}
	
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}
	
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getCreateMan() {
		return this.createMan;
	}
	
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public String getSellerMemo() {
		return sellerMemo;
	}

	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaveDeliveryShipOrder [id=");
		builder.append(id);
		builder.append(", billNo=");
		builder.append(billNo);
		builder.append(", logisticsId=");
		builder.append(logisticsId);
		builder.append(", logisticsName=");
		builder.append(logisticsName);
		builder.append(", deliveryId=");
		builder.append(deliveryId);
		builder.append(", logisticsMan=");
		builder.append(logisticsMan);
		builder.append(", logisticsTime=");
		builder.append(logisticsTime);
		builder.append(", deliverer=");
		builder.append(deliverer);
		builder.append(", deliveryDate=");
		builder.append(deliveryDate);
		builder.append(", createMan=");
		builder.append(createMan);
		builder.append("]");
		return builder.toString();
	}
	
}
