package com.ylzt.geekbang.lesson05.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: StudentFactory
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/18 12:40 上午
 **/
public class StudentFactory  {

    public  Student create(){
        Student st=new Student();
        st.setName("工厂-小明");
        st.setGender("男");
        return st;
    }

}
