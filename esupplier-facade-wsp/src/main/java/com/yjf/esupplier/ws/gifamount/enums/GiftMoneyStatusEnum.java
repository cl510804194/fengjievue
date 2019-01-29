
package com.yjf.esupplier.ws.gifamount.enums;

import java.util.ArrayList;
import java.util.List;


public enum GiftMoneyStatusEnum {
    STOP("STOP", "停用"),
    USED("USED","使用"),
    FINISH("FINISH", "完成"),
    GAMEOVER("GAMEOVER", "手动结束"),
    EXPIRE("EXPIRE", "过期"),
    FAILED("FAILED","失败"),
    CANCEL("CANCEL","取消"),
    NORMAL("NORMAL", "启用");



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
    private GiftMoneyStatusEnum(String code, String message) {
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
    public static GiftMoneyStatusEnum getByCode(String code) {
        for (GiftMoneyStatusEnum _enum : values()) {
            if (_enum.code().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    public static GiftMoneyStatusEnum getByMessage(String message) {
        for (GiftMoneyStatusEnum _enum : values()) {
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
    public static List<GiftMoneyStatusEnum> getAllEnum() {
        List<GiftMoneyStatusEnum> list = new ArrayList<GiftMoneyStatusEnum>();
        for (GiftMoneyStatusEnum _enum : values()) {
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
        for (GiftMoneyStatusEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }
}
