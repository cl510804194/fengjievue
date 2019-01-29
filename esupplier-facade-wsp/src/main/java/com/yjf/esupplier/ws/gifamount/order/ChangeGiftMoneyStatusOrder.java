package com.yjf.esupplier.ws.gifamount.order;

import java.util.Date;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class ChangeGiftMoneyStatusOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = 4040138065638024544L;
	
	protected long giftId;
	
	protected String status;
	
	protected long createUserid;
	
	protected String createUsername;
	
	protected Date updateRowDate;
	
	@Override
	public void check() {
		this.validateHasZore(giftId, "红包ID");
		this.validateHasText(status, "红包状态");
		this.validateHasZore(createUserid, "用户ID");
		this.validateHasText(createUsername, "用户名");
	}
	
	public long getGiftId() {
		return giftId;
	}
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getCreateUserid() {
		return createUserid;
	}
	
	public void setCreateUserid(long createUserid) {
		this.createUserid = createUserid;
	}
	
	public String getCreateUsername() {
		return createUsername;
	}
	
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	
	public Date getUpdateRowDate() {
		return updateRowDate;
	}
	
	public void setUpdateRowDate(Date updateRowDate) {
		this.updateRowDate = updateRowDate;
	}
}
