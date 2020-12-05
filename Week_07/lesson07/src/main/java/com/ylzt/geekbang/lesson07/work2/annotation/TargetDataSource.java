package com.ylzt.geekbang.lesson07.work2.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: TargetDataSource
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/6 1:14 上午
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented()
public @interface TargetDataSource {

    String value();
}
