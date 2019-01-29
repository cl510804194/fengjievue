package com.yjf.esupplier.web.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yjf.esupplier.service.security.info.PermissionInfo;
import com.yjf.esupplier.web.interceptor.DefaultWebAppAuthorityVerifier;

public class PermissionUtil {
	
	public static int check(String code) {
		List<PermissionInfo> permissions = DefaultWebAppAuthorityVerifier.getPermission();
		for (PermissionInfo permission : permissions) {
			Pattern p = Pattern.compile(permission.getPermissionOperate().replace("*", ".*")
				.replace("?", "\\?"));
			Matcher matcher = p.matcher(code);
			if (matcher.matches()) {
				return 1;
			}
		}
		return 0;
	}
	
}
