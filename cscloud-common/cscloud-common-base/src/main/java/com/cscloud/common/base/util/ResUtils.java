package com.cscloud.common.base.util;

import java.util.HashMap;
import java.util.Map;

import com.cscloud.common.base.constant.ErrorCode;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 用于返回给前台的内容的认证，如果添加这个的话，就不用添加@RestController和@ResponseBody这个注解了
 */
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class ResUtils {

    // 账号被禁用
    public static String lockUser = "账号被禁用，请与管理员联系";
    // 账号或者密码错误
    public static String errUser = "账号或密码错误";

    public static String STATUS = "status";
    public static String MSG = "msg";
    public static String DATA = "data";

    public static String okRes() {
        Map map = new HashMap();
        map.put(STATUS, ErrorCode.OK.getCode());
        map.put(MSG, ErrorCode.OK.getMessage());
        try {
            return resJsonOrJsonP(JacksonUtils.toJson(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // return JSON.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return execRes();
    }

    public static String okRes(Object obj) {

        Map map = new HashMap();
        map.put(STATUS, ErrorCode.OK.getCode());
        map.put(MSG, ErrorCode.OK.getMessage());
        map.put(DATA, obj);

        try {
            return resJsonOrJsonP(JacksonUtils.toJson(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // return JSON.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return execRes();
    }
    
    

    public static String execRes(ErrorCode obj) {
        Map map = new HashMap();
        map.put(STATUS, obj.getValue());
        map.put(MSG, obj.getMessage());
        try {
            return resJsonOrJsonP(JacksonUtils.toJson(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // return JSON.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return execRes();
    }

    public static String execRes() {
        Map map = new HashMap();
        map.put(STATUS, ErrorCode.SYSTEM_ERROR.getCode());
        map.put(MSG, ErrorCode.SYSTEM_ERROR.getMessage());
        try {
            return resJsonOrJsonP(JacksonUtils.toJson(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // return JSON.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return execRes();
    }

    public static String errRes(String code, String msg) {
        Map map = new HashMap();
        map.put(STATUS, code);
        map.put(MSG, msg);
        try {
            return resJsonOrJsonP(JacksonUtils.toJson(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // return JSON.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return execRes();
    }
    
    public static String errRes(String code, String msg, String data) {
        Map map = new HashMap();
        map.put(STATUS, code);
        map.put(MSG, msg);
        map.put(DATA, data);
        try {
            return resJsonOrJsonP(JacksonUtils.toJson(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // return JSON.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
        return execRes();
    }


    /*
     * 返回json或者jsonp跨域格式数据
     */
    public static String resJsonOrJsonP(String jsonStr) {
//        if (ContextConstant.IS_JSONP.equals(FileUtil.getApplicationPro("is.json.or.jsonp"))) {
//            HttpServletRequest request =
//                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            String callback = request.getParameter("callback");
//            if (StringUtils.isNotBlank(callback)) {
//                return callback + "(" + jsonStr + ")";
//            } else {
//                return jsonStr;
//            }
//        } else {
//            return jsonStr;
//        }
    	return jsonStr;
    }
}
