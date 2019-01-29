
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;


public enum RecommendRuleGiveTypeEnum {
    GIFT_MONEY("GIFT_MONEY","红包"),
    EXPERIENCE_AMOUNT("EXPERIENCE_AMOUNT","体验金");

    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     *
     * @param code
     * @param message
     */
    private RecommendRuleGiveTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the code.
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String message() {
        return message;
    }

    /**
     * @param code
     * @return UserStatusEnum
     */
    public static RecommendRuleGiveTypeEnum getByCode(String code) {
        for (RecommendRuleGiveTypeEnum _enum : values()) {
            if (_enum.code().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    public static RecommendRuleGiveTypeEnum getByMessage(String message) {
        for (RecommendRuleGiveTypeEnum _enum : values()) {
            if (_enum.message().equals(message)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<UserStatusEnum>
     */
    public static List<RecommendRuleGiveTypeEnum> getAllEnum() {
        List<RecommendRuleGiveTypeEnum> list = new ArrayList<RecommendRuleGiveTypeEnum>();
        for (RecommendRuleGiveTypeEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>();
        for (RecommendRuleGiveTypeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }
}
