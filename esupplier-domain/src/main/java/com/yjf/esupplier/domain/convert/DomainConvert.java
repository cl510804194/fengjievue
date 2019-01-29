package com.yjf.esupplier.domain.convert;

import com.yjf.esupplier.ws.product.enums.*;
import org.springframework.beans.BeanUtils;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.dal.dataobject.ContractDO;
import com.yjf.esupplier.dal.dataobject.CustomerInfoDO;
import com.yjf.esupplier.dal.dataobject.GiftMoneyDO;
import com.yjf.esupplier.dal.dataobject.GiftMoneyTradeDO;
import com.yjf.esupplier.dal.dataobject.PaymentFlowDO;
import com.yjf.esupplier.dal.dataobject.PointsRuleDO;
import com.yjf.esupplier.dal.dataobject.RefundItemDO;
import com.yjf.esupplier.dal.dataobject.RefundOrderInfoDO;
import com.yjf.esupplier.dal.dataobject.ReportRuleDO;
import com.yjf.esupplier.dal.dataobject.TblOrderInfoDO;
import com.yjf.esupplier.dal.dataobject.TblProductDO;
import com.yjf.esupplier.ws.bill.data.OrderData;
import com.yjf.esupplier.ws.bill.data.PaymentFlowData;
import com.yjf.esupplier.ws.bill.data.RefundOrderData;
import com.yjf.esupplier.ws.bill.enums.OrderFlowStatus;
import com.yjf.esupplier.ws.bill.enums.OrderRefundStatusEnum;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.PaymentMethodEnum;
import com.yjf.esupplier.ws.bill.enums.PrintReceiptStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundProcessStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundTypeEnum;
import com.yjf.esupplier.ws.common.enums.PaymentTypeEnum;
import com.yjf.esupplier.ws.data.ContractData;
import com.yjf.esupplier.ws.data.CustomerData;
import com.yjf.esupplier.ws.data.RefundItemData;
import com.yjf.esupplier.ws.data.ReportRuleData;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.ContractStatusEnum;
import com.yjf.esupplier.ws.enums.CustomerStatusEnum;
import com.yjf.esupplier.ws.enums.EducationLevelEnum;
import com.yjf.esupplier.ws.enums.MaritalTatusEnum;
import com.yjf.esupplier.ws.enums.MatchStatusEnum;
import com.yjf.esupplier.ws.enums.QrStatusEnum;
import com.yjf.esupplier.ws.enums.RefundEnum;
import com.yjf.esupplier.ws.enums.SettlementStatusEnum;
import com.yjf.esupplier.ws.enums.UserSexEnum;
import com.yjf.esupplier.ws.gifamount.data.GiftMoneyData;
import com.yjf.esupplier.ws.gifamount.data.GiftMoneyTradeData;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTradeTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.integral.data.PointsRuleData;
import com.yjf.esupplier.ws.integral.enums.PointsRuleStateEnum;
import com.yjf.esupplier.ws.integral.enums.PointsRuleValidityTypeEnum;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.pay.enums.PaymentFlowMode;
import com.yjf.esupplier.ws.pay.enums.PaymentFlowReturnStatus;
import com.yjf.esupplier.ws.pay.enums.PaymentFlowStatus;
import com.yjf.esupplier.ws.product.data.ProductData;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

public class DomainConvert {
	
	public static void productDomainCovertDO(ProductData data, TblProductDO porSrc) {
		BeanCopier.staticCopy(data, porSrc);
		if (data.getPostType() != null)
			porSrc.setPostType(String.valueOf(data.getPostType().getDbValue()));
		if (data.getProductVary() != null)
			porSrc.setProductVary(data.getProductVary().getCode());
		if (data.getProductStatus() != null)
			porSrc.setProductStatus(data.getProductStatus().code());
		if (data.getCensor() != null)
			porSrc.setCensor(data.getCensor().code());
		if (data.getSaleTypeB2c() != null)
			porSrc.setSaleTypeB2c(data.getSaleTypeB2c().code());
		if (data.getSaleTypeO2o() != null)
			porSrc.setSaleTypeO2o(data.getSaleTypeO2o().code());
		if (data.getFacade() != null) {
			porSrc.setFacade(data.getFacade().code());
		}
		if (data.getSaleTypeHotels() != null) {
			porSrc.setSaleTypeHotels(data.getSaleTypeHotels().code());
		}
		if (data.getSaleTypeOrderMeal() != null) {
			porSrc.setSaleTypeOrderMeal(data.getSaleTypeOrderMeal().code());
		}
		if (data.getTuneMeal() != null) {
			porSrc.setTuneMeal(data.getTuneMeal().code());
		}
		if (data.getRecommend() != null) {
			porSrc.setRecommend(data.getRecommend().code());
		}
		if (data.getSpecialRoom() != null) {
			porSrc.setSpecialRoom(data.getSpecialRoom().code());
		}
		if (data.getLongRentRoom() != null) {
			porSrc.setLongRentRoom(data.getLongRentRoom().code());
		}
		if (data.getMorningRoom() != null) {
			porSrc.setMorningRoom(data.getMorningRoom().code());
		}
		if (data.getCustomType1() != null) {
			porSrc.setCustomType1(data.getCustomType1().code());
		}
		if (data.getCustomType2() != null) {
			porSrc.setCustomType2(data.getCustomType2().code());
		}
		
	}
	
