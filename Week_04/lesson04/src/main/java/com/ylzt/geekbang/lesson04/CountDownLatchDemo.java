package com.ylzt.geekbang.lesson04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CountDownLatchDemo
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/11 12:31 上午
 **/
public class CountDownLatchDemo {
    private static int result;
    public  static void main(String args[]){
        CountDownLatch countDownLatch=new CountDownLatch(1);
        ExecutorService service= Executors.newCachedThreadPool();
        service.submit(()->{
             result=Fibonacci.sum();
           countDownLatch.countDown();
        });
        try {
            countDownLatch.await();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();


    }

}
