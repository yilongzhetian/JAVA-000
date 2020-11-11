package com.ylzt.geekbang.lesson04;

/**
 * @ClassName: Fibonacci
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/10 11:00 下午
 **/
public class Fibonacci {

    public static int sum() {
        return fibo(36);
    }

    public static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
