/**
 * 
 */
package com.yjf.esupplier.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.common.Logger;

/**
 * product navigator manage the visiting path of guest to products a path should
 * like below: 所有分类 > 专业合作社产品 > 茶叶 > 红茶 > 春茶 > 生茶(4) the type
 * "专业合作社产品 > 茶叶 > 红茶" map to code "0001-0004-0002" the facade "春茶" is a "采摘季节"
 * the facade "生茶" is a "焙火程度" the number "4" is product count according to the
 * conditions The URL should be:
 * ?pn.typeCode=0001-0004-0002&facade=12::春茶#;13::生茶
 * 
 * @author kunyun,hooxin
 * @author liujunwei modify 2011-04
 */
public class ProductNavigator {
	private static Logger logger = Logger.getLogger(ProductNavigator.class);
	private String typeCode; // 0001-0001-0002
								// or
								// 0001-0001
								// or 0001
	private String typeName; // 保健药品 or
								// 保健品 or
								// 专业合作社产品
	// 制定处理链接
	private String url;
	// 用户自定义参数
	private String userPara;
	
	private ArrayList<String> facades = new ArrayList<String>();
	
	public ProductNavigator() {
	}
	
	public ProductNavigator(String typeCode, String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}
	
	public ProductNavigator addFacade(String facade) {
		this.facades.add(facade);
		return this;
	}
	
	/**
	 * parse facades text
	 * 
	 * @param facadesText
	 * @return
	 */
	public ProductNavigator parseFacades(String facadesText) {
		/*
		 * 品牌=普洱;制茶工艺=红茶
		 * ([^=;]{1,})=([^=;]{1,})
		 */
		/*
		 * 品牌::普洱;制茶工艺::红茶
		 */
		facades.clear();
		// 这里可能不能用=的形式，改用##号
		// Pattern regex = Pattern.compile("([^=;]{1,})=([^=;]{1,})",
		// Pattern.DOTALL | Pattern.MULTILINE);
		Pattern regex = Pattern.compile("([^##]{1,}::([^##]{1,}))", Pattern.DOTALL
																	| Pattern.MULTILINE);
		Matcher regexMatcher = regex.matcher(facadesText);
		while (regexMatcher.find()) {
			String facade = regexMatcher.group(1);
			facades.add(facade);
		}
		return this;
	}
	
	@Override
	public String toString() {
		String delim = "&nbsp;&gt;&nbsp;";
		StringBuilder s = new StringBuilder();
		// 首页
		// add by hooxin
		//String page = WebContext.fullUrl(PropertyFactory.getProperty("default_property.properties","asn.product.homepage"));
		String page = "/";
		page = page.contains("?") ? page + "&" + userPara : page + "?" + userPara;
		//s.append(String.format("<a href='%s'>首页</a>%s", page, delim));		//2010-10-25 liujunwei 暂时去掉首页
		// 0级
		//page = WebContext.fullUrl(PropertyFactory.getProperty("default_property.properties","asn.product.typeAllUrl"));
		page = "/";
		page = page.contains("?") ? page + "&" + userPara : page + "?" + userPara;
		s.append(String.format("<a href='%s'>所有分类</a>", page));
		// 导航action地址
		if (getUrl() == null || getUrl().equals("")) {
			//setUrl(WebContext.fullUrl(PropertyFactory.getProperty("default_property.properties","asn.product.searchUrl")));
			setUrl("/");
		} else
			setUrl(url);
		if (typeCode != null) {
			// TODO find all level of type
			// typeCode.substr(0, 4) - level one
			// typeCode.substr(0, 9) - level two
			// typeCode - level three
			// TODO MAKE LINK OF ALL LEVEL
			String lvls[] = typeCode.split("-");
			String lvl = "";
			for (int i = 0; i < lvls.length; i++) {
				lvl += lvls[i];
				String tName = null;
				
				//				try {
				//					tName = ProductTypeService.getProductTypeByCode(lvl);
				//				} catch (Exception e) {//TODO 检查是否出问题？
				//					logger.error(e.getLocalizedMessage() + e);
				//					//					System.out.println(ProductNavigator.class
				//					//							.getName() + ": 得到类型错误");
				//				}
				s.append(String.format("%s<a href='%s'>%s</a>", delim,
					makeHref(getUrl(), "type=" + lvl, getUserPara()), tName)); // ...
				lvl += "-";
			}
			
		}
		for (int i = 0; i < facades.size(); i++) {
			// FACADE后续##，以确认唯一记录，避免发生12::12##13::1234##的情况
			s.append(String.format(
				"%s<a href='%s'>%s</a>",
				delim,
				makeHref(getUrl(), "type=" + typeCode, "facade=" + facades.get(i) + "##",
					getUserPara()), facades.get(i).toString().split("::")[1])); // ...
		}
		return s.toString();
	}
	
	// 原始版本
	// private String makeHref(String url, String... para){
	// String s=url;
	// if(para.length>0) s += "?";
	// String arg2 = "";
	// for(int i=1; i<para.length; i++){
	// if(para[i] != null && !para.equals(""))
	// arg2 += para[i]+"&";
	// }
	// arg2 = arg2.substring(0,arg2.length()-1);
	//
	// try {
	// arg2 = URLEncoder.encode(arg2, "UTF-8");
	// arg2 = URLEncoder.encode(arg2, "UTF-8");
	// s += arg2;
	// } catch (UnsupportedEncodingException e) {
	// logger.error(e.getLocalizedMessage()+e);
	// }
	//
	// return s;
	// }
	
	private String makeHref(String url, String... para) {
		String s = url;
		if (para.length > 0)
			s += "?";
		String arg2 = "";
		Pattern regex = Pattern.compile("([^#!@<>\\.?;$\\[\\]]{1,})=([^!@<>\\.?;$\\[\\]]{1,})",
			Pattern.DOTALL | Pattern.MULTILINE);
		for (int i = 0; i < para.length; i++) {
			if (para[i] != null && !para.equals("")) {
				Matcher regexMatcher = regex.matcher(para[i]);
				if (regexMatcher.find()) {
					try {
						String tmp = regexMatcher.group(2);
						tmp = URLEncoder.encode(tmp, "UTF-8");
						tmp = URLEncoder.encode(tmp, "UTF-8");
						arg2 += regexMatcher.group(1) + "=" + tmp + "&";
					} catch (UnsupportedEncodingException e) {
						logger.error(e.getLocalizedMessage() + e);
						//System.err.println("无法支持UTF-8编码");
					}
				}
			}
		}
		arg2 = arg2.substring(0, arg2.length() - 1);
		s += arg2;
		
		return s;
		
	}
	
	public ArrayList<String> getFacades() {
		return facades;
	}
	
	public void setFacades(ArrayList<String> facades) {
		this.facades = facades;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUserPara(String userPara) {
		this.userPara = userPara;
	}
	
	public String getUserPara() {
		return userPara;
	}
	
	public String getTypeCode() {
		return typeCode;
	}
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
