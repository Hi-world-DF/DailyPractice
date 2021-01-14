package com.juc;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  1.故障现象
 *      java.util.ConcurrentModificationException
 *  2.导致原因
 *      2.1 ArrayList add方法没有同步机制，线程不安全
 *      2.2
 *  3.解决办法
 *      3.1 用Vector，可解决但是不推荐
 *      3.2 用Collections工具类，Collections.synchronizedList(new ArrayList<>());
 *      3.3 CopyOnWriteArrayList<>();
 *  4.优化建议（同样错误不犯第二次）
 *
 * */
public class NotSafeDemo03 {
    public static void main(String[] args){
        mapNotSafe();
    }
    //ArrayList线程不安全
    public static  void listNotSafe(){
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i = 1;i <= 30;i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
    //HashSet线程不安全
    public static void setNotSafe(){
        Set<String> set = new CopyOnWriteArraySet<>();
        for(int i = 1;i <= 30;i++){
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
    //HashMap线程不安全
    public static void mapNotSafe(){
        Map<String,String> map = new ConcurrentHashMap<>();
        for(int i = 1;i <= 30;i++){
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
