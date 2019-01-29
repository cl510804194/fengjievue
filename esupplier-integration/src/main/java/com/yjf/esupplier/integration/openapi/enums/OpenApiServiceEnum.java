package com.yjf.esupplier.integration.openapi.enums;

import java.util.ArrayList;
import java.util.List;

public enum OpenApiServiceEnum {
	
	DECUT_DEPOSIT_APPLY("decutDepositApply", "代扣充值申请"),
	
	APPLY_QUICK("applyQuick", "快捷申请"),
	
	QUERY_DECUT_DEPOSIT_RESULT("queryDecutDepositResult", "代扣充值结果查询"),
	
	QUCIK_SIGN_APPLY_OFF_LINE("offLineQucikSignApply", "线下快捷签约接口"),
	
	CHECK_USER_NAME_EXIST("checkUserNameExist", "检查用户名是否存在"),
	
	TRADE_PAY("tradePay", "交易付款"),
	
	TRADE_CREATE("tradeCreate", "创建交易"),
	
	USER_REGISTER("userRegister", "用户注册"),
	
	USER_LOGIN("userLogin", "用户登录"),
	
	CHANGE_PASSWORD("changePassword", "修改登录密码"),
	
	CHANGE_PAY_PASSWORD("changePayPassword", "修改支付密码"),
	
	VERIFY_PAY_PASSWORD("verifyPayPassword", "验证支付密码"),
	
	QUICK_PAY_APPLY("quickPayApply", "快捷签约申请"),
	
	QUICK_PAY_VERIFY("quickPayVerify", "快捷签约验证"),
	
	FASTPAYTRADE("fastpay", "即时到账"),
	
	FASTPAYREFUND("fastpayRefund", "即时到账有退款"),
	
	ESCROWTRADE("escowtrade", "担保交易"),
	
	DEDUCTDEPOISITAL("deductDepoisital", "代扣充值"),
	
	QUSER_REGISTER("qUserRegister", "Q用户注册"),
	
	QUERY_PAY_CHANNEL_API("queryPayChannelApi", "支付渠道查询"),
	
	SMS("sms", "短信服务"),
	
	CAPTCHA("captcha", "验证码服务"),
	
	TRADE_QUERY("tradeQuery", "单个交易查询"),
	
	USER_ACCOUNT_QUERY("userAccountQuery", "用户资金信息查询"),
	
	FAST_PAY_BATCH_TRADE("fastpayBatchTrade", "批量即时到账"),
	
	/** 跳转充值页面*/
	DEPOSIT("deposit", "跳转充值页面"),
	
	/** 跳转提现页面*/
	WITHDRAW("withdraw", "跳转提现页面"),
	
	/** 跳转激活页面*/
	ACCOUNTACTIVE("accountActive", "跳转激活页面"),
	
	/** 实名认证*/
	AUTHORIZE("authorize", "实名认证"),
	
	/** 跳转交易查询页面 */
	JUMP_TRADE_QUERY("jumpTradeQuery", "跳转交易查询"),
	
	/** 安全中心*/
	SECURITY("security", "安全中心"),
	
	/** 页面跳转*/
	NOTIFY_JUMP("notifyJump", "页面跳转"),
	
	USER_BASEINFO_QUERY("userBaseinfoQuery", "用户基本信息查询"),
	
	FORGET_PASSWORD("forgetPassword", "忘记登录密码，找回"),
	
	FORGET_PAYMENT_PASSWORD("forgetPaymentPassword", "忘记支付密码，找回"),
	
	MODIFY_USER_INFO("modifyUserInfo", "修改用户信息"),
	
	APPLY_QUICK_DEPOSIT("applyQuickDeposit", "快捷充值"),
	
	APPLY_DEPOSIT("applyDeposit", "B2B/B2C普通网银充值（不含收费）"),
	
	APPLY_B_DEPOSIT("applyBDeposit", "B2B/B2C普通网银充值（含收费）"),
	
	FIND_QUICK_BANK("findQuickBank", "根据userId查询已经快捷签约的银行"),
	
	FIND_INST_CHANNEL("findInstChannel", "查询可快捷签约银行"),
	
	ZBJ_USER_INFO_QUERY("zbjUserQuery", "猪八戒用户信息查询"),
	
	ZBJ_TRADE_CREATE("zbjTradeCreate", "猪八戒创建担保悬赏交易"),
	
	ZBJ_ESCOW_PAY("zbjEscowPay", "猪八戒买家支付担保资金"),
	
	ZBJ_TRANSFER("zbjTransfer", "猪八戒交易子转帐付款"),
	
	ZBJ_TRADE_CLOSE("zbjTradeClose", "猪八戒交易关闭"),
	
	APPLY_WITHDRAW("applyWithdraw", "提现申请"),
	
	OFF_LINE_DEPOSIT("offLineDeposit", "线下充值"),
	
	TRADE_BATCH_QUERY("tradeBatchQuery", "交易批量信息查询"),
	
	APPLY_BILL_PAYMENT("applyBillPayment", "账单类资源缴费接口"),
	
	QUERY_BILL_PAYABLE_AMOUNT("queryBillPayableAmount", "查询账单应缴金额"),
	
	QUERY_ORDER_STATUS("queryOrderStatus", "查询订单状态");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>OpenApiServiceEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private OpenApiServiceEnum(String code, String message) {
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
	 * @return OpenApiServiceEnum
	 */
	public static OpenApiServiceEnum getByCode(String code) {
		for (OpenApiServiceEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<OpenApiServiceEnum>
	 */
	public List<OpenApiServiceEnum> getAllEnum() {
		List<OpenApiServiceEnum> list = new ArrayList<OpenApiServiceEnum>();
		for (OpenApiServiceEnum _enum : values()) {
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
		for (OpenApiServiceEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
