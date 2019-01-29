package com.yjf.esupplier.ws.directsend.order;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.directsend.enums.DirectSendTypeEnum;
import com.yjf.esupplier.ws.directsend.enums.DirectTypeEnum;
import com.yjf.esupplier.ws.enums.NotificationTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class DirectSendOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = -5344718730235750128L;
	
	protected String content;
	
	protected DirectTypeEnum directType;
	
	protected DirectSendTypeEnum sendType;
	
	protected String userName;
	
	protected String s_sendValue;
	
	protected String[] userType;
	
	protected String[] sendValue;
	
	protected Date registrationStartTime;
	
	protected Date registrationEndTime;

	protected String sendAccountCode;

	protected String sendAccountName;
	
	protected String sendReason;
	
	@Override
	public void check() {
		this.validateHasText(content, "发放事由");
		this.validateNotNull(directType, "发放内容");
		this.validateNotNull(sendType, "发放方式");
		if (DirectSendTypeEnum.USERGROUP.code().equals(sendType.code())) {
			if (userType == null || userType.length == 0) {
				throw new IllegalArgumentException("会员等级不能为空!");
			}
			HashMap<String, String> tMap = new HashMap<String, String>();
			for (String uType : userType) {
				if (StringUtil.isEmpty(uType)) {
					throw new IllegalArgumentException("会员等级不能为空!");
				} else {
					if (NotificationTypeEnum.ALL.code().equals(uType) && userType.length > 1) {
						throw new IllegalArgumentException("选择向所有会员赠送时,只能有一条数据!");
					}
					
					if (tMap.get(uType) == null) {
						tMap.put(uType, uType);
					} else {
						throw new IllegalArgumentException("同一会员等级只能有一条数据!");
					}
				}
			}
			
			if (sendValue == null || sendValue.length == 0) {
				throw new IllegalArgumentException("发放值必须大于0！");
			}
			for (String sValue : sendValue) {
				if (StringUtil.isEmpty(sValue)) {
					throw new IllegalArgumentException("发放值必须大于0！");
					
				} else {
					try {
						double v = Double.valueOf(sValue);
						if (v <= 0) {
							throw new IllegalArgumentException("发放值必须大于0！");
						}
					} catch (Exception e) {
						throw new IllegalArgumentException("发放值必须大于0！");
					}
					
					if (DirectTypeEnum.POINT.code().equals(directType.code())) {
						try {
							long v2 = Long.valueOf(sValue);
						} catch (NumberFormatException e) {
							throw new IllegalArgumentException("积分的发放值必须为整数！");
						}
					}
					
				}
			}
		} else {
			this.validateHasText(userName, "用户名");
			try {
				double v = Double.valueOf(s_sendValue);
				if (v <= 0) {
					throw new IllegalArgumentException("发放值必须大于0！");
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("发放值必须大于0！");
			}
			
			if (DirectTypeEnum.POINT.code().equals(directType.code())) {
				try {
					long v2 = Long.valueOf(s_sendValue);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("积分的发放值必须为整数！");
				}
			}
		}
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public DirectTypeEnum getDirectType() {
		return directType;
	}
	
	public void setDirectType(DirectTypeEnum directType) {
		this.directType = directType;
	}
	
	public DirectSendTypeEnum getSendType() {
		return sendType;
	}
	
	public void setSendType(DirectSendTypeEnum sendType) {
		this.sendType = sendType;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getS_sendValue() {
		return s_sendValue;
	}
	
	public void setS_sendValue(String s_sendValue) {
		this.s_sendValue = s_sendValue;
	}
	
	public String[] getUserType() {
		return userType;
	}
	
	public void setUserType(String[] userType) {
		this.userType = userType;
	}
	
	public String[] getSendValue() {
		return sendValue;
	}
	
	public void setSendValue(String[] sendValue) {
		this.sendValue = sendValue;
	}
	
	public Date getRegistrationStartTime() {
		return this.registrationStartTime;
	}
	
	public void setRegistrationStartTime(Date registrationStartTime) {
		this.registrationStartTime = registrationStartTime;
	}
	
	public Date getRegistrationEndTime() {
		return this.registrationEndTime;
	}
	
	public void setRegistrationEndTime(Date registrationEndTime) {
		this.registrationEndTime = registrationEndTime;
	}
	
	public String getSendAccountCode() {
		return sendAccountCode;
	}

	public void setSendAccountCode(String sendAccountCode) {
		this.sendAccountCode = sendAccountCode;
	}

	public String getSendAccountName() {
		return sendAccountName;
	}

	public void setSendAccountName(String sendAccountName) {
		this.sendAccountName = sendAccountName;
	}

	public String getSendReason() {
		return sendReason;
	}

	public void setSendReason(String sendReason) {
		this.sendReason = sendReason;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DirectSendOrder [content=");
		builder.append(content);
		builder.append(", directType=");
		builder.append(directType);
		builder.append(", sendType=");
		builder.append(sendType);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", s_sendValue=");
		builder.append(s_sendValue);
		builder.append(", userType=");
		builder.append(Arrays.toString(userType));
		builder.append(", sendValue=");
		builder.append(Arrays.toString(sendValue));
		builder.append(", registrationStartTime=");
		builder.append(registrationStartTime);
		builder.append(", registrationEndTime=");
		builder.append(registrationEndTime);
		builder.append("]");
		return builder.toString();
	}
	
}
