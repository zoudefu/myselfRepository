package com.java1234.webservice.impl;



import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.java1234.webservice.HelloWorld;

public class Server {

	public static void main(String[] args) {
		System.out.println("web service start");
		HelloWorld implementor=new HelloWorldImpl();
		String address="http://10.41.107.160/helloWorld";
		// Endpoint.publish(address, implementor); // jdk实现 暴露webservice接口
		JaxWsServerFactoryBean factoryBean=new JaxWsServerFactoryBean();
		factoryBean.setAddress(address); // 设置暴露地址
		factoryBean.setServiceClass(HelloWorld.class); // 接口类
		factoryBean.setServiceBean(implementor); // 设置实现类
		factoryBean.create(); // 创建webservice接口
		System.out.println("web service started");
	}
}
