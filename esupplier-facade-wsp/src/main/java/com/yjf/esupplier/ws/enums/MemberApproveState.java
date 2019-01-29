package com.yjf.esupplier.ws.enums;

public enum MemberApproveState {
	None("None", "未知", "/do/member/need_apply.htm"), // 未知
	Register("None", "注册", "/do/member/need_apply.htm"), // 注册
	MailVerify("MailVerify", "邮件验证", "/do/member/member_mailverify.htm"), // 邮件验证
	ManualVerify("ManualVerify", "人工审核", "/do/member/member_others.htm"), // 人工审核
	Rejected("Rejected", "已被拒绝", "/do/supplier/updateSupplier.htm"), // 已被拒绝
	Completed("Completed", "已经完成", "/do/supplier/updateSupplier.htm");
	// 已经完成;
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;
	/** 枚举描述 */
	private final String url;
	
	/**
	 * 
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	private MemberApproveState(String code, String message, String url) {
		this.code = code;
		this.message = message;
		this.url = url;
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
	
	public String getUrl() {
		return this.url;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return MemberApproveState
	 */
	public static MemberApproveState getByCode(String code) {
		for (MemberApproveState _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<MemberApproveState>
	 */
	public static java.util.List<MemberApproveState> getAllEnum() {
		java.util.List<MemberApproveState> list = new java.util.ArrayList<MemberApproveState>(
			values().length);
		for (MemberApproveState _enum : values()) {
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
		for (MemberApproveState _enum : values()) {
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
		MemberApproveState _enum = getByCode(code);
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
	public static String getCode(MemberApproveState _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
