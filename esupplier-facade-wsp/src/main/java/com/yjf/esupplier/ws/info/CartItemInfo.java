package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.enums.IsBuyEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.product.enums.PostFeeTypeEnum;
import com.yjf.esupplier.ws.product.info.DeliveryInfo;

public class CartItemInfo implements Serializable {
	private static final long serialVersionUID = 3091606023920017205L;
	private long productId; // 商品编号(*)
	private long supplierId; // 供应商编号(*)
	private long quantity; // 数量(*)
	private String name; // 商品名称
	private String image; // 图片路径
	private Money price = new Money(); // 价格
	private Money priceOriginal = new Money(); // 原有价格
	private String supplierName; // 供应商名称
	private String unit; // 计价单位
	private Integer postType; // 运费说明 cl 2010-07-20 add
	private String htmlPath;
	private String viewDimensions1;//商品维度
	private String viewDimensions2;//商品维度
	private String viewDimensions3;//商品维度
	private String viewDimensions4;//商品维度
	private String priceType = "0"; //设置标示符，判断是活动价还是商场价
	private Integer activityId;//活动ID  
	private DeliveryInfo deliveryInfo;
	private Date beginTime;//入住日期
	private Date endTime;//离店日期
	private long days = 0;//入住天数
	private HotelTypeEnum roomType;//房间


	/**
	 * 是否为购买商品
	 */
	private IsBuyEnum isBuy = IsBuyEnum.YES;
	
	public String getAllDimensions() {
		return StringUtil.defaultIfEmpty(viewDimensions1)
				+ StringUtil.defaultIfEmpty(viewDimensions2)
				+ StringUtil.defaultIfEmpty(viewDimensions3)
				+ StringUtil.defaultIfEmpty(viewDimensions4);
	}
	
	public CartItemInfo(Long productId, Long supplierId, long quantity) {
		this.productId = productId;
		this.supplierId = supplierId;
		this.quantity = quantity;
	}
	
	public CartItemInfo() {
	}
	
	/**
	 * 克隆本项目
	 */
	
	@Override
	public CartItemInfo clone() {
		return new CartItemInfo(productId, supplierId, quantity);
	}
	
	public Money getTotalAmount() {
		long numDays = days<1?1:days;
		if (deliveryInfo == null)
			return price.multiply(quantity).multiply(numDays);
		else if (postType == PostFeeTypeEnum.BUYER.getDbValue()) {
			return price.multiply(quantity).multiply(numDays).add(deliveryInfo.getExpress());
		} else
			return price.multiply(quantity).multiply(numDays);
	}
	
	public Money getTotalAmountNoShipment() {
		long numDays = days<1?1:days;
		return price.multiply(quantity).multiply(numDays);
	}
	
	public Integer getActivityId() {
		return activityId;
	}
	
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	public String getPriceType() {
		return priceType;
	}
	
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Money getPrice() {
		return price;
	}
	
	public void setPrice(Money price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Money getPriceOriginal() {
		return priceOriginal;
	}
	
	public void setPriceOriginal(Money priceOriginal) {
		this.priceOriginal = priceOriginal;
	}
	
	public Integer getPostType() {
		return postType;
	}
	
	public void setPostType(Integer postType) {
		this.postType = postType;
	}
	
	public String getHtmlPath() {
		return htmlPath;
	}
	
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	
	public String getViewDimensions1() {
		return this.viewDimensions1;
	}
	
	public void setViewDimensions1(String viewDimensions1) {
		this.viewDimensions1 = viewDimensions1;
	}
	
	public String getViewDimensions2() {
		return this.viewDimensions2;
	}
	
	public void setViewDimensions2(String viewDimensions2) {
		this.viewDimensions2 = viewDimensions2;
	}
	
	public String getViewDimensions3() {
		return this.viewDimensions3;
	}
	
	public void setViewDimensions3(String viewDimensions3) {
		this.viewDimensions3 = viewDimensions3;
	}
	
	public String getViewDimensions4() {
		return this.viewDimensions4;
	}
	
	public void setViewDimensions4(String viewDimensions4) {
		this.viewDimensions4 = viewDimensions4;
	}
	
	public DeliveryInfo getDeliveryInfo() {
		return this.deliveryInfo;
	}
	
	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	
	public IsBuyEnum getIsBuy() {
		return isBuy;
	}
	
	public void setIsBuy(IsBuyEnum isBuy) {
		this.isBuy = isBuy;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public long getDays() {
		return days;
	}

	public void setDays(long days) {
		this.days = days;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public HotelTypeEnum getRoomType() {
		return roomType;
	}

	public void setRoomType(HotelTypeEnum roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("CartItemInfo{");
		sb.append("productId=").append(productId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", quantity=").append(quantity);
		sb.append(", name='").append(name).append('\'');
		sb.append(", image='").append(image).append('\'');
		sb.append(", price=").append(price);
		sb.append(", priceOriginal=").append(priceOriginal);
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append(", unit='").append(unit).append('\'');
		sb.append(", postType=").append(postType);
		sb.append(", htmlPath='").append(htmlPath).append('\'');
		sb.append(", viewDimensions1='").append(viewDimensions1).append('\'');
		sb.append(", viewDimensions2='").append(viewDimensions2).append('\'');
		sb.append(", viewDimensions3='").append(viewDimensions3).append('\'');
		sb.append(", viewDimensions4='").append(viewDimensions4).append('\'');
		sb.append(", priceType='").append(priceType).append('\'');
		sb.append(", activityId=").append(activityId);
		sb.append(", deliveryInfo=").append(deliveryInfo);
		sb.append(", beginTime=").append(beginTime);
		sb.append(", endTime=").append(endTime);
		sb.append(", days=").append(days);
		sb.append(", roomType=").append(roomType);
		sb.append(", isBuy=").append(isBuy);
		sb.append('}');
		return sb.toString();
	}


}
