package com.yjf.esupplier.domain.service.repository.impl;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.dal.dataobject.TblProductTypeDO;
import com.yjf.esupplier.dal.dataobject.TblProductTypeDO;
import com.yjf.esupplier.domain.ProductTypeDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.repository.ProductTypeDomainRepository;
import com.yjf.esupplier.domain.service.repository.ProductTypeDomainRepository;
import org.springframework.stereotype.Service;

@Service("productTypeDomainRepository")
public class ProductTypeDomainRepositoryImpl extends DomainRepositoryBase implements
		ProductTypeDomainRepository {
	
	@Override
	public void store(ProductTypeDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		TblProductTypeDO tblProductTypeDO = new TblProductTypeDO();
		BeanCopier.staticCopy(domain, tblProductTypeDO);
		tblProductTypeDAO.insert(tblProductTypeDO);
	}
	
	@Override
	public void reStore(ProductTypeDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		TblProductTypeDO tblProductTypeDO = new TblProductTypeDO();
		BeanCopier.staticCopy(domain, tblProductTypeDO);
		tblProductTypeDAO.update(tblProductTypeDO);
	}
	
	@Override
	public ProductTypeDomain active(String productTypeCode, boolean isLock) {
		TblProductTypeDO tblProductTypeDO = null;
		if (isLock) {
			tblProductTypeDO = tblProductTypeDAO.findByCodeForUpdate(productTypeCode);
		} else {
			tblProductTypeDO = tblProductTypeDAO.findByPtCode(productTypeCode);
		}
		if (tblProductTypeDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		ProductTypeDomain domain = new ProductTypeDomain();
		BeanCopier.staticCopy(tblProductTypeDO, domain);
		return domain;
	}

}
