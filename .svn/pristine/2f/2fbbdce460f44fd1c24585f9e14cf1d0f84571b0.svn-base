package com.yjf.esupplier.web.controller.front.scenicCenter;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.dal.daointerface.UserBaseInfoDAO;
import com.yjf.esupplier.dal.dataobject.UserBaseInfoDO;
import com.yjf.esupplier.service.user.UserBaseInfoManager;
import com.yjf.esupplier.service.user.impl.UserBaseInfoManagerImpl;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.result.ScenicQueryResult;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.ScenicStateEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/do/scenic")
public class ScenicInfoManagerController extends FrontAutowiredBaseController {
	final static String path = "front/infoCenter/";
	@Autowired
	protected UserBaseInfoDAO userBaseInfoDAO;
	
	@RequestMapping("doCenter/updateScenic.htm")
	public String updateMerchant(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		long belongTo = ShiroSessionUtils.getSessionLocal().getBelongTo();
		/*如果是景区操作员，查询上级的景区信息*/
		if (belongTo != 0 && userId != belongTo) {
			UserBaseInfoDO baseInfoDO = userBaseInfoDAO.findByUserId(belongTo);
			if (baseInfoDO != null)
				userBaseId = baseInfoDO.getUserBaseId();
		}
		ScenicInfo info = new ScenicInfo();
		if (StringUtil.isNotEmpty(userBaseId)) {
			ScenicQueryResult queryResult = scenicService.queryByUserBaseId(userBaseId);
			info = queryResult.getQueryScenicInfo();
			if (info == null || info.getId() == 0) { /*新增*/
				info = new ScenicInfo();
				info.setUserBaseId(userBaseId);
				info.setName("");
				info.setCode("-");
				info.setInTime(DateUtil.simpleFormatYmd(new Date()));
				info.setStatus(ScenicStateEnum.NORMAL.code());
				scenicService.insert(info);
			}
		}
		model.addAttribute("info", info);
		return path + "scenic_info.vm";
	}
	
	@RequestMapping("doCenter/updateScenicSubmit.htm")
	@ResponseBody
	public Object updateScenicSubmit(HttpServletRequest request) throws Exception {
		JSONObject jsonobj = new JSONObject();
		String userId = request.getParameter("id");
		String userBaseId = request.getParameter("userBaseId");
		if (StringUtil.isEmpty(userId)&&StringUtil.isEmpty(userBaseId)) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "景区信息未初始化，请联系平台管理员");
			return jsonobj;
		}
		ScenicInfo scenicInfo = new ScenicInfo();
		ScenicQueryResult oldScenicInfo = scenicService.queryByUserBaseId(userBaseId);
		BeanCopier.staticCopy(oldScenicInfo.getQueryScenicInfo(), scenicInfo);
		WebUtil.setPoPropertyByRequest(scenicInfo, request);
		EsupplierBaseResult result = scenicService.update(scenicInfo);
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "修改景区详情信息成功");
		}
		if (!result.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改景区详情信息失败,原因（" + result.getMessage() + "）");
		}
		return jsonobj;
	}
}
