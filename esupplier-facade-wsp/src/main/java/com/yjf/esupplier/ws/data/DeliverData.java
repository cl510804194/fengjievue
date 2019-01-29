package com.yjf.esupplier.ws.data;

import com.yjf.esupplier.ws.enums.ReferenceAddressEnum;

import java.io.Serializable;
import java.util.Date;

public class DeliverData implements Serializable {
	private static final long serialVersionUID = -9132585124502323045L;
	
	private int deliverId;
	
	private String contractId;
	
	private long customerId;
	
	private String deliverName;
	
	private String deliverMobile;
	
	private String province;
	
	private String city;
	
	private String contry;
	
	private String deliverAddress;

    private String referenceAddress;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;

	public int getDeliverId() {
		return this.deliverId;
	}
	
	public void setDeliverId(int deliverId) {
		this.deliverId = deliverId;
	}
	
	public String getContractId() {
		return this.contractId;
	}
	
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public long getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public String getDeliverName() {
		return this.deliverName;
	}
	
	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}
	
	public String getDeliverMobile() {
		return this.deliverMobile;
	}
	
	public void setDeliverMobile(String deliverMobile) {
		this.deliverMobile = deliverMobile;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getContry() {
		return this.contry;
	}
	
	public void setContry(String contry) {
		this.contry = contry;
	}
	
	public String getDeliverAddress() {
		return this.deliverAddress;
	}
	
	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}

    public String getReferenceAddress() {
        return referenceAddress;
    }

    public void setReferenceAddress(String referenceAddress) {
        this.referenceAddress = referenceAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeliverData{");
        sb.append("deliverId=").append(deliverId);
        sb.append(", contractId='").append(contractId).append('\'');
        sb.append(", customerId=").append(customerId);
        sb.append(", deliverName='").append(deliverName).append('\'');
        sb.append(", deliverMobile='").append(deliverMobile).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", contry='").append(contry).append('\'');
        sb.append(", deliverAddress='").append(deliverAddress).append('\'');
        sb.append(", referenceAddress='").append(referenceAddress).append('\'');
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append('}');
        return sb.toString();
    }
}
