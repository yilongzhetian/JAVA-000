package com.ylzt.geekbang.lesson05.starter;

import com.ylzt.geekbang.lesson05.starter.school.Klass;
import com.ylzt.geekbang.lesson05.starter.school.School;
import com.ylzt.geekbang.lesson05.starter.school.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SpringBootAutoConfiguration
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/18 11:32 下午
 **/
@Configuration
@ConditionalOnProperty(prefix = "school",name = "enabled",havingValue = "true",matchIfMissing = false)
public class SchoolAutoConfiguration {

    @Bean
    public School create(){
        School school=new School();
        return  school;
    }

    @Bean(name = "student100")
    public Student createStudent(){
        Student st=new Student();
        st.setId(1);
        st.setName("小明");
        return  st;
    }

    @Bean
    public Klass createKlass(){
        Klass klass=new Klass();
        return klass;
    }
}
