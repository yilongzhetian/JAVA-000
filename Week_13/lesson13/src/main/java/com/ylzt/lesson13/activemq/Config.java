package com.ylzt.lesson13.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @ClassName: Config
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/13 2:00 上午
 **/
@Configuration
@EnableJms
public class Config {

    @Bean(name="queue")
    public Queue queue() {
        return new ActiveMQQueue("queue.test");
    }

    @Bean(name = "topic")
    public Topic topic(){
        return new ActiveMQTopic("topic.test");
    }



}
