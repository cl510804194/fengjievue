package com.yjf.esupplier.ws.product.info;

import java.util.List;
import java.util.Map;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.product.data.ProductData;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

public class ProductInfo extends ProductData {
	private static final long serialVersionUID = 5125166737714469378L;
	private SupplierInfo supplierInfo;
	/*消费总数*/
    private long payedCount;
	/*商品评价总数*/
    private long commentCount;
	/*商品评价平均分*/
    private long commentAvgScore;

	/*是否推荐 1 推荐 0 不推荐*/
	private long isReComment;
	
	/*是否收藏 1 收藏 0 不收藏*/
	private long isEnshrine;

	private String city;
	
	private String province;
	
	private Money execPrice;
	
	private List<String>refundMessageList;
	
	private List<Map<String, Object>> roomList;
	
	public Money getExecPrice() {
		return execPrice;
	}

	public void setExecPrice(Money execPrice) {
		this.execPrice = execPrice;
	}

	public SupplierInfo getSupplierInfo() {
		return supplierInfo;
	}

	public void setSupplierInfo(SupplierInfo supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

	public long getPayedCount() {
		return payedCount;
	}

	public void setPayedCount(long payedCount) {
		this.payedCount = payedCount;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public long getCommentAvgScore() {
		return commentAvgScore;
	}

	public void setCommentAvgScore(long commentAvgScore) {
		this.commentAvgScore = commentAvgScore;
	}

	public long getIsReComment() {
		return isReComment;
	}

	public void setIsReComment(long isReComment) {
		this.isReComment = isReComment;
	}

	public long getIsEnshrine() {
		return isEnshrine;
	}

	public void setIsEnshrine(long isEnshrine) {
		this.isEnshrine = isEnshrine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getRecommendPrice1(){
		return super.getPrice1().toString();
	}
	
	public String getRecommendMarketPrice(){
		return super.getMarketPrice().toString();
	}

	public List<Map<String, Object>> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Map<String, Object>> roomList) {
		this.roomList = roomList;
	}

	public List<String> getRefundMessageList() {
		return refundMessageList;
	}

	public void setRefundMessageList(List<String> refundMessageList) {
		this.refundMessageList = refundMessageList;
	}
}
