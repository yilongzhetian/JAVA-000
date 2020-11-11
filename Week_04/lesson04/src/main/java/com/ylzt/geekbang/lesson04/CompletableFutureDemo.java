package com.ylzt.geekbang.lesson04;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName: CompletableFutureDemo
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/10 11:15 下午
 **/
public class CompletableFutureDemo {

    public static void  main(String args[]){
       Integer result= CompletableFuture.supplyAsync(()->Fibonacci.sum()).thenApplyAsync(r->r).join();
       System.out.println(result);

    }
}
