package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  有返回值的线程创建方法 实现 Callable 接口
 *
 * */
//class MyThread implements Runnable{
//
//    @Override
//    public void run() {
//
//    }
//}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("Welcome Callable!");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask,"A").start();
        Integer result = futureTask.get();
        System.out.println("返回值："+ result);
    }
}
