package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.product.info.ProductInfo;

public class CommentProductInfo implements Serializable {
	
	private static final long serialVersionUID = 7403992920097432401L;
	private Long id;
	private Long productId;
	private String clientIp;
	private String score;
	private String commentCont;
	private Long memberId;
	private String ssoAccount;
	private Date createTime;
	private Long OrderId;
	
	private ProductInfo getProduct;
	
	public ProductInfo getGetProduct() {
		return getProduct;
	}
	
	public void setGetProduct(ProductInfo getProduct) {
		this.getProduct = getProduct;
	}
	
	public Long getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getClientIp() {
		return clientIp;
	}
	
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getCommentCont() {
		return commentCont;
	}
	
	public void setCommentCont(String commentCont) {
		this.commentCont = commentCont;
	}
	
	public Long getMemberId() {
		return memberId;
	}
	
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	public String getSsoAccount() {
		return ssoAccount;
	}
	
	public void setSsoAccount(String ssoAccount) {
		this.ssoAccount = ssoAccount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommentProductDO [id=");
		builder.append(id);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", clientIp=");
		builder.append(clientIp);
		builder.append(", score=");
		builder.append(score);
		builder.append(", commentCont=");
		builder.append(commentCont);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", ssoAccount=");
		builder.append(ssoAccount);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", OrderId=");
		builder.append(OrderId);
		builder.append(", getProduct=");
		builder.append(getProduct);
		builder.append("]");
		return builder.toString();
	}
}
