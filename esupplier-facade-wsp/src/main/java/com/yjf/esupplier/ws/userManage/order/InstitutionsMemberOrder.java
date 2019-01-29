package com.yjf.esupplier.ws.userManage.order;

public class InstitutionsMemberOrder {

	private String userName;

	private String realName;

	private String certNo;

	private String mobile;

	private String mail;

	private String state = "fail";
	
	private String institutionName; 
	
	public InstitutionsMemberOrder() {
	}

	public InstitutionsMemberOrder(String userName, String realName,
			String certNo, String mobile, String mail, String state, String institutionName) {
		this.userName = userName;
		this.realName = realName;
		this.certNo = certNo;
		this.mobile = mobile;
		this.mail = mail;
		this.state = state;
		this.institutionName = institutionName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
}
