/**
 * 
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;



/**
 * @author min
 *
 */
public enum InsureWayEnum {

    GUARANTEE("0000000001", "    机构担保标 "),

    CREDIT("0000000010", "实地认证标"),

    PLEDGE("0000000100", "抵押标"),
    SLOANS("0000001000", "小贷"),
    FACTOR("0000010000", "保理"),
     PAPER("0000100000", "票据"),
  CARLOANS("0001000000", "车贷"),
     LEASE("0010000000", "融资租凭"),
    CREDITLOAN("0100000000", "信用贷"),

    OTHER("0000000000", "其他");
	
	
	private final String code;
	private final String message;
	private InsureWayEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}

	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}

	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return LogResultEnum
	 */
	public static InsureWayEnum getByCode(String code) {
		for (InsureWayEnum _enum : values()) {
			if (_enum.getCode().equalsIgnoreCase(code)) {
				return _enum;
			}
		}
		return null;
	}

	/**
	 * 获取全部枚举
	 * 
	 * @return List<LogResultEnum>
	 */
	public static List<InsureWayEnum> getAllEnum() {
		List<InsureWayEnum> list = new ArrayList<InsureWayEnum>();
		for (InsureWayEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}

	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (InsureWayEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}

}
