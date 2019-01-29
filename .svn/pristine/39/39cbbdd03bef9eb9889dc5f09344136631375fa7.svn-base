
package com.yjf.esupplier.ws.gifamount.enums;

import java.util.ArrayList;
import java.util.List;


public enum GiftMoneyTradeTypeEnum {
    ORIGINAL("ORIGINAL", "领取"),
    BACK("BACK", "退回"),
    USED("USED", "使用");



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
    private GiftMoneyTradeTypeEnum(String code, String message) {
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
    public static GiftMoneyTradeTypeEnum getByCode(String code) {
        for (GiftMoneyTradeTypeEnum _enum : values()) {
            if (_enum.code().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    public static GiftMoneyTradeTypeEnum getByMessage(String message) {
        for (GiftMoneyTradeTypeEnum _enum : values()) {
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
    public static List<GiftMoneyTradeTypeEnum> getAllEnum() {
        List<GiftMoneyTradeTypeEnum> list = new ArrayList<GiftMoneyTradeTypeEnum>();
        for (GiftMoneyTradeTypeEnum _enum : values()) {
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
        for (GiftMoneyTradeTypeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }
}
