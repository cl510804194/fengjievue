package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by zjialin@yiji.com on 2014/4/15.
 */
public class SignOrder extends ValidateOrderBase implements Order {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -780880051975183789L;

    /**
     * 会员号
     */
    @NotEmpty
    @Size(min = 20, max = 32, message = "会员号为20-32字节")
    private String userId;

    /**
     * 银联商户号
     */
    private String unionBusinessNo = "easy_trade-yxyt";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUnionBusinessNo() {
        return unionBusinessNo;
    }

    public void setUnionBusinessNo(String unionBusinessNo) {
        this.unionBusinessNo = unionBusinessNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
