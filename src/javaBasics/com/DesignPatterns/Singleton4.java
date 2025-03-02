package src.javaBasics.com.DesignPatterns;

/**
 * 单例模式：Ⅳ 双重校验锁-线程安全
 *
 * @author Ernest
 * @version 1.0, 5/3/2021
 * @since 1.0.0
 */
public class Singleton4 {

    private static Singleton4 uniqueInstance;

    private Singleton4() {

    }
    public static Singleton4 getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton4.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }

}
