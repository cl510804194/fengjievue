package com.yjf.esupplier.web.controller.password;

import javax.servlet.http.HttpSession;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.MD5Util;

public class CheckMd5UserBD {
	private static final String md5AddString = "S1as#%DF#@D*(=-@@!";
	/**
	 * 校验Md5UserBaseId
	 * */
	public static boolean checkMd5UserBD(HttpSession session, String CMd5UserBaseId,String userBaseId) {
		String sessionUserBaseId = (String) session.getAttribute("userBaseId");
		String randomToken = (String) session.getAttribute("randomToken");
		String SMd5UserBaseId = MD5Util.getMD5_32(sessionUserBaseId + md5AddString +randomToken);
		
		if(StringUtil.equals(userBaseId, sessionUserBaseId)){
			if (StringUtil.isNotEmpty(userBaseId)
					&& SMd5UserBaseId.equals(CMd5UserBaseId)) {
				return true;
			}
		}
		return false;

	}
}
