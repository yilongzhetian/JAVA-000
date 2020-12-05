package com.ylzt.geekbang.lesson07.work3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.ComponentScans;

/**
 * @ClassName: ShardingsphereApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/6 2:30 上午
 **/
@EntityScan(basePackages = "com.ylzt.geekbang.lesson07.domain")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class ShardingsphereApplication {

    public  static  void  main(String args[]){
        SpringApplication.run(ShardingsphereApplication.class,args);
    }

}
