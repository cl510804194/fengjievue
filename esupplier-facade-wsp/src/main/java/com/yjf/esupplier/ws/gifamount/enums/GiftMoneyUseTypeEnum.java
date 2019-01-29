
package com.yjf.esupplier.ws.gifamount.enums;

import java.util.ArrayList;
import java.util.List;


public enum GiftMoneyUseTypeEnum {
    ONLY_INVEST("INVEST", "单笔投资满");


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
    private GiftMoneyUseTypeEnum(String code, String message) {
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
    public static GiftMoneyUseTypeEnum getByCode(String code) {
        for (GiftMoneyUseTypeEnum _enum : values()) {
            if (_enum.code().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    public static GiftMoneyUseTypeEnum getByMessage(String message) {
        for (GiftMoneyUseTypeEnum _enum : values()) {
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
    public static List<GiftMoneyUseTypeEnum> getAllEnum() {
        List<GiftMoneyUseTypeEnum> list = new ArrayList<GiftMoneyUseTypeEnum>();
        for (GiftMoneyUseTypeEnum _enum : values()) {
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
        for (GiftMoneyUseTypeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }
}
