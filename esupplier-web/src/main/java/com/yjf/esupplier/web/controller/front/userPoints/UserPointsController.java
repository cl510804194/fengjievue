package com.yjf.esupplier.web.controller.front.userPoints;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.config.TerracottaConfiguration.ValueMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.domain.context.EsupplierDomainHolder;
import com.yjf.esupplier.domain.service.repository.PointsRuleDomainRepository;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.UserAccountDataQueryService;
import com.yjf.esupplier.service.user.info.UserAccountDataInfo;
import com.yjf.esupplier.service.user.integral.PointsRuleService;
import com.yjf.esupplier.service.user.integral.UserPointsService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTradeTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.integral.enums.PointsRuleStateEnum;
import com.yjf.esupplier.ws.integral.info.PointsRuleInfo;
import com.yjf.esupplier.ws.integral.info.UserPointsDetailInfo;
import com.yjf.esupplier.ws.integral.order.UserPointsDetailQueryOrder;
import com.yjf.esupplier.ws.service.query.order.PointsRuleQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;
@Controller
@RequestMapping("do/userPoints/")
public class UserPointsController  extends BaseAutowiredController{
	@Autowired
	UserPointsService userPointsService;
	@Autowired
	PointsRuleDomainRepository pointsRuleDomainRepository;
	@Autowired
	PointsRuleService pointsRuleService;
	@Autowired
	UserAccountDataQueryService userAccountDataQueryService;
	private final String USER_MANAGE_PATH = "front/userPoints/";
	
	@RequestMapping(value = "pageQueryUserPoints.htm")
	public String pageQueryUserPoints(HttpServletRequest request, HttpServletResponse response, 
			Model model) {
		try {
			
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			UserPointsDetailQueryOrder pointsDetailQueryOrder = new UserPointsDetailQueryOrder();
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			pointsDetailQueryOrder.setUserId(userId);
			pointsDetailQueryOrder.setPageNumber(pages);
			pointsDetailQueryOrder.setPageSize(pagesize);
			QueryBaseBatchResult<UserPointsDetailInfo> baseBatchResult = userPointsService
					.queryDetailUserPoints(pointsDetailQueryOrder);
			//baseBatchResult.getPageList();
			PageTool page = new PageTool();
			page.setCurrentPage(pages);
			page.setPageSize(pagesize);
			page.setTotalRow(baseBatchResult.getTotalCount());
			String pageBar = page.getPageBar();
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("userPointsList", baseBatchResult.getPageList());
			
			PointsRuleQueryOrder ruleQueryOrder = new PointsRuleQueryOrder();
			ruleQueryOrder.setState(PointsRuleStateEnum.NORMAL);
			ruleQueryOrder.setStartDate(new Date());
			ruleQueryOrder.setEndDate(new Date());
			ruleQueryOrder.setValueType(UserLevelRuleType.POINT);
			QueryBaseBatchResult<PointsRuleInfo> batchRuleResult = pointsRuleService
				.queryPointsRule(ruleQueryOrder);
			//baseBatchResult.getPageList();
			PageTool pageRule = new PageTool();
			pageRule.setCurrentPage(pages);
			pageRule.setPageSize(pagesize);
			pageRule.setTotalRow(baseBatchResult.getTotalCount());
			String pageRuleBar = pageRule.getPageBar();
			model.addAttribute("userPointsRuleList", batchRuleResult.getPageList());
			model.addAttribute("pageRuleBar", pageRuleBar);
			
			UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService.getUserAccountDataInfo(userId,false);
			model.addAttribute("userIntegral",userAccountDataInfo.getUserIntegral());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return USER_MANAGE_PATH + "pageQueryUserPointsInfo.vm";
	}
	
}
