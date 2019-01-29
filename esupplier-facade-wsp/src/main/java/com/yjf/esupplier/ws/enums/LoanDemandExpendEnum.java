package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 2015/1/20.
 */
public enum LoanDemandExpendEnum {


    USE_GIFT_MONEY("USE_GIFT_MONEY", "是否使用红包"),

    GIFT_MONEY_AMOUNT("GIFT_MONEY_AMOUNT", "红包单笔限额"),

    USE_EXPERIENCE_AMOUNT("USE_EXPERIENCE_AMOUNT", "是否使用体验金"),

    GIFT_EXPERIENCE_AMOUNT("GIFT_EXPERIENCE_AMOUNT", "体验金单笔限额"),


    USE_GIFT_MONEY_RULE("USE_GIFT_MONEY_RULE", "使用红包规则"),

    USE_GIFT_MONEY_INCREASE("USE_GIFT_MONEY_INCREASE_RULE", "使用红包规则是否递增"),

    LOAN_TYPE("LOAN_TYPE", "项目信用类型"),
    PLATFORM_TYPE("PLATFORM_TYPE", "平台产品分类"),
    INVEST_ADD_AMOUNT("INVEST_ADD_AMOUNT", "递增金额"),
//  CONTRACT_TEMPLATE("CONTRACT_TEMPLATE", "合同模板"),
    INVESTMENT_INCOME("INVESTMENT INCOME","投资收益"),

    MOVIE_IMG("MOVIE_IMG","电影众筹头部图片"),

    LOAN_DEMAND_INFO_ITEM("LOAN_DEMAND_INFO_ITEM_", "融资项目信息模块");
    
    /** 枚举值 */
    private final String	code;

    /** 枚举描述 */
    private final String	message;

    /**
     * 构造一个<code>LoanBizTypeEnum</code>枚举对象
     *
     * @param code
     * @param message
     */
    private LoanDemandExpendEnum(String code, String message) {
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
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return LoanBizTypeEnum
     */
    public static LoanDemandExpendEnum getByCode(String code) {
        for (LoanDemandExpendEnum _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<LoanBizTypeEnum>
     */
    public List<LoanDemandExpendEnum> getAllEnum() {
        List<LoanDemandExpendEnum> list = new ArrayList<LoanDemandExpendEnum>();
        for (LoanDemandExpendEnum _enum : values()) {
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
        for (LoanDemandExpendEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }
}