	public static void productDOCovertDomain(ProductData data, TblProductDO porSrc) {
		BeanCopier.staticCopy(porSrc, data);
		data.setProductVary(ProductVaryEnum.getByCode(porSrc.getProductVary()));
		data.setPostType(PostFeeTypeEnum.getByDBValue(Integer.parseInt(porSrc.getPostType())));
		data.setFacade(RefundRuleEnum.getByCode(porSrc.getFacade()));
		data.setCensor(ProductCheckEnum.getByCode(porSrc.getCensor()));
		data.setProductStatus(ProductStatusEnum.getByCode(porSrc.getProductStatus()));
		data.setSaleTypeB2c(BooleanEnum.getByCode(porSrc.getSaleTypeB2c()));
		data.setSaleTypeO2o(BooleanEnum.getByCode(porSrc.getSaleTypeO2o()));
		data.setSaleTypeOrderMeal(BooleanEnum.getByCode(porSrc.getSaleTypeOrderMeal()));
		data.setSaleTypeHotels(BooleanEnum.getByCode(porSrc.getSaleTypeHotels()));
		data.setTuneMeal(BooleanEnum.getByCode(porSrc.getTuneMeal()));
		data.setRecommend(BooleanEnum.getByCode(porSrc.getRecommend()));
		data.setMorningRoom(BooleanEnum.getByCode(porSrc.getMorningRoom()));
		data.setLongRentRoom(BooleanEnum.getByCode(porSrc.getLongRentRoom()));
		data.setCustomType1(BooleanEnum.getByCode(porSrc.getCustomType1()));
		data.setCustomType2(BooleanEnum.getByCode(porSrc.getCustomType2()));
		data.setSpecialRoom(BooleanEnum.getByCode(porSrc.getSpecialRoom()));
	}


	public static void orderDomainCovertDO(OrderData data, TblOrderInfoDO orderInfoDO) {
		BeanCopier.staticCopy(data, orderInfoDO);
		if (data.getPostType() != null)
			orderInfoDO.setPostType(String.valueOf(data.getPostType().getDbValue()));
		if (data.getOrderStatus() != null)
			orderInfoDO.setOrderStatus(data.getOrderStatus().code());
		if (data.getDelStatus() != null)
			orderInfoDO.setDelStatus(data.getDelStatus().code());
		if (data.getTakeWays() != null)
			orderInfoDO.setTakeWays(data.getTakeWays().code());
		if (data.getWorkflowStatus() != null)
			orderInfoDO.setWorkflowStatus(data.getWorkflowStatus().code());
		if (data.getSaleTypeB2c() != null)
			orderInfoDO.setSaleTypeB2c(data.getSaleTypeB2c().code());
		if (data.getSaleTypeO2o() != null)
			orderInfoDO.setSaleTypeO2o(data.getSaleTypeO2o().code());
		if (data.getSaleTypeHotels() != null) {
			orderInfoDO.setSaleTypeHotels(data.getSaleTypeHotels().code());
		}
		if (data.getProductVary() != null) {
			orderInfoDO.setProductVary(data.getProductVary().code());
		}
		if (data.getSaleTypeOrderMeal() != null) {
			orderInfoDO.setSaleTypeOrderMeal(data.getSaleTypeOrderMeal().code());
		}
		if (data.getFacade() != null) {
			orderInfoDO.setFacade(data.getFacade().code());
		}
		if (data.getRefundStatus() != null) {
			orderInfoDO.setRefundStatus(data.getRefundStatus().code());
		}
		if (data.getIsPayed() != null) {
			orderInfoDO.setIsPayed(data.getIsPayed().code());
		}
		if (data.getSendStatus() != null) {
			orderInfoDO.setSendStatus(data.getSendStatus().code());
		}
		if (data.getValidationStatus() != null) {
			orderInfoDO.setValidationStatus(data.getValidationStatus().code());
		}
		if (data.getPaymentMethod() != null) {
			orderInfoDO.setPaymentMethod(data.getPaymentMethod().code());
		}
		if (data.getTuneMeal() != null) {
			orderInfoDO.setTuneMeal(data.getTuneMeal().code());
		}
		if (StringUtil.isNotBlank(data.getBatchNo()))
			orderInfoDO.setBatchNo(NumberUtil.parseLong(data.getBatchNo()));
		if (data.getPrintReceipt() != null) {
			orderInfoDO.setPrintReceipt(data.getPrintReceipt().code());
		}
	}
	
