package com.ylzt.lesson11.redis.pubsub.pub;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.ylzt.lesson11.redis.pubsub.config.RedisConfig;
import com.ylzt.lesson11.redis.pubsub.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: OrderPubService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/7 12:56 上午
 **/
@Service
public class OrderPubService {


    @Autowired
    private RedisTemplate redisTemplate;

    public void createOrder(String orderNo,Integer userId){
        Order order=new Order();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setCreatedAt(new Date());
        System.out.println("开始创建订单："+orderNo);
        redisTemplate.convertAndSend(RedisConfig.REDIS_TOPIC_ORDER_CHANNEL,order);
    }

}
