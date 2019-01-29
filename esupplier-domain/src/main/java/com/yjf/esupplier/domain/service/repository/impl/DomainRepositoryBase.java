package com.yjf.esupplier.domain.service.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.dal.daointerface.HotelsStockDAO;
import com.yjf.esupplier.dal.daointerface.PaymentFlowDAO;
import com.yjf.esupplier.dal.daointerface.RefundOrderInfoDAO;
import com.yjf.esupplier.dal.daointerface.TblHotelLongSetDAO;
import com.yjf.esupplier.dal.daointerface.TblOrderInfoDAO;
import com.yjf.esupplier.dal.daointerface.TblOrderItemDAO;
import com.yjf.esupplier.dal.daointerface.TblProductDAO;
import com.yjf.esupplier.dal.daointerface.TblProductTypeDAO;

public class DomainRepositoryBase {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	TblOrderInfoDAO tblOrderInfoDAO;
	
	@Autowired
	TblOrderItemDAO tblOrderItemDAO;

	@Autowired
	TblProductDAO tblProductDAO;
	
	@Autowired
	RefundOrderInfoDAO refundOrderInfoDAO;
	
	@Autowired
	PaymentFlowDAO paymentFlowDAO;

	@Autowired
	TblProductTypeDAO tblProductTypeDAO;

	@Autowired
	HotelsStockDAO hotelsStockDAO;
	
	@Autowired
	TblHotelLongSetDAO hotelLongSetDAO;
}
