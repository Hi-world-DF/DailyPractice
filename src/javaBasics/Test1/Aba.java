package javaBasics.Test1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Aba {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args){


        System.out.println("==================ABA问题=====================");
        /**
         * ABA问题，线程1修改了内存值，后面改回100
         * 但是线程B任然操作成功，能进行修改
         * */
        new Thread(() -> {
            atomicReference.compareAndSet(100,99);
            atomicReference.compareAndSet(99,100);
        },"t1").start();

        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            boolean result = atomicReference.compareAndSet(100,2020);
            System.out.println("操作true/false："+result+"\t"+atomicReference.get());
        },"t2").start();

        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("==================解决ABA问题=====================");
        /**
         * 解决ABA问题：原子引用+版本号
         *
         * */
        int stamp = atomicStampedReference.getStamp();
        System.out.println("初始版本号:"+stamp);
        new Thread(()->{
            boolean first = atomicStampedReference.compareAndSet(100,99,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("操作true/false:"+first+"\t"+atomicStampedReference.getReference()+"\t版本号"+atomicStampedReference.getStamp());
            boolean second = atomicStampedReference.compareAndSet(99,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("操作true/false:"+second+"\t"+atomicStampedReference.getReference()+"\t版本号"+atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            boolean result1 = atomicStampedReference.compareAndSet(100,2019,stamp,atomicStampedReference.getStamp()+1);
            System.out.println("操作true/false:"+result1+"\t"+atomicStampedReference.getReference()+"\t版本号"+atomicStampedReference.getStamp());
        },"t4").start();





    }
}
