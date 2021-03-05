package com.DesignPatterns;

import com.niuke.test.Singleton;

/**
 * 单例模式：Ⅰ 懒汉式-线程不安全
 *
 * @author Ernest
 * @version 1.0, 5/3/2021
 * @since 1.0.0
 */
public class Singleton1 {

    private static Singleton1 uniqueInstance;

    private Singleton1() {

    }

    public static Singleton1 getUniqueInstance() {
        //延迟实例化，节约资源
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}
