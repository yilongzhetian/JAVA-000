package com.ylzt.geekbang.lesson04;

/**
 * @ClassName: WaitAndNotifyDemo
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/12 12:10 上午
 **/
public class JoinDemo {
    private static int result;
    public static void main(String args[]){
        JoinDemo demo=new JoinDemo();
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                result=Fibonacci.sum();
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }
}
