package com.ylzt.lesson11.redis.lock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName: InventoryService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/7 12:17 上午
 **/
@Service
public class InventoryService {

    private static final String REDIS_INVENTORY_KEY="inventory";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private  RedisLockService redisLockService;

    /**
     * 设置库存
     */
    public void setInventory(Integer inventory){
        redisTemplate.opsForValue().set(REDIS_INVENTORY_KEY,String.valueOf(inventory));
    }

    public boolean decrease(){
       while(true){
           if(redisLockService.tryLock(REDIS_INVENTORY_KEY,10)){
            try {
                Integer inventory =new Integer(redisTemplate.opsForValue().get(REDIS_INVENTORY_KEY).toString());
                if (inventory > 0) {
                    inventory = inventory - 1;
                    redisTemplate.opsForValue().set(REDIS_INVENTORY_KEY, String.valueOf(inventory));
                    System.out.println("剩余库存数量:"+inventory);
                    return true;
                } else {
                    System.out.println("剩余库存数量:"+inventory+",已没有库存了！");
                    return false;
                }
            }finally {
                redisLockService.unLock(REDIS_INVENTORY_KEY);
            }
           }else{
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

       }
    }


}
