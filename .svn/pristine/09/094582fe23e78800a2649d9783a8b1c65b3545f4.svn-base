package com.yjf.esupplier.web.controller.front.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.service.bill.DrawerAddressService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.ws.bill.order.DrawerAddressSaveOrder;
import com.yjf.esupplier.ws.enums.AddressBooleanEnum;
import com.yjf.esupplier.ws.info.DrawerAddressInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@Controller
@RequestMapping("/do/addressManager")
public class AddressManagerController extends FrontAutowiredBaseController {
	@Autowired
	DrawerAddressService drawerAddressService;
    final static String vm_path = "front/platform/member/address/";
	
	/**
	 * 会员查询自己地址管理栏 2010-5-11
	 * 
	 * @return
	 * @author yuwenqiang
	 */
	@RequestMapping("buyer/myAddressList.htm")
	public String myAddressList(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		List<DrawerAddressInfo> addressesInfos = drawerAddressService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		model.addAttribute("addressesInfos", addressesInfos);
		return vm_path + "myAddressList.vm";
	}
	
	@RequestMapping("buyer/saveAddressInfo.htm")
	public String saveAddressInfo(HttpServletRequest request, HttpServletResponse response,
									Model model, String drawerName, String area,
									String detailAddress, String zipCode, String drawerNumber,
									String mobileNumber, String defaultAddress, String addId) {
		DrawerAddressSaveOrder addressOrder = new DrawerAddressSaveOrder();
		addressOrder.setDrawerName(drawerName);
		addressOrder.setAreaCode(area);
		addressOrder.setCity(request.getParameter("city"));
		addressOrder.setProvince(request.getParameter("province"));
		addressOrder.setDetailAddress(detailAddress);
		addressOrder.setZipCode(zipCode);
		addressOrder.setDrawerNumber(drawerNumber);
		addressOrder.setMobileNumber(mobileNumber);
		if (StringUtil.isNotEmpty(defaultAddress)) {
			addressOrder.setIsDefault(AddressBooleanEnum.getByCode(defaultAddress).code());
		} else {
			addressOrder.setIsDefault(AddressBooleanEnum.NO.code());
		}
		addressOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		/** 一个用户只能有一个默认收货地址 */
		
		if (StringUtil.isNotBlank(addId)) {
			addressOrder.setId(addId);
			drawerAddressService.updateDrawerAddress(addressOrder);
		} else {
			drawerAddressService.saveDrawerAddress(addressOrder);
		}
		
		List<DrawerAddressInfo> addressesInfos = drawerAddressService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		model.addAttribute("addressesInfos", addressesInfos);
		sendUrl(response, "/do/addressManager/buyer/myAddressList.htm");
		return null;
	}
	
	/**
	 * 删除存在的收货地址 2010-5-11
	 * 
	 * @return
	 * @author yuwenqiang
	 */
	@RequestMapping("buyer/deleteAddressInfo.htm")
	public String deleteAddressInfo(HttpServletRequest request, HttpServletResponse response,
									Model model, Long addId) {
		drawerAddressService.deleteAddressById(String.valueOf(addId));
		List<DrawerAddressInfo> addressesInfos = drawerAddressService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		model.addAttribute("addressesInfos", addressesInfos);
		sendUrl(response, "/do/addressManager/buyer/myAddressList.htm");
		return null;
	}
	
	@RequestMapping("buyer/updateAddressInfo.htm")
	public String updateAddressInfo(HttpServletRequest request, HttpServletResponse response,
									Model model, String drawerName, String area,
									String detailAddress, String zipCode, String drawerNumber,
									String mobileNumber, String addId) {
		
		List<DrawerAddressInfo> addressesInfos = drawerAddressService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		DrawerAddressInfo addressesInfo = drawerAddressService.findDrawerAddressById(addId);
		model.addAttribute("addressesInfos", addressesInfos);
		if (ShiroSessionUtils.getSessionLocal().getUserId() == addressesInfo.getUserId()) {
			model.addAttribute("addressesInfo", addressesInfo);
			model.addAttribute("addId", addId);
		}
		return vm_path + "myAddressList.vm";
	}
	
	@RequestMapping("addressList.htm")
	public String addressList(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<DrawerAddressInfo> addressesInfos = drawerAddressService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		model.addAttribute("addressesInfos", addressesInfos);
		sendUrl(response, "/do/addressManager/buyer/myAddressList.htm");
		return null;
	}
	
	/**
	 * 设置默认地址
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param addId
	 * @return
	 */
	@RequestMapping("buyer/saveDefaultAddressInfo.json")
	public String saveDefaultAddressInfo(HttpServletRequest request, HttpServletResponse response,
											Model model, String addId) {
		
		DrawerAddressInfo drawerAddressInfo = drawerAddressService.findDrawerAddressById(addId);
		DrawerAddressSaveOrder addressOrder = new DrawerAddressSaveOrder();
		BeanCopier.staticCopy(drawerAddressInfo, addressOrder);
		addressOrder.setIsDefault(AddressBooleanEnum.YES.code());
		addressOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		/** 一个用户只能有一个默认收货地址 */
		
		if (StringUtil.isNotBlank(addId)) {
			drawerAddressService.updateDrawerAddress(addressOrder);
		}
		List<DrawerAddressInfo> addressesInfos = drawerAddressService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		model.addAttribute("addressesInfos", addressesInfos);
		sendUrl(response, "/do/addressManager/buyer/myAddressList.htm");
		return null;
	}


    /**
     * 提交订单页面新增收货地址
     * @param request
     * @param response
     * @param model
     * @param drawerName
     * @param area
     * @param detailAddress
     * @param zipCode
     * @param drawerNumber
     * @param mobileNumber
     * @param defaultAddress
     * @param addId
     * @return
     */
    @ResponseBody
    @RequestMapping("buyer/saveOrderAddressInfo.htm")
    public Object saveOrderAddressInfo(HttpServletRequest request, HttpServletResponse response,
                                  Model model, String drawerName, String area,
                                  String detailAddress, String zipCode, String drawerNumber,
                                  String mobileNumber, String defaultAddress, String addId) {
        JSONObject jsonObject = new JSONObject();
        
        DrawerAddressSaveOrder addressOrder = new DrawerAddressSaveOrder();
        addressOrder.setDrawerName(drawerName);
        addressOrder.setAreaCode(area);
        addressOrder.setCity(request.getParameter("city"));
        addressOrder.setProvince(request.getParameter("province"));
        addressOrder.setDetailAddress(detailAddress);
        addressOrder.setZipCode(zipCode);
        addressOrder.setDrawerNumber(drawerNumber);
        addressOrder.setMobileNumber(mobileNumber);
        if (StringUtil.isNotEmpty(defaultAddress)) {
            addressOrder.setIsDefault(AddressBooleanEnum.getByCode(defaultAddress).code());
        } else {
            addressOrder.setIsDefault(AddressBooleanEnum.NO.code());
        }
        addressOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
        /** 一个用户只能有一个默认收货地址 */

         EsupplierBaseResult baseResult =  drawerAddressService.saveDrawerAddress(addressOrder);
        
        if(baseResult.isSuccess()){
            jsonObject.put("code",1);
            jsonObject.put("message","新增收货地址成功");
        }else{
            jsonObject.put("code",0);
            jsonObject.put("message","新增收货地址失败");
        }

        return jsonObject;
    }



}
