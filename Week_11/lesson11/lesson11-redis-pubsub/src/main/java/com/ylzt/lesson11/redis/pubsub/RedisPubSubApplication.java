package com.ylzt.lesson11.redis.pubsub;

import com.ylzt.lesson11.redis.pubsub.pub.OrderPubService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName: RedisLockApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/5 11:09 下午
 **/
@SpringBootApplication
public class RedisPubSubApplication {


    public  static  void main(String[] args){
        ApplicationContext applicationContext=SpringApplication.run(RedisPubSubApplication.class,args);
        OrderPubService orderPubService=applicationContext.getBean(OrderPubService.class);
        for(int i=0;i<10;i++){
            orderPubService.createOrder("DD-"+i,i);//创建订单测试
        }

    }

}
