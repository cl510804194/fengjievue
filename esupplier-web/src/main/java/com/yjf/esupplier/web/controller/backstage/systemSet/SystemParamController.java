package com.yjf.esupplier.web.controller.backstage.systemSet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.dal.dataobject.SysParamDO;
import com.yjf.esupplier.service.common.services.SysParameterService;
import com.yjf.esupplier.web.controller.backstage.controller.BackstageIndexController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.order.SysParamOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.order.SysParamQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 系统参数  Created By chengzi on 2015/04/03.
 */
@Controller
@RequestMapping("/admin/sysParamManage")
public class SystemParamController extends BackstageIndexController {
	private final String vm_path = "/backstage/systemSet/";
	
	@Autowired
	protected SysParameterService sysParameterService;
	
	/**
	 * 系统参数管理页面
	 * @param paramName
	 * @param pageParam
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysParamManage.htm")
	public String sysParamManage(String paramName, PageParam pageParam,
									HttpServletResponse response, Model model) throws Exception {
		SysParamQueryOrder queryOrder = new SysParamQueryOrder();
		queryOrder.setParamName(paramName);
		queryOrder.setPageSize(pageParam.getPageSize());
		queryOrder.setPageNumber(pageParam.getPageNo());
		QueryBaseBatchResult<SysParamDO> queryBaseBatchResult = sysParameterService
			.querySysPram(queryOrder);
		model.addAttribute("page", PageUtil.getCovertPage(queryBaseBatchResult));
		model.addAttribute("queryConditions", queryOrder);
		response.setHeader("Pragma", "No-cache");
		return vm_path + "sysParamManage.vm";
	}
	
	/**
	 * 转到新增页面
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toAddSysParam.htm")
	public String toAddSysParamManager(HttpServletResponse response, Model model) throws Exception {
		return vm_path + "addSysParam.vm";
	}
	
	/**
	 * 验证参数名称是否已经存在
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("validationParamName.json")
	public Object validationUserName(String paramName) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "参数名称不存在，入参：{}", paramName);
		JSONObject json = new JSONObject();
		SysParamDO sysParamDO = sysParameterService.getSysParameterValueDO(paramName);
		// 验证用户不存在
		if (sysParamDO != null) {
			json.put("message", "参数名称已经存在");
		}else{
			json.put("message", "参数名称可以用");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "参数名称不存在，入参：{}", paramName);
		return json;
	}
	
	/**
	 * 新增系统参数
	 * @param param_name
	 * @param param_value
	 * @param extend_attribute_one
	 * @param extend_attribute_two
	 * @param rawAddTime
	 * @param description
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("addSysParamSubmit.json")
	public Object addSysParamSubmit(HttpServletRequest request) throws Exception {
		SysParamOrder sysParamOrder = new SysParamOrder();
		WebUtil.setPoPropertyByRequest(sysParamOrder, request);
		JSONObject json = new JSONObject();
		logger.info("新增系统参数，入参{}", sysParamOrder);
		
		//判断参数名称是否已经存在
		String paramName = sysParamOrder.getParamName();
		SysParamDO sysParamDO = null;
		if(!"".equalsIgnoreCase(paramName) && paramName != null){
			sysParamDO = sysParameterService.getSysParameterValueDO(paramName);
		}
		if (sysParamDO != null) {
			json.put("message", "参数名称已经存在");
		}else{
			EsupplierBaseResult result = sysParameterService.insertSysParameterValueDO(sysParamOrder);
			if (result.isSuccess()) {
				json.put("message", "新增系统参数成功");
			} else {
				json.put("message", "新增系统参数失败");
			}
		}
		return json;
		
	}
	
	
	/**
	 * 转到编辑页面
	 * @param paramName
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("editSysParam.htm")
	public String editSysParam(String paramName, HttpServletResponse response, Model model)
																									throws Exception {
		SysParamDO sysParamDO = sysParameterService.getSysParameterValueDO(paramName);
		model.addAttribute("info", sysParamDO);
		return vm_path + "editSysParam.vm";
	}
	
	/**
	 * 更新系统参数
	 * @param param_name
	 * @param param_value
	 * @param extend_attribute_one
	 * @param extend_attribute_two
	 * @param rawAddTime
	 * @param description
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("updateSysParamSubmit.json")
	public Object updateSysParamSubmit(HttpServletRequest request, HttpServletResponse response,
											Model model) throws Exception {
		SysParamOrder sysParamOrder = new SysParamOrder();
		WebUtil.setPoPropertyByRequest(sysParamOrder, request);
		JSONObject json = new JSONObject();
		logger.info("更新系统参数，入参{}", sysParamOrder);
		EsupplierBaseResult result = sysParameterService.updateSysParameterValueDO(sysParamOrder);
		if (result.isSuccess()) {
			json.put("message", "更新系统参数成功");
		} else {
			json.put("message", "更新系统参数失败");
		}
		return json;
	}
	
	
	/**
	 * 转到详情页面
	 * @param paramName
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("detailSysParam.htm")
	public String detailSysParam(String paramName, HttpServletResponse response, Model model) throws Exception {
		SysParamDO sysParamDO = sysParameterService.getSysParameterValueDO(paramName);
		model.addAttribute("info", sysParamDO);
		return vm_path + "detailSysParam.vm";
	}
	
	
}
