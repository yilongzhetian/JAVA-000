package com.ylzt.geekbang.lesson05.starter.school;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @ClassName: School
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/18 12:55 上午
 **/
@Data
@ToString
public class School implements  ISchool{

    // Resource
    @Autowired(required = true) //primary
            Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding(){

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);

    }
}
