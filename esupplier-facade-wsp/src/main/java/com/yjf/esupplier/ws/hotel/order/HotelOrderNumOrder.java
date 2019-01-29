package com.yjf.esupplier.ws.hotel.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.info.HotelStockInfo;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

import java.util.Date;
import java.util.List;

public class HotelOrderNumOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -5736929542761119013L;
	private long id;
	/*房型id*/
	private long productId;
	/*开始日期*/
	private Date beginDate;
	/*结束日期*/
	private Date endDate;
	/*用户预订数量*/
	private long checkNum;
	/*房间类型*/
	private HotelTypeEnum hotelTypeEnum;

	List<HotelStockInfo> stockInfoList;
	
	@Override
	public void check() {
		validateHasZore(productId, "产品ID");
		validateNotNull(beginDate, "开始日期");
		validateNotNull(endDate, "结束日期");
		validateGreaterThanEqualZero(checkNum, "用户预订数量");
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
	
	public long getCheckNum() {
		return checkNum;
	}
	
	public void setCheckNum(long checkNum) {
		this.checkNum = checkNum;
	}

	public HotelTypeEnum getHotelTypeEnum() {
		return hotelTypeEnum;
	}

	public void setHotelTypeEnum(HotelTypeEnum hotelTypeEnum) {
		this.hotelTypeEnum = hotelTypeEnum;
	}

	public List<HotelStockInfo> getStockInfoList() {
		return stockInfoList;
	}

	public void setStockInfoList(List<HotelStockInfo> stockInfoList) {
		this.stockInfoList = stockInfoList;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("HotelOrderNumOrder{");
		sb.append("id=").append(id);
		sb.append(", productId=").append(productId);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", checkNum=").append(checkNum);
		sb.append(", hotelTypeEnum=").append(hotelTypeEnum);
		sb.append(", stockInfoList=").append(stockInfoList);
		sb.append('}');
		return sb.toString();
	}
}
