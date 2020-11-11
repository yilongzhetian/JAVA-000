package com.ylzt.geekbang.lesson04;

import java.util.concurrent.*;

/**
 * @ClassName: CallTread
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/9 11:29 下午
 **/
public class FutureTaskDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return Fibonacci.sum();
    }




    public static void main(String args[]) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task=new FutureTask<Integer>(new FutureTaskDemo());
        Thread thread=new Thread(task);
        thread.start();
        System.out.println(task.get());

    }
}
