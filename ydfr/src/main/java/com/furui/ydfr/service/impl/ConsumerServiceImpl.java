package com.furui.ydfr.service.impl;

import javax.jms.JMSException;

import org.springframework.stereotype.Service;

import com.furui.ydfr.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    public void receiveMessage(String message) throws JMSException {
        System.out.println("------------------消费者接收消息-----------------");
        System.out.println("-----------------生产者发来的消息是：" + message);
    }

}
