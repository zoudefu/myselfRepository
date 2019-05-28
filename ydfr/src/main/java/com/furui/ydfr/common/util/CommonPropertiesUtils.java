package com.furui.ydfr.common.util;

import java.util.Properties;

public class CommonPropertiesUtils {

	public static Properties config = null;

	public static String get(String key){
		return config.getProperty(key);
	}
	
	public static String get(String key, String defaultValue){
		String value = get(key);
		if(value == null || "".equals(value.trim())){
			return defaultValue;
		}else{
			return value;
		}
	}
	
	public static Integer getInt(String key, Integer defaultValue){
		String value = get(key);
		if(value == null || "".equals(value.trim())){
			return defaultValue;
		}else{
			return Integer.parseInt(value);
		}
	}
	
	public static Long getLong(String key, Long defaultValue){
		String value = get(key);
		if(value == null || "".equals(value.trim())){
			return defaultValue;
		}else{
			return Long.parseLong(value);
		}
	}
	
	public static Double getDouble(String key, Double defaultValue){
		String value = get(key);
		if(value == null || "".equals(value.trim())){
			return defaultValue;
		}else{
			return Double.parseDouble(value);
		}
	}
	
	public static Float getFloat(String key, Float defaultValue){
		String value = get(key);
		if(value == null || "".equals(value.trim())){
			return defaultValue;
		}else{
			return Float.parseFloat(value);
		}
	}
	
}
