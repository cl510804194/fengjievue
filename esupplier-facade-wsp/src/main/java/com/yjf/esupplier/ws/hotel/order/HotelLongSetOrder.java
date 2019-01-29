package com.yjf.esupplier.ws.hotel.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.hotel.enums.HotelRuleTypeEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.info.HotelLongDetailInfo;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 
 * 
 * 
 * @author zhouwei
 * 
 */
public class HotelLongSetOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -6044652682312045857L;
	
	private long supplierId;
	
	private long productId;
	
	/** 景区中心主键ID */
	private long scenicKeyId;

	/** 房间类型 */
	private HotelTypeEnum type = HotelTypeEnum.LONGRENT;
	
	/** 有效开始日期 */
	private Date beginDate;
	
	/** 有效结束日期 */
	private Date endDate;
	
	/** 定价规则 */
	private HotelRuleTypeEnum ruleType;
	
	/** 房间数量 */
	private long roomNum;
	
	/** 折扣明细 */
	private List<HotelLongDetailInfo> hotelLongDetailInfos;
	

	@Override
	public void check() {
		validateHasZore(supplierId, "商户ID");
		validateHasZore(productId, "房间ID");
		validateNotNull(ruleType, "定价规则");
	}

	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public HotelTypeEnum getType() {
		return type;
	}
	
	public void setType(HotelTypeEnum type) {
		this.type = type;
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
	
	public HotelRuleTypeEnum getRuleType() {
		return ruleType;
	}
	
	public void setRuleType(HotelRuleTypeEnum ruleType) {
		this.ruleType = ruleType;
	}
	
	public long getRoomNum() {
		return roomNum;
	}
	
	public void setRoomNum(long roomNum) {
		this.roomNum = roomNum;
	}
	
	public List<HotelLongDetailInfo> getHotelLongDetailInfos() {
		return hotelLongDetailInfos;
	}
	
	public void setHotelLongDetailInfos(List<HotelLongDetailInfo> hotelLongDetailInfos) {
		this.hotelLongDetailInfos = hotelLongDetailInfos;
	}

	public long getScenicKeyId() {
		return scenicKeyId;
	}
	
	public void setScenicKeyId(long scenicKeyId) {
		this.scenicKeyId = scenicKeyId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelLongSetOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", scenicKeyId=");
		builder.append(scenicKeyId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", ruleType=");
		builder.append(ruleType);
		builder.append(", roomNum=");
		builder.append(roomNum);
		builder.append(", hotelLongDetailInfos=");
		builder.append(hotelLongDetailInfos);
		builder.append("]");
		return builder.toString();
	}

}
