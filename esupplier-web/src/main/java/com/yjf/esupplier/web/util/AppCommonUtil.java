package com.yjf.esupplier.web.util;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.cglib.beans.BeanMap;

import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.MD5Util;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.ws.enums.RegistFromEnum;

/**
 * 
 * 
 * @Filename AppCommontil.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zhaohaibing
 * 
 * @Email abing@yiji.com
 * 
 * @Date: 2015-1-5
 * 
 * 
 */
public class AppCommonUtil {
	private final static String addMDString = "dsf2IHU158JI97bv6%^h";
	
	public static String getMD5(HttpSession session, String userBaseId) {
		String SMD5String = null;
		String token = UUID.randomUUID().toString();
		if (StringUtil.isNotEmpty(userBaseId)) {
			SMD5String = MD5Util.getMD5_32(addMDString + userBaseId + token);
			session.setAttribute("SMD5String", SMD5String);
		}
		return SMD5String;
		
	}
	
	public static boolean checkMD5(HttpSession session, String CMD5String) {
		boolean result = false;
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		if (StringUtil.isNotEmpty(userBaseId) && StringUtil.isNotEmpty(CMD5String)) {
			String SMD5String = (String) session.getAttribute("SMD5String");
			if (StringUtil.isNotEmpty(SMD5String) && CMD5String.equals(SMD5String)) {
				result = true;
			}
			
		}
		return result;
		
	}
	
	/**
	 * 将查询的结果装入Map<String,String>
	 * 
	 * */
	public static Map<String, String> beanToMap(Object bean) {
		Map<String, String> map = new HashMap<String, String>();
		setMap(bean, map);
		return AppCommonUtil.cleanNull(map);
		
	}
	
	public static Map<String, String> beanToMap(Object bean, Map<String, String> map) {
		setMap(bean, map);
		return AppCommonUtil.cleanNull(map);
		
	}
	
	@SuppressWarnings("unchecked")
	private static void setMap(Object bean, Map<String, String> map) {
		Map<String, String> map0 = BeanMap.create(bean);
		Object sMap[] = map0.keySet().toArray();
		for (int i = 0; i < map0.size(); i++) {
			String key = (String) sMap[i];
			Object value = map0.get(sMap[i]);
			if (value != null) {
				String class0 = String.valueOf(value.getClass());
				if (class0.toLowerCase().indexOf("date") > -1) {
					map.put(key, DateUtil.simpleFormat((Date) value));
				} else if (class0.toLowerCase().indexOf("money") > -1
							&& class0.toLowerCase().indexOf("giftmoney") == -1) {
					map.put(key, ((Money) value).toStandardString());
				} else {
					map.put(key, String.valueOf(value));
				}
				
			} else {
				map.put(key, "");
			}
			
		}
	}
	
	/**
	 * str 页面展示
	 * 
	 * @param str
	 * @param type mail /mobile/idCard
	 * */
	
	public static String viewStr(String str, String type) {
		if (StringUtil.isEmpty(str)) {
			return "";
		}
		if (StringUtil.isEmpty(type)) {
			return str;
		}
		if ("mail".equals(type) && str.length() > 4) {
			str = str.substring(0, 2) + "***" + str.subSequence(str.indexOf("@"), str.length());
		} else if ("mobile".equals(type) && str.length() == 11) {
			str = str.substring(0, 3) + "****" + str.substring(7, 11);
		} else if ("idCard".equals(type) && str.length() > 5) {
			str = str.substring(0, 4) + "**********"
					+ str.subSequence(str.length() - 4, str.length());
		} else if (StringUtil.equals("realName", type)) {
			str = str.substring(0, 2) + "**";
		} else if (StringUtil.equals("userName", type)) {
			str = str.substring(0, 2) + "***";
		}
		return str;
		
	}
	
	/**
	 * 将返回数据中的 null 换成 ""
	 * */
	public static Map<String, String> cleanNull(Map<String, String> map) {
		Object sMap[] = map.keySet().toArray();
		for (int i = 0; i < map.size(); i++) {
			if (StringUtil.isEmpty(map.get(sMap[i])) || "null".equalsIgnoreCase(map.get(sMap[i]))) {
				map.put((String) sMap[i], "");
			}
		}
		return map;
	}
	
