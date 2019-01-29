package com.yjf.esupplier.integration.openapi.order;

import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * Created by zjialin@yiji.com on 2014/4/15.
 */
public class QuerySignBankOrder extends ValidateOrderBase implements Order {
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1975280762950326569L;
	
	/**
	 * 用户号
	 */
	@NotEmpty
	@Size(min = 20, max = 32, message = "会员号为20-32字节")
	private String userId;
	
	/**
	 * 商户号
	 */
	private String upUserNo;
	
	/**
	 * 状态
	 */
	private String afterStatus;
	/**
	 * 银联业务号
	 * @return
	 */
	private String unionBusinessNo;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUpUserNo() {
		return upUserNo;
	}
	
	public void setUpUserNo(String upUserNo) {
		this.upUserNo = upUserNo;
	}
	
	public String getAfterStatus() {
		return afterStatus;
	}
	
	public void setAfterStatus(String afterStatus) {
		this.afterStatus = afterStatus;
	}
	
	public String getUnionBusinessNo() {
		return this.unionBusinessNo;
	}
	
	public void setUnionBusinessNo(String unionBusinessNo) {
		this.unionBusinessNo = unionBusinessNo;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
