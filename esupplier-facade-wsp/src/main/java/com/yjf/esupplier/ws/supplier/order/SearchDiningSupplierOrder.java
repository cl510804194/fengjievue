package com.yjf.esupplier.ws.supplier.order;

import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.MerchantTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;
import com.yjf.esupplier.ws.supplier.enums.SupplierApproveStateEnum;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;
import com.yjf.esupplier.ws.supplier.enums.VouchStateEnum;

public class SearchDiningSupplierOrder extends QueryPageBase {
	private static final long serialVersionUID = -8568200186246940233L;
	long supplierId;
	
	/** 点餐商户ID(用户用餐地址) */
	long diningSupplierId;
	
	/** 是否查询点餐商户自己 */
	private BooleanEnum loadSelf = BooleanEnum.NO;
	
	/** 点餐商户类别 */
	private String diningSupplierType;

	long belongTo;
	
	/** 商户名称 */
	String supplierName;
	
	MerchantStateEnum merchantStateEnum;
	
	MerchantTypeEnum merchantTypeEnum;

	String supplierType; // 供应商类型1 单位2个人
	
	SupplierApproveStateEnum approveState; // 审核状态
	
	private VouchStateEnum vouchState; // 担保状态
	
	private SupplierRunStateEnum runState; //运营状态
	
	private SupplierRunStateEnum diningRunState; //运营状态

	/** 是否支持点餐 */
	private BooleanEnum orderMeal;
	/** 是否支持酒店预订 */
	private BooleanEnum hotels;
	
	/** 是否支持团购 */
	private BooleanEnum o2o;

	private String promiseState; //供应商诚信承诺状态
	

	/*用户经纬度*/
	/*经度*/
	private String longitude;
	/*维度*/
	private String latitude;

	Date beginDate;
	
	Date endDate;
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
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

	public long getDiningSupplierId() {
		return diningSupplierId;
	}
	
	public void setDiningSupplierId(long diningSupplierId) {
		this.diningSupplierId = diningSupplierId;
	}
	
	public BooleanEnum getLoadSelf() {
		return loadSelf;
	}
	
	public void setLoadSelf(BooleanEnum loadSelf) {
		this.loadSelf = loadSelf;
	}
	
	public long getBelongTo() {
		return belongTo;
	}
	
	public void setBelongTo(long belongTo) {
		this.belongTo = belongTo;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public MerchantStateEnum getMerchantStateEnum() {
		return merchantStateEnum;
	}
	
	public void setMerchantStateEnum(MerchantStateEnum merchantStateEnum) {
		this.merchantStateEnum = merchantStateEnum;
	}
	
	public MerchantTypeEnum getMerchantTypeEnum() {
		return merchantTypeEnum;
	}
	
	public void setMerchantTypeEnum(MerchantTypeEnum merchantTypeEnum) {
		this.merchantTypeEnum = merchantTypeEnum;
	}

	public String getDiningSupplierType() {
		return diningSupplierType;
	}

	public void setDiningSupplierType(String diningSupplierType) {
		this.diningSupplierType = diningSupplierType;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public SupplierRunStateEnum getDiningRunState() {
		return diningRunState;
	}
	
	public void setDiningRunState(SupplierRunStateEnum diningRunState) {
		this.diningRunState = diningRunState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchDiningSupplierOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", diningSupplierId=");
		builder.append(diningSupplierId);
		builder.append(", loadSelf=");
		builder.append(loadSelf);
		builder.append(", diningSupplierType=");
		builder.append(diningSupplierType);
		builder.append(", belongTo=");
		builder.append(belongTo);
		builder.append(", supplierName=");
		builder.append(supplierName);
		builder.append(", merchantStateEnum=");
		builder.append(merchantStateEnum);
		builder.append(", merchantTypeEnum=");
		builder.append(merchantTypeEnum);
		builder.append(", supplierType=");
		builder.append(supplierType);
		builder.append(", approveState=");
		builder.append(approveState);
		builder.append(", vouchState=");
		builder.append(vouchState);
		builder.append(", runState=");
		builder.append(runState);
		builder.append(", diningRunState=");
		builder.append(diningRunState);
		builder.append(", orderMeal=");
		builder.append(orderMeal);
		builder.append(", hotels=");
		builder.append(hotels);
		builder.append(", o2o=");
		builder.append(o2o);
		builder.append(", promiseState=");
		builder.append(promiseState);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}



}
