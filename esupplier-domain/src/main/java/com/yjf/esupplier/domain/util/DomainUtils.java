package com.yjf.esupplier.domain.util;

import java.util.Date;

import com.yjf.common.service.Order;
import com.yjf.esupplier.domain.context.EsupplierDomainContext;
import com.yjf.esupplier.domain.context.EsupplierDomainHolder;

public class DomainUtils {
	public static Date getNowData() {
		Date nowDate = new Date();
		EsupplierDomainContext<Order> domainContext = EsupplierDomainHolder.get();
		if (domainContext != null && domainContext.getSysDate() != null) {
			nowDate = domainContext.getSysDate();
		}
		return nowDate;
	}
}
