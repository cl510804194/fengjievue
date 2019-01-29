package com.yjf.esupplier.ws.hotel.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class HotelStockNumOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -5736929542761119013L;
	private long id;
	/*房型id*/
	private long scenicId;
	/*房型id*/
	private long productId;
	/*可用库存*/
	private long stockNum;
	/*可用库存*/
	private Money price = new Money(0);
	/*房间类型*/
	private HotelTypeEnum hotelTypeEnum;
	@Override
	public void check() {
		validateHasZore(id, "房间ID");
		validateHasZore(scenicId, "景区ID");
		validateGreaterThanEqualZero(stockNum, "可用房间数");
		validateGreaterThanEqualZero(price.getAmount(), "房间价格");
	}

	public long getScenicId() {
		return scenicId;
	}

	public void setScenicId(long scenicId) {
		this.scenicId = scenicId;
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

	public long getStockNum() {
		return stockNum;
	}

	public void setStockNum(long stockNum) {
		this.stockNum = stockNum;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public HotelTypeEnum getHotelTypeEnum() {
		return hotelTypeEnum;
	}

	public void setHotelTypeEnum(HotelTypeEnum hotelTypeEnum) {
		this.hotelTypeEnum = hotelTypeEnum;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("HotelStockNumOrder{");
		sb.append("id=").append(id);
		sb.append(", scenicId=").append(scenicId);
		sb.append(", productId=").append(productId);
		sb.append(", stockNum=").append(stockNum);
		sb.append(", price=").append(price);
		sb.append(", hotelTypeEnum=").append(hotelTypeEnum);
		sb.append('}');
		return sb.toString();
	}
}
