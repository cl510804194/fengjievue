package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename UserStateEnum.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-6-8</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum CollectionStateEnum {

	COLLECT("COLLECT", "攻略收藏"),
	AGREE("AGREE", "攻略点赞"),
	PRODUCT_COL("PRODUCT_COL", "商品收藏"),
	SERVICE_COL("SERVICE_COL", "服务收藏"),
	HOTEL_COL("HOTEL_COL", "酒店收藏"),
	SUPPLIER_COL("SUPPLIER_COL", "商户收藏");
	
	private final String code;
	private final String message;
	
	private CollectionStateEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
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
	 * @return LogResultEnum
	 */
	public static CollectionStateEnum getByCode(String code) {
		for (CollectionStateEnum _enum : values()) {
			if (_enum.getCode().equalsIgnoreCase(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LogResultEnum>
	 */
	public List<CollectionStateEnum> getAllEnum() {
		List<CollectionStateEnum> list = new ArrayList<CollectionStateEnum>();
		for (CollectionStateEnum _enum : values()) {
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
		for (CollectionStateEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
}
