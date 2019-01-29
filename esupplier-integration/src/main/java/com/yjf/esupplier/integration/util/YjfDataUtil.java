package com.yjf.esupplier.integration.util;

import java.util.Random;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.integration.openapi.enums.PeasonSexEnum;
import com.yjf.esupplier.integration.openapi.order.RegisterOrder;
import com.yjf.esupplier.ws.enums.CertTypeEnum;

public class YjfDataUtil {
	static final Random random = new Random();
	
	public static void fullRegisterOrder(RegisterOrder registerOrder) {
		//		if (registerOrder.getAnonymousRegister() != BooleanEnum.YES) {
		//			return;
		//		}
		if (registerOrder.getCertType() == null || StringUtil.isBlank(registerOrder.getCertNo())) {
			registerOrder.setCertType(CertTypeEnum.Other);
			registerOrder.setCertNo(getOtherCertNo());
		} else {
			if (registerOrder.getCertType() == CertTypeEnum.Identity_Card) {
				int gender = getGender(registerOrder.getCertNo());
				if (gender == 1)
					registerOrder.setGender(PeasonSexEnum.MAN);
				else
					registerOrder.setGender(PeasonSexEnum.WOMAN);
			}
		}
		if (StringUtil.isBlank(registerOrder.getCountry())) {
			registerOrder.setCountry("中国大陆");
		}
		if (StringUtil.isBlank(registerOrder.getProvince())) {
			int index = random.nextInt(YjfConstant.CityNameArray.length);
			registerOrder.setProvince(YjfConstant.CityNameArray[index]);
		}
		if (StringUtil.isBlank(registerOrder.getLicenseValidTime())) {
			registerOrder.setLicenseValidTime("0");
		}
		if (StringUtil.isBlank(registerOrder.getRealName())) {
			int indexFirst = random.nextInt(YjfConstant.FirstNameArray.length);
			int indexLast = random.nextInt(YjfConstant.LastNameArray.length);
			registerOrder.setRealName(YjfConstant.FirstNameArray[indexFirst]
										+ YjfConstant.LastNameArray[indexLast]);
		}
		if (registerOrder.getGender() == null) {
			int index = random.nextInt(1000);
			if (index % 2 == 0) {
				registerOrder.setGender(PeasonSexEnum.MAN);
			} else {
				registerOrder.setGender(PeasonSexEnum.WOMAN);
			}
		}
		if ("B".equals(registerOrder.getUserType())) {
			if (StringUtil.isBlank(registerOrder.getEnterpriseBusinessScope())) {
				int index = random.nextInt(YjfConstant.EnterpriseBusinessScopeArray.length);
				registerOrder
					.setEnterpriseBusinessScope(YjfConstant.EnterpriseBusinessScopeArray[index]);
			}
			if (StringUtil.isBlank(registerOrder.getRegAddress())) {
				int index = random.nextInt(YjfConstant.CityNameArray.length);
				registerOrder.setRegAddress(YjfConstant.CityNameArray[index]);
			}
		}
	}
	
	public static String makeAddress() {
		int index = random.nextInt(YjfConstant.CityNameArray.length);
		return YjfConstant.CityNameArray[index];
	}
	
	public static String makeEnterpriseBusinessScope() {
		int index = random.nextInt(YjfConstant.EnterpriseBusinessScopeArray.length);
		return YjfConstant.EnterpriseBusinessScopeArray[index];
	}
	
