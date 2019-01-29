package com.yjf.esupplier.domain.service.repository.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.dal.dataobject.TblOrderInfoDO;
import com.yjf.esupplier.dal.dataobject.TblOrderItemDO;
import com.yjf.esupplier.domain.OrderDomain;
import com.yjf.esupplier.domain.OrderItemDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.repository.OrderDomainRepository;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;

@Service("orderDomainRepository")
public class OrderDomainRepositoryImpl extends DomainRepositoryBase implements
																	OrderDomainRepository {
	
	@Override
	public void store(OrderDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		TblOrderInfoDO tblOrderDO = new TblOrderInfoDO();
		DomainConvert.orderDomainCovertDO(domain, tblOrderDO);
		tblOrderInfoDAO.insert(tblOrderDO);
		if (domain.getOrderItemDomain() != null) {
			TblOrderItemDO tblOrderItemDO = new TblOrderItemDO();
			BeanCopier.staticCopy(domain.getOrderItemDomain(), tblOrderItemDO);
			if (domain.getOrderItemDomain().getRoomType() != null) {
				tblOrderItemDO.setRoomType(domain.getOrderItemDomain().getRoomType().getCode());
			}
			tblOrderItemDO.setOrderId(tblOrderDO.getId());
			tblOrderItemDAO.insert(tblOrderItemDO);
		}
	}
	
	@Override
	public void reStore(OrderDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		TblOrderInfoDO tblOrderDO = new TblOrderInfoDO();
		DomainConvert.orderDomainCovertDO(domain, tblOrderDO);
		tblOrderInfoDAO.update(tblOrderDO);
		if (domain.getOrderItemDomain() != null) {
			TblOrderItemDO tblOrderItemDO = new TblOrderItemDO();
			BeanCopier.staticCopy(domain.getOrderItemDomain(), tblOrderItemDO);
			tblOrderItemDO.setOrderId(tblOrderDO.getId());
			tblOrderItemDAO.update(tblOrderItemDO);
		}
	}
	
	@Override
	public OrderDomain active(long orderId, boolean isLock) {
		TblOrderInfoDO tblOrderInfoDO = null;
		if (isLock) {
			tblOrderInfoDO = tblOrderInfoDAO.findByIdForUpdate(orderId);
		} else {
			tblOrderInfoDO = tblOrderInfoDAO.findById(orderId);
		}
		if (tblOrderInfoDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		OrderDomain domain = new OrderDomain();
		DomainConvert.orderDOCovertDomain(domain, tblOrderInfoDO);
		return domain;
	}
	
	@Override
	public OrderItemDomain activeOrderItem(long orderId) {
		
		List<TblOrderItemDO> orderItemDOs = tblOrderItemDAO.findByOrderId(orderId);
		if (ListUtil.isEmpty(orderItemDOs)) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		OrderItemDomain domain = new OrderItemDomain();
		BeanCopier.staticCopy(orderItemDOs.get(0), domain);
		domain.setRoomType(HotelTypeEnum.getByCode(orderItemDOs.get(0).getRoomType()));
		return domain;
	}
	
	@Override
	public void remove(OrderDomain domain) {
		tblOrderInfoDAO.deleteById(domain.getId());
		tblOrderItemDAO.deleteByOrderId(domain.getId());
	}
	
	@Override
	public OrderItemDomain activeOrderItemByItemId(long orderItemId) {
		TblOrderItemDO orderItemDO = tblOrderItemDAO.findById(orderItemId);
		if (orderItemDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		OrderItemDomain domain = new OrderItemDomain();
		BeanCopier.staticCopy(orderItemDO, domain);
		domain.setRoomType(HotelTypeEnum.getByCode(orderItemDO.getRoomType()));
		return domain;
	}

	
}
