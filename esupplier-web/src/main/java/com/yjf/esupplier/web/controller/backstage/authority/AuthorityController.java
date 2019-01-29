package com.yjf.esupplier.web.controller.backstage.authority;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.service.security.AuthorityService;
import com.yjf.esupplier.service.security.info.PermissionInfo;
import com.yjf.esupplier.service.security.info.RoleInfo;
import com.yjf.esupplier.service.security.order.PermissionOrder;
import com.yjf.esupplier.service.security.order.RoleOrder;
import com.yjf.esupplier.service.security.query.order.PermissonQueryOrder;
import com.yjf.esupplier.service.security.query.order.RoleQueryOrder;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * 
 * @Filename AuthorityController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author yhl
 * 
 * @Email yhailong@yiji.com
 * 
 * @History
 * <li>Author: yhl</li>
 * <li>Date: 2013-6-8</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li> 权限管理控制器
 */
@Controller
@RequestMapping("admin/authority")
public class AuthorityController extends BaseAutowiredController {
	/**
	 * 权限服务接口
	 */
	@Autowired
	private AuthorityService authorityService;
	
	/**
	 * 查询所有权限列表
	 * @param model
	 * @return
	 */
	@RequestMapping("permissions/{page}/{size}.htm")
	public String getAllPermissions(@PathVariable int page, @PathVariable int size, Model model,
									HttpServletRequest request) {
									
		PermissonQueryOrder queryOrder = new PermissonQueryOrder();
		queryOrder.setPageNumber(page);
		queryOrder.setPageSize(size);
		queryOrder.setPermissionName(request.getParameter("permissionName"));
		queryOrder.setPermissionCode(request.getParameter("permissionCode"));
		logger.info("查询所有权限列表，入参{}", queryOrder);
		QueryBaseBatchResult<PermissionInfo> result = authorityService.getAllPermission(queryOrder);
		model.addAttribute("page", PageUtil.getCovertPage(result));
		
		return "authority/permissions.vm";
	}
	
	/**
	 * 删除权限
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delPermission.json")
	public Object delPermissions(int[] ids) {
		
		JSONObject json = new JSONObject();
		logger.info("删除权限操作，入参{}", ids);
		EsupplierBaseResult result = authorityService.deletePermissions(ids);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "删除权限成功");
		} else {
			json.put("code", 0);
			json.put("message", "删除权限失败");
		}
		
		return json;
	}
	
	/**
	 * 修改权限信息页面
	 * @param permissionId
	 * @return
	 */
	@RequestMapping("toModifyPermission.htm")
	public String toModifyPermission(int permissionId, Model model) {
		
		logger.info("进入修改权限信息页面，入参{}", permissionId);
		PermissionInfo permission = authorityService.getPermissionById(permissionId);
		model.addAttribute("item", permission);
		model.addAttribute("type", "modify");
		
		return "authority/permission_add.vm";
	}
	
