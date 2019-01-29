package com.yjf.esupplier.domain.service.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.dal.daointerface.UserAccountDataDAO;
import com.yjf.esupplier.dal.dataobject.UserAccountDataDO;
import com.yjf.esupplier.domain.UserAccountDataDomain;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.repository.UserAccountDataDomainRepository;

@Service("userAccountDataDomainRepository")
public class UserAccountDataDomainRepositoryImpl extends DomainRepositoryBase implements
																				UserAccountDataDomainRepository {
	@Autowired
	UserAccountDataDAO userAccountDataDAO;
	
	@Override
	public void store(UserAccountDataDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		UserAccountDataDO accountDataDO = new UserAccountDataDO();
		BeanCopier.staticCopy(domain, accountDataDO);
		userAccountDataDAO.insert(accountDataDO);
	}
	
	@Override
	public void reStore(UserAccountDataDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		UserAccountDataDO accountDataDO = new UserAccountDataDO();
		BeanCopier.staticCopy(domain, accountDataDO);
		userAccountDataDAO.update(accountDataDO);
	}
	
	@Override
	public UserAccountDataDomain active(long userId, boolean isLock) {
		UserAccountDataDO accountDataDO = null;
		accountDataDO = loadDO(userId, isLock);
		if (accountDataDO == null && isLock) {
			UserAccountDataDomain accountDataDomain = new UserAccountDataDomain();
			accountDataDomain.setUserId(userId);
			store(accountDataDomain);
			accountDataDO = loadDO(userId, isLock);
		}
		
		UserAccountDataDomain domain = new UserAccountDataDomain();
		if(accountDataDO == null) accountDataDO =  new UserAccountDataDO();
		BeanCopier.staticCopy(accountDataDO, domain);
		return domain;
	}
	
	private UserAccountDataDO loadDO(long userId, boolean isLock) {
		UserAccountDataDO accountDataDO;
		if (isLock) {
			accountDataDO = userAccountDataDAO.findByIdForUpdate(userId);
		} else {
			accountDataDO = userAccountDataDAO.findById(userId);
		}
		return accountDataDO;
	}
}