	public static void orderDOCovertDomain(OrderData data, TblOrderInfoDO orderInfoDO) {
		BeanCopier.staticCopy(orderInfoDO, data);
		data.setPostType(PostFeeTypeEnum.getByDBValue(NumberUtil.parseInt(orderInfoDO.getPostType())));
		data.setOrderStatus(OrderStatusEnum.getByCode(orderInfoDO.getOrderStatus()));
		data.setWorkflowStatus(OrderFlowStatus.getByCode(orderInfoDO.getWorkflowStatus()));
		data.setFacade(RefundRuleEnum.getByCode(orderInfoDO.getFacade()));
		data.setSaleTypeB2c(BooleanEnum.getByCode(orderInfoDO.getSaleTypeB2c()));
		data.setSaleTypeO2o(BooleanEnum.getByCode(orderInfoDO.getSaleTypeO2o()));
		data.setSaleTypeHotels(BooleanEnum.getByCode(orderInfoDO.getSaleTypeHotels()));
		data.setSaleTypeOrderMeal(BooleanEnum.getByCode(orderInfoDO.getSaleTypeOrderMeal()));
		data.setProductVary(ProductVaryEnum.getByCode(orderInfoDO.getProductVary()));
		data.setRefundStatus(OrderRefundStatusEnum.getByCode(orderInfoDO.getRefundStatus()));
		data.setIsPayed(BooleanEnum.getByCode(orderInfoDO.getIsPayed()));
		data.setSendStatus(QrStatusEnum.getByCode(orderInfoDO.getSendStatus()));
		data.setValidationStatus(BooleanEnum.getByCode(orderInfoDO.getValidationStatus()));
		data.setPaymentMethod(PaymentMethodEnum.getByCode(orderInfoDO.getPaymentMethod()));
		data.setTuneMeal(BooleanEnum.getByCode(orderInfoDO.getTuneMeal()));
		data.setPrintReceipt(PrintReceiptStatusEnum.getByCode(orderInfoDO.getPrintReceipt()));
		if (orderInfoDO.getBatchNo() > 0)
			data.setBatchNo(String.valueOf(orderInfoDO.getBatchNo()));
	}
	
	public static void refundOrderDomainCovertDO(RefundOrderData data,
													RefundOrderInfoDO refundOrderInfoDO) {
		BeanCopier.staticCopy(data, refundOrderInfoDO);
		if (data.getRefundType() != null)
			refundOrderInfoDO.setRefundType(data.getRefundType().getCode());
		if (data.getSaleTypeB2c() != null)
			refundOrderInfoDO.setSaleTypeB2c(data.getSaleTypeB2c().code());
		if (data.getSaleTypeO2o() != null)
			refundOrderInfoDO.setSaleTypeO2o(data.getSaleTypeO2o().code());
		if (data.getProductVaryEnum() != null)
			refundOrderInfoDO.setProductVary(data.getProductVaryEnum().code());
		if (data.getStatus() != null)
			refundOrderInfoDO.setStatus(data.getStatus().code());
		
	}
	
	public static void refundOrderDOCovertDomain(RefundOrderData data,
													RefundOrderInfoDO refundOrderInfoDO) {
		BeanCopier.staticCopy(refundOrderInfoDO, data);
		if(StringUtil.isNotEmpty(refundOrderInfoDO.getRefundType())){
			data.setRefundType(RefundTypeEnum.getByCode(refundOrderInfoDO.getRefundType()));
		}
		if(StringUtil.isNotEmpty(refundOrderInfoDO.getSaleTypeB2c())){
			data.setSaleTypeB2c(BooleanEnum.getByCode(refundOrderInfoDO.getSaleTypeB2c()));
		}
		if(StringUtil.isNotEmpty(refundOrderInfoDO.getSaleTypeO2o())){
			data.setSaleTypeO2o(BooleanEnum.getByCode(refundOrderInfoDO.getSaleTypeO2o()));
		}
		if(StringUtil.isNotEmpty(refundOrderInfoDO.getStatus())){
			data.setStatus(RefundProcessStatusEnum.getByCode(refundOrderInfoDO.getStatus()));
		}
		if(StringUtil.isNotEmpty(refundOrderInfoDO.getProductVary())){
			data.setProductVaryEnum(ProductVaryEnum.getByCode(refundOrderInfoDO.getProductVary()));
		}
	}
	
