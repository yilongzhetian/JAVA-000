package com.ylzt.geekbang.lesson08.work1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @ClassName: SprintBootApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/8 11:06 下午
 **/

@SpringBootApplication
@EntityScan("com.ylzt.geekbang.lesson08.work1.domain")
public class SprintBootWork1Application {

    public static  void main(String args[]){
        SpringApplication.run(SprintBootWork1Application.class,args);
    }

}

