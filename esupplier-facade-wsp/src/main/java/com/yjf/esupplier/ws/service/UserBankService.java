package com.yjf.esupplier.ws.service;

import java.util.List;

import com.yjf.esupplier.ws.info.UserBankInfo;
import com.yjf.esupplier.ws.order.DeleteUserBankOrder;
import com.yjf.esupplier.ws.order.UserBankOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

public interface UserBankService {
	QueryBaseBatchResult<UserBankInfo> queryUserBankInfo(String userBaseId);
	
	EsupplierBaseResult addUserBankInfo(UserBankOrder bankOrder);
	
	UserBankInfo loadUserBankInfo(long id);
	
	EsupplierBaseResult updateUserBankInfo(UserBankOrder bankOrder);
	
	EsupplierBaseResult removeUserBankInfo(DeleteUserBankOrder deleteUserBankOrder);
	
	/**
	 * 本地后台手动绑卡
	 * @param userBaseId
	 * @return
	 */
	List<UserBankInfo> loadLocalManuallyUserBankInfo(String userBaseId);
	
	/**
	 * 加载不同角色的用户卡
	 * @param userBaseId
	 * @param isLoader
	 * @return
	 */
	QueryBaseBatchResult<UserBankInfo> queryUserBankInfo(String userBaseId, boolean isLoader);
	
	UserBankInfo loadUserWithdrawCardInfo(String userBaseId, String cardNo);
}
