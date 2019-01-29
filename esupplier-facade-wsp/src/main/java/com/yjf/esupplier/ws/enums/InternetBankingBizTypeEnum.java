package com.yjf.esupplier.ws.enums;

/**
 * 互联网金融类型
 * 
 * 
 * @author qch
 * 
 */
public enum InternetBankingBizTypeEnum {
	/**
	 * 债权(P2P)
	 */
	CLAIMS_RAISE("CLAIMS_RAISE", "债权", true, true),


	/**
	 * 产权纵筹
	 */
	EQUITY_RAISE("EQUITY_RAISE", "产权众筹", false, true),
	/**
	 * 产品纵筹
	 */
	PRODUCT_RAISE("PRODUCT_RAISE", "产品众筹", false, false),
	/**
	 * （活动募资）如一元购
	 */
	ACTIVITIES_RAISE("ACTIVITIES_RAISE", "活动募资", false, false),

    PROJECT_RAISE("PROJECT_RAISE", "项目众筹", false, false),

    HOUSE_RAISE("HOUSE_RAISE", "房产众筹", false, true),
    ENTREPRENEURSHIP_RAISE("ENTREPRENEURSHIP_RAISE","创业众筹",false,false),
    LOVING_HEART_RAISE("LOVING_HEART_RAISE","爱心众筹",false,false),
    DREAMING_RAISE("DREAMING_RAISE","梦想众筹",false,false),
    CULTURE_RAISE("CULTURE_RAISE","文化众筹",false,false),
    ONE_YUAN_RAISE("ONE_YUAN_RAISE","一元众筹",false,false),
    MOVIE_RAISE("MOVIE_RAISE","电影众筹",false,true),
    TOURISM_RAISE("TOURISM_RAISE","旅游众筹",false,false);



	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	
	/** 枚举描述 */
	private final boolean isRepayPrincipal;
	/** 枚举描述 */
	private final boolean isRepayProfit;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private InternetBankingBizTypeEnum(String code, String message, boolean isRepayPrincipal,
										boolean isRepayProfit) {
		this.code = code;
		this.message = message;
		this.isRepayPrincipal = isRepayPrincipal;
		this.isRepayProfit = isRepayProfit;
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
	
	public boolean isRepayPrincipal() {
		return this.isRepayPrincipal;
	}
	
	public boolean isRepayProfit() {
		return this.isRepayProfit;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return InternetBankingBizTypeEnum
	 */
	public static InternetBankingBizTypeEnum getByCode(String code) {
		for (InternetBankingBizTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<InternetBankingBizTypeEnum>
	 */
	public static java.util.List<InternetBankingBizTypeEnum> getAllEnum() {
		java.util.List<InternetBankingBizTypeEnum> list = new java.util.ArrayList<InternetBankingBizTypeEnum>(
			values().length);
		for (InternetBankingBizTypeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public static java.util.List<String> getAllEnumCode() {
		java.util.List<String> list = new java.util.ArrayList<String>(values().length);
		for (InternetBankingBizTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 通过code获取msg
	 * @param code 枚举值
	 * @return
	 */
	public static String getMsgByCode(String code) {
		if (code == null) {
			return null;
		}
		InternetBankingBizTypeEnum _enum = getByCode(code);
		if (_enum == null) {
			return null;
		}
		return _enum.getMessage();
	}
	
	/**
	 * 获取枚举code
	 * @param _enum
	 * @return
	 */
	public static String getCode(InternetBankingBizTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
