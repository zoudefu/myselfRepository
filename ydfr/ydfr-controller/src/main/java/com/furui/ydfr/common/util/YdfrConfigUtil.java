package com.furui.ydfr.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class YdfrConfigUtil {
	
	public static String  ydfr;
	//用java配置对象相当map对象使用
	public static Properties properties= new Properties();
	
	static {
		try {
			initConfig();
		} catch (IOException e) {
			//logger.error("初始化配置文件失败", e);;
			System.out.println(e.getMessage());
		}
	}
	public static void initConfig() throws IOException{
		//jvm加载YdfrUtil 因为执行静态块的时候  YdfrUtil有可能还没加载 路径前 有/表示根目录  没有表示当前目录
		InputStream in = YdfrConfigUtil.class.getResourceAsStream("/book.properties");
		//properties对象开始读配置文件
		properties.load(in);
		//将配置信息设置给对象
		setYdfr(properties.getProperty("ydfr"));
	}
	public static String getYdfr() {
		return ydfr;
	}
	public static void setYdfr(String ydfr) {
		YdfrConfigUtil.ydfr = ydfr;
	}
}
