package com.yjf.esupplier.web.controller.base;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phprpc.PHPRPC_Server;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.CommonUtil;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.service.common.result.SmsCodeResult;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.query.order.MailOrMobileOrder;
import com.yjf.esupplier.service.user.query.order.UserQueryOrder;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * 
 * @Filename BaseCheckController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-8-9</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("anon")
public class BaseCheckController extends BaseAutowiredController {
	
	@RequestMapping("getImgCode.htm")
	public void getImgCode(HttpServletResponse response, HttpSession session) throws IOException {
		// response.reset();
		// ServletOutputStream out = response.getOutputStream();
		// Image.creatImageNew(session, out);
		BufferedImage bufferedImage = Image.creatImage(session);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bufferedImage, "jpg", out);
		out.flush();
		out.close();
	}
	
	@ResponseBody
	@RequestMapping("checkImgCode.json")
	public Object checkImgCode(HttpSession session, String imgCode) throws IOException {
		logger.info("验证易图片验证码是否正确，入参：{}", imgCode);
		int errCount = 0;
		if (session.getAttribute("errCount") != null) {
			errCount = (int) session.getAttribute("errCount");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtil.isBlank(imgCode)) {
			map.put("code", 0);
			map.put("message", "验证码不能为空");
			return map;
		}
		String oldImgCode = (String) session.getAttribute("imgCode");
		if (StringUtil.isBlank(oldImgCode)) {
			map.put("code", 0);
			map.put("message", "旧验证码不能为空,请刷新");
			return map;
		}
		if (imgCode.equalsIgnoreCase(oldImgCode)) {
			map.put("code", 1);
			map.put("message", "验证码正确");
		} else {
			map.put("code", 0);
			map.put("message", "验证码错误");
			errCount++;
			session.setAttribute("errCount", errCount);
		}
		if (errCount >= 5) {
			session.setAttribute("errCount", 0);
			session.removeAttribute("imgCode");
			map.put("code", 0);
			map.put("message", "验证码错误5次,请重新获取");
		}
		logger.info("验证易图片验证码是否正确，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkUserMobile.json")
	public Object checkUserMobile(String userName, String mobile) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", userName);
		JSONObject jsonobj = new JSONObject();
		UserInfo baseUser = userQueryService.queryByUserName(userName).getQueryUserInfo();
		// 验证用户不存在
		if (baseUser != null) {
			if (StringUtil.equals(mobile, baseUser.getMobile())) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "用户手机验证成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "用户手机验证失败");
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户手机验证失败");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户手机，入参：{}", userName);
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("checkUserName.json")
	public Object checkUserName(String userName) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", userName);
		Map<String, Object> map = new HashMap<String, Object>();
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		returnEnum = userBaseInfoManager.validationUserName(userName);
		// if (!NameListUtil.isWhiteName(userName)) {
		// map.put("code", 0);
		// map.put("message", "平台正在内测中。。。请等待开放");
		// return map;
		// }
		// 验证用户不存在
		if (returnEnum.isSuccess()) {
			// 验证易极付账户是否已经存在
			CustomerResult customerResult = customerService.checkUserNameExist(
				AppConstantsUtil.getYrdPrefixion() + userName, this.getOpenApiContext());
			if (customerResult.isExsit()) {
				if (!CommonUtil.checkMobile(userName) && !CommonUtil.checkEmail(userName)) {
					map.put("code", 0);
					map.put("message", "该用户名已经存在，请重新输入");
				} else {
					map.put("code", 0);
					map.put("message",
						"已经注册过易极付账户，直接"
								+ "<a class='ft-blue' href='/login/login?loginType=yjf'>登录</a> ");
				}
				
			} else {
				map.put("code", 1);
				map.put("message", "用户名可以用");
			}
		} else {
			map.put("code", 0);
			map.put("message", "用户名已存在");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkMobileUserName.json")
	public Object checkMobileUserName(String mobile) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", mobile);
		Map<String, Object> map = new HashMap<String, Object>();
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		returnEnum = userBaseInfoManager.validationUserName(mobile);
		// if (!NameListUtil.isWhiteName(userName)) {
		// map.put("code", 0);
		// map.put("message", "平台正在内测中。。。请等待开放");
		// return map;
		// }
		// 验证用户不存在
		if (returnEnum.isSuccess()) {
			// 验证易极付账户是否已经存在
			CustomerResult customerResult = customerService.checkUserNameExist(
				AppConstantsUtil.getYrdPrefixion() + mobile, this.getOpenApiContext());
			if (customerResult.isExsit()) {
				if (!CommonUtil.checkMobile(mobile) && !CommonUtil.checkEmail(mobile)) {
					map.put("code", 0);
					map.put("message", "该用户名已经存在，请重新输入");
				} else {
					map.put("code", 0);
					map.put("message",
						"已经注册过易极付账户，直接"
								+ "<a class='ft-blue' href='/login/login?loginType=yjf'>登录</a> ");
				}
				
			} else {
				map.put("code", 1);
				map.put("message", "用户名可以用");
			}
		} else {
			map.put("code", 0);
			map.put("message", "用户名已存在");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkEmail.json")
	public Object checkEmail(String email) throws Exception {
		logger.info("验证邮箱格式是否正确，入参：{}", email);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean bool = CommonUtil.checkEmail(email);
		if (bool) {
			map.put("code", 1);
			map.put("message", "邮箱格式正确");
		} else {
			map.put("code", 0);
			map.put("message", "邮箱格式错误");
		}
		logger.info("验证邮箱格式是否正确，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkCertNo.json")
	public Object checkCertNo(String certNo) throws Exception {
		logger.info("验证身份证号码格式是否正确，入参：{}", certNo);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean bool = CommonUtil.checkIdentifyCardNum(certNo);
		if (bool) {
			map.put("code", 1);
			map.put("message", "身份证号码格式正确");
		} else {
			map.put("code", 0);
			map.put("message", "身份证号码格式错误");
		}
		logger.info("验证身份证号码格式是否正确，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkEmailOrMobile.json")
	public Object checkEmail(String email, String mobile, String checkType) throws Exception {
		logger.info("验证邮箱格式是否正确，入参：{}", email);
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtil.isNotEmpty(email)) {
			boolean bool = CommonUtil.checkEmail(email);
			if (bool) {
				
				map.put("code", 1);
				map.put("message", "邮箱格式正确");
				// }
			} else {
				map.put("code", 0);
				map.put("message", "邮箱格式错误");
			}
		}
		if (StringUtil.isNotEmpty(mobile)) {
			boolean bool = CommonUtil.checkMobile(mobile);
			if (bool) {
				MailOrMobileOrder mobileOrder = new MailOrMobileOrder();
				mobileOrder.setMobile(mobile);
				mobileOrder.setRole(SysUserRoleEnum.getByCode(checkType));
				long count = userQueryService.countMailOrMobileByRole(mobileOrder).getQueryCount();// .countMailOrMobileByRole(map);
				if (count > 0) {
					map.put("code", 0);
					map.put("message", "此手机号已被注册");
				} else {
					map.put("code", 1);
					map.put("message", "手机号码格式正确");
				}
				map.put("code", 1);
				map.put("message", "手机号码格式正确");
			} else {
				map.put("code", 0);
				map.put("message", "手机号码格式错误");
			}
		}
		logger.info("验证邮箱或手机格式是否正确，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkMobile.json")
	public Object checkMobile(String mobile) throws Exception {
		logger.info("验证手机号码格式是否正确，入参：{}", mobile);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean bool = CommonUtil.checkMobile(mobile);
		if (bool) {
			map.put("code", 1);
			map.put("message", "手机号码格式正确");
		} else {
			map.put("code", 0);
			map.put("message", "手机号码格式错误");
		}
		logger.info("验证手机号码格式是否正确，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("sendSmsCode.json")
	public Object sendSmsCode(String mobile, String business, String extendMessage , String verifyCode,HttpSession session)
																					throws Exception {
		logger.info("发生手机验证码，入参[{}],[{}]", mobile, business);
		JSONObject json = new JSONObject();
        String oldImgCode = (String) session.getAttribute("imgCode");
		Map<String, Object> map = new HashMap<String, Object>();;
        SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
        if (sessionLocal == null || sessionLocal.getUserBaseId() == null) {
            if (StringUtil.isBlank(verifyCode)) {
                map.put("code", 0);
                map.put("message", "图片验证码不能为空");
                return map;
            }
            if (!verifyCode.equalsIgnoreCase(oldImgCode)) {
                map.put("code", 0);
                map.put("message", "图片验证码错误");
                return map;
            }
        }
	/*	if (Image.checkImgCode(session, verifyCode)) {*/
		if (ShiroSessionUtils.getSessionLocal() != null
			&& ShiroSessionUtils.getSessionLocal().getUserBaseId() != null) {
			UserInfo baseUser = userQueryService
				.queryByUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId())
				.getQueryUserInfo();
			if (StringUtil.isNotEmpty(baseUser.getMobile())) {
				mobile = baseUser.getMobile();
			}
		}
		EsupplierBaseResult baseResult = smsManagerService.sendSmsCode(mobile,
			SmsBizType.getByCode(business), null);
		if (baseResult.isSuccess()) {
			map.put("code", 1);
			map.put("message", "发生手机验证码成功");
		} else {
			map.put("code", 0);
			map.put("message", baseResult.getMessage());
		}
		logger.info("发生手机验证码，结果：{}", map);
		return map;
	}	
	
	@ResponseBody
	@RequestMapping("sendSmsCodeModifyPhone.json")
	public Object sendSmsCodeModifyPhone(String mobile, String business) throws Exception {
		logger.info("发生手机验证码，入参[{}],[{}]", mobile, business);
		Map<String, Object> map = new HashMap<String, Object>();
		EsupplierBaseResult baseResult = smsManagerService.sendSmsCode(mobile,
			SmsBizType.getByCode(business));
		if (baseResult.isSuccess()) {
			map.put("code", 1);
			map.put("message", "发生手机验证码成功");
		} else {
			map.put("code", 0);
			map.put("message", baseResult.getMessage());
		}
		logger.info("发生手机验证码，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("sendSmsCodeForgetPassword.json")
	public Object sendSmsCodeForgetPassword(HttpServletRequest request, String mobile,
											String business, HttpSession session) throws Exception {
		logger.info("发生手机验证码，入参[{}],[{}]", mobile, business);
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo userBaseInfo = (UserInfo) session.getAttribute("newLogPasswordChoice");
		SessionLocal local = new SessionLocal();
		if (StringUtil.isNotEmpty(userBaseInfo.getRealName()))
			local.setRealName(userBaseInfo.getRealName());
		else
			local.setRealName(userBaseInfo.getUserName());
		local.setUserName(userBaseInfo.getUserName());
		local.setRemoteAddr(IPUtil.getIpAddr(request));
		ShiroSessionUtils.setSessionLocal(local);
		EsupplierBaseResult baseResult = smsManagerService.sendSmsCode(userBaseInfo.getMobile(),
			SmsBizType.getByCode(business));
		if (baseResult.isSuccess()) {
			map.put("code", 1);
			map.put("message", "发生手机验证码成功");
		} else {
			map.put("code", 0);
			map.put("message", baseResult.getMessage());
		}
		logger.info("发生手机验证码，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("sendSmsPasswordCode.json")
	public Object sendSmsPasswordCode(String mobile, String business, String userName)
																						throws Exception {
		logger.info("发生手机验证码，入参[{}],[{}]", mobile, business);
		JSONObject jsonobj = new JSONObject();
		UserInfo baseUser = userQueryService.queryByUserName(userName).getQueryUserInfo();
		if (baseUser == null) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户名错误");
			return jsonobj;
		}
		if (!StringUtil.equals(mobile, baseUser.getMobile())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "手机号不匹配");
			return jsonobj;
		}
		
		EsupplierBaseResult yrdBaseResult = smsManagerService.sendSmsCode(mobile,
			SmsBizType.getByCode(business));
		if (yrdBaseResult.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "发生手机验证码成功");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", yrdBaseResult.getMessage());
		}
		logger.info("发生手机验证码，结果：{}", jsonobj);
		return jsonobj;
	}
	
	/**
	 * 合同录入 发送手机验证码
	 * @param mobile
	 * @param business
	 * @param extendMessage
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("sendSmsContractCode.json")
	public Object sendSmsContractCode(String mobile, String business, String extendMessage)
																							throws Exception {
		logger.info("发送手机验证码，入参[{}],[{}]", mobile, business);
		Map<String, Object> map = new HashMap<String, Object>();
		EsupplierBaseResult baseResult = smsManagerService.sendSmsCode(mobile,
			SmsBizType.getByCode(business), null);
		if (baseResult.isSuccess()) {
			map.put("code", 1);
			map.put("message", "发送手机验证码成功");
		} else {
			map.put("code", 0);
			map.put("message", baseResult.getMessage());
		}
		logger.info("发送手机验证码，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkSmsCode.json")
	public Object checkSmsCode(String mobile, String business, String code) throws Exception {
		logger.info("验证手机验证码，入参[{}],[{}]", mobile, business);
		Map<String, Object> map = new HashMap<String, Object>();
		SmsCodeResult smsCodeResult = this.smsManagerService.verifySmsCode(mobile,
			SmsBizType.getByCode(business), code, false);
		if (smsCodeResult.isSuccess()) {
			map.put("code", 1);
			map.put("message", "验证手机验证码成功");
		} else {
			map.put("code", 0);
			map.put("message", smsCodeResult.getMessage());
		}
		logger.info("验证手机验证码，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkUserNameAndType.json")
	public Object checkUserNameAndType(String userName, String type) throws Exception {
		logger.info("根据用户名和用户类型验证用户，入参[{}],[{}]", userName, type);
		Map<String, Object> map = new HashMap<String, Object>();
		EsupplierBaseResult userBaseReturnEnum = userBaseInfoManager.validationUserName(userName);
		if (userBaseReturnEnum.isSuccess()) {
			map.put("code", 0);
			map.put("message", "不是有效的用户名");
			return map;
		}
		UserInfo userInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
		if (StringUtil.equals(userInfo.getType().code(), type)) {
			map.put("code", 1);
			map.put("message", "验证成功");
		} else {
			map.put("code", 0);
			map.put("message", "用户名和用户类型不匹配");
		}
		logger.info("根据用户名和用户类型验证用户，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkUserNameAndRealName.json")
	public Object checkUserNameAndRealName(String userName, String realName) throws Exception {
		logger.info("根据用户名和真实姓名验证用户，入参[{}],[{}]", userName, realName);
		Map<String, Object> map = new HashMap<String, Object>();
		UserQueryOrder userQueryOrder = new UserQueryOrder();
		userQueryOrder.setUserName(userName);
		userQueryOrder.setRealName(realName);
		long userId = userQueryService.commonQueryUserInfo(userQueryOrder).getTotalCount();
		if (userId > 0) {
			map.put("code", 1);
			map.put("message", "验证成功");
		} else {
			map.put("code", 0);
			map.put("message", "用户名和真实姓名不匹配");
		}
		logger.info("根据用户名和真实姓名验证用户，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkIdentityName.htm")
	public Object checkIdentityName(String identityName, String type) throws Exception {
		logger.info("验证机构简码，入参[{}],[{}]", identityName, type);
		Map<String, Object> map = new HashMap<String, Object>();
		UserQueryOrder userQueryOrder = new UserQueryOrder();
		userQueryOrder.setIdentityName(identityName);
		userQueryOrder.setType(UserTypeEnum.JG);
		long userId = userQueryService.commonQueryUserInfo(userQueryOrder).getTotalCount();
		if (userId > 0) {
			map.put("code", 0);
			map.put("message", "机构简码已存在");
		} else {
			map.put("code", 1);
			map.put("message", "机构简码不存在");
		}
		logger.info("验证机构简码，结果：{}", map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("checkIdentityNameUserNameAndType.json")
	public Object checkIdentityNameUserNameAndType(String identityName, String userName, String type)
																										throws Exception {
		logger.info("根据用户名,用户类型,验机构号段，入参[{" + identityName + "}],[{" + identityName + "}],[{"
					+ type + "}]");
		Map<String, Object> map = new HashMap<String, Object>();
		
		UserQueryOrder userQueryOrder = new UserQueryOrder();
		userQueryOrder.setUserName(userName);
		userQueryOrder.setIdentityName(identityName);
		userQueryOrder.setType(UserTypeEnum.getByCode(type));
		long userId = userQueryService.commonQueryUserInfo(userQueryOrder).getTotalCount();
		if (userId > 0) {
			map.put("code", 1);
			map.put("message", "用户名与机构号段匹配成功");
		} else {
			map.put("code", 0);
			map.put("message", "用户名与机构号段匹配失败");
		}
		logger.info("根据用户名,用户类型,验机构号段，结果：{}", map);
		return map;
	}
	
	@RequestMapping("toGetKey.htm")
	public void toGetKey(HttpServletRequest request, HttpServletResponse response)
																					throws IOException {
		
		logger.info("获取安全控件密钥，开始");
		PHPRPC_Server loginServer = new PHPRPC_Server();
		loginServer.add("getKey", this);
		loginServer.start(request, response);
		logger.info("获取安全控件密钥，结束");
	}
	
	public String getKey(HttpServletRequest request) throws NoSuchAlgorithmException,
													UnsupportedEncodingException {
		HttpSession session = request.getSession(true);
		String aesKey = getRandomString(16);
		session.setAttribute(session.getId(), aesKey);
		return aesKey;
	}
	
	@ResponseBody
	@RequestMapping("checkReferees.json")
	public Object checkReferees(String referees) throws IOException {
		logger.info("验证推荐人编号是否正确，入参：{}", referees);
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		if (StringUtil.isNotBlank(referees)) {
			json = registerService.validationBroker(referees);
			if ((Integer) json.get("code") == 1) {
				map.put("code", 1);
				map.put("message", "推荐人编号正确");
			} else {
				map.put("code", 0);
				map.put("message", "推荐人不存在");
			}
		}
		logger.info("验证易图片验证码是否正确，结果：{}", map);
		return map;
		
	}
	
	// 产生一个随机数 方法
	public String getRandomString(int length) {
		String str = "abcdefghigklmnopkrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
		Random random = new Random();
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(72);// 0~71
			sf.append(str.charAt(number));
			
		}
		return sf.toString();
	}
	
}