	public static void paymentFlowDomainCovertDO(PaymentFlowData data, PaymentFlowDO paymentFlowDO) {
		BeanCopier.staticCopy(data, paymentFlowDO);
		if (data.getPaymentType() != null)
			paymentFlowDO.setPaymentType(data.getPaymentType().getCode());
		if (data.getStatus() != null)
			paymentFlowDO.setStatus(data.getStatus().code());
		if (data.getRefundStatus() != null)
			paymentFlowDO.setRefundStatus(data.getRefundStatus().code());
		if (data.getPaymentMode() != null)
			paymentFlowDO.setPaymentMode(data.getPaymentMode().code());
		
	}
	
	public static void paymentFlowDOCovertDomain(PaymentFlowData data, PaymentFlowDO paymentFlowDO) {
		BeanCopier.staticCopy(paymentFlowDO, data);
		data.setPaymentType(PaymentTypeEnum.getByCode(paymentFlowDO.getPaymentType()));
		data.setStatus(PaymentFlowStatus.getByCode(paymentFlowDO.getStatus()));
		data.setRefundStatus(PaymentFlowReturnStatus.getByCode(paymentFlowDO.getRefundStatus()));
		data.setPaymentMode(PaymentFlowMode.getByCode(paymentFlowDO.getPaymentMode()));
	}
	
	public static void convertPointsRuleDomain(PointsRuleData pointsRuleDomain,
												PointsRuleDO pointsRuleDO) {
		BeanCopier.staticCopy(pointsRuleDO, pointsRuleDomain);
		pointsRuleDomain.setRuleType(PointsTypeEnum.getByCode(pointsRuleDO.getRuleType()));
		pointsRuleDomain.setState(PointsRuleStateEnum.getByCode(pointsRuleDO.getState()));
		pointsRuleDomain.setValueType(UserLevelRuleType.getByCode(pointsRuleDO.getValueType()));
		pointsRuleDomain.setValidityType(PointsRuleValidityTypeEnum.getByCode(pointsRuleDO
			.getValidityType()));
	}
	
	public static void convertPointsRuleDO(PointsRuleData pointsRuleDomain,
											PointsRuleDO pointsRuleDO) {
		BeanCopier.staticCopy(pointsRuleDomain, pointsRuleDO);
		if (pointsRuleDomain.getRuleType() != null) {
			pointsRuleDO.setRuleType(pointsRuleDomain.getRuleType().code());
		}
		if (pointsRuleDomain.getState() != null) {
			pointsRuleDO.setState(pointsRuleDomain.getState().code());
		}
		if (pointsRuleDomain.getValueType() != null) {
			pointsRuleDO.setValueType(pointsRuleDomain.getValueType().code());
		}
		if (pointsRuleDomain.getValidityType() != null) {
			pointsRuleDO.setValidityType(pointsRuleDomain.getValidityType().code());
		}
	}
	
	public static void convertGiftMoneyDO(GiftMoneyData giftMoneyData, GiftMoneyDO giftMoneyDO) {
		BeanCopier.staticCopy(giftMoneyData, giftMoneyDO);
		giftMoneyDO.setGiveType(giftMoneyData.getGiveType().getCode());
		giftMoneyDO.setType(giftMoneyData.getType().getCode());
	}
	
	public static void convertGiftMoneyTradeDO(GiftMoneyTradeData giftMoneyTradeData,
												GiftMoneyTradeDO giftMoneyTradeDO) {
		BeanCopier.staticCopy(giftMoneyTradeData, giftMoneyTradeDO);
		giftMoneyTradeDO.setUseType(giftMoneyTradeData.getUseType());
		giftMoneyTradeDO.setType(giftMoneyTradeData.getType().getCode());
		giftMoneyTradeDO.setTradeType(giftMoneyTradeData.getTradeType().getCode());
		giftMoneyTradeDO.setStatus(giftMoneyTradeData.getStatus().code());
		if (giftMoneyTradeData.getNotify() != null) {
			giftMoneyTradeDO.setNotify(giftMoneyTradeData.getNotify().getCode());
		}
	}
	
