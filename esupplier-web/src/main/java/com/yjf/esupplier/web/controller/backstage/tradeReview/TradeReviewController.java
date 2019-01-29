package com.yjf.esupplier.web.controller.backstage.tradeReview;

import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.dal.daointerface.TblProductScoreDAO;
import com.yjf.esupplier.dal.daointerface.TblTradeReviewDAO;
import com.yjf.esupplier.dal.dataobject.TblProductScoreDO;
import com.yjf.esupplier.dal.dataobject.TblTradeReviewDO;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.review.info.TradeReviewInfo;
import com.yjf.esupplier.ws.review.order.TradeReviewQueryOrder;
import com.yjf.esupplier.ws.review.services.TradeReviewService;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by liugy on 2016/4/7.
 */

@Controller
@RequestMapping("/admin/tradeReview/")
public class TradeReviewController extends BaseAutowiredController {
	
	/**
	 * 通用页面路径
	 */
	private final String vm_path = "/backstage/systemManage/tradeReview/";
	
	@Autowired
	TradeReviewService tradeReviewService;
	
	@Autowired
	TblProductScoreDAO tblProductScoreDAO;
	
	@Autowired
	TblTradeReviewDAO tblTradeReviewDAO;
	
	/**
	 * 查询所有的商品评价
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("queryTradeAll.htm")
	public String queryTradeAll(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		try {
			int pageSize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			String orderId = request.getParameter("orderId");
			TradeReviewQueryOrder tradeQueryOrder = new TradeReviewQueryOrder();
			tradeQueryOrder.setPageSize(pageSize);
			tradeQueryOrder.setPageNumber(pages);
			tradeQueryOrder.setOrderId(NumberUtil.parseLong(orderId));
			QueryBaseBatchResult<TradeReviewInfo> baseBatchResult = tradeReviewService
				.queryTradeReview(tradeQueryOrder);
			PageTool pageTool = new PageTool();
			pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
			pageTool.setPageSize((int) baseBatchResult.getPageSize());
			pageTool.setTotalRow(baseBatchResult.getTotalCount());
			List<TradeReviewInfo> listP = baseBatchResult.getPageList();
			
			model.addAttribute("page", PageUtil.getCovertPageByPageTools(listP, pageTool));
			model.addAttribute("orderId", orderId);
		} catch (Exception e) {
			logger.error("商品评价查询失败" + e.getMessage(), e);
		}
		return vm_path + "tradeReviewList.vm";
	}
	
	/**
	 * 删除商品评价
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteTradeReview.htm")
	public String deleteTradeReview(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		try {
			int reviewId = NumberUtil.parseInt(request.getParameter("reviewId"), 0);
			TblProductScoreDO searchScoreDO = new TblProductScoreDO();
			TblTradeReviewDO tblTradeReviewDO = tblTradeReviewDAO.findById(reviewId);
			EsupplierBaseResult baseResult = tradeReviewService.delTradeReview(reviewId);
			searchScoreDO.setOrderId(tblTradeReviewDO.getOrderId());
			List<TblProductScoreDO> scoreDOs = tblProductScoreDAO.findByCondition(searchScoreDO, 0,
				10, null, null, 0, 5);
			for (TblProductScoreDO scoreDO : scoreDOs) {
				tblProductScoreDAO.deleteById(scoreDO.getId());
			}
			if (baseResult.isSuccess()) {
				response.sendRedirect("/admin/tradeReview/queryTradeAll.htm");
			}
		} catch (Exception e) {
			logger.error("删除评价失败" + e.getMessage(), e);
		}
		return null;
	}
	
}
