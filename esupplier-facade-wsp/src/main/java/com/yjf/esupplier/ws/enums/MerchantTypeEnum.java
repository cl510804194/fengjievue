package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public enum MerchantTypeEnum {
	
	LEISURE("LEISURE", "休闲娱乐",false),
	
	SERVICE("SERVICE", "生活服务",false),
	
	HOSPITAL("HOSPITAL", "酒店",true),

	HOSTEL("HOSTEL", "民宿",true),

	INN("INN", "客栈",true),

	TRAVEL("TRAVEL", "旅游",false),
	
	FOOD("FOOD", "美食",false);
	
	private final String code;
	private final String message;
	private final boolean hotel;

	private MerchantTypeEnum(String code, String message,boolean hotel) {
		this.code = code;
		this.message = message;
		this.hotel = hotel;
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

	public boolean isHotel() {
		return hotel;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return LogResultEnum
	 */
	public static MerchantTypeEnum getByCode(String code) {
		for (MerchantTypeEnum _enum : values()) {
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
	public List<MerchantTypeEnum> getAllEnum() {
		List<MerchantTypeEnum> list = new ArrayList<MerchantTypeEnum>();
		for (MerchantTypeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}

	/**
	 * 获取全部枚举值
	 *
	 * @return List<String>
	 */
	public static List<Map<String, String>> getAllEnumList(boolean isAll,boolean hotel) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>(values().length);
		for (MerchantTypeEnum _enum : values()) {
			Map<String, String> map = new HashMap<String, String>();
			if(!isAll&&hotel&&!_enum.isHotel()) continue;
			if(!isAll&&!hotel&&!_enum.isHotel()) continue;
			map.put("code",_enum.code());
			map.put("name",_enum.getMessage());
			list.add(map);
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
		for (MerchantTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
}
