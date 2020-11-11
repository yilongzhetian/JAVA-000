package com.ylzt.geekbang.lesson04;

import java.util.concurrent.*;

/**
 * @ClassName: CallTread
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/9 11:29 下午
 **/
public class FutureDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return Fibonacci.sum();
    }




    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(new FutureDemo());
        System.out.println(future.get());
        executorService.shutdown();

    }
}
