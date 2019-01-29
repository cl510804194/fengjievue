package com.yjf.esupplier.domain.service.repository.impl;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.dal.dataobject.RefundOrderInfoDO;
import com.yjf.esupplier.domain.RefundOrderDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.repository.RefundOrderDomainRepository;

@Service("refundOrderDomainRepository")
public class RefundOrderDomainRepositoryImpl extends DomainRepositoryBase implements
																			RefundOrderDomainRepository {
	
	@Override
	public void store(RefundOrderDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		RefundOrderInfoDO refundOrderInfoDO = new RefundOrderInfoDO();
		DomainConvert.refundOrderDomainCovertDO(domain, refundOrderInfoDO);
		refundOrderInfoDAO.insert(refundOrderInfoDO);
		/*ID数据会写*/
		domain.setRefundId(refundOrderInfoDO.getRefundId());
	}
	
	@Override
	public void reStore(RefundOrderDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		RefundOrderInfoDO refundOrderInfoDO = new RefundOrderInfoDO();
		DomainConvert.refundOrderDomainCovertDO(domain, refundOrderInfoDO);
		refundOrderInfoDAO.update(refundOrderInfoDO);
		
	}
	
	@Override
	public RefundOrderDomain active(long refundId, boolean isLock) {
		RefundOrderInfoDO refundOrderInfoDO = null;
		if (isLock) {
			refundOrderInfoDO = refundOrderInfoDAO.findByIdForUpdate(refundId);
		} else {
			refundOrderInfoDO = refundOrderInfoDAO.findById(refundId);
		}
		if (refundOrderInfoDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		RefundOrderDomain domain = new RefundOrderDomain();
		DomainConvert.refundOrderDOCovertDomain(domain, refundOrderInfoDO);
		return domain;
	}
	
	@Override
	public RefundOrderDomain activeByOrderId(long orderId) {
		RefundOrderInfoDO refundOrderInfoDO = null;
		refundOrderInfoDO = refundOrderInfoDAO.findByOrderId(orderId);
		if (refundOrderInfoDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		RefundOrderDomain domain = new RefundOrderDomain();
		DomainConvert.refundOrderDOCovertDomain(domain, refundOrderInfoDO);
		return domain;
	}
	
	@Override
	public void remove(RefundOrderDomain domain) {
		refundOrderInfoDAO.deleteById(domain.getRefundId());
	}
	
}
