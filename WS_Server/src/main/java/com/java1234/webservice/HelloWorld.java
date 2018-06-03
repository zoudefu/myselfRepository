package com.java1234.webservice;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	public String say(String str);
}
