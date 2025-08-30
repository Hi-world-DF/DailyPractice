package javaBasics.com.DesignPatterns;

/**
 * 单例模式：Ⅱ 饿汉式-线程安全
 *
 * @author Ernest
 * @version 1.0, 5/3/2021
 * @since 1.0.0
 */
public class Singleton2 {

    /**
     * 线程不安全问题主要是由于 uniqueInstance 被实例化多次，
     * 采取直接实例化 uniqueInstance 的方式就不会产生线程不安全问题。
     */
    private static final Singleton2 uniqueInstance = new Singleton2();

    private Singleton2(){

    }

    public static Singleton2 getUniqueInstance() {
        return uniqueInstance;
    }

}
