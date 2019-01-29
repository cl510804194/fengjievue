
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;


public enum RecommendRuleWayTypeEnum {
    REGISTER("REGISTER", "注册"),
    AUTHENTICATION("AUTHENTICATION", "实名"),
    ONLY_INVEST("ONLY_INVEST", "投资");


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
    private RecommendRuleWayTypeEnum(String code, String message) {
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
    public static RecommendRuleWayTypeEnum getByCode(String code) {
        for (RecommendRuleWayTypeEnum _enum : values()) {
            if (_enum.code().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    public static RecommendRuleWayTypeEnum getByMessage(String message) {
        for (RecommendRuleWayTypeEnum _enum : values()) {
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
    public static List<RecommendRuleWayTypeEnum> getAllEnum() {
        List<RecommendRuleWayTypeEnum> list = new ArrayList<RecommendRuleWayTypeEnum>();
        for (RecommendRuleWayTypeEnum _enum : values()) {
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
        for (RecommendRuleWayTypeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }
}
