package com.yjf.esupplier.ws.storage.enums;

public enum StorageBillTypeEnum {
	STORAGE("STORAGE", "入库", StorageChangeEnum.ADD),
	NEW_PRODUCT("NEW_PRODUCT", "初设置", StorageChangeEnum.UPDATE),
	MODIFY_PRODUCT("MODIFY_PRODUCT", "修改产品", StorageChangeEnum.UPDATE),
	MANUAL_DELIVERY("MANUAL_DELIVERY", "手工出库", StorageChangeEnum.REMOVE),
	AOTO_SYNCHRONIZE("AOTO_SYNCHRONIZE", "自动同步库存", StorageChangeEnum.UPDATE),
	PLACE_AN_ORDER("PLACE_AN_ORDER", "下订单", StorageChangeEnum.REMOVE),
	PAYMENT_ORDER("PAYMENT_ORDER", "支付订单", StorageChangeEnum.REMOVE),
	CANCEL_ORDER("CANCEL_ORDER", "取消订单", StorageChangeEnum.REMOVE),
	/**
	 * 退款入库
	 */
	RETURN_GOODS("RETURN_GOODS", "退货入库", StorageChangeEnum.ADD),
	/**
	 * 订单出库
	 */
	ORDER_DELIVERY("ORDER_DELIVERY", "订单出库", StorageChangeEnum.REMOVE);
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/**
	 * 增加库存
	 */
	private final StorageChangeEnum changeEnum;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private StorageBillTypeEnum(String code, String message, StorageChangeEnum changeEnum) {
		this.code = code;
		this.message = message;
		this.changeEnum = changeEnum;
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
	
	public StorageChangeEnum getChangeEnum() {
		return this.changeEnum;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return StorageBillTypeEnum
	 */
	public static StorageBillTypeEnum getByCode(String code) {
		for (StorageBillTypeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<StorageBillTypeEnum>
	 */
	public static java.util.List<StorageBillTypeEnum> getAllEnum() {
		java.util.List<StorageBillTypeEnum> list = new java.util.ArrayList<StorageBillTypeEnum>(
			values().length);
		for (StorageBillTypeEnum _enum : values()) {
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
		for (StorageBillTypeEnum _enum : values()) {
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
		StorageBillTypeEnum _enum = getByCode(code);
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
	public static String getCode(StorageBillTypeEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
