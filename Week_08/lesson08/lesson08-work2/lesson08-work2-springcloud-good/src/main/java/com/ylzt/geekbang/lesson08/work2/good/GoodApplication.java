package com.ylzt.geekbang.lesson08.work2.good;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: GoodApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 5:21 下午
 **/
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@ImportResource({"classpath:applicationContext.xml"})
@MapperScan("com/ylzt/geekbang/lesson08/work2/good/mapper")
@EnableTransactionManagement
public class GoodApplication {

    public  static  void main(String args[]){
        SpringApplication.run(GoodApplication.class,args);
    }

}
