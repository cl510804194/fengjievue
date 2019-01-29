package com.yjf.esupplier.web.controller.backstage.usermanage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.service.user.order.InstitutionsBaskstageRegisterOrder;
import com.yjf.esupplier.service.user.query.ScenicService;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.service.user.result.ScenicQueryResult;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.service.user.result.UserRegisterResult;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.ScenicStateEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * 
 * @Filename InstitutionsController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History
 * <li>Author: zjl</li>
 * <li>Date: 2013-7-5</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("/admin/userManage")
public class ScenicController extends UserBaseInfoBaseController {
	/** 通用页面路径 */
	String USER_MANAGE_PATH = "/backstage/userManage/";
	
	@Autowired
	protected ScenicService scenicService;
	
	@Override
	protected String[] getDateInputNameArray() {
		return new String[] { "changeLockTime" };
	}
	
	@RequestMapping("scenicManage.htm")
	public String scenicManage(	HttpServletRequest request, PageParam pageParam,
								Model model) throws Exception {
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		WebUtil.setPoPropertyByRequest(scenicQueryOrder, request);
		scenicQueryOrder.setPageSize(pageParam.getPageSize());
		scenicQueryOrder.setPageNumber(pageParam.getPageNo());
		scenicQueryOrder.setStatus(UserStateEnum.getByCode(request.getParameter("status")));
		QueryBaseBatchResult<ScenicInfo> baseBatchResult = scenicService
			.getScenicInfo(scenicQueryOrder);
		model.addAttribute("queryConditions", scenicQueryOrder);
		model.addAttribute("page", PageUtil.getCovertPage(baseBatchResult));
		return USER_MANAGE_PATH + "scenicManage.vm";
	}
	
	@RequestMapping("scenicManage/changeScenic.htm")
	public String addScenic(Model model, String  userBaseId,String roleEnum) throws Exception {

		ScenicInfo info =  new ScenicInfo();
		if (StringUtil.isNotEmpty(userBaseId)) {
			ScenicQueryResult queryResult = scenicService.queryByUserBaseId(userBaseId);
			UserQueryResult userQueryResult = userQueryService.queryByUserBaseId(userBaseId);
			info = queryResult.getQueryScenicInfo();
			if (userQueryResult.getQueryUserInfo() != null) {
				info.setUserName(userQueryResult.getQueryUserInfo().getUserName());
			}
			if (info==null||info.getId() == 0) { /*新增*/
				info =  new ScenicInfo();
				info.setUserBaseId(userBaseId);
				info.setInTime(DateUtil.simpleFormatYmd(new Date()));
				info.setStatus(ScenicStateEnum.NORMAL.code());
			}
		}
		model.addAttribute("info", info);
		model.addAttribute("roleEnum", roleEnum);
		model.addAttribute("uploadHost", "");
		return USER_MANAGE_PATH + "changeScenic.vm";
	}
	
	@RequestMapping("scenicManage/checkIdentityCode.htm")
	@ResponseBody
	public Object checkIdentityCode(String code, String userBaseId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		ScenicInfo info = new ScenicInfo();
		if (StringUtil.isNotEmpty(userBaseId) && StringUtil.isNotEmpty(code)) { /*修改时*/
			ScenicQueryResult queryResult = scenicService.queryByCode(code);
			info = queryResult.getQueryScenicInfo();
			if (info != null && !userBaseId.equals(info.getUserBaseId())) {
				map.put("code", 0);
				map.put("message", "景区编码已存在");
			} else {
				map.put("code", 1);
				map.put("message", "景区编码可用");
			}
		} else if (StringUtil.isEmpty(userBaseId) && StringUtil.isNotEmpty(code)) { /*新增时*/
			ScenicQueryResult queryResult = scenicService.queryByCode(code);
			info = queryResult.getQueryScenicInfo();
			if (info != null) {
				map.put("code", 0);
				map.put("message", "景区编码已存在");
			} else {
				map.put("code", 1);
				map.put("message", "景区编码可用");
			}
		} else if (StringUtil.isEmpty(code)) {
			map.put("code", 0);
			map.put("message", "景区编码为空");
		}
		logger.info("验证机构简码，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("scenicManage/changeScenicSubmit.htm")
	public Object updateScenicSubmit(HttpServletRequest request) throws Exception {
		//ScenicBaskstageRegisterOrder scenicBaskstageRegisterOrder = new ScenicBaskstageRegisterOrder();
		InstitutionsBaskstageRegisterOrder institutionsBaskstageRegisterOrder = new InstitutionsBaskstageRegisterOrder();
		setRegistorOrder(institutionsBaskstageRegisterOrder, request);
		JSONObject jsonobj = new JSONObject();
		if (institutionsBaskstageRegisterOrder.getId() == 0) { /*新增*/
			//			scenicInfo.setStatus(ScenicStateEnum.NORMAL.code());
			//			scenicInfo.setRawAddTime(new Date());
			UserRegisterResult result = registerService
				.ScenicBaskstageRegister(institutionsBaskstageRegisterOrder);
			//	EsupplierBaseResult result = scenicService.insert(scenicInfo);
			if (result.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "新增景区详情信息成功");
			}
			if (!result.isSuccess()) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "新增景区详情信息失败,原因（" + result.getMessage() + "）");
			}
		} else { /*修改*/
			ScenicInfo scenicInfo = new ScenicInfo();
			WebUtil.setPoPropertyByRequest(scenicInfo, request);
			scenicInfo.setOpenTime(request.getParameter("openTimeStr"));
			scenicInfo.setCloseTime(request.getParameter("closeTimeStr"));
			scenicInfo.setImagePath1(request.getParameter("imagePath1Img"));
			EsupplierBaseResult result = scenicService.update(scenicInfo);
			if (result.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "修改景区详情信息成功");
			}
			if (!result.isSuccess()) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "修改景区详情信息失败,原因（" + result.getMessage() + "）");
			}
		}
		return jsonobj;
	}
	
	private InstitutionsBaskstageRegisterOrder setRegistorOrder(InstitutionsBaskstageRegisterOrder institutionsBaskstageRegisterOrder,
																HttpServletRequest request) {
		WebUtil.setPoPropertyByRequest(institutionsBaskstageRegisterOrder, request);
		institutionsBaskstageRegisterOrder.setLatitude(request.getParameter("lng"));
		institutionsBaskstageRegisterOrder.setLongitude(request.getParameter("lat"));
		institutionsBaskstageRegisterOrder.setEnterpriseName(request.getParameter("name"));
		institutionsBaskstageRegisterOrder.setCompanyPhone(request.getParameter("phone"));
		return institutionsBaskstageRegisterOrder;
		
	}
}
