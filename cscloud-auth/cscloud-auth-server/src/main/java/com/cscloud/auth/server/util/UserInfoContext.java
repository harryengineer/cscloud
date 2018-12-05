package com.cscloud.auth.server.util;

import java.util.HashMap;
import java.util.Map;

import com.cscloud.common.base.constant.GlobalConstants;
import com.cscloud.common.base.util.StringHelperUtils;


/**
 * 用来保存已经调用的服务的client的对应的信息
 * @author Administrator
 *
 */
public class UserInfoContext {

	public static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();
	
	
	public static void set(String key,Object value) {
		Map<String,Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<>();
			threadLocal.set(map);
		}
		map.put(key, value);
	}
	

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getUserID(){
        Object value = get(GlobalConstants.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static String getUsername(){
        Object value = get(GlobalConstants.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }


    public static String getName(){
        Object value = get(GlobalConstants.CONTEXT_KEY_USER_NAME);
        return StringHelperUtils.getNoNullString(value);
    }

    public static String getToken(){
        Object value = get(GlobalConstants.CONTEXT_KEY_USER_TOKEN);
        return StringHelperUtils.getNoNullString(value);
    }
    public static void setToken(String token){set(GlobalConstants.CONTEXT_KEY_USER_TOKEN,token);}

    public static void setName(String name){set(GlobalConstants.CONTEXT_KEY_USER_NAME,name);}

    public static void setUserID(String userID){
        set(GlobalConstants.CONTEXT_KEY_USER_ID,userID);
    }

    public static void setUsername(String username){
        set(GlobalConstants.CONTEXT_KEY_USERNAME,username);
    }

    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }
    
    /**
     * 删除保存的用户信息
     */
    public static void remove(){
        threadLocal.remove();
    }
	
	
	
	
	
	
	
	
}
