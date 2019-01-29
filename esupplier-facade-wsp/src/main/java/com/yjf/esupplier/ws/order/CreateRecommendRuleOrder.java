package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.DebtTransferRuleVerEnum;
import org.springframework.util.Assert;

import java.util.Date;

public class CreateRecommendRuleOrder extends ValidateOrderBase implements Order {

    private long ruleId;

    private String ruleName;

    private String rewardObj;

    private String rewardType;

    private String amount;

    private String giveAmount;

    private String giveType;

    private Date rawAddTime;

    private Date rawUpdateTime;

    private String version;

    private String status;

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRewardObj() {
        return rewardObj;
    }

    public void setRewardObj(String rewardObj) {
        this.rewardObj = rewardObj;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGiveAmount() {
        return giveAmount;
    }

    public void setGiveAmount(String giveAmount) {
        this.giveAmount = giveAmount;
    }

    public String getGiveType() {
        return giveType;
    }

    public void setGiveType(String giveType) {
        this.giveType = giveType;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
