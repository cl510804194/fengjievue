package com.yjf.esupplier.web.controller.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.ApplicationConstant;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.service.common.services.SysParameterService;

public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	protected SysParameterService sysParameterService;
	
	protected String sendUrl(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	protected OpenApiContext getOpenApiContext() {
		OpenApiContext openApiContext = new OpenApiContext();
		openApiContext.setPartnerId(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_YJF_BUSINESS_USER_ID));
		openApiContext.setSecurityCheckKey(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_SECURITY_CHECK_KEY));
		openApiContext.setOpenApiUrl(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_OPEN_API_URL_KEY));
		
		openApiContext.setNotifyUrl(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_RETURN_URL_KEY));
		openApiContext.setOpenApiBizNo(BusinessNumberUtil.gainOutBizNoNumber());
		return openApiContext;
	}
}
