package com.cscloud.common.base.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
public class JacksonUtils extends BaseUtil {

    /**
     * 
     */
    private static final long serialVersionUID = 67587921296850459L;

    private JacksonUtils() {
        //工具类无需对象实例化
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static String toJson(Object object) throws JsonProcessingException {
        return toJson(object, false);
    }

    public static String toJson(Object object, boolean isFormat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        mapper.setDateFormat(fmt);  
        if (isFormat) {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } else {
            return mapper.writeValueAsString(object);
        }
    }

    public static <T> T toObject(String content, Class<T> c)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, c);
    }

    public static <T> List<T> toListObject(String content, Class<T> c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true) ;   
        JavaType t = getCollectionType(ArrayList.class, c);
        return (List<T>) mapper.readValue(content, t);
    }

    public static <T> Map<String, T> toMapObject(String content, Class<T> c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType t = getCollectionType(HashMap.class, String.class, c);
        return (Map<String, T>) mapper.readValue(content, t);
    }

}
