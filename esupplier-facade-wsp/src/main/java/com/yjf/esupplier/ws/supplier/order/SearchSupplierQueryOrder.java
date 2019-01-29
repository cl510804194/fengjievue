package com.yjf.esupplier.ws.supplier.order;

import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;
import com.yjf.esupplier.ws.supplier.enums.SupplierApproveStateEnum;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;
import com.yjf.esupplier.ws.supplier.enums.VouchStateEnum;

public class SearchSupplierQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = -8568200186246940233L;
	long supplierId;
	String realName;
	
	String nickname;
	String searchName;
	String supplierType; // 供应商类型1 单位2个人
	
	SupplierApproveStateEnum approveState; // 审核状态
	
	private VouchStateEnum vouchState; // 担保状态
	
	private SupplierRunStateEnum runState; //运营状态
	
	/** 是否支持点餐 */
	private BooleanEnum orderMeal;
	/** 是否支持酒店预订 */
	private BooleanEnum hotels;
	
	/** 是否支持团购 */
	private BooleanEnum o2o;

	private String promiseState; //供应商诚信承诺状态
	
	Date beginDate;
	
	Date endDate;
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSearchName() {
		return this.searchName;
	}
	
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	public String getSupplierType() {
		return this.supplierType;
	}
	
	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}
	
	public SupplierApproveStateEnum getApproveState() {
		return this.approveState;
	}
	
	public void setApproveState(SupplierApproveStateEnum approveState) {
		this.approveState = approveState;
	}
	
	public VouchStateEnum getVouchState() {
		return this.vouchState;
	}
	
	public void setVouchState(VouchStateEnum vouchState) {
		this.vouchState = vouchState;
	}
	
	public SupplierRunStateEnum getRunState() {
		return this.runState;
	}
	
	public void setRunState(SupplierRunStateEnum runState) {
		this.runState = runState;
	}
	
	public String getPromiseState() {
		return this.promiseState;
	}
	
	public void setPromiseState(String promiseState) {
		this.promiseState = promiseState;
	}
	
	public Date getBeginDate() {
		return this.beginDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public BooleanEnum getOrderMeal() {
		return orderMeal;
	}
	
	public void setOrderMeal(BooleanEnum orderMeal) {
		this.orderMeal = orderMeal;
	}
	
	public BooleanEnum getHotels() {
		return hotels;
	}
	
	public void setHotels(BooleanEnum hotels) {
		this.hotels = hotels;
	}
	
	public BooleanEnum getO2o() {
		return o2o;
	}
	
	public void setO2o(BooleanEnum o2o) {
		this.o2o = o2o;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchSupplierQueryOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", searchName=");
		builder.append(searchName);
		builder.append(", supplierType=");
		builder.append(supplierType);
		builder.append(", approveState=");
		builder.append(approveState);
		builder.append(", vouchState=");
		builder.append(vouchState);
		builder.append(", runState=");
		builder.append(runState);
		builder.append(", orderMeal=");
		builder.append(orderMeal);
		builder.append(", hotels=");
		builder.append(hotels);
		builder.append(", o2o=");
		builder.append(o2o);
		builder.append(", promiseState=");
		builder.append(promiseState);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}

	

}
