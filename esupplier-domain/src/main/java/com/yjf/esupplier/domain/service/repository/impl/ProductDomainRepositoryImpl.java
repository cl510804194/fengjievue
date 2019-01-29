package com.yjf.esupplier.domain.service.repository.impl;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.dal.dataobject.TblProductDO;
import com.yjf.esupplier.domain.ProductDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.repository.ProductDomainRepository;

@Service("productDomainRepository")
public class ProductDomainRepositoryImpl extends DomainRepositoryBase implements
																		ProductDomainRepository {
	
	@Override
	public void store(ProductDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		TblProductDO tblProductDO = new TblProductDO();
		DomainConvert.productDomainCovertDO(domain, tblProductDO);
		tblProductDAO.insert(tblProductDO);
	}
	
	@Override
	public void reStore(ProductDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		TblProductDO tblProductDO = new TblProductDO();
		DomainConvert.productDomainCovertDO(domain, tblProductDO);
		tblProductDAO.update(tblProductDO);
	}
	
	@Override
	public ProductDomain active(long productId, boolean isLock) {
		TblProductDO tblProductDO = null;
		if (isLock) {
			tblProductDO = tblProductDAO.findByIdForUpdate(productId);
		} else {
			tblProductDO = tblProductDAO.findById(productId);
		}
		if (tblProductDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		ProductDomain domain = new ProductDomain();
		DomainConvert.productDOCovertDomain(domain, tblProductDO);
		return domain;
	}
	
	@Override
	public void remove(ProductDomain domain) {
		tblProductDAO.deleteById(domain.getProductId());
	}
}
