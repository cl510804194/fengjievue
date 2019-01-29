package com.yjf.esupplier.web.controller.front.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

public class AppChoiceFunction extends BaseFunction {
	/**
	 * 接口功能选择
	 * @throws Exception
	 */
	public void goToFunction(HttpServletRequest request, HttpSession session,
								HttpServletResponse response, String service, JSONObject json)
																								throws Exception {
		switch (service) {
		
			case "getWxSign":
				getWxSign(request, session, response, json, "获取微信公众号签名");
				break;
			/** 红包优惠券接口 **/
			case "queryGift":
				queryGift(request, json, "红包/优惠券列表查询");
				break;
			case "queryGiftCanUse":
				queryGiftCanUse(request, json, "验证当前消费可使用优惠券");
				break;
			/** 二维码 **/
			case "makeQrCode":
				makeQrCode(request, json, "生成消费二维码");
				break;
			case "useQrCode":
				useQrCode(request, json, "商家使用消费码");
				break;
			/** 消息类接口 **/
			case "scenicList":
				scenicList(request, json, "景区列表查询");
				break;
			case "scenicInfo":
				scenicInfo(request, json, "景区详情查询");
				break;
			case "supplierInfo":
				supplierInfo(request, json, "商户详情");
				break;
			case "supplierList":
				supplierList(request, json, "商户列表");
				break;
			case "supplierType":
				supplierType(request, json, "商户分类");
				break;
			case "hotelHistoryList":
				hotelHistoryList(request, json, "酒店历史入住列表");
				break;
			case "orderMealSupplierList":
				orderMealSupplierList(request, json, "订餐商户列表");
				break;
			case "orderMealSupplierInfo":
				orderMealSupplierInfo(request, json, "订餐商户详情");
				break;
			case "lygl":
				lygl(request, json, "旅游攻略");
				break;
			case "glCollectAgree":
				glCollectAgree(request, json, "攻略收藏|点赞");
				break;
			case "glfl":
				glfl(request, json, "旅游攻略分类");
				break;
			case "helpList":
				helpList(request, json, "帮助中心");
				break;
			case "helpType":
				helpType(request, json, "帮助中心分类");
				break;
			case "infoDetail":
				infoDetail(request, json, "旅游攻略、帮助中心详情");
				break;
			case "summary":
				summary(request, json, "真美美简介");
				break;
			case "indexImg":
				indexImg(request, json, "获取首页图");
				break;
			case "appUpdateInfo":
				appUpdateInfo(request, json, "版本信息");
				break;
			case "feebackOption":
				feebackOption(request, json, "意见反馈");
				break;
			
			/** 收货地址 **/
			case "addressesList":
				addressesList(request, json, "收货地址列表");
				break;
			case "saveAddress":
				saveAddress(request, json, "增加或修改收货地址");
				break;
			case "deletAddress":
				deletAddress(request, json, "删除收货地址");
				break;
			case "setDefaultAddress":
				setDefaultAddress(request, json, "设置默认收货地址");
				break;
			case "defaultAddressesList":
				defaultAddressesList(request, json, "点餐默认用餐地址列表");
				break;
			case "searchAddressesList":
				searchAddressesList(request, json, "查询用餐地址列表");
				break;
			case "setDiningAddress":
				setDiningAddress(request, json, "设置收餐地址");
				break;
			
			case "provinceList":
				provinceList(request, json, "获取省份列表");
				break;
			case "cityList":
				cityList(request, json, "获取城市列表");
				break;
			/*购物车*/
			case "shoppingCar":
				shoppingCar(request, json, "购物车");
				break;
			case "refreshShoppingCar":
				refreshShoppingCar(request, json, "强制刷新购物车");
				break;
			case "shoppingCarUpdate":
				shoppingCarUpdate(request, json, "修改购物车");
				break;
			case "shoppingCarDel":
				shoppingCarDel(request, json, "批量删除购物车商品");
				break;
			/*点餐购物车*/
			case "orderMealShoppingCar":
				orderMealShoppingCar(request, json, "点餐购物车");
				break;
			case "refreshOrderMealShoppingCar":
				refreshOrderMealShoppingCar(request, json, "强制刷新点餐购物车");
				break;
			case "orderMealShoppingCarUpdate":
				orderMealShoppingCarUpdate(request, json, "修改点餐购物车");
				break;
			case "orderMealShoppingCarDel":
				orderMealShoppingCarDel(request, json, "批量删除点餐购物车商品");
				break;
			case "getOrderMealShoppingCarCounts":
				getOrderMealShoppingCarCounts(request, json, "获取购物车商品数量");
				break;
			
			/*收货*/
			case "wuliu":
				wuliu(request, json, "物流查询");
				break;
			case "confirmRecieve":
				confirmRecieve(request, json, "确认收货");
				break;
			
			/** 用户类接口 **/
			case "verifyUser":
				verifyUser(request, json, "验证用户名");
				break;
			case "registerSubmit":
				registerSubmit(request, session, json, "注册提交");
				break;
			case "weixin":
				weixin(request, session, response, json, "微信授权登陆");
				break;
			case "weixinLogin":
				weixinLogin(request, session, response, json, "微信登录");
				break;
			case "logOut":
				logOut(request, json, "退出");
				break;
			case "login":
				doLogin(request, json, "登录");
				break;
			case "quickLogin":
				quickLogin(request, session, json, "快捷登录");
				break;
			case "setPwd":
				setPwd(request, session, json, "快捷登录设置密码");
				break;
			case "forgetLoginPwd":
				forgetLoginPwd(request, session, json, "忘记密码，验证用户名");
				break;
			case "forgetLoginPwdSub":
				forgetLoginPwdSub(request, session, json, "忘记密码，提交新密码");
				break;
			case "appChangePwd":
				appChangePwd(request, json, "修改登陆密码");
				break;
			case "changePayPwd":
				changePayPwd(request, json, "修改支付密码");
				break;
			case "checkMail":
				checkMail(request, json, "校验邮箱发送验证码");
				break;
			case "forgetLoginPwdByEmail":
				forgetLoginPwdByEmail(request, session, json, "忘记密码，提交新密码");
				break;
			case "forgetPayPwd":
				forgetPayPwd(request, json, "忘记支付密码");
				break;
			case "appChangeMobile":
				appChangeMobile(request, session, json, "修改绑定手机号，验证旧手机号");
				break;
			case "appChangeToNewPhone":
				appChangeToNewPhone(request, session, json, "修改绑定手机号，验证新手机");
				break;
			case "updateMail":
				updateMail(request, json, "修改邮箱");
				break;
			case "updateUserInfo":
				updateUserInfo(request, json, "修改用户信息");
				break;
			case "userInfo":
				userInfo(request, json, "用户信息");
				break;
			/** 订单类接口 **/
			case "SupplierOrderSum":
				supplierOrderSum(request, json, "卖家订单汇总信息查询");
				break;
			case "orderList":
				orderList(request, json, "查询订单列表");
				break;
			case "tecOrderIndex":
				tecOrderIndex(request, json, "技师首页查询");
				break;
			case "orderMealOrderList":
				orderMealOrderList(request, json, "查询点餐订单列表");
				break;
			case "diningOrderDetail":
				diningOrderDetail(request, json, "查询点餐订单详情");
				break;
			case "orderDetail":
				orderDetail(request, json, "订单详情查询");
				break;
			case "confirmOrder":
				confirmOrder(request, json, "订单待确认(购物车）");
				break;
			
			case "confirmOrderMealOrder":
				confirmOrderMealOrder(request, json, "app已点菜单");
				break;
			case "confirmOrderMeal":
				confirmOrderMeal(request, json, "app点餐确认菜单");
				break;
			
			case "diliveryList":
				deliveryList(request, json, "可用技师列表");
				break;
			case "confirmOrderSub":
				confirmOrderSub(request, json, "生成订单");
				break;
			case "confirmOrderB2c":
				confirmOrderB2c(request, json, "生成邮购订单(购物车）");
				break;
			case "gotoPay":
				gotoPay(request, json, "去付款");
				break;
			case "diningToPay":
				diningToPay(request, json, "点餐去付款");
				break;
			case "queryDepositResult":
				queryDepositResult(request, json, "查询付款结果");
				break;
			case "shopOrScanPay":
				shopOrScanPay(request, json, "到店或者扫码付款");
				break;
			case "depositResult":
				depositResult(request, json, "付款结果处理");
				break;
			case "cancelOrder":
				cancelOrder(request, json, "取消订单");
				break;
			case "cancelBatchOrder":
				cancelBatchOrder(request, json, "取消订单（按批次号）");
				break;
			case "postFeeByArea":
				postFeeByArea(request, json, "运费查询");
				break;
			/*退款退货*/
			case "refundList":
				refundList(request, json, "退款/退货列表");
				break;
			case "refundInfo":
				refundInfo(request, json, "退款/退货详情");
				break;
			case "refundApply":
				refundApply(request, json, "退款申请");
				break;
			case "refundGoodsConfirm":
				refundGoodsConfirm(request, json, "退货确认");
				break;
			/** 商品类接口 **/
			case "keyWords":
				keyWords(request, json, "关键词查询");
				break;
			case "collect":
				collect(request, json, "收藏产品/商户");
				break;
			case "collectList":
				collectList(request, json, "收藏列表");
				break;
			case "deletCollect":
				deletCollect(request, json, "取消收藏产品/商户");
				break;
			case "productType":
				productType(request, json, "获取商品类型");
				break;
			case "indexRecommend":
				indexRecommend(request, json, "热卖商品");
				break;
			case "indexRecommend2":
				indexRecommend2(request, json, "猜你喜欢");
				break;
			case "productList":
				productList(request, json, "团购商品列表/搜索商品");
				break;
			case "b2cProductList":
				b2cProductList(request, json, "邮购商品列表/搜索商品");
				break;
			case "lineList":
				lineList(request, json, "旅游线路列表");
				break;
			case "recommendProduct":
				recommendProduct(request, json, "商品推荐");
				break;
			case "productDetail":
				productDetail(request, json, "商品详情");
				break;
			case "pingjiaSub":
				pingjiaSub(request, json, "评价商品");
				break;
			case "pingjia":
				pingjia(request, json, "商品评价查询");
				break;
			case "pingjiaLike":
				pingjiaLike(request, json, "评价点赞操作");
				break;
			/** 点餐相关 */
			case "setSupplierTableNumber":
				setSupplierTableNumber(request, json, "设置商户桌数");
				break;
			case "qureyDiningTable":
				qureyDiningTable(request, json, "查询餐桌信息");
				break;
			case "selectDiningTable":
				selectDiningTable(request, json, "选择餐桌");
				break;
			case "clearTableNumber":
				clearTableNumber(request, json, "清除餐位");
				break;
			case "padMealOrder":
				padMealOrder(request, json, "点餐");
				break;
			case "padUpdateQuantityMealOrder":
				padUpdateQuantityMealOrder(request, json, "更新点餐数据");
				break;
			case "padConfirmMealOrder":
				padConfirmMealOrder(request, json, "确认点餐");
				break;
			case "orderTakingMealOrder":
				orderTakingMealOrder(request, json, "商户收单");
				break;
			case "confirmDeliveryMealOrder":
				confirmDeliveryMealOrder(request, json, "商户确认派单");
				break;
			case "printReceiptMealOrder":
				printReceiptMealOrder(request, json, "商户申请打印小票");
				break;
			case "printReceiptComplete":
				printReceiptComplete(request, json, "商户打印小票完成");
				break;
			case "printReceiptList":
				printReceiptList(request, json, "商户待打印订单列表");
				break;
			
			case "completeDelivery":
				completeDelivery(request, json, "配送完成");
				break;
			case "padOrderMealList":
				padOrderMealList(request, json, "已点餐菜单");
				break;
			case "cancelDiningOrder":
				cancelDiningOrder(request, json, "取消点餐订单");
				break;
			case "getDiningTypeList":
				getDiningTypeList(request, json, "获取菜系列表");
				break;
			case "updateProductStatus":
				updateProductStatus(request, json, "上架/下架商品");
				break;
			case "updateSupplierRunState":
				updateSupplierRunState(request, json, "商户关/开店");
				break;
			case "setOperatePwd":
				setOperatePwd(request, json, "设置操作密码");
				break;
			case "validationOperatePwd":
				validationOperatePwd(request, json, "验证操作密码");
				break;
			case "getDeliverHomePage":
				getDeliverHomePage(request, json, "配送员首页");
				break;
			case "getPadQrCode":
				getPadQrCode(request, response, json, "获取app付款二维码");
				break;
			case "queryAppScanPayResult":
				queryAppScanPayResult(request, json, "app扫码付款结果查询");
				break;
			
			/** 酒店预订接口 */
			case "hotelRoomType":
				hotelRoomType(request, json, "酒店房间分类");
				break;
			case "supplierHotelList":
				supplierHotelList(request, json, "酒店房间列表");
				break;
			case "hotelStatus":
				hotelStatus(request, json, "酒店房间状态管理");
				break;
			case "hotelStockInfo":
				hotelStockInfo(request, json, "酒店房间可用数量价格管理");
				break;
			case "hotelOrderNumCheck":
				hotelOrderNumCheck(request, json, "房间预订确认数量");
				break;
			case "getLongRoomSetInfo":
				getLongRoomSetInfo(request, json, "获取长包房配置条件");
				break;
			/** 万花筒接口 **/
			case "messageLoveWallList":
				messageLoveWallList(request, json, "爱的印记列表");
				break;
			case "messageLoveWallInfo":
				messageLoveWallInfo(request, json, "爱的印记详情");
				break;
			case "addMessageLoveWall":
				addMessageLoveWall(request, json, "添加爱的印记");
				break;
			case "messageWallList":
				messageWallList(request, json, "到此一游列表");
				break;
			case "addMessageWall":
				addMessageWall(request, json, "新增到此一游记录");
				break;

			/** 辅助功能类接口 **/
			case "sendSmsCode":
				sendSmsCode(request, session, json, "获取短信验证码");
				break;
			case "verifySmsCode":
				verifySmsCode(request, json, "校验短信验证码是否正确");
				break;
			case "getImgCode":
				getImgCode(request, session, response, json, "获取图片验证码");
				break;
			case "verifyImgCode":
				verifyImgCode(request, session, json, "校验图片证码是否正确");
				break;
			case "imagesUpload":
				imagesUpload(request, json, "图片上传");
				break;
			/*站内消息*/
			case "messageList":
				messageList(request, json, "消息列表");
				break;
			case "messageInfo":
				messageInfo(request, json, "消息详情");
				break;
			case "deleteReceivedMessageInfo":
				deleteReceivedMessageInfo(request, json, "删除消息");
				break;
			case "uploadHeaderImg":
				uploadHeaderImg(request, json, "上传头像");
				break;
			case "accountWithdrawals":
				accountWithdrawals(request, json, "提现到银行卡所有信息");
				break;
			case "saveBankCard":
				saveBankCard(request, json, "保存银行卡");
				break;
			case "updateBankCard":
				updateBankCard(request, json, "修改银行卡入口");
				break;
			case "withdrawalToCard":
				withdrawalToCard(request, json, "提现到银行卡");
				break;
			case "chooseCard":
				chooseCard(request, json, "选择银行卡");
				break;
			case "withdrawalsInfo":
				withdrawalsInfo(request, json, "提现详情");
				break;
			case "doWxInfo":
				doWxInfo(request, session, response, json, "处理微信授权返回的数据");
				break;
			default:
				json.put("code", -3);
				json.put("message", "功能开发中...");
				break;
		}
	}
}
