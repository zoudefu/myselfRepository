package com.java1234.webservice.impl;



import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.java1234.webservice.HelloWorld;

public class Server {

	public static void main(String[] args) {
		System.out.println("web service start");
		HelloWorld implementor=new HelloWorldImpl();
		String address="http://10.41.107.160/helloWorld";
		// Endpoint.publish(address, implementor); // jdkʵ�� ��¶webservice�ӿ�
		JaxWsServerFactoryBean factoryBean=new JaxWsServerFactoryBean();
		factoryBean.setAddress(address); // ���ñ�¶��ַ
		factoryBean.setServiceClass(HelloWorld.class); // �ӿ���
		factoryBean.setServiceBean(implementor); // ����ʵ����
		factoryBean.create(); // ����webservice�ӿ�
		System.out.println("web service started");
	}
}
