package com.concurrent;
/**
 * @auther : wdf
 * @create : 2020-06-01
 * 死锁
 * ：形成死锁--->线程a拥有锁a但又申请锁b，而线程b拥有锁b，同时它也去申请锁a
 * ：判定死锁--->jps命令定位死锁的进程号；jstack到找到死锁查看
 * */

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA,String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 拥有："+lockA+"\t 尝试获得："+lockB);
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 拥有："+lockB+"\t 尝试获得："+lockA);
            }
        }

    }
}
public class DeadLockDemo{
    public static void main(String[] args){
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadAAA").start();
    }

}
