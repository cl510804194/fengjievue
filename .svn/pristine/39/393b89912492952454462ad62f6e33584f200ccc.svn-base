package com.yjf.esupplier.ws.friend.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.RecommendFriendStatusEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class UpdateRecommendFriendOrder extends ValidateOrderBase implements Order {
    private static final long serialVersionUID = 8060079402917808781L;
    private long recommendId;


    private String giftDescription;

    private String giftStatus = RecommendFriendStatusEnum.INITIAL.code();

    public long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(long recommendId) {
        this.recommendId = recommendId;
    }

    public String getGiftDescription() {
        return giftDescription;
    }

    public void setGiftDescription(String giftDescription) {
        this.giftDescription = giftDescription;
    }

    public String getGiftStatus() {
        return giftStatus;
    }

    public void setGiftStatus(String giftStatus) {
        this.giftStatus = giftStatus;
    }
}
