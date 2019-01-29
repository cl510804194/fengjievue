package com.yjf.yrd.integration.bornapi.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class YjfActiveOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = 1595688596461628554L;
	
	/** PC：电商平台 ； MOBILE:移动平台 */
	private String termnalType;
	/** 是否设置登录密码 T/F */
	private String isSetPassword = "T";
	/** 资金账户名 */
	private String userName;
	/** 是否显示标题 1/默认=显示；0=不显示 */
	private String title = "1";
	/** 是否需要弱实名：1=是；0/默认=否 */
	private String certify = "0";
	/** 是否需要验证手机号 ：1=是；0/默认=否 */
	private String isPhoneValidate = "0";
	//	private String mobile;
	private String notifyUrl;
	private String errorNotifyUrl;
	
	@Override
	public void check() {
		validateHasText(userName, "资金账户名");
	}
	
	public String getTermnalType() {
		return this.termnalType;
	}
	
	public void setTermnalType(String termnalType) {
		this.termnalType = termnalType;
	}
	
	public String getIsSetPassword() {
		return this.isSetPassword;
	}
	
	public void setIsSetPassword(String isSetPassword) {
		this.isSetPassword = isSetPassword;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCertify() {
		return this.certify;
	}
	
	public void setCertify(String certify) {
		this.certify = certify;
	}
	
	public String getIsPhoneValidate() {
		return this.isPhoneValidate;
	}
	
	public void setIsPhoneValidate(String isPhoneValidate) {
		this.isPhoneValidate = isPhoneValidate;
	}
	
	public String getNotifyUrl() {
		return this.notifyUrl;
	}
	
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
	public String getErrorNotifyUrl() {
		return this.errorNotifyUrl;
	}
	
	public void setErrorNotifyUrl(String errorNotifyUrl) {
		this.errorNotifyUrl = errorNotifyUrl;
	}
	
	@Override
	public String toString() {
		return "YjfActiveOrder [termnalType=" + termnalType + ", isSetPassword=" + isSetPassword
				+ ", userName=" + userName + ", title=" + title + ", certify=" + certify
				+ ", isPhoneValidate=" + isPhoneValidate + ", notifyUrl=" + notifyUrl
				+ ", errorNotifyUrl=" + errorNotifyUrl + "]";
	}
	
}
