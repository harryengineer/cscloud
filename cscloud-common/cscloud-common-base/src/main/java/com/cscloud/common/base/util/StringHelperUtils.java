package com.cscloud.common.base.util;

/**
 * String工具类
 * @author Administrator
 *
 */
public class StringHelperUtils {
	/**
	 * 传入对象，对象不为空获取对象的toString的值
	 * @param obj
	 * @return
	 */
	public static String getNoNullString(Object obj) {
		return obj == null ? "": obj.toString();
	}

}
