package com.yjf.esupplier.web.controller.openapi;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.common.services.DateSeqService;
import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.service.product.StorageService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.ws.common.enums.SeqNameEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.order.ProductSearchOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.storage.enums.StorageBillTypeEnum;
import com.yjf.esupplier.ws.storage.order.StorageUpdateOrder;

@Controller
@RequestMapping("openApi")
public class ErpOpenApiController extends BaseAutowiredController {
	@Autowired
	StorageService storageService;
	
	@Autowired
	ProductService productService;
	@Autowired
	DateSeqService dateSeqService;
	
	@RequestMapping("erpOpenApi")
	public String erpOpenApi(HttpServletRequest request, HttpServletResponse response,
								ModelMap modelMap) {
		JSONObject retJsonObject = new JSONObject();
		try {
			String c = request.getParameter("c");
			if (StringUtil.equals(c, "c1")) {
				String d = request.getParameter("d");
				HashMap<String, Object> jsonObject = MiscUtil.parseJSON(d);
				String productCode = (String) jsonObject.get("i1");
				String i2 = String.valueOf(jsonObject.get("i2"));
				ProductSearchOrder productSearchOrder = new ProductSearchOrder();
				productSearchOrder.setProductNumber(productCode);
				QueryBaseBatchResult<ProductInfo> batchResult = productService
					.getProductList(productSearchOrder);
				if (ListUtil.isEmpty(batchResult.getPageList())) {
					retJsonObject.put("a", "201");
				} else {
					ProductInfo productInfo = batchResult.getPageList().get(0);
					StorageUpdateOrder storageUpdateOrder = new StorageUpdateOrder();
					storageUpdateOrder.setStorageBillTypeEnum(StorageBillTypeEnum.AOTO_SYNCHRONIZE);
					storageUpdateOrder.setBillNo("autosy"
													+ dateSeqService.getNextDateSeq(
														SeqNameEnum.STORAGE_IN_OUT_SEQ, "", 12));
					storageUpdateOrder.setBillTime(new Date());
					storageUpdateOrder.setProductId(productInfo.getProductId());
					storageUpdateOrder.setSupplierId(productInfo.getSupplierId());
					storageUpdateOrder.setStockAmount(NumberUtil.parseLong(i2));
					EsupplierBaseResult baseResult = storageService
						.saveStorageProductChange(storageUpdateOrder);
					if (baseResult.isSuccess()) {
						retJsonObject.put("a", "200");
					} else {
						retJsonObject.put("a", "500");
					}
				}
			} else if (StringUtil.equals(c, "c2")) {
				retJsonObject.put("a", "200");
			} else {
				retJsonObject.put("a", "600");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			retJsonObject.put("a", "500");
		}
		printHttpResponse(response, retJsonObject);
		return null;
	}
}
