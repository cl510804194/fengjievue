package com.yjf.esupplier.ws.gifamount.query.order;

import java.util.Date;
import java.util.List;

import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class GiftMoneyQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = 4637443397492729265L;
	private String giftName;
	private GiftMoneyGiveTypeEnum giveType;
	private Date currentDate;
	private GiftMoneyTypeEnum type;
	
	private String status;
	
	private List<GiftMoneyTypeEnum> typeList;
	/*交易详情id*/
	protected long tradeDetailId;

	private Date startDate;
	private Date endDate;
	private long giftId;
	
	public String getGiftName() {
		return giftName;
	}
	
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	
	public Date getCurrentDate() {
		return currentDate;
	}
	
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
	public GiftMoneyGiveTypeEnum getGiveType() {
		return giveType;
	}
	
	public void setGiveType(GiftMoneyGiveTypeEnum giveType) {
		this.giveType = giveType;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public long getGiftId() {
		return giftId;
	}
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	
	public GiftMoneyTypeEnum getType() {
		return type;
	}
	
	public void setType(GiftMoneyTypeEnum type) {
		this.type = type;
	}
	
	public List<GiftMoneyTypeEnum> getTypeList() {
		return typeList;
	}
	
	public void setTypeList(List<GiftMoneyTypeEnum> typeList) {
		this.typeList = typeList;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public long getTradeDetailId() {
		return tradeDetailId;
	}

	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}

	@Override
	public String toString() {
		return "GiftMoneyQueryOrder{" + "giftName='" + giftName + '\'' + ", giveType=" + giveType
				+ ", currentDate=" + currentDate + ", type=" + type + ", status=" + status
				+ ", typeList=" + typeList + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", giftId=" + giftId + '}';
	}
}
