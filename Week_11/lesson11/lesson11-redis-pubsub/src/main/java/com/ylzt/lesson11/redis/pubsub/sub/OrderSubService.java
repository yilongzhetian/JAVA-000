package com.ylzt.lesson11.redis.pubsub.sub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ylzt.lesson11.redis.pubsub.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OrderSubService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/7 12:57 上午
 **/
public class OrderSubService {



    public  void receiveMessage(String message){
        GenericJackson2JsonRedisSerializer serializer=new GenericJackson2JsonRedisSerializer();
        Order order= serializer.deserialize(message.getBytes(),Order.class);
        System.out.println("开始异步处理订单:"+order.getOrderNo());
    }


}
