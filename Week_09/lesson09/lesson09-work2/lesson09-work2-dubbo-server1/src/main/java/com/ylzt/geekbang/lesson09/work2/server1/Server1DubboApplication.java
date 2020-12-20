package com.ylzt.geekbang.lesson09.work2.server1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName: Server1DubboApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/21 12:02 上午
 **/
@SpringBootApplication
@MapperScan("com.ylzt.geekbang.lesson09.work2.server1.mapper")
public class Server1DubboApplication {

    public static void main(String[]  args){

        SpringApplication springApplication = new SpringApplication(Server1DubboApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

}
