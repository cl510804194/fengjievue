package com.yjf.esupplier.ws.directsend;

import com.yjf.esupplier.ws.directsend.order.DirectSendOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.AsynchronousService;

public interface DirectSendService extends AsynchronousService {
	
	public EsupplierBaseResult directSend(DirectSendOrder directSendOrder);
	
	public EsupplierBaseResult batchDirectSend(DirectSendOrder directSendOrder);
	
}