	/**
	 * 解密
	 * */
	public static String decode(String str) {
		byte[] data = str.getBytes();
		int len = data.length;
		ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
		int i = 0;
		int b1, b2, b3, b4;
		while (i < len) {
			do {
				b1 = base64DecodeChars[data[i++]];
			} while (i < len && b1 == -1);
			if (b1 == -1) {
				break;
			}
			do {
				b2 = base64DecodeChars[data[i++]];
			} while (i < len && b2 == -1);
			if (b2 == -1) {
				break;
			}
			buf.write(((b1 << 2) | ((b2 & 0x30) >>> 4)));
			do {
				b3 = data[i++];
				if (b3 == 61) {
					return buf.toString();
				}
				b3 = base64DecodeChars[b3];
			} while (i < len && b3 == -1);
			if (b3 == -1) {
				break;
			}
			buf.write((((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));
			do {
				b4 = data[i++];
				if (b4 == 61) {
					return buf.toString();
				}
				b4 = base64DecodeChars[b4];
			} while (i < len && b4 == -1);
			if (b4 == -1) {
				break;
			}
			buf.write((((b3 & 0x03) << 6) | b4));
		}
		return buf.toString();
	}
	
	private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
															-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
															-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
															-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
															-1, -1, -1, 62, -1, -1, -1, 63, 52, 53,
															54, 55, 56, 57, 58, 59, 60, 61, -1, -1,
															-1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5,
															6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
															17, 18, 19, 20, 21, 22, 23, 24, 25, -1,
															-1, -1, -1, -1, -1, 26, 27, 28, 29, 30,
															31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
															41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
															51, -1, -1, -1, -1, -1 };
	
	private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
															'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
															'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
															'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
															'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
															'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
															'w', 'x', 'y', 'z', '0', '1', '2', '3',
															'4', '5', '6', '7', '8', '9', '+', '/' };
	
	/********** 加密 ******/
	public static String encode(String str) {
		StringBuffer sb = new StringBuffer();
		byte[] data = str.getBytes();
		int len = data.length;
		int i = 0;
		int b1, b2, b3;
		
		while (i < len) {
			b1 = data[i++] & 0xff;
			if (i == len) {
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
				sb.append("==");
				break;
			}
			b2 = data[i++] & 0xff;
			if (i == len) {
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
				sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
				sb.append("=");
				break;
			}
			b3 = data[i++] & 0xff;
			sb.append(base64EncodeChars[b1 >>> 2]);
			sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
			sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
			sb.append(base64EncodeChars[b3 & 0x3f]);
		}
		return sb.toString();
	}
	
	public static String getRegistFromByRequest(HttpServletRequest request) {
		String userAgent = request.getHeader("user-agent");
		String rs = "";
		if (StringUtil.isBlank(userAgent)) {
			rs = RegistFromEnum.PC.code();
		} else if (userAgent.toLowerCase().indexOf("android") > -1) {
			rs = RegistFromEnum.ANDROID.code();
		} else if (userAgent.toLowerCase().indexOf("ios") > -1) {
			rs = RegistFromEnum.IOS.code();
		} else if (userAgent.toLowerCase().indexOf("pad") > -1) {
			rs = RegistFromEnum.PAD.code();
		} else {
			rs = RegistFromEnum.PC.code();
		}
		return rs;
		
	}
	
	/*************** 判断是否移动端 **************/
	private static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
										+ "|windows (phone|ce)|blackberry"
										+ "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
										+ "|laystation portable)|nokia|fennec|htc[-_]"
										+ "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
	private static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
										+ "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
	
	//移动设备正则匹配：手机端、平板  
	private static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
	private static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);
	
	/**
	 * 检测是否是移动设备访问
	 * @return true:移动设备接入，false:pc端接入
	 */
	public static boolean check(String userAgent) {
		if (null == userAgent) {
			userAgent = "";
		}
		// 匹配    
		Matcher matcherPhone = phonePat.matcher(userAgent);
		Matcher matcherTable = tablePat.matcher(userAgent);
		if (matcherPhone.find() || matcherTable.find()) {
			return true;
		} else {
			return false;
		}
	}

	public  static  String decodeCheck(String pwd){
		return pwd.replaceAll("-jia","+");
	}


	
}
