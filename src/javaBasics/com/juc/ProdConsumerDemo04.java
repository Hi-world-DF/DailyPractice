package com.juc;

import org.springframework.asm.SpringAsmInfo;
import sun.awt.windows.ThemeReader;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：两个线程，可以操作初始值为0的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1；
 * 实现交替，来多轮，变量初始值为0；
 *
 * 1.高内聚低耦合，线程操作资源类
 * 2.判断/操作/通知
 * 3.防止多线程的虚假唤醒
 *
 * 知识小结：多线程编程套路+while判断+新版写法
 *
 * */
class AirCondition{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    /**
     * 用synchronized实现
     * */
//    public synchronized void addNumber() throws InterruptedException {
//        while(number != 0){
//            this.wait();
//        }
//        number++;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        this.notifyAll();
//    }
//    public synchronized void subNumber() throws InterruptedException {
//        while(number == 0){
//            this.wait();
//        }
//        number--;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        this.notifyAll();
//    }
    /**
     * 用Lock实现
     *
     * */
    public void addNumber(){
        lock.lock();
        try{
            while(number != 0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void subNumber() {
        lock.lock();
        try{
            while(number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

public class ProdConsumerDemo04 {
    public static void main(String[] args) {
        //资源类
        AirCondition airCondition = new AirCondition();
        //两个线程
        new Thread(() -> {
            for(int i = 0;i < 10;i++){
                airCondition.addNumber();
            }
        },"A").start();

        new Thread(()->{
            for(int i = 0; i < 10;i++){
                airCondition.subNumber();
            }
        },"B").start();

        new Thread(()->{
            for(int i = 0; i < 10;i++){
                airCondition.addNumber();
            }
        },"C").start();

        new Thread(()->{
            for(int i = 0; i < 10;i++){
                airCondition.subNumber();
            }
        },"D").start();
    }
}
