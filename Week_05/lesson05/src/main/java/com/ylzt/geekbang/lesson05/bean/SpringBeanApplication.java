package com.ylzt.geekbang.lesson05.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName: SprintBootApplicaiton
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/17 11:53 下午
 **/
@SpringBootApplication
@ImportResource(locations = "classpath:spring-beans.xml")
public class SpringBeanApplication {


    public  static  void main(String args[]){

        ConfigurableApplicationContext context= SpringApplication.run(SpringBeanApplication.class,args);

        System.out.println("bean配置:"+context.getBean("bean",Student.class));
        System.out.println("xml配置:"+context.getBean("xml",Student.class));
        System.out.println("annotation配置:"+context.getBean("annotation",Student.class));
        System.out.println("xml工厂:"+context.getBean("factory",Student.class));

        context.close();

    }
}
