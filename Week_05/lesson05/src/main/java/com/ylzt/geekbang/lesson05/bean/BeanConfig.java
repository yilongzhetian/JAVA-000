package com.ylzt.geekbang.lesson05.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: BeanConfig
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/17 11:51 下午
 **/
@Configuration
public class BeanConfig {

    @Bean(name = "bean")
    public Student create(){
        Student st=new Student();
        st.setName("小明-bean");
        st.setGender("男");
        return st;
    }
}
