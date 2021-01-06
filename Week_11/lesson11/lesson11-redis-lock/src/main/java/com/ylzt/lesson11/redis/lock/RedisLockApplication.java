package com.ylzt.lesson11.redis.lock;

import com.ylzt.lesson11.redis.lock.service.InventoryService;
import com.ylzt.lesson11.redis.lock.service.RedisLockService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RedisLockApplication {


    public  static  void main(String[] args){

         ApplicationContext applicationContext=SpringApplication.run(RedisLockApplication.class,args);
        // RedisLockService redisLockService=applicationContext.getBean(RedisLockService.class);
        InventoryService inventoryService=applicationContext.getBean(InventoryService.class);
        inventoryService.setInventory(100);//设置库存
        for(int i=0;i<101;i++){//模拟减库存
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    inventoryService.decrease();
                }
            });
            t.start();

        }



    }

}
