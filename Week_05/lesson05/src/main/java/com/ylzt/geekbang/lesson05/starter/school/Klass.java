package com.ylzt.geekbang.lesson05.starter.school;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: Kclass
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/18 12:54 上午
 **/
@Data
@ToString
public class Klass {

    @Autowired
    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }
}
