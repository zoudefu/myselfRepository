package com.java1234.webservice.impl;

import javax.jws.WebService;

import com.java1234.webservice.HelloWorld;

@WebService
public class HelloWorldImpl implements HelloWorld{

	public String say(String str) {
		return "Hello"+str;
	}

}
