package com.yjf.esupplier.web.controller.front.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.storage.enums.StorageBillTypeEnum;
import com.yjf.esupplier.ws.storage.info.ProductStorageDetailInfo;
import com.yjf.esupplier.ws.storage.info.ProductStorageInfo;
import com.yjf.esupplier.ws.storage.info.StorageInOutDetailInfo;
import com.yjf.esupplier.ws.storage.info.StorageInOutInfo;
import com.yjf.esupplier.ws.storage.order.StorageUpdateOrder;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

@Controller
@RequestMapping("/do/storage")
public class StorageController extends FrontAutowiredBaseController {
	final static String path = "front/platform/member/product/";
	
	@RequestMapping("seller/toStorageList.htm")
	public String toStorageList(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		SupplierInfo supplier = supplierService.getCurrentSupplier();
		String productName = request.getParameter("productName");
		long supplierId = supplier.getSupplierId();
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		int intPage = 1;
		int intPageSize = 15;
		if (StringUtil.isNotBlank(page)) {
			intPage = NumberUtil.parseInt(page);
		}
		if (StringUtil.isNotBlank(pageSize)) {
			intPageSize = NumberUtil.parseInt(pageSize);
		}
		
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage(intPage);
		pageTool.setPageSize(intPageSize);
		QueryBaseBatchResult<ProductStorageInfo> batchResult = storageService.getStorageList(
			supplierId, productName, intPage, intPageSize);
		pageTool.setTotalRow(batchResult.getTotalCount());
		String pageBar = pageTool.getPageBar();
		int startCount = (intPage - 1) * intPageSize;
		int endCount = intPage * intPageSize;
		List<ProductStorageInfo> listStorage = batchResult.getPageList();
		model.addAttribute("productName", productName);
		model.addAttribute("listStorage", listStorage);
		
		model.addAttribute("pageBar", pageBar);
		return path + "storageList.vm";
	}
	
	@RequestMapping("seller/toStorageListIn.htm")
	public String toStorageListIn(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String string = request.getParameter("ids");
		String[] ids = string.split(",");
		List<ProductStorageInfo> listStorage = storageService.getStorageListOnChange(ids);
		//权限控制
		long supplierId = supplierService.getSupplierId();
		for (ProductStorageInfo ps : listStorage) {
			long productId = ps.getProductId();
			ProductInfo p = productService.getProductById(productId);
			ps.setProductName(p.getProductName());
			ps.setSmallPicPath(p.getSmallPicPath());
			long supplierId1 = p.getSupplierId();
			if (supplierId != supplierId1) {
				return getNoAccessView();
			}
		}
		model.addAttribute("listStorage", listStorage);
		return path + "storageListIn.vm";
	}
	
	@RequestMapping("seller/toStorageListOut.htm")
	public String toStorageListOut(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String string = request.getParameter("ids");
		String[] ids = string.split(",");
		List<ProductStorageInfo> listStorage = storageService.getStorageListOnChange(ids);
		//权限控制
		long supplierId = supplierService.getSupplierId();
		for (ProductStorageInfo ps : listStorage) {
			long productId = ps.getProductId();
			ProductInfo p = productService.getProductById(productId);
			ps.setProductName(p.getProductName());
			ps.setSmallPicPath(p.getSmallPicPath());
			long supplierId1 = p.getSupplierId();
			if (supplierId != supplierId1) {
				return getNoAccessView();
			}
		}
		//
		model.addAttribute("listStorageInOut", listStorage);
		return path + "storageListOut.vm";
	}
	
	@RequestMapping("seller/insertStorageInOut.htm")
	public String insertStorageInOut(HttpServletRequest request, HttpServletResponse response,
										Model model) throws Exception {
		StorageUpdateOrder storageInOutInfo = new StorageUpdateOrder();
		WebUtil.setPoPropertyByRequest(storageInOutInfo, request);
		storageInOutInfo.setSupplierId(supplierService.getSupplierId());
		storageInOutInfo.setStorageBillTypeEnum(StorageBillTypeEnum.getByCode(request
			.getParameter("billType")));
		List<StorageInOutDetailInfo> siods = new ArrayList<StorageInOutDetailInfo>();
		String[] productIds = request.getParameterValues("productIds");
		if (productIds != null) {
			
			for (String id : productIds) {
				StorageInOutDetailInfo siod = new StorageInOutDetailInfo();
				siod.setProductId(NumberUtil.parseInt(id));
				siod.setBillAmount(NumberUtil.parseInt(request.getParameter("storageMap_" + id)));
				siods.add(siod);
			}
		}
		storageInOutInfo.setDetailInfos(siods);
		EsupplierBaseResult baseResult = storageService.saveStorageProductChange(storageInOutInfo);
		if (baseResult.isSuccess()) {
			model.addAttribute("message", "操作成功！");
		} else
			model.addAttribute("message", baseResult.getMessage());
		return path + "createSuccess.vm";
	}
	
	@RequestMapping("seller/toStorageInOutList.htm")
	public String toStorageInOutList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		String billNum = request.getParameter("billNum");
		String id = request.getParameter("id");
		String billType = request.getParameter("billType");
		if (billType == null || billType.trim().equals("all")) {
			billType = "";
		}
		Integer supplierId = supplierService.getSupplierId().intValue();
		int page = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pageSize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage(page);
		pageTool.setPageSize(pageSize);
		QueryBaseBatchResult<StorageInOutInfo> batchResult = storageService.findStorageInOutList(
			NumberUtil.parseLong(id), billNum, billType, supplierId, page, pageSize);
		pageTool.setTotalRow(batchResult.getTotalCount());
		String pageBar = pageTool.getPageBar();
		model.addAttribute("pageBar", pageBar);
		
		List<StorageInOutInfo> listStorageInOut = batchResult.getPageList();
		model.addAttribute("listStorageInOut", listStorageInOut);
		model.addAttribute("billNum", billNum);
		model.addAttribute("billType", billType);
		model.addAttribute("billTypeList", StorageBillTypeEnum.getAllEnum());
		model.addAttribute("id", id);
		return path + "storageListInOut.vm";
	}
	
	@RequestMapping("seller/tolistStorageInOutSee.htm")
	public String tolistStorageInOutSee(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		String id = request.getParameter("id");
		StorageInOutInfo storageInOut = storageService.getStorageInOutById(id);
		//权限控制
		long supplierId = supplierService.getSupplierId();
		long i = storageInOut.getHandleMan();
		if (supplierId != i) {
			return path + "input.vm";
		}
		//
		List<ProductStorageDetailInfo> listStorageInOutDetail = storageService
			.getStorageInOutDetailByPid(id);
		model.addAttribute("listStorageInOutDetail", listStorageInOutDetail);
		return path + "storageListOut.vm";
	}
	
}
