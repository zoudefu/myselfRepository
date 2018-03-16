package com.furui.ydfr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furui.ydfr.service.imp.IActiveMqService;
@Controller
public class ActiveMqSend {
	@Autowired
	private  IActiveMqService  activeMqService;

	 @RequestMapping(value="activeMq")
	 @ResponseBody
	 public void  ActiveMqSendMessag(){
		 activeMqService.SendMessageData();
	 }
}
