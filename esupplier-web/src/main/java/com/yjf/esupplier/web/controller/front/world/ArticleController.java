package com.yjf.esupplier.web.controller.front.world;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.pop.IPopModuleService;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.PopModuleVOInfo;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.order.ProductRecommendOrder;

@Controller
@RequestMapping("/front/platform/world")
public class ArticleController extends FrontAutowiredBaseController {
	final static String path = "front/platform/world/";
	@Autowired
	IPopService popService;
	@Autowired
	IPopModuleService popModuleService;
	
	@RequestMapping("displayArticle.htm")
	public String getArticleInfo(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		PopModuleVOInfo popModuleVOInfo = popModuleService.getPopModule("article");
		long popId = Long.parseLong(request.getParameter("popId"));
		PopInfo PopInfo = popService.getByPopId(popId);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("popId",popId);
		conditions.put("type",popModuleVOInfo.getModuleId());
		Long beforePopId = popService.getBeforePopId(conditions);
		if (beforePopId == null||beforePopId==0) {
			model.addAttribute("beforePopId", 0);
		} else {
			PopInfo beforePopInfo = popService.getByPopId(beforePopId);
			model.addAttribute("beforePopId", beforePopId);
			model.addAttribute("beforePopInfo", beforePopInfo);
		}
		Long afterPopId = popService.getAfterPopId(conditions);
		if (afterPopId == null||afterPopId==0) {
			model.addAttribute("afterPopId", 0);
		} else {
			PopInfo afterPopInfo = popService.getByPopId(afterPopId);
			model.addAttribute("afterPopId", afterPopId);
			model.addAttribute("afterPopInfo", afterPopInfo);
		}
		/*推荐商品*/
		ProductRecommendOrder productRecommendOrder = new ProductRecommendOrder();
		productRecommendOrder.setProductStatus(ProductStatusEnum.ON);
		productRecommendOrder.setProductType("0001-0001-0002");
		productRecommendOrder.setPageNumber(1);
		productRecommendOrder.setPageSize(4);
		productRecommendOrder.setRecommendType(ProductRecommendTypeEnum.PRODUCT_TOP);
		List<ProductInfo> commendProduct = productRecommendService
				.getProductRecommendList(productRecommendOrder).getPageList();
		model.addAttribute("commendProduct", commendProduct);
		//查询属性值
		model.addAttribute("PopInfo", PopInfo);
		return path + "articleInfo.vm";
	}
	
	@RequestMapping("articleList.htm")
	public String getArticleList(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		PopModuleVOInfo popModuleVOInfo = popModuleService.getPopModule("article");
		//request请求参数
		int pageno = NumberUtil.parseInt(request.getParameter("page"), 1); //页码
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 20); //页显示量
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("type", popModuleVOInfo.getModuleId());
		conditions.put("status", 2);//上线的
		PageParam pageParam = new PageParam();
		pageParam.setPageNo(pageno);
		pageParam.setPageSize(pagesize);
		Page<PopInfo> page = popService.getPageByConditionsNew(pageParam, conditions);
		model.addAttribute("page", page);
		model.addAttribute("articleList", page.getResult());
		return path + "articleList.vm";
	}
}
