package com.furui.ydfr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
  @RequestMapping(value="login")
  public ModelAndView login(String userName,String passWord){
	  Map<String,Object> data=new HashMap<String, Object>();
	  Subject subject=SecurityUtils.getSubject();
	 UsernamePasswordToken token=new UsernamePasswordToken(userName,passWord);
	 try{
		 subject.login(token);
		 Session session=subject.getSession();
		 session.setAttribute("info", "session数据");
		 data.put("message","用户都登录成功"); 
		 data.put("success", true);
	 }catch(Exception e){
		 e.printStackTrace();
		 data.put("message","用户登录失败");
		 data.put("success", false);
	 }
	 return new ModelAndView("/index/index",data) ;
}
  @RequestMapping(value="student")
  public ModelAndView Test(){
	  Map<String,Object> data=new HashMap<String, Object>();
	  return new ModelAndView("/index/index",data) ;
  }
}