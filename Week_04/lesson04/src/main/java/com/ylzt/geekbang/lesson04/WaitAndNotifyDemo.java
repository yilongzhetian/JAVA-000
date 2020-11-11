package com.ylzt.geekbang.lesson04;

/**
 * @ClassName: WaitAndNotifyDemo
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/12 12:10 上午
 **/
public class WaitAndNotifyDemo {
    private static int result;
    public static void main(String args[]){
        Object lock=new Object();
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    result = Fibonacci.sum();
                    lock.notify();
                }
            }
        });
        t.start();
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);

    }
}
