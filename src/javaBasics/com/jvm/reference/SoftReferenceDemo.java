package javaBasics.com.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * 四大引用：软引用
 * java.lang.ref.SoftReference类实现
 * 当内存充足时，软引用对象  不会   被回收
 * 当内存不足时，软引用对象  就会   被回收
 *
 * */
public class SoftReferenceDemo {
    //内存充足，保存
    public static void softRef_Memory_Enough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(softReference.get());
    }
    /**
     * 内存不够，回收--->设置内存参数大小
     * JVM，故意产生大对象并配置小内存，让其出现OOM，来对比软引用回收情况
     * 参数： -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough(){
        Object obj2 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj2);
        System.out.println(obj2);
        System.out.println(softReference.get());

        obj2 = null;
        System.gc();
        try{
            byte[] bytes = new byte[30 *1024 *1024];
        }catch (Throwable e){

        }finally {
            System.out.println(obj2);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args){
        //softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }

}
