package com.concurrent;

import java.util.concurrent.*;

/**
 * @auther : wdf
 * @create : 2020-05-20
 * 第四种获得/使用多线程的方式，线程池
 *
 * */

public class MyThreadPoolDemo {
    public static void main(String[] args){
        /**硬件基础判断，先判定是几核的cpu
         * （1）若是CPU密集型：一般为 CPU核数 + 1个线程的线程池
         * （2）若是I/O密集型：
         *       1.并不是一直在执行任务，应尽可能配置多的线程，如 cpu核数 * 2；
         *       2.大部分线程都阻塞，故需要配置多一些线程 如 cpu核数 / (1-阻塞系数) --> 阻塞系数在0.8 ~ 0.9之间
         */

        //CPU 核数
        int cpuNum = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuNum);

        //(1)一个线程池可以有5个处理线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //(2)一个线程池可以有5个处理线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //(3)一个线程池多个处理线程:若一个处理线程能处理过来就一个，不行就按需求加，自动添加，随机扩容
        //ExecutorService threadPool = Executors.newCachedThreadPool();


        /**
         * 以上三个我们一般都不用，一般使用自己手写的线程池
         * */
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try{
            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for(int i =1;i <= 10;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
