package Test.niuke.test;

//单例模式--双重校验---线程安全
public class Singleton {

    //volatile可以禁指令重排
    private volatile static Singleton instance;

    private Singleton(){}


    public synchronized static Singleton getInstance(){
        //先判断对象是否实例过，没有实例化过才进入加锁
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
