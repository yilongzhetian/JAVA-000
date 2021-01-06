package com.ylzt.lesson11.redis.pubsub.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ylzt.lesson11.redis.pubsub.sub.OrderSubService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @ClassName: RedisConfi
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/5 11:42 下午
 **/
@Configuration
public class RedisConfig {

    public static String REDIS_TOPIC_ORDER_CHANNEL="order";


    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){

        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.json());
       return  redisTemplate;
    }


    @Bean
    public MessageListenerAdapter listenerAdapter() {
        return new MessageListenerAdapter(new OrderSubService(), "receiveMessage");
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.addMessageListener(listenerAdapter, new PatternTopic(REDIS_TOPIC_ORDER_CHANNEL));
        return listenerContainer;
    }

}
