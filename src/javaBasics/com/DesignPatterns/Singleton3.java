package src.javaBasics.com.DesignPatterns;

/**
 * 单例模式：Ⅲ 懒汉式-线程安全
 *
 * @author Ernest
 * @version 1.0, 5/3/2021
 * @since 1.0.0
 */
public class Singleton3 {
    private static Singleton3 uniqueInstance;

    private Singleton3() {

    }

    /**
     * 懒汉式要实现线程安全，getUniqueInstance()方法需要加锁
     *
     * @return uniqueInstance
     */
    public static synchronized Singleton3 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
}
