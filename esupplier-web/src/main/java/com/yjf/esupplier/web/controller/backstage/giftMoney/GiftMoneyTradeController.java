package com.yjf.esupplier.web.controller.backstage.giftMoney;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTradeTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/admin/giftMoney")
public class GiftMoneyTradeController extends BaseAutowiredController {
	/**
	 * 页面所在路径
	 */
	private final String BORROWING_MANAGE__PATH = "/backstage/giftMoney/";
	
	@Autowired
	GiftMoneyTradeQueryService giftMoneyTradeQueryService;
	
	/**
	 * 领取 分页查询
	 */
	@RequestMapping(value = "pageQueryGiftMoneyTrade.htm")
	public String pageQueryGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder, PageParam pageParam,
											Model model) {
		try {
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			queryOrder.setTradeType(GiftMoneyTradeTypeEnum.ORIGINAL.getCode());
			String username = null;
			if (StringUtil.isNotEmpty(queryOrder.getUsername())) {
				username = queryOrder.getUsername();
				queryOrder.setUsername("%" + queryOrder.getUsername() + "%");
			}
			QueryBaseBatchResult<GiftMoneyTradeInfo> page = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(queryOrder);
			queryOrder.setUsername(username);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BORROWING_MANAGE__PATH + "pageQueryGiftMoneyTradeInfo.vm";
	}
	
	/**
	 * 使用领取 分页查询
	 */
	@RequestMapping(value = "pageQueryUseGiftMoneyTrade.htm")
	public String pageQueryUseGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder,
												PageParam pageParam, Model model) {
		try {
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			String username = null;
			if (StringUtil.isNotEmpty(queryOrder.getUsername())) {
				username = queryOrder.getUsername();
				queryOrder.setUsername("%" + queryOrder.getUsername() + "%");
			}
			queryOrder.setTradeType(GiftMoneyTradeTypeEnum.USED.getCode());
			QueryBaseBatchResult<GiftMoneyTradeInfo> page = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(queryOrder);
			queryOrder.setUsername(username);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BORROWING_MANAGE__PATH + "pageQueryUseGiftMoneyTradeInfo.vm";
	}
	
	/**
	 * 下载优惠券领取详情
	 * @param response
	 * @param queryOrder
	 */
	@RequestMapping("downUseGiftMoneyTrade.htm")
	public void downUseGiftMoneyTrade(HttpServletResponse response,
										GiftMoneyTradeQueryOrder queryOrder) {
		try {
			queryOrder.setPageNumber(1);
			queryOrder.setPageSize(1000);
			queryOrder.setTradeType(GiftMoneyTradeTypeEnum.ORIGINAL.getCode());
			if (StringUtil.isNotEmpty(queryOrder.getUsername())) {
				queryOrder.setUsername("%" + queryOrder.getUsername() + "%");
			}
			QueryBaseBatchResult<GiftMoneyTradeInfo> page = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(queryOrder);
			HSSFWorkbook wb = new HSSFWorkbook();//建立新HSSFWorkbook对象
			HSSFSheet sheet = wb.createSheet("查询数据");//建立新的sheet对象
			List<GiftMoneyTradeInfo> giftlist = page.getPageList();
			if (giftlist != null && giftlist.size() > 0) {
				String[] title = { "账户名", "手机号", "所属优惠券", "领取金额(元)", "已使用金额(元)", "优惠券开始时间",
									"优惠券结束时间", "领取时间", "使用时间", "优惠券用途", "状态" };
				HSSFRow row = sheet.createRow(0);
				HSSFCellStyle style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
				for (int i = 0; i < title.length; i++) {
					HSSFCell cell = row.createCell((short) i);
					cell.setCellValue(title[i]);
					cell.setCellStyle(style);
				}
				for (int j = 0; j < giftlist.size(); j++) {
					row = sheet.createRow(j + 1);
					row.createCell(0).setCellValue(giftlist.get(j).getUsername());
					row.createCell(1).setCellValue(giftlist.get(j).getPhoneNum());
					row.createCell(2).setCellValue(giftlist.get(j).getGiftName());
					row.createCell(3).setCellValue(giftlist.get(j).getAmount().toStandardString());
					row.createCell(4).setCellValue(
						giftlist.get(j).getUsedAmount().toStandardString());
					row.createCell(5).setCellValue(
						DateUtil.simpleFormat(giftlist.get(j).getStartDate()));
					row.createCell(6).setCellValue(
						DateUtil.simpleFormat(giftlist.get(j).getEndDate()));
					row.createCell(7).setCellValue(
						DateUtil.simpleFormat(giftlist.get(j).getRawAddTime()));
					row.createCell(8).setCellValue(
						DateUtil.simpleFormat(giftlist.get(j).getRawUpdateTime()));
					String useType = giftlist.get(j).getUseType();
					if (useType.equalsIgnoreCase("INVEST")) {
						row.createCell(9).setCellValue("投资");
					} else {
						row.createCell(9).setCellValue("");
					}
					GiftMoneyStatusEnum status = giftlist.get(j).getStatus();
					if (status == GiftMoneyStatusEnum.NORMAL) {
						row.createCell(10).setCellValue("未使用");
					} else if (status == GiftMoneyStatusEnum.EXPIRE) {
						row.createCell(10).setCellValue("过期");
					} else {
						row.createCell(10).setCellValue("已使用");
					}
				}
				OutputStream out = null;
				out = response.getOutputStream();
				response.setHeader("Content-disposition",
					"attachment; filename=" + new String("优惠券领取详情".getBytes("GB2312"), "ISO8859-1")
							+ ".xls");
				response.setContentType("application/msexcel");
				wb.write(out);
				out.close();
				out.flush();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
