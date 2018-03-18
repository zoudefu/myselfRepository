package com.furui.ydfr.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.furui.ydfr.service.imp.IActiveMqService;
@Service
public class ActiveMqSerivce implements IActiveMqService {
	
	@Autowired
    private JmsTemplate jmsTemplate;
	@Autowired
	private  Destination destination;
	@Override
	public void SendMessageData() {
		String message="activemqMessage";
		 System.out.println("---------------生产者发了一个消息：" + message);  
	        jmsTemplate.send(destination, new MessageCreator() {  
	            @Override
	            public Message createMessage(Session session) throws JMSException {  
	                return session.createTextMessage(message);  
	            }  
	        });  
		
	}

}
