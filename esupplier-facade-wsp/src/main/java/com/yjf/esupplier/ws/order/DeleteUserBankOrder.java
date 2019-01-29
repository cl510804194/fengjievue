package com.yjf.esupplier.ws.order;

import com.yjf.esupplier.ws.enums.BooleanEnum;

public class DeleteUserBankOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -5500370537701754714L;
	long id;
	String userBaseId;
	BooleanEnum isEnforce = BooleanEnum.NO;
	
	@Override
	public void check() {
		super.check();
		validateHasText(userBaseId, "userBaseId");
		validateNotNull(isEnforce, "isEnforce");
		validateHasZore(id, "id");
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserBaseId() {
		return this.userBaseId;
	}
	
	public void setUserBaseId(String userBaseId) {
		this.userBaseId = userBaseId;
	}
	
	public BooleanEnum getIsEnforce() {
		return this.isEnforce;
	}
	
	public void setIsEnforce(BooleanEnum isEnforce) {
		this.isEnforce = isEnforce;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeleteUserBankOrder [id=");
		builder.append(id);
		builder.append(", userBaseId=");
		builder.append(userBaseId);
		builder.append(", isEnforce=");
		builder.append(isEnforce);
		builder.append("]");
		return builder.toString();
	}
	
}
