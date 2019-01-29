package com.yjf.esupplier.ws.userManage.order;

public class AddMemberOrder {
	/**机构用户名*/
	private String jgUserName;
	/**个人用户名*/
	private String grUserName;
	/** 状态 */
	private String state = "失败";

	public String getJgUserName() {
		return jgUserName;
	}

	public void setJgUserName(String jgUserName) {
		this.jgUserName = jgUserName;
	}

	public String getGrUserName() {
		return grUserName;
	}

	public void setGrUserName(String grUserName) {
		this.grUserName = grUserName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddMemberOeder [jgUserName=" + jgUserName + ", grUserName="
				+ grUserName + ", state=" + state + "]";
	}

}
