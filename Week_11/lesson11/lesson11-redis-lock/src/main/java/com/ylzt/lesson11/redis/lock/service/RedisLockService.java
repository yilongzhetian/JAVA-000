package com.ylzt.lesson11.redis.lock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisLockService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/5 11:30 下午
 **/
@Service
public class RedisLockService {

    private static final String REDIS_LOCK = "redis:lock:";

    @Autowired
    private RedisTemplate redisTemplate;


    public boolean tryLock(String key,Integer timeout){
        return  this.lock(key,getLockValue(),timeout);
    }

    public  void unLock(String key){
        this.unLock(key,getLockValue());
    }



    private boolean lock(String key,String value,Integer timeout){
        Boolean result = redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK + key, value, timeout, TimeUnit.SECONDS);
        return result != null && result;

    }

    private void unLock(String key,String value){
        key=REDIS_LOCK+key;
        if (value.equals(redisTemplate.opsForValue().get(key))) {
            redisTemplate.opsForValue().getOperations().delete(key);
        }
    }

    private String getLockValue(){
        try {
            InetAddress ip4 = Inet4Address.getLocalHost();
           return  ip4.getHostAddress()+":"+ Thread.currentThread().getId();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return  null;
    }


}
