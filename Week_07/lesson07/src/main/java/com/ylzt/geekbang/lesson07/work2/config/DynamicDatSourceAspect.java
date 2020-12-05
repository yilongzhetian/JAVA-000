package com.ylzt.geekbang.lesson07.work2.config;

import com.ylzt.geekbang.lesson07.work2.annotation.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DynamicDatSourceAspect
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/6 1:08 上午
 **/
@Aspect
@Component
@Order(-1)
public class DynamicDatSourceAspect {



    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource){
        String dsName = targetDataSource.value();
        System.out.println("切换数据源:"+dsName);
        DynamicDataSourceContextHolder.setDataSource(dsName); //设置到动态数据源上下文中
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource){
        DynamicDataSourceContextHolder.clear();
    }
}
