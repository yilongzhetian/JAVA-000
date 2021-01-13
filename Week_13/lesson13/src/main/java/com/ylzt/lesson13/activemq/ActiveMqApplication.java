package com.ylzt.lesson13.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName: ActiveMqApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/13 1:58 上午
 **/
@SpringBootApplication
public class ActiveMqApplication {

    public static void main(String[] args){
       ApplicationContext context= SpringApplication.run(ActiveMqApplication.class,args);
       ProducerService producerService=context.getBean(ProducerService.class);
      /* for(int i=0;i<100;i++){
           producerService.sendQueueMsg("消息"+i);
       }*/

       // Spring Boot集成ActiveMQ时默认只支持队列或者广播之一，通过配置项spring.jms.pub-sub-domain来指定，true 为广播模式，false为队列模式，默认情况下支持队列模式。
        for(int i=0;i<100;i++){
            producerService.sendTopicMsg("消息"+i);
        }

    }
}
