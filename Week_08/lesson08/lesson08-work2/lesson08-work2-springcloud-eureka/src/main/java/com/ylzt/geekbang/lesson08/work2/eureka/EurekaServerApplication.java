package com.ylzt.geekbang.lesson08.work2.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: eureka
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 5:39 下午
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    public  static  void  main(String args[]){
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
