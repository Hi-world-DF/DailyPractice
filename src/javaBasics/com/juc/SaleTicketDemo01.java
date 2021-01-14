package com.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：3 个售票员卖 30 张票
 * 笔记：如何编写企业级的多线程代码，固定的编程套路 + 模板
 *
 * 1.在高内聚低耦合前提下，线程 操作 资源类
 * 2.先创建资源类
 *
 *  Runnable 接口是函数式接口 ，可以使用 lambdaExpress
 *
 * */
//@FunctionalInterface
//public interface Runnable {
//    public abstract void run();
//}


public class SaleTicketDemo01 {

    public static void main(String[] args){
        Ticket ticket = new Ticket();
        //三个售票员
        new Thread(() ->{for(int i = 0;i < 40;i++) ticket.sale();},"A").start();
        new Thread(() ->{for(int i = 0;i < 40;i++) ticket.sale();},"B").start();
        new Thread(() ->{for(int i = 0;i < 40;i++) ticket.sale();},"C").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0;i < 40;i++){
//                    ticket.sale();
//                }
//
//            }
//        }, "A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0;i < 40;i++){
//                    ticket.sale();
//                }
//            }
//        }, "B").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0;i < 40;i++){
//                    ticket.sale();
//                }
//            }
//        }, "C").start();
    }
}

//资源类
class Ticket {
    private int number = 30;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if(number > 0){
                System.out.println(Thread.currentThread().getName()+"卖出了第 "+(number--)+" 张票，还剩 "+number+" 张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}