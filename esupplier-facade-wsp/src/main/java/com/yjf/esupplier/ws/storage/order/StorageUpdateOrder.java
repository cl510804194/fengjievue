package com.yjf.esupplier.ws.storage.order;

import java.util.Date;
import java.util.List;

import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.storage.enums.StorageBillTypeEnum;
import com.yjf.esupplier.ws.storage.enums.StorageChangeEnum;
import com.yjf.esupplier.ws.storage.info.StorageInOutDetailInfo;

public class StorageUpdateOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -8980456109159211406L;
	long productId;
	long stockAmount;
	long supplierId;
	StorageBillTypeEnum storageBillTypeEnum;
	String unit;
	String billNo;
	Date billTime;
	List<StorageInOutDetailInfo> detailInfos;
	
	@Override
	public void check() {
		
		validateNotNull(storageBillTypeEnum, "库存变更方式");
		if (storageBillTypeEnum.getChangeEnum() == StorageChangeEnum.ADD
			|| storageBillTypeEnum.getChangeEnum() == StorageChangeEnum.REMOVE) {
			if (ListUtil.isEmpty(detailInfos)) {
				validateHasZore(stockAmount, "库存量");
			}
			
		}
		validateHasZore(supplierId, "供应商");
		if (ListUtil.isEmpty(detailInfos)) {
			validateHasZore(productId, "产品");
		} else {
			for (StorageInOutDetailInfo detailInfo : detailInfos) {
				validateHasZore(detailInfo.getProductId(), "产品");
				validateHasZore(detailInfo.getBillAmount(), "产品");
			}
		}
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getStockAmount() {
		return this.stockAmount;
	}
	
	public void setStockAmount(long stockAmount) {
		this.stockAmount = stockAmount;
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public StorageBillTypeEnum getStorageBillTypeEnum() {
		return this.storageBillTypeEnum;
	}
	
	public void setStorageBillTypeEnum(StorageBillTypeEnum storageBillTypeEnum) {
		this.storageBillTypeEnum = storageBillTypeEnum;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getBillNo() {
		return this.billNo;
	}
	
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	public List<StorageInOutDetailInfo> getDetailInfos() {
		return this.detailInfos;
	}
	
	public void setDetailInfos(List<StorageInOutDetailInfo> detailInfos) {
		this.detailInfos = detailInfos;
	}
	
	public Date getBillTime() {
		return this.billTime;
	}
	
	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StorageUpdateOrder [productId=");
		builder.append(productId);
		builder.append(", stockAmount=");
		builder.append(stockAmount);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", storageBillTypeEnum=");
		builder.append(storageBillTypeEnum);
		builder.append(", unit=");
		builder.append(unit);
		builder.append(", billNo=");
		builder.append(billNo);
		builder.append("]");
		return builder.toString();
	}
	
}
