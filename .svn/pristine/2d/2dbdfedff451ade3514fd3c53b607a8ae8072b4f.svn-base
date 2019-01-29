package com.yjf.esupplier.ws.gifamount.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;

/**
 * Created by min on 2014/11/17.
 */
public class GiftMoneyBalanceData implements Serializable {
    private static final long serialVersionUID = -1959675690855962285L;
    /**优惠券余额Id */
    protected long giftBalanceId;
    /**优惠券余额 */
    protected Money balanceAmount = new Money(0, 0);
    /**y用户 */
    protected long userid;
    /**用户名 */
    protected String username;
    /**体验金 */
    protected Money experienceAmount = new Money(0, 0);
    /**   */
    protected String type;
    /**添加时间 */
    protected Date rawAddTime;
    /**更新时间 */
    protected Date rawUpdateTime;

    public long getGiftBalanceId() {
        return giftBalanceId;
    }

    public void setGiftBalanceId(long giftBalanceId) {
        this.giftBalanceId = giftBalanceId;
    }

    public Money getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Money balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Money getExperienceAmount() {
        return experienceAmount;
    }

    public void setExperienceAmount(Money experienceAmount) {
        this.experienceAmount = experienceAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getRawAddTime() {
        return rawAddTime;
    }

    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GiftMoneyBalanceData{");
        sb.append("giftBalanceId=").append(giftBalanceId);
        sb.append(", balanceAmount=").append(balanceAmount);
        sb.append(", userid=").append(userid);
        sb.append(", username='").append(username).append('\'');
        sb.append(", experienceAmount=").append(experienceAmount);
        sb.append(", type='").append(type).append('\'');
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append('}');
        return sb.toString();
    }
}
