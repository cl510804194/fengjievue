package com.yjf.esupplier.ws.hotel.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;

import java.util.Date;

public class HotelStockInfoOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -5736929542761119013L;
	private long id;
	/*房型id*/
	private long productId;
	/*房型名称*/
	private String productName;
	/*商户ID*/
	private long supplierId;
	/*日期*/
	private Date priceDate;
	/*价格*/
	private Money productPrice = new Money(0, 0);
	/*折扣价*/
	private Money marketPrice = new Money(0, 0);
	/*执行价-最低价*/
	private Money execPrice = new Money(0, 0);
	/*特价房价格*/
	private Money specialRoomPrice = new Money(0, 0);
	/*凌晨房价格*/
	private Money morningRoomPrice = new Money(0, 0);
	/*总库存*/
	private long inStock;
	/*可用库存*/
	private long availableStock;
	/*预订数量*/
	private long ordainNum;
	/*凌晨房数量*/
	private long morningRoomTotalNum;
	/*凌晨房预定数量*/
	private long morningRoomNum;
	/*特价房预定总数量*/
	private long specialRoomTotalNum;
	/*特价房预定数量*/
	private long specialRoomNum;
	/*状态*/
	private HotelStockStatusEnum status;
	/*开始日期*/
	private Date beginDate;
	/*结束日期*/
	private Date endDate;

	@Override
	public void check() {
		validateHasZore(supplierId, "商户id");
		validateHasZore(productId, "产品ID");
		validateHasText(productName, "产品名称");
		validateMoneyGreaterThanZero(productPrice, "产品价格");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public Money getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Money productPrice) {
		this.productPrice = productPrice;
	}

	public Money getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Money marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Money getSpecialRoomPrice() {
		return specialRoomPrice;
	}

	public void setSpecialRoomPrice(Money specialRoomPrice) {
		this.specialRoomPrice = specialRoomPrice;
	}

	public Money getMorningRoomPrice() {
		return morningRoomPrice;
	}

	public void setMorningRoomPrice(Money morningRoomPrice) {
		this.morningRoomPrice = morningRoomPrice;
	}

	public long getInStock() {
		return inStock;
	}

	public void setInStock(long inStock) {
		this.inStock = inStock;
	}

	public long getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(long availableStock) {
		this.availableStock = availableStock;
	}

	public long getOrdainNum() {
		return ordainNum;
	}

	public void setOrdainNum(long ordainNum) {
		this.ordainNum = ordainNum;
	}

	public long getMorningRoomTotalNum() {
		return morningRoomTotalNum;
	}

	public void setMorningRoomTotalNum(long morningRoomTotalNum) {
		this.morningRoomTotalNum = morningRoomTotalNum;
	}

	public long getMorningRoomNum() {
		return morningRoomNum;
	}

	public void setMorningRoomNum(long morningRoomNum) {
		this.morningRoomNum = morningRoomNum;
	}

	public long getSpecialRoomTotalNum() {
		return specialRoomTotalNum;
	}

	public void setSpecialRoomTotalNum(long specialRoomTotalNum) {
		this.specialRoomTotalNum = specialRoomTotalNum;
	}

	public long getSpecialRoomNum() {
		return specialRoomNum;
	}

	public void setSpecialRoomNum(long specialRoomNum) {
		this.specialRoomNum = specialRoomNum;
	}

	public HotelStockStatusEnum getStatus() {
		return status;
	}

	public void setStatus(HotelStockStatusEnum status) {
		this.status = status;
	}

	public Money getExecPrice() {
		return execPrice;
	}

	public void setExecPrice(Money execPrice) {
		this.execPrice = execPrice;
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

	@Override
	public String toString() {
		return "HotelStockInfoOrder{" +
				"id=" + id +
				", productId=" + productId +
				", productName='" + productName + '\'' +
				", supplierId=" + supplierId +
				", priceDate=" + priceDate +
				", productPrice=" + productPrice +
				", marketPrice=" + marketPrice +
				", execPrice=" + execPrice +
				", specialRoomPrice=" + specialRoomPrice +
				", morningRoomPrice=" + morningRoomPrice +
				", inStock=" + inStock +
				", availableStock=" + availableStock +
				", ordainNum=" + ordainNum +
				", morningRoomTotalNum=" + morningRoomTotalNum +
				", morningRoomNum=" + morningRoomNum +
				", specialRoomTotalNum=" + specialRoomTotalNum +
				", specialRoomNum=" + specialRoomNum +
				", status=" + status +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				'}';
	}
}