	/**
	 * 修改权限信息
	 * @param permission
	 * @return
	 */
	@ResponseBody
	@RequestMapping("modifyPermission.json")
	public Object modifyPermission(PermissionOrder permission) {
		
		JSONObject json = new JSONObject();
		logger.info("修改权限操作，入参{}", permission);
		EsupplierBaseResult result = authorityService.modifyPermission(permission);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "修改权限成功");
		} else {
			json.put("code", 0);
			json.put("message", "修改权限失败");
		}
		
		return json;
	}
	
	/**
	 * 进入添加权限页面
	 * @return
	 */
	@RequestMapping("toAddPermission.htm")
	public String toAddPermission() {
		
		return "authority/permission_add.vm";
	}
	
	/**
	 * 添加权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addPermission.json")
	public Object addPermission(PermissionOrder permission) {
		
		JSONObject json = new JSONObject();
		logger.info("添加权限操作，入参{}", permission);
		EsupplierBaseResult result = authorityService.addPermission(permission);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "添加权限成功");
		} else {
			json.put("code", 0);
			json.put("message", "添加权限失败");
		}
		
		return json;
	}
	
	/**
	 * 验证是否权限ID
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping("existPermission.json")
	public Object existPermission(String code) {
		return authorityService.existPermisson(code);
	}
	
	/**
	 * 获取所有角色
	 * @return
	 */
	@RequestMapping("roles/{page}/{size}.htm")
	public String getAllRoles(	@PathVariable int page, @PathVariable int size, Model model,
								HttpServletRequest request) {
								
		RoleQueryOrder queryOrder = new RoleQueryOrder();
		queryOrder.setPageNumber(page);
		queryOrder.setPageSize(size);
		queryOrder.setRoleName(request.getParameter("roleName"));
		queryOrder.setRoleCode(request.getParameter("roleCode"));
		logger.info("查询所有角色操作，入参{}", queryOrder);
		QueryBaseBatchResult<RoleInfo> result = authorityService.getAllRoles(queryOrder);
		model.addAttribute("page", PageUtil.getCovertPage(result));
		
		return "authority/roles.vm";
	}
	
	/**
	 * 删除角色
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delRole.json")
	public Object delRole(int[] ids, String redirect) {
		
		JSONObject json = new JSONObject();
		logger.info("删除角色操作，入参角色ID{}", ids);
		EsupplierBaseResult result = authorityService.deleteRoles(ids);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "删除角色成功");
		} else {
			json.put("code", 0);
			json.put("message", "删除角色失败");
		}
		
		return json;
	}
	
	/**
	 * 修改角色信息
	 * @param roleId
	 * @param model
	 * @return
	 */
	@RequestMapping("toModifyRole.htm")
	public String toModifyRole(int roleId, Model model) {
		
		logger.info("修改角色操作，入参角色ID{}", roleId);
		RoleInfo role = authorityService.getRoleByRoleId(roleId);
		model.addAttribute("item", role);
		model.addAttribute("type", "modify");
		
		return "authority/role_add.vm";
	}
	
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("toAddRole.htm")
	public String toAddRole() {
		
		return "authority/role_add.vm";
	}
	
	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("modifyRole.json")
	public Object modifyRole(RoleOrder role, String redirect) {
		
		JSONObject json = new JSONObject();
		logger.info("修改角色信息操作，入参角色{}", role);
		/*默认admin类型*/
		if (role.getUserBizTypeEnum() == null) {
			role.setUserBizTypeEnum(UserBizTypeEnum.ADMIN);
		}
		EsupplierBaseResult result = authorityService.modifyRole(role);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "修改角色成功");
		} else {
			json.put("code", 0);
			json.put("message", "修改角色失败");
		}
		
		return json;
	}
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addRole.json")
	public Object addRole(RoleOrder role, String redirect) {
		role.setUserBizTypeEnum(UserBizTypeEnum.ADMIN);
		JSONObject json = new JSONObject();
		logger.info("添加角色信息操作，入参角色{}", role);
		/*默认admin类型*/
		if (role.getUserBizTypeEnum() == null) {
			role.setUserBizTypeEnum(UserBizTypeEnum.ADMIN);
		}
		EsupplierBaseResult result = authorityService.addRole(role);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "添加角色成功");
		} else {
			json.put("code", 0);
			json.put("message", "添加角色失败");
		}
		
		return json;
	}
	
	/**
	 * 验证是否存在角色
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping("existRole.json")
	public Object existRole(String code) {
		
		return authorityService.existRoleCode(code);
	}
	
	/**
	 * 根据用户ID获取角色列表
	 * @return
	 */
	@RequestMapping("grbu/{userId}/{page}/{size}")
	public String getRolesByUserId(	@PathVariable long userId, @PathVariable int page,
									@PathVariable int size, Model model) {
									
		List<RoleInfo> list = authorityService.getRolesByUserId(userId);
		
		model.addAttribute("page", list);
		
		return "authority/roles.vm";
	}
	
	/**
	 * 根据角色ID获取子角色
	 * @return
	 */
	//	@RequestMapping("gcbr/{roleId}/{page}/{size}")
	//	public String getChildrenByRoleId(@PathVariable int roleId, @PathVariable int page,
	//										@PathVariable int size, Model model) {
	//		model.addAttribute("page",
	//			authorityService.getChildrenByRoleId(roleId, (page - 1) * size, size));
	//		return "authority/roles.vm";
	//	}
	
	/**
	 * 根据角色获取权限列表
	 * @return
	 */
	@RequestMapping("gpbr/{roleId}/{page}/{size}")
	public String getPermissionsByRoleId(	@PathVariable int roleId, @PathVariable int page,
											@PathVariable int size, Model model) {
											
		List<PermissionInfo> list = authorityService.getPermissionsByRoleId(roleId);
		
		model.addAttribute("page", list);
		
		return "authority/permissions.vm";
	}
	
	/**
	 * 根据用户ID获取可授予的角色
	 * @return
	 */
	@RequestMapping("ggrbu/{userId}/{page}/{size}")
	public String getGrantableRolesByUserId(@PathVariable long userId, @PathVariable int page,
											@PathVariable int size, Model model) {
		List<RoleInfo> list = authorityService.getGrantableRolesByUserId(userId);
		
		model.addAttribute("page", list);
		
		return "authority/roles.vm";
	}
	
	/**
	 * 根据角色ID获取可授予的权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ggpbr/{roleId}/{page}/{size}.json")
	public Object getGrantablePermissionsByRoleId(	@PathVariable int roleId, @PathVariable int page,
													@PathVariable int size, Model model) {
													
		JSONObject json = new JSONObject();
		RoleInfo role = authorityService.getRoleByRoleId(roleId);
		List<PermissionInfo> list = authorityService.getGrantablePermissionsByRoleId(roleId);
		model.addAttribute("page", list);
		List<PermissionInfo> permissions = new ArrayList<>();
		//只展示后台的权限
		for (PermissionInfo p : list) {
			if(role.getUserBizTypeEnum()==UserBizTypeEnum.ADMIN) {
				if (p.getPermissionOperate().startsWith("/admin")) {
					permissions.add(p);
				}
			}else{
				if (!p.getPermissionOperate().startsWith("/admin")) {
					permissions.add(p);
				}
			}
		}
		json.put("permissions", permissions);
		
		List<PermissionInfo> list1 = authorityService.getPermissionsByRoleId(roleId);
		json.put("permissions1", list1);
		
		return json;
	}
	
	/**
	 * 根据角色ID获取授予的权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("permissionsHad/{roleId}/{page}/{size}.json")
	public Object getpermissionsHadByRoleId(@PathVariable int roleId, @PathVariable int page,
											@PathVariable int size, Model model) {
		JSONObject json = new JSONObject();
		List<PermissionInfo> list = authorityService.getPermissionsByRoleId(roleId);
		model.addAttribute("page", list);
		json.put("result", list);
		return json;
	}
	
	/**
	 * 给用户授予角色
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@RequestMapping("grantrtu/{userId}")
	public String grantRolesToUser(@PathVariable long userId, int[] roleIds) {
		authorityService.grantRolesToUser(userId, roleIds);
		return "";
	}
	
	/**
	 * 给角色授予权限
	 * @param roleId
	 * @param permissionIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("grantptr/{roleId}.json")
	public Object grantPermissionsToRole(	@PathVariable int roleId, int[] permissionIds,
											Model model) {
											
		JSONObject json = new JSONObject();
		logger.info("给角色授予权限操作，入参角色{}", roleId, "权限{}", permissionIds);
		EsupplierBaseResult result = authorityService.grantPermisssionsToRole(roleId,
			permissionIds);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "角色授予权限成功");
		} else {
			json.put("code", 0);
			json.put("message", "角色授予权限失败");
		}
		
		return json;
	}
	
	/**
	 * 给角色授予权限(先删除角色原来的权限，再赋予新权限)
	 * @param roleId
	 * @param permissionIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("grantptroldd/{roleId}.json")
	public Object grantPermissionsToRoleOldDelete(@PathVariable int roleId, int[] permissionIds) {
		JSONObject json = new JSONObject();
		logger.info("给角色授予权限操作，入参角色{}", roleId, "权限{}", permissionIds);
		EsupplierBaseResult result = authorityService.grantPermisssionsToRoleDeleteOld(roleId,
			permissionIds);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "角色授予权限成功");
		} else {
			json.put("code", 0);
			json.put("message", "角色授予权限失败");
		}
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping("grantToRole")
	public String grantToRole(int roleId, int[] permissionIds) {
		try {
			authorityService.grantPermisssionsToRoleDeleteOld(roleId, permissionIds);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	/**
	 * 给角色解除权限
	 * @param roleId
	 * @param permissionIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("removeptr/{roleId}")
	public Object removePermissions(@PathVariable int roleId, int[] permissionIds) {
		authorityService.removePermissions(roleId, permissionIds);
		return "";
	}
	
	/**
	 * 给用户解除角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("unbindrtu/{userId}")
	public Object unbind(@PathVariable int userId, int[] roleIds) {
		authorityService.unbindRoles(userId, roleIds);
		return "";
	}
	
	//	@RequestMapping("moduleManage")
	//	public String moduleManage(PermissionModuleQueryOrder queryOrder, Model model) {
	//		model.addAttribute("queryOrder", queryOrder);
	//		model.addAttribute("page",
	//			PageUtil.getCovertPage(authorityService.getPermissionsPagesSortByModule(queryOrder)));
	//		return "authority/moduleManage.vm";
	//	}
	//	
	//	@RequestMapping("moduleList")
	//	public String permissionList(PermissionModuleQueryOrder queryOrder, Model model) {
	//		model.addAttribute("queryOrder", queryOrder);
	//		model.addAttribute("moduleList",
	//			authorityService.getPermissionsSortByModuleSearch(queryOrder));
	//		return "authority/moduleList.vm";
	//	}
	//	
	//	@ResponseBody
	//	@RequestMapping("saveModule")
	//	public String saveModule(int moduleId, String moduleName, String moduleDesc) {
	//		PermissionModuleInfo info = new PermissionModuleInfo();
	//		info.setModuleId(moduleId);
	//		info.setModuleName(moduleName);
	//		info.setModuleDesc(moduleDesc);
	//		
	//		try {
	//			authorityService.saveModule(info);
	//			return "1";
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			return "0";
	//		}
	//	}
	//	
	//	@ResponseBody
	//	@RequestMapping("addToModule")
	//	public String addToModule(int selModuleId, int[] permissionIds) {
	//		try {
	//			authorityService.addToModule(selModuleId, permissionIds);
	//			return "1";
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			return "0";
	//		}
	//	}
	//	
	//	@ResponseBody
	//	@RequestMapping("delModule")
	//	public String delModule(int moduleId) {
	//		try {
	//			authorityService.deleteModule(moduleId);
	//			return "1";
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			return "0";
	//		}
	//	}
}
