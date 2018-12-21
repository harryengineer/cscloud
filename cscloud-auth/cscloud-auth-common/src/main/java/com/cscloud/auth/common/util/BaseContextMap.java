package com.cscloud.auth.common.util;

import java.util.HashMap;
import java.util.Map;

import com.cscloud.common.base.constant.GlobalConstants;
import com.cscloud.common.base.util.StringHelperUtils;

/**
 * 用来存放每个用户解析后访问的数据
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class BaseContextMap {

	public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	public static void set(String key, Object value) {
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<>();
			threadLocal.set(map);
		}
		map.put(key, value);
	}

	public static Object get(String key) {
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<>();
			threadLocal.set(map);
		}
		return map.get(key);
	}

	public static String getUserID() {
		Object value = get(GlobalConstants.CONTEXT_KEY_USER_ID);
		return returnObjectValue(value);
	}

	public static String getUsername() {
		Object value = get(GlobalConstants.CONTEXT_KEY_USERNAME);
		return returnObjectValue(value);
	}

	public static String getName() {
		Object value = get(GlobalConstants.CONTEXT_KEY_USER_NAME);
		return StringHelperUtils.getNoNullString(value);
	}

	public static String getUserToken() {
		Object value = get(GlobalConstants.CONTEXT_KEY_USER_TOKEN);
		return StringHelperUtils.getNoNullString(value);
	}

	public static String getClientToken() {
		Object value = get(GlobalConstants.CONTEXT_KEY_CLIENT_TOKEN);
		return StringHelperUtils.getNoNullString(value);
	}

	public static void setClientToken(String token) {
		set(GlobalConstants.CONTEXT_KEY_CLIENT_TOKEN, token);
	}

	public static void setUserToken(String token) {
		set(GlobalConstants.CONTEXT_KEY_USER_TOKEN, token);
	}

	public static void setName(String name) {
		set(GlobalConstants.CONTEXT_KEY_USER_NAME, name);
	}

	public static void setUserID(String userID) {
		set(GlobalConstants.CONTEXT_KEY_USER_ID, userID);
	}

	public static void setUsername(String username) {
		set(GlobalConstants.CONTEXT_KEY_USERNAME, username);
	}

	private static String returnObjectValue(Object value) {
		return value == null ? null : value.toString();
	}

	public static void setHost(String url){
		set("host",url);
	};

	public static String getHost(){
		return returnObjectValue(get("host"));
	}


	/**
	 * 删除保存的用户信息
	 */
	public static void remove() {
		threadLocal.remove();
	}

}
