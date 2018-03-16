package com.furui.ydfr.Listen;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicMessageListen implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage) message;
                String messages = txtMsg.getText();
                //实际项目中拿到String类型的message(通常是JSON字符串)之后，
                //会进行反序列化成对象，做进一步的处理
                System.out.println("receive txt msg===" + messages);
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
	}
}
