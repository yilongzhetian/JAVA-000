package com.ylzt.geekbang.lesson05.starter.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/18 12:55 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;

    public void init(){
        System.out.println("hello...........");
    }

    public Student create(){
        return new Student(101,"KK101");
    }

}
