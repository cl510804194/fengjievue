package com.yjf.esupplier.ws.hotel.order;

import java.util.Date;

import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.info.HotelSetRefundInfo;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.userManage.enums.UserLevelEnum;

public class HotelRefundCheckOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -5736929542761119013L;
	/*会员等级*/
	private UserLevelEnum userLevelEnum;
	/*入住日期*/
	private Date inDate;
	/*房间类型*/
	private HotelTypeEnum hotelTypeEnum;
	/*退款设置详情*/
	private HotelSetRefundInfo hotelSetRefundInfo;

	@Override
	public void check() {
		validateNotNull(userLevelEnum, "会员等级");
		validateNotNull(inDate, "入住日期");
		validateNotNull(hotelTypeEnum, "房间价格类型");
		//		validateNotNull(hotelSetRefundInfo, "退款设置详情");
	}
	
	public UserLevelEnum getUserLevelEnum() {
		return userLevelEnum;
	}
	
	public void setUserLevelEnum(UserLevelEnum userLevelEnum) {
		this.userLevelEnum = userLevelEnum;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public HotelTypeEnum getHotelTypeEnum() {
		return hotelTypeEnum;
	}
	
	public void setHotelTypeEnum(HotelTypeEnum hotelTypeEnum) {
		this.hotelTypeEnum = hotelTypeEnum;
	}

	public HotelSetRefundInfo getHotelSetRefundInfo() {
		return hotelSetRefundInfo;
	}

	public void setHotelSetRefundInfo(HotelSetRefundInfo hotelSetRefundInfo) {
		this.hotelSetRefundInfo = hotelSetRefundInfo;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("HotelRefundCheckOrder{");
		sb.append("userLevelEnum=").append(userLevelEnum);
		sb.append(", inDate=").append(inDate);
		sb.append(", hotelTypeEnum=").append(hotelTypeEnum);
		sb.append(", hotelSetRefundInfo=").append(hotelSetRefundInfo);
		sb.append('}');
		return sb.toString();
	}
}
