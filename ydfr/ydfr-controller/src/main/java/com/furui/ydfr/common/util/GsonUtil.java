package com.furui.ydfr.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	public static <T> T fromJson(String json, Class<T> clasz) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, clasz);
	}

	/**
	 * obj 转换成  json 字符串
	 * @param src
	 * @return
	 */
	public static String toJson(Object src) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(src);
	}
	
	
	public static <T> T fromJson(String json, Type typeOfT) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, typeOfT);
	}
	
	public static String put(String snapshot, String key, String value) {
		Gson gson = new GsonBuilder().create();
		Map<String, String> map =  gson.fromJson(snapshot, new TypeToken<Map<String, String>>() {
		}.getType());
		map.put(key, value);
		return gson.toJson(map);
	}
	
	/**
	 * json 字符串 转化  Map
	 * @param jsonStr
	 * @return
	 */
    public static Map<String,Object> jsonToMap(String jsonStr){
    	Gson gson=new Gson();
        Map<String,Object> objMap=null;
        if(gson!=null){
            java.lang.reflect.Type type=new com.google.gson.reflect.TypeToken<Map<String,String>>(){}.getType();
            objMap=gson.fromJson(jsonStr, type);
        }
        return objMap;
    }
    
    /**
     * jsonStr 2 Object
     * @param jsonStr
     * @return
     */
    public static JSONObject stringToJSONOBject(String jsonStr){
    	JSONObject  dataJson=JSONObject.parseObject(jsonStr);
        return dataJson;
    }
    
    /**
     * obj对象转化成  Map
     * @param src
     * @return
     */
    public static Map<String, Object> objToMap(Object src) {
        return jsonToMap(toJson(src));
    }
    
    /**
     * map 转化成 Object
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
        if (map == null){
        	return null;    
        }
        Object obj = beanClass.newInstance();  
        Field[] fields = obj.getClass().getDeclaredFields();   
        for (Field field : fields) {    
            int mod = field.getModifiers();    
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
                continue;    
            }    
            field.setAccessible(true);    
            field.set(obj, map.get(field.getName()));   
        }   
        return obj;    
    }    
    
}
