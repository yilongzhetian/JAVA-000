package com.ylzt.geekbang.lesson05.starter;

import com.ylzt.geekbang.lesson05.starter.school.School;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName: SpringBeanApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/18 11:57 下午
 **/
@SpringBootApplication
public class SpringStarterApplication {

    public static  void main(String args[]){
        ConfigurableApplicationContext context= SpringApplication.run(SpringStarterApplication.class,args);

        System.out.println(context.getBean(School.class));

    }
}
