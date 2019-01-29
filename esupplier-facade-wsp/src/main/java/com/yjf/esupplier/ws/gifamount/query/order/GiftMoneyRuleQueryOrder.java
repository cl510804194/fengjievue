package com.yjf.esupplier.ws.gifamount.query.order;


import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class GiftMoneyRuleQueryOrder extends QueryPageBase {
    private static final long serialVersionUID = 4637443397492729265L;
    private long giftId;

    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }
}
