package com.ylzt.geekbang.lesson09.work2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * @ClassName: ClientApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/21 1:05 上午
 **/
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ClientApplication {

    public  static  void main(String[] args){
        SpringApplication.run(ClientApplication.class,args);
    }
}
