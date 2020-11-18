package com.ylzt.geekbang.lesson05.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/17 11:49 下午
 **/
@Component(value = "annotation")
public class Student {

    private String name;

    private String gender;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }


}
