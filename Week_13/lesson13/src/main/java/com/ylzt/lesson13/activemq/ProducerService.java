package com.ylzt.lesson13.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @ClassName: Producer
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/13 1:59 上午
 **/
@Service
public class ProducerService {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    @Qualifier(value = "queue")
    private Queue queue;

    @Autowired
    @Qualifier(value = "topic")
    private Topic topic;


    public void sendQueueMsg(String msg){
       jmsMessagingTemplate.convertAndSend(this.queue,msg);
    }

    public void sendTopicMsg(String msg){
        jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }

}