	public static void convertGiftMoneyTradeDomain(GiftMoneyTradeData giftMoneyTradeData,
													GiftMoneyTradeDO giftMoneyTradeDO) {
		BeanCopier.staticCopy(giftMoneyTradeDO, giftMoneyTradeData);
		giftMoneyTradeData.setUseType(giftMoneyTradeDO.getUseType());
		giftMoneyTradeData.setType(GiftMoneyTypeEnum.getByCode(giftMoneyTradeDO.getType()));
		giftMoneyTradeData.setTradeType(GiftMoneyTradeTypeEnum.getByCode(giftMoneyTradeDO
			.getTradeType()));
		giftMoneyTradeData.setNotify(BooleanEnum.getByCode(giftMoneyTradeDO.getNotify()));
		giftMoneyTradeData.setStatus(GiftMoneyStatusEnum.getByCode(giftMoneyTradeDO.getStatus()));
	}
	
	public static void convertGiftMoneyDomain(GiftMoneyData giftMoneyDomain, GiftMoneyDO giftMoneyDO) {
		BeanCopier.staticCopy(giftMoneyDO, giftMoneyDomain);
		giftMoneyDomain.setGiveType(GiftMoneyGiveTypeEnum.getByCode(giftMoneyDO.getGiveType()));
		giftMoneyDomain.setType(GiftMoneyTypeEnum.getByCode(giftMoneyDO.getType()));
		
	}
	
	/**
	 * 
	 * 历史领域模型
	 * 
	 * 
	 * @param contractDO
	 * @param contractData
	 */
	
	public static void convertContractToDomain(ContractDO contractDO, ContractData contractData) {
		BeanUtils.copyProperties(contractDO, contractData);
		contractData.setMatchStatus(MatchStatusEnum.getByCode(contractDO.getMatchStatus()));
		contractData.setRefundStatus(RefundEnum.getByCode(contractDO.getRefundStatus()));
		contractData.setSettlementStatus(SettlementStatusEnum.getByCode(contractDO
			.getSettlementStatus()));
		contractData.setStatus(ContractStatusEnum.getByCode(contractDO.getStatus()));
		contractData.setTakeStatus(BooleanEnum.getByCode(contractDO.getTakeStatus()));
	}
	
	public static void convertContractDO(ContractData contractData, ContractDO contractDO) {
		BeanCopier.staticCopy(contractData, contractDO);
		if (contractData.getMatchStatus() != null)
			contractDO.setMatchStatus(contractData.getMatchStatus().getCode());
		if (contractData.getRefundStatus() != null)
			contractDO.setRefundStatus(contractData.getRefundStatus().getCode());
		if (contractData.getSettlementStatus() != null)
			contractDO.setSettlementStatus(contractData.getSettlementStatus().getCode());
		if (contractData.getStatus() != null)
			contractDO.setStatus(contractData.getStatus().getCode());
		if (contractData.getTakeStatus() != null)
			contractDO.setTakeStatus(contractData.getTakeStatus().getCode());
	}
	
	public static void convertCustomerDomain(CustomerData customerData, CustomerInfoDO customerDO) {
		BeanCopier.staticCopy(customerDO, customerData);
		customerData
			.setEducationLevel(EducationLevelEnum.getByCode(customerDO.getEducationLevel()));
		customerData.setMaritalTatus(MaritalTatusEnum.getByCode(customerDO.getMaritalTatus()));
		customerData.setStatus(CustomerStatusEnum.getByCode(customerDO.getStatus()));
		customerData.setSex(UserSexEnum.getByCode(customerDO.getSex()));
	}
	
	public static void convertRefundItemDO(RefundItemData refundItemData, RefundItemDO refundItemDO) {
		BeanUtils.copyProperties(refundItemData, refundItemDO);
		if (refundItemData.getCustomerSex() != null) {
			refundItemDO.setCustomerSex(refundItemData.getCustomerSex().getCode());
		}
		if (refundItemData.getCustomerSex() != null) {
			refundItemDO.setRefundStatus(refundItemData.getRefundStatus().code());
		}
		if (refundItemData.getLoanType() != null) {
			refundItemDO.setLoanType(refundItemData.getLoanType().code());
		}
		
	}
	
	public static void convertReportRuleDomain(ReportRuleData reportRuleData,
												ReportRuleDO reportRuleDO) {
		BeanCopier.staticCopy(reportRuleDO, reportRuleData);
	}
	
	public static void convertReportRuleDO(ReportRuleDO reportRuleDO, ReportRuleData reportRuleData) {
		BeanCopier.staticCopy(reportRuleData, reportRuleDO);
		
	}
}
