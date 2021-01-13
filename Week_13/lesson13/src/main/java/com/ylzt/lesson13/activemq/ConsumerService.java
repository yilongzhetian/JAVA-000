package com.ylzt.lesson13.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/13 1:59 上午
 **/
@Service
public class ConsumerService {

    @JmsListener(destination="queue.test")
    public void receiveQueueMessage(String text) {
        System.err.println("【*****接受消息[queue]******】"+text);
    }

    @JmsListener(destination="topic.test")
    public void receiveTopicMessage(String text){
        System.err.println("【*****接受消息[topic]******】"+text);

    }


}
