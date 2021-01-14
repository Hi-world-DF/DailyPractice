package com.juc;

/**
 * 多线程之间按顺序调度 A > B > C > A
 * 描述：一轮完成 A 打印 5 次，然后 B 打印 10 次 ，然后 C 打印 15次
 * 这样循环 10 轮
 * */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDate {
    private Lock lock = new ReentrantLock();
    private int number = 0;//A:1  B:2  C:3
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print(int num,int flag){
        lock.lock();
        try{
            while(number != flag){
                if(flag == 0)  c1.await();
                if(flag == 1)  c2.await();
                if(flag == 2)  c3.await();
            }
            for (int i = 0; i < num; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number = (flag + 1)%3;
            if(number == 0) c1.signal();
            if(number == 1) c2.signal();
            if(number == 2) c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ConditionDemo {
    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate();

        new Thread(()->{
            for (int i = 0; i < 10; i++) shareDate.print(5,0);
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) shareDate.print(10,1);
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) shareDate.print(15,2);
        },"C").start();
    }
}
