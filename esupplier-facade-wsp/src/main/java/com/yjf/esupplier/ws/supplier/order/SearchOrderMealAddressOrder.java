package com.yjf.esupplier.ws.supplier.order;

import java.util.List;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

/**
 * 
 * 
 * 点餐地址查询
 * @author zhouwei
 * 
 */
public class SearchOrderMealAddressOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 4242622692499991384L;
	
	/** 商户名称 */
	private String storeName;

	/*用户经纬度*/
	/** 经度 */
	private String longitude;
	/** 维度 */
	private String latitude;
	
	/** 已被点餐商户ID */
	private List<Long> choseList;
	
	private long defaultAddressId;

	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
	
	public List<Long> getChoseList() {
		return choseList;
	}
	
	public void setChoseList(List<Long> choseList) {
		this.choseList = choseList;
	}
	
	public long getDefaultAddressId() {
		return defaultAddressId;
	}

	public void setDefaultAddressId(long defaultAddressId) {
		this.defaultAddressId = defaultAddressId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchOrderMealAddressOrder [storeName=");
		builder.append(storeName);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", choseList=");
		builder.append(choseList);
		builder.append(", defaultAddressId=");
		builder.append(defaultAddressId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}


}
