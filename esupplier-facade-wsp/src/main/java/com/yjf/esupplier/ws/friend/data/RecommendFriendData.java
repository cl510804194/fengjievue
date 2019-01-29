package com.yjf.esupplier.ws.friend.data;

import com.yjf.esupplier.ws.enums.RecommendFriendStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by min on 2014/11/17.
 */
public class RecommendFriendData implements Serializable {


    private long recommendId;

    private long userId;

    private String realName;

    private String userName;

    private long childId;

    private String childName;

    private String childRealName;

    private String giftDescription;

    private RecommendFriendStatusEnum giftStatus;

    private Date rawAddTime;

    private Date rawUpdateTime;

    public long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(long recommendId) {
        this.recommendId = recommendId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getChildId() {
        return childId;
    }

    public void setChildId(long childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildRealName() {
        return childRealName;
    }

    public void setChildRealName(String childRealName) {
        this.childRealName = childRealName;
    }

    public String getGiftDescription() {
        return giftDescription;
    }

    public void setGiftDescription(String giftDescription) {
        this.giftDescription = giftDescription;
    }

    public RecommendFriendStatusEnum getGiftStatus() {
        return giftStatus;
    }

    public void setGiftStatus(RecommendFriendStatusEnum giftStatus) {
        this.giftStatus = giftStatus;
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
}
