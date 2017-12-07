package com.furui.ydfr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
  @RequestMapping(value="login")
  public ModelAndView login(String userName,String passWord){
	 
	 Map<String,Object> data=new HashMap<String, Object>();
	 logger.info("用户登录系统");
	 data.put("message","SUCESS");
	 return new ModelAndView("login",data) ;
}
}