	/**
	 * 更新是处理
	 * @param registerOrder
	 */
	public static void fullUserInfoOrder(RegisterOrder registerOrder) {
		
		if (!(registerOrder.getCertType() == null || StringUtil.isBlank(registerOrder.getCertNo()))) {
			if (registerOrder.getCertType() == CertTypeEnum.Identity_Card) {
				int gender = getGender(registerOrder.getCertNo());
				if (gender == 1)
					registerOrder.setGender(PeasonSexEnum.MAN);
				else
					registerOrder.setGender(PeasonSexEnum.WOMAN);
			}
		}
		if (StringUtil.isBlank(registerOrder.getCountry())) {
			registerOrder.setCountry("中国大陆");
		}
		if (StringUtil.isBlank(registerOrder.getProvince())) {
			int index = random.nextInt(YjfConstant.CityNameArray.length);
			registerOrder.setProvince(YjfConstant.CityNameArray[index]);
		}
		if (StringUtil.isBlank(registerOrder.getLicenseValidTime())) {
			registerOrder.setLicenseValidTime("0");
		}
		if (registerOrder.getGender() == null) {
			int index = random.nextInt(1000);
			if (index % 2 == 0) {
				registerOrder.setGender(PeasonSexEnum.MAN);
			} else {
				registerOrder.setGender(PeasonSexEnum.WOMAN);
			}
		}
		if ("B".equals(registerOrder.getUserType())) {
			if (StringUtil.isBlank(registerOrder.getEnterpriseBusinessScope())) {
				int index = random.nextInt(YjfConstant.EnterpriseBusinessScopeArray.length);
				registerOrder
					.setEnterpriseBusinessScope(YjfConstant.EnterpriseBusinessScopeArray[index]);
			}
		}
	}
	
	public static String getOtherCertNo() {
		
		int length = 19;
		int i = 0;
		StringBuffer buffer = new StringBuffer();
		int sameValue = random.nextInt(10);
		while (i < length) {
			if (i % 2 == 0) {
				buffer.append(random.nextInt(10));
			} else {
				buffer.append(sameValue);
			}
			i++;
		}
		return buffer.toString();
	}
	
	public static int getGender(String certNo) {
		if (StringUtil.isNotBlank(certNo)) {
			if (certNo.length() == 15) {
				String c = certNo.substring(14, 15);
				int n = Integer.parseInt(c);
				if (n % 2 != 0) {
					return 1;
				} else {
					return 0;
				}
			} else if (certNo.length() == 18) {
				String c = certNo.substring(16, 17);
				int n = Integer.parseInt(c);
				if (n % 2 != 0) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return 3;
			}
		}
		return 3;
	}
	
	/**
	 * 当前用户为未认证状态的时候，检查是否特殊编号
	 * @param certNo
	 * @return
	 */
	public static boolean isInvalidCertNo(String certNo) {
		int length = 19;
		if (certNo == null || certNo.length() == 0)
			return false;
		if (certNo.length() != length) {
			return false;
		}
		int i = 0;
		String sameValue = certNo.substring(1, 2);
		while (i < length) {
			if (i % 2 != 0) {
				if (!sameValue.equals(certNo.substring(i, i + 1))) {
					return false;
				}
			}
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(getGender("510221197803150075"));
		String[] aa = new String[] { "5888984868789858180", "8939195959593949693",
									"3383932323930353031", "1010007070205020404",
									"5242123242429292729", "9878682848789818285",
									"0949295929599959592", "6535658525356535055",
									"4111516181312161811", "6303733323633303439",
									"3171917181013111110", "7262420232821222020",
									"6171711111019141914", "9949497999297949797",
									"0606764616562696063", "9343536343033343537",
									"5080200000806050305", "0979799959293989199",
									"7262527242024292425", "9232625202121202227",
									"0282924202429212727", "1525656505457585852",
									"7959297949495929694", "7080507090705060809",
									"4878682868783888381", "9838882858684878584",
									"3949596989593999398", "4707470737878777372",
									"1000403090009080009", "6383534313738303935",
									"4424948464744414948", "8080506000703090806",
									"8979897909793989791", "4010105040801040307",
									"3545256535254545153", "1747779767275757575",
									"7323633353932373738", "5212125232527292729",
									"0979192909196969294", "0767571757976787277",
									"0787173757478737573", "3191614121618101533",
									"0404746414649404143", "3606060646367656861",
									"8747079737377797378", "5313638303132393232",
									"4868280878481868840", "8151911131910121019",
									"5979092959197969591", "2949292999999959822" };
		for (int i = 0; i < 50; i++) {
			System.out.println(random.nextInt(10));
		}
		
	}
}
