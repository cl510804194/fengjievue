package com.yjf.esupplier.web.controller.backstage.usermanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.user.order.RegisterBaseOrder;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;

public class UserBaseInfoBaseController extends BaseAutowiredController {
	protected void setRoles(HttpServletRequest request, RegisterBaseOrder registerOrder) {
		String[] roleIds = request.getParameterValues("roleIds");
		if (roleIds != null) {
			List<SysUserRoleEnum> roles = new ArrayList<SysUserRoleEnum>();
			for (int i = 0; i < roleIds.length; i++) {
				roles.add(SysUserRoleEnum.getByValue(NumberUtil.parseInt(roleIds[i])));
			}
			registerOrder.setRole(roles);
		}
	}
}
