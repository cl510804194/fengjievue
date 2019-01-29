package com.yjf.esupplier.integration.openapi.result;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 2015/1/12.
 */
public class UseGiftMoneyResult extends EsupplierBaseResult {

    private static final long serialVersionUID = 776616237612261780L;

    private Money amount;

    List<GiftMoneyTradeInfo> createTrades = new ArrayList<GiftMoneyTradeInfo>();
    List<GiftMoneyTradeInfo> updateTrades = new ArrayList<GiftMoneyTradeInfo>();


    public List<GiftMoneyTradeInfo> getCreateTrades() {
        return createTrades;
    }

    public void setCreateTrades(List<GiftMoneyTradeInfo> createTrades) {
        this.createTrades = createTrades;
    }

    public List<GiftMoneyTradeInfo> getUpdateTrades() {
        return updateTrades;
    }

    public void setUpdateTrades(List<GiftMoneyTradeInfo> updateTrades) {
        this.updateTrades = updateTrades;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
